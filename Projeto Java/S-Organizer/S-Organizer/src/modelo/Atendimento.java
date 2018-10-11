/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Time;

/**
 *
 * @author 20161bsi0403
 */
public class Atendimento {
    private boolean estahFeito;
    private Time horarioInicioAtendimento;
    private Time horarioFimAtendimento;
    

    public boolean isEstahFeito() {
        return estahFeito;
    }

    public void setEstahFeito(boolean estahFeito) {
        this.estahFeito = estahFeito;
    }

    public Time getHorarioInicioAtendimento() {
        return horarioInicioAtendimento;
    }

    public void setHorarioInicioAtendimento(Time horarioInicioAtendimento) {
        this.horarioInicioAtendimento = horarioInicioAtendimento;
    }

    public Time getHorarioFimAtendimento() {
        return horarioFimAtendimento;
    }

    public void setHorarioFimAtendimento(Time horarioFimAtendimento) {
        this.horarioFimAtendimento = horarioFimAtendimento;
    }

    
    
   
}
