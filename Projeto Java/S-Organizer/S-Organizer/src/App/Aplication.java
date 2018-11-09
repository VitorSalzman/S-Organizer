/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.ControladorJPA.EstadoJpaController;

import persistencia.Estado;

/**
 *
 * @author luizg
 */
public class Aplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory objFactory = Persistence.createEntityManagerFactory("S-OrganizerPU");
        EntityManager manager = objFactory.createEntityManager();
        
        EstadoJpaController EstadoC = new EstadoJpaController(objFactory);
        
//         List<Estado> lista = EstadoC.findEstadoEntities();
        
        Estado e1 = new Estado();
        Estado e2 = new Estado();
        Estado e3 = new Estado();
        
        e1.setNome("Espirito Santo");
        e2.setNome("Acre");
        e3.setNome("Goias");
        
        EstadoC.create(e1);
        EstadoC.create(e2);
        EstadoC.create(e3);

//        for (Estado l : lista){
//            l.toString();
//        }
    }
    
}
