/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;


@Entity
@Table(name="Solicitacao")
public class Solicitacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "protocolo")
    private long protocolo; //Protocolo, precisamos customizar o GenerationType, isso seria um singleton, correto?
    
    
    @Column(name="dispCliIni")
    @Temporal(javax.persistence.TemporalType.TIME)// ir apenas o TIME
    private Calendar dispCliIni;
    @Column(name="dispCliFim")
    @Temporal(javax.persistence.TemporalType.TIME)
    private Calendar dispCliFim;
    @Column(length = 255,name="observacao")
    private String observacao;
    @Column(name="dataSolicitacao")
    @Temporal(javax.persistence.TemporalType.DATE)// ir apenas o DATE
    private Calendar dataSolicitacao;
    @Column(name="multaTotal")
    private Double multaTotal;
    
    
    private EstadoSolicitacao estado;
    
    @OneToOne
    private Endereco endereco;
    @OneToMany
    private List<Servico> servicos = new ArrayList();

    public Solicitacao() {
        this.multaTotal = 0.0;
    }
   
    public String getObservacao() {
        return observacao;
    }
    
    public EstadoSolicitacao getEstado() {
        return estado;
    }
    
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public void setEstado(EstadoSolicitacao estado) {
        this.estado = estado;
    }
  
    public List<Servico> getServicos() {
        return servicos;
    }

    public long getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(long protocolo) {
        this.protocolo = protocolo;
    }

    public Calendar getDispCliIni() {
        return dispCliIni;
    }

    public void setDispCliIni(Calendar dispCliIni) {
        this.dispCliIni = dispCliIni;
    }

    public Calendar getDispCliFim() {
        return dispCliFim;
    }

    public void setDispCliFim(Calendar dispCliFim) {
        this.dispCliFim = dispCliFim;
    }

    public Calendar getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Calendar dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
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

    public void addServico(Servico servico) {
        this.servicos.add(servico);
    }
    
    public void removeServico(Servico servico){
        this.servicos.remove(servico);
    }
    
    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }

    public void printServicos() {
        for( Servico service : servicos ) {
            System.out.println(service.toString());
        }
    }
    
    public double calculaMultaTotal(){
        for(Servico s: servicos){
            multaTotal+= s.getMulta();
        }
        return multaTotal;
    }
    
    
}
