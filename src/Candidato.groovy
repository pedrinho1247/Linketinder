class Candidato implements Pessoa {

    String nome
    String email
    String cpf
    int idade
    String estado
    String cep
    String descricao

    Candidato(String nome, String email, String cpf, int idade, String estado, String cep, String descricao) {
        this.nome = nome
        this.email = email
        this.cpf = cpf
        this.idade = idade
        this.estado = estado
        this.cep = cep
        this.descricao = descricao
    }

}
