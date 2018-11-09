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
import persistencia.Categoria_servico;
import persistencia.ControladorJPA.exceptions.NonexistentEntityException;

/**
 *
 * @author luizg
 */
public class Categoria_servicoJpaController implements Serializable {

    public Categoria_servicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Categoria_servico categoria_servico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(categoria_servico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Categoria_servico categoria_servico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            categoria_servico = em.merge(categoria_servico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = categoria_servico.getId();
                if (findCategoria_servico(id) == null) {
                    throw new NonexistentEntityException("The categoria_servico with id " + id + " no longer exists.");
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
            Categoria_servico categoria_servico;
            try {
                categoria_servico = em.getReference(Categoria_servico.class, id);
                categoria_servico.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The categoria_servico with id " + id + " no longer exists.", enfe);
            }
            em.remove(categoria_servico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Categoria_servico> findCategoria_servicoEntities() {
        return findCategoria_servicoEntities(true, -1, -1);
    }

    public List<Categoria_servico> findCategoria_servicoEntities(int maxResults, int firstResult) {
        return findCategoria_servicoEntities(false, maxResults, firstResult);
    }

    private List<Categoria_servico> findCategoria_servicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Categoria_servico.class));
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

    public Categoria_servico findCategoria_servico(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Categoria_servico.class, id);
        } finally {
            em.close();
        }
    }

    public int getCategoria_servicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Categoria_servico> rt = cq.from(Categoria_servico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
