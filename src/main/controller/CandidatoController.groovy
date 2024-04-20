package main.controller

import main.Candidato
import main.db
import main.instancias.Instancias

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class CandidatoController {

    void ListarCandidatos() {
        db bancoDeDados = new db()
        Connection conexao = bancoDeDados.getConexao()

        String sql = "SELECT * FROM candidatos"
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql)
            ResultSet rs = stmt.executeQuery()

            println("Listagem de Candidatos:")
            while (rs.next()) {
                println("ID: ${rs.getString('id')}")
                println("Nome: ${rs.getString('nome')}")
                println("Sobrenome: ${rs.getString('sobrenome')}")
                println("Data de Nascimento: ${rs.getString('data_nascimento')}")
                println("Email: ${rs.getString('email')}")
                println("CPF: ${rs.getString('cpf')}")
                println("País: ${rs.getString('pais')}")
                println("Idade: ${rs.getInt('idade')}")
                println("Estado: ${rs.getString('estado')}")
                println("CEP: ${rs.getString('cep')}")
                println("Descrição: ${rs.getString('descricao')}")
                println("Senha: ${rs.getString('senha')}")
                println("------------------------------------")
            }

        } catch (SQLException e) {
            println("Erro ao listar candidatos: ${e.message}")

        } finally {
            bancoDeDados.fecharConexao()
        }
    }

    void AdicionarCandidato(Candidato novoCandidato) {


        db bancoDeDados = new db()
        Connection conexao = bancoDeDados.getConexao()

        String sql = "INSERT INTO candidatos (nome, sobrenome, data_nascimento, email, cpf, pais, idade, estado, cep, descricao, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql)
            stmt.setString(1, novoCandidato.getNome())
            stmt.setString(2, novoCandidato.getSobrenome())
            stmt.setString(3, novoCandidato.getData_nascimento())
            stmt.setString(4, novoCandidato.getEmail())
            stmt.setString(5, novoCandidato.getCpf())
            stmt.setString(6, novoCandidato.getPais())
            stmt.setInt(7, novoCandidato.getIdade())
            stmt.setString(8, novoCandidato.getEstado())
            stmt.setString(9, novoCandidato.getCep())
            stmt.setString(10, novoCandidato.getDescricao())
            stmt.setString(11, novoCandidato.getSenha())

            stmt.executeUpdate()
            println("Candidato inserido com sucesso!")
        } catch (SQLException e) {
            println("Erro ao inserir candidato: ${e.getMessage()}")
        } finally {
            bancoDeDados.fecharConexao()
        }
    }
}
