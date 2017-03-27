/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transjakarta_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class findLoc {
    
    private String region;
    private String location;
    private String busStop;
    private boolean gotBusStop = false;
    
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    findLoc(String region, String location){
        this.region = region;
        this.location = location;
        connectDB();
    }
    
    public final void connectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test2?zeroDateTimeBehavior=convertToNull", user = "root", password = "";
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select * from tj";
            rs = stmt.executeQuery(query);
            rs.next();
        }catch(SQLException e){
            System.out.println(e);
            //JOptionPane.showMessageDialog(this, e.getMessage());
        }catch (ClassNotFoundException ex) {
            //JOptionPane.showMessageDialog(this, ex.getMessage());
            //Logger.getLogger(JListFirstAssignment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void findBusStop(){
        String[] nearBys;
        String nearBy;
        try{
            rs.beforeFirst();
            while(!gotBusStop){
                rs.next();
                if(this.region.equals(rs.getString("region"))){
                    nearBy = rs.getString("nearby");
                    //nearBy = nearBy.replaceAll("\\s","");
			
                    nearBys = nearBy.split(",\\s");
                    for(int i = 0; i < nearBys.length; i++){
                        if(location.equals(nearBys[i])){
                            this.busStop = rs.getString("halte");
                            gotBusStop = true;
                            break;
                        }
                    }
                }
            }
        } catch (SQLException e){
            System.out.println(e);
        }
    }
    
    public String getBusStop(){
        findBusStop();
        return this.busStop;
    }
}
