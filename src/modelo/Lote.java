

package modelo;

import java.util.Date;

/**
 *Modelo de datos de lote
 * @author netom
 */
public class Lote {
    private int ID;
    private Date FechaLLegada;
    private Date FechaRetiro;
    private String Serie;

    /**
     *
     * @param ID
     * @param FechaLLegada
     * @param FechaRetiro
     * @param Serie
     */
    public Lote(int ID, Date FechaLLegada, Date FechaRetiro, String Serie) {
        this.ID = ID;
        this.FechaLLegada = FechaLLegada;
        this.FechaRetiro = FechaRetiro;
        this.Serie = Serie;
    }

    /**
     *
     */
    public Lote() {
        this.ID = 0;
        this.FechaLLegada = new Date();
        this.FechaRetiro = new Date();
        this.Serie = "";
    }

    /**
     *
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     *
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     *
     * @return
     */
    public Date getFechaLLegada() {
        return FechaLLegada;
    }

    /**
     *
     * @param FechaLLegada
     */
    public void setFechaLLegada(Date FechaLLegada) {
        this.FechaLLegada = FechaLLegada;
    }

    /**
     *
     * @return
     */
    public Date getFechaRetiro() {
        return FechaRetiro;
    }

    /**
     *
     * @param FechaRetiro
     */
    public void setFechaRetiro(Date FechaRetiro) {
        this.FechaRetiro = FechaRetiro;
    }

    /**
     *
     * @return
     */
    public String getSerie() {
        return Serie;
    }

    /**
     *
     * @param Serie
     */
    public void setSerie(String Serie) {
        this.Serie = Serie;
    }
    
}
