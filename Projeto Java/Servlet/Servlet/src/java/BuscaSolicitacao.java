
import aplicacao.APLCliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Servico;
import modelo.Solicitacao;
import modelo.padroesdeprojeto.dao.DAOSolicitacao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Serenna
 */
public class BuscaSolicitacao extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        APLCliente aplc = new APLCliente();
        Solicitacao soli = aplc.consultaSolicitacao(Long.parseLong(request.getParameter("pesquisaProtocolo")));
        
        if(soli != null){    
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='utf-8'/>");
            out.println("<title>Pesquisa de Solicitação</title>");
            out.println("<link rel='stylesheet' type='text/css'"
                    + "href='materialize-v0.98.1/css/materialize.min.css'  "
                    + "media='screen'/>");
            out.println("<link rel='stylesheet' type='text/css' "
                    + "href='//fonts.googleapis.com/css?family=Pacifico' />");
            out.println("</head>");
            out.println("<body>");
            out.println("<nav class='nav-extended'>");
            out.println("<div class='nav-wrapper'>");
            out.println("<a href='index.html' class='brand-logo' style='font-family:"
                    + " Pacifico;font-size: 2em;font-weight: 700;'>S-Organizer");
            out.println("</a>");
            out.println("</div>");
            out.println("</nav>");
            out.println("<div class='container'>");
            out.println("<div class='col s12 m8 offset-m1 x17 offset-x11'>");
            
            out.println("<form action='BuscaSolicitacao' method='GET' >"
                    + "<div class='input-field col s3'>"
                +" <input id='protClient' placeholder='Pesquisar protocolo' "
                + "style='max-width: 300px;right:0;margin: 10px;background: #fff;"
                + "'name='pesquisaProtocolo'></div></form>");
            out.println("<div class='row'>");
            out.println("<div class='col s12 m6'>");
            out.println("<div class='card blue-grey darken-1'>");
            out.println("<div class='card-content white-text'>");
            out.println("<span id='nProtocol' class='card-title'"
                    + ">Solicitação nº" +request.getParameter("pesquisaProtocolo")+"</span>");
            out.println("<label>Status</label>");
            out.println("<p>"+soli.getEstado().name()+"</p>");
            out.println("<label>Disponibilidade Cliente</label>");
            out.println("<p>"+soli.getDispCliIni()+ " a " + soli.getDispCliFim()+"</p>");
            out.println("<label>Observação</label>");
            out.println("<p>"+soli.getObservacao()+"</p>");
            out.println("<label>Serviços</label>");
            for(Servico s: soli.getServicos()){
                out.println("<p>"+s.toString()+"</p>");
            }
            
            out.println("<label>Endereço</label>");
            out.println("<p> #MostraEndereço</p>");
            out.println("<label>Multa</label>");
            out.println("<p> #MostraMulta</p>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div> ");
            out.println("</div>");
            out.println("</div>");

            out.println("</body>");
            out.println("<script type='text/javascript' "
                    + "src='https://code.jquery.com/jquery-2.1.1.min.js'></script>");
            out.println("<script type='text/javascript' "
                    + "src='materialize-v0.98.1/js/materialize.min.js'></script>");
            out.println("</html>");
        } else {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='utf-8'/>");
            out.println("<title>Pesquisa de Solicitação</title>");
            out.println("<link rel='stylesheet' type='text/css'"
                    + "href='materialize-v0.98.1/css/materialize.min.css'  "
                    + "media='screen'/>");
            out.println("<link rel='stylesheet' type='text/css' "
                    + "href='//fonts.googleapis.com/css?family=Pacifico' />");
            out.println("</head>");
            out.println("<body>");
            out.println("<nav class='nav-extended'>");
            out.println("<div class='nav-wrapper'>");
            out.println("<a href='#' class='brand-logo' style='font-family:"
                    + " Pacifico;font-size: 2em;font-weight: 700;'>S-Organizer");
            out.println("</a>");
            out.println("</div>");
            out.println("</nav>");
            out.println("<div class='container'>");
            out.println("<div class='col s12 m8 offset-m1 x17 offset-x11'>");
            
            out.println("<form action='BuscaSolicitacao' method='GET' >"
                    + "<div class='input-field col s3'>"
                +" <input id='protClient' placeholder='Pesquisar protocolo' "
                + "style='max-width: 300px;right:0;margin: 10px;background: #fff;"
                + "'name='pesquisaProtocolo'></div></form>");
            out.println("<div class='row'>");
            out.println("<div class='col s12 m6'>");
            out.println("<div class='card blue-grey darken-1'>");
            out.println("<div class='card-content white-text'>");
            out.println("<span id='nProtocol' class='card-title'"
                    + ">Nada encontrado...</span>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div> ");
            out.println("</div>");
            out.println("</div>");

            out.println("</body>");
            out.println("<script type='text/javascript' "
                    + "src='https://code.jquery.com/jquery-2.1.1.min.js'></script>");
            out.println("<script type='text/javascript' "
                    + "src='materialize-v0.98.1/js/materialize.min.js'></script>");
            out.println("</html>");
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
        return "Servlet Busca Solicitação";
    }// </editor-fold>

    
}
