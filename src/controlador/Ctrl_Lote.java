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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cajero;
import modelo.Lote;
import modelo.RangoCliente;

/**
 *
 * @author netom
 */
public class Ctrl_Lote {
      public static final boolean Crear(Lote lote) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Crear_Lote(?,?,?)}");
            consulta.setString(1, lote.getSerie());
            consulta.setDate(2, new java.sql.Date(lote.getFechaLLegada().getTime()));
            consulta.setDate(3, new java.sql.Date(lote.getFechaRetiro().getTime()));
            consulta.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return false;
        }
    }
            public static final boolean Actualizar(Lote lote) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Actualizar_Lote(?,?,?,?)}");
            consulta.setInt(1,lote.getID());
            consulta.setDate(2,new java.sql.Date(lote.getFechaLLegada().getTime()) );
            consulta.setDate(3,new java.sql.Date(lote.getFechaRetiro().getTime()));
            consulta.setString(4,lote.getSerie());
            consulta.execute();
               return true;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null,"Ocurrio un error");
            return false;
        }
    }
   public static final boolean Elimniar(int id) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Eliminar_Lote(?)}");
            consulta.setInt(1,id);
            consulta.execute();
               return true;
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null,"Ocurrio un error");
            return false;
        }
    }
   private static final List<Lote> getAll() {
        List<Lote> lista = new ArrayList<>();
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_All_Lote()}");
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            while (rs.next()) {
                Lote lote = new Lote();
                lote.setID(rs.getInt("ID"));
                lote.setFechaLLegada(rs.getDate("FechaLlegada"));
                lote.setFechaRetiro(rs.getDate("FechaRetiro"));
                lote.setSerie(rs.getString("Serie"));
                lista.add(lote);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
        return lista;
    }
      public static final Lote getLote(int id) {
        Lote lote = new Lote();
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_Lotes_By_ID(?)}");
            consulta.setInt(1, id);
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            while (rs.next()) {
               
                lote.setID(rs.getInt("ID"));
                lote.setFechaLLegada(rs.getDate("FechaLlegada"));
                lote.setFechaRetiro(rs.getDate("FechaRetiro"));
                lote.setSerie(rs.getString("Serie"));
                
            }
            return lote;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
        return lote;
    }
         public static final boolean existe(String id) {
        Lote lote = new Lote();
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_Lote_By_Serie(?)}");
            consulta.setString(1, id);
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            if (rs.next()) {
                 return true;
                
            }else{
                     return false;
            }
         
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
        return false;
    }
       public static DefaultTableModel getTabla(){
     DefaultTableModel model=new DefaultTableModel();
     List<Lote>lista=getAll();
     String fila[]=new String[4];
     model.addColumn("Id");
     model.addColumn("Fecha Llegada");
     model.addColumn("Fecha Retiro");
     model.addColumn("Serie");
     for(Lote i:lista){
         fila[0]=i.getID()+"";
         fila[1]=i.getFechaLLegada().toString();
         fila[2]=i.getFechaRetiro().toString();
         fila[3]=i.getSerie();
         model.addRow(fila);
     }  
     return model;
 }
}
