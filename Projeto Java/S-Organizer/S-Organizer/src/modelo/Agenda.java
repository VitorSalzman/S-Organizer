/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;


/**
 * FICOU DEFINIDO QUE: 
 * Agenda é uma classe que será instanciada pelo adm,
 * o construtor deve capturar os valores do dia válido da agenda,
 * intancia de agenda comportará Servicos de Solicitacoes,
 * a instancia de Agenda completamente preenchida é entregue para um Prestador
 * 
 * RN:
 * 01 Cliente pagará multa caso não cumpra com o horário marcado.
 * 02 Se os SERVICOS da AGENDA não representarem 8 horas exatas,
 *    o tempo restante o PRESTADOR ficará (DISPONÍVEL OU EXPEDIENTE ENCERRADO)??
 */
@Entity
@Table(name ="Agenda")
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat sdfHora = new SimpleDateFormat("hh:mm:ss");// espero que esses campos não sejam persistidos <<
    @Column(name = "horaInicio")
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaInicioExpediente;
    @Column(name = "horaFim")
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaFimExpediente;
    @Column(name = "data")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    
    @OneToMany
    private List<Solicitacao> solicitacaoDoDia = new ArrayList();
    @OneToOne
    private Empresa empresa;
    @OneToOne
    private Prestador prestador;
        
    
    public Agenda(Prestador prestador) {
        this.prestador = prestador;
        this.data = new Date();
        /*
        Necessario checar se funciona para o último dia do mes,
        se nao, mudaremos para Calendar OU a Agenda será construida
        no mesmo dia que o Prestador atenderá ela.
        */
        data.setDate(data.getDate()+1);
        
    }
    
    public Agenda() { //espero que ele não reclame desse construtor, pq ele precisa sempre de um construtor vazio
        this.data = new Date();
        data.setDate(data.getDate()+1);
    }
    
    

    public SimpleDateFormat getSdfData() {
        return sdfData;
    }

    public void setSdfData(SimpleDateFormat sdfData) {
        this.sdfData = sdfData;
    }

    public SimpleDateFormat getSdfHora() {
        return sdfHora;
    }

    public void setSdfHora(SimpleDateFormat sdfHora) {
        this.sdfHora = sdfHora;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHoraInicioExpediente() {
        return horaInicioExpediente;
    }

    public void setHoraInicioExpediente(Date horaInicioExpediente) {
        this.horaInicioExpediente = horaInicioExpediente;
    }

    public Date getHoraFimExpediente() {
        return horaFimExpediente;
    }

    public void setHoraFimExpediente(Date horaFimExpediente) {
        this.horaFimExpediente = horaFimExpediente;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Solicitacao> getSolicitacaoDoDia() {
        return solicitacaoDoDia;
    }

    public void setSolicitacaoDoDia(List<Solicitacao> solicitacaoDoDia) {
        this.solicitacaoDoDia = solicitacaoDoDia;
    }

    
    
    /* Funcoes manual */ 
    public List<Solicitacao> getServicosDoDia() {
        return solicitacaoDoDia;
    }

    public void setServicosDoDia(Solicitacao service) {
        solicitacaoDoDia.add(service);
    }
    
    public void printServicosDoDia() {
        for( Solicitacao Solicitacao : solicitacaoDoDia ) { // acho melhor usar o toString aq
            Solicitacao.toString();
        }
    }
    
    /*
    esse metodo deve percorrer a lista de servicos verificando o
    horario mais cedo marcado e o horário mais tarde marcado,
    o horario mais tarde deve somar a duracao base da categoria
    para determinar o horarioFimExpediente.
    */
    /*public int calculaInicioExpediente() {
    
    }*/

    public void add(Agenda agenda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 13 * hash + Objects.hashCode(this.sdfData);
        hash = 13 * hash + Objects.hashCode(this.sdfHora);
        hash = 13 * hash + Objects.hashCode(this.horaInicioExpediente);
        hash = 13 * hash + Objects.hashCode(this.horaFimExpediente);
        hash = 13 * hash + Objects.hashCode(this.data);
        hash = 13 * hash + Objects.hashCode(this.solicitacaoDoDia);
        hash = 13 * hash + Objects.hashCode(this.prestador);
        hash = 13 * hash + Objects.hashCode(this.empresa);
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
        final Agenda other = (Agenda) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.sdfData, other.sdfData)) {
            return false;
        }
        if (!Objects.equals(this.sdfHora, other.sdfHora)) {
            return false;
        }
        if (!Objects.equals(this.horaInicioExpediente, other.horaInicioExpediente)) {
            return false;
        }
        if (!Objects.equals(this.horaFimExpediente, other.horaFimExpediente)) {
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
    
}

//
//    fazer builder de agenda
    
