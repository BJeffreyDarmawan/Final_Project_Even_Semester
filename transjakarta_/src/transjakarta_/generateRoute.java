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
    
    ArrayList<String> haltePoints = new ArrayList();
    ArrayList<findLoc> Transit;
    ArrayList<String> halteRoute = new ArrayList();
    
    generateRoute(){
        
    }
    
    generateRoute(int a){
        
    }
    
    generateRoute(findLoc Departure, findLoc Destination){
        this.Departure = Departure;
        this.Destination = Destination;
        connectDB();
    }
    
    public final void connectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/tj", user = "root", password = "";
            con = DriverManager.getConnection(url, user, password);
            stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }catch(SQLException e){
            System.out.println(e);
        }catch (ClassNotFoundException ex) {
            //JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    public boolean doWeHaveSameStops(String a, String b){
        try{
            rs1 = stmt1.executeQuery("select * from tj where corridor = '" + a + "'");
            rs2 = stmt2.executeQuery("select * from tj where corridor = '" + b + "'");
            while(true){
                rs1.next();
                rs2.beforeFirst();
                while(rs2.next()){
                    if(rs1.getString("halte").equals(rs2.getString("halte"))){
                        haltePoints.add(rs1.getString("halte"));
                        return true;
                    }
                }
            }
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    public void goToRS(){
        try{
            rs1.first(); rs1.previous();
            while(true){
                rs1.next();
                if(rs1.getString("halte").equals(Departure.getBusStop())){
                    break;
                }
            }
        }catch(SQLException ex){
            //JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    /*
    public void iteratelah(String halte, String halte){
        if()
    }
        
    if indexTransit > indexDepart go forth
    */
    public void gataunimethodapa(){
        try{
            if(Departure.getCorridor().equals(Destination.getCorridor())){
                //iArrCorridorPassed = Departure.getCorridor();
                //System.out.println(Departure.getCorridor());
                
                rs1 = stmt1.executeQuery("select * from tj where corridor = '" + Departure.getCorridor() + "'");
                goToRS();
                halteRoute.add(rs1.getString("halte"));
                if(Departure.getIndex() < Destination.getIndex()){
                    while(rs1.next()){
                        halteRoute.add(rs1.getString("halte"));
                        if(rs1.getString("halte").equals(Destination.getBusStop())){
                            break;
                        }
                    }
                } else {
                    while(rs1.previous()){
                        System.out.println("abcd");
                        halteRoute.add(rs1.getString("halte"));
                        if(rs1.getString("halte").equals(Destination.getBusStop())){
                            break;
                        }
                    }
                }
                //gotors departure, loop, add busstops
            } else if(doWeHaveSameStops(Departure.getCorridor(), Destination.getCorridor())){
                
                ResultSet freelance = stmt1.executeQuery("select * from tj where corridor = '" + Departure.getCorridor() + "'");
                
                //for(int i = 0; i < Transit.size(); i++){
                if(Departure.getIndex() < Transit.get(0).getIndex()){
                    while(rs1.next()){
                        halteRoute.add(rs1.getString("halte"));
                        if(rs1.getString("halte").equals(Destination.getBusStop())){
                            break;
                        }
                    }
                } else {
                    while(rs1.previous()){
                        halteRoute.add(rs1.getString("halte"));
                        if(rs1.getString("halte").equals(Destination.getBusStop())){
                            break;
                        }
                    }
                }
                //}
                //ResultSet rsRoute = stmt1.executeQuery("select * from tj where ");
            } else {
                
            }
        } catch (SQLException e){
            System.out.println(e);
        }
        
    }
    
    public ArrayList getRoute(){
        gataunimethodapa();
        return halteRoute;
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
        findLoc Departure = new findLoc("South Jakarta", "Fx Sudirman");
        findLoc Destination = new findLoc("Central Jakarta", "Atma Jaya");
        //findLoc Destination = new findLoc("West Jakarta", "Apartemen Kedoya Elok");
        generateRoute WEH = new generateRoute(Departure, Destination);
        System.out.println(Departure.getCorridor());
        System.out.println(Destination.getCorridor());
        System.out.println(WEH.getRoute());
        if(abc.doWeHaveSameStops("1", "8")){
            System.out.println("abc");
        }
    }
    
    
    
}
