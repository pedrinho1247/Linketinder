import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class Empresa implements Pessoa {

    String nome
    String emailCorporativo
    String cnpj
    String pais
    String cep
    String descricao
    String senha

    Empresa(String nome, String emailCorporativo, String cnpj, String pais, String cep, String descricao,  String senha) {
        this.nome = nome
        this.emailCorporativo = emailCorporativo
        this.cnpj = cnpj
        this.pais = pais
        this.cep = cep
        this.descricao = descricao
        this.senha = senha
    }

    Empresa(){}

    void ListarEmpresa() {

        db bancoDeDados = new db()
        Connection conexao = bancoDeDados.getConexao()

        String sql = "SELECT * FROM empresas;"
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql)
            ResultSet rs = stmt.executeQuery()

            println("Listagem de Empresas:")
            while (rs.next()) {
                println("ID: ${rs.getString('id')}")
                println("Nome: ${rs.getString('nome')}")
                println("Email Corporativo: ${rs.getString('email')}")
                println("CNPJ: ${rs.getString('cnpj')}")
                println("País: ${rs.getString('pais')}")
                println("CEP: ${rs.getString('cep')}")
                println("Descrição: ${rs.getString('descricao')}")
                println("------------------------------------")
            }

        } catch (SQLException e) {
            println("Erro ao listar candidatos: ${e.message}")

        } finally {
            bancoDeDados.fecharConexao()
        }
    }

    void AdicionarEmpresa() {
        db bancoDeDados = new db()
        Connection conexao = bancoDeDados.getConexao()

        String sql = "INSERT INTO empresas (nome, email, cnpj,cep, descricao,senha) VALUES (?, ?, ?, ?, ?, ?)"
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql)
            stmt.setString(1, this.getNome())
            stmt.setString(2, this.getEmailCorporativo())
            stmt.setString(3, this.getCnpj())
            stmt.setString(4, this.getCep())
            stmt.setString(5, this.getDescricao())
            stmt.setString(6, this.getSenha())

            stmt.executeUpdate()

            println("Empresa inserida com sucesso!")
        } catch (SQLException e) {
            println("Erro ao inserir empresa: ${e.getMessage()}")
        } finally {
        bancoDeDados.fecharConexao()
        }
    }

}