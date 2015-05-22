/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import dblis.GraphInfo;
import dblis.SportData2;
//import java.awt.Dimension;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JCheckBox;

/**
 *
 * @author Chen
 */
public class MainFrame extends CenterFrame {
    private FXPanel fxPanel;

    /**
     * Creates new form MainFrame
     */
    List<JCheckBox> sportCheckboxes;
    public MainFrame() {
        initComponents();
        centerize();
        sportCheckboxes = new ArrayList<>();
        sportCheckboxes.add(hockeyCheckBox);
        sportCheckboxes.add(tennisCheckBox);
        sportCheckboxes.add(footballCheckBox);
        sportCheckboxes.add(cyclingCheckBox);
        sportCheckboxes.add(skatingCheckBox);
        fxPanel = new FXPanel();
        testPanel.add(fxPanel);
//        GraphInfo graphInfo = new GraphInfo(startTimePicker.getDate(),
//                endTimePicker.getDate(), footballCheckBox.isSelected(),
//            hockeyCheckBox.isSelected(), cyclingCheckBox.isSelected(),
//            tennisCheckBox.isSelected(), skatingCheckBox.isSelected(), 1);
        fxPanel.drawScene(0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sportsDialog = new javax.swing.JDialog();
        footballCheckBox = new javax.swing.JCheckBox();
        hockeyCheckBox = new javax.swing.JCheckBox();
        cyclingCheckBox = new javax.swing.JCheckBox();
        tennisCheckBox = new javax.swing.JCheckBox();
        skatingCheckBox = new javax.swing.JCheckBox();
        sportsSelectAllBtn = new javax.swing.JButton();
        sportsDeselectAllBtn = new javax.swing.JButton();
        sportsInverseSelectionBtn = new javax.swing.JButton();
        sportsOKBtn = new javax.swing.JButton();
        sportsCancelBtn = new javax.swing.JButton();
        parametersPanel = new javax.swing.JPanel();
        timeIntervalLabel = new javax.swing.JLabel();
        startTimePicker = new com.lavantech.gui.comp.DateTimePicker();
        endTimePicker = new com.lavantech.gui.comp.DateTimePicker();
        startTimeLabel = new javax.swing.JLabel();
        endTimeLabel = new javax.swing.JLabel();
        timeIntervalCombo = new javax.swing.JComboBox();
        sportsLabel = new javax.swing.JLabel();
        yearCombo = new javax.swing.JComboBox();
        yearLabel = new javax.swing.JLabel();
        sportsChooseBtn = new javax.swing.JButton();
        showYearDataCheckbox = new javax.swing.JCheckBox();
        showBtn = new javax.swing.JButton();
        lineChartBtn = new javax.swing.JButton();
        histogramBtn = new javax.swing.JButton();
        pieChartBtn = new javax.swing.JButton();
        listBtn = new javax.swing.JButton();
        visualizationPanel = new javax.swing.JPanel();
        testPanel = new javax.swing.JPanel();

        sportsDialog.setTitle("Select the sports to show");

        footballCheckBox.setText("Football");

        hockeyCheckBox.setText("Hockey");
        hockeyCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hockeyCheckBoxActionPerformed(evt);
            }
        });

        cyclingCheckBox.setText("Cycling");

        tennisCheckBox.setText("Tennis");

        skatingCheckBox.setText("Skating");

        sportsSelectAllBtn.setText("Select all");
        sportsSelectAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sportsSelectAllBtnActionPerformed(evt);
            }
        });

        sportsDeselectAllBtn.setText("Deselect all");
        sportsDeselectAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sportsDeselectAllBtnActionPerformed(evt);
            }
        });

        sportsInverseSelectionBtn.setText("Invert selection");
        sportsInverseSelectionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sportsInverseSelectionBtnActionPerformed(evt);
            }
        });

        sportsOKBtn.setText("OK");
        sportsOKBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sportsOKBtnActionPerformed(evt);
            }
        });

        sportsCancelBtn.setText("Cancel");
        sportsCancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sportsCancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sportsDialogLayout = new javax.swing.GroupLayout(sportsDialog.getContentPane());
        sportsDialog.getContentPane().setLayout(sportsDialogLayout);
        sportsDialogLayout.setHorizontalGroup(
            sportsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sportsDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sportsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sportsDialogLayout.createSequentialGroup()
                        .addComponent(footballCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hockeyCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cyclingCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tennisCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(skatingCheckBox))
                    .addGroup(sportsDialogLayout.createSequentialGroup()
                        .addComponent(sportsSelectAllBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sportsDeselectAllBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sportsInverseSelectionBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(sportsDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sportsOKBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sportsCancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        sportsDialogLayout.setVerticalGroup(
            sportsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sportsDialogLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(sportsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(footballCheckBox)
                    .addComponent(hockeyCheckBox)
                    .addComponent(cyclingCheckBox)
                    .addComponent(tennisCheckBox)
                    .addComponent(skatingCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(sportsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(sportsDeselectAllBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(sportsSelectAllBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sportsInverseSelectionBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(sportsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sportsOKBtn)
                    .addComponent(sportsCancelBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("That bird is fit");

        parametersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Parameters"));

        timeIntervalLabel.setText("Time interval");

        startTimeLabel.setText("Start time");

        endTimeLabel.setText("End time");

        timeIntervalCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Month", "Week", "Day" }));

        sportsLabel.setText("Sports");

        yearCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "< -- >", "2013", "2014", "2015", "" }));
        yearCombo.setEnabled(false);

        yearLabel.setText("Year :");
        yearLabel.setEnabled(false);

        sportsChooseBtn.setText("Choose");
        sportsChooseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sportsChooseBtnActionPerformed(evt);
            }
        });

        showYearDataCheckbox.setLabel("Show data in one year");
        showYearDataCheckbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yearDataCheckboxChanged(evt);
            }
        });
        showYearDataCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showYearDataCheckboxActionPerformed(evt);
            }
        });

        showBtn.setText("Show");
        showBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBtnActionPerformed(evt);
            }
        });

        lineChartBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons/Data-Line-Chart-icon_32x32.png"))); // NOI18N
        lineChartBtn.setToolTipText("");

        histogramBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons/bar_chart-512_32x32.png"))); // NOI18N
        histogramBtn.setToolTipText("");

        pieChartBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons/chart_pie_32x32.png"))); // NOI18N
        pieChartBtn.setToolTipText("");

        listBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons/grid_layout_snap_small_stock-512_32x32.png"))); // NOI18N
        listBtn.setToolTipText("");

        javax.swing.GroupLayout parametersPanelLayout = new javax.swing.GroupLayout(parametersPanel);
        parametersPanel.setLayout(parametersPanelLayout);
        parametersPanelLayout.setHorizontalGroup(
            parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parametersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(parametersPanelLayout.createSequentialGroup()
                        .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(parametersPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(yearLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(parametersPanelLayout.createSequentialGroup()
                                .addComponent(startTimeLabel)
                                .addGap(89, 89, 89)
                                .addComponent(endTimeLabel))
                            .addGroup(parametersPanelLayout.createSequentialGroup()
                                .addComponent(startTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(endTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timeIntervalLabel)
                            .addComponent(timeIntervalCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sportsChooseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sportsLabel)))
                    .addComponent(showYearDataCheckbox))
                .addGap(5, 5, 5)
                .addComponent(showBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(parametersPanelLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(lineChartBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(histogramBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pieChartBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(listBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        parametersPanelLayout.setVerticalGroup(
            parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parametersPanelLayout.createSequentialGroup()
                .addComponent(showYearDataCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(parametersPanelLayout.createSequentialGroup()
                            .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(startTimeLabel)
                                .addComponent(endTimeLabel)
                                .addComponent(yearLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(startTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(endTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(parametersPanelLayout.createSequentialGroup()
                            .addComponent(sportsLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(sportsChooseBtn))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, parametersPanelLayout.createSequentialGroup()
                            .addComponent(timeIntervalLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(timeIntervalCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(yearCombo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(showBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lineChartBtn)
                    .addComponent(histogramBtn)
                    .addComponent(pieChartBtn)
                    .addComponent(listBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        visualizationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Visualization"));
        visualizationPanel.setLayout(new java.awt.GridLayout(1, 0));

        testPanel.setBackground(new java.awt.Color(255, 255, 255));
        testPanel.setLayout(new java.awt.GridLayout(1, 0));
        visualizationPanel.add(testPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(parametersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(visualizationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(visualizationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parametersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hockeyCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hockeyCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hockeyCheckBoxActionPerformed

    private void sportsChooseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sportsChooseBtnActionPerformed
        // TODO add your handling code here:
        for(JCheckBox cb : sportCheckboxes){
            cb.setSelected(false);
        }
        sportsDialog.setSize(380, 180);
        sportsDialog.show();
    }//GEN-LAST:event_sportsChooseBtnActionPerformed

    private void sportsOKBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sportsOKBtnActionPerformed
        // TODO add your handling code here:
        sportsDialog.dispose();
        
    }//GEN-LAST:event_sportsOKBtnActionPerformed

    private void sportsCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sportsCancelBtnActionPerformed
        // TODO add your handling code here:
        
        sportsDialog.dispose();
    }//GEN-LAST:event_sportsCancelBtnActionPerformed

    private void sportsSelectAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sportsSelectAllBtnActionPerformed
        // TODO add your handling code here:
        for(JCheckBox cb : sportCheckboxes){
            cb.setSelected(true);
        }
    }//GEN-LAST:event_sportsSelectAllBtnActionPerformed

    private void sportsDeselectAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sportsDeselectAllBtnActionPerformed
        // TODO add your handling code here:
        for(JCheckBox cb : sportCheckboxes){
            cb.setSelected(false);
        }
    }//GEN-LAST:event_sportsDeselectAllBtnActionPerformed

    private void sportsInverseSelectionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sportsInverseSelectionBtnActionPerformed
        // TODO add your handling code here:
        for(JCheckBox cb : sportCheckboxes){
            cb.setSelected(!cb.isSelected());
        }
    }//GEN-LAST:event_sportsInverseSelectionBtnActionPerformed

    private void showYearDataCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showYearDataCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showYearDataCheckboxActionPerformed

    private void yearDataCheckboxChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yearDataCheckboxChanged
        // TODO add your handling code here:
        boolean showYear  = showYearDataCheckbox.isSelected();
        this.yearLabel.setEnabled(showYear);
        this.yearCombo.setEnabled(showYear);
        this.startTimeLabel.setEnabled(!showYear);
        this.endTimeLabel.setEnabled(!showYear);
        this.startTimePicker.setEnabled(!showYear);
        this.endTimePicker.setEnabled(!showYear);
    }//GEN-LAST:event_yearDataCheckboxChanged

    // If the show button is pressed we update the graph
    // 
    private void showBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBtnActionPerformed
        System.out.println("Pressed");
        int timeInterval = 0;
        String selected = timeIntervalCombo.getSelectedItem().toString();
        if(selected.equals("Month")){
            timeInterval = 30;
        } else if(selected.equals("Week")){
            timeInterval = 7;
        } else if(selected.equals("Day")){
            timeInterval = 1;
        }
        GraphInfo graphInfo = new GraphInfo(startTimePicker.getDate(),
                endTimePicker.getDate(), footballCheckBox.isSelected(),
            hockeyCheckBox.isSelected(), cyclingCheckBox.isSelected(),
            tennisCheckBox.isSelected(), skatingCheckBox.isSelected(), 1);
        fxPanel.drawScene(2);
        
        SportData2.getInstance().setDates(getStartDate(), getEndDate());
        SportData2.getInstance().setSelected(getSports());
        SportData2.getInstance().setInterval(timeInterval);
    }//GEN-LAST:event_showBtnActionPerformed

    private Date getStartDate() {
        return startTimePicker.getDate();
    }
    
    private Date getEndDate() {
        return endTimePicker.getDate();
    }
    
    
    private List<String> getSports() {
        List sports = new ArrayList();
        if(footballCheckBox.isSelected() == true) {
            sports.add(footballCheckBox.getName().toLowerCase());
        }
        if(hockeyCheckBox.isSelected() == true) {
            sports.add(hockeyCheckBox.getName().toLowerCase());
        }
        if(cyclingCheckBox.isSelected() == true) {
            sports.add(cyclingCheckBox.getName().toLowerCase());
        }
        if(tennisCheckBox.isSelected() == true) {
            sports.add(tennisCheckBox.getName().toLowerCase());
        }
        if(skatingCheckBox.isSelected() == true) {
            sports.add(skatingCheckBox.getName().toLowerCase());
        }
        return sports;
    }
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        SportData2.getInstance().init();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cyclingCheckBox;
    private javax.swing.JLabel endTimeLabel;
    private com.lavantech.gui.comp.DateTimePicker endTimePicker;
    private javax.swing.JCheckBox footballCheckBox;
    private javax.swing.JButton histogramBtn;
    private javax.swing.JCheckBox hockeyCheckBox;
    private javax.swing.JButton lineChartBtn;
    private javax.swing.JButton listBtn;
    private javax.swing.JPanel parametersPanel;
    private javax.swing.JButton pieChartBtn;
    private javax.swing.JButton showBtn;
    private javax.swing.JCheckBox showYearDataCheckbox;
    private javax.swing.JCheckBox skatingCheckBox;
    private javax.swing.JButton sportsCancelBtn;
    private javax.swing.JButton sportsChooseBtn;
    private javax.swing.JButton sportsDeselectAllBtn;
    private javax.swing.JDialog sportsDialog;
    private javax.swing.JButton sportsInverseSelectionBtn;
    private javax.swing.JLabel sportsLabel;
    private javax.swing.JButton sportsOKBtn;
    private javax.swing.JButton sportsSelectAllBtn;
    private javax.swing.JLabel startTimeLabel;
    private com.lavantech.gui.comp.DateTimePicker startTimePicker;
    private javax.swing.JCheckBox tennisCheckBox;
    private javax.swing.JPanel testPanel;
    private javax.swing.JComboBox timeIntervalCombo;
    private javax.swing.JLabel timeIntervalLabel;
    private javax.swing.JPanel visualizationPanel;
    private javax.swing.JComboBox yearCombo;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables
}
