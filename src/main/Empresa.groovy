package main

class Empresa{

    String nome
    String emailCorporativo
    String cnpj
    String pais
    String cep
    String descricao
    String senha

    Empresa(String nome, String emailCorporativo, String cnpj, String pais, String cep, String descricao,  String senha) {
        this.nome = nome
        this.emailCorporativo = emailCorporativo
        this.cnpj = cnpj
        this.pais = pais
        this.cep = cep
        this.descricao = descricao
        this.senha = senha
    }

}