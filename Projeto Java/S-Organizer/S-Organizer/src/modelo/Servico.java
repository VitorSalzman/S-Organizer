/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


public class Servico {
    private long id;
    
    private String descricao;
    private double valor;
    private Time horarioMarcado;
    private boolean estadoAtendido;
    private Double multa;
    private List<Atendimento> atendimento = new ArrayList();
    private Categoria categoria;

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
    
    public void setCategoria(String category) throws Exception{
        this.categoria =  Categoria.valueOf(category);
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public double getValor() {
        return valor;
    }

    public Time getHorarioMarcado() {
        return horarioMarcado;
    }

    public void setHorarioMarcado(Time horarioMarcado) {
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
        return "Servico{" + "id=" + id + ", descricao=" + descricao + 
                ", valor=" + valor + ", horarioMarcado=" + horarioMarcado + 
                ", estadoAtendido=" + estadoAtendido + ", multa=" + multa + '}';
    }
}
