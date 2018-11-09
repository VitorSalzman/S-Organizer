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
import persistencia.Horario_trabalho;

/**
 *
 * @author luizg
 */
public class Horario_trabalhoJpaController implements Serializable {

    public Horario_trabalhoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Horario_trabalho horario_trabalho) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(horario_trabalho);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Horario_trabalho horario_trabalho) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            horario_trabalho = em.merge(horario_trabalho);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = horario_trabalho.getId();
                if (findHorario_trabalho(id) == null) {
                    throw new NonexistentEntityException("The horario_trabalho with id " + id + " no longer exists.");
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
            Horario_trabalho horario_trabalho;
            try {
                horario_trabalho = em.getReference(Horario_trabalho.class, id);
                horario_trabalho.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The horario_trabalho with id " + id + " no longer exists.", enfe);
            }
            em.remove(horario_trabalho);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Horario_trabalho> findHorario_trabalhoEntities() {
        return findHorario_trabalhoEntities(true, -1, -1);
    }

    public List<Horario_trabalho> findHorario_trabalhoEntities(int maxResults, int firstResult) {
        return findHorario_trabalhoEntities(false, maxResults, firstResult);
    }

    private List<Horario_trabalho> findHorario_trabalhoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Horario_trabalho.class));
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

    public Horario_trabalho findHorario_trabalho(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Horario_trabalho.class, id);
        } finally {
            em.close();
        }
    }

    public int getHorario_trabalhoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Horario_trabalho> rt = cq.from(Horario_trabalho.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
