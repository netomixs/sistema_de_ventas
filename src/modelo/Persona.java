/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 *Modelo de datos de Persona
 * @author netom
 */
public class Persona {
    private int ID;
    private String Nombre;
    private String ApellidoP;
    private String ApellidoM;
    private Date Nacimiento;
    private String Curp;
    private Date FechaRegistro;
    private Direccion Direccion;

    /**
     *
     */
    public Persona() {

        this.Nombre = "";
        this.ApellidoP = "";
        this.ApellidoM = "";
        this.Nacimiento = new Date();
        this.Curp = Curp;
        this.Direccion = new Direccion();
    }

    /**
     *
     * @param Nombre
     * @param ApellidoP
     * @param ApellidoM
     * @param Nacimiento
     * @param Curp
     * @param FechaRegistro
     * @param Direccion
     */
    public Persona(String Nombre, String ApellidoP, String ApellidoM, Date Nacimiento, String Curp,Date FechaRegistro, Direccion Direccion) {

        this.Nombre = Nombre;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.Nacimiento = Nacimiento;
        this.Curp = Curp;
        this.Direccion = Direccion;
        this.FechaRegistro=FechaRegistro;
    }

    /**
     *
     * @param id
     * @param Nombre
     * @param ApellidoP
     * @param ApellidoM
     * @param Nacimiento
     * @param Curp
     * @param FechaRegistro
     * @param Direccion
     */
    public Persona(int id,String Nombre, String ApellidoP, String ApellidoM, Date Nacimiento, String Curp,Date FechaRegistro, Direccion Direccion) {
        this.ID=id;
        this.Nombre = Nombre;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.Nacimiento = Nacimiento;
        this.Curp = Curp;
        this.Direccion = Direccion;
        this.FechaRegistro=FechaRegistro;
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
    public Date getFechaRegistro() {
        return FechaRegistro;
    }

    /**
     *
     * @param FechaRegistro
     */
    public void setFechaRegistro(Date FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     *
     * @param Nombre
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     *
     * @return
     */
    public String getApellidoP() {
        return ApellidoP;
    }

    /**
     *
     * @param ApellidoP
     */
    public void setApellidoP(String ApellidoP) {
        this.ApellidoP = ApellidoP;
    }

    /**
     *
     * @return
     */
    public String getApellidoM() {
        return ApellidoM;
    }

    /**
     *
     * @param ApellidoM
     */
    public void setApellidoM(String ApellidoM) {
        this.ApellidoM = ApellidoM;
    }

    /**
     *
     * @return
     */
    public Date getNacimiento() {
        return Nacimiento;
    }

    /**
     *
     * @param Nacimiento
     */
    public void setNacimiento(Date Nacimiento) {
        this.Nacimiento = Nacimiento;
    }

    /**
     *
     * @return
     */
    public String getCurp() {
        return Curp;
    }

    /**
     *
     * @param Curp
     */
    public void setCurp(String Curp) {
        this.Curp = Curp;
    }

    /**
     *
     * @return
     */
    public Direccion getDireccion() {
        return Direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(Direccion direccion) {
        this.Direccion = direccion;
    }

    /**
     *
     * @return
     */
    public String getApelldios(){
    return ApellidoP+" "+ApellidoM;
}

}
