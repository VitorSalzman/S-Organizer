/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public enum EstadoSolicitacao { //não vai ser persistida logo não coloquei nenhuma @Annotation, nem serializei
    PENDENTE(1) ,AGENDADO(2), ACAMINHO(3), EMEXECUCAO(4), CONCLUIDO(5), CANCELADO(6);
    private long id;
    
    
    public long getId() {
        return id;
    }

    EstadoSolicitacao(long id) {
        this.id = id;
    }
}
