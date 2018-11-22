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
@Table(name="Cliente")
public class ClienteP implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
     
    @Column(length = 20,name = "cpf")
    private String cpf;

    @OneToOne
    private UsuarioP usuario;
    @OneToMany
    private List<SolicitacaoP> solicitacao = new ArrayList();

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

    public UsuarioP getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioP usuario) {
        this.usuario = usuario;
    }

    public List<SolicitacaoP> getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(List<SolicitacaoP> solicitacao) {
        this.solicitacao = solicitacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 41 * hash + Objects.hashCode(this.cpf);
        hash = 41 * hash + Objects.hashCode(this.usuario);
        hash = 41 * hash + Objects.hashCode(this.solicitacao);
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
        final ClienteP other = (ClienteP) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.solicitacao, other.solicitacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", cpf=" + cpf + '}';
    }

}
