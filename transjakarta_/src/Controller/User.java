/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.*;
/**
 *
 * @author Lenovo
 */
public class User {
    private Settings Preferences;
    private generateRoute Journey;
    
    public User(){
        this.Preferences.setColor("default");
        this.Preferences.setLanguage("eng");
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
    
    public void change(){
        
    }
    
    public void setJourney(String A, String B){
        this.Journey = new generateRoute(new FindLocation(A), new FindLocation(B));
    }
    
    public generateRoute getJourney(){
        return this.Journey;
    }
    
}
