package main.DAO

import main.model.Candidato
import main.model.db.ConnectionFactory
import main.model.db.DatabaseConnection
import main.model.db.DbUser
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class CandidatoDAO {

    protected String url = "jdbc:postgresql://localhost:5432/Linketinder"
    protected String user = "pedro"
    protected String password = "Cap1vara_@2025"

    void ListarCandidatos() {

        String sql = "SELECT * FROM candidatos"

        try {
            DatabaseConnection postgresConnection = ConnectionFactory.createConnection("postgres", url, user, password)
            DbUser dbuser = new DbUser(postgresConnection)

            dbuser.executeQuery(sql)
            ResultSet rs = dbuser.getResultSet()

            println("Listagem de Candidatos:")

            while (rs.next()) {
                println("ID: ${rs.getString('id')}")
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

        }
    }

    void AdicionarCandidato(Candidato novoCandidato) {

        String sql = "INSERT INTO candidatos (nome, sobrenome, data_nascimento, email, cpf, pais, idade, estado, cep, descricao, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"

        try {
            DatabaseConnection postgresConnection = ConnectionFactory.createConnection("postgres", url, user, password)
            PreparedStatement stmt = postgresConnection.getConnection().prepareStatement(sql)

            stmt.setString(1, novoCandidato.getNome())
            stmt.setString(2, novoCandidato.getSobrenome())
            stmt.setString(3, novoCandidato.getData_nascimento())
            stmt.setString(4, novoCandidato.getEmail())
            stmt.setString(5, novoCandidato.getCpf())
            stmt.setString(6, novoCandidato.getPais())
            stmt.setInt(7, novoCandidato.getIdade())
            stmt.setString(8, novoCandidato.getEstado())
            stmt.setString(9, novoCandidato.getCep())
            stmt.setString(10, novoCandidato.getDescricao())
            stmt.setString(11, novoCandidato.getSenha())

            stmt.executeUpdate()
            println("Candidato inserido com sucesso!")
        } catch (SQLException e) {
            println("Erro ao inserir candidato: ${e.getMessage()}")
        }
    }

}