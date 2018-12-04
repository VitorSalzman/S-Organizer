///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//import java.util.HashMap;
//import modelo.FabricaUsuarios;
//import modelo.Prestador;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
///**
// *
// * @author helle
// */
//public class FabricaUsuariosJUnit {
//    
//    public FabricaUsuariosJUnit() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    // TODO add test methods here.
//    // The methods must be annotated with annotation @Test. For example:
//    //
//    // @Test
//    // public void hello() {}
//    
//    @Test
//    public void testeFUsuario() {
//        
//        HashMap dados = new HashMap();
//        dados.put("nome","Saruman");
//        dados.put("empregadoDe","ifes");
//        dados.put("cpf",22233344477L);
//        dados.put("tel",999558342L);
//        dados.put("login","onixsu5");
//        dados.put("senha","asd887!");
//        
//        FabricaUsuarios fu = new FabricaUsuarios(dados);
//        Prestador p = null;
//        try {
//            p = (Prestador) fu.retornaUsuario("prestador");
//        } catch (Exception ex) {
//            System.out.println("Erro");
//        }
//        System.out.println(p.getEmpresaQueTrabalha());
//       
//    }
//}
