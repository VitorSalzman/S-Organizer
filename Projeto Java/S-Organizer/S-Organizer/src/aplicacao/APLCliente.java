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
    /**
     * Busca a Solicitacao referente ao protocolo passado como parametro
     * @param protocolo
     * @return
     */
    public Solicitacao consultaSolicitacao(long protocolo){
        DAOSolicitacao daoSolicitacao = new DAOSolicitacao();
        
        return daoSolicitacao.obterPorId(protocolo); 
    }
}
