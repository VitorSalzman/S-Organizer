/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 20161bsi0403
 */
public class Solicitacao {
    private SimpleDateFormat sdfDMA = new SimpleDateFormat("dd/MM/yyyy");
    private Date disp_cli_ini;
    private Date disp_cli_fim;
    private String descricao;
    private String observacao;
    private Date dataSolicitacao;
    private long protocolo;
    private EstadoSolicitacao estado;
    private ArrayList<Servico> servicos;
    
    

 

    public String getDescricao() {
        return descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public SimpleDateFormat getDataSolicitacao() {
        return dataSolicitacao;
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

    public void setDataSolicitacao(SimpleDateFormat dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
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

    public SimpleDateFormat getDispCliIni() {
        return disp_cli_ini;
    }

    public void setDisCliIni(SimpleDateFormat disp_cli_ini) {
        this.disp_cli_ini = disp_cli_ini;
    }

    public SimpleDateFormat getDispCliFim() {
        return disp_cli_fim;
    }

    public void setDispCliFim(SimpleDateFormat disp_cli_fim) {
        this.disp_cli_fim = disp_cli_fim;
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }
     
    
    
}
