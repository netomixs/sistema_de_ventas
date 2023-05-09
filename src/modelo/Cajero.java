/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author netom
 */
public class Cajero {

    private int ID;
    private String Clave;
    private Persona Persona;

    public Cajero(int ID, String Clave, Persona persona) {
        this.ID = ID;
        this.Clave = Clave;
        this.Persona = persona;
    }

    public Cajero() {
        this.ID = 0;
        this.Clave = "";
        this.Persona = new Persona();
    }

    public Persona getPersona() {
        return Persona;
    }

    public void setPersona(Persona persona) {
        this.Persona = persona;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

}
