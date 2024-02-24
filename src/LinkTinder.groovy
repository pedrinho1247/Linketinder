class LinkTinderMain {

    def sc = new Scanner(System.in)
    def candidato = new Candidato()
    def empresa = new Empresa()

    LinkTinderMain() {

        // Pré-cadastrando 5 candidatos

        def dadosCandidatos = [
                [nome: "Maria", email: "maria@example.com", cpf: "123.456.789-00", idade: 30, estado: "SP", cep: "12345-678", descricao: "Descrição do candidato 1", competencias:["Python", "Java", "Angular"]],
                [nome: "Pedro", email: "pedro@example.com", cpf: "987.654.321-00", idade: 25, estado: "RJ", cep: "54321-987", descricao: "Descrição do candidato 2", competencias:["Java", "Angular"]],
                [nome: "Isabelle", email: "isabelle@example.com", cpf: "456.789.123-00", idade: 35, estado: "MG", cep: "98765-432", descricao: "Descrição do candidato 3", competencias:["Python", "Java", "Angular"]],
                [nome: "João", email: "joao@example.com", cpf: "789.123.456-00", idade: 28, estado: "BA", cep: "87654-321", descricao: "Descrição do candidato 4", competencias:[ "Angular"]],
                [nome: "Camilla", email: "camilla@example.com", cpf: "321.654.987-00", idade: 33, estado: "PR", cep: "76543-210", descricao: "Descrição do candidato 5", competencias:["Python",]]
        ]

        dadosCandidatos.each { dados ->
            candidato.cadastrar(dados)
        }

        // Pré-cadastrando 5 empresas

        def empresas = [
                [nome: "Empresa 1", emailCorporativo: "empresa1@example.com", cnpj: "123456789", pais: "Brasil", estado: "SP", cep: "12345-678", descricao: "Descrição da Empresa 1", "competencias desejadas":["Python", "Java", "Angular"]],
                [nome: "Empresa 2", emailCorporativo: "empresa2@example.com", cnpj: "987654321", pais: "Brasil", estado: "RJ", cep: "98765-432", descricao: "Descrição da Empresa 2", "competencias desejadas":["Python"]],
                [nome: "Empresa 3", emailCorporativo: "empresa3@example.com", cnpj: "456789123", pais: "Brasil", estado: "MG", cep: "54321-987", descricao: "Descrição da Empresa 3", "competencias desejadas":["Java", "Angular"]],
                [nome: "Empresa 4", emailCorporativo: "empresa4@example.com", cnpj: "789123456", pais: "Brasil", estado: "BA", cep: "87654-321", descricao: "Descrição da Empresa 4", "competencias desejadas":["Java"]],
                [nome: "Empresa 5", emailCorporativo: "empresa5@example.com", cnpj: "321654987", pais: "Brasil", estado: "PR", cep: "76543-210", descricao: "Descrição da Empresa 5", "competencias desejadas":["Python","Angular"]]
        ]

        empresas.each { dados ->
            empresa.cadastrar(dados)
        }

        try {
            while (true) {
                println("O que deseja realizar? Escolha uma opção: ")
                println("-----------------------------------------------")
                println("1. Adicionar um Candidato")
                println("2. Adicionar uma Empresa")
                println("3. Listar Geral")
                println("4. Listar Candidatos")
                println("5. Listar Empresas")
                println("6. Sair")
                println("-----------------------------------------------")
                print("OPÇÃO: ")
                def opcao = sc.nextInt()
                sc.nextLine()

                switch (opcao) {
                    case 1:

                        def dados1 = [
                                nome: "",
                                email: "",
                                cpf: "",
                                idade: "",
                                estado: "",
                                cep: "",
                                descricao: "",
                                competencias: []
                        ]

                        dados1.each { chave, valor ->
                            if (chave == "competencias") {
                                println("$chave:")
                                dados1[chave] = sc.nextLine().split(", ") // Entrada separada por vírgula
                            } else {
                                println("$chave:")
                                dados1[chave] = sc.nextLine()
                            }
                        }
                        
                        candidato.cadastrar(dados1)
                        break

                    case 2:

                        def dados2 = [
                                nome: "",
                                emailCorporativo: "",
                                cnpj: "",
                                pais: "",
                                estado: "",
                                cep: "",
                                descricao: "",
                                "competencias desejadas": []
                        ]

                        dados2.each { chave, valor ->
                            if (chave == "competencias desejadas") {
                                println("$chave:")
                                dados2[chave] = sc.nextLine().split(", ") // Entrada separada por vírgula
                            } else {
                                println("$chave:")
                                dados2[chave] = sc.nextLine()
                            }
                        }

                        empresa.cadastrar(dados2)
                        break

                    case 3:
                        candidato.listarGeral()
                        empresa.listarGeral()
                        break

                    case 4:
                        candidato.listarGeral()
                        break

                    case 5:
                        empresa.listarGeral()
                        break

                    case 6:
                        println("Saindo do programa...")
                        System.exit(0)
                        break

                    default:
                        println("Opção inválida! Por favor, escolha uma opção válida.")
                }
            }
        } catch (InputMismatchException e) {
            println("Valor inserido inválido! Por favor, insira um número correspondente à opção desejada.")
            sc.nextLine()
        }
    }
}

new LinkTinderMain()

