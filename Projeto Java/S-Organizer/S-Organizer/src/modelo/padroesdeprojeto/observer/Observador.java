/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.observer;

/**
 * PADRAO DE PROJETO OBSERVER
 * Observador aplicado para a(s) classe(s): Cliente
 * @author helle
 */
public interface Observador {
    
    public void update(Observavel ob);
    
}
