package main.controller

import main.DAO.CandidatoDAO
import main.model.Candidato

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(urlPatterns = ["/candidatos"])
class CadastroCandidatoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nome")
        String sobrenome = request.getParameter("sobrenome")
        String data_nascimento = request.getParameter("data_nascimento")
        String email = request.getParameter("email")
        String cpf = request.getParameter("cpf")
        String pais = request.getParameter("pais")
        int idade = request.getParameter("idade")
        String estado = request.getParameter("estado")
        String cep = request.getParameter("cep")
        String descricao = request.getParameter("descricao")
        String senha = request.getParameter("senha")

        Candidato novoCandidato = new Candidato(nome, sobrenome, data_nascimento, email, cpf,  pais,  idade,  estado,  cep,  descricao, senha)
        new CandidatoDAO().AdicionarCandidato(novoCandidato)

        response.setContentType("text/plain")
        response.setCharacterEncoding("UTF-8")
        response.getWriter().write("Candidato cadastrado com sucesso!")
    }
}
