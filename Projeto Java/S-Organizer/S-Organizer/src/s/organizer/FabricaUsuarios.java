/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s.organizer;

/**
 *
 * @author 20161bsi0403
 */
public class FabricaUsuarios {
    public static Usuario retornaUsuario(String user) throws Exception {
        Usuario usuario = null;
        
        if(user.equalsIgnoreCase("cliente")){
            usuario = new Cliente();
            
        }
        else if(user.equalsIgnoreCase("prestador")){
            usuario = new Prestador();
            
        }
        else if(user.equalsIgnoreCase("empresa")){
            usuario = new Empresa();
            
        }
        else{
            throw new Exception("Usuario desconhecido");
           
        }
        
        return usuario;
    }
  }
