/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
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
@Table(name="Servico")
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(length = 255,name="descricao")
    private String descricao;
    @Column(name="horarioMarcado")
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horarioMarcado;
    @Column(name="valor")
    private double valor;
    @Column(name="multa")
    private double multa;
    @Column(name="estadoAtendido")
    private boolean estadoAtendido;
    
    @OneToOne
    private Categoria categoria;
    @OneToMany
    private List<Atendimento> atendimento = new ArrayList();

    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public double getValor() {
        return valor;
    }

    public Date getHorarioMarcado() {
        return horarioMarcado;
    }

    public void setHorarioMarcado(Date horarioMarcado) {
        this.horarioMarcado = horarioMarcado;
    }

    public boolean isEstado() {
        return estadoAtendido;
    }

    public void setEstado(boolean estado) {
        this.estadoAtendido = estado;
    }

    public boolean isEstadoAtendido() {
        return estadoAtendido;
    }

    public void setEstadoAtendido(boolean estadoAtendido) {
        this.estadoAtendido = estadoAtendido;
    }

    public Double getMulta() {
        return multa;
    }

    public void setMulta(Double multa) {
        this.multa = multa;
    }
    
    public void aplicaMulta(){
        setMulta(this.valor*0.1);
    }
    
    public void addAtendimento(Atendimento atendimento) {
        this.atendimento.add(atendimento);
    }
    
    public void printAtendimento() {
        for( Atendimento a : atendimento ) {
            System.out.println(a.toString());
        }
    }
    
    public List<Atendimento> getAtendimentos() {
        return atendimento;
    }

    public void setAtendimento(List<Atendimento> atendimento) {
        this.atendimento = atendimento;
    }

    @Override
    public String toString() {
        String servico = "Servico{" + "id=" + id + ", descricao=" + descricao + 
                ", valor=" + valor + ", horarioMarcado=" + horarioMarcado;
                if(estadoAtendido){
                    servico+= ", estadoAtendido= ATENDIDO";
                }else{
                   servico+= ", estadoAtendido= NÃO ATENDIDO,"+" multa=" + multa + '}';
                }
        return servico;
    }
}
