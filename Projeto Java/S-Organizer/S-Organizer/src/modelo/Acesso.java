/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Acesso extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_Acesso")
    private long id;
    
    @Column(length = 255,name="login")
    private String login;
    @Column(length = 255,name="senha")
    private String senha;
    
    public Acesso(String usuario, String senha, String nome, String telefone) {
        super(nome, telefone);
        this.login = usuario;
        try {
            this.setSenha(senha);   
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public Acesso(){
        
    }

    public void setSenha(String senha) throws Exception {
       if (!senha.equals("")){
           this.senha = senha;
       } else{
           throw new Exception ("Senha vazia");
       }
    }

    public String getSenha() {
        return senha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return super.toString()+ "Acesso{" + "id=" + id + ", login=" + login + ", senha=" + senha + '}';
    }

    
    
}
