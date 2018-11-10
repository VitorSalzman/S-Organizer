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
import persistencia.HorarioTrabalho;

/**
 *
 * @author luizg
 */
public class HorarioTrabalhoJpaController implements Serializable {

    public HorarioTrabalhoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HorarioTrabalho horarioTrabalho) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(horarioTrabalho);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HorarioTrabalho horarioTrabalho) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            horarioTrabalho = em.merge(horarioTrabalho);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = horarioTrabalho.getId();
                if (findHorarioTrabalho(id) == null) {
                    throw new NonexistentEntityException("The horarioTrabalho with id " + id + " no longer exists.");
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
            HorarioTrabalho horarioTrabalho;
            try {
                horarioTrabalho = em.getReference(HorarioTrabalho.class, id);
                horarioTrabalho.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The horarioTrabalho with id " + id + " no longer exists.", enfe);
            }
            em.remove(horarioTrabalho);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HorarioTrabalho> findHorarioTrabalhoEntities() {
        return findHorarioTrabalhoEntities(true, -1, -1);
    }

    public List<HorarioTrabalho> findHorarioTrabalhoEntities(int maxResults, int firstResult) {
        return findHorarioTrabalhoEntities(false, maxResults, firstResult);
    }

    private List<HorarioTrabalho> findHorarioTrabalhoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HorarioTrabalho.class));
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

    public HorarioTrabalho findHorarioTrabalho(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HorarioTrabalho.class, id);
        } finally {
            em.close();
        }
    }

    public int getHorarioTrabalhoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HorarioTrabalho> rt = cq.from(HorarioTrabalho.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
