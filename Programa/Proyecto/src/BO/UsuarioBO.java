package BO;

/**
 *
 * @author MANUEL
 */
public class UsuarioBO {
    private int idUsuario;
    private String nombreUsuario;
    private String hashContra;
    private String claveEmp;
    private int idPerfil;
    private String NomPerfil;
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
        this.hashContra = hashContra;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int tipoUser) {
        this.idPerfil = tipoUser;
    }
    
    public String getTokenSesion() {
        return tokenSesion;
    }
    
    public void setTokenSesion(String tokenSesion) {
        this.tokenSesion = tokenSesion;
    }
    
    public String getNomPerfil() {
        return NomPerfil;
    }
    
    public void setNomPerfil(String NomPerfil) {
        this.NomPerfil = NomPerfil;
    }
}
