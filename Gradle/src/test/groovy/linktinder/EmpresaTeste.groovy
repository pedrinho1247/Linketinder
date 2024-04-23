import main.model.Empresa
import org.junit.Test
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull

class EmpresaTeste {

    @Test
    void TesteCadastrarEmpresa() {
        // Dados da empresa para teste
        String nomeEmpresa = "main.model.Empresa Teste"
        String emailEmpresa = "empresa@teste.com"
        String cnpjEmpresa = "12345678901234"
        String paisEmpresa = "Brasil"
        String cepEmpresa = "12345-678"
        String descricaoEmpresa = "Descrição da main.model.Empresa Teste"
        String senhaEmpresa = "@meajuda"

        // Criar uma nova empresa
        def empresa = new Empresa(nomeEmpresa, emailEmpresa, cnpjEmpresa, paisEmpresa, cepEmpresa, descricaoEmpresa,senhaEmpresa)

        // Verificar se a empresa foi criada com sucesso
        assertNotNull(empresa)
        assertEquals(nomeEmpresa, empresa.nome)
        assertEquals(emailEmpresa, empresa.emailCorporativo)
        assertEquals(cnpjEmpresa, empresa.cnpj)
        assertEquals(paisEmpresa, empresa.pais)
        assertEquals(cepEmpresa, empresa.cep)
        assertEquals(descricaoEmpresa, empresa.descricao)
        assertEquals(senhaEmpresa, empresa.senha)
    }
}


