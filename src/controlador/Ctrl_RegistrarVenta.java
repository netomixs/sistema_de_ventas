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
import modelo.CabeceraVenta;
import modelo.DetalleVenta;
import modelo.Lote;
import modelo.ProductosVendidos;

/**
 * @author edison
 */
public class Ctrl_RegistrarVenta {

    private static final boolean Crear(ProductosVendidos venta) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Crear_Productosvendidos(?,?,?,?)}");
            consulta.setInt(1, venta.getProdcuto());
            consulta.setInt(2, venta.getCantidad());
            consulta.setInt(1, venta.getFactura());
            consulta.setFloat(4, venta.getSubTotal());
            consulta.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error : " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return false;
        }
    }

    protected static final List<ProductosVendidos> registarVenta(List<ProductosVendidos> lista,int idFactura) {
        float total=0;
        List<ProductosVendidos> noProcesados=new ArrayList<>();
            for(ProductosVendidos i: lista){
                i.setFactura(idFactura);
                total+=i.getSubTotal();
                if(Crear(i)){
                    
                }else{
                    noProcesados.add(i);
                }
            }
           
            return noProcesados;
            
    }
       private static final List<ProductosVendidos> get(int facturaId) {
        List<ProductosVendidos> lista = new ArrayList<>();
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_Productos_Vendidos_By_Factura(?)}");
            consulta.setInt(1, facturaId);
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            while (rs.next()) {
                ProductosVendidos p = new ProductosVendidos();
                p.setID(rs.getInt("ID"));
                p.setProdcuto(rs.getInt("Producto"));
                p.setFactura(rs.getInt("Factura"));
                p.setSubTotal(rs.getFloat("Subtotal"));
                lista.add(p);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
        return lista;
    }
}
