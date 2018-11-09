/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.PadroesDeProjeto.Builder;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Categoria;
import modelo.Servico;

/**
 *
 * @author 20161bsi0403
 */
public class BuilderServico {
    private Servico servico;
    private String categoria;
    private String descricao;
    private double valor;
    private String horarioMarcado;   ///Falta tratar o horario como String
    
    public BuilderServico(String categoria, String descricao,
            double valor, String horarioMarcado, Servico service){
            
            this.servico=service;
            this.categoria=categoria;
            this.valor=valor;
            this.horarioMarcado=horarioMarcado;
            this.descricao=descricao;
            this.servico.setEstado(false);   /// false = não feito
           /// this.servico.setAtendimento(atendimento);   falta tratar
    }
    
    public void geraCategoria() throws Exception{
        this.servico.setCategoria(categoria);
    }

    public void geraDescricao(){
        this.servico.setDescricao(descricao);
    }
    
    public void geraValor(){
        this.servico.setValor(valor);
    }
    
    public void geraHorarioMarcado() throws ParseException{
        Time h;
        DateFormat formato = new SimpleDateFormat("HH:mm:ss");

        h = new java.sql.Time(formato.parse(this.horarioMarcado).getTime());
        System.out.println(h.toString());
        this.servico.setHorarioMarcado(h);
    }
    
    ///verificar
    
    
       
    }

