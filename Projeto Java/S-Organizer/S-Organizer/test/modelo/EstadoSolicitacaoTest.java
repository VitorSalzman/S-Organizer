/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.padroesdeprojeto.dao.DAOEmpresa;
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
        
        
       
    }

    /**
     * Test of valueOf method, of class EstadoSolicitacao.
     */
    @Test
    public void testValueOf() {
        
        Empresa emp = new Empresa();
        DAOEmpresa demp = new DAOEmpresa();
        

        emp.setCnpj("12345600");
        emp.setLogin("meuteste");
        emp.setNome("Maaarc");
        try {
            emp.setSenha("123");
        } catch (Exception ex) {
            ex.getMessage();
        }
        emp.setTelefone("9999999999");
        demp.inserir(emp);
    }

    /**
     * Test of getId method, of class EstadoSolicitacao.
     */
    @Test
    public void testGetId() {
       
     
    }
    
}
