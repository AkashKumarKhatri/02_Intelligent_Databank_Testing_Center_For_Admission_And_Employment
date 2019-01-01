/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelligentDatabank.business;

import com.intelligentDatabank.dao.UserDAO;
import com.intelligentDatabank.dao.impl.UserDAOImpl;
import com.intelligentDatabank.models.UserModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Akash
 */
public class UserRegistrationFrame extends javax.swing.JFrame {
    
    private Integer userId;
   
    public UserRegistrationFrame() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
        setSize(width, height);
        setTitle("User Registration");
        populateUserTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnLabel = new javax.swing.JLabel();
        headingLabel = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lbComboRegistrationDate = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        lbRemarks = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lbPassword = new javax.swing.JLabel();
        comboRegistrationDate = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRemarks = new javax.swing.JTextArea();
        lbEmail = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intelligentDatabank/icons/update.png"))); // NOI18N
        btnUpdate.setText("UDATE USER");
        btnUpdate.setEnabled(false);
        btnUpdate.setOpaque(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        backgroundPanel.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 320, 230, 40));

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intelligentDatabank/icons/delete.png"))); // NOI18N
        btnDelete.setText("DELETE USER");
        btnDelete.setEnabled(false);
        btnDelete.setOpaque(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        backgroundPanel.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 380, 230, 40));

        btnClear.setBackground(new java.awt.Color(255, 255, 255));
        btnClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intelligentDatabank/icons/reset.png"))); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.setOpaque(false);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        backgroundPanel.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 440, 230, 40));

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intelligentDatabank/icons/save.png"))); // NOI18N
        btnAdd.setText("ADD USER");
        btnAdd.setOpaque(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        backgroundPanel.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 260, 230, 40));

        btnLabel.setBackground(new java.awt.Color(47, 79, 79));
        btnLabel.setOpaque(true);
        backgroundPanel.add(btnLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 0, 310, 750));

        headingLabel.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        headingLabel.setForeground(new java.awt.Color(47, 79, 79));
        headingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headingLabel.setText("User Registration");
        backgroundPanel.add(headingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 320, 50));

        lbName.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        lbName.setForeground(new java.awt.Color(47, 79, 79));
        lbName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbName.setText("Name :");
        backgroundPanel.add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 80, 30));

        txtName.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        backgroundPanel.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 88, 250, 40));

        lbComboRegistrationDate.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        lbComboRegistrationDate.setForeground(new java.awt.Color(47, 79, 79));
        lbComboRegistrationDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbComboRegistrationDate.setText("Registration Date :");
        backgroundPanel.add(lbComboRegistrationDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 160, 30));

        txtPassword.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        backgroundPanel.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 88, 250, 40));

        lbRemarks.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        lbRemarks.setForeground(new java.awt.Color(47, 79, 79));
        lbRemarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbRemarks.setText("Remarks :");
        backgroundPanel.add(lbRemarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 90, 30));

        txtEmail.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        backgroundPanel.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 148, 250, 40));

        lbPassword.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        lbPassword.setForeground(new java.awt.Color(47, 79, 79));
        lbPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPassword.setText("Password :");
        backgroundPanel.add(lbPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 100, 30));

        comboRegistrationDate.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPanel.add(comboRegistrationDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 148, 250, 40));

        txtRemarks.setColumns(20);
        txtRemarks.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        txtRemarks.setRows(5);
        jScrollPane1.setViewportView(txtRemarks);

        backgroundPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 730, 110));

        lbEmail.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        lbEmail.setForeground(new java.awt.Color(47, 79, 79));
        lbEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbEmail.setText("Email :");
        backgroundPanel.add(lbEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 80, 30));

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));
        tablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(47, 79, 79)), "USERS DETAIL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic", 0, 14), new java.awt.Color(47, 79, 79))); // NOI18N
        tablePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userTable.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        userTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userTable.setFocusable(false);
        userTable.setRowHeight(20);
        userTable.setSelectionBackground(new java.awt.Color(47, 79, 79));
        userTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        userTable.setShowVerticalLines(false);
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(userTable);

        tablePanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 950, 310));

        backgroundPanel.add(tablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 970, 350));

        getContentPane().add(backgroundPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if((txtName.getText().trim()!=null) && (txtEmail.getText().trim()!=null) && (txtPassword.getText().trim()!=null)
                && (txtRemarks.getText().trim()!=null) && (comboRegistrationDate.getDate()!=null)) {
            UserModel userModel = new UserModel();
            userModel.setUserName(txtName.getText().trim());
            userModel.setUserPassword(txtPassword.getText().trim());
            userModel.setEmail(txtEmail.getText().trim());
            userModel.setRemarks(txtRemarks.getText());
            Date date = comboRegistrationDate.getDate();
            userModel.setRegistrationDate(new Timestamp(date.getTime()));
            UserDAO userDAO = new UserDAOImpl();
            int row = userDAO.addUser(userModel);
            if(row>0) {
                populateUserTable();
                clearFields();
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Record Not ADDED!");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseClicked
        btnAdd.setEnabled(false);
        btnDelete.setEnabled(true);
        btnUpdate.setEnabled(true);
        userId = (Integer) userTable.getValueAt(userTable.getSelectedRow(), 0);
        UserDAO userDAO = new UserDAOImpl();
        UserModel userModel = userDAO.getUserWithId(userId);
        txtName.setText(userModel.getUserName());
        txtPassword.setText(userModel.getUserPassword());
        txtRemarks.setText(userModel.getRemarks());
        txtEmail.setText(userModel.getEmail());
        comboRegistrationDate.setDate(userModel.getRegistrationDate());
    }//GEN-LAST:event_userTableMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearFields();
        btnAdd.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if((txtName.getText().trim()!=null) && (txtEmail.getText().trim()!=null) && (txtPassword.getText().trim()!=null)
                && (txtRemarks.getText().trim()!=null) && (comboRegistrationDate.getDate()!=null)) {
            UserModel userModel = new UserModel();
            userModel.setUserId(userId);
            userModel.setUserName(txtName.getText().trim());
            userModel.setUserPassword(txtPassword.getText().trim());
            userModel.setEmail(txtEmail.getText().trim());
            userModel.setRemarks(txtRemarks.getText());
            Date date = comboRegistrationDate.getDate();
            userModel.setRegistrationDate(new Timestamp(date.getTime()));
            UserDAO userDAO = new UserDAOImpl();
            int row = userDAO.updateUser(userModel);
            if(row>0) {
                populateUserTable();
                clearFields();
                btnAdd.setEnabled(true);
                btnDelete.setEnabled(false);
                btnUpdate.setEnabled(false);
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Record Not UPDATED!");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Integer confirm = JOptionPane.showConfirmDialog(rootPane, "Do you realy want to delete", "Delete", JOptionPane.YES_NO_OPTION);
        if(confirm == 0) {
            UserModel userModel = new UserModel();
            userModel.setUserId(userId);
            UserDAO userDAO = new UserDAOImpl();
            int row = userDAO.deleteUser(userModel);
            if(row>0) {
                populateUserTable();
                btnAdd.setEnabled(true);
                btnDelete.setEnabled(false);
                btnUpdate.setEnabled(false);
            }
            else {
                JOptionPane.showMessageDialog(null, "Record Not Deleted");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        txtPassword.requestFocus();
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        txtEmail.requestFocus();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        txtRemarks.requestFocus();
    }//GEN-LAST:event_txtEmailActionPerformed

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
            java.util.logging.Logger.getLogger(UserRegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserRegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserRegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserRegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserRegistrationFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel btnLabel;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser comboRegistrationDate;
    private javax.swing.JLabel headingLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbComboRegistrationDate;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbRemarks;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextArea txtRemarks;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }
        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }
    private void populateUserTable() {  
        UserDAO userDAO = new UserDAOImpl();
        ResultSet rs= userDAO.getAllUserResultSet();
        DefaultTableModel dtm=null;
        try {
            dtm = buildTableModel(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        userTable.setModel(dtm);
    }

    private void clearFields() {
        txtName.setText(null);
        txtEmail.setText(null);
        txtPassword.setText(null);
        txtRemarks.setText(null);
        comboRegistrationDate.setDate(null);
    }
}
