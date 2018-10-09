/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 20161bsi0403
 */
public class testeProtocoloGenerator {
    public static void main(String[] args) {
        ProtocoloGenerator p = null;
        long protocol;
        long protocol2;
        protocol= p.INSTANCE.getNextProtocol();
        
        System.out.println(" protocol : " + protocol + "\n");
        
        protocol2 = p.INSTANCE.getNextProtocol();
        System.out.println(" Protocol 2 : " + protocol2 + "\n");
    }
}
