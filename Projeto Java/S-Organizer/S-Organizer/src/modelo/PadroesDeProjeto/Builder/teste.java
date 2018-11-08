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
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitorsalzman
 */
public class teste {
    
    public static void main(String[] args) {
        String hora = "01:10:2005";
        DateFormat h ;
        DateFormat formato = new SimpleDateFormat("DD:mm:AAAA");

        try {
            h = new java.sql.Time(formato.parse(hora).getTime());
            System.out.println(h.toString());
        } catch (ParseException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }
}    
    
  

