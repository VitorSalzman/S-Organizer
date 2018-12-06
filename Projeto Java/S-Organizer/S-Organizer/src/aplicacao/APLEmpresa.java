/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import modelo.padroesdeprojeto.fabrica.FabricaUsuarios;
import modelo.Prestador;
import modelo.Servico;
import modelo.Solicitacao;
import modelo.padroesdeprojeto.builder.DiretorServico;
import modelo.padroesdeprojeto.builder.DiretorSolicitacao;
import modelo.padroesdeprojeto.dao.DAOPrestador;
import modelo.padroesdeprojeto.dao.DAOSolicitacao;

public class APLEmpresa {
    public ArrayList<Servico> criaListaServico(){
        ArrayList<Servico>  listServices = new ArrayList();
        
        return listServices;
    }
    
    public void addServico(ArrayList<Servico> listServices, String categoria, String descricao, 
            String valor, String horarioMarcado) throws Exception{
        DiretorServico director = new DiretorServico();
        Servico service = new Servico();
        service = director.builder(categoria, descricao, valor, horarioMarcado);
        listServices.add(service);
    }
    
    public void criaSolicitacao(String disp_cli_ini, String disp_cli_fim,
            String observacao, String dataSolicitacao, ArrayList<Servico> listServices) throws ParseException{
        DiretorSolicitacao director = new DiretorSolicitacao();
        Solicitacao solicit = new Solicitacao();
        
        solicit = director.builder(disp_cli_ini, disp_cli_fim, observacao, dataSolicitacao, listServices);
        
        
        DAOSolicitacao daoSolicitacao = new DAOSolicitacao();
        daoSolicitacao.inserir(solicit);
    }
    
    public Prestador criaPrestador(String user, String horIni, String ch, String cpf, String usuario, 
            String senha, String nome, String telefone) throws Exception{
        Map<String, String> mp = new HashMap<String, String>();
        mp.put("horarioInicio", horIni);
        mp.put("cargaHoraria", ch);
        mp.put("cpf", cpf);
        mp.put("usuario", usuario);
        mp.put("senha", senha);
        mp.put("nome", nome);
        mp.put("telefone", telefone);
        
        FabricaUsuarios faber = new FabricaUsuarios(mp);
        Prestador p = new Prestador();
        
        p=(Prestador) faber.retornaUsuario(user);
        
        DAOPrestador daoPrestador = new DAOPrestador();
        daoPrestador.inserir(p);
        
        return p;
    }
        
    
    
}    
    
    