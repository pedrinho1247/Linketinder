package main.view

class OpcaoEscolhida {

    Scanner sc = new Scanner(System.in);

    int InterfaceOpcao()
    {
        println("O que deseja realizar? Escolha uma opção: ")
        println("-----------------------------------------------")
        println("1. Adicionar Candidato")
        println("2. Adicionar uma Empresa")
        println("3. Listar Geral")
        println("4. Listar Candidatos")
        println("5. Listar Empresas")
        println("6. Adicionar vaga")
        println("7. Listar vaga")
        println("8. Sair")
        println("-----------------------------------------------")
        println("OPÇÃO: ")
        int OpcaoEscolhida = sc.nextInt()
        sc.nextLine()
        return OpcaoEscolhida
    }
}
