package main.db

import java.sql.SQLException

class DbUser {
    private DatabaseConnection connection

    DbUser(DatabaseConnection connection) {
        this.connection = connection
    }

    void executeQuery(String query) {
        try {
            connection.execute(query)
        } catch (SQLException e) {
            println("Erro ao executar a consulta: $e.message")
        }
    }
}
