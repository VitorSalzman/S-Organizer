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
    
    private Calendar disp_cli_ini;
    private Calendar disp_cli_fim;
    private String descricao;
    private String observacao;
    private Calendar dataSolicitacao;
    private long protocolo;
    private EstadoSolicitacao estado;
    private ArrayList<Servico> servicos;
    
    

 

    public String getDescricao() {
        return descricao;
    }

    public String getObservacao() {
        return observacao;
    }



    public EstadoSolicitacao getEstado() {
        return estado;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
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
     
    
    
}
