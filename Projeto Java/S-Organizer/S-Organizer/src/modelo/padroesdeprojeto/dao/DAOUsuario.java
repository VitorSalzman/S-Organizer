/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.dao;

import modelo.padroesdeprojeto.dao.interfaces.IUsuarioDAO;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Usuario;

/**
 *
 * @author helle
 */
public class DAOUsuario extends AGenericDAOImpl<Usuario> implements IUsuarioDAO {

    private FabricManager fm = new FabricManager();
    
    public DAOUsuario(Class<Usuario> classe) {
        super(classe);
    }
    
    public DAOUsuario() {
        super(Usuario.class);
    }

    @Override
    public int getClassCount() {
        EntityManager em = fm.getFabricManager();
        
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
