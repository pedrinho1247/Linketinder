import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.SQLException

class Vagas {
    int id_empresa
    String nome
    String descricao
    String local

    Vagas(int id_empresa,String nome, String descricao, String local){
        this.id_empresa = id_empresa
        this.nome = nome
        this.descricao = descricao
        this.local = local
    }

    void AdicionarVaga(){
        db bancoDeDados = new db()
        Connection conexao = bancoDeDados.getConexao()

        String sql = "INSERT INTO vagas (id_empresa, nome, descricao,local) VALUES (?, ?, ?, ?)"
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql)
            stmt.setInt(1, this.getId_empresa())
            stmt.setString(2, this.getNome())
            stmt.setString(3, this.getDescricao())
            stmt.setString(4, this.getLocal())

            stmt.executeUpdate()

            println("Vaga inserida com sucesso!")

        } catch (SQLException e) {
            println("Erro ao inserir empresa: ${e.getMessage()}")
        }
    }

}
