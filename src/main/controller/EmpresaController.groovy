package main.controller

import main.Empresa
import main.db.ConnectionFactory
import main.db.DatabaseConnection
import main.db.DbUser
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class EmpresaController {

    protected String url = "jdbc:postgresql://localhost:5432/Linketinder"
    protected String user = "pedro"
    protected String password = "Cap1vara_@2025"

    void ListarEmpresas() {

        String sql = "SELECT * FROM empresas"

        try {
            DatabaseConnection postgresConnection = ConnectionFactory.createConnection("postgres", url, user, password)
            DbUser dbuser = new DbUser(postgresConnection)

            dbuser.executeQuery(sql)
            ResultSet rs = dbuser.getResultSet()

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
            println("Erro ao listar empresas: ${e.message}")
        } finally {

        }
    }

    void AdicionarEmpresa(Empresa empresa) {

        String sql = "INSERT INTO empresas (nome, email, cnpj, pais, cep, descricao, senha) VALUES (?, ?, ?, ?, ?, ?, ?)"

        try {
            DatabaseConnection postgresConnection = ConnectionFactory.createConnection("postgres", url, user, password)
            PreparedStatement stmt = postgresConnection.getConnection().prepareStatement(sql)

            stmt.setString(1, empresa.getNome())
            stmt.setString(2, empresa.getEmailCorporativo())
            stmt.setString(3, empresa.getCnpj())
            stmt.setString(4, empresa.getPais())
            stmt.setString(5, empresa.getCep())
            stmt.setString(6, empresa.getDescricao())
            stmt.setString(7, empresa.getSenha())

            stmt.executeUpdate()
            println("Empresa inserida com sucesso!")
        } catch (SQLException e) {
            println("Erro ao inserir empresa: ${e.getMessage()}")
        }
    }
}
