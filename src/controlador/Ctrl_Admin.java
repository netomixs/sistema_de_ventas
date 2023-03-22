/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Administrador;
import modelo.Direccion;
import modelo.Persona;

/**
 *
 * @author netom
 */
public class Ctrl_Admin {

    public static final boolean AdminExistente() {
        boolean respuesta = false;

        try {
            Connection cn = Conexion.conectar();

            CallableStatement consulta = cn.prepareCall("{CALL Existe_Admin()}");
            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error ocuriro algo: " + e);
        }
        return respuesta;
    }

    public static final boolean Crear(Administrador admi) {
        boolean respuesta = false;
        Ctrl_Persona p = new Ctrl_Persona();
        try {
            admi.setPersona(p.Crear(admi.getPersona()));
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Crear_Admin(?,?)}");
            consulta.setString(1, admi.getUsuario());
            consulta.setString(2, admi.getPassword());

            consulta.execute();

            ResultSet rs = consulta.getResultSet();
            if (rs.next()) {
                admi.setID(Integer.parseInt(rs.getString(1)));

                return relacionPersonaAdmin(admi);
            }
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            eliminarPersona(admi);
            return false;
        }
        return false;
    }

    private static boolean relacionPersonaAdmin(Administrador admi) {
        boolean respuesta = false;
        Ctrl_Persona p = new Ctrl_Persona();
        try {

            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{ CALL Crear_RelacionAdminPersona(?,?)}");
            consulta.setInt(2, admi.getID());  
            consulta.setInt(1, admi.getPersona().getID());
            
          
            System.out.println(admi.getPersona().getID() + " " + admi.getID());

            if (consulta.executeUpdate() > 0) {

                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al crear relacion: " + e);
           eliminarPersona(admi);
        }
        return false;
    }

    public static void eliminarPersona(Administrador obj) {
        Connection cn = Conexion.conectar();
        try {
            CallableStatement consulta = cn.prepareCall("{CALL Eliminar_Admin(?,?,?)}");

            consulta.setInt(1, obj.getID());
            consulta.setInt(2, obj.getPersona().getID());
            consulta.setInt(3, obj.getPersona().getDireccion().getID());
            consulta.execute();

            cn.close();
        } catch (SQLException e) {

        }
    }
    public static boolean actualizarAdmin(Administrador admi){
        Ctrl_Persona p = new Ctrl_Persona();
        try {
            p.Actualizar(admi.getPersona());
            Connection cn = Conexion.conectar();
            
            CallableStatement consulta = cn.prepareCall("{CALL Actualizar_Admin(?,?,?)}");
             consulta.setInt(1, admi.getID());
            consulta.setString(2, admi.getUsuario());
            consulta.setString(3, admi.getPassword());

            consulta.execute();

            ResultSet rs = consulta.getResultSet();
   
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);

           return false;
        }
       return true;
    }
        public static Administrador getAdmin(Administrador admi) {
        boolean respuesta = false;
   
        try {

            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_Administradores_By_User_Password(?,?)}");
            consulta.setString(1, admi.getUsuario());
            consulta.setString(2, admi.getPassword());
            consulta.execute();
               ResultSet rs = consulta.getResultSet();
            if (rs.next()) {
                 Persona p=new Persona();
                 Direccion d=new Direccion();
                 p.setID(rs.getInt("ID_persona"));
                 p.setNombre(rs.getString("Nombre"));
                 p.setApellidoP(rs.getString("ApellidoP"));
                 p.setApellidoM(rs.getString("ApellidoM"));
                 p.setCurp(rs.getString("Curp"));
                 p.setNacimiento(rs.getDate("Nacimiento"));
                 d.setID(rs.getInt("ID_direccion"));
                 System.out.println("fhubdisjokm"+rs.getInt("ID_direccion"));
                 d.setCP(rs.getString("CP"));
                 d.setCalle(rs.getString("Calle"));
                 d.setEstado(rs.getInt("Estado"));
                 d.setLocalidad(rs.getString("Localidad"));
                 d.setNumero(rs.getString("Numero"));
                 admi.setID(rs.getInt("ID_Admin"));
                 p.setDireccion(d);
                 admi.setPersona(p);
                 admi.setUsuario(rs.getString("Usuario"));
             
                return admi;
            }
            
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            JOptionPane.showInputDialog(null, "Error de conexion");
        }
        return null;
    }
        
}
