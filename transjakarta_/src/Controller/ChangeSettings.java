/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import View.*;
import javax.swing.JButton;
/**
 *
 * @author Mikha Putri
 * @author Wilson too HEHE
 */

public class ChangeSettings {
    
    String language;
    String color;
    JLabel langLabel, colorLabel;
    JButton back;
    JFrame frame;
    JButton button1, button2, button3, button4;   
  
    Settings apakek;

    public ChangeSettings() {
    }

    public ChangeSettings(String language, String color, JLabel langLabel, JLabel colorLabel, JFrame frame, JButton back) {
        this.language = language;
        this.color = color;
        this.langLabel = langLabel;
        this.colorLabel = colorLabel;
        this.frame = frame;
    }
    
    public ChangeSettings(String language, String color, JFrame frame){
        this.language = language;
        this.color = color;
        this.frame = frame;
        this.apakek = new Settings(language, color);
    }
    
    public void ChangeOpeningView(String language, String color, JButton findBusStopButt, JButton sRoutesButt, JButton Settings, JButton mapButt){

        this.language = language;
        this.color = color;
        this.button1 = findBusStopButt;
        this.button2 = sRoutesButt;
        this.button3 = Settings;
        this.button4 = mapButt;
        
        Settings sc = new Settings(button1, button2, button3, button4);
        
        if(language.equals("eng"))
        {
            sc.changeToEng();
            
        }
        else if(language.equals("indo"))
        {
            sc.changeToIndoOpeningView();
        }
        if(color.equals("pink"))
                sc.changePink(frame);
            else if(color.equals("gray"))
                sc.changeGray(frame);
        
    }
    /*
    public void change(){
        if(frame.getClass() == (new SettingsView()).getClass() ){
            frame.get
            frame.langLabel.setText("language");
            frame.colorLabel.setText("color");
        }
    }*/
    
    public void change(String language, String color, JLabel langLabel, JLabel colorLabel, JFrame frame, JButton back)
    {
        this.language = language;
        this.color = color;
        this.langLabel = langLabel;
        this.frame = frame;
        this.back = back;
        Settings sc = new Settings(language, color, langLabel, colorLabel, back);
        //SettingsView s = new SettingsView(language, color, langLabel, colorLabel, back);
        
        if(language.equals("eng"))
        {
            sc.changeToEng();
            if(color.equals("pink"))
            sc.changePink(frame);
            else if(color.equals("gray"))
            sc.changeGray(frame);
        }
        else if(language.equals("indo"))
        {
            sc.changeToIndo();
            if(color.equals("pink"))
                sc.changePink(frame);
            else if(color.equals("gray"))
                sc.changeGray(frame);
        }
    }
}

