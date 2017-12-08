package proyecto;

import BO.UsuarioBO;
import DAO.PerfilesDAO;
import DAO.UsuarioDAO;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author MANUEL
 */
public class Proyecto {

    public static void main(String[] args) {
        // TODO code application logic here
        UsuarioBO userDAO;
        userDAO = new UsuarioBO();
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
        System.out.println(util.SHA1.cifrarContra("AlbertoEmmanuelCamposUC79"));
        System.out.println("contra: asd, hash SHA1:" + util.SHA1.cifrarContra("asd"));
        System.out.println("contra: asdasd, hash SHA1:" + util.SHA1.cifrarContra("asdasd"));
        System.out.println("contra: qwe, hash SHA1:" + util.SHA1.cifrarContra("qwe"));
        System.out.println("contra: qweqwe, hash SHA1:" + util.SHA1.cifrarContra("qweqwe"));
    }
    
}
