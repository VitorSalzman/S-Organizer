
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empresa;
import modelo.Prestador;
import modelo.padroesdeprojeto.dao.DAOEmpresa;
import modelo.padroesdeprojeto.dao.DAOPrestador;
import modelo.padroesdeprojeto.dao.DAOUsuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Serenna
 */
public class ValidaUsuario extends HttpServlet{
    
   
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        DAOEmpresa demp = new DAOEmpresa();
        DAOPrestador dprest = new DAOPrestador();
        
        String login = request.getParameter("user");
        String senha =request.getParameter("senha");
        List t= demp.listarTodos(0, 0);
        List t1 = dprest.listarTodos(0,0);
        
        for(int i = 0; i < t.size();i++ ){
            Empresa e = (Empresa)t.get(i);
            if( login.equals(e.getLogin()) && senha.equals(e.getSenha())){
                response.sendRedirect("empresaIndex.html");
                break;
            }
        }
        for(int j = 0; j < t.size();j++ ){
            Prestador p = (Prestador)t.get(j);
            if( login.equals(p.getLogin()) && senha.equals(p.getSenha())){
                response.sendRedirect("prestadorIndex.html");
                break;
            }
        }
        
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    public String getServletInfo() {
        return "Servlet para validação do Usuário";
    }// </editor-fold>
}
