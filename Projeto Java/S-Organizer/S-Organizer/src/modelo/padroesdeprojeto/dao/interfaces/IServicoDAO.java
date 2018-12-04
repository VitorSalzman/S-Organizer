/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.dao.interfaces;

import java.util.List;
import modelo.Servico;

/**
 * Interface dos métodos mais específicos fora do CRUD
 * Seguindo o padrão DAO.
 * 
 * Novos métodos de DAO para classe <nome>DAO devem ser
 * escritos aqui primeiro.
 * @author helle
 */
public interface IServicoDAO extends IGenericDAO<Servico> {
    
    public int getClassCount();
    //public List<Servico> listarTodosServicosPorPrestador(long idPrestador, int limit, int offset);
}
