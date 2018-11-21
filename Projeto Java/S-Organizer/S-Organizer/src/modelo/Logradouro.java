/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class Logradouro {
    
    private String nome;
    private String abreviatura;
    
    private Bairro bairro;

    public Logradouro(String nome, String abreviatura, Bairro bairro) {
        this.nome = nome;
        this.abreviatura = abreviatura;
        this.bairro = bairro;
    }

    public Logradouro() {
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    
    
    
    
}
