/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.builder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import modelo.Endereco;
import modelo.padroesdeprojeto.singleton.ProtocoloGenerator;
import modelo.Servico;
import modelo.Solicitacao;


public class BuilderSolicitacao { 
    private long protocolo;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String dataSolicitacao;
    private String disp_cli_ini;
    private String disp_cli_fim;
    private ArrayList<Servico> servicos;
    private Solicitacao solicit;
    private Endereco endereco;
    
    public BuilderSolicitacao(String disp_cli_ini, String disp_cli_fim,
            String observacao, String dataSolicitacao, ArrayList<Servico> servicos, Solicitacao solicitacao, Endereco endereco){
        
        this.dataSolicitacao=dataSolicitacao;
        this.disp_cli_ini=disp_cli_ini;
        this.disp_cli_fim=disp_cli_fim;
        this.servicos=servicos;
        this.endereco=endereco;
        solicitacao.setObservacao(observacao);

        this.solicit=solicitacao;
    }
    
    public void geraProtocolo(){
        
        this.protocolo=ProtocoloGenerator.INSTANCE.getNextProtocol();
        this.solicit.setProtocolo(protocolo);
    }
    
    public void geraDisponibilidades() throws ParseException{
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        
        cal.setTime(sdf.parse(this.disp_cli_ini));
        cal2.setTime(sdf.parse(this.disp_cli_fim));
        this.solicit.setDispCliIni(cal);
        this.solicit.setDispCliFim(cal2);
    }
    public void geraDataSolicitacao() throws ParseException{
        Calendar cal = Calendar.getInstance();
	cal.setTime(sdf.parse(this.dataSolicitacao));
        this.solicit.setDataSolicitacao(cal);
    }
    
    public void adicionaServicos(){
        
        this.solicit.setServicos(this.servicos);      ///Falta tratar a adição de somente um serviço
        //deveria ser .add não simplesmente setar a list inteira
        //mas eu criei a opção de adicionar não manualmente (como esta sendo usada agr)
    }
    
    public void geraEndereco(){
        this.solicit.setEndereco(endereco);
    }
    
    
    
    
    
}
