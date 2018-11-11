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
     * Sequencia para criação de uma persistencia:
     *  Define as variaveis
     *  Nomear as Colunas
     *  Cria toString (utilize alt + insert , isso é um atalho)
     *  Criar hash e equals
     *  Criar get e set
     *  Deleta Controlador da persistencia modificado
     *  Cria Controlador (ctrl + n -> persistencia -> controladorJPA, escolhe a tabela modificada, joga no pacote persistencia.ControladorJPA)
     *  Limpar banco de dados (DROP SCHEMA public CASCADE; CREATE SCHEMA public;)
     *  Testa se ta persistindo
     * 
     * ToDo:
     * Criar as FK de Agenda, Empresa em Prestador
     * Persistencias a serem criadas:
     *      Agenda
     *      Atendimento
     *      Bairro
     *      Categoria
     *      Cidade
     *      Cliente
     *      Empresa
     *      Endereco
     *      Estado
     *      EstadoSolicitacao
     *      Logradouro
     *      Servico
     *      Solicitacao
     *      
     * comments:
     * Não possui Usuario nem Acesso na persistencia, os atributos deles são salvos nas classes que as herdam.
     * Bem não deveria criar a tabela.. não sei pq diachos cria ._. Não existe elas na persistencia, muito menos controladores..
     * Talvez a primeira vez que rodei tenha configurado algo que se configura apenas na primeira rodada.. Não faço ideia :/
     * 
     * as colunas com "s" no final e com tipo bytea são "Set"s ou seja elas carregam todos os objetos em que estão linkados 
     * (todas as linhas da tabela indicada, isso acredito que vá facilitar muito na Aplicação no momento de buscar os dados do banco :D)
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

        p1.setCpf("12671893149");
        p1.setUsuario("Jimm");
        p1.setSenha("1234");
        p1.setNome("Luiz Antonio");
        p1.setTelefone("027998065439");
        p1.setHorarioTrabalho(hT1);
//        p1.setAgenda(agenda);
//        p1.setEmpresa(empresa);
        
        
        hTJpa.create(hT1);
        prestadorJpa.create(p1);
        
        
        //prestadorJpa.create(p2);


        
    }
    
}
