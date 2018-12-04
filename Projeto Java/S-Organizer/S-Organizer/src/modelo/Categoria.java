/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MUDANCA:
 * Foi inserido um tempo base para execucao de cata tipo de servico
 * dessa forma podemos calcular quantos servicos conseguimos colocar
 * dentro de uma agenda.
 * 
 * Isso é uma tabela agora ou seja não é ENUM
 */
@Entity
@Table(name="CategoriaServico")
public class Categoria implements Serializable{
    //INSTALACAO("instalacao"),REPARO("reparo"),CONSTRUCAO("construcao"),LIMPEZA("limpeza"),ENTREGA("entrega"),BUSCA("busca");
    //são as categorias de serviço que irão ser salvas
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(length = 50, name= "Tipo")
    private String descricao;
    @Column(name="duracao")
    private Time duracao;

    Categoria(String descricao, Time duracao) {
        this.descricao = descricao;
        this.duracao = duracao;
    }

    public Categoria() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return "Categoria{" + "id=" + id + ", descricao=" + descricao + ", duracao=" + duracao + '}';
    }
    
}
