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
import modelo.Empresa;

/**
 *
 * @author helle
 */
public class DAOEmpresa extends AGenericDAOImpl<Empresa> implements IEmpresaDAO {

    private FabricManager fm = new FabricManager();
    
    public DAOEmpresa(Class<Empresa> classe) {
        super(classe);
    }
    
    public DAOEmpresa() {
        super(Empresa.class);
    }

    @Override
    public int getClassCount() {
        EntityManager em = fm.getFabricManager();
        
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empresa> rt = cq.from(Empresa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();   
        } finally {
            em.close();
        }
    }
    
}
