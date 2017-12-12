package BO;

import java.util.Date;

/**
 *
 * @author md
 */
public class BitacoraERPBO {
    private int IdBitacoraERP;
    private int IdUsuarios;
    private Date TimeStamp;
    private String Accion;
    private int error_Id;
    private Date error_TimeStamp;
    private String error_Desc;

    /**
     * @return the IdBitacoraERP
     */
    public int getIdBitacoraERP() {
        return IdBitacoraERP;
    }

    /**
     * @param IdBitacoraERP the IdBitacoraERP to set
     */
    public void setIdBitacoraERP(int IdBitacoraERP) {
        this.IdBitacoraERP = IdBitacoraERP;
    }

    /**
     * @return the IdUsuarios
     */
    public int getIdUsuarios() {
        return IdUsuarios;
    }

    /**
     * @param IdUsuarios the IdUsuarios to set
     */
    public void setIdUsuarios(int IdUsuarios) {
        this.IdUsuarios = IdUsuarios;
    }

    /**
     * @return the TimeStamp
     */
    public Date getTimeStamp() {
        return TimeStamp;
    }

    /**
     * @param TimeStamp the TimeStamp to set
     */
    public void setTimeStamp(Date TimeStamp) {
        this.TimeStamp = TimeStamp;
    }

    /**
     * @return the Accion
     */
    public String getAccion() {
        return Accion;
    }

    /**
     * @param Accion the Accion to set
     */
    public void setAccion(String Accion) {
        this.Accion = Accion;
    }

    /**
     * @return the error_Id
     */
    public int getError_Id() {
        return error_Id;
    }

    /**
     * @param error_Id the error_Id to set
     */
    public void setError_Id(int error_Id) {
        this.error_Id = error_Id;
    }

    /**
     * @return the error_TimeStamp
     */
    public Date getError_TimeStamp() {
        return error_TimeStamp;
    }

    /**
     * @param error_TimeStamp the error_TimeStamp to set
     */
    public void setError_TimeStamp(Date error_TimeStamp) {
        this.error_TimeStamp = error_TimeStamp;
    }

    /**
     * @return the error_Desc
     */
    public String getError_Desc() {
        return error_Desc;
    }

    /**
     * @param error_Desc the error_Desc to set
     */
    public void setError_Desc(String error_Desc) {
        this.error_Desc = error_Desc;
    }
}
