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
@Table(name ="Agenda")
public class AgendaP implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "horaInicio")
    private Time horaInicio;
    @Column(name = "horaFim")
    private Time horaFim;
    @Column(name = "data")
    private Date data;
    
    @OneToMany
    private List<SolicitacaoP> solicitacaoDoDia = new ArrayList();
    @OneToOne
    private PrestadorP prestador;
    @OneToOne
    private EmpresaP empresa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Time horaFim) {
        this.horaFim = horaFim;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<SolicitacaoP> getSolicitacaoDoDia() {
        return solicitacaoDoDia;
    }

    public void setSolicitacaoDoDia(List<SolicitacaoP> solicitacaoDoDia) {
        this.solicitacaoDoDia = solicitacaoDoDia;
    }

    public PrestadorP getPrestador() {
        return prestador;
    }

    public void setPrestador(PrestadorP prestador) {
        this.prestador = prestador;
    }

    public EmpresaP getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaP empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + Objects.hashCode(this.horaInicio);
        hash = 53 * hash + Objects.hashCode(this.horaFim);
        hash = 53 * hash + Objects.hashCode(this.data);
        hash = 53 * hash + Objects.hashCode(this.solicitacaoDoDia);
        hash = 53 * hash + Objects.hashCode(this.prestador);
        hash = 53 * hash + Objects.hashCode(this.empresa);
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
        final AgendaP other = (AgendaP) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.horaInicio, other.horaInicio)) {
            return false;
        }
        if (!Objects.equals(this.horaFim, other.horaFim)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.solicitacaoDoDia, other.solicitacaoDoDia)) {
            return false;
        }
        if (!Objects.equals(this.prestador, other.prestador)) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Agenda{" + "id=" + id + ", horaInicio=" + horaInicio + ", horaFim=" + horaFim + ", data=" + data + '}';
    }

    
    
    }
