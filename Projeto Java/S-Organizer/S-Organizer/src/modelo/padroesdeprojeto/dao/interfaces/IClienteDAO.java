/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.dao.interfaces;

import modelo.Cliente;
import modelo.Solicitacao;

/**
 *
 * @author helle
 */
public interface IClienteDAO extends IGenericDAO<Cliente> {
    
    public int getClassCount();
}
