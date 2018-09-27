package s.organizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 20161bsi0284
 */
public enum ProtocoloGenerator {
    INSTANCE;
    
    private long count = System.currentTimeMillis();
    
    public synchronized long getNextProtocol(){
        return count++;
    }
    
    
}
