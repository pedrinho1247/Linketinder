package main.db

import java.sql.SQLException

interface DatabaseConnection {
    void execute(String sql) throws SQLException
}