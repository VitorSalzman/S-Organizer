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
public class Cliente extends Usuario{
       private long cpf;

    public Cliente(long cpf, String nome, long telefone) {
        super(nome, telefone);
        this.cpf = cpf;
    }

    public Cliente (){
    }
      
    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
     
    
}
