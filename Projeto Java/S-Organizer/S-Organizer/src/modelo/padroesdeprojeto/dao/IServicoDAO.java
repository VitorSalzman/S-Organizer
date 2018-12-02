/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.dao;

import java.util.List;
import modelo.Servico;

/**
 *
 * @author helle
 */
public interface IServicoDAO extends IGenericDAO<Servico> {
    
    public int getClassCount();
    //public List<Servico> listarTodosServicosPorPrestador(long idPrestador, int limit, int offset);
}
