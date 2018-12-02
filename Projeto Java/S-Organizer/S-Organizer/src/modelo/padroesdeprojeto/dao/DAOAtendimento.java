/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Atendimento;

/**
 *
 * @author helle
 */
public class DAOAtendimento extends AGenericDAOImpl<Atendimento> implements IAtendimentoDAO{
    
    private FabricManager fm = new FabricManager();    

    public DAOAtendimento(Class<Atendimento> classe) {
        super(classe);
    }
    
    public DAOAtendimento() {
        super(Atendimento.class);
    }

    @Override
    public int getClassCount() {
        
        EntityManager em = fm.getFabricManager();
        
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Atendimento> rt = cq.from(Atendimento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
