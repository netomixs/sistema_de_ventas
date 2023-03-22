

package modelo;

import java.util.Date;

public class Lote {
    private int ID;
    private Date FechaLLegada;
    private Date FechaRetiro;
    private String Serie;

    public Lote(int ID, Date FechaLLegada, Date FechaRetiro, String Serie) {
        this.ID = ID;
        this.FechaLLegada = FechaLLegada;
        this.FechaRetiro = FechaRetiro;
        this.Serie = Serie;
    }
    public Lote() {
        this.ID = 0;
        this.FechaLLegada = new Date();
        this.FechaRetiro = new Date();
        this.Serie = "";
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getFechaLLegada() {
        return FechaLLegada;
    }

    public void setFechaLLegada(Date FechaLLegada) {
        this.FechaLLegada = FechaLLegada;
    }

    public Date getFechaRetiro() {
        return FechaRetiro;
    }

    public void setFechaRetiro(Date FechaRetiro) {
        this.FechaRetiro = FechaRetiro;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String Serie) {
        this.Serie = Serie;
    }
    
}
