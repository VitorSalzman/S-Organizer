/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 20161bsi0403
 */
public enum Estado {
    PENDENTE("pendente"),AGENDADO("agendado"), ACAMINHO("a caminho"),EMEXECUCAO("em execucao"),CONCLUIDO("concluido"); 
    
    private String descricao;
    
    Estado(String descricao){
        this.descricao=descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
