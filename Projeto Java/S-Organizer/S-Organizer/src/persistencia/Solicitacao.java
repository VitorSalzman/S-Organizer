/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author luizg
 */
@Entity
public class Solicitacao implements Serializable {

    public Solicitacao(String descricao, Time dispCliIni, Time dispCliFim, String observacao, Date dispDate, Cliente cliente, Empresa empresa, Endereco endereco, EstadoSolicitacao estadoSolicitacao) {
        this.descricao = descricao;
        this.dispCliIni = dispCliIni;
        this.dispCliFim = dispCliFim;
        this.observacao = observacao;
        this.dispDate = dispDate;
        this.cliente = cliente;
        this.empresa = empresa;
        this.endereco = endereco;
        this.estadoSolicitacao = estadoSolicitacao;
    }

    public Solicitacao() {
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "Protocolo") //precisa ser customizado
    private Long id;
    
    @Column(length = 255)
    private String descricao;
    private Time dispCliIni;
    private Time dispCliFim;
    @Column(length = 255)
    private String observacao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dispDate;
    
    @OneToOne
    private Cliente cliente;
    @OneToOne
    private Empresa empresa;
    @OneToOne
    private Endereco endereco;
    @OneToOne
    private EstadoSolicitacao estadoSolicitacao;
    private List agendas = new ArrayList(0);
    private List servicos = new ArrayList(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public EstadoSolicitacao getEstadoSolicitacao() {
        return estadoSolicitacao;
    }

    public void setEstadoSolicitacao(EstadoSolicitacao estadoSolicitacao) {
        this.estadoSolicitacao = estadoSolicitacao;
    }

    public List getAgendas() {
        return agendas;
    }

    public void setAgendas(List agendas) {
        this.agendas = agendas;
    }

    public List getServicos() {
        return servicos;
    }

    public void setServicos(List servicos) {
        this.servicos = servicos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.descricao);
        hash = 79 * hash + Objects.hashCode(this.dispCliIni);
        hash = 79 * hash + Objects.hashCode(this.dispCliFim);
        hash = 79 * hash + Objects.hashCode(this.observacao);
        hash = 79 * hash + Objects.hashCode(this.dispDate);
        hash = 79 * hash + Objects.hashCode(this.cliente);
        hash = 79 * hash + Objects.hashCode(this.empresa);
        hash = 79 * hash + Objects.hashCode(this.endereco);
        hash = 79 * hash + Objects.hashCode(this.estadoSolicitacao);
        hash = 79 * hash + Objects.hashCode(this.agendas);
        hash = 79 * hash + Objects.hashCode(this.servicos);
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
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
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
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.estadoSolicitacao, other.estadoSolicitacao)) {
            return false;
        }
        if (!Objects.equals(this.agendas, other.agendas)) {
            return false;
        }
        if (!Objects.equals(this.servicos, other.servicos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Solicitacao{" + "id=" + id + ", descricao=" + descricao + ", dispCliIni=" + dispCliIni + ", dispCliFim=" + dispCliFim + ", observacao=" + observacao + ", dispDate=" + dispDate + ", cliente=" + cliente + ", empresa=" + empresa + ", endereco=" + endereco + ", estadoSolicitacao=" + estadoSolicitacao + ", agendas=" + agendas + ", servicos=" + servicos + '}';
    }
    
    
}
