/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="Atendimento")
public class Atendimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="horarioInicio")
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horarioInicioAtendimento;
    @Column(name="horarioFim")
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horarioFimAtendimento;
    @Column(name="dataAtendimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAtendimento;
    @Column(name="concluido")
    private boolean concluido;
    
    @OneToOne
    private Prestador prestador;

    public Atendimento() {
    }
    
   
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getHorarioInicioAtendimento() {
        return horarioInicioAtendimento;
    }

    public void setHorarioInicioAtendimento(Time horarioInicioAtendimento) {
        this.horarioInicioAtendimento = horarioInicioAtendimento;
    }

    public Date getHorarioFimAtendimento() {
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
                "Prestador=" + prestador.getNome()+
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
