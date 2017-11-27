package DAO;

import BO.UsuariosBO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author MANUEL
 */
public class UsuariosDAO {
    private UsuariosBO objP = new UsuariosBO();
    private Conexion con;
    private Connection conn;
    
    public UsuariosDAO() {
        try{
            con = new Conexion();
            conn = con.getConnection();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public int ValidarUsuario(String user, String passw)
   {
       int resultado = -1;
       try {            
            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            CallableStatement proc = conn.prepareCall("CALL sp_ValidarUsuario(?,?,?);");
            //se cargan los parametros de entrada
            proc.setString("userName", user);//Tipo String
            proc.setString("passw", passw);//Tipo String
            // parametros de salida
            proc.registerOutParameter("resp", Types.VARCHAR);//Tipo String
            // Se ejecuta el procedimiento almacenado
            proc.execute();            
            // devuelve el valor del parametro de salida del procedimiento
            resultado = proc.getInt("resp");
        } 
       catch (Exception e) {                  
            System.out.println(e);
       }
       return resultado;
   }
    
   public String BuscarPerfil(int id_Perf) {
       String resultado = "";
       try {            
            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            CallableStatement proc = conn.prepareCall("CALL sp_BuscarPerfil(?,?);");
            //se cargan los parametros de entrada
            proc.setInt("id_Perfil", id_Perf);//Tipo String
            // parametros de salida
            proc.registerOutParameter("nombreP", Types.VARCHAR);//Tipo String
            // Se ejecuta el procedimiento almacenado
            proc.execute();            
            // devuelve el valor del parametro de salida del procedimiento
            resultado = proc.getString("nombreP");
        } 
       catch (Exception e) {                  
            System.out.println(e);
       }
       return resultado;
   }
}
