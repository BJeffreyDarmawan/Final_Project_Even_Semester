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
    String[] arrCorridorsList = {"1", "4C", "2", "8", "10", "12"};
    
    ArrayList<String> haltePoints = new ArrayList();
    ArrayList<findLoc> Transit = new ArrayList();
    ArrayList<String> halteRoute = new ArrayList();
    ArrayList<String> corridorPassed = new ArrayList();
    
    generateRoute(){
        
    }
    
    generateRoute(int a){
        
    }
    
    generateRoute(findLoc Departure, findLoc Destination){
        this.Departure = Departure;
        this.Destination = Destination;
        Departure.chooseCorridor(Destination.getCorridors()); Destination.chooseCorridor(Departure.getCorridors());
        connectDB();
    }
    
    public final void connectDB(){
        try{
            //singleton
            con = ConnectionConfig.createConnection();
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
                        //System.out.println(rs1.getString("halte"));//haltePoints.add(rs1.getString("halte"));
                        return true;
                    }
                }
            }
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    public void goToRS(int i){
        try{
            rs1.first(); rs1.previous();//System.out.print(haltePoints.get(i));System.out.println(i);
            while(true){
                rs1.next();
                if(rs1.getString("halte").equals(haltePoints.get(i))){System.out.println(haltePoints.get(i) + " line 92");
                    break;
                } 
            }System.out.println(haltePoints.get(i) + " line 95 " + rs1.getInt("index"));
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
                
                rs1 = stmt1.executeQuery("select * from tj where corridor = '" + Departure.getCorridor() + "'");
                goToRS(0); 
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
            } else {
                haltePoints.add(Departure.getBusStop()); 
                Transit.add(new findLoc(Departure.getBusStop()));
                findCorridorAndTransit(Departure.getCorridor(), Destination.getCorridor()); System.out.println(Transit.get(0).getBusStop());showTransits(); System.out.println("INI CORRIDOR PASSED" + corridorPassed);//System.out.println(haltePoints);
                for(int i = 0; i < corridorPassed.size(); i++){System.out.println(corridorPassed.size() + " line 136");
                    rs1 = stmt1.executeQuery("select * from tj where corridor = '" + corridorPassed.get(i) + "'");  
                    goToRS(i);
                    halteRoute.add(rs1.getString("halte")); //System.out.println(Transit.get(i+1).getCorridors());
                    System.out.println(corridorPassed.get(i) + " line 159");
                    Transit.get(i+1).chooseCorridor(new ArrayList<String>(Arrays.asList(corridorPassed.get(i))));System.out.println(Transit.get(i+1).getCorridor());
                    Transit.get(i).chooseCorridor(new ArrayList<String>(Arrays.asList(corridorPassed.get(i))));//System.out.println(Transit.get(i).getIndex() + " line 160 " + i + " " + Transit.size());
                    
                    System.out.println(haltePoints.get(i) + "  " + rs1.getInt("index") + " berangkat ::" + Transit.get(i).getIndex() + " brenti : " +Transit.get(i+1).getIndex());
                    //System.out.println(rs1.getInt("index") + "sini" +Transit.get(i+1).getIndex());
                    if(rs1.getInt("index") < Transit.get(i+1).getIndex()){
                        while(rs1.next()){
                            halteRoute.add(rs1.getString("halte"));
                            if(rs1.getString("halte").equals(Transit.get(i+1).getBusStop())){
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
                }
            }
        } catch (SQLException e){
            System.out.println(e);
            System.out.println("ErrorAtIDKWHATMETHOD");
        }
        
    }
    //recursion
    int a = 0;
    public void findCorridorAndTransit(String corridorA, String corridorB){
        try{System.out.println("findCorridorAndTransiit");
        
            if(doWeHaveSameStops(corridorA, corridorB) && !corridorB.equals(corridorA)){ 
                Transit.add(new findLoc(rs1.getString("halte")));
                haltePoints.add(rs1.getString("halte"));
                corridorPassed.add(rs1.getString("corridor"));System.out.println(haltePoints);
                if(corridorB.equals(Destination.getCorridor())){ 
                    corridorPassed.add(Destination.getCorridor());  
                    Transit.add(new findLoc(Destination.getBusStop()));
                    haltePoints.add(Destination.getBusStop()); System.out.println(corridorPassed + "line 198");
                    return;
                } else {
                    System.out.println("UNFORTINATELY IT GOES HERE"); a=0;
                    findCorridorAndTransit(corridorB, Destination.getCorridor()); //dia muter2 disini
                }
            } else {
                System.out.println("YES IT GOES HERE!!"); System.out.println(corridorA);/*
                if (corridorB.equals(Departure.getCorridor()) || corridorB.equals(arrCorridorsList[a])) {
                    a++;
                }
                findCorridorAndTransit(corridorA, arrCorridorsList[a++]);*/
                /*
                while(corridorB.equals(Departure.getCorridor()) && corridorB.equals(arrCorridorsList[a])){
                    a++;
                }*/
                //findCorridorAndTransit(corridorA, arrCorridorsList[a++]);
                for(int i = 0; i < arrCorridorsList.length; i++){
                    if(doWeHaveSameStops(corridorA, arrCorridorsList[i]) && doWeHaveSameStops(arrCorridorsList[i], corridorB)){
                        findCorridorAndTransit(corridorA, arrCorridorsList[i]);
                    }
                }
            }
        } catch (SQLException e){
            System.out.println("Error at findCorridorAndTransit");
        }
    }
    
    public ArrayList getRoute(){
        gataunimethodapa();
        return halteRoute;
    }
    
    
    public void showTransits(){
        for(findLoc a : Transit){
            System.out.println(a.getBusStop());
        }
    }
    
    public static void main(String[] args) {
        generateRoute abc = new generateRoute();
        abc.connectDB();
        findLoc Departure = new findLoc("South Jakarta", "Fx Sudirman");
        //findLoc Destination = new findLoc("Central Jakarta", "Atma Jaya");
        //findLoc Destination = new findLoc("West Jakarta", "Apartment Kedoya Elok");
        //findLoc Destination = new findLoc("North Jakarta", "Mall Of Indonesia");
        //findLoc Destination = new findLoc("East Jakarta", "PGC");
        findLoc Destination = new findLoc("Central Jakarta", "Tugu Monas");
        generateRoute WEH = new generateRoute(Departure, Destination);
        System.out.println(Departure.getCorridor());
        System.out.println(Destination.getCorridor());
        System.out.println(WEH.getRoute());
        if(abc.doWeHaveSameStops("1", "8")){
            System.out.println("abc");
        }
    }
   
}