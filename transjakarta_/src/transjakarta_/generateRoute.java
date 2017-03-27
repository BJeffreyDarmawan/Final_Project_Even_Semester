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

/**
 *
 * @author Lenovo
 */
public class generateRoute {
    //private generateRoute fastest = new generateRoute();
    //private generateRoute shortest = new generateRoute();
    
    findLoc Departure;
    findLoc Destination;
    
    Connection con;
    Statement stmt1, stmt2;
    ResultSet rs1, rs2;
    String halte;
    
    ArrayList<String> halteRoute = new ArrayList();
    
    generateRoute(){
        
    }
    
    generateRoute(int a){
        
    }
    
    public final void connectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/tj_busstops", user = "root", password = "";
            con = DriverManager.getConnection(url, user, password);
            stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }catch(SQLException e){
            System.out.println(e);
            //JOptionPane.showMessageDialog(this, e.getMessage());
        }catch (ClassNotFoundException ex) {
            //JOptionPane.showMessageDialog(this, ex.getMessage());
            //Logger.getLogger(JListFirstAssignment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean doWeHaveSameStops(int a, int b){
        try{
            rs1 = stmt1.executeQuery("select * from tj where corridor = '" + Integer.toString(a) + "'");
            rs2 = stmt2.executeQuery("select * from tj where corridor = '" + Integer.toString(b) + "'");
            while(true){
                rs1.next();
                rs2.beforeFirst();
                while(rs2.next()){
                    if(rs1.getString("halte").equals(rs2.getString("halte"))){
                        halte = rs1.getString("halte");
                        return true;
                    }
                }
            }
        }catch(SQLException e){
            System.out.println(e);
            return false;
            //JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void goToRS(){
        try{
            ResultSet watrs = rs1;
            watrs.first(); watrs.previous();
            while(true){
                watrs.next();
                if(watrs.getString("halte").equals(halte)){
                    break;
                }
            }
        }catch(SQLException ex){
            //JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    public void iteratelah(String halte, String halte){
        if()
    }
        
    if indexTransit > indexDepart go forth
    
    public void gataunimethodapa(int a, int b){
        try{
            if(Departure.getCorridor().equals(Destination.getCorridor())){
                
    //gotors departure, loop, add busstops
            } else if(doWeHaveSameStops(Integer.valueOf(rs1.getString("corridor")), Integer.valueOf(rs2.getString("corridor")))){
                ResultSet rsRoute = stmt1.executeQuery("select * from tj where ");
            } else {
                
            }
            
            
        } catch (SQLException e){
            System.out.println(e);
        }
        
    }
    
    /*
    public void makeLeRoute(){
        boolean niga = false;
        while(rs.next()){
            if
        }
        
    }*/
    
    public static void main(String[] args) {
        generateRoute abc = new generateRoute();
        abc.connectDB();
        if(abc.doWeHaveSameStops(1, 8)){
            System.out.println("abc");
        }
    }
    
    
    
}
