package com.lms.gui;

import com.lms.panel.TeacherRegistration;
import java.awt.BorderLayout;
import javax.swing.SwingUtilities;

/**
 *
 * @author KEHAN HASALAWA
 */
public class Teacher extends javax.swing.JFrame {
    
    public Dashboard dashboard;
    private static Teacher activeTeacher;

    public Teacher() {
        initComponents();
        loadTeacherReg();
        activeTeacher = this;
    }
    
    public static Teacher getActiveTeacher() {
        return activeTeacher;
    }

    public static void closeActiveTeacher() {
        if (activeTeacher != null) {
            activeTeacher.dispose();
            activeTeacher = null;
        }
    }
    
    public void loadTeacherReg(){
        jPanel1.setLayout(new BorderLayout());
        jPanel1.removeAll();
        TeacherRegistration databaseProcessViewer = new TeacherRegistration(dashboard);
        jPanel1.add(databaseProcessViewer, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel1);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Teacher Registration");
        setResizable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1010, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
