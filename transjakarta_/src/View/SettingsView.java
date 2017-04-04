/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.*;
import Model.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Mikha Putri
 */
public class SettingsView extends javax.swing.JFrame implements Apply_Settings{
    
    Settings Preferences; 
    User guest;
    
    public SettingsView(Settings set){
        this.Preferences = set;
        initComponents();     
        apply();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        okButton.setPreferredSize(new Dimension(130,29));
        backButton.setPreferredSize(new Dimension(130,29));
        defaultButt.setPreferredSize(new Dimension(130,29));
        pinkButton.setPreferredSize(new Dimension(60, 29));
        grayButton.setPreferredSize(new Dimension(60, 29));
        getContentPane().setLayout(null);
        getContentPane().add(okButton);
        getContentPane().add(backButton);
        getContentPane().add(defaultButt);
        getContentPane().add(pinkButton);
        getContentPane().add(grayButton);
    }
    
    public SettingsView(User s){
        this.guest = s;
        initComponents();     
        apply();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        okButton.setPreferredSize(new Dimension(130,29));
        backButton.setPreferredSize(new Dimension(130,29));
        defaultButt.setPreferredSize(new Dimension(130,29));
        pinkButton.setPreferredSize(new Dimension(60, 29));
        grayButton.setPreferredSize(new Dimension(60, 29));
        getContentPane().setLayout(null);
        getContentPane().add(okButton);
        getContentPane().add(backButton);
        getContentPane().add(defaultButt);
        getContentPane().add(pinkButton);
        getContentPane().add(grayButton);
    }
    
    // Apply_Settings methods
    @Override
    public void apply() {
        if(this.guest.getSettings().getLanguage().equals("eng")){
            changeToEng(); System.out.println("default");
            languageGroup.setSelected(engButton.getModel(), true);
        }
        else if (this.guest.getSettings().getLanguage().equals("indo")){
            changeToIndo();
            languageGroup.setSelected(indoButton.getModel(), true);
        }else System.out.println("went here");
        
        if(this.guest.getSettings().getColor().equals("pink")){
            changePink();
            colorGroup.setSelected(pinkButton.getModel(), true);
        }
        else if (this.guest.getSettings().getColor().equals("gray")){
            changeGray();
            colorGroup.setSelected(grayButton.getModel(), true);
        }
        else{
            changeDefault();
        }        
        //batas
        if(indoButton.isSelected() || pinkButton.isSelected() || grayButton.isSelected())
        {
            defaultButt.setEnabled(true);
        }
        else{
            defaultButt.setEnabled(false);
        }
        
    }
    
