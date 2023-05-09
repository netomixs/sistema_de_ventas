/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 *
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

    public Persona() {

        this.Nombre = "";
        this.ApellidoP = "";
        this.ApellidoM = "";
        this.Nacimiento = new Date();
        this.Curp = Curp;
        this.Direccion = new Direccion();
    }

    public Persona(String Nombre, String ApellidoP, String ApellidoM, Date Nacimiento, String Curp,Date FechaRegistro, Direccion Direccion) {

        this.Nombre = Nombre;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.Nacimiento = Nacimiento;
        this.Curp = Curp;
        this.Direccion = Direccion;
        this.FechaRegistro=FechaRegistro;
    }
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
        
  public Date getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(Date FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoP() {
        return ApellidoP;
    }

    public void setApellidoP(String ApellidoP) {
        this.ApellidoP = ApellidoP;
    }

    public String getApellidoM() {
        return ApellidoM;
    }

    public void setApellidoM(String ApellidoM) {
        this.ApellidoM = ApellidoM;
    }

    public Date getNacimiento() {
        return Nacimiento;
    }

    public void setNacimiento(Date Nacimiento) {
        this.Nacimiento = Nacimiento;
    }

    public String getCurp() {
        return Curp;
    }

    public void setCurp(String Curp) {
        this.Curp = Curp;
    }

    public Direccion getDireccion() {
        return Direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.Direccion = direccion;
    }
public String getApelldios(){
    return ApellidoP+" "+ApellidoM;
}

}
