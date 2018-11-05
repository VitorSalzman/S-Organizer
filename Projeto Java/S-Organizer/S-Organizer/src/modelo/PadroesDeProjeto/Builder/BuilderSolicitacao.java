/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.PadroesDeProjeto.Builder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private SimpleDateFormat dataSolicitacao;
    private SimpleDateFormat disp_cli_ini;
    private SimpleDateFormat disp_cli_fim;
    private ArrayList<Servico> servicos;
    private Solicitacao solicit;
    public BuilderSolicitacao(SimpleDateFormat disp_cli_ini, SimpleDateFormat disp_cli_fim, String descricao,
            String observacao, SimpleDateFormat dataSolicitacao, ArrayList<Servico> servicos, Solicitacao solicitacao){
        
        this.dataSolicitacao=dataSolicitacao;
        this.disp_cli_ini=disp_cli_ini;
        this.disp_cli_fim=disp_cli_fim;
        this.servicos=servicos;
        
        solicitacao.setDescricao(descricao);
        solicitacao.setObservacao(observacao);
        
        this.solicit=solicitacao;
    }
    
    public void geraProtocolo(){
        ProtocoloGenerator protocol = null;
        this.protocolo=protocol.INSTANCE.getNextProtocol();
        this.solicit.setProtocolo(protocolo);
    }
    
    public void setDisponibilidades(){
        this.solicit.setDataSolicitacao(this.dataSolicitacao);
        this.solicit.setDisCliIni(this.disp_cli_ini);
        this.solicit.setDispCliFim(this.disp_cli_fim);
    }
    
    public void adicionaServicos(){
        this.solicit.setServicos(this.servicos);      ///Falta tratar a adição de somente um serviço
    }
    
    
    
    
    
}
