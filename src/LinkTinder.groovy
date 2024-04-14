class LinkTinderMain {

    static void main(String[] args) {

        Scanner sc = new Scanner(System.in)

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
                println("7. Listar vaga")
                println("8. Sair")
                println("-----------------------------------------------")
                print("OPÇÃO: ")
                int OpcaoEscolhida = sc.nextInt()
                sc.nextLine()

                switch (OpcaoEscolhida) {

                    case 1:
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
                        new CandidatoController().AdicionarCandidato(NovoCandidato)
                        break

                    case 2:

                        println("Insira o nome da empresa:")
                        String nomeEmpresa = sc.nextLine()

                        println("Insira o email corporativo da empresa:")
                        String emailEmpresa = sc.nextLine()

                        println("Insira o cnpj da empresa:")
                        String cnpjEmpresa = sc.nextLine()

                        println("Insira o pais da empresa:")
                        String paisEmpresa = sc.nextLine()

                        println("Insira o cep da empresa:")
                        String cepEmpresa = sc.nextLine()

                        println("Insira a descrição da empresa:")
                        String descricaoEmpresa = sc.nextLine()

                        println("Insira a senha da empresa:")
                        String senhaEmpresa = sc.nextLine()

                        Empresa NovaEmpresa = new Empresa(
                                nomeEmpresa,
                                emailEmpresa,
                                cnpjEmpresa,
                                paisEmpresa,
                                cepEmpresa,
                                descricaoEmpresa,
                                senhaEmpresa
                        )

                        new EmpresaController().AdicionarEmpresa(NovaEmpresa)
                        break

                    case 3:
                        println("Listando Geral:")
                        println("--------------------")
                        println("Candidatos:")
                        new CandidatoController().ListarCandidatos()
                        println("Empresas:")
                        new EmpresaController().ListarEmpresa()
                        break

                    case 4:
                        new CandidatoController().ListarCandidatos()
                        break

                    case 5:
                        new EmpresaController().ListarEmpresa()
                        break

                    case 6:

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

                        new VagasController().AdicionarVaga(NovaVaga)
                        break

                    case 7:
                        new VagasController().ListarVagas();
                        break

                    case 8:
                        println("Saindo do programa...")
                        System.exit(0)
                        break

                    default:
                        println("Opção inválida! Por favor, escolha uma opção válida.")
                }
            }
        } catch (InputMismatchException ignored) {
            println("Valor inserido inválido! Por favor, insira um número correspondente à opção desejada.")
            sc.nextLine()
        }
    }
}
