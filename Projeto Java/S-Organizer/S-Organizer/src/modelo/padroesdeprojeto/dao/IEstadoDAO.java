/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.dao;

import modelo.Estado;

/**
 *
 * @author helle
 */
public interface IEstadoDAO extends IGenericDAO<Estado> {
    
    public int getClassCount();
    
}
