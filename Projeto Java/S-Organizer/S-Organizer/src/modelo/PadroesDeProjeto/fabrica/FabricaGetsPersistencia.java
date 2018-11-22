/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.PadroesDeProjeto.fabrica;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import java.util.ArrayList;
import java.util.List;
import modelo.Empresa;
import modelo.Prestador;
import persistencia.AcessoP;
import persistencia.EmpresaP;
import persistencia.PrestadorP;
import persistencia.SolicitacaoP;
import persistencia.UsuarioP;

/**
 *
 * @author luizg
 */
public class FabricaGetsPersistencia {
    public void getObjeto(Object obj) {
        
        if(obj instanceof Empresa) {
            EmpresaP objP = new EmpresaP();
            AcessoP aceP = new AcessoP();
            UsuarioP usuP = new UsuarioP();
            
            usuP.setNome(((Empresa) obj).getNome());
            usuP.setTelefone(((Empresa) obj).getTelefone());
            //verificar se deve salvar agora ou salvar depois o usuario.
            
            aceP.setSenha(((Empresa) obj).getSenha());// esse campo é para persistencia de Acessa
            aceP.setLogin(((Empresa) obj).getUsuario()); // essa campo aqui é para persistencia de Acesssa
            aceP.setUsuario(usuP);
            //verificar se deve salvar agora ou salvar depois o acesso.
            
            objP.setCnpj(((Empresa) obj).getCnpj());
            objP.setPrestadores((((Empresa) obj).getPrestadores()));
            objP.setSolicitacaoes(((Empresa) obj).getSolicitacaoes());
            
            
            
            
            
            
            
            
            
                    
            
        }
    }
    
    public List<PrestadorP> tLista(List<Prestador> prestadores) {
        List<PrestadorP> lPrestP = new ArrayList();
        
        for (Prestador prest : prestadores) {
            lPrestP.add((PrestadorP)prest);
        }
        
    }
}
