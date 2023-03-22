/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author netom
 */
public class Administrador {
    private int ID;
    private String Usuario;
    private String Password;
    private Persona Persona;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Persona getPersona() {
        return Persona;
    }

    public void setPersona(Persona Persona) {
        this.Persona = Persona;
    }
    
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }
    
    public void setPassword(String Password) {
 
        this.Password =Password;
    }

    public Administrador(String Usuario, String Password,Persona persona) {
        this.Usuario = Usuario;
        this.Password = Password;
        this.Persona=persona;
    }
        public Administrador() {
        this.Usuario = "";
        this.Password = "";
          this.Persona=new Persona();
    }



}
