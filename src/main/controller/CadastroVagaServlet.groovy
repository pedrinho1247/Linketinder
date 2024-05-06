package main.controller

import main.DAO.VagasDAO
import main.model.Vagas

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(urlPatterns = ["/vagas"])
class CadastroVagaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id_empresa = request.getParameter("id_empresa") as int
        String nome = request.getParameter("nome")
        String local = request.getParameter("local")
        String descricao = request.getParameter("descricao")

        Vagas novaVaga= new Vagas(id_empresa, nome, descricao, local)
        new VagasDAO().AdicionarVaga(novaVaga)

        response.setContentType("text/plain")
        response.setCharacterEncoding("UTF-8")
        response.getWriter().write("Vaga cadastrada com sucesso!")
    }
}