    @Override
    public void changeToIndo() {
        languageLabel.setText("Bahasa");
        colorsLabel.setText("Warna");
        backButton.setText("Menu Utama");
        defaultButt.setText("Pengaturan Awal");
        okButton.setText("Simpan");
        engButton.setText("Inggris");
        indoButton.setText("Bahasa");
        pinkButton.setText("Merah Muda");
        grayButton.setText("Kelabu");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void changeToEng() {
        languageLabel.setText("Language");
        colorsLabel.setText("Color");
        backButton.setText("Main Menu");
        defaultButt.setText("Set Default");
        okButton.setText("Save");
        engButton.setText("English");
        indoButton.setText("Indonesia");
        pinkButton.setText("Pink");
        grayButton.setText("Gray");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changePink() {
        this.getContentPane().setBackground(Color.PINK);
        engButton.setBackground(Color.PINK);
        indoButton.setBackground(Color.PINK);
        pinkButton.setBackground(Color.PINK);
        grayButton.setBackground(Color.PINK);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeGray() {
        this.getContentPane().setBackground(Color.GRAY);
        engButton.setBackground(Color.GRAY);
        indoButton.setBackground(Color.GRAY);
        pinkButton.setBackground(Color.GRAY);
        grayButton.setBackground(Color.GRAY);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeDefault() {
        this.getContentPane().setBackground(null);
        engButton.setBackground(null);
        indoButton.setBackground(null);
        pinkButton.setBackground(null);
        grayButton.setBackground(null);
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

        languageGroup = new javax.swing.ButtonGroup();
        colorGroup = new javax.swing.ButtonGroup();
        pinkButton = new javax.swing.JRadioButton();
        grayButton = new javax.swing.JRadioButton();
        okButton = new javax.swing.JButton();
        languageLabel = new javax.swing.JLabel();
        engButton = new javax.swing.JRadioButton();
        indoButton = new javax.swing.JRadioButton();
        colorsLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        defaultButt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(414, 150));
        setMinimumSize(new java.awt.Dimension(414, 150));
        setPreferredSize(new java.awt.Dimension(414, 150));
        setResizable(false);
        setSize(new java.awt.Dimension(414, 150));

        colorGroup.add(pinkButton);
        pinkButton.setText("Pink");
        pinkButton.setPreferredSize(new java.awt.Dimension(60, 23));

        colorGroup.add(grayButton);
        grayButton.setText("Gray");

        okButton.setText("Save");
        okButton.setMaximumSize(new java.awt.Dimension(112, 29));
        okButton.setMinimumSize(new java.awt.Dimension(112, 29));
        okButton.setPreferredSize(new java.awt.Dimension(112, 29));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        languageLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        languageLabel.setText("Language");
        languageLabel.setToolTipText("");
        languageLabel.setMaximumSize(new java.awt.Dimension(70, 15));
        languageLabel.setMinimumSize(new java.awt.Dimension(70, 15));
        languageLabel.setPreferredSize(new java.awt.Dimension(70, 15));

        languageGroup.add(engButton);
        engButton.setText("English");
        engButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engButtonActionPerformed(evt);
            }
        });

        languageGroup.add(indoButton);
        indoButton.setText("Indonesia");
        indoButton.setAlignmentY(0.0F);
        indoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        indoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indoButtonActionPerformed(evt);
            }
        });

        colorsLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        colorsLabel.setText("Color");
        colorsLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorsLabel.setMaximumSize(new java.awt.Dimension(70, 15));
        colorsLabel.setMinimumSize(new java.awt.Dimension(70, 15));
        colorsLabel.setPreferredSize(new java.awt.Dimension(70, 15));

        backButton.setText("Main Menu");
        backButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        defaultButt.setText("Set Default");
        defaultButt.setMaximumSize(new java.awt.Dimension(112, 29));
        defaultButt.setMinimumSize(new java.awt.Dimension(112, 29));
        defaultButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(engButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pinkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(grayButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(indoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(colorsLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(languageLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(defaultButt, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(languageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(engButton)
                    .addComponent(indoButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colorsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pinkButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grayButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(defaultButt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        String lang, color;
        if(engButton.isSelected())
        {
            lang = "eng";
        }
        else if(indoButton.isSelected())
        {
            lang = "indo";
        }
        else{
            lang = "eng";
        }
        
        if(pinkButton.isSelected())
        {
            color = "pink";
            if(engButton.isSelected()){
                JOptionPane.showMessageDialog(this, "Updated!");
            }
            else if (indoButton.isSelected()){
                JOptionPane.showMessageDialog(this, "Diperbarui!");
            }
        }
        else if(grayButton.isSelected())
        {
            color = "gray";
                if(engButton.isSelected()){
                JOptionPane.showMessageDialog(this, "Updated!");
                }
                else if (indoButton.isSelected()){
                JOptionPane.showMessageDialog(this, "Diperbarui!");
                }
        }
        else{
            color = " ";
        }        
        this.guest.changeSettings(lang, color);
        apply();
        /*
        frame = this;
        langLabel = languageLabel;
        colorLabel = colorsLabel;
        back = backButton;
        ChangeSettings cs = new ChangeSettings();
        cs.change(language, color, langLabel, colorLabel, frame, back);*/
    }//GEN-LAST:event_okButtonActionPerformed

    private void engButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_engButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        this.guest.openOpeningView();
        //new OpeningView(this.guest).setVisible(true);        
    }//GEN-LAST:event_backButtonActionPerformed

    private void defaultButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultButtActionPerformed
        //this.guest.getSettings().setColor("default");
        //this.guest.getSettings().setLanguage("eng");
        this.guest.changeSettings("eng", "default"); //System.out.println(this.guest.getSettings().getColor() + this.guest.getSettings().getLanguage());
        apply();
        //languageGroup.setSelected((ButtonModel)engButton, true);
        languageGroup.setSelected(engButton.getModel(), true);
        //languageGroup.clearSelection();
        colorGroup.clearSelection();
        defaultButt.setEnabled(false);
        //JOptionPane.showMessageDialog(this, "Changed to default settings.");
    }//GEN-LAST:event_defaultButtActionPerformed

    private void indoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_indoButtonActionPerformed

    /*
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton backButton;
    private javax.swing.ButtonGroup colorGroup;
    public javax.swing.JLabel colorsLabel;
    private javax.swing.JButton defaultButt;
    public javax.swing.JRadioButton engButton;
    public javax.swing.JRadioButton grayButton;
    public javax.swing.JRadioButton indoButton;
    private javax.swing.ButtonGroup languageGroup;
    public javax.swing.JLabel languageLabel;
    public javax.swing.JButton okButton;
    public javax.swing.JRadioButton pinkButton;
    // End of variables declaration//GEN-END:variables

}
