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
public class Settings implements Apply_Settings{
    
    String language;
    String color;
    
    
    //settings
    JLabel langLabel, colorLabel;
    JButton back;
    
    //button in opening view
    JButton button1, button2, button3, button4;
    JFrame frame;
    
    public Settings() {
        this.language = "eng";
        this.color = "gray";
    }
    
    public Settings(String language, String color){
        this.language = language;
        this.color = color;
    }
    
    //settings
    public Settings(String language, String color, JLabel langLabel, JLabel colorLabel, JButton back) {
        this.language = language;
        this.color = color;
        this.langLabel = langLabel;
        this.colorLabel = colorLabel;
        this.back = back;
    }
    
    //opening
    public Settings(JButton button1, JButton button2, JButton button3, JButton button4) {
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
        this.button4 = button4;
    }
    
    @Override
    public void changePink() {
        frame.getContentPane().setBackground(Color.PINK);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeGray() {
        frame.getContentPane().setBackground(Color.GRAY);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeToIndo() {
        //settings
        this.langLabel.setText("bahasa");
        this.colorLabel.setText("warna");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public void changeToEng() {
        //settigs
        this.langLabel.setText("language");
        this.colorLabel.setText("color");
        
        //opening
        /*this.button1.setText("Find Bus Stop");
        this.button2.setText("Find Routes");
        this.button3.setText("Settings");
        this.button4.setText("Maps");*/
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeDefault() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public void changeToIndoOpeningView() {
        //opening
        this.button1.setText("Cari Halte");
        this.button2.setText("Cari Rute");
        this.button3.setText("Pengaturan");
        this.button4.setText("Peta");
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apply() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
