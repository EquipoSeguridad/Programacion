package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MANUEL
 */
public class Conexion {
    static String usuario = "root";
    static String contra = "";
    static String bd = "erp";
    static String url = "jdbc:mysql://localhost/" + bd;
    static Connection con = null;
    
    public Conexion () throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, contra);
            if(con == null) {
                System.out.println("Error en la conexión a la base de datos.");
            }
        }catch(ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection() {
        return con;
    }
    
    public void CerrarConexion() throws SQLException {
        con.close();
    }
}
