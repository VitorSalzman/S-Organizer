/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.util.Date;
import java.util.Scanner;
import modelo.Agenda;
import modelo.Atendimento;
import modelo.Bairro;
import modelo.Categoria;
import modelo.Cidade;
import modelo.Cliente;
import modelo.Empresa;
import modelo.Endereco;
import modelo.Estado;
import modelo.Logradouro;
import modelo.Prestador;
import modelo.Servico;
import modelo.Solicitacao;
import modelo.padroesdeprojeto.dao.DAOAgenda;
import modelo.padroesdeprojeto.dao.DAOAtendimento;
import modelo.padroesdeprojeto.dao.DAOBairro;
import modelo.padroesdeprojeto.dao.DAOCategoria;
import modelo.padroesdeprojeto.dao.DAOCidade;
import modelo.padroesdeprojeto.dao.DAOCliente;
import modelo.padroesdeprojeto.dao.DAOEmpresa;
import modelo.padroesdeprojeto.dao.DAOEndereco;
import modelo.padroesdeprojeto.dao.DAOEstado;
import modelo.padroesdeprojeto.dao.DAOLogradouro;
import modelo.padroesdeprojeto.dao.DAOPrestador;
import modelo.padroesdeprojeto.dao.DAOServico;
import modelo.padroesdeprojeto.dao.DAOSolicitacao;

/**
 *
 * @author luizg
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        //instanciando todos os DAOs
        DAOAgenda daoAgenda = new DAOAgenda();
        DAOAtendimento daoAtendimento = new DAOAtendimento();
        DAOBairro daoBairro = new DAOBairro();
        DAOCategoria daoCategoria = new DAOCategoria();
        DAOCidade daoCidade = new DAOCidade();
        DAOCliente daoCliente = new DAOCliente();
        DAOEmpresa daoEmpresa = new DAOEmpresa();
        DAOEndereco daoEndereco = new DAOEndereco();
        DAOEstado daoEstado = new DAOEstado();
        DAOLogradouro daoLogradouro = new DAOLogradouro();
        DAOPrestador daoPrestador = new DAOPrestador();
        DAOServico daoServico = new DAOServico();
        DAOSolicitacao daoSolicitacao = new DAOSolicitacao();
        
        //instanciando todas as classes
        Agenda agenda = new Agenda();
        Atendimento atendimento = new Atendimento();
        Bairro bairro = new Bairro();
        Categoria categoria = new Categoria();
        Cidade cidade = new Cidade();
        Cliente cliente = new Cliente();
        Empresa empresa = new Empresa();
        Endereco endereco = new Endereco();
        Estado estado = new Estado();
        Logradouro logradouro = new Logradouro();
        Prestador prestador = new Prestador();
        Servico servico = new Servico();
        Solicitacao solicitacao = new Solicitacao();
        
        System.out.println("Criação de Empresa");
        System.out.println("Porfavor digite os campos solicitados");
        
        System.out.println("CNPJ: ");
        Scanner input = new Scanner(System.in);
        String val = input.nextLine();
        empresa.setCnpj(val);
        
        System.out.println("Login: ");
        input = new Scanner(System.in);
        val = input.nextLine();
        empresa.setLogin(val);
        
        System.out.println("Nome: ");
        input = new Scanner(System.in);
        val = input.nextLine();
        empresa.setNome(val);
        
        System.out.println("Senha: ");
        input = new Scanner(System.in);
        val = input.nextLine();
        empresa.setSenha(val);
        
        System.out.println("Telefone");
        input = new Scanner(System.in);
        val = input.nextLine();
        empresa.setTelefone(val);
        
        System.out.println("Agora digite os dados do prestador que irá fazer parte da empresa");
        
        System.out.println("CPF: ");
        input = new Scanner(System.in);
        val = input.nextLine();
        prestador.setCpf(val);
        
        System.out.println("Login: ");
        input = new Scanner(System.in);
        val = input.nextLine();
        prestador.setLogin(val);
        
        System.out.println("Nome: ");
        input = new Scanner(System.in);
        val = input.nextLine();
        prestador.setNome(val);
        
        System.out.println("Senha: ");
        input = new Scanner(System.in);
        val = input.nextLine();
        prestador.setSenha(val);
        
        System.out.println("Telefone");
        input = new Scanner(System.in);
        val = input.nextLine();
        prestador.setTelefone(val);
        
        prestador.setDisponibilidade(true);
        prestador.setHorarioInicio(new Date());
        prestador.setHorarioFim(new Date());
        
        empresa.setPrestador(prestador);
        
        daoPrestador.inserir(prestador);
        daoEmpresa.inserir(empresa);
        
    }
    
}
