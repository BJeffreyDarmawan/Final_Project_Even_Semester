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
    private ArrayList<String> corridors = new ArrayList();
    private ArrayList<Integer> indxs = new ArrayList();
    
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    findLoc(){
        connectDB();
        //findBusStop();
    }
    
    findLoc(String busStop){
        this.busStop = busStop;
        connectDB();
        findCorridor();
    }
    
    findLoc(String region, String location){
        this.region = region;
        this.location = location;
        connectDB();
        findBusStop();
        //findCorridor();
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
        System.out.println(b.size() + " findLoc line 77"); System.out.println("INDEXES " + this.indxs + " " + this.corridors);int i = 0;
        for(String a : corridors){
            for(String c : b){
                if(c.equals(a)){ 
                    this.corridor = a;
                    this.indx = this.indxs.get(i);// System.out.println(this.indx);
                    return;
                }
            }i++;
        } 
        i = 0;
        for(String a : corridors){
            for(String c : b){
                if (doWeHaveSameStops(a, c) ){
                    this.corridor = a;
                    this.indx = this.indxs.get(i);// System.out.println(this.indx);
                    return;
                }
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
        }
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
    
    public void findCorridor(){
        try{System.out.println("findCorridor"); System.out.println(this.busStop);
            //boolean gotCorridor = false;
            rs = stmt.executeQuery("select * from tj where halte = '" + this.busStop + "'"); //System.out.println(rs.getString("corridor"));
            while(rs.next()){
                this.corridors.add(rs.getString("corridor"));
                this.indxs.add(rs.getInt("index")); System.out.println(this.indxs);
            }
        }catch(SQLException e){
            
        }
    }
    
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
}