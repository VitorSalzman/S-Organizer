/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.PadroesDeProjeto.Builder;

import java.util.ArrayList;
import java.util.Date;
import modelo.Agenda;
import modelo.Prestador;
import modelo.Servico;

/**
 *
 * @author helle
 */
public class DiretorAgenda {
    
    public Agenda builder(Date horaInicioExpediente, Date horaFimExpediente, ArrayList<Servico> servicosDoDia, Prestador prestador) {
        Agenda agenda = new Agenda();
                
        BuilderAgenda builder = new BuilderAgenda(horaInicioExpediente, horaFimExpediente, servicosDoDia, prestador, agenda );
        
        return agenda;
    }
}
