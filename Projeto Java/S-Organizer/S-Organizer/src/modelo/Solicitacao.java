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
    private boolean disponibilidadeCliente;
    private String descricao;
    private String observacao;
    private String dataSolicitacao;
    private long protocolo;
    private EstadoSolicitacao estado;
    private ArrayList<Servico> servicos;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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

    public EstadoSolicitacao getEstado() {
        return estado;
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
