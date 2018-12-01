/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Empresa extends Acesso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_Empresa")
    private long id;
    
    @Column(length = 20,name = "cnpj")
    private String cnpj;
    
    @OneToMany
    private List<Solicitacao> solicitacaoes = new ArrayList(); //tipo da lista SOLICITACAO 
    @OneToMany
    private List<Prestador> prestadores = new ArrayList(); //tipo da lista PRESTADOR
    
    public Empresa(String cnpj, String usuario, String senha, String nome, String telefone) {
        super(usuario, senha, nome, telefone);
        this.cnpj = cnpj;
    }
    
    public Empresa(){
    } 

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return super.toString()+"Empresa{" + "id=" + id + ", cnpj=" + cnpj + '}';
        
    }
    
    
}
