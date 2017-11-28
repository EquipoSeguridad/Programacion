/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import DAO.PersonalDAO;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MANUEL
 */
public class frmConsultarPersonal extends javax.swing.JFrame {

    /**
     * Creates new form frmConsultarPersonal
     */
    public frmConsultarPersonal() {
        initComponents();
        Listado("", 0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuSeleccionar = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtablePersonal = new javax.swing.JTable();

        jMenuSeleccionar.setText("Seleccionar");
        jMenuSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSeleccionarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuSeleccionar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar personal");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Nombre:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        JtablePersonal.setModel(new javax.swing.table.DefaultTableModel(
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
        JtablePersonal.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(JtablePersonal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addContainerGap(86, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        if(txtNombre.getText().trim().equals("")) {
            Listado("", 0);
        }else {
            Listado(txtNombre.getText(), 1);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jMenuSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSeleccionarActionPerformed
        // TODO add your handling code here:
        int fila = JtablePersonal.getSelectedRow();//Obtiene el indice de la fila
        frmUsuarios objfrmPerf = new frmUsuarios();
        if(fila >=0) {//Verifica que se haya seleccionado una fila
            objfrmPerf.txtEmpleado.setText(JtablePersonal.getValueAt(fila, 1).toString());
            objfrmPerf.lblClave.setText(JtablePersonal.getValueAt(fila, 0).toString());
            objfrmPerf.setVisible(true);
            this.setVisible(false);
        }else {
            JOptionPane.showMessageDialog(null, "Porfavor seleccione una fila...");
        }
    }//GEN-LAST:event_jMenuSeleccionarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        frmUsuarios objfrmPerf = new frmUsuarios();
        objfrmPerf.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(frmConsultarPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmConsultarPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmConsultarPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmConsultarPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmConsultarPersonal().setVisible(true);
            }
        });
    }
    
    public void Listado(String nombre, int Opcion) {
        ResultSet result;
        try{
            result = objPersDAO.Lista(nombre, Opcion);
            DefaultTableModel modelo = new DefaultTableModel();
            this.JtablePersonal.setModel(modelo);
            
            java.sql.ResultSetMetaData mtDatos = result.getMetaData();
            int numColumn = mtDatos.getColumnCount();
            Object[] nomCampos = new Object[numColumn];
            for(int i = 0; i < numColumn; i++) {
                nomCampos[i] = mtDatos.getColumnLabel(i+1);
            }
            modelo.setColumnIdentifiers(nomCampos);
            while(result.next()) {
                Object[] fila = new Object[numColumn];
                for(int j = 0; j < numColumn; j++) {
                    fila[j] = result.getObject(j+1);
                }
                modelo.addRow(fila);
            }
            //result.close();
        }catch(Exception err) {
            System.out.println("Error! no hay nada en la base de datos...");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JtablePersonal;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuSeleccionar;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

       //VAriables para la conexion
    PersonalDAO objPersDAO = new PersonalDAO();
    

}
