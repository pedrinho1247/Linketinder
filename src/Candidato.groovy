import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class Candidato implements Pessoa {

    String nome
    String sobrenome
    String data_nascimento
    String email
    String cpf
    String pais
    String cep
    String descricao
    String senha
    int idade
    String estado

    Candidato(String nome, String sobrenome,String data_nascimento, String email, String cpf, String pais, int idade, String estado, String cep, String descricao,String senha) {
        this.nome = nome
        this.sobrenome = sobrenome
        this.data_nascimento = data_nascimento
        this.email = email
        this.cpf = cpf
        this.pais = pais
        this.idade = idade
        this.estado = estado
        this.cep = cep
        this.descricao = descricao
        this.senha = senha
    }

    Candidato(){}

    void ListarCandidatos() {
        db bancoDeDados = new db()
        Connection conexao = bancoDeDados.getConexao()

        String sql = "SELECT * FROM candidatos"
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql)
            ResultSet rs = stmt.executeQuery()

            println("Listagem de Candidatos:")
            while (rs.next()) {
                println("Nome: ${rs.getString('nome')}")
                println("Sobrenome: ${rs.getString('sobrenome')}")
                println("Data de Nascimento: ${rs.getString('data_nascimento')}")
                println("Email: ${rs.getString('email')}")
                println("CPF: ${rs.getString('cpf')}")
                println("País: ${rs.getString('pais')}")
                println("Idade: ${rs.getInt('idade')}")
                println("Estado: ${rs.getString('estado')}")
                println("CEP: ${rs.getString('cep')}")
                println("Descrição: ${rs.getString('descricao')}")
                println("Senha: ${rs.getString('senha')}")
                println("------------------------------------")
            }

        } catch (SQLException e) {
            println("Erro ao listar candidatos: ${e.message}")

        } finally {
            bancoDeDados.fecharConexao()
        }
    }

    void AdicionarCandidato() {
        db bancoDeDados = new db()
        Connection conexao = bancoDeDados.getConexao()

        String sql = "INSERT INTO candidatos (nome,sobrenome,data_nascimento, email, cpf,pais,idade, estado, cep, descricao,senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql)
            stmt.setString(1, this.getNome())
            stmt.setString(2, this.getSobrenome())
            stmt.setString(3, this.getData_nascimento())
            stmt.setString(4, this.getEmail())
            stmt.setString(5, this.getCpf())
            stmt.setString(6, this.getPais())
            stmt.setInt(7, this.getIdade())
            stmt.setString(8, this.getEstado())
            stmt.setString(9, this.getCep())
            stmt.setString(10, this.getDescricao())
            stmt.setString(11, this.getSenha())

            stmt.executeUpdate()
            println("Candidato inserido com sucesso!")
        } catch (SQLException e) {
            println("Erro ao inserir candidato: ${e.getMessage()}")
        } finally {
            bancoDeDados.fecharConexao()
        }
    }
}
