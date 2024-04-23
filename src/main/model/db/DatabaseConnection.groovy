package main.model.db

import java.sql.SQLException

interface DatabaseConnection {
    void execute(String sql) throws SQLException
}