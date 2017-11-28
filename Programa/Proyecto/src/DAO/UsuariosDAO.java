package DAO;

import BO.PerfilesBO;
import BO.UsuariosBO;
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
public class UsuariosDAO {
    //private UsuariosBO usuario;
    //private PerfilesBO perfil;
    private Conexion con;

    public UsuariosDAO() {
        //usuario = new UsuariosBO();
        //perfil = new PerfilesBO();
        try {
            con = new Conexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int ValidarUsuario(String user, String passw) {
        int resultado = -1;
        try {
            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            CallableStatement proc = con.getConnection().prepareCall("CALL sp_ValidarUsuario(?,?,?);");
            //se cargan los parametros de entrada
            proc.setString("_NombreUsuario", user);//Tipo String
            proc.setString("_HashContra", passw);//Tipo String
            // parametros de salida
            proc.registerOutParameter("_idPerfiles", Types.VARCHAR);//Tipo String
            // Se ejecuta el procedimiento almacenado
            proc.execute();
            // devuelve el valor del parametro de salida del procedimiento
            resultado = proc.getInt("_idPerfiles");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return resultado;
    }

    public String BuscarPerfil(int id_Perf) {
        String resultado = "";
        try {
            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            CallableStatement proc = con.getConnection().prepareCall("CALL sp_BuscarPerfil(?,?);");
            //se cargan los parametros de entrada
            proc.setInt("_idPerfiles", id_Perf);//Tipo String
            // parametros de salida
            proc.registerOutParameter("_NombrePerfil", Types.VARCHAR);//Tipo String
            // Se ejecuta el procedimiento almacenado
            proc.execute();
            // devuelve el valor del parametro de salida del procedimiento
            resultado = proc.getString("_NombrePerfil");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return resultado;
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
    
    public ResultSet Lista(int idPerfil, String nombreUsu, String passw, int idPers, int opcion) throws SQLException {
        ResultSet result = null;
        
        try{
            String sql = "";
            if(opcion == 0) {
                sql = "SELECT * FROM usuarios;";
            }else {
                sql = "select * from usuarios where IdPerfiles="+ idPerfil+" or NombreUsuario Like '"+ nombreUsu +"%' or Hashcontra Like '"+ passw +"%' or Clave ="+ idPers+";";
            }
            PreparedStatement pa = con.getConnection().prepareStatement(sql);
            result = pa.executeQuery();
        }catch(SQLException e) {
            System.out.println(e);
        }
        return result;
    }
}
