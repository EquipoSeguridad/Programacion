package DAO;

import BO.PerfilesBO;
import BO.PersonalBO;
import BO.UsuarioBO;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author MANUEL
 */
public class UsuarioDAO {
    //private UsuarioBO usuario;
    //private PerfilesBO perfil;
    private Conexion con;
    private static UsuarioDAO _instance;
    
    public static UsuarioDAO getInstance() {
        if ( _instance == null ) {
            _instance = new UsuarioDAO();
        }
        return _instance;
    }

    private UsuarioDAO() {
        //usuario = new UsuarioBO();
        //perfil = new PerfilesBO();
        try {
            con = new Conexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ValidarUsuario(UsuarioBO usuario) {
        try {
            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            CallableStatement cStmt = con.getConnection().prepareCall("{CALL sp_ValidarUsuario(?,?,?,?,?)}");
            //se cargan los parametros de entrada
            cStmt.setString("_NombreUsuario", usuario.getNombreUsuario());//Tipo String
            cStmt.setString("_HashContra", usuario.getHashContra());//Tipo String
            // parametros de salida            
            cStmt.registerOutParameter("_idPerfiles", Types.INTEGER);//Tipo int
            cStmt.registerOutParameter("_idUsuarios", Types.INTEGER);//Tipo int
            cStmt.registerOutParameter("_TokenSesion", Types.VARCHAR);//Tipo String
            // Se ejecuta el procedimiento almacenado
            boolean hasResults = cStmt.execute();
            usuario.setIdPerfil(cStmt.getInt(3));
            usuario.setIdUsuario(cStmt.getInt(4));
            usuario.setTokenSesion(cStmt.getString(5));
            
            BuscarPerfil(usuario);
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void BuscarPerfil(UsuarioBO usuario) {
        try {
            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            CallableStatement proc = con.getConnection().prepareCall("CALL sp_BuscarPerfil(?,?);");
            //se cargan los parametros de entrada
            proc.setInt("_idPerfiles", usuario.getIdPerfil());//Tipo String
            // parametros de salida
            proc.registerOutParameter("_NombrePerfil", Types.VARCHAR);//Tipo String
            // Se ejecuta el procedimiento almacenado
            proc.execute();
            // devuelve el valor del parametro de salida del procedimiento
            usuario.setNomPerfil( proc.getString("_NombrePerfil") );
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<PerfilesBO> consultarPerfiles() {
        ArrayList<PerfilesBO> perfilesList = new ArrayList<>();

        PreparedStatement statement = null;
        ResultSet result = null;

        PerfilesBO perfilBo;

        String consulta = "Select IdPerfiles, NombrePerfil from perfiles;";

        try {
            if (con.getConnection() != null) {
                statement = con.getConnection().prepareStatement(consulta);
                result = statement.executeQuery();

                while (result.next() == true) {
                    perfilBo = new PerfilesBO();
                    perfilBo.setIdPerfil(result.getInt("IdPerfiles"));
                    perfilBo.setNombrePerfil(result.getString("NombrePerfil"));

                    perfilesList.add(perfilBo);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta de perfiles: " + e.getMessage());
        } finally {
            try {
                //con.getConnection().close();

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return perfilesList;
    }
    
    public ArrayList<PersonalBO> buscarPersonal(String Nombre) {
        ArrayList<PersonalBO> personalList = new ArrayList<>();

        PreparedStatement statement = null;
        ResultSet result = null;

        PersonalBO personalBo;
        String consulta = "";

        if(Nombre.trim().equals("")) {
            consulta = "select Clave, Concat(Nombre, ' ', ApellidoPaterno, ' ', ApellidoMaterno) As NombreC from personal ORDER BY NombreC ASC;";
        }else {
            consulta = "select Clave, Concat(Nombre, ' ', ApellidoPaterno, ' ', ApellidoMaterno) As NombreC from personal having NombreC Like '"+Nombre+"%' ORDER BY NombreC ASC;";
        }
        try {
            if (con.getConnection() != null) {
                statement = con.getConnection().prepareStatement(consulta);
                result = statement.executeQuery();

                while (result.next() == true) {
                    personalBo = new PersonalBO();
                    personalBo.setClave(result.getString("Clave"));
                    personalBo.setNombre(result.getString("NombreC"));

                    personalList.add(personalBo);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta de personal: " + e.getMessage());
        } finally {
            try {
                //con.getConnection().close();

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return personalList;
    }
    
    public ResultSet Lista(int idPerfil, String nombreUsu, String passw, int idPers, int opcion) throws SQLException {
        ResultSet result = null;
        
        try{
            String sql = "";
            if(opcion == 0) {
                sql = "SELECT IdUsuarios As ID, NombreUsuario AS Usuario,  Hashcontra As Contraseña, IdPerfiles As Perfil, Clave As Empleado FROM usuarios;";
            }else {
                sql = "SELECT IdUsuarios As ID, NombreUsuario AS Usuario,  Hashcontra As Contraseña, IdPerfiles As Perfil, Clave As Empleado FROM usuarios where IdPerfiles="+ idPerfil+" or NombreUsuario Like '"+ nombreUsu +"%' or Clave="+ idPers+";";
            }
            PreparedStatement pa = con.getConnection().prepareStatement(sql);
            result = pa.executeQuery();
        }catch(SQLException e) {
            System.out.println(e);
        }
        return result;
    }
    
    public boolean AgregarUsuario(UsuarioBO objUBO)
   {
       boolean resultado = false;
       try {            
            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            CallableStatement proc = con.getConnection().prepareCall("CALL sp_AgregarUsuario(?,?,?,?);");
            //se cargan los parametros de entrada
            proc.setInt("_IdPerfiles", objUBO.getIdPerfil());//Tipo String
            proc.setString("_NombreUsuario", objUBO.getNombreUsuario());//Tipo String
            proc.setString("_HashContra", objUBO.getHashContra());//Tipo String
            proc.setString("_Clave", objUBO.getClaveEmp());//Tipo String
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
    
    public boolean Modificarusuarios(UsuarioBO obUPBO)
   {
       boolean resultado = false;
       try {            
            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            CallableStatement proc = con.getConnection().prepareCall("CALL sp_ModificarUsuario(?,?,?,?);");
            //se cargan los parametros de entrada
            proc.setInt("_IdUsuarios", obUPBO.getIdUsuario());
            proc.setInt("_IdPerfiles", obUPBO.getIdPerfil());//Tipo String
            proc.setString("_NombreUsuario", obUPBO.getNombreUsuario());//Tipo String
            //proc.setString("_HashContra", obUPBO.getHashContra());//Tipo String
            proc.setString("_Clave", obUPBO.getClaveEmp());//Tipo String
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
    
    public boolean EliminarUsuario(UsuarioBO objUBO)
   {
       boolean resultado = false;
       try {            
            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            CallableStatement proc = con.getConnection().prepareCall("CALL sp_EliminarUsuario(?);");
            //se cargan los parametros de entrada
            proc.setInt("_IdUsuarios", objUBO.getIdUsuario());
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
    
   public String buscarEmp(int claveEmp) {
        String resultado = "";
        try {
            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            CallableStatement proc = con.getConnection().prepareCall("CALL sp_buscarNombreEmp(?,?);");
            //se cargan los parametros de entrada
            proc.setInt("_Clave", claveEmp);//Tipo String
            // parametros de salida
            proc.registerOutParameter("_Nombre", Types.VARCHAR);//Tipo String
            // Se ejecuta el procedimiento almacenado
            proc.execute();
            // devuelve el valor del parametro de salida del procedimiento
            resultado = proc.getString("_Nombre");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return resultado;
    }
}
