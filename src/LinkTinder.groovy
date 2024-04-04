class LinkTinderMain {

    def sc = new Scanner(System.in)

    List<Candidato> candidatos = []
    List<Empresa> empresas = []
    List<Vagas> vagas = []

    def bancoDeDados = new db()

    LinkTinderMain() {

        // Pré-cadastrando 5 candidatos, já inseridos no banco de dados Postgresql

        candidatos << new Candidato("Maria","Julio", "12/05/2005" , "maria@example.com", "123.456.789-00", "Brasil", 30, "SP", "12345-678", "Descrição do candidato 1","12@12")
//        bancoDeDados.inserirCandidato(candidatos[0])
        candidatos << new Candidato("Joao", "Silva", "13/03/2005", "joao@example.com", "987.654.321-00", "Brasil", 25, "RJ", "54321-876", "Descrição do candidato 2", "23@45")
//        bancoDeDados.inserirCandidato(candidatos[1])
        candidatos << new Candidato("Ana", "Santos", "14/04/2005", "ana@example.com", "111.222.333-44", "Brasil", 28, "MG", "98765-432", "Descrição do candidato 3", "ab@cd")
//        bancoDeDados.inserirCandidato(candidatos[2])
        candidatos << new Candidato("Pedro", "Souza", "15/05/2005", "pedro@example.com", "444.555.666-77", "Brasil", 22, "RS", "13579-246", "Descrição do candidato 4", "56@78")
//        bancoDeDados.inserirCandidato(candidatos[3])
        candidatos << new Candidato("Carla", "Ferreira","16/06/2005" , "carla@example.com", "888.999.000-11", "Brasil", 33, "BA", "24680-135", "Descrição do candidato 5", "cd@ef")
//        bancoDeDados.inserirCandidato(candidatos[4])

        // Pré-cadastrando 5 empresas, já inseridos no banco de dados postgresql

        empresas << new Empresa("Empresa 1","empresa1@teste.com","12345678901234","SP","12345-678","Descrição da Empresa 1", "666_pedro")
//        bancoDeDados.inserirEmpresa(empresas[0])
        empresas << new Empresa("Empresa 2","empresa2@teste.com","98765432109876","RJ","54321-987","Descrição da Empresa 2","000-maria")
//        bancoDeDados.inserirEmpresa(empresas[1])
        empresas << new Empresa("Empresa 3","empresa3@teste.com","45678912345678","MG","98765-432","Descrição da Empresa 3","teste_123")
//        bancoDeDados.inserirEmpresa(empresas[2])
        empresas << new Empresa("Empresa 4","empresa4@teste.com","32165498765432","BA","87654-321","Descrição da Empresa 4","naoseinada")
//        bancoDeDados.inserirEmpresa(empresas[3])
        empresas << new Empresa("Empresa 5","empresa5@teste.com","78912345678901","PR","76543-210","Descrição da Empresa 5","socorro123")
//        bancoDeDados.inserirEmpresa(empresas[4])

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
                println("6. Adicionar vaga")
                println("7. Sair")
                println("-----------------------------------------------")
                print("OPÇÃO: ")
                def opcao = sc.nextInt()
                sc.nextLine()

                switch (opcao) {

                    case 1:
                        def dados1 = [
                                nome: "",
                                sobrenome:"",
                                data_nascimento:"",
                                email: "",
                                cpf: "",
                                pais:"",
                                idade: "",
                                estado: "",
                                cep: "",
                                descricao: "",
                                senha:""
                        ]

                        dados1.each { chave, valor ->
                            println("$chave:")
                            dados1[chave] = sc.nextLine()
                        }

                        candidatos << new Candidato(
                                dados1.nome,
                                dados1.sobrenome,
                                dados1.data_nascimento,
                                dados1.email,
                                dados1.cpf,
                                dados1.pais,
                                dados1.idade.toInteger(),
                                dados1.estado,
                                dados1.cep,
                                dados1.descricao,
                                dados1.senha
                        )
                        bancoDeDados.inserirCandidato(candidatos[candidatos.size()-1])
                        break

                    case 2:

                        def dadosEmpresa = [
                                nome: "",
                                emailCorporativo: "",
                                cnpj: "",
                                estado: "",
                                cep: "",
                                descricao: "",
                                senha: ""
                        ]

                        dadosEmpresa.each { chave, valor ->
                            println("$chave:")
                            dadosEmpresa[chave] = sc.nextLine()
                        }

                        empresas << new Empresa(
                                dadosEmpresa.nome,
                                dadosEmpresa.emailCorporativo,
                                dadosEmpresa.cnpj,
                                dadosEmpresa.estado,
                                dadosEmpresa.cep,
                                dadosEmpresa.descricao,
                                dadosEmpresa.senha
                        )

                        bancoDeDados.inserirEmpresa(empresas[empresas.size()-1])
                        break

                    case 3:

                        println("Listando Geral:")
                        println("--------------------")
                        println("Candidatos:")
                        candidatos.each { candidato ->
                            println("Nome: ${candidato.nome}")
                            println("Sobrenome: ${candidato.sobrenome}")
                            println("Email: ${candidato.email}")
                            println("CPF: ${candidato.cpf}")
                            println("Idade: ${candidato.idade}")
                            println("Estado: ${candidato.estado}")
                            println("CEP: ${candidato.cep}")
                            println("Descrição: ${candidato.descricao}")
                            println("Data de Nascimento: ${candidato.data_nascimento}")
                            println("--------------------")
                        }

                        println("Empresas:")
                        empresas.each { empresa ->
                            println("Nome: ${empresa.nome}")
                            println("Email Corporativo: ${empresa.emailCorporativo}")
                            println("CNPJ: ${empresa.cnpj}")
                            println("País: ${empresa.pais}")
                            println("CEP: ${empresa.cep}")
                            println("Descrição: ${empresa.descricao}")
                            println("--------------------")
                        }
                        break

                    case 4:
                        println("Listando Candidatos:")
                        candidatos.each { candidato ->
                            println("Nome: ${candidato.nome}")
                            println("Sobrenome: ${candidato.sobrenome}")
                            println("Email: ${candidato.email}")
                            println("CPF: ${candidato.cpf}")
                            println("Idade: ${candidato.idade}")
                            println("Estado: ${candidato.estado}")
                            println("CEP: ${candidato.cep}")
                            println("Descrição: ${candidato.descricao}")
                            println("Data de Nascimento: ${candidato.data_nascimento}")
                        }
                        break

                    case 5:
                        println("Listando Empresas:")
                        empresas.each { empresa ->
                            println("Nome: ${empresa.nome}")
                            println("Email Corporativo: ${empresa.emailCorporativo}")
                            println("CNPJ: ${empresa.cnpj}")
                            println("País: ${empresa.pais}")
                            println("CEP: ${empresa.cep}")
                            println("Descrição: ${empresa.descricao}")
                            println("-----------------------------")
                        }
                        break

                    case 6:
                        def VagasEmpresa = [
                                id_empresa: "",
                                nome: "",
                                descricao: "",
                                local: ""
                        ]

                        VagasEmpresa.each { chave, valor ->
                            println("$chave:")
                            VagasEmpresa[chave] = sc.nextLine()
                        }

                        vagas << new Vagas(
                                VagasEmpresa.id_empresa as int,
                                VagasEmpresa.nome,
                                VagasEmpresa.descricao,
                                VagasEmpresa.local
                        )
                        bancoDeDados.inserirVaga(vagas[vagas.size()-1])

                        break

                    case 7:
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


