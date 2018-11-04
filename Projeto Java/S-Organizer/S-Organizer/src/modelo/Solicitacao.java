/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author 20161bsi0403
 */
public class Solicitacao {
    private  SimpleDateFormat disp_cli_ini = new SimpleDateFormat("dd/MM/yyyy");
    private  SimpleDateFormat disp_cli_fim = new SimpleDateFormat("dd/MM/yyyy");
    private String descricao;
    private String observacao;
    private String dataSolicitacao;
    private long protocolo;
    private EstadoSolicitacao estado;
    private ArrayList<Servico> servicos;
    

 

    public String getDescricao() {
        return descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getDataSolicitacao() {
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

    public void setDataSolicitacao(String dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }
    
    public void setEstado(EstadoSolicitacao estado) {
        this.estado = estado;
    }

    public long getProtocolo() {
        return protocolo;
    }

    public void setProtocolo() {
        this.protocolo = ProtocoloGenerator.INSTANCE.getNextProtocol();
    }
     
    
    
}
