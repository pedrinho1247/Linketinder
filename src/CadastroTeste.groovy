import org.junit.Test
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull


class CadastroTeste{

    @Test
    void TesteCadastrarCandidato() {
        // Dados do candidato para teste
        String nome = "Maria"
        String email = "maria@example.com"
        String cpf = "123.456.789-00"
        Integer idade = 30
        String estado = "SP"
        String cep = "12345-678"
        String descricao = "Descrição do candidato 1"

        // Criar um novo candidato
        Candidato candidato = new Candidato(nome, email, cpf, idade, estado, cep, descricao)

        // Verificar se o candidato foi criado com sucesso
        assertNotNull(candidato)
        assertEquals(nome, candidato.nome)
        assertEquals(email, candidato.email)
        assertEquals(cpf, candidato.cpf)
        assertEquals(idade, candidato.idade)
        assertEquals(estado, candidato.estado)
        assertEquals(cep, candidato.cep)
        assertEquals(descricao, candidato.descricao)

    }

}
