/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.sun.imageio.spi.RAFImageInputStreamSpi;
import conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Administrador;
import modelo.Direccion;
import modelo.Persona;

/**
 *
 * @author netom
 */
public class Ctrl_Persona {
    
 public Persona Crear(Persona objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            objeto.getDireccion().setID(crearDireccion(objeto.getDireccion()));
            CallableStatement consulta = cn.prepareCall("{ CALL Crear_Persona(?,?,?,?,?,?,?)}");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellidoP());
                consulta.setString(3, objeto.getApellidoM());
                consulta.setDate(4,new java.sql.Date(objeto.getNacimiento().getTime()) );
                consulta.setInt(5, objeto.getDireccion().getID());
                consulta.setString(6, objeto.getCurp());
                consulta.setDate(7, new java.sql.Date(objeto.getFechaRegistro().getTime()) );
             consulta.execute();
                 ResultSet rs=consulta.getResultSet();
                  while(rs.next()){
                      objeto.setID(Integer.parseInt(rs.getString(1)));
                     return objeto;
                  }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar usuario: " + e);
            eliminarPersona(objeto);
        }
        return new Persona();
    }
  public void Actualizar(Persona objeto) {
        System.out.println("Direccion en personas"+ objeto.getDireccion().getID());
        Connection cn = Conexion.conectar();
        try {

           ActualizarDireccion(objeto.getDireccion());
            CallableStatement consulta = cn.prepareCall("{ CALL Actualizar_Personas(?,?,?,?,?,?)}");
            consulta.setInt(1, objeto.getID());
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellidoP());
                consulta.setString(4, objeto.getApellidoM());
                consulta.setDate(5,new java.sql.Date(objeto.getNacimiento().getTime()) );    
                consulta.setString(6, objeto.getCurp());
            System.out.println("Actulizar direccion");
             consulta.execute();
 
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar usuario: " + e);
         
        }
    
    }
 public int crearDireccion(Direccion obj){
     Connection cn = Conexion.conectar();
        try {
            CallableStatement consulta = cn.prepareCall("{ CALL Crear_Direccion(?, ?, ?,?, ?)}");
            
            consulta.setInt(1, obj.getEstado());
                consulta.setString(2, obj.getLocalidad());
                consulta.setString(3, obj.getCP());
                consulta.setString(4, obj.getCalle());
                 consulta.setString(5, obj.getNumero());
                 consulta.execute();
                 ResultSet rs=consulta.getResultSet();
                  while(rs.next()){
                     return Integer.parseInt(rs.getString(1));
                  }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar usuario: " + e);
            
        }
     return 0;
 
 }
  public void ActualizarDireccion(Direccion obj){
     Connection cn = Conexion.conectar();
        try {
            CallableStatement consulta = cn.prepareCall("{ CALL Actualizar_Direccion(?,?, ?, ?,?, ?)}");
            System.out.println("D"+obj.getID());
             consulta.setInt(1, obj.getID());
            consulta.setInt(2, obj.getEstado());
                consulta.setString(3, obj.getLocalidad());
                consulta.setString(4, obj.getCP());
                consulta.setString(5, obj.getCalle());
                 consulta.setString(6, obj.getNumero());
                 consulta.execute();


            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar usuario: " + e);
            
        }
  
 
 }
    public static void eliminarPersona(Persona obj){
      Connection cn = Conexion.conectar();
        try {
            CallableStatement consulta = cn.prepareCall("{ CALL Eliminar_Persona(?, ?)}");
            
            consulta.setInt(1, obj.getID());
             consulta.setInt(2, obj.getDireccion().getID());
                 consulta.execute();
 
            cn.close();
        } catch (SQLException e) {
        
        }
            }
}
