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
import modelo.Factura;
import modelo.Lote;
import modelo.ProductosVendidos;

public class Ctrl_Factura {

    public static final int Crear(int idCliente, List<ProductosVendidos> lista) {
        int idFactura = -1;
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Crear_Factura(?)}");
            if (idCliente == -1) {
                consulta.setString(1, "");
            } else {
                consulta.setInt(1, idCliente);
            }

            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            if (rs.next()) {
                idFactura = Integer.parseInt(rs.getString(1));
            }
            return idFactura;

        } catch (SQLException e) {
            System.out.println("Error : " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return idFactura;
        }
    }

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

    private static final List<Factura> getAll() {
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
                lista.add(f);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
        return lista;
    }

    public static DefaultTableModel getTabla() {
        DefaultTableModel model = new DefaultTableModel();
        List<Factura> lista = getAll();
        String fila[] = new String[4];
        model.addColumn("Id");
        model.addColumn("Fecha Llegada");
        model.addColumn("Fecha Retiro");
        model.addColumn("Serie");
        for (Factura i : lista) {
            fila[0] = i.getID() + "";
            fila[1] = "52" + i.getCliente();
            fila[2] = i.getFecha().toString();
            fila[3] = i.getTotal() + "";
            model.addRow(fila);
        }
        return model;
    }
}
