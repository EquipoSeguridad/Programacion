package launcher;

import Forms.frmPrincipal;

/**
 * Esta clase se encarga de iniciar la aplicación y todos los objetos necesarios
 * para que funcione (conexiones a la BD, etc)
 * @author md
 */
public class Launcher {
    public static void main(String args[]) {
        //Nimbus L&F
        try {
            for ( javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels() ) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch ( ClassNotFoundException | InstantiationException |
                 IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex ) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        // Crear y mostrar la forma
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }
}
