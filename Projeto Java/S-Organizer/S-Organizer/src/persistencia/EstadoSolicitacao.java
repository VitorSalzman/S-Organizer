/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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
public class EstadoSolicitacao implements Serializable {

    public EstadoSolicitacao(String tipo) {
        this.tipo = tipo;
    }

    public EstadoSolicitacao() {
    }
    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 20)
    private String tipo;
    
    private List solicitacaos = new ArrayList(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List getSolicitacaos() {
        return solicitacaos;
    }

    public void setSolicitacaos(List solicitacaos) {
        this.solicitacaos = solicitacaos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.tipo);
        hash = 53 * hash + Objects.hashCode(this.solicitacaos);
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
        final EstadoSolicitacao other = (EstadoSolicitacao) obj;
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.solicitacaos, other.solicitacaos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EstadoSolicitacao{" + "id=" + id + ", tipo=" + tipo + ", solicitacaos=" + solicitacaos + '}';
    }

}
