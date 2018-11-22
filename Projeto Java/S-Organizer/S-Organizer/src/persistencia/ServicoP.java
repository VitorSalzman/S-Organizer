/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
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
@Table(name="Servico")
public class ServicoP implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(length = 255,name="descricao")
    private String descricao;
    @Column(name="horarioMarcado")
    private Time horarioMarcado;
    @Column(name="valor")
    private double valor;
    @Column(name="multa")
    private double multa;
    @Column(name="estadoAtendido")
    private boolean estadoAtendido;
    
    @OneToOne
    private CategoriaServicoP categoriaServico;
    @OneToMany
    private List<AtendimentoP> atendimento = new ArrayList();

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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public boolean isEstadoAtendido() {
        return estadoAtendido;
    }

    public void setEstadoAtendido(boolean estadoAtendido) {
        this.estadoAtendido = estadoAtendido;
    }

    public CategoriaServicoP getCategoriaServico() {
        return categoriaServico;
    }

    public void setCategoriaServico(CategoriaServicoP categoriaServico) {
        this.categoriaServico = categoriaServico;
    }

    public List<AtendimentoP> getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(List<AtendimentoP> atendimento) {
        this.atendimento = atendimento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 31 * hash + Objects.hashCode(this.descricao);
        hash = 31 * hash + Objects.hashCode(this.horarioMarcado);
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.multa) ^ (Double.doubleToLongBits(this.multa) >>> 32));
        hash = 31 * hash + (this.estadoAtendido ? 1 : 0);
        hash = 31 * hash + Objects.hashCode(this.categoriaServico);
        hash = 31 * hash + Objects.hashCode(this.atendimento);
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
        final ServicoP other = (ServicoP) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (Double.doubleToLongBits(this.multa) != Double.doubleToLongBits(other.multa)) {
            return false;
        }
        if (this.estadoAtendido != other.estadoAtendido) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.horarioMarcado, other.horarioMarcado)) {
            return false;
        }
        if (!Objects.equals(this.categoriaServico, other.categoriaServico)) {
            return false;
        }
        if (!Objects.equals(this.atendimento, other.atendimento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servico{" + "id=" + id + ", descricao=" + descricao + ", horarioMarcado=" + horarioMarcado + ", valor=" + valor + ", multa=" + multa + ", estadoAtendido=" + estadoAtendido + ", categoriaServico=" + categoriaServico + ", atendimento=" + atendimento + '}';
    }


}
