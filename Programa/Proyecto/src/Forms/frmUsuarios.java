package Forms;

import BO.PerfilesBO;
import BO.PersonalBO;
import BO.UsuariosBO;
import DAO.UsuariosDAO;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MANUEL
 */
public final class frmUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form frmUsuarios
     */
    public frmUsuarios() {
        initComponents();
        this.setLocationRelativeTo(null);
        Listado(0, "", "", 0, 0);//Trae todos los registros
        lblCodPerf.setVisible(false);
        lblUserID.setVisible(false);
        lblClave.setVisible(false);
        //txtEmpleado.setEditable(false);
        //chkEditar.setEnabled(false);
        mostrarPerfiles();//Muestra los perfiles en el combobox
        mostrarPersonal("");//Muestra el personal en el combobox
        setTextFieldChanged(txtEmpleado);
        lblCodPerf.setText("1");
        lblClave.setText("0");
        btnEliminar.setEnabled(false);
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
        jMenuModificar = new javax.swing.JMenuItem();
        jMenuEliminar = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEmpleado = new javax.swing.JTextField();
        txtusuario = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JCmbPerfiles = new javax.swing.JComboBox<>();
        lblCodPerf = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarios = new JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {

                return false; //Las celdas no son editables.

            }
        };
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblUserID = new javax.swing.JLabel();
        jcmbPersonal = new javax.swing.JComboBox<>();
        lblClave = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();

        jMenuModificar.setText("Modificar");
        jMenuModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuModificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuModificar);

        jMenuEliminar.setText("Eliminar");
        jMenuEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuarios");
        setResizable(false);

        jLabel1.setText("Empleado:");

        jLabel2.setText("Usuario:");

        jLabel3.setText("Contraseña:");

        txtContrasena.setAutoscrolls(false);
        txtContrasena.setMaximumSize(new java.awt.Dimension(20, 10));

        jLabel4.setText("Perfil:");

        JCmbPerfiles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JCmbPerfiles.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCmbPerfilesItemStateChanged(evt);
            }
        });

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableUsuarios.setComponentPopupMenu(jPopupMenu1);
        jTableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableUsuariosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableUsuarios);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icong.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/iconca.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jcmbPersonal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcmbPersonal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbPersonalItemStateChanged(evt);
            }
        });

        lblClave.setText("jLabel5");

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icond.png"))); // NOI18N
        btnEliminar.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblClave))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(lblUserID))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(JCmbPerfiles, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcmbPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar)
                .addGap(27, 27, 27)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addGap(27, 27, 27)
                .addComponent(btnCancelar)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcmbPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblClave)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(lblUserID)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel4))
                    .addComponent(JCmbPerfiles, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnCancelar)
                            .addComponent(btnEliminar)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JCmbPerfilesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCmbPerfilesItemStateChanged
        // TODO add your handling code here:
        int select = JCmbPerfiles.getSelectedIndex();
        if(cont == 0) {
            lblCodPerf.setText("1");
        }else {
            lblCodPerf.setText("" + idsPerf[select]);
        }
        cont++;
    }//GEN-LAST:event_JCmbPerfilesItemStateChanged

    private void jMenuModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuModificarActionPerformed
        // TODO add your handling code here:
        int fila = jTableUsuarios.getSelectedRow();//Obtiene el indice de la fila
        if(fila >=0) {//Verifica que se haya seleccionado una fila
            //chkEditar.setEnabled(true);
            editar = true;//Activa la opcion de editar
            btnCancelar.setEnabled(true);//Activa el boton de cancelar
            btnBuscar.setEnabled(false);//Bloquea el boton de busar
            lblUserID.setText(jTableUsuarios.getValueAt(fila, 0).toString());//obtiene el código del usuario
            txtusuario.setText(jTableUsuarios.getValueAt(fila, 1).toString());//Muestra el nombre del perfil seleccionado
            txtContrasena.setText(jTableUsuarios.getValueAt(fila, 2).toString());//obtiene la contra del perfil
            contraG = txtContrasena.getText();
            txtContrasena.setEditable(false);
            lblCodPerf.setText(jTableUsuarios.getValueAt(fila, 3).toString());//obtiene el codigo del perfil
            lblClave.setText(jTableUsuarios.getValueAt(fila, 4).toString());//obtiene el código del empleao
            String empl = objUsuDao.buscarEmp(Integer.parseInt(lblClave.getText()));
            txtEmpleado.setText(empl);
        }else {
            JOptionPane.showMessageDialog(null, "Porfavor seleccione una fila...");
        }
    }//GEN-LAST:event_jMenuModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(verificarCampos() == false) {
            JOptionPane.showMessageDialog(null, "Error! porfavor ingrese los datos requeridos..");
        }else {
            if(editar == false) {
                if(Guardar()) {
                    JOptionPane.showMessageDialog(null, "Registro agregado correctamente!!!");
                    Listado(0, "", "", 0, 0);//Actualiza los registros que se muestran
                    resetearCampos();
                    
                }else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al agregar el perfil!");
                }
            }else {
                if(btnGuardar.getText().trim().equals("Modificar")) {
                    desbloquearCamposEntrada();
                    txtEmpleado.requestFocus();
                    btnGuardar.setText("Guardar");
                }else {
                    if(Modificar()) {
                        JOptionPane.showMessageDialog(null, "Registro modificado correctamente!!!");
                        Listado(0, "", "", 0, 0);//Actualiza los registros que se muestran
                        resetearCampos();
                    }else {
                        JOptionPane.showMessageDialog(null, "Ocurrió un error al modificar el perfil!");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jMenuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int fila = jTableUsuarios.getSelectedRow();
            if(fila >=0) {
                
                int resp = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar el registro seleccionado?");
                if(JOptionPane.OK_OPTION == resp) {
                    if(Eliminar(Integer.parseInt(jTableUsuarios.getValueAt(fila, 0).toString()))) {//Obtiene el id para eliminar
                        JOptionPane.showMessageDialog(null, "Datos eliminados correctamente!!!");
                    }
                }
            }else {
                JOptionPane.showMessageDialog(null, "Porfavor seleccione una fila...");
            }
            Listado(0,"","",0, 0);
        }catch(Exception err) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar el registro...");
        }
    }//GEN-LAST:event_jMenuEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        if(txtEmpleado.getText().trim().equals("") && txtusuario.getText().trim().equals("") && txtContrasena.getText().trim().equals("")) {
            Listado(0, "", "", 0, 0);
        }else {
            Listado(Integer.parseInt(lblCodPerf.getText().trim()), txtusuario.getText().trim(), "", Integer.parseInt(lblClave.getText().trim()), 1);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        resetearCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jcmbPersonalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbPersonalItemStateChanged
        // TODO add your handling code here:
        if(jcmbPersonal.getItemCount() > 0) {
        int select = jcmbPersonal.getSelectedIndex();
            if(contd == 0) {
                lblClave.setText("0");
            }else {
                
                if(select == 0) {
                    lblClave.setText("0");
                }else {
                    lblClave.setText("" + idsPerso[select - 1]);
                }
            }
            contd++;
            }
    }//GEN-LAST:event_jcmbPersonalItemStateChanged

    private void jTableUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsuariosMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int fila = jTableUsuarios.getSelectedRow();//Obtiene el indice de la fila
                if(fila >=0) {//Verifica que se haya seleccionado una fila
                    mostrarDat = true;
                    editar = true;//Activa la opcion de editar
                    btnCancelar.setEnabled(true);//Activa el boton de cancelar
                    btnBuscar.setEnabled(false);//Bloquea el boton de busar
                    lblUserID.setText(jTableUsuarios.getValueAt(fila, 0).toString());//obtiene el código del usuario
                    txtusuario.setText(jTableUsuarios.getValueAt(fila, 1).toString());//Muestra el nombre del perfil seleccionado
                    txtContrasena.setText(jTableUsuarios.getValueAt(fila, 2).toString());//obtiene la contra del perfil
                    contraG = txtContrasena.getText();
                    txtContrasena.setEditable(false);
                    lblCodPerf.setText(jTableUsuarios.getValueAt(fila, 3).toString());//obtiene el codigo del perfil
                    lblClave.setText(jTableUsuarios.getValueAt(fila, 4).toString());//obtiene el código del empleao
                    claveSelec = jTableUsuarios.getValueAt(fila, 4).toString();
                    String empl = objUsuDao.buscarEmp(Integer.parseInt(lblClave.getText()));
                    txtEmpleado.setText(empl);
                    
                    bloquearCamposEntrada();
                    btnEliminar.setEnabled(true);
                    btnGuardar.setText("Modificar");
                }else {
                    JOptionPane.showMessageDialog(null, "Porfavor seleccione una fila...");
                }
        }
    }//GEN-LAST:event_jTableUsuariosMousePressed

    int i = 0;
    private void setTextFieldChanged(JTextField txt) {
        DocumentListener documentL = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                /*System.out.println("insert");
                lblClave.setText(txtEmpleado.getText());*/
                try{
                mostrarPersonal(txtEmpleado.getText());
                }catch(Exception er) {
                    System.out.println("Ninguna coincidencia");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                /*System.out.println("remove");
                lblClave.setText(txtEmpleado.getText());*/
                try{
                mostrarPersonal(txtEmpleado.getText());
                }catch(Exception er) {
                    System.out.println("Ninguna coincidencia");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                /*System.out.println("change");
                lblClave.setText(txtEmpleado.getText());*/
                try{
                mostrarPersonal(txtEmpleado.getText());
                }catch(Exception er) {
                    System.out.println("Ninguna coincidencia");
                }
            }
        };
        txt.getDocument().addDocumentListener(documentL);
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
            java.util.logging.Logger.getLogger(frmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmUsuarios().setVisible(true);
            }
        });
    }
    
    private void mostrarPerfiles() {
        JCmbPerfiles.removeAllItems();
        idsPerf = new int[listaPerfiles.size()];
        for (int i = 0; i < listaPerfiles.size(); i++) {
            JCmbPerfiles.addItem(listaPerfiles.get(i).getNombrePerfil());
            idsPerf[i] = listaPerfiles.get(i).getIdPerfil();
            //System.out.println(idsPerf[i]);
        }
    }
    
    private void mostrarPersonal(String Nombre) {
        listaPersonal = objUsuDao.buscarPersonal(Nombre);
        jcmbPersonal.removeAllItems();
        jcmbPersonal.addItem("Seleccionar...");
        if(listaPersonal.size() > 0) {
            idsPerso = new String[listaPersonal.size()];
            for (int i = 0; i < listaPersonal.size(); i++) {
                jcmbPersonal.addItem(listaPersonal.get(i).getNombre());
                idsPerso[i] = listaPersonal.get(i).getClave();
                //System.out.println(idsPerf[i]);
            }
        }else{System.out.println("Sin resultado");}
    }
    
    public boolean verificarCampos() {
        if(txtEmpleado.getText().trim().equals("") || txtusuario.getText().trim().equals("") || txtContrasena.getText().trim().equals("") || jcmbPersonal.getSelectedIndex() == 0) {
            return false;
        }else {
            return true;
        }
    }
    
    public void Listado(int idPerfil, String nombreUsu, String passw, int idPers, int opcion) {
        ResultSet result;
        try{
            result = objUsuDao.Lista(idPerfil, nombreUsu, passw, idPers, opcion);
            DefaultTableModel modelo = new DefaultTableModel();
            this.jTableUsuarios.setModel(modelo);
            
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
    
    public boolean Guardar() {
        String passw = objUsuBo.encriptarContrasena(txtContrasena.getText().trim());
        try{
            objUsuBo.setTipoUser(Integer.parseInt(lblCodPerf.getText().trim()));
            objUsuBo.setUsuario(txtusuario.getText().trim());
            objUsuBo.setPassw(passw);
            objUsuBo.setClaveEmp(lblClave.getText().trim());
            
            objUsuDao.AgregarUsuario(objUsuBo);
            return true;
        }catch(Exception e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error! Puede que el código ya esté registrado...");
            return false;
        }
    }
    
    public boolean Modificar() {
        try{
            objUsuBo.setId_user(Integer.parseInt(lblUserID.getText().trim()));
            objUsuBo.setTipoUser(Integer.parseInt(lblCodPerf.getText().trim()));
            objUsuBo.setUsuario(txtusuario.getText().trim());
            //objUsuBo.setPassw(objUsuBo.encriptarContrasena(txtContrasena.getText().trim()));
            objUsuBo.setClaveEmp(lblClave.getText().trim());
            
            objUsuDao.Modificarusuarios(objUsuBo);
            return true;
        }catch(Exception e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error!...");
            return false;
        }
    }
    
    public boolean Eliminar(int codUser) {
        try{
            objUsuBo.setId_user(codUser);
            
            objUsuDao.EliminarUsuario(objUsuBo);
            return true;
        }catch(Exception e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error!...");
            return false;
        }
    }
    
    public void desbloquearCamposEntrada() {
        txtEmpleado.requestFocus();
        //chkEditar.setEnabled(true);
        txtEmpleado.setEditable(true);
        txtusuario.setEditable(true);
        //txtContrasena.setEditable(true);
        JCmbPerfiles.setEnabled(true);
        jcmbPersonal.setEnabled(true);
    }
    
    public void bloquearCamposEntrada() {
        //chkEditar.setEnabled(false);
        txtEmpleado.setEditable(false);
        txtusuario.setEditable(false);
        txtContrasena.setEditable(false);
        JCmbPerfiles.setEnabled(false);
        jcmbPersonal.setEnabled(false);
    }
    
    public void resetearCampos() {
        txtEmpleado.requestFocus();
        txtEmpleado.setText("");
        txtusuario.setText("");
        txtContrasena.setText("");
        lblClave.setText("0");
        lblCodPerf.setText("1");
        lblUserID.setText("0");
        btnGuardar.setEnabled(true);
        btnBuscar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(false);
        //chkEditar.setEnabled(false);
        txtContrasena.setEditable(true);
        JCmbPerfiles.setEnabled(true);
        jcmbPersonal.setEnabled(true);
        
        txtEmpleado.setEditable(true);
        txtusuario.setEditable(true);
        txtContrasena.setEditable(true);
        JCmbPerfiles.setEnabled(true);
        jcmbPersonal.setEnabled(true);
        
        cont = 0;
        Listado(0, "", "", 0, 0);
        claveSelec = "";
        mostrarDat = false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCmbPerfiles;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuEliminar;
    private javax.swing.JMenuItem jMenuModificar;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JComboBox<String> jcmbPersonal;
    public static javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblCodPerf;
    private javax.swing.JLabel lblUserID;
    private javax.swing.JTextField txtContrasena;
    public static javax.swing.JTextField txtEmpleado;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
    
    
    //Variables para conexion
    UsuariosDAO objUsuDao = new UsuariosDAO();
    UsuariosBO objUsuBo = new UsuariosBO();
    PersonalBO objPersBo = new PersonalBO();
    int[] idsPerf;
    String[] idsPerso;
    ArrayList < PerfilesBO > listaPerfiles = objUsuDao.consultarPerfiles();
    ArrayList <PersonalBO> listaPersonal;
    int cont = 0;
    int contd = 0;
    private boolean editar = false;
    private boolean mostrarDat = false;
    private String claveSelec = "";
    String contraG = "";
}
