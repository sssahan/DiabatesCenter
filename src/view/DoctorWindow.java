/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import database.DBOperation;
import graph.GraphCreater;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sachithra sahan
 */
public class DoctorWindow extends javax.swing.JFrame {

    /**
     * Creates new form DoctorWindow
     */
    DBOperation db;
    ArrayList<String> resultList,dateList,medicineList;
    String detail;
    public DoctorWindow() {
        initComponents();
        db = DBOperation.getInstance();
        resultList=new ArrayList();
        dateList=new ArrayList();
        medicineList=new ArrayList();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textPID = new javax.swing.JTextField();
        btnTreatment = new javax.swing.JButton();
        btnHBA1C = new javax.swing.JButton();
        btnFBS = new javax.swing.JButton();
        btnRandom = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Doctor Window");
        setResizable(false);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/cloud-logo.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel10)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Patient ID :");

        btnTreatment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTreatment.setForeground(new java.awt.Color(0, 51, 255));
        btnTreatment.setText("View previous treatments");
        btnTreatment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTreatmentActionPerformed(evt);
            }
        });

        btnHBA1C.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHBA1C.setForeground(new java.awt.Color(0, 51, 255));
        btnHBA1C.setText("View HBA1C prograss");
        btnHBA1C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHBA1CActionPerformed(evt);
            }
        });

        btnFBS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFBS.setForeground(new java.awt.Color(0, 51, 255));
        btnFBS.setText("View FBS prograss");
        btnFBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFBSActionPerformed(evt);
            }
        });

        btnRandom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRandom.setForeground(new java.awt.Color(0, 51, 255));
        btnRandom.setText("View Random sugar prograss");
        btnRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRandomActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(0, 51, 255));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textPID, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHBA1C, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFBS, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRandom, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textPID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(btnTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFBS, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHBA1C, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRandom, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTreatmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTreatmentActionPerformed
        try {
            // TODO add your handling code here:
            if(db.isValidPatient(Integer.valueOf(textPID.getText()))){
                btnTreatment.setEnabled(false);
                medicineList=db.getMedicineList(textPID.getText());
                detail=db.getDetails(textPID.getText());
                ViewTreatmentWindow vtw=new ViewTreatmentWindow(medicineList, detail);
                vtw.setLocationRelativeTo(null);
                vtw.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "Invalid patient...!!!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Incorrect format");
            textPID.setText(null);
            //Logger.getLogger(DoctorWindow.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(DoctorWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTreatmentActionPerformed

    private void btnHBA1CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHBA1CActionPerformed
        try {
            // TODO add your handling code here:
            if(db.isValidPatient(Integer.valueOf(textPID.getText()))){
                btnHBA1C.setEnabled(false);
                resultList=db.getResultList(textPID.getText(), "HBA1C");
                dateList=db.getDateList(textPID.getText(), "HBA1C");
                GraphCreater.createGraph(resultList, dateList,"HBA1C");
            }else{
                JOptionPane.showMessageDialog(this, "Invalid patient...!!!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Incorrect format");
            textPID.setText(null);
            //Logger.getLogger(DoctorWindow.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(DoctorWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHBA1CActionPerformed

    private void btnFBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFBSActionPerformed
        try {
            // TODO add your handling code here:
            if(db.isValidPatient(Integer.valueOf(textPID.getText()))){
                btnFBS.setEnabled(false);
                resultList=db.getResultList(textPID.getText(), "FBS");
                dateList=db.getDateList(textPID.getText(), "FBS");
                GraphCreater.createGraph(resultList, dateList,"FBS");
            }else{
                JOptionPane.showMessageDialog(this, "Invalid patient...!!!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Incorrect format");
            textPID.setText(null);
            //Logger.getLogger(DoctorWindow.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(DoctorWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFBSActionPerformed

    private void btnRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRandomActionPerformed
        try {
            // TODO add your handling code here:
            if(db.isValidPatient(Integer.valueOf(textPID.getText()))){
                btnRandom.setEnabled(false);
                resultList=db.getResultList(textPID.getText(), "Random");
                dateList=db.getDateList(textPID.getText(), "Random");
                GraphCreater.createGraph(resultList, dateList,"Random");
            }else{
                JOptionPane.showMessageDialog(this, "Invalid patient...!!!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Incorrect format");
            textPID.setText(null);
            //Logger.getLogger(DoctorWindow.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(DoctorWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRandomActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        textPID.setText(null);
        btnTreatment.setEnabled(true);
        btnFBS.setEnabled(true);
        btnHBA1C.setEnabled(true);
        btnRandom.setEnabled(true);
        
    }//GEN-LAST:event_btnClearActionPerformed

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
            java.util.logging.Logger.getLogger(DoctorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFBS;
    private javax.swing.JButton btnHBA1C;
    private javax.swing.JButton btnRandom;
    private javax.swing.JButton btnTreatment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField textPID;
    // End of variables declaration//GEN-END:variables
}
