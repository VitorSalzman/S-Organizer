/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Time;

public class HorarioTrabalho {
    private Time horarioinicio;
    private Time horariofim;
    private long id;
    
    
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
}
