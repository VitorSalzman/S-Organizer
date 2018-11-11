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
import persistencia.Agenda;
import persistencia.ControladorJPA.exceptions.NonexistentEntityException;
import persistencia.Prestador;

/**
 *
 * @author luizg
 */
public class PrestadorJpaController implements Serializable {

    public PrestadorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Prestador prestador) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Agenda agenda = prestador.getAgenda();
            if (agenda != null) {
                agenda = em.getReference(agenda.getClass(), agenda.getId());
                prestador.setAgenda(agenda);
            }
            em.persist(prestador);
            if (agenda != null) {
                Prestador oldPrestadorOfAgenda = agenda.getPrestador();
                if (oldPrestadorOfAgenda != null) {
                    oldPrestadorOfAgenda.setAgenda(null);
                    oldPrestadorOfAgenda = em.merge(oldPrestadorOfAgenda);
                }
                agenda.setPrestador(prestador);
                agenda = em.merge(agenda);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Prestador prestador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Prestador persistentPrestador = em.find(Prestador.class, prestador.getId());
            Agenda agendaOld = persistentPrestador.getAgenda();
            Agenda agendaNew = prestador.getAgenda();
            if (agendaNew != null) {
                agendaNew = em.getReference(agendaNew.getClass(), agendaNew.getId());
                prestador.setAgenda(agendaNew);
            }
            prestador = em.merge(prestador);
            if (agendaOld != null && !agendaOld.equals(agendaNew)) {
                agendaOld.setPrestador(null);
                agendaOld = em.merge(agendaOld);
            }
            if (agendaNew != null && !agendaNew.equals(agendaOld)) {
                Prestador oldPrestadorOfAgenda = agendaNew.getPrestador();
                if (oldPrestadorOfAgenda != null) {
                    oldPrestadorOfAgenda.setAgenda(null);
                    oldPrestadorOfAgenda = em.merge(oldPrestadorOfAgenda);
                }
                agendaNew.setPrestador(prestador);
                agendaNew = em.merge(agendaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = prestador.getId();
                if (findPrestador(id) == null) {
                    throw new NonexistentEntityException("The prestador with id " + id + " no longer exists.");
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
            Prestador prestador;
            try {
                prestador = em.getReference(Prestador.class, id);
                prestador.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The prestador with id " + id + " no longer exists.", enfe);
            }
            Agenda agenda = prestador.getAgenda();
            if (agenda != null) {
                agenda.setPrestador(null);
                agenda = em.merge(agenda);
            }
            em.remove(prestador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Prestador> findPrestadorEntities() {
        return findPrestadorEntities(true, -1, -1);
    }

    public List<Prestador> findPrestadorEntities(int maxResults, int firstResult) {
        return findPrestadorEntities(false, maxResults, firstResult);
    }

    private List<Prestador> findPrestadorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Prestador.class));
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

    public Prestador findPrestador(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Prestador.class, id);
        } finally {
            em.close();
        }
    }

    public int getPrestadorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Prestador> rt = cq.from(Prestador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
