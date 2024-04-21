package main.controller

import main.Vagas
import main.db.ConnectionFactory
import main.db.DatabaseConnection
import main.db.DbUser

import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class VagasController {
    protected String url = "jdbc:postgresql://localhost:5432/Linketinder"
    protected String user = "pedro"
    protected String password = "Cap1vara_@2025"

    void ListarVagas() {

        String sql = "SELECT * FROM vagas"

        try {
            DatabaseConnection postgresConnection = ConnectionFactory.createConnection("postgres", url, user, password)
            DbUser dbuser = new DbUser(postgresConnection)

            dbuser.executeQuery(sql)
            ResultSet rs = dbuser.getResultSet()

            println("Listagem de Vagas:")

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

        }
    }

    void AdicionarVaga(Vagas vaga) {
        String url = "jdbc:postgresql://localhost:5432/Linketinder"
        String user = "pedro"
        String password = "Cap1vara_@2025"

        String sql = "INSERT INTO vagas (id_empresa, nome, descricao, local) VALUES (?, ?, ?, ?)"

        try {
            DatabaseConnection postgresConnection = ConnectionFactory.createConnection("postgres", url, user, password)
            PreparedStatement stmt = postgresConnection.getConnection().prepareStatement(sql)

            stmt.setInt(1, vaga.getId_empresa())
            stmt.setString(2, vaga.getNome())
            stmt.setString(3, vaga.getDescricao())
            stmt.setString(4, vaga.getLocal())

            stmt.executeUpdate()
            println("Vaga inserida com sucesso!")
        } catch (SQLException e) {
            println("Erro ao inserir vaga: ${e.getMessage()}")
        }
    }
}
