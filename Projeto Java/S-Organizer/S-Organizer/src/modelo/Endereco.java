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
public class Endereco {
    private Logradouro logradouro;
    private Bairro bairro;
    private Estado estado;
    private int cep;

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public Estado getEstado() {
        return estado;
    }

    public int getCep() {
        return cep;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro; 
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }
    
    
    
}
