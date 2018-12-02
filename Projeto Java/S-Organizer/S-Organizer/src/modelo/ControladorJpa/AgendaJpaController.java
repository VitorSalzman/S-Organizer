/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.ControladorJpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Agenda;
import modelo.ControladorJpa.exceptions.NonexistentEntityException;
import modelo.Prestador;

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

    public void create(Agenda agenda) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Prestador prestador = agenda.getPrestador();
            if (prestador != null) {
                prestador = em.getReference(prestador.getClass(), prestador.getId());
                agenda.setPrestador(prestador);
            }
            em.persist(agenda);
            if (prestador != null) {
                prestador.getAgenda().add(agenda);
                prestador = em.merge(prestador);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Agenda agenda) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Agenda persistentAgenda = em.find(Agenda.class, agenda.getId());
            Prestador prestadorOld = persistentAgenda.getPrestador();
            Prestador prestadorNew = agenda.getPrestador();
            if (prestadorNew != null) {
                prestadorNew = em.getReference(prestadorNew.getClass(), prestadorNew.getId());
                agenda.setPrestador(prestadorNew);
            }
            agenda = em.merge(agenda);
            if (prestadorOld != null && !prestadorOld.equals(prestadorNew)) {
                prestadorOld.getAgenda().remove(agenda);
                prestadorOld = em.merge(prestadorOld);
            }
            if (prestadorNew != null && !prestadorNew.equals(prestadorOld)) {
                prestadorNew.getAgenda().add(agenda);
                prestadorNew = em.merge(prestadorNew);
            }
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
            Agenda agenda;
            try {
                agenda = em.getReference(Agenda.class, id);
                agenda.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The agenda with id " + id + " no longer exists.", enfe);
            }
            Prestador prestador = agenda.getPrestador();
            if (prestador != null) {
                prestador.getAgenda().remove(agenda);
                prestador = em.merge(prestador);
            }
            em.remove(agenda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Agenda> findAgendaEntities() {
        return findAgendaEntities(true, -1, -1);
    }

    public List<Agenda> findAgendaEntities(int maxResults, int firstResult) {
        return findAgendaEntities(false, maxResults, firstResult);
    }

    private List<Agenda> findAgendaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Agenda.class));
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

    public Agenda findAgenda(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Agenda.class, id);
        } finally {
            em.close();
        }
    }

    public int getAgendaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Agenda> rt = cq.from(Agenda.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
