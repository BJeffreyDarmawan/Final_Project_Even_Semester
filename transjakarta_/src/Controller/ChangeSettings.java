/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.*;
/**
 *
 * @author Mikha Putri
 */

public class ChangeSettings implements Language_Color {
    public String language;
    public String color;

    public ChangeSettings() {
    }

    public ChangeSettings(String language, String color) {
        this.language = language;
        this.color = color;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        if ("gray".equals(color)){
            
        }
    }

    @Override
    public void changeToIndo() {
        settingsView sv = null;
        sv.ENG.setEnabled(true);
        //ENG.setBackground(Color.red);
        //languages_txt.setBackground(Color.red);
        //gray.setForeground(Color.red);
        sv.languages_txt.setText("Bahasa");
        sv.openingView.setText("Menu Utama");
        sv.color.setText("Warna");
        sv.gray.setText("Abu-abu");
        sv.pink.setText("Merah Jambu");
        sv.setasdefault.setText("Pengaturan awal");
        sv.ID.setEnabled(false);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeToEng() {
        settingsView sv = new settingsView();
        sv.ID.setEnabled(true);
        sv.languages_txt.setText("Languages");
        sv.openingView.setText("Main Menu");
        sv.color.setText("Color");
        sv.gray.setText("Gray");
        sv.pink.setText("Pink");
        sv.setasdefault.setText("Set as Default");
        sv.ENG.setEnabled(false); 
        //languages_txt.setText("Languages");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changePink() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeGray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeDefault() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
