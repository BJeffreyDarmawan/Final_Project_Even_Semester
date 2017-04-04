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
import java.util.Collections;
import Controller.*;

/**
 *
 * @author Mikha Putri
 */
public class FindLocation implements IRegardingCorridors{
    public static String region;
    public static String location;
    private String busStop;
    private int indx;
    private String corridor;
    private boolean gotBusStop = false;
    private ArrayList<String> corridors = new ArrayList();
    private ArrayList<Integer> indxs = new ArrayList();
    
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    
    public FindLocation(){
        connectDB();
        //findBusStop();
    }
    
    public FindLocation(String busStop){
        this.busStop = busStop;
        connectDB();
        findCorridor();
    }
    
    public FindLocation(String region, String location){
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
    
    public String getBusStop(){
        return this.busStop;
    }
    
    public ArrayList<String> getCorridors(){
        return corridors;
    }
    
    public void chooseCorridor(ArrayList<String> b){
        int i = 0;
        
        // if possible, choose corridor where we can move within 1 corridor
        for(String a : corridors){
            for(String c : b){
                if(c.equals(a)){ 
                    this.corridor = a;
                    this.indx = this.indxs.get(i); 
                    return;
                }
            }i++;
        } 
        
        // OR if possible, 1 transit
        i = 0;
        for(String a : corridors){
            for(String c : b){
                if (doWeHaveSameStops(a, c) ){
                    this.corridor = a;
                    this.indx = this.indxs.get(i);
                    return;
                }
            }
        }
        
        // OR if possible, 2 transits
        i = 0;
        for(String a : corridors){
            
            ArrayList<String> possibleCorridorsA = findPossibleCorridors(a);
            
            for(String c : b){
                
                ArrayList<String> possibleCorridorsB = findPossibleCorridors(c);
                
                for(String possa : possibleCorridorsA){
                    for(String possb : possibleCorridorsB){
                        if(possa.equals(possb)){
                            this.corridor = a;
                            this.indx = this.indxs.get(i);
                            return;
                        }
                    }
                }
            }
            i++;
        }
        
        // OR if possible, 3 transits
        i = 0;
        for(String a : corridors){
            
            ArrayList<String> possibleCorridorsA = findPossibleCorridors(a);
            
            for(String c : b){
                
                ArrayList<String> possibleCorridorsB = findPossibleCorridors(c);
                
                for(String possa : possibleCorridorsA){
                    for(String possb : possibleCorridorsB){
                        if(doWeHaveSameStops(possa, possb)){
                            this.corridor = a;
                            this.indx = this.indxs.get(i);
                            return;
                        }
                    }
                }
            }
            i++;
        }
        corridor = this.corridors.get(0);
        indx = this.indxs.get(0);
    }
    
    public final void connectDB(){
        try{
            //singleton
            con = ConnectionConfig.createConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }catch(SQLException e){
            System.out.println("Errot at findLoc.connectDB()");
            System.out.println(e);
        }catch (ClassNotFoundException ex) {
            System.out.println("Error at findLoc.connectDB()");
            System.out.println(ex);
        }
    }
    
    public void findBusStop(){
        String[] nearBys;
        String nearBy;
        try{
            rs = stmt.executeQuery("select * from tj");
            rs.beforeFirst();
            while(!gotBusStop){
                rs.next();
                if(this.region.equals(rs.getString("region"))){
                    nearBy = rs.getString("nearby");
			
                    nearBys = nearBy.split(",\\s");
                    for(int i = 0; i < nearBys.length; i++){
                        if(location.equals(nearBys[i])){
                            this.busStop = rs.getString("halte");
                            findCorridor();
                            gotBusStop = true;
                            break;
                        }
                    }
                }
            }
        } catch (SQLException e){
            System.out.println(e);
            System.out.println("Error at findBusStop");
        }
    }

    public ArrayList getNearby(String reg)
    {
        ArrayList<String> nearBys = new ArrayList();
        String nearBy;
        String[] test;
        //System.out.println(reg);
        try{
            rs = stmt.executeQuery("select * from tj where region = '" + reg + "' order by nearby");
            while(rs.next()){
                nearBy = rs.getString("nearby");
                test = nearBy.split(",\\s");
                ArrayList<String> list = new ArrayList(Arrays.asList(test));
                nearBys.addAll(list);
                
                
            }
            Collections.sort(nearBys);
            for(int i = 0; i < nearBys.size(); i++){
                if(nearBys.get(i).equals(null))
                    break;
                if(i != 0){
                    //remove the data with the same value
                    if(nearBys.get(i).equals(nearBys.get(i-1))){
                        nearBys.remove(i);
                    }
                }
            }
        }catch(SQLException e)
        {
           System.out.println(e);
        }
        
        return nearBys;
    }
    
    public void findCorridor(){
        try{System.out.println("findCorridor"); System.out.println(this.busStop);
            //boolean gotCorridor = false;
            rs = stmt.executeQuery("select * from tj where halte = '" + this.busStop + "'"); //System.out.println(rs.getString("corridor"));
            while(rs.next()){
                this.corridors.add(rs.getString("corridor"));
                this.indxs.add(rs.getInt("index"));
            }
        }catch(SQLException e){
            System.out.println(e);
            System.out.println("Error at findCorridor");
        }
    }
    
    @Override
    public boolean doWeHaveSameStops(String a, String b){
        try{System.out.println(a + "     " + b);
            Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Statement stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs1 = stmt1.executeQuery("select * from tj where corridor = '" + a + "'");
            ResultSet rs2 = stmt2.executeQuery("select * from tj where corridor = '" + b + "'");
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
    
    @Override
    public ArrayList<String> findPossibleCorridors(String corridorX){
        ArrayList<String> possibleCorridors = new ArrayList();
        for(int i = 0; i < arrCorridorsList.length; i++){
            if(doWeHaveSameStops(corridorX, arrCorridorsList[i]))
                possibleCorridors.add(arrCorridorsList[i]);
        }
        return possibleCorridors;
    }
}
