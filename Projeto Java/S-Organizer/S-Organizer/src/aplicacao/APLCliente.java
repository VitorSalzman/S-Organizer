/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Solicitacao;
import modelo.padroesdeprojeto.dao.DAOSolicitacao;

/**
 *
 * @author vitorsalzman
 */
public class APLCliente {
    public Solicitacao consultaSolicitacao(long protocolo){
        DAOSolicitacao daoSolicitacao = new DAOSolicitacao();
        
        return daoSolicitacao.obterPorId(protocolo);
        
        //Aqui é uma busca no bd por uma solicitacao com um protocolo igual ao passado por parametro; 
    }
}
