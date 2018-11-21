/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.PadroesDeProjeto.fabrica; //WHY

import java.sql.Time;
import java.util.Map;
import modelo.Cliente;
import modelo.Empresa;
import modelo.Prestador;
import modelo.Usuario;

/**
 *
 * @author 20161bsi0403
 */
public class FabricaUsuarios {
    
    //Interface map (dicionário do python) 
    Map parametros = null;
    
    public FabricaUsuarios (Map par){
        this.parametros = par;
    }
    
    public Usuario retornaUsuario(String user) throws Exception {
        Usuario usuario = null;
        
        if(user.equalsIgnoreCase("cliente")){
            usuario = new Cliente(
                    (long)parametros.get("cpf"),
                    (String)parametros.get("nome"),
                    (long)parametros.get("telefone")
            );
            Cliente cli = (Cliente) usuario;

        }
        else if(user.equalsIgnoreCase("prestador")){
            usuario = new Prestador(
                    (Time)parametros.get("horarioInicio"),
                    (Time)parametros.get("horarioFim"),
                    (int)parametros.get("cargaHoraria"),
                    (String)parametros.get("cpf"),
                    (String)parametros.get("usuario"),
                    (String)parametros.get("senha"),
                    (String)parametros.get("nome"),
                    (long)parametros.get("telefone")
            );
            Prestador pre = (Prestador) usuario; 

        }
        else if(user.equalsIgnoreCase("empresa")){
            usuario = new Empresa(
                    (long)parametros.get("cnpj"),
                    (String)parametros.get("usuario"),
                    (String)parametros.get("senha"),
                    (String)parametros.get("nome"),
                    (long)parametros.get("telefone")
            );
            
            Empresa emp = (Empresa) usuario;

        }
        else{
            throw new Exception("Usuario desconhecido");
           
        }
        
        return usuario;
    }
 

  
    
  }
