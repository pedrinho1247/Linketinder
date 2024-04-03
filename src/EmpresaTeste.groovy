import org.junit.Test
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull

class EmpresaTeste {

    @Test
    void TesteCadastrarEmpresa() {
        // Dados da empresa para teste
        def nomeEmpresa = "Empresa Teste"
        def emailEmpresa = "empresa@teste.com"
        def cnpjEmpresa = "12345678901234"
        def paisEmpresa = "Brasil"
        def estadoEmpresa = "SP"
        def cepEmpresa = "12345-678"
        def descricaoEmpresa = "Descrição da Empresa Teste"

        // Criar uma nova empresa
        def empresa = new Empresa(nomeEmpresa, emailEmpresa, cnpjEmpresa, paisEmpresa, estadoEmpresa, cepEmpresa, descricaoEmpresa)

        // Verificar se a empresa foi criada com sucesso
        assertNotNull(empresa)
        assertEquals(nomeEmpresa, empresa.nome)
        assertEquals(emailEmpresa, empresa.emailCorporativo)
        assertEquals(cnpjEmpresa, empresa.cnpj)
        assertEquals(paisEmpresa, empresa.pais)
        assertEquals(estadoEmpresa, empresa.estado)
        assertEquals(cepEmpresa, empresa.cep)
        assertEquals(descricaoEmpresa, empresa.descricao)
    }
}


