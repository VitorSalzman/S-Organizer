/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.ControladorJpa;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Agenda;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.ControladorJpa.exceptions.NonexistentEntityException;
import modelo.Prestador;

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
        if (prestador.getAgenda() == null) {
            prestador.setAgenda(new ArrayList<Agenda>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Agenda> attachedAgenda = new ArrayList<Agenda>();
            for (Agenda agendaAgendaToAttach : prestador.getAgenda()) {
                agendaAgendaToAttach = em.getReference(agendaAgendaToAttach.getClass(), agendaAgendaToAttach.getId());
                attachedAgenda.add(agendaAgendaToAttach);
            }
            prestador.setAgenda(attachedAgenda);
            em.persist(prestador);
            for (Agenda agendaAgenda : prestador.getAgenda()) {
                Prestador oldPrestadorOfAgendaAgenda = agendaAgenda.getPrestador();
                agendaAgenda.setPrestador(prestador);
                agendaAgenda = em.merge(agendaAgenda);
                if (oldPrestadorOfAgendaAgenda != null) {
                    oldPrestadorOfAgendaAgenda.getAgenda().remove(agendaAgenda);
                    oldPrestadorOfAgendaAgenda = em.merge(oldPrestadorOfAgendaAgenda);
                }
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
            List<Agenda> agendaOld = persistentPrestador.getAgenda();
            List<Agenda> agendaNew = prestador.getAgenda();
            List<Agenda> attachedAgendaNew = new ArrayList<Agenda>();
            for (Agenda agendaNewAgendaToAttach : agendaNew) {
                agendaNewAgendaToAttach = em.getReference(agendaNewAgendaToAttach.getClass(), agendaNewAgendaToAttach.getId());
                attachedAgendaNew.add(agendaNewAgendaToAttach);
            }
            agendaNew = attachedAgendaNew;
            prestador.setAgenda(agendaNew);
            prestador = em.merge(prestador);
            for (Agenda agendaOldAgenda : agendaOld) {
                if (!agendaNew.contains(agendaOldAgenda)) {
                    agendaOldAgenda.setPrestador(null);
                    agendaOldAgenda = em.merge(agendaOldAgenda);
                }
            }
            for (Agenda agendaNewAgenda : agendaNew) {
                if (!agendaOld.contains(agendaNewAgenda)) {
                    Prestador oldPrestadorOfAgendaNewAgenda = agendaNewAgenda.getPrestador();
                    agendaNewAgenda.setPrestador(prestador);
                    agendaNewAgenda = em.merge(agendaNewAgenda);
                    if (oldPrestadorOfAgendaNewAgenda != null && !oldPrestadorOfAgendaNewAgenda.equals(prestador)) {
                        oldPrestadorOfAgendaNewAgenda.getAgenda().remove(agendaNewAgenda);
                        oldPrestadorOfAgendaNewAgenda = em.merge(oldPrestadorOfAgendaNewAgenda);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = prestador.getId();
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

    public void destroy(long id) throws NonexistentEntityException {
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
            List<Agenda> agenda = prestador.getAgenda();
            for (Agenda agendaAgenda : agenda) {
                agendaAgenda.setPrestador(null);
                agendaAgenda = em.merge(agendaAgenda);
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

    public Prestador findPrestador(long id) {
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
