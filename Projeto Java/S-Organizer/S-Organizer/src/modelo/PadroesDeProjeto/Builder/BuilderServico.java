/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.builder;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import modelo.Servico;
import modelo.Atendimento;
import modelo.Categoria;

public class BuilderServico {
    private Servico servico;
    private Categoria categoria; //acredito que essa categoria agora é uma classe, logo esta dando conflito.
    private String descricao;
    private String valor;
    private String horarioMarcado;   ///Falta tratar o horario como String
    
    public BuilderServico(String categoria, String descricao,
            String valor, String horarioMarcado, Servico service){
            
            this.servico=service;
            this.categoria.setDescricao(categoria);
            this.valor=valor;
            this.horarioMarcado=horarioMarcado;
            this.descricao=descricao;
            this.servico.setEstado(false);   /// false = não feito
    }
    
    public void geraCategoria() throws Exception{
        this.servico.setCategoria(categoria);
    }

    public void geraDescricao(){
        this.servico.setDescricao(descricao);
    }
    
    public void geraValor(){
        double aDouble = Double.parseDouble(valor);
        this.servico.setValor(aDouble);
    }
    
    public void geraHorarioMarcado() throws ParseException{
        Time h;
        DateFormat formato = new SimpleDateFormat("HH:mm:ss");

        h = new java.sql.Time(formato.parse(this.horarioMarcado).getTime());
        this.servico.setHorarioMarcado(h);
    }
    
    ///verificar
    
    
       
    }