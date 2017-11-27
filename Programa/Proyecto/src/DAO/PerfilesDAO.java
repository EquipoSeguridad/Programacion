package DAO;

import BO.PerfilesBO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author MANUEL
 */
public class PerfilesDAO {
    private PerfilesBO objP = new PerfilesBO();
    private Conexion con;
    private Connection conn;
    
    public PerfilesDAO() {
        try{
            con = new Conexion();
            conn = con.getConnection();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet Lista(String nombrePerf, int opcion) throws SQLException {
        ResultSet result = null;
        
        try{
            String sql = "";
            if(opcion == 0) {
                sql = "Select * from perfilusuario";
            }else {
                sql = "Select * from perfilusuario where nombrePerfil='"+nombrePerf+"';";
            }
           
           PreparedStatement pa = con.getConnection().prepareStatement(sql);
           result = pa.executeQuery();
           return result;
        }catch(SQLException e) {
            System.out.println(e);
            return result;
        }
    }
    
   public boolean AgregarPerfil(String perfil)
   {
       boolean resultado = false;
       try {            
            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            CallableStatement proc = conn.prepareCall("CALL sp_AgregarPerfil(?);");
            //se cargan los parametros de entrada
            proc.setString("nombreP", perfil);//Tipo String
            // Se ejecuta el procedimiento almacenado
            proc.execute();            
            // devuelve el valor del parametro de salida del procedimiento
            resultado = true;
        } 
       catch (Exception e) {   
           resultado = false;
            System.out.println(e);
       }
       return resultado;
   }
}
