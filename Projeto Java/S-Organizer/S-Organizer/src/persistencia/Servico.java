/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.sql.Time;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
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
    private Long id;
    
    private double valor;
    @Column(length = 255,name = "descricao")
    private String descricao;
    private Time horario_marcado;
    
    @OneToOne
    private Categoria categoriaServico;
    @OneToOne
    private Prestador prestador;
    @OneToOne
    private Solicitacao solicitacao;
    private Set atendimentos = new HashSet(0); //can be null :^]

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Time getHorario_marcado() {
        return horario_marcado;
    }

    public void setHorario_marcado(Time horario_marcado) {
        this.horario_marcado = horario_marcado;
    }

    public Categoria getCategoriaServico() {
        return categoriaServico;
    }

    public void setCategoriaServico(Categoria categoriaServico) {
        this.categoriaServico = categoriaServico;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public Set getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(Set atendimentos) {
        this.atendimentos = atendimentos;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.descricao);
        hash = 37 * hash + Objects.hashCode(this.horario_marcado);
        hash = 37 * hash + Objects.hashCode(this.categoriaServico);
        hash = 37 * hash + Objects.hashCode(this.prestador);
        hash = 37 * hash + Objects.hashCode(this.solicitacao);
        hash = 37 * hash + Objects.hashCode(this.atendimentos);
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
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.horario_marcado, other.horario_marcado)) {
            return false;
        }
        if (!Objects.equals(this.categoriaServico, other.categoriaServico)) {
            return false;
        }
        if (!Objects.equals(this.prestador, other.prestador)) {
            return false;
        }
        if (!Objects.equals(this.solicitacao, other.solicitacao)) {
            return false;
        }
        if (!Objects.equals(this.atendimentos, other.atendimentos)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "Servico{" + "id=" + id + ", valor=" + valor + ", descricao=" + descricao + ", horario_marcado=" + horario_marcado + ", categoriaServico=" + categoriaServico + ", prestador=" + prestador + ", solicitacao=" + solicitacao + ", atendimentos=" + atendimentos + '}';
    }
    
    
    
}
