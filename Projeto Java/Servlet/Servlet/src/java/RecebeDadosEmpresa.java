
import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empresa;
import modelo.padroesdeprojeto.dao.DAOAcesso;
import modelo.padroesdeprojeto.dao.DAOEmpresa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Serenna
 */
public class RecebeDadosEmpresa extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.close();
        
        Empresa emp = new Empresa();
        //DAOEmpresa demp = new DAOEmpresa();
        
        emp.setCnpj(request.getParameter("cnpjEmpresa"));
        emp.setTelefone(request.getParameter("telEmpresa"));
        emp.setLogin(request.getParameter("userEmp"));
        emp.setNome(request.getParameter("nomeEmpresa"));
        try{
            emp.setSenha(request.getParameter("passwordEmp"));
        } catch(Exception e) {
            out.println(e.getMessage());
        }
        //demp.inserir(emp);
        
        response.sendRedirect("index.html");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

// 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    public String getServletInfo() {
        return "Servlet Recebe Dados";
    }// </editor-fold>

}
