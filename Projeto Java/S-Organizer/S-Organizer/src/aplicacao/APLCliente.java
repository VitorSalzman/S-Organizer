/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.ControladoresJPA.SolicitacaoJpaController;
import modelo.Solicitacao;

/**
 *
 * @author vitorsalzman
 */
public class APLCliente {
    public Solicitacao consultaSolicitacao(long protocolo){
        //public Solicitacao consultaSolicitacao(double protocolo){   ///Na verdade é esse
        
        EntityManagerFactory objFactory = Persistence.createEntityManagerFactory("S-Organizer2PU");
        EntityManager manager = objFactory.createEntityManager();
        
        SolicitacaoJpaController solicitacaoJpaController = new SolicitacaoJpaController(objFactory);
        
        return solicitacaoJpaController.findSolicitacao(protocolo);
        
        //Aqui é uma busca no bd por uma solicitacao com um protocolo igual ao passado por parametro; 
    }
}
