import org.junit.Test

class EmpresaTeste extends Empresa {

    @Test
     void TesteCadastrar(){
        def dadosEmpresa = [nome: "EmpresaTeste", emailCorporativo: "empresateste@example.com", cnpj: "123456789", pais: "Brasil", estado: "SP", cep: "12345-666", descricao: "Descrição da Empresa 1", "competencias desejadas":["Python", "Java", "Angular"]]

        def TesteCadastroEmpresa = new Empresa()

        TesteCadastroEmpresa.cadastrar(dadosEmpresa)

        def empresas = TesteCadastroEmpresa.getEmpresas()
        empresas.contains(dadosEmpresa)
    }

}

