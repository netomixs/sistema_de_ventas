package controlador;

import conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
import modelo.TIpo_Producto;

/**
 *
 * @author Edison Zambrano - © Programador Fantasma
 */
public class Ctrl_Producto {

    public static final boolean Crear(Producto producto) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Crear_Producto(?,?,?,?,?,?,?,?)}");
            consulta.setInt(1, producto.getTipo());
            consulta.setFloat(2, producto.getPrecio());
            consulta.setString(3, producto.getNombre());
            consulta.setString(4, producto.getDescripcion());
            consulta.setInt(5, producto.getStock());
            consulta.setInt(6, producto.getLote());
            consulta.setString(7, producto.getImgSrc());
            consulta.setString(8, producto.getC_Barras());
            consulta.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return false;
        }

    }

    public static final boolean Actualizar(Producto producto) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Actualizar_Producto(?,?,?,?,?,?,?,?,?)}");
            consulta.setInt(1, producto.getID());
            consulta.setInt(2, producto.getTipo());
            consulta.setFloat(3, producto.getPrecio());
            consulta.setString(4, producto.getNombre());
            consulta.setString(5, producto.getDescripcion());
            consulta.setInt(6, producto.getStock());
            consulta.setInt(7, producto.getLote());
            consulta.setString(8, producto.getImgSrc());
            consulta.setString(9, producto.getC_Barras());
            consulta.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return false;
        }
    }

    public static final boolean Eliminar(int id) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Eliminar_Produto_By_Id_Or_Barras(?,?)}");
            consulta.setInt(1, id);
            consulta.setString(2, "");
            consulta.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return false;
        }
    }

    public static final boolean Eliminar(String barra) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Eliminar_Produto_By_Id_Or_Barras(?,?)}");
            consulta.setInt(1, -1);
            consulta.setString(2, barra);
            consulta.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return false;
        }
    }

    public static final List<Producto> getAll() {
        List<Producto> lista = new ArrayList<>();
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_All_TipoProductos()}");
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setID(rs.getInt("ID"));
                producto.setTipo(rs.getInt("Tipo"));
                producto.setPrecio(rs.getFloat("Precio"));
                producto.setNombre(rs.getString("Nombre"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setLote(rs.getInt("Lote"));
                producto.setStock(rs.getInt("Numero"));
                producto.setImgSrc(rs.getString("Imagen"));
                producto.setC_Barras(rs.getString("C_Barras"));

                lista.add(producto);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");

        }
        return lista;
    }

    public static final Producto getProducto(int id) {
        Producto producto = new Producto();
        try {

            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_Productos_By_Id(?)}");
            consulta.setInt(1, id);
            consulta.execute();

            ResultSet rs = consulta.getResultSet();
            while (rs.next()) {

                producto.setID(rs.getInt("ID"));
                producto.setTipo(rs.getInt("Tipo"));
                producto.setPrecio(rs.getFloat("Precio"));
                producto.setNombre(rs.getString("Nombre"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setLote(rs.getInt("Lote"));
                producto.setStock(rs.getInt("Numero"));
                producto.setImgSrc(rs.getString("Imagen"));
                producto.setC_Barras(rs.getString("C_Barras"));

            }
            return producto;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");

        }
        return producto;
    }

    public static final Producto getProducto(String barras) {
        Producto producto = new Producto();
        try {

            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_Produtos_By_Barras(?)}");
            consulta.setString(1, barras);
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            while (rs.next()) {

                producto.setID(rs.getInt("ID"));
                producto.setTipo(rs.getInt("Tipo"));
                producto.setPrecio(rs.getFloat("Precio"));
                producto.setNombre(rs.getString("Nombre"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setLote(rs.getInt("Lote"));
                producto.setStock(rs.getInt("Numero"));
                producto.setImgSrc(rs.getString("Imagen"));
                producto.setC_Barras(rs.getString("C_Barras"));

            }
            return producto;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");

        }
        return producto;
    }
  public static final boolean existe(String barras) {
        Producto producto = new Producto();
        try {

            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_Produtos_By_Barras(?)}");
            consulta.setString(1, barras);
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            if (rs.next()) {
                return true;    
            }
            else return false;
            
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
                
        }
         return false;
    }
    public static DefaultTableModel getTabla() {
        DefaultTableModel model = new DefaultTableModel();
        List<Producto> lista = getAll();
        String fila[] = new String[7];
        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("En stock");
        model.addColumn("Precio");
        model.addColumn("Tipo");
        model.addColumn("Fecha de llegada");
        model.addColumn("Fecha de salida");
        for (Producto i : lista) {
            fila[0] = i.getID() + "";
            fila[1] = i.getNombre();
            fila[2] = i.getStock() + "";
            fila[3] = i.getPrecio() + "";
            fila[4] = Ctrl_TipoProducto.getTipo(i.getTipo()).getTipo();
            fila[5] = Ctrl_Lote.getLote(i.getLote()).getFechaLLegada().toString();
            fila[6] = Ctrl_Lote.getLote(i.getLote()).getFechaRetiro().toString();
            model.addRow(fila);
        }

        return model;
    }
}
