/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author netom
 */
public class Direccion {
    private int Estado;
    private int ID;
    private String Localidad;
    private String CP;
    private String Calle;
    private String Numero;

    public Direccion(int Estado, String Localidad, String CP, String Calle, String Numero) {
        this.Estado = Estado;
        this.Localidad = Localidad;
        this.CP = CP;
        this.Calle = Calle;
        this.Numero = Numero;
    }
       public Direccion(int ID,int Estado, String Localidad, String CP, String Calle, String Numero) {
        this.ID=ID;
           this.Estado = Estado;
        this.Localidad = Localidad;
        this.CP = CP;
        this.Calle = Calle;
        this.Numero = Numero;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
       
    public Direccion(){
        this.ID=0;
        this.Estado = 0;
        this.Localidad = "'";
        this.CP = "";
        this.Calle = "";
        this.Numero = "";
    }
    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

 

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String Localidad) {
        this.Localidad = Localidad;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }
    
}
