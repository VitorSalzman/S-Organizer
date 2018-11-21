/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author luizg
 */
@Entity
@Table(name="Solicitacao")
public class Solicitacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; //Protocolo, precisamos customizar o GenerationType
    
    @Column(name="dispCliIni")
    private Time dispCliIni;
    @Column(name="dispCliFim")
    private Time dispCliFim;
    @Column(length = 255,name="observacao")
    private String observacao;
    @Column(name="dispSolicitacao")
    private Date dispSolicitacao;
    @Column(name="multaTotal")
    private Double multaTotal;
    
    @OneToOne
    private Endereco endereco;
    @OneToOne
    private EstadoSol estado;
    @OneToMany
    private List<Servico> servicos = new ArrayList();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Time getDispCliIni() {
        return dispCliIni;
    }

    public void setDispCliIni(Time dispCliIni) {
        this.dispCliIni = dispCliIni;
    }

    public Time getDispCliFim() {
        return dispCliFim;
    }

    public void setDispCliFim(Time dispCliFim) {
        this.dispCliFim = dispCliFim;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDispSolicitacao() {
        return dispSolicitacao;
    }

    public void setDispSolicitacao(Date dispSolicitacao) {
        this.dispSolicitacao = dispSolicitacao;
    }

    public Double getMultaTotal() {
        return multaTotal;
    }

    public void setMultaTotal(Double multaTotal) {
        this.multaTotal = multaTotal;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public EstadoSol getEstado() {
        return estado;
    }

    public void setEstado(EstadoSol estado) {
        this.estado = estado;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 29 * hash + Objects.hashCode(this.dispCliIni);
        hash = 29 * hash + Objects.hashCode(this.dispCliFim);
        hash = 29 * hash + Objects.hashCode(this.observacao);
        hash = 29 * hash + Objects.hashCode(this.dispSolicitacao);
        hash = 29 * hash + Objects.hashCode(this.multaTotal);
        hash = 29 * hash + Objects.hashCode(this.endereco);
        hash = 29 * hash + Objects.hashCode(this.estado);
        hash = 29 * hash + Objects.hashCode(this.servicos);
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
        final Solicitacao other = (Solicitacao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.dispCliIni, other.dispCliIni)) {
            return false;
        }
        if (!Objects.equals(this.dispCliFim, other.dispCliFim)) {
            return false;
        }
        if (!Objects.equals(this.dispSolicitacao, other.dispSolicitacao)) {
            return false;
        }
        if (!Objects.equals(this.multaTotal, other.multaTotal)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.servicos, other.servicos)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "Solicitacao{" + "id=" + id + ", dispCliIni=" + dispCliIni + ", dispCliFim=" + dispCliFim + ", observacao=" + observacao + ", dispSolicitacao=" + dispSolicitacao + ", multaTotal=" + multaTotal + '}';
    }
    
}
