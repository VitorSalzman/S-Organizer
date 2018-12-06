
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Endereco;
import modelo.Servico;
import modelo.Solicitacao;
import modelo.padroesdeprojeto.builder.DiretorEndereco;
import modelo.padroesdeprojeto.builder.DiretorServico;
import modelo.padroesdeprojeto.builder.DiretorSolicitacao;
import modelo.padroesdeprojeto.dao.DAOEndereco;
import modelo.padroesdeprojeto.dao.DAOServico;
import modelo.padroesdeprojeto.dao.DAOSolicitacao;


public class RecebeDadosCadSolic extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        DiretorSolicitacao dirSolic = new DiretorSolicitacao();
        DiretorServico dirServico = new DiretorServico(); 
        DiretorEndereco dirEnd = new DiretorEndereco();
        
        Solicitacao sol1 = null;
        Servico serv1 = null;
        ArrayList<Servico> servicos = new ArrayList();
        Endereco end;
        
        DAOSolicitacao dsolic = new DAOSolicitacao();
        DAOEndereco dend = new DAOEndereco();
        DAOServico dserv = new DAOServico();
        
        try {
            serv1 = dirServico.builder(request.getParameter("selectServicos"),
                    request.getParameter("descricaoServ"), request.getParameter("valorServic"),
                    request.getParameter("horServic"));
        } catch (Exception ex) {
            Logger.getLogger(RecebeDadosCadSolic.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        servicos.add(serv1);
        
        end = dirEnd.builder(request.getParameter("estadoEndereco"), 
                request.getParameter("cidade"), request.getParameter("bairro"),
                request.getParameter("logradouro"), request.getParameter("complemento"), 
                request.getParameter("cep"));
        
        try {
            sol1 = dirSolic.builder(request.getParameter("dispIniClient"),
                    request.getParameter("dispFimClient"),request.getParameter("observacoes"),
                    request.getParameter("dataSolic"), servicos, end);
        } catch (ParseException ex) {
            Logger.getLogger(RecebeDadosCadSolic.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dserv.inserir(serv1);
        dsolic.inserir(sol1);
        dend.inserir(end);
        
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
