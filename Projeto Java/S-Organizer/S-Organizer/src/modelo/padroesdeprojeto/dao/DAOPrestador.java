/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.dao;

import modelo.padroesdeprojeto.dao.interfaces.IPrestadorDAO;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Prestador;

/**
 * DAO<nomedaclasse> herda os métodos implementados 
 * e implementa os métodos particulares a ele
 * @author helle
 */
public class DAOPrestador extends AGenericDAOImpl<Prestador> implements IPrestadorDAO {

    private FabricManager fm = new FabricManager();
    
    public DAOPrestador(Class<Prestador> classe) {
        super(classe);
    }

    public DAOPrestador() {
        super(Prestador.class);
    }

    @Override
    public int getClassCount() {
        EntityManager em = fm.getFabricManager();
        
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Prestador> rt = cq.from(Prestador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
