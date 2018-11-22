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
import persistencia.AgendaP;
import persistencia.ControladoresJPA.exceptions.NonexistentEntityException;

/**
 *
 * @author luizg
 */
public class AgendaJpaController implements Serializable {

    public AgendaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AgendaP agenda) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(agenda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AgendaP agenda) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            agenda = em.merge(agenda);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = agenda.getId();
                if (findAgenda(id) == null) {
                    throw new NonexistentEntityException("The agenda with id " + id + " no longer exists.");
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
            AgendaP agenda;
            try {
                agenda = em.getReference(AgendaP.class, id);
                agenda.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The agenda with id " + id + " no longer exists.", enfe);
            }
            em.remove(agenda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AgendaP> findAgendaEntities() {
        return findAgendaEntities(true, -1, -1);
    }

    public List<AgendaP> findAgendaEntities(int maxResults, int firstResult) {
        return findAgendaEntities(false, maxResults, firstResult);
    }

    private List<AgendaP> findAgendaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AgendaP.class));
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

    public AgendaP findAgenda(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AgendaP.class, id);
        } finally {
            em.close();
        }
    }

    public int getAgendaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AgendaP> rt = cq.from(AgendaP.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
