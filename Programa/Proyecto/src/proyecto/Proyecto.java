package proyecto;

import DAO.PerfilesDAO;
import DAO.UsuariosDAO;

/**
 *
 * @author MANUEL
 */
public class Proyecto {

    public static void main(String[] args) {
        // TODO code application logic here
        UsuariosDAO userDAO;
        userDAO = new UsuariosDAO();
        PerfilesDAO perfDAO = new PerfilesDAO();
        
        int respu = userDAO.ValidarUsuario("Mau97", "12345");
        System.out.println(respu);
        
        String resp = userDAO.BuscarPerfil(1);
        System.out.println(resp);
        
        boolean respb = perfDAO.AgregarPerfil("Maestro");
        System.out.println("" + respb);
    }
    
}
