/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s.organizer;

/**
 *
 * @author 20161bsi0403
 */
public enum Categoria {
    INSTALACAO("instalacao"),REPARO("reparo"),CONSTRUCAO("construcao"),LIMPEZA("limpeza"),ENTREGA("entrega"),BUSCA("busca");
    
    private String descricao;

    Categoria(String category){
        this.descricao=category;
}
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String category)
    {
        this.descricao=category;
    }
    
    
}
