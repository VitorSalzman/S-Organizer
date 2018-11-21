/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package modelo;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

//public class SOrganizer {

    /**
     * @param args the command line arguments
     
    
//    Exemplo fabrica usuarios bbs
    public static void main(String[] args) {
        HashMap dados = new HashMap();
        dados.put("nome","Saruman");
        dados.put("empregadoDe","ifes");
        dados.put("cpf",22233344477L);
        dados.put("tel",999558342L);
        dados.put("login","onixsu5");
        dados.put("senha","asd887!");
        
        FabricaUsuarios fu = new FabricaUsuarios(dados);
        Prestador p = null;
        try {
            p = (Prestador) fu.retornaUsuario("prestador");
        } catch (Exception ex) {
            System.out.println("Erro");
        }
        System.out.println(p.getEmpresaQueTrabalha());
        
    }
    
}
*/