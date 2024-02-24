class Candidato implements Pessoa {

    String nome
    String email
    String cpf
    int idade
    String estado
    String cep
    String descricao
    List<Map<String, Object>> candidatos = []

    // Método cadastrar, recebe um Map e insere na lista candidatos
    @Override
    void cadastrar(Map<String, Object> dadosCandidato) {
        candidatos << dadosCandidato
    }

    @Override

    def listarGeral() {
        for (def candidato : candidatos) {
            println("-----Candidato------")
            candidato.each { chave, valor ->
                if (chave == "competencias") {
                    println("$chave: ${(valor as List<String>).join(', ')}")
                } else {
                    println("$chave: $valor")
                }
            }
            println("-------------------------------------------------------")
        }
    }
}
