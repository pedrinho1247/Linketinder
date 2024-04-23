import main.model.Candidato
import main.model.Empresa
import main.model.Vagas

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.SQLException

class db {

    private Connection conexao
    private String url = "jdbc:postgresql://localhost:5432/Linketinder"
    private String usuario = "pedro"
    private String senha = "Cap1vara_@2025"

    db() {
        conectar()
    }

    private void conectar() {
        try {
            println("Conectando...")
            conexao = DriverManager.getConnection(url, usuario, senha)
            println("Conexão bem-sucedida!")
        } catch (SQLException e) {
            println("Falha na conexão com o banco de dados: ${e.getMessage()}")
        }
    }

    void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close()
                println("Conexão fechada com sucesso!")
            } catch (SQLException e) {
                println("Erro ao fechar a conexão: ${e.getMessage()}")
            }
        }
    }

    void inserirCandidato(Candidato candidato) {
        String sql = "INSERT INTO candidatos (nome,sobrenome,data_nascimento, email, cpf,pais,idade, estado, cep, descricao,senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql)
            stmt.setString(1, candidato.getNome())
            stmt.setString(2, candidato.getSobrenome())
            stmt.setString(3, candidato.getData_nascimento())
            stmt.setString(4, candidato.getEmail())
            stmt.setString(5, candidato.getCpf())
            stmt.setString(6, candidato.getPais())
            stmt.setInt(7, candidato.getIdade())
            stmt.setString(8, candidato.getEstado())
            stmt.setString(9, candidato.getCep())
            stmt.setString(10, candidato.getDescricao())
            stmt.setString(11, candidato.getSenha())

            stmt.executeUpdate()
            println("main.model.Candidato inserido com sucesso!")
        } catch (SQLException e) {
            println("Erro ao inserir candidato: ${e.getMessage()}")
        }
    }

    void inserirEmpresa(Empresa empresa) {
        String sql = "INSERT INTO empresas (nome, email, cnpj,cep, descricao,senha) VALUES (?, ?, ?, ?, ?, ?)"
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql)
            stmt.setString(1, empresa.getNome())
            stmt.setString(2, empresa.getEmailCorporativo())
            stmt.setString(3, empresa.getCnpj())
            stmt.setString(4, empresa.getCep())
            stmt.setString(5, empresa.getDescricao())
            stmt.setString(6, empresa.getSenha())
            stmt.executeUpdate()

            println("main.model.Empresa inserida com sucesso!")
        } catch (SQLException e) {
            println("Erro ao inserir empresa: ${e.getMessage()}")
        }
    }

    void inserirVaga(Vagas vagas){
        String sql = "INSERT INTO vagas (id_empresa, nome, descricao,local) VALUES (?, ?, ?, ?)"
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql)
            stmt.setInt(1, vagas.getId_empresa())
            stmt.setString(2, vagas.getNome())
            stmt.setString(3, vagas.getDescricao())
            stmt.setString(4, vagas.getLocal())
            stmt.executeUpdate()

            println("Vaga inserida com sucesso!")
        } catch (SQLException e) {
            println("Erro ao inserir empresa: ${e.getMessage()}")
        }
    }
}


