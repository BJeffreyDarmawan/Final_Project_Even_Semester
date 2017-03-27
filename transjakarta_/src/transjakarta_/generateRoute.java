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

/**
 *
 * @author Lenovo
 */
public class generateRoute {
    //private generateRoute fastest = new generateRoute();
    //private generateRoute shortest = new generateRoute();
    
    Connection con;
    Statement stmt1, stmt2;
    ResultSet rs1, rs2;
    String halte;
    
    public final void connectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/tj_busstops", user = "root", password = "";
            con = DriverManager.getConnection(url, user, password);
            stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //String query = "select * from tj";
            //rs = stmt.executeQuery(query);
            //rs.next();
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
    
    public void goToRS(ResultSet rs){
        try{
            ResultSet watrs = rs;
            watrs.first(); watrs.previous();
            while(true){
                watrs.next();
                if(watrs.getString("name").equals()){
                    break;
                }
            }
        }catch(SQLException ex){
            //JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    public void makeLeRoute(){
        
    }
    
    public static void main(String[] args) {
        generateRoute abc = new generateRoute();
        abc.connectDB();
        if(abc.doWeHaveSameStops(1, 8)){
            System.out.println("abc");
        }
    }
    
    
    
}
