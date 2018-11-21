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
public class Empresa extends Acesso{
    
    private long cnpj;
    private  boolean temControle;
    
    public Empresa(long cnpj, String usuario, String senha, String nome, long telefone) {
        super(usuario, senha, nome, telefone);
        this.cnpj = cnpj;
    }
    
    public Empresa(){
    } 

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public boolean isTemControle() {
        return temControle;
    }

    public void setTemControle(boolean temControle) {
        this.temControle = temControle;
    }

}
