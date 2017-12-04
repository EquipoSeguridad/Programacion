package Forms;

import BO.UsuariosBO;
import javax.swing.JOptionPane;

/**
 *
 * @author md
 */
public class frmPrincipal extends javax.swing.JFrame {
    private String titulo = "ERP";
    private UsuariosBO usuario;
    
    /**
     * Creates new form frmMain
     */
    public frmPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBarPrincipal = new javax.swing.JMenuBar();
        jMenuUsuario = new javax.swing.JMenu();
        jMenuItemLogin = new javax.swing.JMenuItem();
        jMenuItemLogout = new javax.swing.JMenuItem();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuArchivoAbrir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(this.titulo);
        setName("frmPrincipal"); // NOI18N

        jMenuUsuario.setText("Usuario");

        jMenuItemLogin.setText("Login");
        jMenuItemLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLoginActionPerformed(evt);
            }
        });
        jMenuUsuario.add(jMenuItemLogin);

        jMenuItemLogout.setText("Logout");
        jMenuItemLogout.setEnabled(false);
        jMenuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogoutActionPerformed(evt);
            }
        });
        jMenuUsuario.add(jMenuItemLogout);

        jMenuItemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenuUsuario.add(jMenuItemSalir);

        jMenuBarPrincipal.add(jMenuUsuario);

        jMenuArchivo.setText("Archivo");
        jMenuArchivo.setEnabled(false);

        jMenuArchivoAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuArchivoAbrir.setText("Abrir");
        jMenuArchivoAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArchivoAbrirActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuArchivoAbrir);

        jMenuBarPrincipal.add(jMenuArchivo);

        setJMenuBar(jMenuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 411, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLoginActionPerformed
        // Mostrar diálogo de login...
        dlgIniciarSesion dlgSesion = new dlgIniciarSesion(this, true);
        dlgSesion.setVisible(true);
        
        usuario = dlgSesion.getUsuario();
        if( usuario.getIdUsuario() != -1 ) { // -1 = Usuario no validado
//            JOptionPane.showMessageDialog(this, "Bienvenido, " + usuario.getNombreUsuario() + ".",
//                    "Información", JOptionPane.INFORMATION_MESSAGE);
            /*
             * Código maqueta...
             * Verificar los PERMISOS asociados al USUARIO logueado
             * para activar las acciones permitidas
             */
            this.setTitle( usuario.getNombreUsuario() + " @ " + titulo );
            jMenuItemLogin.setEnabled(false);
            jMenuItemLogout.setEnabled(true);
            jMenuArchivo.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Usuario no validado.",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            /* 
             * Código maqueta...
             * Desactivar las opciones que necesitan un usuario logueado
             */
        }
    }//GEN-LAST:event_jMenuItemLoginActionPerformed

    private void jMenuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogoutActionPerformed
        // Mostrar diálogo de login...
        int answer = JOptionPane.showConfirmDialog(
            this, "¿Desea cerrar la sesión?", "Logout", JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        if ( answer == JOptionPane.YES_OPTION ) {
            logout();
        }
    }//GEN-LAST:event_jMenuItemLogoutActionPerformed

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        if( usuario.getIdUsuario() != -1 ) { // -1 = Usuario no validado
            int eleccion = JOptionPane.showConfirmDialog(this, "Para cerrar la aplicación,\n" +
                "su sesión debe ser cerrada.\n¿Desea cerrar su sesión y la aplicación?",
                "Sesión abierta en ERP", JOptionPane.OK_CANCEL_OPTION);
            if ( eleccion == JOptionPane.OK_OPTION ) {
                // Cerrar sesión
                logout();
                // Cerrar la ventana
                dispose();
            }
        } else {
            int eleccion = JOptionPane.showConfirmDialog(this, "¿Desea cerrar la aplicación?",
                "Cerrar ERP", JOptionPane.OK_CANCEL_OPTION);
            if ( eleccion == JOptionPane.OK_OPTION ) {
                // Cerrar la ventana
                dispose();
            }
        }
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jMenuArchivoAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArchivoAbrirActionPerformed
        JOptionPane.showMessageDialog(this, "Acción realizada:\n" +
                    "Archivo > Abrir archivo");
    }//GEN-LAST:event_jMenuArchivoAbrirActionPerformed
    
    private void logout() {        
        /* 
         * Modificar el panel de frmPrincipal...?
         * Código maqueta...
         * Desactivar las opciones que necesitan un usuario logueado
         */
        this.setTitle(titulo);
        jMenuItemLogin.setEnabled(true);
        jMenuItemLogout.setEnabled(false);
        jMenuArchivo.setEnabled(false);
        usuario = new UsuariosBO();
        usuario.setIdUsuario(-1);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenuItem jMenuArchivoAbrir;
    private javax.swing.JMenuBar jMenuBarPrincipal;
    private javax.swing.JMenuItem jMenuItemLogin;
    private javax.swing.JMenuItem jMenuItemLogout;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenu jMenuUsuario;
    // End of variables declaration//GEN-END:variables
}
