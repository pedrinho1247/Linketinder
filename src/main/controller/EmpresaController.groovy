package main.controller

import main.Empresa
import main.db.db

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class EmpresaController {

    void ListarEmpresa() {

        db bancoDeDados = new db()
        Connection conexao = bancoDeDados.getConexao()

        String sql = "SELECT * FROM empresas;"
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql)
            ResultSet rs = stmt.executeQuery()

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
            bancoDeDados.fecharConexao()
        }
    }

    void AdicionarEmpresa(Empresa empresa) {
        db bancoDeDados = new db()
        Connection conexao = bancoDeDados.getConexao()

        String sql = "INSERT INTO empresas (nome, email, cnpj,cep, descricao,senha) VALUES (?, ?, ?, ?, ?, ?)"
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql)
            stmt.setString(1, empresa.getNome())
            stmt.setString(2, empresa.getEmailCorporativo())
            stmt.setString(3, empresa.getCnpj())
            stmt.setString(4, empresa.getCep())
            stmt.setString(5, empresa.getDescricao())
            stmt.setString(6, empresa.getSenha())

            stmt.executeUpdate()

            println("main.Empresa inserida com sucesso!")
        } catch (SQLException e) {
            println("Erro ao inserir empresa: ${e.getMessage()}")
        } finally {
            bancoDeDados.fecharConexao()
        }
    }

}
