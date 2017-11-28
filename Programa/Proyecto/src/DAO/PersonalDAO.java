/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MANUEL
 */
public class PersonalDAO {
    private Conexion con;

    public PersonalDAO() {
        //usuario = new UsuariosBO();
        //perfil = new PerfilesBO();
        try {
            con = new Conexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet Lista(String nombre, int Opcion) throws SQLException {
        ResultSet result = null;
        
        try{
            String sql = "";
            if(Opcion == 0) {
                sql = "select Clave, Nombre, Concat(ApellidoPaterno, ' ', ApellidoMaterno) As 'Apellidos' , RFC, Puesto, Departamento from personal;";
            }else {
                sql = "select Clave, Nombre, Concat(ApellidoPaterno, ' ', ApellidoMaterno) As 'Apellidos' , RFC, Puesto, Departamento from personal where Nombre Like'"+nombre+"%';";
            }
            PreparedStatement pa = con.getConnection().prepareStatement(sql);
            result = pa.executeQuery();
        }catch(SQLException e) {
            System.out.println(e);
        }
        return result;
    }
}
