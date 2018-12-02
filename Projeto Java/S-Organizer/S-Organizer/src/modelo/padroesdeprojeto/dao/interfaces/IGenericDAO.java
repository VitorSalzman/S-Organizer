/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.dao.interfaces;

import java.util.List;

/**
 * DAO Generico AKA pai de todos os DAO
 * Seguindo o padrão DAO.
 * @author helle
 */
public interface IGenericDAO<T> {
    
    public void inserir(T obj);
    public void alterar(T obj);
    public void deletarPorId(long id);
    public T obterPorId(long id);
    public List<T> listarTodos(Integer limit, Integer offset);
    
    }
