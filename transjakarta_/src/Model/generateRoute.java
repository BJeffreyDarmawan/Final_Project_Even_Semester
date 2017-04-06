/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import Model.*;

/**
 *
 * @author Mikha Putri, Jeffrey Darmawan, Wilson Fransicius
 */
public class generateRoute implements IRegardingCorridors{
    
    BusStop Departure;
    BusStop Destination;
    
    Connection con;
    Statement stmt1, stmt2;
    ResultSet rs1, rs2;
    
    ArrayList<String> haltePoints = new ArrayList();
    ArrayList<BusStop> Transit = new ArrayList();
    ArrayList<String> halteRoute = new ArrayList();
    ArrayList<String> corridorPassed = new ArrayList();
    ArrayList<BusStop> BusStopPassed = new ArrayList();
    
    public generateRoute(){
        this.Departure = new BusStop("");
        this.Destination = new BusStop("");
    }
    
    public generateRoute(BusStop Departure, BusStop Destination){
        this.Departure = Departure;
        this.Destination = Destination;System.out.println(Destination.getCorridors() + " " + Departure.getCorridors());
        Departure.chooseCorridor(Destination.getCorridors()); 
        Destination.chooseCorridor(Departure.getCorridors());
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
            System.out.println(ex);
            System.out.println("Error at connectDB");
        }
    }
        
    // IRegardingCorridors methods
    @Override
    public boolean doWeHaveSameStops(String a, String b){
        try{
            rs1 = stmt1.executeQuery("select * from tj where corridor = '" + a + "'");
            rs2 = stmt2.executeQuery("select * from tj where corridor = '" + b + "'");
            while(rs1.next()){
                
                rs2.beforeFirst();
                while(rs2.next()){ 
                    if(rs1.getString("halte").equals(rs2.getString("halte"))){
                        return true;
                    }
                }
            }
            System.out.println("SAME STOP NOT FOUND");
            return false;
        }catch(SQLException e){
            System.out.println(e);
            System.out.println("Error at doWeHaveSameStops");
            return false;
        }
    }

    @Override
    public ArrayList<String> findPossibleCorridors(String corridorX){
        ArrayList<String> possibleCorridors = new ArrayList();
        for(int i = 0; i < arrCorridorsList.length; i++){
            if(doWeHaveSameStops(corridorX, arrCorridorsList[i]) && !corridorX.equals(arrCorridorsList[i]))
                possibleCorridors.add(arrCorridorsList[i]);
        }
        return possibleCorridors;
    }
    
    // go to a specific row where the wanted bus stop is posistioned
    public void goToRS(int i){
        try{ 
            rs1.first(); rs1.previous();
            while(true){
                rs1.next();
                if(rs1.getString("halte").equals(haltePoints.get(i))){
                    break;
                } 
            }
        }catch(SQLException ex){
            System.out.println(ex);
            System.out.println("Error at goToRS");
        }
    }
    
    public void gataunimethodapa(){
        try{
            if(Departure.getCorridor().equals(Destination.getCorridor())){
                haltePoints.add(Departure.getBusStop());
                rs1 = stmt1.executeQuery("select * from tj where corridor = '" + Departure.getCorridor() + "'");
                
                // go to result set row where the first haltePoints is positioned in the corridor
                goToRS(0); 
                
                // write the first bus stop used (Departure bus stop)
                halteRoute.add(rs1.getString("halte"));
                corridorPassed.add(rs1.getString("corridor"));
                if(Departure.getIndex() < Destination.getIndex()){
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
            } else {
                haltePoints.add(Departure.getBusStop()); 
                Transit.add(new BusStop(Departure.getBusStop()));
                findCorridorAndTransit(Departure.getCorridor(), Destination.getCorridor()); 
                
                // iterate all corridor passed to write all the bus stops passed each corridor
                for(int i = 0; i < corridorPassed.size(); i++){
                    rs1 = stmt1.executeQuery("select * from tj where corridor = '" + corridorPassed.get(i) + "'");  
                    goToRS(i);
                    halteRoute.add(rs1.getString("halte")); 
                    Transit.get(i+1).chooseCorridor(new ArrayList<String>(Arrays.asList(corridorPassed.get(i))));
                    Transit.get(i).chooseCorridor(new ArrayList<String>(Arrays.asList(corridorPassed.get(i))));
                    
                    // write all the bus stops passed in 'this' corridor
                    if(rs1.getInt("index") < Transit.get(i+1).getIndex()){
                        while(rs1.next()){
                            halteRoute.add(rs1.getString("halte"));
                            if(rs1.getString("halte").equals(Transit.get(i+1).getBusStop())){
                                break;
                            }
                        }
                    } else {
                        while(rs1.previous()){
                            halteRoute.add(rs1.getString("halte"));
                            if(rs1.getString("halte").equals(Transit.get(i+1).getBusStop())){
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
    
    
    public void findCorridorAndTransit(String corridorA, String corridorB){
        try{
        
            if(doWeHaveSameStops(corridorA, corridorB) && !corridorB.equals(corridorA)){ 
                Transit.add(new BusStop(rs1.getString("halte")));
                haltePoints.add(rs1.getString("halte"));
                corridorPassed.add(rs1.getString("corridor"));
                
                if(corridorB.equals(Destination.getCorridor())){ 
                    corridorPassed.add(Destination.getCorridor());  
                    Transit.add(Destination);
                    haltePoints.add(Destination.getBusStop()); 
                    return;
                } else { 
                    // recursion
                    findCorridorAndTransit(corridorB, Destination.getCorridor()); 
                    return;
                }
                
            } else {
                
                ArrayList<String> possibleCorridorsA = findPossibleCorridors(corridorA);
                ArrayList<String> possibleCorridorsB = findPossibleCorridors(corridorB); 
                
                for(String a : possibleCorridorsA){
                    for(String b : possibleCorridorsB){
                        if(a.equals(b)){
                            // recursion
                            findCorridorAndTransit(corridorA, b);
                            return;
                        }else if(doWeHaveSameStops(a, b)){
                            // recursion
                            findCorridorAndTransit(corridorA, a); 
                            return;
                        }
                    }
                }
            }
        } catch (SQLException e){
            System.out.println(e);
            System.out.println("Error at findCorridorAndTransit");
        }
    }
    
    public ArrayList getRoute(){
        gataunimethodapa();
        return halteRoute;
    }
    
    public void showTransits(){
        for(BusStop a : Transit){
            System.out.println("Transits: " + a.getBusStop() + " " + a.getCorridors());
        }
    }
    
    public void setDeparture(String A){
        this.Departure = new BusStop(A);
    }
    
    public BusStop getDeparture(){
        return Departure;
    }
    
    public ArrayList<String> getCorridorsPassed(){
        return corridorPassed;
    }
            
}