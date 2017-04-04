/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.*;
import Model.*;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author Mikha Putri
 */
public class OpeningView extends javax.swing.JFrame implements Apply_Settings{

    Settings Preferences;
    
    JLabel langLabel, colorLabel;
    JFrame frame;
    JButton back;
    /**
     * Creates new form openingView
     */
    /*public OpeningView() {
        try {
            this.setTitle("VIEW OPENIGIN BEGINI");
            initComponents();
            this.Preferences = new Settings("eng", "gray");
            showImage("/Users/Home/Desktop/BINUS/SEMESTER 2/Programming Language/Final Project/Final_Project_Even_Semester/transjakarta_/logotransjakarta.png", logoLabel);        
            this.setLocationRelativeTo(null);
        } catch (SQLException ex) {
            Logger.getLogger(transjakarta_.openingView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    public OpeningView(Settings Set){
        try {
            this.Preferences = Set;
            //this.setLocationRelativeTo(null);
            //ChangeSettings cs = new ChangeSettings();
            initComponents();
            showImage("/Users/Home/Desktop/BINUS/SEMESTER 2/Programming Language/Final Project/Final_Project_Even_Semester/transjakarta_/logotransjakarta.png", logoLabel);
            apply();
            //cs.ChangeOpeningView(language, color, findBusStopButt, sRoutesButt, Settings, mapButt);
        } catch (SQLException ex) {
            Logger.getLogger(transjakarta_.openingView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public OpeningView(String language, String color) {
        try {
            this.Preferences = new Settings(language, color);
            this.setLocationRelativeTo(null);
            ChangeSettings cs = new ChangeSettings();
            initComponents();
            showImage("/Users/Home/Desktop/BINUS/SEMESTER 2/Programming Language/Final Project/Final_Project_Even_Semester/transjakarta_/logotransjakarta.png", logoLabel);
            //cs.ChangeOpeningView(language, color, findBusStopButt, sRoutesButt, Settings, mapButt);
        } catch (SQLException ex) {
            Logger.getLogger(transjakarta_.openingView.class.getName()).log(Level.SEVERE, null, ex);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void showImage(String image, JLabel label) throws SQLException
    {
        try
        {
            File f = new File(image);
            
            //temporary storage for the image
            BufferedImage bi = ImageIO.read(f);
            
            //to make the image fit with the image label
            Image newbi = bi.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            
            label.setIcon(new ImageIcon(newbi));
            
            //in case something wrong when setting the icon
            label.revalidate();
            label.repaint();
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void apply(){
        if(this.Preferences.getLanguage().equals("eng"))
            changeToEng();
        else if(this.Preferences.getLanguage().equals("indo"))
            changeToIndo();
        
        if(this.Preferences.getColor().equals("pink"))
            changePink();
        else if(this.Preferences.getColor().equals("gray"))
            changeGray();
        else
            changeDefault();
    }
    
    @Override
    public void changeToIndo() {
        findBusStopButt.setText("Cari Halte");
        sRoutesButt.setText("Cari Rute");
        mapButt.setText("Peta");
        settings.setText("Pengaturan");
        //gitulah...
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeToEng() {
        findBusStopButt.setText("Find Bus Stop");
        sRoutesButt.setText("Search Routes");
        mapButt.setText("Map");
        settings.setText("Settings");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeToIndoOpeningView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoLabel = new javax.swing.JLabel();
        findBusStopButt = new javax.swing.JButton();
        sRoutesButt = new javax.swing.JButton();
        settings = new javax.swing.JButton();
        mapButt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        findBusStopButt.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        findBusStopButt.setText("Find Bus Stop");
        findBusStopButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findBusStopButtActionPerformed(evt);
            }
        });

        sRoutesButt.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        sRoutesButt.setText("Search Routes");
        sRoutesButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sRoutesButtActionPerformed(evt);
            }
        });

        settings.setText("Settings");
        settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsActionPerformed(evt);
            }
        });

        mapButt.setText("Map");
        mapButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(mapButt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(settings)
                .addGap(71, 71, 71))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(findBusStopButt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sRoutesButt)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(findBusStopButt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sRoutesButt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(settings)
                    .addComponent(mapButt))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void findBusStopButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findBusStopButtActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new FindBusStopView(Preferences).setVisible(true);
    }//GEN-LAST:event_findBusStopButtActionPerformed

    private void sRoutesButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sRoutesButtActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new SearchRoutesView(Preferences).setVisible(true);
    }//GEN-LAST:event_sRoutesButtActionPerformed

    private void settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsActionPerformed
        this.dispose();
        new SettingsView(Preferences).setVisible(true);
    }//GEN-LAST:event_settingsActionPerformed

    private void mapButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mapButtActionPerformed
        try {
            // TODO add your handling code here:
            openBrowser();
        } catch (IOException ex) {
            Logger.getLogger(openingView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mapButtActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OpeningView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpeningView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpeningView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpeningView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpeningView(new Settings()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton findBusStopButt;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JButton mapButt;
    private javax.swing.JButton sRoutesButt;
    private javax.swing.JButton settings;
    // End of variables declaration//GEN-END:variables

    
}
