/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * FICOU DEFINIDO QUE: 
 * Agenda é uma classe que será instanciada pelo adm,
 * o construtor deve capturar os valores do dia válido da agenda,
 * intancia de agenda comportará Servicos de Solicitacoes,
 * a instancia de Agenda completamente preenchida é entregue para um Prestador
 */
public class Agenda {
    private SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat sdfHora = new SimpleDateFormat("hh:mm:ss");
    private Calendar data; //ou Date?
    private ArrayList<Servico> servicosDoDia;
    //PRESTADOR RECEBE AGENDA
    private long id;

    public Agenda() {
        this.data = Calendar.getInstance();
    }

    

    
    
    /*public SimpleDateFormat getData(){
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }*/

    public ArrayList<Servico> getServicosDoDia() {
        return servicosDoDia;
    }

    public void setServicosDoDia(Servico service) {
        servicosDoDia.add(service);
    }
    
    public void printServicosDoDia() {
        for( Servico service : servicosDoDia ) {
            System.out.println("Categoria: " + service.getCategoria() + "\n" + "Horario: " + service.getHorarioMarcado());
        }
    }
    
    
}
