/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * MUDANCA:
 * Foi inserido um tempo base para execucao de cata tipo de servico
 * dessa forma podemos calcular quantos servicos conseguimos coloca
 * dentro de uma agenda.
 */
public enum Categoria {
    INSTALACAO("instalacao"),REPARO("reparo"),CONSTRUCAO("construcao"),LIMPEZA("limpeza"),ENTREGA("entrega"),BUSCA("busca");
    
    private String descricao;
    private int duracao;

    Categoria(String descricao, int duracao) {
        this.descricao = descricao;
        this.duracao = duracao;
    }

    Categoria(String category){
        this.descricao=category;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String category) {
        this.descricao=category;
    }
    
    
}
