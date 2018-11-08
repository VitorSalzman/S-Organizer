/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.PadroesDeProjeto.Builder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import modelo.ProtocoloGenerator;
import modelo.Servico;
import modelo.Solicitacao;

/**
 *
 * @author Salzman
 */
public class BuilderSolicitacao {
    private long protocolo;
    private SimpleDateFormat sdfDMA = new SimpleDateFormat("dd/MM/yyyy"); //Isso tem que estar no builder msm?
    private Date dataSolicitacao;
    private Date disp_cli_ini;
    private Date disp_cli_fim;
    private ArrayList<Servico> servicos;
    private Solicitacao solicit;
    public BuilderSolicitacao(Date disp_cli_ini, Date disp_cli_fim, String descricao,
            String observacao, Date dataSolicitacao, ArrayList<Servico> servicos, Solicitacao solicitacao){
        
        this.dataSolicitacao=dataSolicitacao;
        this.disp_cli_ini=disp_cli_ini;
        this.disp_cli_fim=disp_cli_fim;
        this.servicos=servicos;
        
        solicitacao.setDescricao(descricao);
        solicitacao.setObservacao(observacao);
        
        this.solicit=solicitacao;
    }
    
    public void geraProtocolo(){
        this.protocolo=ProtocoloGenerator.INSTANCE.getNextProtocol();
        this.solicit.setProtocolo(protocolo);
    }
    
    public void setDisponibilidades(){
        this.solicit.setDataSolicitacao(this.dataSolicitacao);
        this.solicit.setDispCliIni(this.disp_cli_ini);
        this.solicit.setDispCliFim(this.disp_cli_fim);
    }
    
    public void adicionaServicos(){
        
        this.solicit.setServicos(this.servicos);      ///Falta tratar a adição de somente um serviço
    }
    
    
    
    
    
}
