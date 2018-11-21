/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;


public class Cliente extends Usuario{
       private long cpf;
       
       List<Solicitacao> solicitacao = new ArrayList();

    public Cliente(long cpf, String nome, long telefone) {
        super(nome, telefone);
        this.cpf = cpf;
    }

    public Cliente (){
    }
      
    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    
    //manual
    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao.add(solicitacao);
    }

    public void printSolicitacao() {
        for( Solicitacao solicitacao : solicitacao ) {
            solicitacao.toString();
        }
    }

    //não manual
    public List<Solicitacao> getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(List<Solicitacao> solicitacao) {
        this.solicitacao = solicitacao;
    }
    
    
    
    @Override
    public String toString() {
        return "Cliente{" + "cpf=" + cpf + ", solicitacao=" + solicitacao + '}';
    }
    
    
    
}
