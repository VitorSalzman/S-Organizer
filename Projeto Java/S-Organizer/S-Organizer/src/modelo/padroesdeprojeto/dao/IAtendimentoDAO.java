/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.dao;

import modelo.Atendimento;

/**
 *
 * @author helle
 */
public interface IAtendimentoDAO extends IGenericDAO<Atendimento> {
    
    public int getClassCount();
    
}
