/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Administrador;
import modelo.Cajero;
import modelo.Direccion;
import modelo.Persona;

/**
 *
 * @author netom
 */
public class Bitacora {

    /**
     *Regresa una tabla con la bitacora de registros de administrador
     * @return
     */
    public static DefaultTableModel BitavoraAdmin() {
        DefaultTableModel model = new DefaultTableModel();
        try {
            Connection cn = Conexion.conectar();
            Statement statement = cn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM registrosadminitradores");

            String fila[] = new String[7];
            model.addColumn("Id");
            model.addColumn("Fecha");
            model.addColumn("Administrador afeectado");
            model.addColumn("Usuario");
            model.addColumn("Accion");
            model.addColumn("Info actual");
            model.addColumn("Info anterior");
            while (rs.next()) {
                fila[0] = rs.getInt("Id") + "";
                fila[1] = rs.getString("Fecha");
                fila[2] = rs.getString("Administrador");
                fila[3] = rs.getString("ejecutos");
                fila[4] = rs.getString("accion");
                fila[5] = rs.getString("info_actual");
                fila[6] = rs.getString("info_anterior");
                model.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            JOptionPane.showInputDialog(null, "Error de conexion");
        }
        return model;
    }

    /**
     *Recupera los registro ocurridos con los clientes
     * @return
     */
    public static DefaultTableModel BitavoraCajeros() {
        DefaultTableModel model = new DefaultTableModel();
        try {
            Connection cn = Conexion.conectar();
            Statement statement = cn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `registroscajero`");

            String fila[] = new String[5];
            model.addColumn("Id");
            model.addColumn("Fecha");
            model.addColumn("Cajero afeectado");
            model.addColumn("Usuario");
            model.addColumn("Accion");

            while (rs.next()) {
                fila[0] = rs.getInt("ID") + "";
                fila[1] = rs.getString("Fecha");
                fila[2] = rs.getString("Cajero");
                fila[3] = rs.getString("ejecutor");
                fila[4] = rs.getString("accion");
                model.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            JOptionPane.showInputDialog(null, "Error de conexion");
        }
        return model;
    }

    /**
     *Regresa unat tabla con los regiostro de la bitacora de cliente
     * @return
     */
    public static DefaultTableModel BitavoraCliente() {
        DefaultTableModel model = new DefaultTableModel();
        try {
            Connection cn = Conexion.conectar();
            Statement statement = cn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `registrosclientes`");

            String fila[] = new String[5];
            model.addColumn("Id");
            model.addColumn("Fecha");
            model.addColumn("Cliente afeectado");
            model.addColumn("Usuario");
            model.addColumn("Accion");

            while (rs.next()) {
                fila[0] = rs.getInt("ID") + "";
                fila[1] = rs.getString("Fecha");
                fila[2] = rs.getString("Cliente");
                fila[3] = rs.getString("ejecutor");
                fila[4] = rs.getString("accion");
                model.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            JOptionPane.showInputDialog(null, "Error de conexion");
        }
        return model;
    }
}
