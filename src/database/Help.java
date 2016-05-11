/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class Help {
    public static Date getDate(int year,int month,int day){
        if(!(isValidDate(String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day))))
            return null;
        Date newDate = new Date(year-1900,month-1,day);
        Date today = new Date(System.currentTimeMillis());
        Date minimumDate = new Date(1900-1900,01-1,01);
        if(!(newDate.compareTo(today)<1&&newDate.compareTo(minimumDate)>-1))            
            return null;        
        return newDate;
    }
    public static int getYear(Date date){
        return date.getYear()+1900;
    }
    public static int getMonth(Date date){
        return date.getMonth()+1;
    }
    public static int getDay(Date date){
        return date.getDate();
    }
    
    
    
    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());           
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
   
   
    
    
}