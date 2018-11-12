/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.builder;

import modelo.Servico;

/**
 *
 * @author Salzman
 */
public class DiretorServico {
   
    
    public Servico builder(String categoria, String descricao,
            String valor, String horarioMarcado) throws Exception{
        Servico service = new Servico();
        
        BuilderServico builder = new BuilderServico(categoria, descricao, valor, horarioMarcado, service);
        
        builder.geraCategoria();
        System.out.println(service.getCategoria().toString());
        builder.geraDescricao();
        System.out.println(service.getDescricao());
        builder.geraHorarioMarcado();
        System.out.println(service.getHorarioMarcado().toString());
        builder.geraValor();
        System.out.println(service.getValor());
        
        
        return service;
    }
}