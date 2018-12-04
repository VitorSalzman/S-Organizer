/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.dao;

import modelo.padroesdeprojeto.dao.interfaces.IAcessoDAO;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Acesso;

/**
 * DAO<nomedaclasse> herda os métodos implementados 
 * e implementa os métodos particulares a ele
 * @author helle
 */
public class DAOAcesso extends AGenericDAOImpl<Acesso> implements IAcessoDAO{
    
    private FabricManager fm = new FabricManager();    

    public DAOAcesso(Class<Acesso> classe) {
        super(classe);
    }
    
    public DAOAcesso() {
        super(Acesso.class);
    }

    @Override
    public int getClassCount() {
        
        EntityManager em = fm.getFabricManager();
        
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Acesso> rt = cq.from(Acesso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
