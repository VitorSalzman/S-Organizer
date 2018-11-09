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
public class teste{
    
    public static void main(String[] args) {
        try {
		String data = "16/07/2008";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(data));
                data = sdf.format(cal.getTime());
                System.out.println(data);
                System.out.println("aqui");
	} catch (ParseException e) {
		e.printStackTrace();
	}     
    }
}    
    
  

