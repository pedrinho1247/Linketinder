package main.model.db

import java.sql.Connection
import java.sql.SQLException
import java.sql.DriverManager

class MySqlConnection implements DatabaseConnection{
    private Connection connection

    MySqlConnection(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password)
    }

    @Override
    void execute(String sql) throws SQLException {
        println("Executando SQL no MySQL: $sql")
        //Implemnta a lógica do MYSQL...
        //Building...
    }
}
