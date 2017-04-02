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
/**
 *
 * @author Mikha Putri
 * @author Wilson too HEHE
 */

public class ChangeSettings {
    
    String language;
    String color;
    JLabel langLabel;
    JLabel colorLabel;
    JFrame frame;

    public ChangeSettings() {
    }

    public ChangeSettings(String language, String color, JLabel langLabel, JLabel colorLabel, JFrame frame) {
        this.language = language;
        this.color = color;
        this.langLabel = langLabel;
        this.colorLabel = colorLabel;
        this.frame = frame;
    }
    
    public void change(String language, String color, JLabel langLabel, JLabel colorLabel, JFrame frame)
    {
        this.language = language;
        this.color = color;
        this.langLabel = langLabel;
        this.frame = frame;
        Settings sc = new Settings(language, color, langLabel, colorLabel);
        SettingsView s = new SettingsView(language, color, langLabel, colorLabel);
        
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

