package DAO;

import BO.PerfilesBO;
import BO.UsuariosBO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MANUEL
 */
public class UsuariosDAO {
    private UsuariosBO objP = new UsuariosBO();
    private PerfilesBO objPerf = new PerfilesBO();
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
   
   public ArrayList<PerfilesBO> consultarPerfiles() {
       ArrayList<PerfilesBO> perfilesList=new ArrayList<>();
       
        PreparedStatement statement=null;
        ResultSet result=null;

        PerfilesBO perfilBo;
        
        String consulta="Select idPerfil, nombrePerfil from perfilusuario;";

        try {
         if (conn!=null) {
          statement=conn.prepareStatement(consulta);    
          result=statement.executeQuery();

          while(result.next()==true){
           perfilBo=new PerfilesBO();
           perfilBo.setIdPerfil(result.getInt("idPerfil"));
           perfilBo.setNombrePerfil(result.getString("nombrePerfil"));

           perfilesList.add(perfilBo);
          }  
         }
        } catch (SQLException e) {
         System.out.println("Error en la consulta de perfiles: "+e.getMessage());
        }finally{
         try {
          conn.close();
          
         } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
         }
        }
        return perfilesList;
       }
}

