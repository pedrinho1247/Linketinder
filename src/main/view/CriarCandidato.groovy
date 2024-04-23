package main.view


import main.model.Candidato

class CriarCandidato implements Instancias {

    @Override
      criarInstancia() {
        Scanner sc = new Scanner(System.in)

        println("Insira o nome do candidato:")
        String nomeCandidato = sc.nextLine()

        println("Insira o sobrenome do candidato:")
        String sobrenomeCandidato = sc.nextLine()

        println("Insira a data de nascimento do candidato:")
        String dataNascimentoCandidato = sc.nextLine()

        println("Insira o email do candidato:")
        String emailCandidato = sc.nextLine()

        println("Insira o CPF do candidato:")
        String cpfCandidato = sc.nextLine()

        println("Insira o país do candidato:")
        String paisCandidato = sc.nextLine()

        println("Insira a idade do candidato:")
        def idadeCandidato = sc.nextLine().toInteger()

        println("Insira o estado do candidato:")
        String estadoCandidato = sc.nextLine()

        println("Insira o CEP do candidato:")
        String cepCandidato = sc.nextLine()

        println("Insira a descrição do candidato:")
        String descricaoCandidato = sc.nextLine()

        println("Insira a senha do candidato:")
        String senhaCandidato = sc.nextLine()

        Candidato NovoCandidato = new Candidato(
                nomeCandidato,
                sobrenomeCandidato,
                dataNascimentoCandidato,
                emailCandidato,
                cpfCandidato,
                paisCandidato,
                idadeCandidato,
                estadoCandidato,
                cepCandidato,
                descricaoCandidato,
                senhaCandidato
        )
        return NovoCandidato;
    }
}