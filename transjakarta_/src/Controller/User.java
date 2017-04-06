/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.*;
import java.util.ArrayList;
/**
 *
 * @author Mikha Putri, Jeffrey Darmawan, Wilson Fransicius
 */
public class User {
    private Settings Preferences;
    private generateRoute Journey;
    
    public User(){
        this.Preferences = new Settings();
        this.Journey = new generateRoute();
        openOpeningView();
    }
    
    public void openAdminView(){
        AdminView s = new AdminView(this);
        s.setVisible(true);
    }
    public void openLoginForm(){
        LoginForm s = new LoginForm(this);
        s.setVisible(true);
    }
    public void openSettingsView(){
        SettingsView s = new SettingsView(this);
        s.setVisible(true);
    }
    
    public void openFindBusStopView(){
        FindBusStopView s = new FindBusStopView(this);
        s.setVisible(true);
    }
    
    public void openSearchRoutesView(){
        SearchRoutesView s = new SearchRoutesView(this);
        s.setVisible(true);
    }
    
    public void openOpeningView(){
        OpeningView s = new OpeningView(this);
        s.setVisible(true);
    }
    
    public void openResultView(){
        ResultView s = new ResultView(this);
        s.setVisible(true);
    }
    
    
    public void changeSettings(String lang, String color){
        this.Preferences.setColor(color);
        this.Preferences.setLanguage(lang);
    }
    
    public void setJourney(String departure, String destination){
        this.Journey = new generateRoute(new BusStop(departure), new BusStop(destination)); 
    }
    
    public void setDeparture(String departure){
        this.Journey.setDeparture(departure);
    }
    
    public String getDeparture(){
        return this.Journey.getDeparture().getBusStop();
    }
    
    public ArrayList<String> getBusStopList(){
        return this.Journey.getRoute();
    }
    
    public ArrayList<String> getCorridorsPassed(){
        return this.Journey.getCorridorsPassed();
    }
    
    public String getLanguage(){
        return this.Preferences.getLanguage();
    }
    
    public String getColor(){
        return this.Preferences.getColor();
    }
    
}
