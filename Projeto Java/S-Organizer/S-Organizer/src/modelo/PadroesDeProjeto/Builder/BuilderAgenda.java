package modelo.padroesdeprojeto.builder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package modelo.padroesdeprojeto.builder;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import modelo.Agenda;
import modelo.Prestador;
import modelo.Servico;


public class BuilderAgenda {
    private String data;
    private String horaInicioExpediente;
    private String horaFimExpediente;
    private ArrayList<Servico> servicosDoDia;
    private String prestador;
    private Agenda agenda;

    //pensando em tirar os parametros Date e só instanciar eles dentro do construtor
    public BuilderAgenda(String horaInicioExpediente, String horaFimExpediente, ArrayList<Servico> servicosDoDia, String prestador,  Agenda agenda) {
        
        this.horaInicioExpediente = horaInicioExpediente;
        this.horaFimExpediente = horaFimExpediente;
        this.servicosDoDia = servicosDoDia; //(??) fica assim msm? por ser array
        this.prestador = prestador;
        this.agenda = agenda;
        
    }
    
    public void geraHorarioExpediente() throws ParseException{
        Time h;
        DateFormat formato = new SimpleDateFormat("HH:mm:ss");

        h = new java.sql.Time(formato.parse(this.horaInicioExpediente).getTime());
        this.agenda.setHoraInicioExpediente(h);
        
        h = new java.sql.Time(formato.parse(this.horaFimExpediente).getTime());
        this.agenda.setHoraFimExpediente(h);
    }
    
    public void geraData() throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        Calendar cal = Calendar.getInstance();
	cal.setTime(sdf.parse(this.data));
        this.agenda.setData(data);
    }
    
    public void geraServicos(){
        this.agenda.setServicosDoDia(this.servicosDoDia);
    }
    //ainda definindo operacoes da agenda para escrever os metodos
}
*/