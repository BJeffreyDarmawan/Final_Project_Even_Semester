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
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
/**
 *
 * @author Mikha Putri
 */
public class FindBusStopView extends javax.swing.JFrame implements Apply_Settings{

    /**
     * Creates new form findBusStopView
     */
    
    Settings Preferences;
    private User guest;
    
    public FindBusStopView(){
        initComponents();
    }
    
    public FindBusStopView(User s){
        this.guest = s;
        initComponents();
        apply();
        this.setLocationRelativeTo(null);
        regionBox.setPreferredSize(new Dimension(157, 27));
        nearbyBox.setPreferredSize(new Dimension(157, 27));
        mainmenu.setPreferredSize(new Dimension(150, 29));
        searchRoutesButt.setPreferredSize(new Dimension(150, 29));
        getContentPane().setLayout(null);
        getContentPane().add(regionBox);
        getContentPane().add(nearbyBox);
        getContentPane().add(mainmenu);
        getContentPane().add(searchRoutesButt);
        displayNearby();
    }
    
    public FindBusStopView(Settings set){
        this.Preferences = set;
        initComponents();
        apply();
        this.setLocationRelativeTo(null);
        regionBox.setPreferredSize(new Dimension(157, 27));
        nearbyBox.setPreferredSize(new Dimension(157, 27));
        mainmenu.setPreferredSize(new Dimension(150, 29));
        searchRoutesButt.setPreferredSize(new Dimension(150, 29));
        getContentPane().setLayout(null);
        getContentPane().add(regionBox);
        getContentPane().add(nearbyBox);
        getContentPane().add(mainmenu);
        getContentPane().add(searchRoutesButt);
        displayNearby();
    }
    
    @Override
    public void apply() {
        if(this.guest.getSettings().getLanguage().equals("eng")){
            changeToEng();
        }        
        else if (this.guest.getSettings().getLanguage().equals("indo")){
            changeToIndo();
        }
        if(this.guest.getSettings().getColor().equals("pink")){
            changePink();
        }
        else if (this.guest.getSettings().getColor().equals("gray")){
            changeGray();
        }
        else{
            changeDefault();
        }
        
    }
    
