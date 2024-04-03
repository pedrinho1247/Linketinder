class Empresa implements Pessoa {

    String nome
    String emailCorporativo
    String cnpj
    String pais
    String estado
    String cep
    String descricao

    Empresa(String nome, String emailCorporativo, String cnpj, String pais, String estado, String cep, String descricao) {
        this.nome = nome
        this.emailCorporativo = emailCorporativo
        this.cnpj = cnpj
        this.pais = pais
        this.estado = estado
        this.cep = cep
        this.descricao = descricao
    }
}