package proyecto;

import DAO.PerfilesDAO;
import DAO.UsuariosDAO;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author MANUEL
 */
public class Proyecto {

    public static void main(String[] args) {
        // TODO code application logic here
        UsuariosDAO userDAO;
        userDAO = new UsuariosDAO();
        /*PerfilesDAO perfDAO = new PerfilesDAO();
        
        int respu = userDAO.ValidarUsuario("Mau97", "12345");
        System.out.println(respu);
        
        String resp = userDAO.BuscarPerfil(1);
        System.out.println(resp);
        
        boolean respb = perfDAO.AgregarPerfil("Maestro");
        System.out.println("" + respb);*/
        
        
        /*String textoSinEncriptar="sergio"; 
        String textoEncriptadoConSHA=DigestUtils.sha1Hex(textoSinEncriptar); 
        System.out.println("Texto Encriptado con SHA: "+textoEncriptadoConSHA);*/
        System.out.println(userDAO.encriptarContrasena("Sergio"));
    }
    
}
