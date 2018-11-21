/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Time;


public class Servico {
    private long id;
    
    private String descricao;
    private double valor;
    private Time horarioMarcado;
    private boolean estadoAtendido;
    private Double multa;
    
    private Atendimento atendimento;
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
        
        //this.categoria =  Categoria.valueOf(category);     Em manutenção
        if(category.equalsIgnoreCase("limpeza")){
            this.categoria = Categoria.LIMPEZA;
        }
       
        else if(category.equalsIgnoreCase("instalacao")){
            this.categoria = Categoria.INSTALACAO;
        }
        
        else if(category.equalsIgnoreCase("REPARO")){
            this.categoria = Categoria.REPARO;
        }
        
        else if(category.equalsIgnoreCase("construcao")){
            this.categoria = Categoria.CONSTRUCAO;
        }
        
        else if(category.equalsIgnoreCase("entrega")){
            this.categoria = Categoria.ENTREGA;
        }
        
        else if(category.equalsIgnoreCase("busca")){
            this.categoria = Categoria.BUSCA;
        }
        
        
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

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    @Override
    public String toString() {
        return "Servico{" + "descricao=" + descricao + ", valor=" + valor + ", horarioMarcado=" + horarioMarcado + ", estadoAtendido=" + estadoAtendido + ", multa=" + multa + '}';
    }
    
    
    
    
}
