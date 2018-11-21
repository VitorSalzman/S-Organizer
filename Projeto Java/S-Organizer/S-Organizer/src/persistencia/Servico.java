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
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(length = 255)
    private String descricao;
    private Time horarioMarcado;
    private Double valor;
    
    @OneToOne
    private CategoriaServico categoriaServico;
    @OneToOne
    private Solicitacao solicitacao;

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

    public Time getHorarioMarcado() {
        return horarioMarcado;
    }

    public void setHorarioMarcado(Time horarioMarcado) {
        this.horarioMarcado = horarioMarcado;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public CategoriaServico getCategoriaServico() {
        return categoriaServico;
    }

    public void setCategoriaServico(CategoriaServico categoriaServico) {
        this.categoriaServico = categoriaServico;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 43 * hash + Objects.hashCode(this.descricao);
        hash = 43 * hash + Objects.hashCode(this.horarioMarcado);
        hash = 43 * hash + Objects.hashCode(this.valor);
        hash = 43 * hash + Objects.hashCode(this.categoriaServico);
        hash = 43 * hash + Objects.hashCode(this.solicitacao);
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
        final Servico other = (Servico) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.horarioMarcado, other.horarioMarcado)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.categoriaServico, other.categoriaServico)) {
            return false;
        }
        if (!Objects.equals(this.solicitacao, other.solicitacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servico{" + "id=" + id + ", descricao=" + descricao + ", horarioMarcado=" + horarioMarcado + ", valor=" + valor + '}';
    }

}
