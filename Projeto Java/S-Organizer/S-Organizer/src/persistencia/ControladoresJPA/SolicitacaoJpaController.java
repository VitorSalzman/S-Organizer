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
import persistencia.SolicitacaoP;

/**
 *
 * @author luizg
 */
public class SolicitacaoJpaController implements Serializable {

    public SolicitacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SolicitacaoP solicitacao) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(solicitacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SolicitacaoP solicitacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            solicitacao = em.merge(solicitacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = solicitacao.getId();
                if (findSolicitacao(id) == null) {
                    throw new NonexistentEntityException("The solicitacao with id " + id + " no longer exists.");
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
            SolicitacaoP solicitacao;
            try {
                solicitacao = em.getReference(SolicitacaoP.class, id);
                solicitacao.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The solicitacao with id " + id + " no longer exists.", enfe);
            }
            em.remove(solicitacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SolicitacaoP> findSolicitacaoEntities() {
        return findSolicitacaoEntities(true, -1, -1);
    }

    public List<SolicitacaoP> findSolicitacaoEntities(int maxResults, int firstResult) {
        return findSolicitacaoEntities(false, maxResults, firstResult);
    }

    private List<SolicitacaoP> findSolicitacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SolicitacaoP.class));
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

    public SolicitacaoP findSolicitacao(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SolicitacaoP.class, id);
        } finally {
            em.close();
        }
    }

    public int getSolicitacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SolicitacaoP> rt = cq.from(SolicitacaoP.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
