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
    private boolean controle;
    private int CNPJ;

    public void setControle(boolean controle) {
        this.controle = controle;
    }

    public void setCNPJ(int CNPJ) {
        this.CNPJ = CNPJ;
    }

    public boolean isControle() {
        return controle;
    }

    public int getCNPJ() {
        return CNPJ;
    }
    
    
}
