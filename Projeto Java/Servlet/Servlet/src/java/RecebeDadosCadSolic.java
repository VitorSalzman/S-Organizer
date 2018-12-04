
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Servico;
import modelo.Solicitacao;
import modelo.padroesdeprojeto.builder.DiretorEndereco;
import modelo.padroesdeprojeto.builder.DiretorServico;
import modelo.padroesdeprojeto.builder.DiretorSolicitacao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Serenna
 */
public class RecebeDadosCadSolic extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /* request.getParameterMap().get("descricao") */
        DiretorSolicitacao dirSolic = new DiretorSolicitacao();
        DiretorServico dirServico = new DiretorServico(); 
        DiretorEndereco dirEnd = new DiretorEndereco();
        Solicitacao sol1;
        Servico serv1;
        
        
        
        
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
        return "Servlet Recebe Dados";
    }// </editor-fold>

}
