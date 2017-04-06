/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JFrame;
import Model.*;
import Controller.*;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mikha Putri, Jeffrey Darmawan, Wilson Fransicius
 */
public class ResultView extends javax.swing.JFrame implements IApply_Settings{

    /**
     * Creates new form resultView
     */
    
    Settings Preferences;
    private User guest;
    private ArrayList<String> BusStops = new ArrayList();
    private ArrayList<String> CorridorsPassed = new ArrayList();
    
    public ResultView(Settings set){
        initComponents();
        this.Preferences = set;
        apply();
        this.setLocationRelativeTo(null);
    }
    
    public ResultView(User s){
        this.guest = s;
        this.BusStops.addAll(this.guest.getBusStopList()); 
        this.CorridorsPassed.addAll(this.guest.getCorridorsPassed()); 
        initComponents();
        apply();
        display();
        this.setLocationRelativeTo(null);
        JOptionPane.showMessageDialog(this, "Your journey will pass through " + BusStops.size() + " bus stops and use " + CorridorsPassed.size() + " corridors");
    }
    
    // Apply_Settings methods
    @Override
    public void apply() {
        if(this.guest.getLanguage().equals("eng")){
            changeToEng();
        }        
        else if (this.guest.getLanguage().equals("indo")){
            changeToIndo();
        }
        if(this.guest.getColor().equals("pink")){
            changePink();
        }
        else if (this.guest.getColor().equals("gray")){
            changeGray();
        }
        else{
            changeDefault();
        }
    }
    
    @Override
    public void changeToIndo() {
        lblCorridor.setText("Menggunakan Koridor: ");
    }

    @Override
    public void changeToEng() {
        lblCorridor.setText("Corridors Passed: ");
    }

    @Override
    public void changePink() {
        this.getContentPane().setBackground(Color.PINK);
    }

    @Override
    public void changeGray() {
        this.getContentPane().setBackground(Color.GRAY);
    }

    @Override
    public void changeDefault() {
        this.getContentPane().setBackground(null);
    }
    
    int index = 0;
    public void display(){
        
        lblCurrentCorridor.setText(CorridorsPassed.get(index));
        
        String text = "<html>"; // apply wrap text
        String transit = "Transit at: ";
        
        for(int i = 0; i < BusStops.size(); i++){
            if(i == 0){
                    text += BusStops.get(i);
            }
            else if (i < BusStops.size()-1){
                if (BusStops.get(i).equals(BusStops.get(i-1))){
                    text += " - " + BusStops.get(i);
                    transit+= " - " + BusStops.get(i);
                    i++;
                }
                else
                    text += " - " + BusStops.get(i);
                }
        }
        String corridors="";
        for(String a : CorridorsPassed){
            corridors+= a + " ";
        }
        
        text += "</html>";
        lblCurrentCorridor.setText(corridors);
        transitAt.setText(transit);
        ROUTE.setText(text);
        
        index++;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        repeat2 = new javax.swing.JButton();
        ROUTE = new javax.swing.JLabel();
        lblCorridor = new javax.swing.JLabel();
        lblCurrentCorridor = new javax.swing.JLabel();
        transitAt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Alternative Route");

        repeat2.setText("Do again?");
        repeat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repeat2ActionPerformed(evt);
            }
        });

        ROUTE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ROUTEMouseClicked(evt);
            }
        });

        lblCorridor.setText("Corridors used:");

        lblCurrentCorridor.setText("jLabel4");

        transitAt.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(transitAt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ROUTE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(repeat2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCorridor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCurrentCorridor)))
                        .addGap(0, 170, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorridor, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCurrentCorridor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ROUTE, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transitAt)
                .addGap(7, 7, 7)
                .addComponent(repeat2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void repeat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repeat2ActionPerformed
        this.dispose();
        this.guest.openOpeningView();
    }//GEN-LAST:event_repeat2ActionPerformed

    private void ROUTEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ROUTEMouseClicked
        display();
    }//GEN-LAST:event_ROUTEMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ROUTE;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCorridor;
    private javax.swing.JLabel lblCurrentCorridor;
    private javax.swing.JButton repeat2;
    private javax.swing.JLabel transitAt;
    // End of variables declaration//GEN-END:variables


    
}
