/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
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
        
        List<T> listObj = new ArrayList<>();
        
        try {
            /* monta o resultado de retorno */
            listObj = em.createQuery("from " + classe.getName()).setFirstResult(offset).setMaxResults(limit).getResultList();
                    
        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            if (em != null) {
                em.close();
            }
        }    
        
        return listObj;

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
