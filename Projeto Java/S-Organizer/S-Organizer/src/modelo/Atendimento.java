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
public class Atendimento {
    private boolean estahFeito;
    private String horarioAtendido;
    private Solicitacao solicitacao;

    public boolean isEstahFeito() {
        return estahFeito;
    }

    public String getHorarioAtendido() {
        return horarioAtendido;
    }

    public void setEstahFeito(boolean estahFeito) {
        this.estahFeito = estahFeito;
    }

    public void setHorarioAtendido(String horarioAtendido) {
        this.horarioAtendido = horarioAtendido;
    }
    
    
    
   
}
