/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Essa classe "terceiriza" a conexão com o banco de dados,
 * assim o código é reaproveitado.
 * 
 * A ferramenta de persistência JPA utiliza um FabricManager
 * e EntityManagerFactory para criar/estabelecer a conexão
 * com o banco.
 * @author helle
 */
public class FabricManager {
    
    private static FabricManager fm;
    private static EntityManagerFactory emf;
    
    public FabricManager() {
        emf = Persistence.createEntityManagerFactory("S-Organizer2PU");
    }
    
    public EntityManager getFabricManager() {
        return emf.createEntityManager();
    }
    
    public void closeFabricManager() {
        if(emf.isOpen()) {
            try{
                emf.close();   
            } catch (Exception e) {
                e.printStackTrace();
            }    
        }
    }  
}
