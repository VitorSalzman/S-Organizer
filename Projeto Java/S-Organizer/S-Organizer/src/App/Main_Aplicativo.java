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
import persistencia.Bairro;
import persistencia.ControladorJPA.BairroJpaController;

/**
 *
 * @author luizg
 */
public class Main_Aplicativo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory objFactory = Persistence.createEntityManagerFactory("S-Organizer2PU");
        EntityManager manager = objFactory.createEntityManager();
        
        BairroJpaController jpa = new BairroJpaController(objFactory);
                
        List<Bairro> lista = jpa.findBairroEntities();
        
        Bairro l1 = new Bairro();
        Bairro l2 = new Bairro();
        Bairro l3 = new Bairro();
        
        l1.setNome("COLOCAR");
        l2.setNome("AUTO-INCREMENT");
        l3.setNome("NESSA BUDEGAA");
        
        jpa.create(l1);
        jpa.create(l2);
        jpa.create(l3);

        for (Bairro l : lista){
            System.out.println("Cod.: "+l.getId()+" Nome.:"+l.getNome());
        }
        
    }
    
}
