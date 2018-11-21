/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.sql.Time;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author luizg
 */
@Entity
public class Prestador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(length = 20)
    private String cpf;
    private Time horarioinicio;
    private Time horariofim;
    private int cargahoraria;
    
    @OneToOne
    private Acesso acesso;
    @OneToOne
    private Empresa empresa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Time getHorarioinicio() {
        return horarioinicio;
    }

    public void setHorarioinicio(Time horarioinicio) {
        this.horarioinicio = horarioinicio;
    }

    public Time getHorariofim() {
        return horariofim;
    }

    public void setHorariofim(Time horariofim) {
        this.horariofim = horariofim;
    }

    public int getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    public Acesso getAcesso() {
        return acesso;
    }

    public void setAcesso(Acesso acesso) {
        this.acesso = acesso;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 47 * hash + Objects.hashCode(this.cpf);
        hash = 47 * hash + Objects.hashCode(this.horarioinicio);
        hash = 47 * hash + Objects.hashCode(this.horariofim);
        hash = 47 * hash + this.cargahoraria;
        hash = 47 * hash + Objects.hashCode(this.acesso);
        hash = 47 * hash + Objects.hashCode(this.empresa);
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
        if (this.id != other.id) {
            return false;
        }
        if (this.cargahoraria != other.cargahoraria) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.horarioinicio, other.horarioinicio)) {
            return false;
        }
        if (!Objects.equals(this.horariofim, other.horariofim)) {
            return false;
        }
        if (!Objects.equals(this.acesso, other.acesso)) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prestador{" + "id=" + id + ", cpf=" + cpf + ", horarioinicio=" + horarioinicio + ", horariofim=" + horariofim + ", cargahoraria=" + cargahoraria + '}';
    }

}
