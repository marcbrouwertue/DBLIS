/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dblis;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JScrollPane;

/**
 *
 * @author Chen
 */
public class Fram1 extends javax.swing.JFrame {

    /**
     * Creates new form Fram1
     */
    Map<Integer, JScrollPane> parameterPanels; 
    public Fram1() {
        initComponents();
        initParameterPanes();
    }

    public void initParameterPanes(){
        parameterPanels = new HashMap<>();
        for( int i = 0; i < 1000; i++){
            //add JScrollPane to parameterPanels
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

        visualizePanel = new javax.swing.JPanel();
        queryList = new javax.swing.JComboBox();
        parametersPanelHolder = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        pieChartButton = new javax.swing.JButton();
        lineGraphButton = new javax.swing.JButton();
        listGraphButton = new javax.swing.JButton();
        histogramButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        visualizePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Visualize"));

        queryList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Popular sport(s) in country(ies)", "Country(ies) where sport(s) are popular", "Influence of a sport event" }));
        queryList.setToolTipText("<Query>");

        jLabel1.setText("please select a query type");
        parametersPanelHolder.setViewportView(jLabel1);

        pieChartButton.setIcon(new javax.swing.ImageIcon("E:\\Study\\TUe\\Year 2\\Q4\\DBL information system\\DBLIS\\chart_pie_32x32.png")); // NOI18N
        pieChartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pieChartButtonActionPerformed(evt);
            }
        });

        lineGraphButton.setIcon(new javax.swing.ImageIcon("E:\\Study\\TUe\\Year 2\\Q4\\DBL information system\\DBLIS\\Data-Line-Chart-icon_32x32.png")); // NOI18N
        lineGraphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineGraphButtonActionPerformed(evt);
            }
        });

        listGraphButton.setIcon(new javax.swing.ImageIcon("E:\\Study\\TUe\\Year 2\\Q4\\DBL information system\\DBLIS\\grid_layout_snap_small_stock-512_32x32.png")); // NOI18N
        listGraphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listGraphButtonActionPerformed(evt);
            }
        });

        histogramButton.setIcon(new javax.swing.ImageIcon("E:\\Study\\TUe\\Year 2\\Q4\\DBL information system\\DBLIS\\bar_chart-512_32x32.png")); // NOI18N
        histogramButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                histogramButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout visualizePanelLayout = new javax.swing.GroupLayout(visualizePanel);
        visualizePanel.setLayout(visualizePanelLayout);
        visualizePanelLayout.setHorizontalGroup(
            visualizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visualizePanelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(visualizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(parametersPanelHolder)
                    .addGroup(visualizePanelLayout.createSequentialGroup()
                        .addGroup(visualizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(queryList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, visualizePanelLayout.createSequentialGroup()
                                .addComponent(pieChartButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lineGraphButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(listGraphButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(histogramButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        visualizePanelLayout.setVerticalGroup(
            visualizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visualizePanelLayout.createSequentialGroup()
                .addComponent(queryList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(parametersPanelHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(visualizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pieChartButton, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(lineGraphButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listGraphButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(histogramButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(visualizePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(visualizePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pieChartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pieChartButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pieChartButtonActionPerformed

    private void lineGraphButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineGraphButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lineGraphButtonActionPerformed

    private void listGraphButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listGraphButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listGraphButtonActionPerformed

    private void histogramButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_histogramButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_histogramButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Fram1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fram1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fram1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fram1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fram1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton histogramButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton lineGraphButton;
    private javax.swing.JButton listGraphButton;
    private javax.swing.JScrollPane parametersPanelHolder;
    private javax.swing.JButton pieChartButton;
    private javax.swing.JComboBox queryList;
    private javax.swing.JPanel visualizePanel;
    // End of variables declaration//GEN-END:variables
}