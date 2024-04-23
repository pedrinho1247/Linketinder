package main.model.db

import java.sql.SQLException

class ConnectionFactory {
    static DatabaseConnection createConnection(String dbType, String url, String user, String password) throws SQLException {
        switch (dbType.toLowerCase()) {
            case "postgres":
                return new PostgresConnection(url, user, password)
            case "mysql":
                return new MySqlConnection(url, user, password)
            default:
                throw new IllegalArgumentException("Tipo de banco de dados não suportado: $dbType")
        }
    }
}
