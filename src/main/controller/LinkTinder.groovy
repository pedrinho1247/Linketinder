package main.controller

import main.DAO.CandidatoDAO
import main.DAO.EmpresaDAO
import main.DAO.VagasDAO
import main.model.Vagas
import main.view.CriarCandidato
import main.view.CriarEmpresa
import main.view.CriarVaga
import main.view.Instancias
import main.model.Candidato
import main.model.Empresa
import main.view.OpcaoEscolhida


class LinkTinderMain {

    static void main(String[] args) {

        Scanner sc = new Scanner(System.in)
        Instancias criador

        try {
            while (true) {

                OpcaoEscolhida opcao = new OpcaoEscolhida()
                int Escolha = opcao.InterfaceOpcao()

                switch (Escolha) {

                    case 1:

                        criador = new CriarCandidato()
                        Candidato novoCandidato = criador.criarInstancia()
                        new CandidatoDAO().AdicionarCandidato(novoCandidato)
                        break

                    case 2:
                        criador = new CriarEmpresa()
                        Empresa NovaEmpresa = criador.criarInstancia()
                        new EmpresaDAO().AdicionarEmpresa(NovaEmpresa)
                        break

                    case 3:
                        println("Listando Geral:")
                        println("--------------------")
                        println("Candidatos:")
                        new CandidatoDAO().ListarCandidatos()
                        println("Empresas:")
                        new EmpresaDAO().ListarEmpresas()
                        break

                    case 4:
                        new CandidatoDAO().ListarCandidatos()
                        break

                    case 5:
                        new EmpresaDAO().ListarEmpresas()
                        break

                    case 6:

                        criador = new CriarVaga()
                        Vagas NovaVaga = criador.criarInstancia()
                        new VagasDAO().AdicionarVaga(NovaVaga)
                        break

                    case 7:
                        new VagasDAO().ListarVagas()
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