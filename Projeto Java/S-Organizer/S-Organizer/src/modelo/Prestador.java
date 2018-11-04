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

    public Prestador(String empresaQueTrabalha, boolean disponibilidade, long cpf, String usuario, String senha, Long telefone, String nome) {
        super(usuario, senha, telefone, nome);
        this.empresaQueTrabalha = empresaQueTrabalha;
        this.disponibilidade = disponibilidade;
        this.cpf = cpf;
    }
    private String empresaQueTrabalha;
    private boolean disponibilidade;
    private long cpf;
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

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    
    
    
}
