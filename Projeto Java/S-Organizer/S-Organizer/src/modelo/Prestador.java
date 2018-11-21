/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Time;
import java.util.Objects;


public class Prestador extends Acesso{
    
    private boolean disponibilidade;
    private Time horarioInicio;
    private Time horarioFim;
    private int cargaHoraria;
    private String cpf;

    //ta sem o disponibilidade no construtor

    public Prestador(Time horarioInicio, Time horarioFim, int cargaHoraria, String cpf, String usuario, String senha, String nome, long telefone) {
        super(usuario, senha, nome, telefone);
        this.disponibilidade = true; // sempre true quando cria
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.cargaHoraria = cargaHoraria;
        this.cpf = cpf;
    }
    

    public Prestador() {
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
