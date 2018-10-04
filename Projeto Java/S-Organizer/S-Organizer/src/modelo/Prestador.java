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
public class Prestador extends Acesso{
    private String empresaQueTrabalha;
    private boolean disponibilidade;

    public String getEmpresaQueTrabalha() {
        return empresaQueTrabalha;
    }

    public boolean isDisponivel() {
        return disponibilidade;
    }

    public void setEmpresaQueTrabalha(String empresaQueTrabalha) {
        this.empresaQueTrabalha = empresaQueTrabalha;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    
    
}
