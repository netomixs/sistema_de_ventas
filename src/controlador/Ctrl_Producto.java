package controlador;

import static controlador.Ctrl_Cliente.get;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Cliente;
import modelo.Lote;
import modelo.Producto;
import modelo.TIpo_Producto;

/**
 *
 * @author Edison Zambrano - © Programador Fantasma
 */
public class Ctrl_Producto {

    /**
     * registra el producto en la base de datos
     *
     * @param producto
     * @return
     */
    public boolean Crear(Producto producto) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Crear_Producto(?,?,?,?,?,?,?,?)}");
            consulta.setInt(1, producto.getTipo());
            consulta.setFloat(2, producto.getPrecio());
            consulta.setString(3, producto.getNombre());
            consulta.setString(4, producto.getDescripcion());
            consulta.setInt(5, producto.getStock());
            consulta.setInt(6, producto.getLoteID());
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

    /**
     * Busca un elemto en una Jtabla
     *
     * @param valorBusqueda
     * @param tabla
     */
    public static void buscarEnJTable(String valorBusqueda, JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(modelo);
        tabla.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + valorBusqueda));
    }

    /**
     * Actualiza el prodcuto indicado
     *
     * @param producto
     * @return
     */
    public boolean Actualizar(Producto producto) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Actualizar_Producto(?,?,?,?,?,?,?,?,?)}");
            consulta.setInt(1, producto.getID());
            consulta.setInt(2, producto.getTipo());
            consulta.setFloat(3, producto.getPrecio());
            consulta.setString(4, producto.getNombre());
            consulta.setString(5, producto.getDescripcion());
            consulta.setInt(6, producto.getStock());
            consulta.setInt(7, producto.getLoteID());
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

    /**
     * Elimina el prodcuto inidcado
     *
     * @param id
     * @return
     */
    public boolean Eliminar(int id) {
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

    /**
     * Elimina el prodcuto indicado
     *
     * @param barra
     * @return
     */
    public boolean Eliminar(String barra) {
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

    /**
     * Recupera una lista de los prodcutos registrados
     *
     * @return
     */
    public List<Producto> getAll() {
        List<Producto> lista = new ArrayList<>();
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_All_Productos()}");
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            while (rs.next()) {
                Lote lote = new Lote();
                Producto producto = new Producto();
                producto.setID(rs.getInt("Producto_ID"));
                producto.setTipo(rs.getInt("Producto_Tipo"));
                producto.setPrecio(rs.getFloat("Producto_Precio"));
                producto.setNombre(rs.getString("Producto_Nombre"));
                producto.setDescripcion(rs.getString("Producto_Descripcion"));
                producto.setLoteID(rs.getInt("Lotes_ID"));
                producto.setStock(rs.getInt("Producto_Numero"));
                producto.setImgSrc(rs.getString("Producto_Imagen"));
                producto.setC_Barras(rs.getString("Producto_Barras"));

                lote.setFechaLLegada(rs.getDate("Lote_FechaLlegada"));
                lote.setFechaRetiro(rs.getDate("Lote_FechaRetiro"));
                lote.setSerie(rs.getString("Lote_Serie"));
                lote.setID(rs.getInt("Lotes_ID"));
                producto.setLotes(lote);
                lista.add(producto);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");

        }
        return lista;
    }

    /**
     * Recupera el prodcuto indicado
     *
     * @param id
     * @return
     */
    public Producto getProducto(int id) {
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
                producto.setLoteID(rs.getInt("Lote"));
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

    /**
     * Recupera el prodcuto indicado
     *
     * @param barras
     * @return
     */
    public Producto getProducto(String barras) {
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
                producto.setLoteID(rs.getInt("Lote"));
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

    /**
     * Verifica si el prodcuto existe
     *
     * @param barras
     * @return
     */
    public boolean existe(String barras) {
        Producto producto = new Producto();
        try {

            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_Produtos_By_Barras(?)}");
            consulta.setString(1, barras);
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");

        }
        return false;
    }

    /**
     * Recupera una tabla de todos los prodcutos
     *
     * @return
     */
    public DefaultTableModel getTabla() {
        Ctrl_Lote ctrlLote = new Ctrl_Lote();
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
            fila[5] = i.getLotes().getFechaLLegada().toString();
            fila[6] = i.getLotes().getFechaRetiro().toString();
            model.addRow(fila);
        }

        return model;
    }

    /**
     * Retorna el descuento que se le hace a un prodcuto basado en su fecha de
     * retiro
     *
     * @param p
     * @return
     */
    public float descuentoPorFecha(Producto p) {
        float porcentajeDescuento = 0;
        LocalDate fechaActual = LocalDate.now();
        Date date = null;
        Ctrl_Lote ctrlLote = new Ctrl_Lote();
        Date fechaRetiro = ctrlLote.get(p.getLoteID()).getFechaRetiro();
        String dateString = fechaRetiro.toString();
        System.out.println(fechaRetiro.toString());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(Ctrl_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        LocalDate fechaFutura = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        LocalDate localDate = LocalDate.now(); // Obtiene la fecha actual

        // Convierte el objeto LocalDate a LocalDateTime a través del método atStartOfDay()
        LocalDateTime localDateTime = localDate.atStartOfDay();

        // Convierte LocalDateTime a Date a través del método Date.from()
        Date fechadeHoy = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        Period periodo = fechaActual.until(fechaFutura);
        System.out.println(fechaFutura.toString());
        System.out.println(fechaActual.toString());
        // Obtener la cantidad de días faltantes
        int diasFaltantes = (int) diasEntreDosFechas(fechadeHoy, fechaRetiro);
        if (diasFaltantes <= 7) {
            porcentajeDescuento = 0.15f;
        }
        if (diasFaltantes <= 3) {
            porcentajeDescuento = 0.30f;
        }
        if (diasFaltantes <= -3) {
            porcentajeDescuento = 0.5f;
        }
        float des = p.getPrecio() * porcentajeDescuento;
        System.out.println("dIAS" + diasFaltantes);
        System.out.println("des" + des);
        return des;
    }

    /**
     * Retorna la diferencia en dias entre dfos fecha
     *
     * @param fechaDesde
     * @param fechaHasta
     * @return
     */
    public static long diasEntreDosFechas(Date fechaDesde, Date fechaHasta) {
        long startTime = fechaDesde.getTime();
        long endTime = fechaHasta.getTime();
        long diasDesde = (long) Math.floor(startTime / (1000 * 60 * 60 * 24)); // convertimos a dias, para que no afecten cambios de hora 
        long diasHasta = (long) Math.floor(endTime / (1000 * 60 * 60 * 24)); // convertimos a dias, para que no afecten cambios de hora
        long dias = diasHasta - diasDesde;
        return dias;
    }

    /**
     * Recupera una tabla de los prodcutos vendidos entre un periodo
     *
     * @param inicio
     * @param fin
     * @return
     */
    public DefaultTableModel getTabla_Reporte(Date inicio, Date fin) {
        DefaultTableModel model = new DefaultTableModel();
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_Productos_Mas_Vendidos_By_Perirodo(?,?)}");
            consulta.setDate(1, new java.sql.Date(inicio.getTime()));
            consulta.setDate(2, new java.sql.Date(fin.getTime()));
            consulta.execute();
            ResultSet rs = consulta.getResultSet();

            String fila[] = new String[5];
            model.addColumn("Id");
            model.addColumn("Nombre");
            model.addColumn("Cantidad");
            model.addColumn("Disponibles");
            model.addColumn("Codigo");
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {
                Producto p = getProducto(rs.getInt("Producto"));
                fila[0] = p.getID() + "";
                fila[1] = p.getNombre();
                fila[2] = rs.getInt("Cantidad") + "";
                fila[3] = p.getStock() + "";
                fila[4] = p.getC_Barras();
                model.addRow(fila);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");

        }
        return model;
    }
}
