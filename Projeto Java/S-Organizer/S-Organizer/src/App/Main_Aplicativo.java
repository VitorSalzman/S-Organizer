/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.sql.Time;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.Bairro;
import persistencia.ControladorJPA.BairroJpaController;
import persistencia.ControladorJPA.HorarioTrabalhoJpaController;
import persistencia.ControladorJPA.PrestadorJpaController;
import persistencia.HorarioTrabalho;
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
        HorarioTrabalhoJpaController hTJpa = new HorarioTrabalhoJpaController(objFactory);
        
        
        //List<Bairro> lista = jpa.findBairroEntities();
        HorarioTrabalho hT1 = new HorarioTrabalho();
        
        final Random random = new Random();
        final int millisInDay = 24*60*60*1000;
        Time time = new Time((long)random.nextInt(millisInDay));
        Time time2 = new Time((long)random.nextInt(millisInDay));
        
        hT1.setHorarioinicio(time);
        hT1.setHorariofim(time2);
        
        Prestador p1 = new Prestador();

        p1.setEmpresaQueTrabalha("Nike");
        p1.setDisponibilidade(false);
        p1.setCpf(12671893149l);
        p1.setUsuario("Jimm");
        p1.setSenha("1234");
        p1.setNome("Luiz Antonio");
        p1.setTelefone(27998065439l);
        p1.setHorarioTrabalho(hT1);
        
        
        hTJpa.create(hT1);
        prestadorJpa.create(p1);
        
        
        //prestadorJpa.create(p2);


        
    }
    
}
