package main.model

class Candidato{

    String nome
    String sobrenome
    String data_nascimento
    String email
    String cpf
    String pais
    String cep
    String descricao
    String senha
    int idade
    String estado

    Candidato(String nome, String sobrenome,String data_nascimento, String email, String cpf, String pais, int idade, String estado, String cep, String descricao,String senha) {
        this.nome = nome
        this.sobrenome = sobrenome
        this.data_nascimento = data_nascimento
        this.email = email
        this.cpf = cpf
        this.pais = pais
        this.idade = idade
        this.estado = estado
        this.cep = cep
        this.descricao = descricao
        this.senha = senha
    }

}
