/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s.organizer;

import java.util.ArrayList;

/**
 *
 * @author 20161bsi0403
 */
public class Solicitacao {
    private boolean disponibilidadeCliente;
    private String descricao;
    private String observacao;
    private String dataSolicitacao;
    private int protocolo;
    private Estado estado;
    private ArrayList<Servico> servicos;

    public boolean isDisponibilidadeCliente() {
        return disponibilidadeCliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getDataSolicitacao() {
        return dataSolicitacao;
    }

    public int getProtocolo() {
        return protocolo;
    }

    public String getEstado() {
        return estado.getDescricao();
    }

    public void setDisponibilidadeCliente(boolean disponibilidadeCliente) {
        this.disponibilidadeCliente = disponibilidadeCliente;
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

    public void setProtocolo(int protocolo) {
        this.protocolo = protocolo;
    }

    public void setEstado(String estado) {
        this.estado.setDescricao(estado);
    }
    
    
    
    
}
