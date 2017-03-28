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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javafx.scene.control.ComboBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class findLoc {
    
    private String region;
    private String location;
    private String busStop;
    private int indx;
    private String corridor;
    private boolean gotBusStop = false;
    
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    findLoc(){
        connectDB();
        findBusStop();
    }
    
    findLoc(String region, String location){
        this.region = region;
        this.location = location;
        connectDB();
        findBusStop();
    }
    
    public int getIndex(){
        return indx;
    }
    
    public String getCorridor(){
        return corridor;
    }
        
    public final void connectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/tj?zeroDateTimeBehavior=convertToNull", user = "root", password = "";
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
			
                    nearBys = nearBy.split(",\\s");
                    for(int i = 0; i < nearBys.length; i++){
                        if(location.equals(nearBys[i])){
                            this.busStop = rs.getString("halte");
                            this.corridor = rs.getString("corridor");
                            this.indx = rs.getInt("index");
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
        return this.busStop;
    }

    public ArrayList getNearby(String reg)
    {
        ArrayList<String> nearBys = new ArrayList();
        String nearBy;
        String[] test;
        //System.out.println(reg);
        try{
            rs = stmt.executeQuery("select * from tj where region = '" + reg + "'");
            while(rs.next()){
                nearBy = rs.getString("nearby");
                test = nearBy.split(",\\s");
                ArrayList<String> list = new ArrayList(Arrays.asList(test));
                nearBys.addAll(list);
            }
        }catch(SQLException e)
        {
           System.out.println(e);
        }
        return nearBys;
    }

    
    public int getIndex(){
        return rs.getInt("index");
    }
    
    public String getCorridor(){
        return rs.getString("corridor");
    }
}

   