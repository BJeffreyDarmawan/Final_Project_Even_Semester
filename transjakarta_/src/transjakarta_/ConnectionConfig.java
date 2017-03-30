/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transjakarta_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mikha Putri
 */
public class ConnectionConfig {
    public static Connection con;
    
    public static Connection createConnection() throws ClassNotFoundException{
        try {
            if(con==null){
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/transjakarta", user = "root", password = "";
                con = DriverManager.getConnection(url, user, password);
            }
            else{
                //System.out.print("connection has been created");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public static void closeConnection()
    {
        try{
          if(con!=null)
          {
              con.close();
          }
        }catch(SQLException ex){
            System.out.print(ex);
        }
        
    }
    
        
    
}
