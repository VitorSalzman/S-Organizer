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
public abstract class Acesso extends Usuario {
    private String usuario;
    private String senha;

    public Acesso(String usuario, String senha, Long telefone, String nome) {
        super(nome,telefone);
        this.usuario = usuario;
        this.senha = senha;
        
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
    
    /* */ 
    
}
