package controlador;

import Interfaces.Crud;
import conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Factura;
import modelo.Lote;
import modelo.ProductosVendidos;

/**
 *Controla la informacion de las facturas y su relacion con la base de datos
 * @author netom
 */
public class Ctrl_Factura {

    /**
     * Crea una factura y llama a la funcion que registra los productos vendidos
     *
     * @param idCliente
     * @param lista
     * @return
     */
    public static final int Crear(int idCliente, List<ProductosVendidos> lista) {
        int idFactura = -1;
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Crear_Factura(?)}");
            if (idCliente == -1) {
                consulta.setObject(1, null);
            } else {
                consulta.setInt(1, idCliente);
            }

            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            if (rs.next()) {
                idFactura = Integer.parseInt(rs.getString(1));
                Ctrl_RegistrarVenta.registarVenta(lista, idFactura);
            }
            return idFactura;

        } catch (SQLException e) {
            System.out.println("Error : " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return idFactura;
        }
    }

    /**
     * Inserta el total a la factura indicada
     *
     * @param factua
     * @param total
     */
    public static final void InsertarTotal(int factua, float total) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Actualizar_Toatal_Fatura(?,?)}");
            consulta.setInt(1, factua);
            consulta.setFloat(2, total);
            consulta.execute();
        } catch (SQLException e) {
            System.out.println("Error : " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");

        }
    }

    /**
     * Recupera una lista de los prodcutos que pertenecen a una factura
     *
     */
    private static List<Factura> getAll() {
        List<Factura> lista = new ArrayList<>();
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_All_Faturas()}");

            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            while (rs.next()) {
                Factura f = new Factura();
                f.setID(rs.getInt("ID"));
                f.setCliente(rs.getInt("Cliente"));
                f.setFecha(rs.getDate("Fecha"));
                f.setTotal(rs.getFloat("Total"));
                f.setHora(rs.getTime("Fecha"));
                System.out.println(rs.getDate("Fecha"));
                System.out.println(rs.getTime("Fecha"));
                lista.add(f);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
        return lista;
    }

    /**
     * Recupera una tabla de las facturas
     *
     * @return
     */
    public static DefaultTableModel getTabla() {
        DefaultTableModel model = new DefaultTableModel();
        List<Factura> lista = getAll();
        String fila[] = new String[5];
        model.addColumn("Id");

        model.addColumn("Id Cliente");
        model.addColumn("Fecha");
        model.addColumn("Hora");
        model.addColumn("Total");
        for (Factura i : lista) {
            fila[0] = i.getID() + "";
            fila[1] = "52" + i.getCliente();
            fila[2] = i.getFecha().toString();
            fila[3] = i.getHora().toString();
            fila[4] = i.getTotal() + "";
            model.addRow(fila);
        }
        return model;
    }

    /**
     * retorna los debe de haber en caja a la fecha desde 12:00 am hasta las
     * hora detonada entre las 3:00Pm y las 4:00PM
     *
     * @return
     */
    public static float corteCaja() {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Corte_Caja()}");

            consulta.execute();
            ResultSet rs = consulta.getResultSet();

            if (rs.next()) {
                return rs.getFloat(1);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");

        }
        return 0;
    }
 /**
     * Se recupera el total de las ventas realizadas por dia registradas dentro de un periodo
     *
     * @param inicio
     * @param fin
     * @return
     */
    public static DefaultTableModel getTabla_ReporteVnetas(Date inicio, Date fin) {
        DefaultTableModel model = new DefaultTableModel();
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_Facturas_By_Periodo(?,?)}");
            consulta.setDate(1, new java.sql.Date(inicio.getTime()));
            consulta.setDate(2, new java.sql.Date(fin.getTime()));
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
           
            String fila[] = new String[5];
            model.addColumn("Fecha");
            model.addColumn("Venta");
                 SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {
                
                    fila[0]=formato.format(rs.getDate("Fecha"));
                    fila[1]=rs.getFloat("Total")+"";
                    model.addRow(fila);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");

        }
        return model;
    }
}
