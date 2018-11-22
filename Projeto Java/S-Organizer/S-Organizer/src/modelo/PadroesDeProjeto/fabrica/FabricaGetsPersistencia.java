/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.PadroesDeProjeto.fabrica;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Empresa;
import modelo.Prestador;
import persistencia.AcessoP;
import persistencia.ControladoresJPA.AcessoJpaController;
import persistencia.ControladoresJPA.EmpresaJpaController;
import persistencia.ControladoresJPA.PrestadorJpaController;
import persistencia.ControladoresJPA.UsuarioJpaController;
import persistencia.EmpresaP;
import persistencia.PrestadorP;
import persistencia.SolicitacaoP;
import persistencia.UsuarioP;

/**
 *
 * @author luizg
 */
public class FabricaGetsPersistencia {
    EntityManagerFactory objFactory = Persistence.createEntityManagerFactory("S-Organizer2PU");
    EntityManager manager = objFactory.createEntityManager();
    
    public void getObjeto(Object obj) {
        EmpresaJpaController emJpa = new EmpresaJpaController(objFactory);
        AcessoJpaController acJpa = new AcessoJpaController(objFactory);
        UsuarioJpaController usJpa = new UsuarioJpaController(objFactory);
                
        
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
            objP.setPrestadores(((Empresa) obj).getPrestadores());
            objP.setSolicitacaoes(((Empresa) obj).getSolicitacaoes());
            objP.setAcesso(aceP);
            
            usJpa.create(usuP);
            acJpa.create(aceP);
            emJpa.create(objP);
            
            
            
            
            
            
            
            
            
                    
            
        }
    }
    /* Transforma uma lista de prestadores em lista de prestadorP
    Info: Eu não consigo transformar um prestador em prestadorP porque eles são
    objetos diferentes.
    
    Se eu quero um transformar um prestador em prestadorP, então eu preciso cons
    -truir toda a base dela antes disso, sendo que prestador extende Acesso que
    extende Usuario.
    
    COMO FAZER? 
     - PADRÃO DE CLONAGEM??
     - SEGUIR COM OS MÉTODOS DE TRANSFORMAÇÃO DA LISTA?
     - POSSO TROCAR TODOS OS TIPOS DE ESPECIFICOS DE LISTA PARA LISTA DE OBJTETO
    GENÉRIO?
     - O QUE ESTÁ ACONTECENDO QUANDO EU COLOCO UM PARENTESES A MAIS E O NETBEANS
    PARA DE APONTAR ERRO?
    */
    public List<PrestadorP> tListaPrestador(List<Prestador> prestadores) {
        List<PrestadorP> lPrestP = new ArrayList();
        PrestadorP prestP = null;
        AcessoP aceP = null; 
        UsuarioP usuP = null;
        
        for (Prestador prest : prestadores) {
            prestP = new PrestadorP();
            aceP = new AcessoP();
            
            
            prestP.setAcesso(aceP);
            
            prestP.setCargaHoraria(prest.getCargaHoraria());
            
            
        }
        
    }
}
