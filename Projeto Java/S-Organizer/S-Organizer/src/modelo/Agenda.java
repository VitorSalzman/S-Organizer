/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * FICOU DEFINIDO QUE: 
 * Agenda é uma classe que será instanciada pelo adm,
 * o construtor deve capturar os valores do dia válido da agenda,
 * intancia de agenda comportará Servicos de Solicitacoes,
 * a instancia de Agenda completamente preenchida é entregue para um Prestador
 * 
 * RN:
 * 01 Cliente pagará multa caso não cumpra com o horário marcado.
 * 02 Se os SERVICOS da AGENDA não representarem 8 horas exatas,
 *    o tempo restante o PRESTADOR ficará (DISPONÍVEL OU EXPEDIENTE ENCERRADO)??
 */
public class Agenda {
    
    private long id;
    
    private SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat sdfHora = new SimpleDateFormat("hh:mm:ss");
    private Date data;
    private Time horaInicioExpediente;
    private Time horaFimExpediente;
    private ArrayList<Solicitacao> SolicitacaoDoDia;
    private Prestador prestador;
    private Empresa empresa;
    
        
    
    public Agenda(Prestador prestador) {
        this.prestador = prestador;
        this.data = new Date();
        /*
        Necessario checar se funciona para o último dia do mes,
        se nao, mudaremos para Calendar OU a Agenda será construida
        no mesmo dia que o Prestador atenderá ela.
        */
        data.setDate(data.getDate()+1);
        
    }
    
    public Agenda() {
        this.data = new Date();
        data.setDate(data.getDate()+1);
    }

    public SimpleDateFormat getSdfData() {
        return sdfData;
    }

    public void setSdfData(SimpleDateFormat sdfData) {
        this.sdfData = sdfData;
    }

    public SimpleDateFormat getSdfHora() {
        return sdfHora;
    }

    public void setSdfHora(SimpleDateFormat sdfHora) {
        this.sdfHora = sdfHora;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHoraInicioExpediente() {
        return horaInicioExpediente;
    }

    public void setHoraInicioExpediente(Time horaInicioExpediente) {
        this.horaInicioExpediente = horaInicioExpediente;
    }

    public Time getHoraFimExpediente() {
        return horaFimExpediente;
    }

    public void setHoraFimExpediente(Time horaFimExpediente) {
        this.horaFimExpediente = horaFimExpediente;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    /* Funcoes manual */
    public ArrayList<Solicitacao> getServicosDoDia() {
        return SolicitacaoDoDia;
    }

    public void setServicosDoDia(Solicitacao service) {
        SolicitacaoDoDia.add(service);
    }
    
    public void printServicosDoDia() {
        for( Solicitacao Solicitacao : SolicitacaoDoDia ) { // acho melhor usar o toString aq
            Solicitacao.toString();
        }
    }
    
    /*
    esse metodo deve percorrer a lista de servicos verificando o
    horario mais cedo marcado e o horário mais tarde marcado,
    o horario mais tarde deve somar a duracao base da categoria
    para determinar o horarioFimExpediente.
    */
    /*public int calculaInicioExpediente() {
    
    }*/
}

//
//    fazer builder de agenda
    