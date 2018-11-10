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
import persistencia.EstadoSolicitacao;

/**
 *
 * @author luizg
 */
public class EstadoSolicitacaoJpaController implements Serializable {

    public EstadoSolicitacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EstadoSolicitacao estadoSolicitacao) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(estadoSolicitacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EstadoSolicitacao estadoSolicitacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            estadoSolicitacao = em.merge(estadoSolicitacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = estadoSolicitacao.getId();
                if (findEstadoSolicitacao(id) == null) {
                    throw new NonexistentEntityException("The estadoSolicitacao with id " + id + " no longer exists.");
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
            EstadoSolicitacao estadoSolicitacao;
            try {
                estadoSolicitacao = em.getReference(EstadoSolicitacao.class, id);
                estadoSolicitacao.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estadoSolicitacao with id " + id + " no longer exists.", enfe);
            }
            em.remove(estadoSolicitacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EstadoSolicitacao> findEstadoSolicitacaoEntities() {
        return findEstadoSolicitacaoEntities(true, -1, -1);
    }

    public List<EstadoSolicitacao> findEstadoSolicitacaoEntities(int maxResults, int firstResult) {
        return findEstadoSolicitacaoEntities(false, maxResults, firstResult);
    }

    private List<EstadoSolicitacao> findEstadoSolicitacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EstadoSolicitacao.class));
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

    public EstadoSolicitacao findEstadoSolicitacao(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EstadoSolicitacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstadoSolicitacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EstadoSolicitacao> rt = cq.from(EstadoSolicitacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
