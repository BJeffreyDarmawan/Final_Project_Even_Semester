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
import java.awt.Dimension;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author Mikha Putri
 */
public class OpeningView extends javax.swing.JFrame implements Apply_Settings{

    Settings Preferences;
    User guest;
   
    public OpeningView(Settings set){
        try {
            this.Preferences = set;
            initComponents();
            showImage("/Users/Home/Desktop/BINUS/SEMESTER 2/Programming Language/Final Project/Final_Project_Even_Semester/transjakarta_/logotransjakarta.png", logoLabel);
            apply();
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            findBusStopButt.setPreferredSize(new Dimension(150, 29));
            sRoutesButt.setPreferredSize(new Dimension(150, 29));
            mapButt.setPreferredSize(new Dimension(95, 29));
            settings.setPreferredSize(new Dimension(95,29));
            getContentPane().setLayout(null);
            getContentPane().add(findBusStopButt);
            getContentPane().add(sRoutesButt);
            getContentPane().add(mapButt);
            getContentPane().add(settings);
            //cs.ChangeOpeningView(language, color, findBusStopButt, sRoutesButt, Settings, mapButt);
        } catch (SQLException ex) {
            Logger.getLogger(transjakarta_.openingView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public OpeningView(User s){
        try {
            this.guest = s;
            initComponents();
            showImage("/Users/Home/Desktop/BINUS/SEMESTER 2/Programming Language/Final Project/Final_Project_Even_Semester/transjakarta_/logotransjakarta.png", logoLabel);
            apply();
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            findBusStopButt.setPreferredSize(new Dimension(150, 29));
            sRoutesButt.setPreferredSize(new Dimension(150, 29));
            mapButt.setPreferredSize(new Dimension(95, 29));
            settings.setPreferredSize(new Dimension(95,29));
            getContentPane().setLayout(null);
            getContentPane().add(findBusStopButt);
            getContentPane().add(sRoutesButt);
            getContentPane().add(mapButt);
            getContentPane().add(settings);
        } catch (SQLException ex) {
            Logger.getLogger(transjakarta_.openingView.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public void openBrowser() throws IOException
    {
        try {
            Desktop d = Desktop.getDesktop();
            d.browse(new URI("http://transjakarta.co.id/peta-rute/"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(OpeningView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void apply(){
        if(this.guest.getSettings().getLanguage().equals("eng"))
            changeToEng();
        else if(this.guest.getSettings().getLanguage().equals("indo"))
            changeToIndo();
        
        if(this.guest.getSettings().getColor().equals("pink"))
            changePink();
        else if(this.guest.getSettings().getColor().equals("gray"))
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
        adminButt = new javax.swing.JButton();

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
        settings.setRequestFocusEnabled(false);
        settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsActionPerformed(evt);
            }
        });

        mapButt.setText("Map");
        mapButt.setPreferredSize(new java.awt.Dimension(95, 29));
        mapButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapButtActionPerformed(evt);
            }
        });

        adminButt.setText("Admin");
        adminButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(findBusStopButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mapButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(settings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sRoutesButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(adminButt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(mapButt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(adminButt)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void findBusStopButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findBusStopButtActionPerformed
        // TODO add your handling code here:
        this.dispose();
        this.guest.openFindBusStopView();
    }//GEN-LAST:event_findBusStopButtActionPerformed

    private void sRoutesButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sRoutesButtActionPerformed
        // TODO add your handling code here:
        this.dispose();
        this.guest.openSearchRoutesView();
    }//GEN-LAST:event_sRoutesButtActionPerformed

    private void settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsActionPerformed
        this.dispose();
        this.guest.openSettingsView();
    }//GEN-LAST:event_settingsActionPerformed

    private void mapButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mapButtActionPerformed
        try {
            // TODO add your handling code here:
            openBrowser();
        } catch (IOException ex) {
            Logger.getLogger(OpeningView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mapButtActionPerformed

    private void adminButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminButtActionPerformed
        this.dispose();
        new LoginForm(this.guest.getSettings()).setVisible(true);
    }//GEN-LAST:event_adminButtActionPerformed

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
    private javax.swing.JButton adminButt;
    private javax.swing.JButton findBusStopButt;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JButton mapButt;
    private javax.swing.JButton sRoutesButt;
    private javax.swing.JButton settings;
    // End of variables declaration//GEN-END:variables

    
}
