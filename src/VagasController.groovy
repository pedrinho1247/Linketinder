import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class VagasController {

    void ListarVagas() {

        db bancoDeDados = new db()
        Connection conexao = bancoDeDados.getConexao()

        String sql = "SELECT * FROM vagas;"
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql)
            ResultSet rs = stmt.executeQuery()

            println("Listagem de Empresas:")
            while (rs.next()) {
                println("ID: ${rs.getString('id')}")
                println("ID da Empresa: ${rs.getString('id_empresa')}")
                println("Nome da Vaga: ${rs.getString('nome')}")
                println("Descrição: ${rs.getString('descricao')}")
                println("Local: ${rs.getString('local')}")
                println("------------------------------------")
            }

        } catch (SQLException e) {
            println("Erro ao listar vagas: ${e.message}")

        } finally {
            bancoDeDados.fecharConexao()
        }
    }

    void AdicionarVaga(Vagas vaga){
        db bancoDeDados = new db()
        Connection conexao = bancoDeDados.getConexao()

        String sql = "INSERT INTO vagas (id_empresa, nome, descricao,local) VALUES (?, ?, ?, ?)"
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql)
            stmt.setInt(1, vaga.getId_empresa())
            stmt.setString(2, vaga.getNome())
            stmt.setString(3, vaga.getDescricao())
            stmt.setString(4, vaga.getLocal())

            stmt.executeUpdate()

            println("Vaga inserida com sucesso!")

        } catch (SQLException e) {
            println("Erro ao inserir empresa: ${e.getMessage()}")
        }
    }

}
