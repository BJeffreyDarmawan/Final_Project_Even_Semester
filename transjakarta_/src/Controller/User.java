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
 * @author Lenovo
 */
public class User {
    private Settings Preferences;
    private generateRoute Journey;
    
    public User(){
        this.Preferences = new Settings();
        this.Journey = new generateRoute();
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
    
    public void setJourney(String A, String B){
        System.out.println(A + " " + B);
        this.Journey = new generateRoute(new FindLocation(A), new FindLocation(B)); 
    }
    
    public void setDeparture(String A){
        this.Journey.setDeparture(A);
    }
    
    public String getDeparture(){
        return this.Journey.getDeparture().getBusStop();
    }
    
    public generateRoute getJourney(){
        return this.Journey;
    }
    
    public ArrayList<String> getBusStopList(){
        return this.Journey.getRoute();
    }
    
    public ArrayList<String> getCorridorsPassed(){
        return this.Journey.getCorridorsPassed();
    }
    
    public Settings getSettings(){
        return this.Preferences;
    }
    
}
