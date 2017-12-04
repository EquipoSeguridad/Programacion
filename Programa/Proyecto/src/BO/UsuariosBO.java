package BO;

import org.apache.commons.codec.digest.DigestUtils;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author MANUEL
 */
public class UsuariosBO {
    private int idUsuario;
    private String nombreUsuario;
    private String hashContra;
    private String claveEmp;
    private int tipoUser;
    private String tokenSesion; 

    public String getClaveEmp() {
        return claveEmp;
    }

    public void setClaveEmp(String claveEmp) {
        this.claveEmp = claveEmp;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getHashContra() {
        return hashContra;
    }

    public void setHashContra(String hashContra) {
        this.hashContra = DigestUtils.sha1Hex(hashContra);
    }

    public int getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(int tipoUser) {
        this.tipoUser = tipoUser;
    }
    
    public String encriptarContrasena(String pasw) {
        String passwSHA=DigestUtils.sha1Hex(pasw);
        return passwSHA;
    }    
    
    public String getContraCifrada() {
        return DigestUtils.sha1Hex(hashContra);
    }
    
    public String getTokenSesion() {
        return tokenSesion;
    }
    
    public void setTokenSesion(String tokenSesion) {
        this.tokenSesion = tokenSesion;
    }
}
