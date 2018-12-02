/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.dao;

import modelo.padroesdeprojeto.dao.interfaces.ISolicitacaoDAO;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import modelo.Solicitacao;

/**
 * DAO<nomedaclasse> herda os métodos implementados 
 * e implementa os métodos particulares a ele
 * @author helle
 */
public class DAOSolicitacao extends AGenericDAOImpl<Solicitacao> implements ISolicitacaoDAO{

    private FabricManager fm = new FabricManager();
    
    public DAOSolicitacao(Class<Solicitacao> classe) {
        super(classe);
    }
    
    public DAOSolicitacao() {
        super(Solicitacao.class);
    }

    @Override
    public int getClassCount() {

        EntityManager em = fm.getFabricManager();
        
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Solicitacao> rt = cq.from(Solicitacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();   
        } finally {
            em.close();
        }
        
        
    }
    
}
