/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Mikha Putri
 */
public class Settings implements Language_Color{
    String language;
    String color;
    JLabel langLabel;
    JLabel colorLabel;
   

    public Settings(String language, String color, JLabel langLabel, JLabel colorLabel) {
        this.language = language;
        this.color = color;
        this.langLabel = langLabel;
        this.colorLabel = colorLabel;
    }

    public Settings() {
    }

    @Override
    public void changePink(JFrame frame) {
        frame.getContentPane().setBackground(Color.pink);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeGray(JFrame frame) {
        frame.getContentPane().setBackground(Color.GRAY);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeToIndo() {
        this.langLabel.setText("bahasa");
        this.colorLabel.setText("warna");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeToEng() {
        this.langLabel.setText("language");
        this.colorLabel.setText("color");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeDefault() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
