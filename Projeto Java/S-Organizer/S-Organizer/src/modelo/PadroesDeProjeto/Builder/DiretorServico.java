/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.PadroesDeProjeto.Builder;

import java.sql.Time;
import modelo.Categoria;
import modelo.Servico;

/**
 *
 * @author 20161bsi0403
 */
public class DiretorServico {
   
    
    public Servico builder(String categoria, String descricao,
            double valor, Time horarioMarcado) throws Exception{
        Servico service = new Servico();
        
        BuilderServico builder = new BuilderServico(categoria, descricao, valor, horarioMarcado, service);
        
        builder.geraCategoria();
        builder.geraDescricao();
        builder.geraHorarioMarcado();
        builder.geraValor();
        
        return service;
    }
}
