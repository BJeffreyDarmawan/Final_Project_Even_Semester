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

/**
 *
 * @author Mikha Putri
 */
public class FindLocation {
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
        findCorridor();
        //chooseCorridor();
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
        int i = 0;System.out.println(b.size() + " findLoc line 77"); System.out.println("INDEXES " + this.indxs);
        for(String a : corridors){
            if(b.get(i).equals(a)){ 
                this.corridor = b.get(i);
                this.indx = this.indxs.get(i); System.out.println(this.indx);
                return;
            }
        }
        corridor = this.corridors.get(0);
        indx = this.indxs.get(0);
    }
    
    public final void connectDB(){
        try{
            //singleton
            con = ConnectionConfig.createConnection();
                    
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
        //ConnectionConfig.closeConnection();
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
                            findCorridor();
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
            
        }
    }
}
