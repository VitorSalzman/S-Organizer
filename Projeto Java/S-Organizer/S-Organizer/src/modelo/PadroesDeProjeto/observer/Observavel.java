/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.PadroesDeProjeto.observer;

import java.util.Observer;

/**
 * PADRAO DE PROJETO OBSERVER
 * Observavel aplicado para classe Solicitacao. A intenção é que toda vez
 * que o estado da solicitação for alterado o cliente será notificado.
 */
public class Observavel {
    
   /*APENAS UM ATRIBUTO OBSERVADOR POIS UMA SOLICITACAO SÓ TEM UM CLIENTE*/
   private Observador ob;
   
   public void notificarObservadores(){
       ob.update(this);
   }
}
