package main.db

import java.sql.ResultSet
import java.sql.SQLException

class DbUser {
    private DatabaseConnection connection

    DbUser(DatabaseConnection connection) {
        this.connection = connection
    }

    ResultSet executeQuery(String query) {
        try {
            return connection.execute(query)
        } catch (SQLException e) {
            println("Erro ao executar a consulta: ${e.message}")
            return null
        }
    }

    ResultSet getResultSet() {
        return connection.getResultSet()
    }
}
