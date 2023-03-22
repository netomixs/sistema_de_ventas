/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import static controlador.Ctrl_Admin.eliminarPersona;
import static controlador.Ctrl_Producto.getAll;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Administrador;
import modelo.Producto;
import modelo.TIpo_Producto;

public class Ctrl_TipoProducto {

    public static final boolean Crear(String tipo) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Crear_TipoProductos(?)}");
            consulta.setString(1, tipo);
            consulta.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return false;
        }

    }

    public static final boolean Actualizar(int id, String tipo) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Actualizar_TipoProductos(?,?)}");
            consulta.setInt(1, id);
            consulta.setString(2, tipo);
            consulta.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return false;
        }

    }

    public static final boolean Elimniar(int id) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Eliminar_TipoProductos(?)}");
            consulta.setInt(1, id);
            consulta.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return false;
        }

    }

    public static final List<TIpo_Producto> getAll() {
        List<TIpo_Producto> lista = new ArrayList<>();
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_All_TipoProductos()}");
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            while (rs.next()) {
                TIpo_Producto tipo = new TIpo_Producto();
                tipo.setID(rs.getInt("ID"));
                tipo.setTipo(rs.getString("Tipo"));
                lista.add(tipo);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");

        }
        return lista;
    }

    public static final TIpo_Producto getTipo(int id) {
        List<TIpo_Producto> lista = getAll();
        for (TIpo_Producto i : lista) {
            if (i.getID() == id) {
                return i;
            }
        }
        return new TIpo_Producto(0, "Error");

    }

    public static final TIpo_Producto getTipo(String nombre) {
        List<TIpo_Producto> lista = getAll();
        for (TIpo_Producto i : lista) {
            if (i.getTipo().equals(nombre)) {
                return i;
            }
        }
        return new TIpo_Producto(0, "Error");

    }

    public static final boolean existe(String nombre) {
        List<TIpo_Producto> lista = getAll();
        for (TIpo_Producto i : lista) {
            if (i.getTipo().equals(nombre)) {
                return true;
            }
        }
        return false;

    }

    public static DefaultTableModel getTabla() {
        DefaultTableModel model = new DefaultTableModel();
        List<TIpo_Producto> lista = getAll();
        String fila[] = new String[2];
        model.addColumn("Id");
        model.addColumn("Nombre");
        for (TIpo_Producto i : lista) {
            fila[0] = i.getID() + "";
            fila[1] = i.getTipo();

            model.addRow(fila);
        }

        return model;
    }
}
