/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Mikha Putri
 */
public class Settings{
    
    String language;
    String color;

    public Settings() {
        this.language = "eng";
        this.color = "default";
    }
    
    public Settings(String language, String color){
        this.language = language;
        this.color = color;
    }
 
    public void setColor(String color){
        this.color = color;
    }
    
    public void setLanguage(String language){
        this.language = language;
    }
    
    public String getLanguage(){
        return this.language;
    }
    
    public String getColor(){
        return this.color;
    }
}
