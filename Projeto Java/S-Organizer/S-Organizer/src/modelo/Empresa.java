/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Empresa extends Acesso{
    private long cnpj;
    
    public Empresa (String nome, long telefone, long cnpj, String login, String senha){
        super(login,senha);
        this.setNome(nome);
        this.setTelefone(telefone);
        this.cnpj = cnpj;
        
    }
    
    public Empresa(){} 
    
    public void setCNPJ(long CNPJ) {
        this.cnpj = CNPJ;
    }

    public long getCNPJ() {
        return cnpj;
    }
    
    
}
