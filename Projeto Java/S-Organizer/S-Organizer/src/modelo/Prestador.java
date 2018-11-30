/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.sql.Time;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Prestador")
public class Prestador extends Acesso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(length = 20,name="cpf")
    private String cpf;
    @Column(name="horarioInicio")
    private Time horarioInicio;
    @Column(name="horarioInicio")
    private Time horarioFim;
    @Column(name="horarioFim")
    private int cargaHoraria;
    @Column(name="disponibilidade")
    private boolean disponibilidade;
    @Column(name="agenda")
    private Agenda agenda;

    //ta sem o disponibilidade no construtor

    public Prestador(Time horarioInicio, Time horarioFim, int cargaHoraria, String cpf, String usuario, String senha, String nome, String telefone) {
        super(usuario, senha, nome, telefone);
        this.disponibilidade = true; // sempre true quando cria
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.cargaHoraria = cargaHoraria;
        this.cpf = cpf;
    }
    

    public Prestador() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Time getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Time horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Time getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(Time horarioFim) {
        this.horarioFim = horarioFim;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (this.disponibilidade ? 1 : 0);
        hash = 37 * hash + Objects.hashCode(this.horarioInicio);
        hash = 37 * hash + Objects.hashCode(this.horarioFim);
        hash = 37 * hash + this.cargaHoraria;
        hash = 37 * hash + Objects.hashCode(this.cpf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prestador other = (Prestador) obj;
        if (this.disponibilidade != other.disponibilidade) {
            return false;
        }
        if (this.cargaHoraria != other.cargaHoraria) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.horarioInicio, other.horarioInicio)) {
            return false;
        }
        if (!Objects.equals(this.horarioFim, other.horarioFim)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "Prestador{" + "disponibilidade=" + disponibilidade + ", horarioInicio=" + horarioInicio + ", horarioFim=" + horarioFim + ", cargaHoraria=" + cargaHoraria + ", cpf=" + cpf + '}';
    }
    
}
