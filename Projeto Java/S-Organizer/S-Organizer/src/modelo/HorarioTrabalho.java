/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Time;

/**
 *
 * @author 20161BSI0403
 */
public class HorarioTrabalho {
    private Time horarioinicio;
    private Time horariofim;

    public Time getHorarioinicio() {
        return horarioinicio;
    }

    public void setHorarioinicio(Time horarioinicio) {
        this.horarioinicio = horarioinicio;
    }

    public Time getHorariofim() {
        return horariofim;
    }

    public void setHorariofim(Time horariofim) {
        this.horariofim = horariofim;
    }
    
    
}
