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
import persistencia.CategoriaServicoP;
import persistencia.ControladoresJPA.exceptions.NonexistentEntityException;

/**
 *
 * @author luizg
 */
public class CategoriaServicoJpaController implements Serializable {

    public CategoriaServicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CategoriaServicoP categoriaServico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(categoriaServico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CategoriaServicoP categoriaServico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            categoriaServico = em.merge(categoriaServico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = categoriaServico.getId();
                if (findCategoriaServico(id) == null) {
                    throw new NonexistentEntityException("The categoriaServico with id " + id + " no longer exists.");
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
            CategoriaServicoP categoriaServico;
            try {
                categoriaServico = em.getReference(CategoriaServicoP.class, id);
                categoriaServico.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The categoriaServico with id " + id + " no longer exists.", enfe);
            }
            em.remove(categoriaServico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CategoriaServicoP> findCategoriaServicoEntities() {
        return findCategoriaServicoEntities(true, -1, -1);
    }

    public List<CategoriaServicoP> findCategoriaServicoEntities(int maxResults, int firstResult) {
        return findCategoriaServicoEntities(false, maxResults, firstResult);
    }

    private List<CategoriaServicoP> findCategoriaServicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CategoriaServicoP.class));
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

    public CategoriaServicoP findCategoriaServico(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CategoriaServicoP.class, id);
        } finally {
            em.close();
        }
    }

    public int getCategoriaServicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CategoriaServicoP> rt = cq.from(CategoriaServicoP.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
