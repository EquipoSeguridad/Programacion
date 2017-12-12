package Forms;

import BO.UsuarioBO;
import javax.swing.JOptionPane;

/**
 *
 * @author md
 */
public class frmPrincipal extends javax.swing.JFrame {
    private final String titulo;
    private UsuarioBO usuario;
    
    /**
     * Creates new form frmMain
     */
    public frmPrincipal() {
        titulo = "ERP";
        usuario = new UsuarioBO();
        usuario.setIdUsuario(-1);
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
        jMenuUsuarioItemLogin = new javax.swing.JMenuItem();
        jMenuUsuarioItemLogout = new javax.swing.JMenuItem();
        jMenuUsuarioItemSalir = new javax.swing.JMenuItem();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuArchivoItemAbrir = new javax.swing.JMenuItem();
        jMenuGestion = new javax.swing.JMenu();
        jMenuGestionItemPerfiles = new javax.swing.JMenuItem();
        jMenuGestionItemUsuarios = new javax.swing.JMenuItem();
        jMenuGestionItemBitácora = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(this.titulo);
        setName("frmPrincipal"); // NOI18N
        setPreferredSize(new java.awt.Dimension(960, 540));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jMenuUsuario.setText("Usuario");

        jMenuUsuarioItemLogin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuUsuarioItemLogin.setText("Login");
        jMenuUsuarioItemLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsuarioItemLoginActionPerformed(evt);
            }
        });
        jMenuUsuario.add(jMenuUsuarioItemLogin);

        jMenuUsuarioItemLogout.setText("Logout");
        jMenuUsuarioItemLogout.setEnabled(false);
        jMenuUsuarioItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsuarioItemLogoutActionPerformed(evt);
            }
        });
        jMenuUsuario.add(jMenuUsuarioItemLogout);

        jMenuUsuarioItemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuUsuarioItemSalir.setText("Salir");
        jMenuUsuarioItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsuarioItemSalirActionPerformed(evt);
            }
        });
        jMenuUsuario.add(jMenuUsuarioItemSalir);

        jMenuBarPrincipal.add(jMenuUsuario);

        jMenuArchivo.setText("Archivo");
        jMenuArchivo.setEnabled(false);

        jMenuArchivoItemAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuArchivoItemAbrir.setText("Abrir");
        jMenuArchivoItemAbrir.setEnabled(false);
        jMenuArchivoItemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArchivoItemAbrirActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuArchivoItemAbrir);

        jMenuBarPrincipal.add(jMenuArchivo);

        jMenuGestion.setText("Gestión");
        jMenuGestion.setEnabled(false);

        jMenuGestionItemPerfiles.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuGestionItemPerfiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ke.png"))); // NOI18N
        jMenuGestionItemPerfiles.setText("Perfiles");
        jMenuGestionItemPerfiles.setEnabled(false);
        jMenuGestionItemPerfiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGestionItemPerfilesActionPerformed(evt);
            }
        });
        jMenuGestion.add(jMenuGestionItemPerfiles);

        jMenuGestionItemUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuGestionItemUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/us.png"))); // NOI18N
        jMenuGestionItemUsuarios.setText("Usuarios");
        jMenuGestionItemUsuarios.setEnabled(false);
        jMenuGestionItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGestionItemUsuariosActionPerformed(evt);
            }
        });
        jMenuGestion.add(jMenuGestionItemUsuarios);

        jMenuGestionItemBitácora.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuGestionItemBitácora.setText("Bitácora");
        jMenuGestionItemBitácora.setEnabled(false);
        jMenuGestionItemBitácora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGestionItemBitácoraActionPerformed(evt);
            }
        });
        jMenuGestion.add(jMenuGestionItemBitácora);

        jMenuBarPrincipal.add(jMenuGestion);

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

    private void jMenuUsuarioItemLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUsuarioItemLoginActionPerformed
        dlgIniciarSesion dlgSesion = new dlgIniciarSesion(this, true);
        dlgSesion.setVisible(true);
        
        usuario = dlgSesion.getUsuario();
        if( dlgSesion.isUsuarioValidado() == true ) {
//            JOptionPane.showMessageDialog(this, "Bienvenido, " + usuario.getNombreUsuario() + ".",
//                    "Información", JOptionPane.INFORMATION_MESSAGE);
            login();
        } else {
//            JOptionPane.showMessageDialog(this, "Usuario no validado.",
//                    "Información", JOptionPane.INFORMATION_MESSAGE);
            /* 
             * Código maqueta...
             * Desactivar las opciones que necesitan un usuario logueado
             */
        }
    }//GEN-LAST:event_jMenuUsuarioItemLoginActionPerformed

    private void jMenuUsuarioItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUsuarioItemLogoutActionPerformed
        // Mostrar diálogo de login...
        int answer = JOptionPane.showConfirmDialog(
            this, "¿Desea cerrar la sesión?", "Logout", JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        if ( answer == JOptionPane.YES_OPTION ) {
            logout();
        }
    }//GEN-LAST:event_jMenuUsuarioItemLogoutActionPerformed

    private void jMenuUsuarioItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUsuarioItemSalirActionPerformed
        cerrarAplicacion();
    }//GEN-LAST:event_jMenuUsuarioItemSalirActionPerformed

    private void jMenuArchivoItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArchivoItemAbrirActionPerformed
        JOptionPane.showMessageDialog(this, "Acción realizada:\n" +
                    "Archivo > Abrir archivo");
    }//GEN-LAST:event_jMenuArchivoItemAbrirActionPerformed

    private void jMenuGestionItemPerfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGestionItemPerfilesActionPerformed
        dlgPerfiles dlgAdminPerfiles = new dlgPerfiles(this, true);
        dlgAdminPerfiles.setVisible(true);
    }//GEN-LAST:event_jMenuGestionItemPerfilesActionPerformed

    private void jMenuGestionItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGestionItemUsuariosActionPerformed
        dlgUsuarios2 dlgAdminUsuarios = new dlgUsuarios2(this, true);
        dlgAdminUsuarios.setVisible(true);
    }//GEN-LAST:event_jMenuGestionItemUsuariosActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cerrarAplicacion();
    }//GEN-LAST:event_formWindowClosing

    private void jMenuGestionItemBitácoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGestionItemBitácoraActionPerformed
        dlgBitacora dlgAdminBitacora = new dlgBitacora(this, true);
        dlgAdminBitacora.setVisible(true);
    }//GEN-LAST:event_jMenuGestionItemBitácoraActionPerformed
    
    private void login() {
        /*
        * Código maqueta...
        * Verificar los PERMISOS asociados al USUARIO logueado
        * para activar las acciones permitidas
        */
        this.setTitle( usuario.getNombreUsuario() + "[" + usuario.getNomPerfil() + "]" + " @ " + titulo );
        
        // El menú USUARIO es el mismo para todos los usuarios
        jMenuUsuarioItemLogin.setEnabled(false);
        jMenuUsuarioItemLogout.setEnabled(true);
        jMenuUsuarioItemSalir.setEnabled(true);
        
        // El menu ARCHIVO es el mismo para todos los usuarios
        jMenuArchivo.setEnabled(true);
        jMenuArchivoItemAbrir.setEnabled(true);
        
        // El menu GESTION sólo está disponible para usuarios tipo ADMINISTRADOR
        if  ( usuario.getNomPerfil().equals(BO.Perfiles.Administrador.toString()) ) {
            jMenuGestion.setEnabled(true);
            jMenuGestionItemPerfiles.setEnabled(true);
            jMenuGestionItemUsuarios.setEnabled(true);
            jMenuGestionItemBitácora.setEnabled(true);
        } else {
            jMenuGestion.setEnabled(false);
            jMenuGestionItemPerfiles.setEnabled(false);
            jMenuGestionItemUsuarios.setEnabled(false);
            jMenuGestionItemBitácora.setEnabled(false);
        }
    }
    
    private void logout() {        
        /* 
         * Modificar el panel de frmPrincipal...?
         * Código maqueta...
         * Desactivar las opciones que necesitan un usuario logueado
         */
        this.setTitle(titulo);
        jMenuUsuarioItemLogin.setEnabled(true);
        jMenuUsuarioItemLogout.setEnabled(false);
        
        jMenuUsuarioItemSalir.setEnabled(true);
        
        jMenuArchivo.setEnabled(false);
        jMenuArchivoItemAbrir.setEnabled(false);
        
        jMenuGestion.setEnabled(false);
        jMenuGestionItemPerfiles.setEnabled(false);
        jMenuGestionItemUsuarios.setEnabled(false);
        jMenuGestionItemBitácora.setEnabled(false);
        
        usuario = new UsuarioBO();
        usuario.setIdUsuario(-1);
    }
    
    private void cerrarAplicacion() {
        if( usuario.getIdUsuario() != -1 ) { // -1 = Usuario no validado
            int eleccion = JOptionPane.showConfirmDialog(this, "Para cerrar la aplicación,\n" +
                "su sesión debe ser cerrada.\n\n¿Desea cerrar su sesión y la aplicación?",
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
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenuItem jMenuArchivoItemAbrir;
    private javax.swing.JMenuBar jMenuBarPrincipal;
    private javax.swing.JMenu jMenuGestion;
    private javax.swing.JMenuItem jMenuGestionItemBitácora;
    private javax.swing.JMenuItem jMenuGestionItemPerfiles;
    private javax.swing.JMenuItem jMenuGestionItemUsuarios;
    private javax.swing.JMenu jMenuUsuario;
    private javax.swing.JMenuItem jMenuUsuarioItemLogin;
    private javax.swing.JMenuItem jMenuUsuarioItemLogout;
    private javax.swing.JMenuItem jMenuUsuarioItemSalir;
    // End of variables declaration//GEN-END:variables
}
