/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Time;

/**
 *
 * @author 20161bsi0403
 */
public class Servico {
    private long id;
    private Categoria categoria;
    private String descricao;
    private double valor;
    private Time horarioMarcado;
    private EstadoSolicitacao estado;
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

    public void setCategoria(String category) {
        this.categoria.setDescricao(category);
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
  
    
}
