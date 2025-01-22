package com.lms.panel;

import com.lms.connection.MySQL;
import com.lms.gui.Dashboard;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author KEHAN HASALAWA
 */
public class StudentPayment extends javax.swing.JPanel {

    private static Dashboard dashboard;

    HashMap<String, String> subjectMap = new HashMap<>();
    HashMap<String, String> monthMap = new HashMap<>();

    public StudentPayment(Dashboard dashboard) {
        initComponents();
        this.dashboard = dashboard;
        loadInvoice(jTextField1.getText());
        loadSubject();
        loadMonth();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Student No :");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice Id", "Student No", "Student Name", "Class No", "Subject", "Month", "Class Fee", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setRowHeight(30);
        jTable1.setSelectionBackground(new java.awt.Color(255, 204, 204));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Subject :");

        jLabel5.setText("None");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Class No :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Teacher Name :");

        jLabel8.setText("None");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Class Fee :");

        jLabel10.setText("None");

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Pay");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Month :");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        loadInvoice(jTextField1.getText());
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged

        String subject = String.valueOf(jComboBox1.getSelectedItem());

        try {

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `class` "
                    + "INNER JOIN `subject` ON `class`.`subject_id` = `subject`.`id` "
                    + "INNER JOIN `teacher` ON `class`.`teacher_nic` = `teacher`.`nic` "
                    + "WHERE `subject`.`name` = '" + subject + "'");

            if (resultSet.next()) {
                jLabel5.setText(resultSet.getString("class.class_no"));
                jLabel10.setText(resultSet.getString("class.class_fee"));
                jLabel8.setText(resultSet.getString("teacher.fname") + " " + resultSet.getString("teacher.lname"));
            } else {
                jLabel5.setText("None");
                jLabel10.setText("None");
                jLabel8.setText("None");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String sNo = jTextField1.getText();
        String class_no = jLabel5.getText();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String month = String.valueOf(jComboBox2.getSelectedItem());

        try {

            if (sNo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter student number.",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (jComboBox1.getSelectedItem().equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please select subject.",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (month.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please select month.",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `class` INNER JOIN `student_has_class` ON "
                        + "`student_has_class`.`class_class_no` = `class`.`class_no` WHERE "
                        + "`class`.`class_no` = '" + class_no + "' AND `student_has_class`.`student_sNo` = '" + sNo + "' ");

                if (resultSet.next()) {

                    String studentHasClassId = resultSet.getString("student_has_class.id");

                    ResultSet resultSet1 = MySQL.executeSearch("SELECT * FROM `invoice` INNER JOIN `student_has_class` ON "
                            + "`invoice`.`student_has_class_id` = `student_has_class`.`id` INNER JOIN `month` ON "
                            + "`invoice`.`month_id` = `month`.`id` INNER JOIN `student` ON "
                            + "`invoice`.`student_sNo` = `student`.`sNo` INNER JOIN `class` ON "
                            + "`student_has_class`.`class_class_no` = `class`.`class_no` INNER JOIN `subject` ON "
                            + "`class`.`subject_id` = `subject`.`id` WHERE `student`.`sNo` = '" + sNo + "' "
                            + "AND `month`.`name` = '" + month + "' AND `student_has_class`.`id` = '" + studentHasClassId + "'");

                    if (resultSet1.next()) {
                        JOptionPane.showMessageDialog(this, "Already paid for selected month. plese select another month.",
                                "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {

                        MySQL.executeIUD("INSERT INTO `invoice` (`date`,`student_has_class_id`,`student_sNo`,`month_id`) "
                                + "VALUES ('" + date + "','" + studentHasClassId + "','" + sNo + "','"+monthMap.get(month)+"')");

                        InputStream path = this.getClass().getResourceAsStream("/com/lms/reports/adyapana_institute_invoice.jasper");

                        HashMap<String, Object> params = new HashMap<>();
                        params.put("Parameter2", date);
                        params.put("Parameter7", sNo);
                        params.put("Parameter8", jComboBox1.getSelectedItem());
                        params.put("Parameter11", class_no);
                        params.put("Parameter1", jLabel8.getText());
                        params.put("Parameter12", jLabel10.getText());
                        params.put("Parameter3", jComboBox2.getSelectedItem());

                        JREmptyDataSource dataSource = new JREmptyDataSource();
                        JasperPrint jasperprint = JasperFillManager.fillReport(path, params, dataSource);

                        JasperViewer.viewReport(jasperprint, false);

                        ReSet();

                        JOptionPane.showMessageDialog(this, "Payment successfull.",
                                "Information", JOptionPane.INFORMATION_MESSAGE);

                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Class not found.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ReSet();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void loadInvoice(String sNo) {

        try {

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `invoice` INNER JOIN `student_has_class` ON "
                    + "`invoice`.`student_has_class_id` = `student_has_class`.`id` INNER JOIN `month` ON "
                    + "`invoice`.`month_id` = `month`.`id` INNER JOIN `student` ON "
                    + "`invoice`.`student_sNo` = `student`.`sNo` INNER JOIN `class` ON "
                    + "`student_has_class`.`class_class_no` = `class`.`class_no` INNER JOIN `subject` ON "
                    + "`class`.`subject_id` = `subject`.`id` WHERE `student`.`sNo` LIKE '" + sNo + "%'");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("invoice.id"));
                vector.add(resultSet.getString("student.sNo"));
                vector.add(resultSet.getString("student.fname") + " " + resultSet.getString("student.lname"));
                vector.add(resultSet.getString("class.class_no"));
                vector.add(resultSet.getString("subject.name"));
                vector.add(resultSet.getString("month.name"));
                vector.add(resultSet.getString("class.class_fee"));
                vector.add(resultSet.getString("invoice.date"));

                model.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadSubject() {

        try {

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `subject`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultSet.next()) {
                vector.add(resultSet.getString("name"));
                subjectMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadMonth() {

        try {

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `month`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultSet.next()) {
                vector.add(resultSet.getString("name"));
                monthMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox2.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void ReSet() {

        jTextField1.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jTable1.clearSelection();
        jLabel5.setText("None");
        jLabel10.setText("None");
        jLabel8.setText("None");
        loadInvoice(jTextField1.getText());

    }

}
