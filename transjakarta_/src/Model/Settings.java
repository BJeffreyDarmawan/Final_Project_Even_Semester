/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Mikha Putri
 */
public class Settings{
    public String language;
    public String color;

    public Settings() {
    }

    public Settings(String language, String color) {
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
    }
  
}
