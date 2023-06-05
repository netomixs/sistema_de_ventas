/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.RangoCliente;
import modelo.TIpo_Producto;

/**
 *
 * @author netom
 */
public class Ctrl_RangoCliente {
   /**
     *Crear rango de cliente
     * @param nombre
     * @param color
     * @return
     */
    public static final boolean Crear(String nombre, String color) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Crear_RangoClientes(?,?)}");
            consulta.setString(1, nombre);
            consulta.setString(2, color);
            consulta.execute();
              cn.close();
               return true;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return false;
        }
       
    }
  /**
     *Actualiza rango de cliente
     * @param rango
     * @return
     */
    public static final boolean Actualizar(RangoCliente rango) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Actualizar_RangoClientes(?,?,?)}");
            consulta.setInt(1, rango.getId());
            consulta.setString(2, rango.getNombre());
            consulta.setString(2, rango.getColor());
            consulta.execute();
              cn.close();
               return true;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return false;
        }
       
    }
  /**
     *Elimina rango de cliente
     * @param id
     * @return
     */
    public static final boolean Elimniar(int id) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Eliminar_Rango(?)}");
            consulta.setInt(1, id);
            consulta.execute();
              cn.close();
               return true;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return false;
        }
  
    }
  /**
     *Recupera la lsita de los rango de cleinte
     * @return
     */
    public static final List<RangoCliente> getAllRangos() {
        List<RangoCliente> lista = new ArrayList<>();
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_All_Rangocliente()}");
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            while (rs.next()) {
                RangoCliente rango = new RangoCliente();
                rango.setId(rs.getInt("ID"));
                rango.setNombre(rs.getString("Nombre"));
                rango.setColor(rs.getString("Color"));
                lista.add(rango);
            }
              cn.close();
            return lista;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
        return lista;
    }
      /**
     *Recupera los datos d3e un rango de cleinte especifico
     * @param id
     * @return
     */
      public static final RangoCliente getRango(int id) {
         RangoCliente rango = new RangoCliente();
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_Rango_Cleinte_By_Id(?)}");
            consulta.setInt(1, id);
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            while (rs.next()) {
               
                rango.setId(rs.getInt("ID"));
                rango.setNombre(rs.getString("Nombre"));
                rango.setColor(rs.getString("Color"));
              
            }
              cn.close();
            return rango;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
        return rango;
    }
      public static RangoCliente getRango(int id,List<RangoCliente> lista){
          for (RangoCliente rangoCliente : lista) {
              if(rangoCliente.getId()==id){
                  return rangoCliente;
              }
          }
          return new RangoCliente();
      }
}
