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
import javax.swing.JOptionPane;
import modelo.padroesdeprojeto.observer.Observador;
import modelo.padroesdeprojeto.observer.Observavel;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Cliente extends Usuario implements Serializable, Observador {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_Cliente")
    private long id;
     
    @Column(length = 20,name = "cpf")
    private String cpf;
       
    @OneToMany
    private List<Solicitacao> solicitacao = new ArrayList();

    public Cliente(String cpf, String nome, String telefone) {
        super(nome, telefone);
        this.cpf = cpf;
    }

    public Cliente (){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
      
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
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
    
    
    //manual
    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao.add(solicitacao);
    }

    public void printSolicitacao() {
        for( Solicitacao s : solicitacao ) {
            s.toString();
        }
    }
    
    /* MÉTODOS UTILIZADOS NO PADRAO DE PROJETO OBSERVER  */ 

    @Override
    public void update(Observavel ob) {
        //ToDo -> NOTIFICACAO SMS
        Solicitacao solicitacao1 = (Solicitacao)ob;
        JOptionPane.showMessageDialog(null,"Prezado, sua solicitação foi atualizada! Estado: " + solicitacao1.getEstado().toString());
    }    
    
}
