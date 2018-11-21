/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.Agenda;
import persistencia.Atendimento;
import persistencia.Bairro;
import persistencia.CategoriaServico;
import persistencia.Cidade;
import persistencia.Empresa;
import persistencia.Endereco;
import persistencia.Estado;
import persistencia.EstadoSol;
import persistencia.Logradouro;
import persistencia.Prestador;
import persistencia.Servico;
import persistencia.Solicitacao;
import persistencia.ControladorJPA.AgendaJpaController;
import persistencia.ControladorJPA.AtendimentoJpaController;
import persistencia.ControladorJPA.BairroJpaController;
import persistencia.ControladorJPA.CategoriaServicoJpaController;
import persistencia.ControladorJPA.CidadeJpaController;
import persistencia.ControladorJPA.ClienteJpaController;
import persistencia.ControladorJPA.EmpresaJpaController;
import persistencia.ControladorJPA.EnderecoJpaController;
import persistencia.ControladorJPA.EstadoJpaController;
import persistencia.ControladorJPA.EstadoSolJpaController;
import persistencia.ControladorJPA.LogradouroJpaController;
import persistencia.ControladorJPA.PrestadorJpaController;
import persistencia.ControladorJPA.ServicoJpaController;
import persistencia.ControladorJPA.SolicitacaoJpaController;

/**
 *
 * @author luizg
 */
public class Main_Aplicativo {

    /**
     * Manual: (ALL DONE 11/11 )
     * Sequencia para criação de uma persistencia:
     *  Define as variaveis
     *  Nomear as Colunas
     *  Adicionar Annotation com length se for String (isso define o tamanho do varchar)
     *  Cria toString (utilize alt + insert , isso é um atalho)
     *  Criar hash e equals
     *  Criar get e set
     *  Deleta Controlador da persistencia modificado
     *  Cria Controlador (ctrl + n -> persistencia -> controladorJPA, escolhe a tabela modificada, joga no pacote persistencia.ControladorJPA)
     *  Limpar banco de dados (DROP SCHEMA public CASCADE; CREATE SCHEMA public;)
     *  Testa se ta persistindo
     * 
     * ToDo:
     *  Jogar valores dentro do banco.
     *  Trocar todos os .toString() para carregar apenas os atributos, nada de links nem arrayLists.
     *      
     * comments:
     * Não possui Usuario nem Acesso na persistencia, os atributos deles são salvos nas classes que as herdam.
     * Bem não deveria criar a tabela.. não sei pq diachos cria ._. Não existe elas na persistencia, muito menos controladores..
     * Talvez a primeira vez que rodei tenha configurado algo que se configura apenas na primeira rodada.. Não faço ideia :/
     * 
     * tudo que vc ler type Set é ArrayList, to com preguiça de ler esse texto todo e corrigir. Eu mudei no codigo ja..
     * 
     * as colunas com "s" no final e com type "bytea" são "Set"s ou seja elas carregam todos os objetos em que estão linkados 
     * (todas as linhas da tabela indicada, isso acredito que vá facilitar muito na Aplicação no momento de buscar os dados do banco :D)
     * 
     * Existe construtores, porem eles não setam o Set, ou seja não mostram no que ele esta linkado.
     * Recomendo usar o .set() msm
     * 
     * Testar:
     * 
     *
     */
    public static void main(String[] args) {
        
        // Iniciar a Persistencia
        EntityManagerFactory objFactory = Persistence.createEntityManagerFactory("S-Organizer2PU");
        EntityManager manager = objFactory.createEntityManager();
        
        // Gerando "randoms" Time
        final Random random = new Random();
        final int millisInDay = 24*60*60*1000;
        
        Time time = new Time((long)random.nextInt(millisInDay));
        Time time2 = new Time((long)random.nextInt(millisInDay));
        
        Date date = new Date(2015,11,2);
        
        
        // instanciar Controladores *primeiras 2 letras + Jpa*
        AgendaJpaController agJpa = new AgendaJpaController(objFactory);
        AtendimentoJpaController atJpa = new AtendimentoJpaController(objFactory);
        BairroJpaController baJpa = new BairroJpaController(objFactory);
        CategoriaServicoJpaController caJpa = new CategoriaServicoJpaController(objFactory);
        CidadeJpaController ciJpa = new CidadeJpaController(objFactory);
        ClienteJpaController clJpa = new ClienteJpaController(objFactory);
        EmpresaJpaController emJpa = new EmpresaJpaController(objFactory);
        EnderecoJpaController enJpa = new EnderecoJpaController(objFactory);
        EstadoJpaController esJpa = new EstadoJpaController(objFactory);
        EstadoSolJpaController esSJpa = new EstadoSolJpaController(objFactory);
        LogradouroJpaController loJpa = new LogradouroJpaController(objFactory);
        PrestadorJpaController prJpa = new PrestadorJpaController(objFactory);
        ServicoJpaController seJpa = new ServicoJpaController(objFactory);
        SolicitacaoJpaController soJpa = new SolicitacaoJpaController(objFactory);
        

        // Instanciando Entidades persistiveis *primeiras 2 letras + numero*
        Agenda ag1 = new Agenda();
        Atendimento at1 = new Atendimento();
        Bairro ba1 = new Bairro();
        CategoriaServico ca1 = new CategoriaServico();
        Cidade ci1 = new Cidade();
        Empresa em1 = new Empresa();
        Endereco en1 = new Endereco();
        Estado es1 = new Estado();
        EstadoSol esS1 = new EstadoSol();
        Logradouro lo1 = new Logradouro();
        Prestador pr1 = new Prestador();
        Servico se1 = new Servico();
        Solicitacao so1 = new Solicitacao();

        
        
        /*
        Preencher todos os campos (ou seja todos os .set(), MENOS O ID)
        Precisa seguir a logica das pontas pro nucleo, para que todos se linkem corretamente
        */
        
        //NAO ESTA COMPLETO (não ta funcionando corretamente)
        
        /*
        TESTAR USANDO O PROJETO QUE VC CLONOU LUIZ "DATAFACTORY"
        */
        // HorarioTrabalho
        ho1.setHorarioinicio(time);
        ho1.setHorariofim(time2);
        
                
        // Prestador
        pr1.setCpf("12671893149");
        pr1.setHorarioTrabalho(ho1);
//        pr1.setAgenda(ag1);
//        pr1.setEmpresa(em1);
        
        hoJpa.create(ho1);
        prJpa.create(pr1);
        
        List<Prestador> listaPrestadores = hoJpa.findHorarioTrabalho(851L).getPrestadors();
        for (Prestador prestador : listaPrestadores) {
            System.out.println("prestador = " + prestador.toString());
        }
// não ta printando o ID pq ele só tem o ID depois que salva, ou seja a gente manda salvar ele no arrayList
// o ID fica nulo, mas quando a gente manda salvar no banco o banco seta o novo ID
        
        
        //prestadorJpa.create(p2);

    }
}  

