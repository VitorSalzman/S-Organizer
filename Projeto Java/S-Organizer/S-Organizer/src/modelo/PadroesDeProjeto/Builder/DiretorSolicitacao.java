/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.PadroesDeProjeto.Builder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelo.Servico;
import modelo.Solicitacao;

/**
 *
 * @author Salzman
 */
public class DiretorSolicitacao {
   
    public Solicitacao builder(Date disp_cli_ini, Date disp_cli_fim, String descricao,
            String observacao, Date dataSolicitacao, ArrayList<Servico> servicos){
            Solicitacao solicitacao = new Solicitacao();
            
            BuilderSolicitacao builder = new BuilderSolicitacao(disp_cli_ini, disp_cli_fim, descricao,
            observacao, dataSolicitacao,  servicos, solicitacao);
        
            builder.geraProtocolo();
            builder.setDisponibilidades();
            builder.adicionaServicos();
            
            return solicitacao;
    }
}
