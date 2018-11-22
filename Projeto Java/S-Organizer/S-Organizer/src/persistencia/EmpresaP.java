/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
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
@Table(name="Empresa")
public class EmpresaP implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(length = 20,name = "cnpj")
    private String cnpj;
    
    @OneToOne
    private AcessoP acesso;
    @OneToMany
    private List<SolicitacaoP> solicitacaoes = new ArrayList(); //tipo da lista SOLICITACAO 
    @OneToMany
    private List<PrestadorP> prestadores = new ArrayList(); //tipo da lista PRESTADOR

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public AcessoP getAcesso() {
        return acesso;
    }

    public void setAcesso(AcessoP acesso) {
        this.acesso = acesso;
    }

    public List<SolicitacaoP> getSolicitacaoes() {
        return solicitacaoes;
    }

    public void setSolicitacaoes(List<SolicitacaoP> solicitacaoes) {
        this.solicitacaoes = solicitacaoes;
    }

    public List<PrestadorP> getPrestadores() {
        return prestadores;
    }

    public void setPrestadores(List<PrestadorP> prestadores) {
        this.prestadores = prestadores;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + Objects.hashCode(this.cnpj);
        hash = 53 * hash + Objects.hashCode(this.acesso);
        hash = 53 * hash + Objects.hashCode(this.solicitacaoes);
        hash = 53 * hash + Objects.hashCode(this.prestadores);
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
        final EmpresaP other = (EmpresaP) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        if (!Objects.equals(this.acesso, other.acesso)) {
            return false;
        }
        if (!Objects.equals(this.solicitacaoes, other.solicitacaoes)) {
            return false;
        }
        if (!Objects.equals(this.prestadores, other.prestadores)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "EmpresaP{" + "id=" + id + ", cnpj=" + cnpj + '}';
    }

    
}
