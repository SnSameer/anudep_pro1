/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package admin.employee;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pande
 */
public class ViewEmployee extends javax.swing.JPanel {
    Object [] row;
    DefaultTableModel model;
    /**
     * Creates new form ViewEmployee
     */
    public ViewEmployee() {
        initComponents();
        getEmployee();
    }
    
    void getEmployee(){
        model = (DefaultTableModel) jTable1.getModel();
        String name,email,phone_no,gender;
        int srno = 0;
        try{
            ResultSet rs = dbconnection.Db_Operations.showAllEmployee();
            if(rs!=null){
                while(rs.next()){
                    srno += 1;
                    name = rs.getString("name");
                    email = rs.getString("email");
                    phone_no = rs.getString("phone_no");
                    gender = rs.getString("gender");
                    
                    row=new Object[]{srno,name,email,phone_no,gender};
                    model.addRow(row);
//                    System.out.println(name+" : "+email);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr no", "Name", "Email", "Phone No", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
