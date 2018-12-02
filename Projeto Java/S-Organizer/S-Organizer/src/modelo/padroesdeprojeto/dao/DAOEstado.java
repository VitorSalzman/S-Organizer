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
import modelo.Estado;

/**
 *
 * @author helle
 */
public class DAOEstado extends AGenericDAOImpl<Estado> implements IEstadoDAO{

    private FabricManager fm = new FabricManager();
    
    public DAOEstado(Class<Estado> classe) {
        super(classe);
    }
    
    public DAOEstado() {
        super(Estado.class);
    }

    @Override
    public int getClassCount() {
        EntityManager em = fm.getFabricManager();
        
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estado> rt = cq.from(Estado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
