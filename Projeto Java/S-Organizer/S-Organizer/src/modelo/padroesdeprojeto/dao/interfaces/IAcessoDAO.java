/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.dao.interfaces;

import modelo.Acesso;

/**
 *
 * @author helle
 */
public interface IAcessoDAO extends IGenericDAO<Acesso> {
    
    public int getClassCount();
    
}
