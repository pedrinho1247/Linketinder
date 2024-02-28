import org.junit.Test

class CadastroTeste extends Candidato{

    @Test
     void TesteCadastrar(){
        def dadosCandidatos = [nome: "TesteCadastro", email: "teste@example.com", cpf: "123.456.789-00", idade: 66, estado: "SP", cep: "12345-678", descricao: "Descrição do candidato 1", competencias:["Python", "Java", "Angular"]]

        def TesteCadastroCanidato = new Candidato()

        TesteCadastroCanidato.cadastrar(dadosCandidatos)

        def cadastros = TesteCadastroCanidato.getCandidatos()
        cadastros.contains(dadosCandidatos)
    }

}
