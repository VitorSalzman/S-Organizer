/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.dao;

import modelo.padroesdeprojeto.dao.interfaces.IServicoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Servico;

/**
 * DAO<nomedaclasse> herda os métodos implementados 
 * e implementa os métodos particulares a ele
 * @author helle
 */
public class DAOServico extends AGenericDAOImpl<Servico> implements IServicoDAO {

    private FabricManager fm = new FabricManager();
    
    public DAOServico() {
        super(Servico.class);
    }

    public DAOServico(Class<Servico> classe) {
        super(classe);
    }
    
    
    
    @Override
    public int getClassCount() {
        
        EntityManager em = fm.getFabricManager();
        
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Servico> rt = cq.from(Servico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();   
        } finally {
            em.close();
        }
    }

}
