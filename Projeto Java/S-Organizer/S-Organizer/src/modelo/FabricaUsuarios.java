/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Map;

/**
 *
 * @author 20161bsi0403
 */
public class FabricaUsuarios {
    
    //Interface map (dicionário do python) 
    static Map parametros = null;
    
    public FabricaUsuarios (Map par){
        this.parametros = par;
    }
    
    public Usuario retornaUsuario(String user) throws Exception {
        Usuario usuario = null;
        
        if(user.equalsIgnoreCase("cliente")){
            usuario = new Cliente();
            Cliente cli = (Cliente) usuario;
            cli.setNome((String)parametros.get("nome"));
            cli.setCpf((long) parametros.get("cpf"));
            cli.setTelefone((long) parametros.get("tel"));
        }
        else if(user.equalsIgnoreCase("prestador")){
            usuario = new Prestador();
            Prestador pre = (Prestador) usuario;
            pre.setNome((String)parametros.get("nome"));
            pre.setCpf((long) parametros.get("cpf"));
            pre.setTelefone((long) parametros.get("tel"));
            pre.setEmpresaQueTrabalha((String)parametros.get("empregadoDe"));
            pre.setUsuario((String)parametros.get("login"));
            pre.setSenha((String)parametros.get("senha"));
            
        }
        else if(user.equalsIgnoreCase("empresa")){
            usuario = new Empresa();
            Empresa emp = (Empresa) usuario;
            emp.setNome((String)parametros.get("nome"));
            emp.setCNPJ((long) parametros.get("cnpj"));
            emp.setTelefone((long) parametros.get("tel"));
            emp.setUsuario((String)parametros.get("login"));
            emp.setSenha((String)parametros.get("senha"));
        }
        else{
            throw new Exception("Usuario desconhecido");
           
        }
        
        return usuario;
    }
 

  
    
  }
