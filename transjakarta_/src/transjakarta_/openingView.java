/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transjakarta_;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Home
 */
public class openingView extends javax.swing.JFrame {

    String language, color;
    
    public openingView() {
        try {
            //this.setTitle("VIEW OPENIGIN BEGINI");
            initComponents();
            language = "english";
            color = "default";
            showImage("/Users/Home/Desktop/BINUS/SEMESTER 2/Programming Language/Final Project/Final_Project_Even_Semester/transjakarta_/logotransjakarta.png", logoLabel);        
            this.setLocationRelativeTo(null);
        } catch (SQLException ex) {
            Logger.getLogger(openingView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public openingView(String languages, String color) {
        try {
            this.color = color;
            this.language = languages;
            initComponents();
            languages();
            colours();
            showImage("/Users/Home/Desktop/BINUS/SEMESTER 2/Programming Language/Final Project/Final_Project_Even_Semester/transjakarta_/logotransjakarta.png", logoLabel);
            this.setLocationRelativeTo(null);
        } catch (SQLException ex) {
            Logger.getLogger(openingView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //show image
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
    public void openBrowser() throws IOException
    {
        try {
            Desktop d = Desktop.getDesktop();
            d.browse(new URI("http://transjakarta.co.id/peta-rute/"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(openingView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void languages(){
        if ("indo".equals(language)){
            //jLabel1.setText("Hai");
            findBusStopButt.setText("Cari Halte");
            sRoutesButt.setText("Cari Rute");
            Settings.setText("Pengaturan");
        }
        else{
            //jLabel1.setText("Welcome!");
            findBusStopButt.setText("Find Bus Stop");
            sRoutesButt.setText("Find Route");
            Settings.setText("Settings");
        }
         
    }
    
    public void colours(){
        if ("pink".equals(color)){
            this.getContentPane().setBackground( Color.PINK );
        }
        else if("gray".equals(color)){
            this.getContentPane().setBackground( Color.LIGHT_GRAY );
        }
        else{
            this.getContentPane().setBackground(null);
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        findBusStopButt = new javax.swing.JButton();
        sRoutesButt = new javax.swing.JButton();
        Settings = new javax.swing.JButton();
        mapButt = new javax.swing.JButton();
        logoLabel = new javax.swing.JLabel();

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

        Settings.setText("Settings");
        Settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsActionPerformed(evt);
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
                .addComponent(Settings)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(findBusStopButt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sRoutesButt)))
                .addContainerGap(23, Short.MAX_VALUE))
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
                    .addComponent(Settings)
                    .addComponent(mapButt))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void findBusStopButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findBusStopButtActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new findBusStopView(language, color).setVisible(true);
    }//GEN-LAST:event_findBusStopButtActionPerformed

    private void sRoutesButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sRoutesButtActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new searchRoutesView(language, color).setVisible(true);
    }//GEN-LAST:event_sRoutesButtActionPerformed

    private void SettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsActionPerformed
        this.dispose();
        new settings(language, color).setVisible(true);
    }//GEN-LAST:event_SettingsActionPerformed

    private void mapButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mapButtActionPerformed
        try {
            // TODO add your handling code here:
            openBrowser();
        } catch (IOException ex) {
            Logger.getLogger(openingView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mapButtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Settings;
    private javax.swing.JButton findBusStopButt;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JButton mapButt;
    private javax.swing.JButton sRoutesButt;
    // End of variables declaration//GEN-END:variables
}
