class LinkTinderMain {

    def sc = new Scanner(System.in)

    List<Candidato> candidatos = []
    List<Empresa> empresas = []

    LinkTinderMain() {

        // Pré-cadastrando 5 candidatos

        candidatos << new Candidato("Maria", "maria@example.com", "123.456.789-00", 30, "SP", "12345-678", "Descrição do candidato 1")
        candidatos << new Candidato("Pedro", "pedro@example.com", "987.654.321-00", 25, "RJ", "54321-987", "Descrição do candidato 2")
        candidatos << new Candidato("Isabelle", "isabelle@example.com", "456.789.123-00", 35, "MG", "98765-432", "Descrição do candidato 3")
        candidatos << new Candidato("Lucas", "lucas@example.com", "321.654.987-00", 28, "BA", "87654-321", "Descrição do candidato 4")
        candidatos << new Candidato("Julia", "julia@example.com", "789.123.456-00", 22, "PR", "76543-210", "Descrição do candidato 5")

        // Pré-cadastrando 5 empresas

        empresas << new Empresa("Empresa 1","empresa1@teste.com","12345678901234","Brasil","SP","12345-678","Descrição da Empresa 1")
        empresas << new Empresa("Empresa 2","empresa2@teste.com","98765432109876","Brasil","RJ","54321-987","Descrição da Empresa 2")
        empresas << new Empresa("Empresa 3","empresa3@teste.com","45678912345678","Brasil","MG","98765-432","Descrição da Empresa 3")
        empresas << new Empresa("Empresa 4","empresa4@teste.com","32165498765432","Brasil","BA","87654-321","Descrição da Empresa 4")
        empresas << new Empresa("Empresa 5","empresa5@teste.com","78912345678901","Brasil","PR","76543-210","Descrição da Empresa 5")

        // Inicializando o programa

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
                                descricao: ""
                        ]
                        dados1.each { chave, valor ->
                            println("$chave:")
                            dados1[chave] = sc.nextLine()
                        }
                        candidatos << new Candidato(
                                dados1.nome,
                                dados1.email,
                                dados1.cpf,
                                dados1.idade.toInteger(),
                                dados1.estado,
                                dados1.cep,
                                dados1.descricao
                        )
                        break

                    case 2:

                        def dadosEmpresa = [
                                nome: "",
                                emailCorporativo: "",
                                cnpj: "",
                                pais: "",
                                estado: "",
                                cep: "",
                                descricao: ""
                        ]
                        dadosEmpresa.each { chave, valor ->
                            println("$chave:")
                            dadosEmpresa[chave] = sc.nextLine()
                        }
                        empresas << new Empresa(
                                dadosEmpresa.nome,
                                dadosEmpresa.emailCorporativo,
                                dadosEmpresa.cnpj,
                                dadosEmpresa.pais,
                                dadosEmpresa.estado,
                                dadosEmpresa.cep,
                                dadosEmpresa.descricao
                        )
                        break

                    case 3:
                        println("Listando Geral:")
                        println("Candidatos:")
                        candidatos.each { candidato ->
                            println("Nome: ${candidato.nome}")
                            println("Email: ${candidato.email}")
                            println("CPF: ${candidato.cpf}")
                            println("Idade: ${candidato.idade}")
                            println("Estado: ${candidato.estado}")
                            println("CEP: ${candidato.cep}")
                            println("Descrição: ${candidato.descricao}")
                            println("--------------------")
                        }
                        println("Empresas:")
                        empresas.each { empresa ->
                            println("Nome: ${empresa.nome}")
                            println("Email Corporativo: ${empresa.emailCorporativo}")
                            println("CNPJ: ${empresa.cnpj}")
                            println("País: ${empresa.pais}")
                            println("Estado: ${empresa.estado}")
                            println("CEP: ${empresa.cep}")
                            println("Descrição: ${empresa.descricao}")
                            println("--------------------")
                        }
                        break

                    case 4:
                        println("Listando Candidatos:")
                        candidatos.each { candidato ->
                            println("Nome: ${candidato.nome}")
                            println("Email: ${candidato.email}")
                            println("CPF: ${candidato.cpf}")
                            println("Idade: ${candidato.idade}")
                            println("Estado: ${candidato.estado}")
                            println("CEP: ${candidato.cep}")
                            println("Descrição: ${candidato.descricao}")
                            println("-----------------------------")
                        }
                        break

                    case 5:
                        println("Listando Empresas:")
                        empresas.each { empresa ->
                            println("Nome: ${empresa.nome}")
                            println("Email Corporativo: ${empresa.emailCorporativo}")
                            println("CNPJ: ${empresa.cnpj}")
                            println("País: ${empresa.pais}")
                            println("Estado: ${empresa.estado}")
                            println("CEP: ${empresa.cep}")
                            println("Descrição: ${empresa.descricao}")
                            println("-----------------------------")
                        }
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

