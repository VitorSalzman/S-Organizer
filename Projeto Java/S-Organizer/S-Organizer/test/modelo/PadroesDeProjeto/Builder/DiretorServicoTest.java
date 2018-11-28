/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.PadroesDeProjeto.Builder;

import modelo.Servico;
import modelo.padroesdeprojeto.builder.DiretorServico;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import modelo.padroesdeprojeto.builder.BuilderServico;

/**
 *
 * @author 20161BSI0403
 */
public class DiretorServicoTest {
    
    public DiretorServicoTest() {
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
     * Test of builder method, of class DiretorServico.
     */
    @Test
    public void testBuilder() throws Exception {
        
        
        System.out.println("builder");
        String categoria = "limpeza";
        String descricao = "limpeza de caixa d'agua fortlev, 2000L";
        String valor = "150.00";
        String horarioMarcado = "15:00:00";
        DiretorServico instance = new DiretorServico();
        Servico expResult = null;
        //expResult.setCategoria(categoria);
        expResult.setDescricao(descricao);
        
        
        Servico result = instance.builder(categoria, descricao, valor, horarioMarcado);
        expResult.setValor(result.getValor());
        expResult.setHorarioMarcado(result.getHorarioMarcado());
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        
        
        
        
        
        
    }
    
    
    
}