    @Override
    public void changeToIndo() {
        String[] a = {"Jakarta Pusat", "Jakarta Barat", "Jakarta Utara", "Jakarta Timur", "Jakarta Selatan"};
        regionBox.setModel(new DefaultComboBoxModel(a));
        titleLabel.setText("POSISI SEKARANG");
        regionLabel.setText("Wilayah");
        nearbyLabel.setText("Tempat Terdekat");
        nearestLabel.setText("Halte Terdekat:");
        searchRoutesButt.setText("Cari Rute");
        findBSButt.setText("Cari");
        mainmenu.setText("Menu Utama");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeToEng() {
        regionBox.setSelectedIndex(0);
        titleLabel.setText("CURRENT POSITION");
        regionLabel.setText("Region");
        nearbyLabel.setText("Nearby Place");
        nearestLabel.setText("Nearest Bus Stop:");
        searchRoutesButt.setText("Search Routes");
        findBSButt.setText("Find");
        mainmenu.setText("Main Menu");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changePink() {
        this.getContentPane().setBackground(Color.pink);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeGray() {
        this.getContentPane().setBackground(Color.GRAY);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeDefault() {
        this.getContentPane().setBackground(null);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayNearby(){
        if(this.guest.getSettings().getLanguage().equals("indo")){
            //System.out.println(regionBox.getSelectedItem());
            String weh = (String)regionBox.getSelectedItem();
                if(weh.equals("Jakarta Pusat"))
                    weh = "Central Jakarta";
                else if(weh.equals("Jakarta Barat"))
                    weh = "West Jakarta";
                else if(weh.equals("Jakarta Timur"))
                    weh = "East Jakarta";
                else if(weh.equals("Jakarta Selatan"))
                    weh = "South Jakarta";
                else if(weh.equals("Jakarta Utara"))
                    weh = "North Jakarta";
            FindLocation user = new FindLocation();
            ArrayList<String> abcdefghi = user.getNearby(weh);
            String[] abc = abcdefghi.toArray(new String[abcdefghi.size()]);
            nearbyBox.setModel(new DefaultComboBoxModel(abc));
        } else {
            String weh = (String)regionBox.getSelectedItem();
            FindLocation user = new FindLocation();
            ArrayList<String> abcdefghi = user.getNearby(weh);
            String[] abc = abcdefghi.toArray(new String[abcdefghi.size()]);
            nearbyBox.setModel(new DefaultComboBoxModel(abc));
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

        regionBox = new javax.swing.JComboBox<>();
        nearbyLabel = new javax.swing.JLabel();
        nearbyBox = new javax.swing.JComboBox<>();
        findBSButt = new javax.swing.JButton();
        nearestLabel = new javax.swing.JLabel();
        nearestBSLabel = new javax.swing.JLabel();
        searchRoutesButt = new javax.swing.JButton();
        mainmenu = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        regionLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        regionBox.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        regionBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Central Jakarta", "North Jakarta", "South Jakarta", "East Jakarta", "West Jakarta" }));
        regionBox.setMaximumSize(new java.awt.Dimension(157, 27));
        regionBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                regionBoxItemStateChanged(evt);
            }
        });

        nearbyLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        nearbyLabel.setText("Nearby Place");

        nearbyBox.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        nearbyBox.setMaximumSize(new java.awt.Dimension(157, 27));
        nearbyBox.setMinimumSize(new java.awt.Dimension(157, 27));
        nearbyBox.setPreferredSize(new java.awt.Dimension(157, 27));

        findBSButt.setText("Find");
        findBSButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findBSButtActionPerformed(evt);
            }
        });

        nearestLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        nearestLabel.setText("Nearest Bus Stop: ");

        nearestBSLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N

        searchRoutesButt.setText("Search Routes");
        searchRoutesButt.setMaximumSize(new java.awt.Dimension(150, 29));
        searchRoutesButt.setMinimumSize(new java.awt.Dimension(150, 29));
        searchRoutesButt.setPreferredSize(new java.awt.Dimension(150, 29));
        searchRoutesButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchRoutesButtActionPerformed(evt);
            }
        });

        mainmenu.setText("Main Menu");
        mainmenu.setMaximumSize(new java.awt.Dimension(150, 29));
        mainmenu.setMinimumSize(new java.awt.Dimension(150, 29));
        mainmenu.setPreferredSize(new java.awt.Dimension(150, 29));
        mainmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainmenuActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        titleLabel.setText("CURRENT LOCATION");

        regionLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        regionLabel.setText("Region");
        regionLabel.setMaximumSize(new java.awt.Dimension(87, 17));
        regionLabel.setMinimumSize(new java.awt.Dimension(87, 17));
        regionLabel.setPreferredSize(new java.awt.Dimension(87, 17));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nearestLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addGap(21, 21, 21)
                                .addComponent(nearestBSLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(titleLabel))
                        .addGap(102, 102, 102))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchRoutesButt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nearbyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(regionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(regionBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nearbyBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addComponent(findBSButt)
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nearbyLabel)
                    .addComponent(nearbyBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findBSButt))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nearestLabel)
                    .addComponent(nearestBSLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchRoutesButt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regionBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_regionBoxItemStateChanged
        // TODO add your handling code here:
        displayNearby();
    }//GEN-LAST:event_regionBoxItemStateChanged

    private void findBSButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findBSButtActionPerformed
        // TODO add your handling code here:
        String region = (String) regionBox.getSelectedItem();
        if(region.equals("Jakarta Pusat"))
            region = "Central Jakarta";
        else if(region.equals("Jakarta Barat"))
            region = "West Jakarta";
        else if(region.equals("Jakarta Timur"))
            region = "East Jakarta";
        else if(region.equals("Jakarta Selatan"))
            region = "South Jakarta";
        else if(region.equals("Jakarta Utara"))
            region = "North Jakarta";
        String nearby = (String) nearbyBox.getSelectedItem();

        FindLocation user = new FindLocation(region, nearby);
        nearestBSLabel.setText(user.getBusStop());
        this.guest.setDeparture(nearestBSLabel.getText());
    }//GEN-LAST:event_findBSButtActionPerformed

    private void searchRoutesButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchRoutesButtActionPerformed
        // TODO add your handling code here:
        this.dispose();
        this.guest.openSearchRoutesView();
        //new SearchRoutesView(Preferences, nearestBSLabel.getText()).setVisible(true);
        //nearestBSLabel.getText();
    }//GEN-LAST:event_searchRoutesButtActionPerformed

    private void mainmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainmenuActionPerformed
        this.dispose();
        this.guest.openOpeningView();
    }//GEN-LAST:event_mainmenuActionPerformed

    /**
     * @param args the command line arguments
     */
    //public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(findBusStopView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(findBusStopView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(findBusStopView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(findBusStopView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        //java.awt.EventQueue.invokeLater(new Runnable() {
            //public void run() {
                //new findBusStopView().setVisible(true);
            //}
        //});
    //}*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton findBSButt;
    private javax.swing.JButton mainmenu;
    private javax.swing.JComboBox<String> nearbyBox;
    private javax.swing.JLabel nearbyLabel;
    private javax.swing.JLabel nearestBSLabel;
    private javax.swing.JLabel nearestLabel;
    private javax.swing.JComboBox<String> regionBox;
    private javax.swing.JLabel regionLabel;
    private javax.swing.JButton searchRoutesButt;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables


    
}
