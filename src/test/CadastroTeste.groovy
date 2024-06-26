package test

import main.model.Candidato
import org.junit.Assert
import org.junit.Test
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull


class CadastroTeste{

    @Test
    void TesteCadastrarCandidato() {
        // Expected
        String nome = "Maria"
        String sobrenome = "Julio"
        String data_nascimento = "12/05/2004"
        String email = "maria@example.com"
        String cpf = "123.456.789-00"
        String pais = "Brasil"
        Integer idade = 30
        String estado = "SP"
        String cep = "12345-678"
        String descricao = "Descrição do candidato 1"
        String senha = "socorro@deus"

        // main.model.Candidato
        Candidato candidato = new Candidato(nome,sobrenome,data_nascimento, email, cpf,pais, idade, estado, cep, descricao,senha)

        // Assert
        assertNotNull(candidato);
        assertEquals(nome, candidato.getNome());
        assertEquals(sobrenome, candidato.getSobrenome());
        assertEquals(data_nascimento, candidato.getData_nascimento());
        assertEquals(email, candidato.getEmail());
        assertEquals(cpf, candidato.getCpf());
        assertEquals(pais, candidato.getPais());
        Assert.assertEquals(idade, candidato.getIdade());
        assertEquals(estado, candidato.getEstado());
        assertEquals(cep, candidato.getCep());
        assertEquals(descricao, candidato.getDescricao());
        assertEquals(senha, candidato.getSenha());

    }

}
