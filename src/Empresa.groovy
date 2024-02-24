class Empresa implements Pessoa{

    String nome
    String emailCorporativo
    String cnpj
    String pais
    String estado
    String cep
    String descricao
    List<Map<String, Object>> empresas = []

    //Método cadastrar, recebe um Map e insere na lista empresas
    @Override
    void cadastrar(Map<String, Object> dadosCandidato) {
        empresas << dadosCandidato
    }

    @Override
    def listarGeral() {
        for (def empresa : empresas) {
            println("-----Empresa------")
            empresa.each { chave, valor ->
                println("$chave: $valor")
            }
            println("-------------------------------------------------------")
        }
    }

}
