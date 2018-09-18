/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s.organizer;

/**
 *
 * @author 20161bsi0403
 */
public class Endereco {
    private String rua;
    private String bairro;
    private String estado;
    private int cep;

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getEstado() {
        return estado;
    }

    public int getCep() {
        return cep;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }
    
    
    
}
