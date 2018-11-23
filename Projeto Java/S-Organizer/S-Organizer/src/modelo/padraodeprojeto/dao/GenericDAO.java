/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padraodeprojeto.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.ControladoresJPA.exceptions.NonexistentEntityException;

/**
 *
 * @author helle
 */
public interface GenericDAO<T> {
    
    public abstract void jpaController(EntityManagerFactory emf); //antigo <nome>JpaController
    public abstract EntityManager getEntityManager();
    public abstract void create(T obj);
    public abstract void edit(T obj) throws NonexistentEntityException, Exception;
    public abstract void destroy(long id) throws NonexistentEntityException;
    public abstract List<T> findEntities();
    public abstract List<T> findEntities(int maxResults, int firstResult);
    public abstract List<T> findEntitiesBoo(boolean all, int maxResults, int firstResult);
    public abstract T find(long id);
    public abstract int getCount();
    
}
