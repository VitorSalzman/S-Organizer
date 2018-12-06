/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.builder;

import modelo.Endereco;

/**
 *
 * @author luizg
 */
public class DiretorEndereco {
    public Endereco builder(String estado, String cidade, String bairro, 
            String logradouro, String complemento, String cep){
        Endereco end = new Endereco();
        BuilderEndereco builderEndereco = new BuilderEndereco(estado,cidade,bairro,logradouro,complemento,cep,end);
        
        builderEndereco.BuildEstado();
        builderEndereco.BuildCidade();
        builderEndereco.BuildBairro();
        builderEndereco.BuildLogradouro();
        builderEndereco.BuildEndereco();
        
        return end;
    }
}
