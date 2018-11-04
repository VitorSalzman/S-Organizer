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
   private long CNPJ;

    public void setCNPJ(long CNPJ) {
        this.CNPJ = CNPJ;
    }

    public long getCNPJ() {
        return CNPJ;
    }
    
    
}
