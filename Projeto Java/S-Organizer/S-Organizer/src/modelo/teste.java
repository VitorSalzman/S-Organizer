/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 20161bsi0403
 */
public class teste {
    public static void main(String args[]) throws Exception {
      String v="INSTALACAO";  
      System.out.println("CellPhone List:");
      for(Categoria m : Categoria.values()) { 
         System.out.println(m + " costs " + m.getDescricao());
      }
      Servico s = new Servico();
      
      s.setCategoria(v);
      System.out.println(s.getCategoria().getDescricao());
      
     
      
      
      
    }  
}
    
