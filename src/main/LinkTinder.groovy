package main

import main.controller.CandidatoController
import main.controller.EmpresaController
import main.controller.VagasController
import main.instancias.CriarCandidato
import main.instancias.CriarEmpresa
import main.instancias.CriarVaga
import main.instancias.Instancias


class LinkTinderMain {

    static void main(String[] args) {

        Scanner sc = new Scanner(System.in)
        Instancias criador

        try {
            while (true) {
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
                print("OPÇÃO: ")
                int OpcaoEscolhida = sc.nextInt()
                sc.nextLine()

                switch (OpcaoEscolhida) {

                    case 1:

                        criador = new CriarCandidato()
                        Candidato novoCandidato = criador.criarInstancia()
                        new CandidatoController().AdicionarCandidato(novoCandidato)
                        break

                    case 2:
                        criador = new CriarEmpresa()
                        Empresa NovaEmpresa = criador.criarInstancia()
                        new EmpresaController().AdicionarEmpresa(NovaEmpresa)
                        break

                    case 3:
                        println("Listando Geral:")
                        println("--------------------")
                        println("Candidatos:")
                        new CandidatoController().ListarCandidatos()
                        println("Empresas:")
                        new EmpresaController().ListarEmpresas()
                        break

                    case 4:
                        new CandidatoController().ListarCandidatos()
                        break

                    case 5:
                        new EmpresaController().ListarEmpresas()
                        break

                    case 6:

                        criador = new CriarVaga()
                        Vagas NovaVaga = criador.criarInstancia()
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