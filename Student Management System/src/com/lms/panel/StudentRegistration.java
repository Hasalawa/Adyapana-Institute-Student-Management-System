package com.lms.panel;

import com.formdev.flatlaf.FlatClientProperties;
import com.lms.connection.MySQL;
import com.lms.custom.delete.button.TableDeleteCellEditor;
import com.lms.custom.delete.button.TableDeleteCellRender;
import com.lms.custom.delete.button.TableDeleteEvent;
import com.lms.gui.Dashboard;
import com.lms.gui.Address;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author KEHAN HASALAWA
 */
public class StudentRegistration extends javax.swing.JPanel {

    public static Dashboard dashboard;

    HashMap<String, String> cityMap = new HashMap<>();

    public StudentRegistration(Dashboard dashboard) {
        initComponents();
        this.dashboard = dashboard;
        jButton3.setEnabled(false);
        loadStudent(jTextField6.getText());
        deleteButton();
        studentCount();
        jTextField6.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Searching Student No");
    }

    public JLabel getId() {
        return jLabel15;
    }

    public JLabel getLine1() {
        return jLabel16;
    }

    public JLabel getLine2() {
        return jLabel17;
    }

    public JLabel getCity() {
        return jLabel18;
    }

    public JLabel getDistrict() {
        return jLabel19;
    }

    public JLabel getProvince() {
        return jLabel20;
    }

