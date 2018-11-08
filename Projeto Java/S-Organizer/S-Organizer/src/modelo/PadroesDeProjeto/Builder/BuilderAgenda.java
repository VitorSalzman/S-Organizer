/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.PadroesDeProjeto.Builder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelo.Agenda;
import modelo.Prestador;
import modelo.Servico;

/**
 *
 * @author helle
 */
public class BuilderAgenda {
    private Date data;
    private Date horaInicioExpediente;
    private Date horaFimExpediente;
    private ArrayList<Servico> servicosDoDia;
    private Prestador prestador;
    private Agenda agenda;

    //pensando em tirar os parametros Date e só instanciar eles dentro do construtor
    public BuilderAgenda(Date horaInicioExpediente, Date horaFimExpediente, ArrayList<Servico> servicosDoDia, Prestador prestador,  Agenda agenda) {
        
        this.horaInicioExpediente = horaInicioExpediente;
        this.horaFimExpediente = horaFimExpediente;
        this.servicosDoDia = servicosDoDia; //(??) fica assim msm? por ser array
        this.prestador = prestador;
        this.agenda = agenda;
        
    }
    
    //ainda definindo operacoes da agenda para escrever os metodos
}
