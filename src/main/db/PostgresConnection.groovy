package main.db

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

class PostgresConnection implements DatabaseConnection {
    private Connection connection
    private Statement statement
    private ResultSet resultSet

    PostgresConnection(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password)
        statement = connection.createStatement()
    }

    @Override
    void execute(String sql) throws SQLException {
        println("Executando SQL no PostgreSQL: $sql")
        resultSet = statement.executeQuery(sql)
    }

    ResultSet getResultSet() {
        return resultSet
    }

    Connection getConnection() {
        return connection
    }

}
