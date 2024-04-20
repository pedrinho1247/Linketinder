package main.db

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class PostgresConnection implements DatabaseConnection{
    private Connection connection

    PostgresConnection(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password)
    }

    @Override
    void execute(String sql) throws SQLException {
        println("Executando SQL no PostgreSQL: $sql")
    }
}
