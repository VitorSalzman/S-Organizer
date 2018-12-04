/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.dao;

import modelo.padroesdeprojeto.dao.interfaces.IGenericDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Classe abstrata de implementacao da interface IGenericDAO
 * Seguindo o padrão DAO
 * @author helle
 */
public abstract class AGenericDAOImpl<T> implements IGenericDAO<T> {
    
    private Class<T> classe;
    private FabricManager fm = new FabricManager();
    private EntityManager em;
    
    
    public AGenericDAOImpl(Class<T> classe) {
        this.definirClasse(classe);
    }
    
    public void definirClasse(final Class<T> classe) {
        this.classe = classe;
    }
    

    @Override
    public void inserir(Object obj) {
        
        EntityManager em = fm.getFabricManager();
        
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
    }

    @Override
    public void alterar(Object obj) {
        
        EntityManager em = fm.getFabricManager();
        
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        }

        catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

        finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void deletarPorId(long id) {
        
        EntityManager em = fm.getFabricManager();
        
        try {
            em.getTransaction().begin();
            T obj = em.find(classe, id);
            em.remove(obj);
            em.getTransaction().commit();
        }

        catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

        finally {
            if (em != null) {
                em.close();
            }
}
        
    }

    @Override
    public List listarTodos(Integer limit, Integer offset) {
        
        EntityManager em = fm.getFabricManager();
        
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(classe));
            Query q = em.createQuery(cq);
            q.setMaxResults(limit);
            q.setFirstResult(offset);

            return q.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public T obterPorId(long id) {
        EntityManager em = fm.getFabricManager();

        T obj = null;

        try {
            obj = em.find(this.classe, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return obj;
    }

}
