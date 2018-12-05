/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.builder;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import modelo.Agenda;
import modelo.Prestador;
import modelo.Servico;
import modelo.Solicitacao;



public class DiretorAgenda {
    
    public Agenda builder(String horaInicioExpediente, String horaFimExpediente, 
            Solicitacao servicosDoDia, String prestador) throws ParseException {
        Agenda agenda = new Agenda();
                
        BuilderAgenda builder = new BuilderAgenda(horaInicioExpediente, horaFimExpediente, servicosDoDia, prestador, agenda );
        
        builder.geraHorarioExpediente();
        builder.geraData();
        builder.geraServicos();
        
        return agenda;
    }
}