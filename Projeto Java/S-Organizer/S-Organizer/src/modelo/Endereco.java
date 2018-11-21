/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class Endereco {

    private String cep;
    private String complemento;
    
    private Logradouro logradouro;

    public Endereco(Logradouro logradouro, String cep, String complemento) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.complemento = complemento;
    }

    public Endereco() {
    }
    

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    
}
