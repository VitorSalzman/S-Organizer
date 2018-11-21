/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.sql.Date;
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
public class Solicitacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(length = 255)
    private String descricao;
    private Time dispCliIni;
    private Time dispCliFim;
    @Column(length = 255)
    private String observacao;
    private Date dispDate;

    private Agenda agenda; // 0 or many.. n tem anottation para isso
    @OneToOne
    private Cliente cliente;
    @OneToOne
    private Empresa empresa;
    @OneToOne
    private Endereco endereco;
    @OneToOne
    private EstadoSol estadoSol;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public Date getDispDate() {
        return dispDate;
    }

    public void setDispDate(Date dispDate) {
        this.dispDate = dispDate;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public EstadoSol getEstadoSol() {
        return estadoSol;
    }

    public void setEstadoSol(EstadoSol estadoSol) {
        this.estadoSol = estadoSol;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.descricao);
        hash = 97 * hash + Objects.hashCode(this.dispCliIni);
        hash = 97 * hash + Objects.hashCode(this.dispCliFim);
        hash = 97 * hash + Objects.hashCode(this.observacao);
        hash = 97 * hash + Objects.hashCode(this.dispDate);
        hash = 97 * hash + Objects.hashCode(this.agenda);
        hash = 97 * hash + Objects.hashCode(this.cliente);
        hash = 97 * hash + Objects.hashCode(this.empresa);
        hash = 97 * hash + Objects.hashCode(this.endereco);
        hash = 97 * hash + Objects.hashCode(this.estadoSol);
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
        if (!Objects.equals(this.descricao, other.descricao)) {
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
        if (!Objects.equals(this.dispDate, other.dispDate)) {
            return false;
        }
        if (!Objects.equals(this.agenda, other.agenda)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.estadoSol, other.estadoSol)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Solicitacao{" + "id=" + id + ", descricao=" + descricao + ", dispCliIni=" + dispCliIni + ", dispCliFim=" + dispCliFim + ", observacao=" + observacao + ", dispDate=" + dispDate + '}';
    }

    
}
