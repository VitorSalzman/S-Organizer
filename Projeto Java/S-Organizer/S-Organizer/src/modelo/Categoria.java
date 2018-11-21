/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Time;

/**
 * MUDANCA:
 * Foi inserido um tempo base para execucao de cata tipo de servico
 * dessa forma podemos calcular quantos servicos conseguimos coloca
 * dentro de uma agenda.
 */
public enum Categoria {//não sei como funciona para adicionar um novo campo.
    INSTALACAO("instalacao"),REPARO("reparo"),CONSTRUCAO("construcao"),LIMPEZA("limpeza"),ENTREGA("entrega"),BUSCA("busca");
    
    private String descricao;
    private Time duracao;

    Categoria(String descricao, Time duracao) {
        this.descricao = descricao;
        this.duracao = duracao;
    }

    Categoria(String category){
        this.descricao=category;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Time getDuracao() {
        return duracao;
    }

    public void setDuracao(Time duracao) {
        this.duracao = duracao;
    }

    
    @Override
    public String toString() {
        return "Categoria{" + "descricao=" + descricao + ", duracao=" + duracao + '}';
    }
    
}
