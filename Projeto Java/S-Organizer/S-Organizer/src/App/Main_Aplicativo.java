/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.Bairro;
import persistencia.ControladorJPA.BairroJpaController;
import persistencia.ControladorJPA.PrestadorJpaController;
import persistencia.Prestador;

/**
 *
 * @author luizg
 */
public class Main_Aplicativo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory objFactory = Persistence.createEntityManagerFactory("S-Organizer2PU");
        EntityManager manager = objFactory.createEntityManager();
        
        PrestadorJpaController prestadorJpa = new PrestadorJpaController(objFactory);
                
        //List<Bairro> lista = jpa.findBairroEntities();
        
        /*
        codigo
        empresaQueTrabalha
        disponibilidade
        cpf
        usuario
        senha
        nome
        telefone
        */
        

        Prestador p1 = new Prestador();

        p1.setEmpresaQueTrabalha("Nike");
        p1.setDisponibilidade(false);
        p1.setCpf(12671893149l);
        p1.setUsuario("Jimm");
        p1.setSenha("1234");
        p1.setNome("Luiz Antonio");
        p1.setTelefone(27998065439l);
        
        //Prestador p2 = new Prestador(/*codigo2,*/"Adidas",true,98765432109l,"Jubileu","4321","Mclovin",027561648746l);
        
        prestadorJpa.create(p1);
        //prestadorJpa.create(p2);


        
    }
    
}
