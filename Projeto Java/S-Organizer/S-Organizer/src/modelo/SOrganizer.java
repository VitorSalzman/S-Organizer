/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;


/**
 *
 * @author 20161bsi0403
 */
public class SOrganizer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente cli = null;
        Empresa adm;
        Prestador p;
        try {
            cli = (Cliente) FabricaUsuarios.retornaUsuario("cliente");
            adm = (Empresa) FabricaUsuarios.retornaUsuario("empresa");
            p = (Prestador) FabricaUsuarios.retornaUsuario("prestador");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        cli.setCpf(123456);
        cli.setCodigo(13);
        cli.setNome("Alberto Bahamas");
        cli.setTelefone(997275424);
        
    }
    
}
