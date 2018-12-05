/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.builder;

import modelo.Bairro;
import modelo.Cidade;
import modelo.Endereco;
import modelo.Estado;
import modelo.Logradouro;

/**
 *
 * @author luizg
 */
public class BuilderEndereco {
    private String estado; //tudo isso é nome
    private String cidade;
    private String bairro;
    private String logradouro;
    private String complemento; //endereco
    private String cep;
    
    private Estado est;
    private Cidade cid;
    private Bairro bai;
    private Logradouro log;
    
    private Endereco end;

    public BuilderEndereco(String estado, String cidade, String bairro, 
            String logradouro, String complemento, String cep,Endereco end) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.cep = cep;
    }

    public void BuildEstado(){
        est = new Estado();
        est.setEstado(estado);
    }
    
    public void BuildCidade(){
        cid = new Cidade();
        cid.setCidade(cidade);
        cid.setEstado(est);
    }
    
    public void BuildBairro(){
        bai = new Bairro();
        bai.setBairro(bairro);
        bai.setCidade(cid);
    }
    
    public void BuildLogradouro(){
        log = new Logradouro();
        log.setLogradouro(logradouro);
        log.setBairro(bai);
    }
    
    public void BuildEndereco(){
        end.setComplemento(complemento);
        end.setCep(cep);
        end.setLogradouro(log);

    }
}
