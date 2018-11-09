/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.ControladorJPA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import persistencia.ControladorJPA.exceptions.NonexistentEntityException;
import persistencia.Estado_sol;

/**
 *
 * @author luizg
 */
public class Estado_solJpaController implements Serializable {

    public Estado_solJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Estado_sol estado_sol) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(estado_sol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Estado_sol estado_sol) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            estado_sol = em.merge(estado_sol);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = estado_sol.getId();
                if (findEstado_sol(id) == null) {
                    throw new NonexistentEntityException("The estado_sol with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estado_sol estado_sol;
            try {
                estado_sol = em.getReference(Estado_sol.class, id);
                estado_sol.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estado_sol with id " + id + " no longer exists.", enfe);
            }
            em.remove(estado_sol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estado_sol> findEstado_solEntities() {
        return findEstado_solEntities(true, -1, -1);
    }

    public List<Estado_sol> findEstado_solEntities(int maxResults, int firstResult) {
        return findEstado_solEntities(false, maxResults, firstResult);
    }

    private List<Estado_sol> findEstado_solEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Estado_sol.class));
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

    public Estado_sol findEstado_sol(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estado_sol.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstado_solCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estado_sol> rt = cq.from(Estado_sol.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
