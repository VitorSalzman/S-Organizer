/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.dao;

import modelo.Bairro;

/**
 *
 * @author helle
 */
public interface IBairroDAO extends IGenericDAO<Bairro> {
    
    public int getClassCount();
    
}
