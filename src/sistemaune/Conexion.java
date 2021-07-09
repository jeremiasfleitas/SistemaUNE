/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaune;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Fernando
 */
public class Conexion {
    String host="192.168.0.30";
    String port="5432";
    String db_name="db_institucion";
    String username="postgres";
    String password="2008mini";
               
    public Connection conexion(){
        Connection connection = null;
        
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password+"");
            if (connection != null) {
                System.out.println("Connection OK");
            }else{
                System.out.println("Connection failed");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }
   
}
