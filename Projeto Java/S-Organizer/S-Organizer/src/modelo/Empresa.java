/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;


public class Empresa extends Acesso{
    
    private String cnpj;
    
    private List<Solicitacao> solicitacaoes = new ArrayList(); 
    private List<Prestador> prestadores = new ArrayList();
    
    public Empresa(String cnpj, String usuario, String senha, String nome, String telefone) {
        super(usuario, senha, nome, telefone);
        this.cnpj = cnpj;
    }
    
    public Empresa(){
    } 

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    //operação manual
    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacaoes.add(solicitacao);
    }
    
    public void setPrestador(Prestador prestador) {
        this.prestadores.add(prestador);
    }
    //não coloquei remoção manual

    //não manual, tive que por esse porque o builder utiliza dessa forma..

    
    public List<Solicitacao> getSolicitacaoes() {
        return solicitacaoes;
    }

    public void setSolicitacaoes(List<Solicitacao> solicitacaoes) {
        this.solicitacaoes = solicitacaoes;
    }

    public List<Prestador> getPrestadores() {
        return prestadores;
    }

    public void setPrestadores(List<Prestador> prestadores) {
        this.prestadores = prestadores;
    }

    
    public void printSolicitacao() {
        for( Object solicitacao : solicitacaoes ) {
            solicitacao.toString();
        }
    }
}
