package main

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class db {

    private Connection conexao
    private String url = "jdbc:postgresql://localhost:5432/Linketinder"
    private String usuario = "pedro"
    private String senha = "Cap1vara_@2025"

    db() {
        conectar()
    }

    private void conectar() {
        try {
            println("Conectando...")
            conexao = DriverManager.getConnection(url, usuario, senha)
            println("Conexão bem-sucedida!")
            println("-----------------------------------")
        } catch (SQLException e) {
            println("Falha na conexão com o banco de dados: ${e.message}")
        }
    }

    void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close()
                println("Conexão fechada com sucesso!")
                println("-----------------------------------")
            } catch (SQLException e) {
                println("Erro ao fechar a conexão: ${e.message}")
            }
        }
    }

    Connection getConexao() {
        return conexao
    }
}
