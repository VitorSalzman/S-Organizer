/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public abstract class Acesso extends Usuario {
    private String usuario;
    private String senha;

 
    public Acesso(String usuario, String senha, String nome, long telefone) {
        super(nome, telefone);
        this.usuario = usuario;
        try {
            this.setSenha(senha);   
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    
    public Acesso(){
        
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) throws Exception {
       if (!senha.equals("")){
           this.senha = senha;
       } else{
           throw new Exception ("Senha vazia");
       }
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
    
    /* */ 
    
}
