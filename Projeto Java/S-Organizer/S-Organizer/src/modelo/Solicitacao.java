/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author 20161bsi0403
 */
public class Solicitacao {

    private long protocolo;
    private Calendar disp_cli_ini;
    private Calendar disp_cli_fim;
    private String observacao;
    private Calendar dataSolicitacao;
    
    private Double multa;
    
    private EstadoSolicitacao estado;
    private ArrayList<Servico> servicos;
   
    public String getObservacao() {
        return observacao;
    }
    
    public EstadoSolicitacao getEstado() {
        return estado;
    }
    
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }


    
    public void setEstado(EstadoSolicitacao estado) {
        this.estado = estado;
    }

    public long getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(long protocol) {
        this.protocolo = protocol;
    }


    public Calendar getDispCliIni() {
        return disp_cli_ini;
    }

    public void setDispCliIni(Calendar disp_cli_ini) {
        this.disp_cli_ini = disp_cli_ini;
    }

    public Calendar getDispCliFim() {
        return disp_cli_fim;
    }

    public void setDispCliFim(Calendar disp_cli_fim) {
        this.disp_cli_fim = disp_cli_fim;
    }

    public Calendar getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Calendar dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }
     
    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    //operação manual
    public void setServicos(Servico servico) {
        this.servicos.add(servico);
    }

    //não manual, tive que por esse porque o builder utiliza dessa forma..
    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }

    
    public void printServicos() {
        for( Servico service : servicos ) {
            service.toString();
        }
    }

    
    
}
