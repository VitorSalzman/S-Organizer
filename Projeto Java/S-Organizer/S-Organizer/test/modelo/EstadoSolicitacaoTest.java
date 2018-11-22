/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Serenna
 */
public class EstadoSolicitacaoTest {
    
    public EstadoSolicitacaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of values method, of class EstadoSolicitacao.
     */
    @Test
    public void testValues() {
        
        EstadoSolicitacao[] expResult = null;
        EstadoSolicitacao[] result = EstadoSolicitacao.values();
        for(int i =0; i<result.length; i++){
            System.out.println("values " + result[i]);
        }
       
    }

    /**
     * Test of valueOf method, of class EstadoSolicitacao.
     */
    @Test
    public void testValueOf() {
        
        String name = "PENDENTE";
        EstadoSolicitacao expResult = null;
        EstadoSolicitacao result = EstadoSolicitacao.valueOf(name);
        System.out.println("valueOf " + result);
    }

    /**
     * Test of getId method, of class EstadoSolicitacao.
     */
    @Test
    public void testGetId() {
       
        EstadoSolicitacao instance;
        instance = EstadoSolicitacao.PENDENTE;
        int idES = instance.getId();
       
        System.out.println("getId "+instance.toString() +' ' + idES);
        
    }
    
}
