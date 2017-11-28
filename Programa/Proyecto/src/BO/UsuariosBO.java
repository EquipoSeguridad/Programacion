package BO;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author MANUEL
 */
public class UsuariosBO {
    private int id_user;
    private String Usuario;
    private String passw;
    private String claveEmp;

    public String getClaveEmp() {
        return claveEmp;
    }

    public void setClaveEmp(String claveEmp) {
        this.claveEmp = claveEmp;
    }
    private int tipoUser;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
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
}
