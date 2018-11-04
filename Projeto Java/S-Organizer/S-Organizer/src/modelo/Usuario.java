/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 20161bsi0403
 */
public abstract class Usuario {
    private String nome;
    private long telefone;
    private int codigo;

    
    public Usuario(String nome, long telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    
}
