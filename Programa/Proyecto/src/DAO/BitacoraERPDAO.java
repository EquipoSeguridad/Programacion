package DAO;

import BO.BitacoraERPBO;
import com.mysql.jdbc.ResultSetImpl;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author md
 */
public class BitacoraERPDAO {
    public static void agregarBitacora( BitacoraERPBO bitacora ) {
        try {
            Conexion con = new Conexion();
            CallableStatement cStmt = con.getConnection().prepareCall("{CALL sp_********}");
            
            cStmt.setString("_param1", bitacora.getAccion());//Tipo String
            cStmt.setInt("_param2", bitacora.getIdUsuarios());//Tipo int
            
            cStmt.registerOutParameter("_param3", Types.INTEGER);//Tipo int
            cStmt.registerOutParameter("_param4", Types.VARCHAR);//Tipo int
            
            boolean hasResults = cStmt.execute();
            bitacora.setIdBitacoraERP(cStmt.getInt(3));
            bitacora.setAccion(cStmt.getString(4));
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    public static void eliminarBitacora( BitacoraERPBO bitacora ) {
        //TODO implementar
    }
    
    public static void modificarBitacora( BitacoraERPBO bitacora ) {
        //TODO implementar
    }
    
    public static ResultSet consultarBitacora() throws SQLException {
        Conexion con = new Conexion();

        String sql = "SELECT b.IdBitácoraERP AS b_IdBitácoraERP, " + 
            "b.IdErroresERP AS b_IdErroresERP, b.IdPerfiles AS b_IdPerfiles, " +
            "b.IdUsuarios AS b_IdUsuarios, CAST(b.Timestamp AS DATE) as b_Date, " + 
            "CAST(b.Timestamp AS TIME) AS b_Time, b.Accion AS b_Accion, " +
            "e.IdErroresERP AS e_IdErroresERP, e.Timestamp as e_Timestamp, " +
            "e.Descripcion as e_Descripcion " +
            "FROM bitacoraerp b " +
            "LEFT JOIN erroreserp e " +
            "ON b.IdErroresERP = e.IdErroresERP;";

        PreparedStatement pa = con.getConnection().prepareStatement(sql);
        /*ResultSet result = */ return pa.executeQuery();
        
        //return result;
    }
}
