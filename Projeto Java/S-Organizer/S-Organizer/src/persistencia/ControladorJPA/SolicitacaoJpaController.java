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
import persistencia.Solicitacao;

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

    public void create(Solicitacao solicitacao) {
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

    public void edit(Solicitacao solicitacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            solicitacao = em.merge(solicitacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = solicitacao.getId();
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

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Solicitacao solicitacao;
            try {
                solicitacao = em.getReference(Solicitacao.class, id);
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

    public List<Solicitacao> findSolicitacaoEntities() {
        return findSolicitacaoEntities(true, -1, -1);
    }

    public List<Solicitacao> findSolicitacaoEntities(int maxResults, int firstResult) {
        return findSolicitacaoEntities(false, maxResults, firstResult);
    }

    private List<Solicitacao> findSolicitacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Solicitacao.class));
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

    public Solicitacao findSolicitacao(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Solicitacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getSolicitacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Solicitacao> rt = cq.from(Solicitacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
