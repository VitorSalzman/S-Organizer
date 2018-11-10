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

/**
 *
 * @author luizg
 */
@Entity
public class HorarioTrabalho implements Serializable {
    
    /*
    Define as variaveis
    cria toString
    criar hash e equals
    criar get e set
    Atualizar Controlador
    Limpar banco de dados
    testa se ta persistindo
    */
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "horarioInicio")
    private Time horarioinicio;
    @Column(name = "horarioFim")
    private Time horariofim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.horarioinicio);
        hash = 29 * hash + Objects.hashCode(this.horariofim);
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
        final HorarioTrabalho other = (HorarioTrabalho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.horarioinicio, other.horarioinicio)) {
            return false;
        }
        if (!Objects.equals(this.horariofim, other.horariofim)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "HorarioTrabalho{" + "id=" + id + ", horarioinicio=" + horarioinicio + ", horariofim=" + horariofim + '}';
    }

     
   
}
