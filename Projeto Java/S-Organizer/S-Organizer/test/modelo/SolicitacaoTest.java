/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
public class SolicitacaoTest {
    
    public SolicitacaoTest() {
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
     * Test of getObservacao method, of class Solicitacao.
     */
    @Test
    public void testGetObservacao() {
        System.out.println("getObservacao");
        Solicitacao instance = new Solicitacao();
        String expResult = "";
        String result = instance.getObservacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class Solicitacao.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Solicitacao instance = new Solicitacao();
        EstadoSolicitacao expResult = null;
        EstadoSolicitacao result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setObservacao method, of class Solicitacao.
     */
    @Test
    public void testSetObservacao() {
        System.out.println("setObservacao");
        String observacao = "";
        Solicitacao instance = new Solicitacao();
        instance.setObservacao(observacao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class Solicitacao.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        EstadoSolicitacao estado = null;
        Solicitacao instance = new Solicitacao();
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProtocolo method, of class Solicitacao.
     */
    @Test
    public void testGetProtocolo() {
        System.out.println("getProtocolo");
        Solicitacao instance = new Solicitacao();
        long expResult = 0L;
        long result = instance.getProtocolo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProtocolo method, of class Solicitacao.
     */
    @Test
    public void testSetProtocolo() {
        System.out.println("setProtocolo");
        long protocol = 0L;
        Solicitacao instance = new Solicitacao();
        instance.setProtocolo(protocol);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDispCliIni method, of class Solicitacao.
     */
    @Test
    public void testGetDispCliIni() {
        System.out.println("getDispCliIni");
        Solicitacao instance = new Solicitacao();
        Calendar expResult = null;
        Calendar result = instance.getDispCliIni();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDispCliIni method, of class Solicitacao.
     */
    @Test
    public void testSetDispCliIni() {
        System.out.println("setDispCliIni");
        Calendar disp_cli_ini = null;
        Solicitacao instance = new Solicitacao();
        instance.setDispCliIni(disp_cli_ini);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDispCliFim method, of class Solicitacao.
     */
    @Test
    public void testGetDispCliFim() {
        System.out.println("getDispCliFim");
        Solicitacao instance = new Solicitacao();
        Calendar expResult = null;
        Calendar result = instance.getDispCliFim();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDispCliFim method, of class Solicitacao.
     */
    @Test
    public void testSetDispCliFim() {
        System.out.println("setDispCliFim");
        Calendar disp_cli_fim = null;
        Solicitacao instance = new Solicitacao();
        instance.setDispCliFim(disp_cli_fim);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataSolicitacao method, of class Solicitacao.
     */
    @Test
    public void testGetDataSolicitacao() {
        System.out.println("getDataSolicitacao");
        Solicitacao instance = new Solicitacao();
        Calendar expResult = null;
        Calendar result = instance.getDataSolicitacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataSolicitacao method, of class Solicitacao.
     */
    @Test
    public void testSetDataSolicitacao() {
        System.out.println("setDataSolicitacao");
        Calendar dataSolicitacao = null;
        Solicitacao instance = new Solicitacao();
        instance.setDataSolicitacao(dataSolicitacao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServicos method, of class Solicitacao.
     */
    @Test
    public void testGetServicos() {
        System.out.println("getServicos");
        Solicitacao instance = new Solicitacao();
        List<Servico> expResult = null;
        List<Servico> result = instance.getServicos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDisp_cli_ini method, of class Solicitacao.
     */
    @Test
    public void testGetDisp_cli_ini() {
        System.out.println("getDisp_cli_ini");
        Solicitacao instance = new Solicitacao();
        Calendar expResult = null;
        Calendar result = instance.getDisp_cli_ini();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDisp_cli_ini method, of class Solicitacao.
     */
    @Test
    public void testSetDisp_cli_ini() {
        System.out.println("setDisp_cli_ini");
        Calendar disp_cli_ini = null;
        Solicitacao instance = new Solicitacao();
        instance.setDisp_cli_ini(disp_cli_ini);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDisp_cli_fim method, of class Solicitacao.
     */
    @Test
    public void testGetDisp_cli_fim() {
        System.out.println("getDisp_cli_fim");
        Solicitacao instance = new Solicitacao();
        Calendar expResult = null;
        Calendar result = instance.getDisp_cli_fim();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDisp_cli_fim method, of class Solicitacao.
     */
    @Test
    public void testSetDisp_cli_fim() {
        System.out.println("setDisp_cli_fim");
        Calendar disp_cli_fim = null;
        Solicitacao instance = new Solicitacao();
        instance.setDisp_cli_fim(disp_cli_fim);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMultaTotal method, of class Solicitacao.
     */
    @Test
    public void testGetMultaTotal() {
        System.out.println("getMultaTotal");
        Solicitacao instance = new Solicitacao();
        Double expResult = null;
        Double result = instance.getMultaTotal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMultaTotal method, of class Solicitacao.
     */
    @Test
    public void testSetMultaTotal() {
        System.out.println("setMultaTotal");
        Double multaTotal = null;
        Solicitacao instance = new Solicitacao();
        instance.setMultaTotal(multaTotal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndereco method, of class Solicitacao.
     */
    @Test
    public void testGetEndereco() {
        System.out.println("getEndereco");
        Solicitacao instance = new Solicitacao();
        Endereco expResult = null;
        Endereco result = instance.getEndereco();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEndereco method, of class Solicitacao.
     */
    @Test
    public void testSetEndereco() {
        System.out.println("setEndereco");
        Endereco endereco = null;
        Solicitacao instance = new Solicitacao();
        instance.setEndereco(endereco);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addServico method, of class Solicitacao.
     */
    @Test
    public void testAddServico() {
        System.out.println("addServico");
        Servico servico = null;
        Solicitacao instance = new Solicitacao();
        instance.addServico(servico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeServico method, of class Solicitacao.
     */
    @Test
    public void testRemoveServico() {
        System.out.println("removeServico");
        Servico servico = null;
        Solicitacao instance = new Solicitacao();
        instance.removeServico(servico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setServicos method, of class Solicitacao.
     */
    @Test
    public void testSetServicos() {
        System.out.println("setServicos");
        ArrayList<Servico> servicos = null;
        Solicitacao instance = new Solicitacao();
        instance.setServicos(servicos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printServicos method, of class Solicitacao.
     */
    @Test
    public void testPrintServicos() {
        System.out.println("printServicos");
        Solicitacao instance = new Solicitacao();
        instance.printServicos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
