/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.dao.interfaces;

import modelo.Agenda;

/**
 *
 * @author helle
 */
public interface IAgendaDAO extends IGenericDAO<Agenda> {
    
    public int getClassCount();
    
}
