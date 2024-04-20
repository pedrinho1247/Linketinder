package main.instancias

import main.Vagas

import static java.sql.DriverManager.println

class CriarVaga implements Instancias {
    @Override
     criarInstancia() {
        Scanner sc = new Scanner(System.in)

        println("Insira o id da empresa:")
        def idVaga = sc.nextLine().toInteger()

        println("Insira o nome da vaga:")
        String nomeVaga = sc.nextLine()

        println("Insira a descrição da vaga:")
        String descricaoVaga = sc.nextLine()

        println("Insira o local da vaga:")
        String localVaga = sc.nextLine()

        Vagas NovaVaga = new Vagas(
                idVaga,
                nomeVaga,
                descricaoVaga,
                localVaga
        )

        return NovaVaga
    }
}
