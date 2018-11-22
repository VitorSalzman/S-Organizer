/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.ControladoresJPA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import persistencia.BairroP;
import persistencia.ControladoresJPA.exceptions.NonexistentEntityException;

/**
 *
 * @author luizg
 */
public class BairroJpaController implements Serializable {

    public BairroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BairroP bairro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bairro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BairroP bairro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bairro = em.merge(bairro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = bairro.getId();
                if (findBairro(id) == null) {
                    throw new NonexistentEntityException("The bairro with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BairroP bairro;
            try {
                bairro = em.getReference(BairroP.class, id);
                bairro.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bairro with id " + id + " no longer exists.", enfe);
            }
            em.remove(bairro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BairroP> findBairroEntities() {
        return findBairroEntities(true, -1, -1);
    }

    public List<BairroP> findBairroEntities(int maxResults, int firstResult) {
        return findBairroEntities(false, maxResults, firstResult);
    }

    private List<BairroP> findBairroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BairroP.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public BairroP findBairro(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BairroP.class, id);
        } finally {
            em.close();
        }
    }

    public int getBairroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BairroP> rt = cq.from(BairroP.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