    public void deleteButton() {

        TableDeleteEvent event = new TableDeleteEvent() {
            @Override
            public void onDelete(int row) {
                String sNo = String.valueOf(jTable1.getValueAt(row, 0));
                try {

                    ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `student_has_class` WHERE `student_sNo` = '" + sNo + "'");

                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(null, "Student cannot be deleted as it is referenced in the some table.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {

                        int response = JOptionPane.showConfirmDialog(null, "Do you want to delete?",
                                "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            MySQL.executeIUD("DELETE FROM `student` WHERE `sNo` = '" + sNo + "'");
                            
                            studentCount();
                            reSet();
                            JOptionPane.showMessageDialog(null, "Record deleted successfully.",
                                    "Success", JOptionPane.INFORMATION_MESSAGE);
                        }

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        jTable1.getColumnModel().getColumn(6).setCellRenderer(new TableDeleteCellRender());
        jTable1.getColumnModel().getColumn(6).setCellEditor(new TableDeleteCellEditor(event));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Student Registration");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Student No:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("First Name :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Last Name :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Mobile :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Birthday:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Gender :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Address :");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Male");
        jRadioButton1.setActionCommand("1");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Female");
        jRadioButton2.setActionCommand("2");

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Select Address");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Id :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Line 01 :");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Line 02 :");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("City :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("District :");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Province :");

        jLabel15.setText("-");

        jLabel16.setText("-");

        jLabel17.setText("-");

        jLabel18.setText("-");

        jLabel19.setText("-");

        jLabel20.setText("-");

        jButton2.setBackground(new java.awt.Color(255, 0, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Create New Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 153, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Update Account");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 102, 102));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Clear All");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addGap(7, 7, 7))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(26, 26, 26))))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jRadioButton1)
                                            .addGap(28, 28, 28)
                                            .addComponent(jRadioButton2)))
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addComponent(jLabel18))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16)
                    .addComponent(jLabel19))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student No", "First Name", "Last Name", "Mobile", "Birthday", "Gender", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setRowHeight(30);
        jTable1.setSelectionBackground(new java.awt.Color(255, 204, 204));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText("Count :");

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("00");

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lms/resources/search_ico2.png"))); // NOI18N
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 30, 30));

        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });
        jPanel3.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 317, 32));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lms/resources/print.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Address address = new Address();
        address.setVisible(true);
        address.setStudentReg(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String sNo = jTextField1.getText();
        String fname = jTextField2.getText();
        String lname = jTextField3.getText();
        String mobile = jTextField4.getText();
        Date birthday = jDateChooser1.getDate();
        String addressId = jLabel15.getText();
        String dateTime = sdf.format(new Date());
        ButtonModel gender = buttonGroup1.getSelection();

        if (sNo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter student's student number.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter student's first name",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter student's last name",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter student's mobile number",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid mobile number",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (birthday == null) {
            JOptionPane.showMessageDialog(this, "Please enter student's birthday",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (gender == null) {
            JOptionPane.showMessageDialog(this, "Please Select student's Gender", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (addressId.equals("-")) {
            JOptionPane.showMessageDialog(this, "Please select student's address",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `student` WHERE `sNo` = '" + sNo + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Student has already using student number.",
                            "Warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    String genderId = gender.getActionCommand();

                    MySQL.executeIUD("INSERT INTO `student` VALUES ('" + sNo + "','" + fname + "','" + lname + "','" + mobile + "',"
                            + "'" + sdf.format(birthday) + "','" + dateTime + "','" + genderId + "','" + addressId + "')");

                    reSet();
                    studentCount();
                    JOptionPane.showMessageDialog(this, "Student Registration Successfull.",
                            "Success", JOptionPane.INFORMATION_MESSAGE);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        loadStudent(jTextField6.getText());
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        try {

            jTextField1.setEditable(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(true);

            int row = jTable1.getSelectedRow();

            String sNo = String.valueOf(jTable1.getValueAt(row, 0));
            jTextField1.setText(sNo);

            jTextField2.setText(String.valueOf(jTable1.getValueAt(row, 1)));
            jTextField3.setText(String.valueOf(jTable1.getValueAt(row, 2)));
            jTextField4.setText(String.valueOf(jTable1.getValueAt(row, 3)));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(String.valueOf(jTable1.getValueAt(row, 4)));
            jDateChooser1.setDate(date);

            String gender = String.valueOf(jTable1.getValueAt(row, 5));

            if (gender.equals("Male")) {
                jRadioButton1.setSelected(true);
            }

            if (gender.equals("Female")) {
                jRadioButton2.setSelected(true);
            }

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `student` INNER JOIN `address` ON "
                    + "`student`.`address_id` = `address`.`id` INNER JOIN `city` ON `address`.`city_id` = `city`.`id` "
                    + "INNER JOIN `district` ON `city`.`district_id` = `district`.`id` INNER JOIN `province` ON "
                    + "`district`.`province_id` = `province`.`id` WHERE `sNo` = '" + sNo + "'");

            if (resultSet.next()) {

                String addressId = resultSet.getString("address.id");
                jLabel15.setText(addressId);

                String line1 = resultSet.getString("address.line1");
                jLabel16.setText(line1);

                String line2 = resultSet.getString("address.line2");
                jLabel17.setText(line2);

                String city = resultSet.getString("city.name");
                jLabel18.setText(city);

                String district = resultSet.getString("district.name");
                jLabel19.setText(district);

                String province = resultSet.getString("province.name");
                jLabel20.setText(province);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        reSet();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String sNo = jTextField1.getText();
        String fname = jTextField2.getText();
        String lname = jTextField3.getText();
        String mobile = jTextField4.getText();
        Date birthday = jDateChooser1.getDate();
        String addressId = jLabel15.getText();
        String dateTime = sdf.format(new Date());
        ButtonModel gender = buttonGroup1.getSelection();

        if (sNo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter student's student number.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter student's first name",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter student's last name",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter student's mobile number",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid mobile number",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (birthday == null) {
            JOptionPane.showMessageDialog(this, "Please enter student's birthday.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (gender == null) {
            JOptionPane.showMessageDialog(this, "Please Select student's Gender", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (addressId.equals("-")) {
            JOptionPane.showMessageDialog(this, "Please select student's address",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                String genderId = gender.getActionCommand();

                MySQL.executeIUD("UPDATE `student` SET "
                        + "`fname` = '" + fname + "', "
                        + "`lname` = '" + lname + "', "
                        + "`mobile` = '" + mobile + "', "
                        + "`dob` = '" + sdf.format(birthday) + "', "
                        + "`address_id` = '" + addressId + "', "
                        + "`gender_id` = '" + genderId + "' "
                        + "WHERE `sNo` = '" + sNo + "'");

                reSet();
                studentCount();
                JOptionPane.showMessageDialog(this, "Student details updated Successfull.",
                        "Success", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        try {

            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

            InputStream path = this.getClass().getResourceAsStream("/com/lms/reports/adyapana_institute_student_report.jasper");

            HashMap<String, Object> params = new HashMap<>();
            params.put("Parameter1", date);

            JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());
            JasperPrint jasperprint = JasperFillManager.fillReport(path, params, dataSource);

            JasperViewer.viewReport(jasperprint, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables

    private void reSet() {

        jTextField1.setText("");
        jTextField1.setEditable(true);
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField6.setText("");
        jDateChooser1.setDate(null);
        jLabel15.setText("-");
        jLabel16.setText("-");
        jLabel17.setText("-");
        jLabel18.setText("-");
        jLabel19.setText("-");
        jLabel20.setText("-");
        buttonGroup1.clearSelection();
        jButton3.setEnabled(false);
        jButton2.setEnabled(true);
        jTable1.clearSelection();
        
        loadStudent(jTextField6.getText());

    }

    private void loadStudent(String sNo) {

        try {

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `student` INNER JOIN `gender` ON "
                    + "`student`.`gender_id` = `gender`.`id` WHERE `student`.`sNo` LIKE '" + sNo + "%'");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("sNo"));
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("lname"));
                vector.add(resultSet.getString("mobile"));
                vector.add(resultSet.getString("dob"));
                vector.add(resultSet.getString("gender.name"));

                model.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void studentCount() {
        try {

            ResultSet resultSet = MySQL.executeSearch("SELECT COUNT(sNo) FROM `student`");

            if (resultSet.next()) {
                jLabel22.setText(resultSet.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
