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
import persistencia.AtendimentoP;
import persistencia.ControladoresJPA.exceptions.NonexistentEntityException;

/**
 *
 * @author luizg
 */
public class AtendimentoJpaController implements Serializable {

    public AtendimentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AtendimentoP atendimento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(atendimento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AtendimentoP atendimento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            atendimento = em.merge(atendimento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = atendimento.getId();
                if (findAtendimento(id) == null) {
                    throw new NonexistentEntityException("The atendimento with id " + id + " no longer exists.");
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
            AtendimentoP atendimento;
            try {
                atendimento = em.getReference(AtendimentoP.class, id);
                atendimento.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The atendimento with id " + id + " no longer exists.", enfe);
            }
            em.remove(atendimento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AtendimentoP> findAtendimentoEntities() {
        return findAtendimentoEntities(true, -1, -1);
    }

    public List<AtendimentoP> findAtendimentoEntities(int maxResults, int firstResult) {
        return findAtendimentoEntities(false, maxResults, firstResult);
    }

    private List<AtendimentoP> findAtendimentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AtendimentoP.class));
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

    public AtendimentoP findAtendimento(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AtendimentoP.class, id);
        } finally {
            em.close();
        }
    }

    public int getAtendimentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AtendimentoP> rt = cq.from(AtendimentoP.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
