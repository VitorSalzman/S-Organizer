/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class Logradouro {
    
    private String nome;
    
    private Bairro bairro;

    public Logradouro(String nome, Bairro bairro) {
        this.nome = nome;
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

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    
    
    
    
}
