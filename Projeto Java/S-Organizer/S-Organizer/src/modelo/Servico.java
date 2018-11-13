/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Time;

public class Servico {
    private long id;
    private Categoria categoria;
    private String descricao;
    private double valor;
    private Time horarioMarcado;
    private boolean estado;
    private Atendimento atendimento;

    public long getId() {
        return id;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCategoria(String category) throws Exception{
        this.categoria =  Categoria.valueOf(category);
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }

    public Time getHorarioMarcado() {
        return horarioMarcado;
    }

    public void setHorarioMarcado(Time horarioMarcado) {
        this.horarioMarcado = horarioMarcado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }
    
    
  
    
}
