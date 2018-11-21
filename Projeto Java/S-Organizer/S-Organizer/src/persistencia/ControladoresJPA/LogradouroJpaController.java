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
import persistencia.ControladoresJPA.exceptions.NonexistentEntityException;
import persistencia.Logradouro;

/**
 *
 * @author luizg
 */
public class LogradouroJpaController implements Serializable {

    public LogradouroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Logradouro logradouro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(logradouro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Logradouro logradouro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            logradouro = em.merge(logradouro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = logradouro.getId();
                if (findLogradouro(id) == null) {
                    throw new NonexistentEntityException("The logradouro with id " + id + " no longer exists.");
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
            Logradouro logradouro;
            try {
                logradouro = em.getReference(Logradouro.class, id);
                logradouro.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The logradouro with id " + id + " no longer exists.", enfe);
            }
            em.remove(logradouro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Logradouro> findLogradouroEntities() {
        return findLogradouroEntities(true, -1, -1);
    }

    public List<Logradouro> findLogradouroEntities(int maxResults, int firstResult) {
        return findLogradouroEntities(false, maxResults, firstResult);
    }

    private List<Logradouro> findLogradouroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Logradouro.class));
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

    public Logradouro findLogradouro(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Logradouro.class, id);
        } finally {
            em.close();
        }
    }

    public int getLogradouroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Logradouro> rt = cq.from(Logradouro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
