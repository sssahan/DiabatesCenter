/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author sachithra sahan
 */
public class DBOperation {
    private static DBOperation  dbo=null;
    
    private DBOperation(){
        
    }
    
    public static DBOperation getInstance(){//singleton pattern to access database object
        if(dbo==null){
            synchronized(DBOperation.class){
                dbo=new DBOperation();
            }
        }
        return dbo;
    }
}
