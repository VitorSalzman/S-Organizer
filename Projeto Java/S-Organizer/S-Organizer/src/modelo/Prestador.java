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
    private HorarioTrabalho horasT;
    private long cpf;

   
    public Prestador(String nome,long cpf, long telefone, String empresaQueTrabalha,
            boolean disponibilidade, String usuario, String senha) {
        super(usuario, senha);
        this.setNome(nome);
        this.setTelefone(telefone);
        this.empresaQueTrabalha = empresaQueTrabalha;
        this.disponibilidade = disponibilidade;
        this.cpf = cpf;
    }
    public Prestador(String login, String senha){
        super(login, senha);
    }
    
     public HorarioTrabalho getHorasT() {
        return horasT;
    }

    public void setHorasT(HorarioTrabalho horasT) {
        this.horasT = horasT;
    }
    
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
