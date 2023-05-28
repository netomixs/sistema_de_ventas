/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *Modelo de datos de administrador
 * @author netom
 */
public class Administrador {
    private int ID;
    private String Usuario;
    private String Password;
    private Persona Persona;

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
    public Persona getPersona() {
        return Persona;
    }

    /**
     *
     * @param Persona
     */
    public void setPersona(Persona Persona) {
        this.Persona = Persona;
    }
    
    /**
     *
     * @return
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     *
     * @param Usuario
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return Password;
    }
    
    /**
     *
     * @param Password
     */
    public void setPassword(String Password) {
 
        this.Password =Password;
    }

    /**
     *
     * @param Usuario
     * @param Password
     * @param persona
     */
    public Administrador(String Usuario, String Password,Persona persona) {
        this.Usuario = Usuario;
        this.Password = Password;
        this.Persona=persona;
    }

    /**
     *
     */
    public Administrador() {
        this.Usuario = "";
        this.Password = "";
          this.Persona=new Persona();
    }



}
