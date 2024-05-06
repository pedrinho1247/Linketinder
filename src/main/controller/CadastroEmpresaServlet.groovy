package main.controller

import main.DAO.EmpresaDAO
import main.model.Empresa

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(urlPatterns = ["/empresas"])
class CadastroEmpresaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nome")
        String emailCorporativo = request.getParameter("emailCorporativo")
        String cnpj = request.getParameter("cnpj")
        String pais = request.getParameter("pais")
        String cep = request.getParameter("cep")
        String descricao = request.getParameter("descricao")
        String senha = request.getParameter("senha")

        Empresa novaEmpresa = new Empresa(nome, emailCorporativo,  cnpj,  pais,  cep,  descricao, senha)
        new EmpresaDAO().AdicionarEmpresa(novaEmpresa)

        response.setContentType("text/plain")
        response.setCharacterEncoding("UTF-8")
        response.getWriter().write("Empresa cadastrada com sucesso!")
    }
}