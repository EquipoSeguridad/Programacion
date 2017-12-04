package DAO;

import BO.PerfilesBO;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MANUEL
 */
public class PerfilesDAO {
    //private PerfilesBO perfil;
    private Conexion con;
    
    public PerfilesDAO() {
        //perfil = new PerfilesBO();
        try{
            con = new Conexion();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet Lista(String nombrePerf, int opcion) throws SQLException {
        ResultSet result = null;
        
        try{
            String sql = "";
            if(opcion == 0) {
                sql = "Select IdPerfiles As ID, NombrePerfil AS Perfil from perfiles;";
            }else {
                sql = "Select IdPerfiles As ID, NombrePerfil AS Perfil from perfiles where NombrePerfil LIKE '"+nombrePerf+"%';";
            }
            PreparedStatement pa = con.getConnection().prepareStatement(sql);
            result = pa.executeQuery();
        }catch(SQLException e) {
            System.out.println(e);
        }
        return result;
    }
    
   public boolean AgregarPerfil(PerfilesBO objPBO)
   {
       boolean resultado = false;
       try {            
            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            CallableStatement proc = con.getConnection().prepareCall("CALL sp_AgregarPerfil(?);");
            //se cargan los parametros de entrada
            proc.setString("_NombrePerfil", objPBO.getNombrePerfil());//Tipo String
            // Se ejecuta el procedimiento almacenado
            proc.execute();            
            // devuelve el valor del parametro de salida del procedimiento
            resultado = true;
        } 
       catch (SQLException e) {   
           resultado = false;
           System.out.println(e);
       }
       return resultado;
   }
   
   public boolean ModificarPerfil(PerfilesBO objPBO)
   {
       boolean resultado = false;
       try {            
            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            CallableStatement proc = con.getConnection().prepareCall("CALL sp_ModificarPerfil(?,?);");
            //se cargan los parametros de entrada
            proc.setInt("_idPerfiles", objPBO.getIdPerfil());
            proc.setString("_NombrePerfil", objPBO.getNombrePerfil());//Tipo String
            // Se ejecuta el procedimiento almacenado
            proc.execute();            
            // devuelve el valor del parametro de salida del procedimiento
            resultado = true;
        } 
       catch (SQLException e) {   
           resultado = false;
            System.out.println(e);
       }
       return resultado;
   }
   
   public boolean EliminarPerfil(PerfilesBO objPBO)
   {
       boolean resultado = false;
       try {            
            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            CallableStatement proc = con.getConnection().prepareCall("CALL sp_EliminarPerfil(?);");
            //se cargan los parametros de entrada
            proc.setInt("_idPerfiles", objPBO.getIdPerfil());
            // Se ejecuta el procedimiento almacenado
            proc.execute();            
            // devuelve el valor del parametro de salida del procedimiento
            resultado = true;
        } 
       catch (SQLException e) {   
           resultado = false;
            System.out.println(e);
       }
       return resultado;
   }
}
