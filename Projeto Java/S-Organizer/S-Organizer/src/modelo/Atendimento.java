/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author 20161bsi0403
 */
public class Atendimento {
    private long id;
    private Prestador prestador;
    private Time horarioInicioAtendimento;
    private Time horarioFimAtendimento;
    private boolean concluido;
    private Date dataAtendimento;
   
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    @Override
    public String toString() {
        return "Atendimento{" + "id=" + id + ", horarioInicioAtendimento=" + 
                "Prestador=" + prestador.getNome() +
                horarioInicioAtendimento + ", horarioFimAtendimento=" + 
                horarioFimAtendimento + ", dataAtendimento=" + dataAtendimento 
                + "concluido "+ concluido + '}';
    }
    
    public void alteraServico(Servico serv){
        /*Máx de 3 atendimentos*/
        if(serv.getAtendimentos().size()<3 && this.concluido ){
            serv.addAtendimento(this);
            serv.setEstado(concluido);
        } else if( serv.getAtendimentos().size()<3 ) {
            serv.addAtendimento(this);
            if(serv.getAtendimentos().size()==3){
                serv.aplicaMulta();
            }
        }
    }
}
