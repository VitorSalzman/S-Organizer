/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Time;
import java.text.SimpleDateFormat;

/**
 *
 * @author 20161BSI0403
 */
public class Agenda {
    private SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
    private Time hora;

    public SimpleDateFormat getData() {
        return data;
    }

    public void setData(SimpleDateFormat data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
    
    
}
