package vista;

import controlador.Ctrl_Admin;
import controlador.Ctrl_Cliente;
import controlador.Ctrl_Factura;
import controlador.Ctrl_Lote;
import controlador.Ctrl_Producto;
import static controlador.Ctrl_Producto.getAll;
import controlador.Ctrl_TipoProducto;
import java.awt.Dimension;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Factura;
import modelo.Producto;
import modelo.ProductosVendidos;
import static vista.InterGestionarCajeros.jTable_Cajeros;

public class InterFacturacion extends javax.swing.JInternalFrame {

    private int indexSeleccioado;
    Cliente cliente;
    Factura factura;
    float subtotal, descuento;
    int id = -1;
    List<ProductosVendidos> lista;
    List<Producto> listaProductos;

    public InterFacturacion() {
        initComponents();
        this.setSize(new Dimension(800, 600));
        this.setTitle("Facturacion");
        cliente = new Cliente();
        lista = new ArrayList<>();
        listaProductos = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_Cantidad = new javax.swing.JTextField();
        jButton_busca_cliente = new javax.swing.JButton();
        jButton_añadir_producto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        txt_descuento = new javax.swing.JTextField();
        txt_iva = new javax.swing.JTextField();
        txt_total_pagar = new javax.swing.JTextField();
        txt_efectivo = new javax.swing.JTextField();
        txt_cambio = new javax.swing.JTextField();
        jButton_RegistrarVenta = new javax.swing.JButton();
        txt_cliente_buscar1 = new javax.swing.JTextField();
        txt_Producto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Producto:");

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Venta");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cantidad:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 80, -1));

        txt_Cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 50, -1));

        jButton_busca_cliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_busca_cliente.setText("Buscar");
        jButton_busca_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_busca_clienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_busca_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 80, -1));

        jButton_añadir_producto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_añadir_producto.setText("Agregar");
        jButton_añadir_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_añadir_productoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_añadir_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 90, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 740, 190));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 760, 210));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Subtotal:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Descuento:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Iva:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Total a pagar:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Efectivo:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Cambio:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txt_subtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_subtotal.setEnabled(false);
        jPanel2.add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 120, -1));

        txt_descuento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_descuento.setEnabled(false);
        jPanel2.add(txt_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 120, -1));

        txt_iva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_iva.setEnabled(false);
        jPanel2.add(txt_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 120, -1));

        txt_total_pagar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_total_pagar.setEnabled(false);
        jPanel2.add(txt_total_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 120, -1));

        txt_efectivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txt_efectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 120, -1));

        txt_cambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_cambio.setEnabled(false);
        jPanel2.add(txt_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 120, -1));

        jButton_RegistrarVenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_RegistrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/impresora.png"))); // NOI18N
        jButton_RegistrarVenta.setText("Registrar Venta");
        jButton_RegistrarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_RegistrarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_RegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarVentaActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_RegistrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 130, 110));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 380, 210));

        txt_cliente_buscar1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_cliente_buscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 150, -1));

        txt_Producto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_Producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 150, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cliente:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Producto:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 80, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_busca_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_busca_clienteActionPerformed
        String idCliente = txt_Cantidad.getText();

        if (!idCliente.isEmpty()) {
            idCliente = idCliente.substring(2);
            id = Integer.parseInt(idCliente);
            try {
                Ctrl_Cliente.getCliente(id);
            } catch (Exception e) {

            }

        }


    }//GEN-LAST:event_jButton_busca_clienteActionPerformed

    private void jButton_añadir_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_añadir_productoActionPerformed
        RetenerProduto(txt_Producto.getText(), Integer.parseInt(this.txt_Cantidad.getText()));

    }//GEN-LAST:event_jButton_añadir_productoActionPerformed

    private void jTable_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_productosMouseClicked

    }//GEN-LAST:event_jTable_productosMouseClicked

    private void jButton_RegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarVentaActionPerformed
        if(!txt_cambio.getText().isBlank()){
            pagar();
        }
        else{
            
        }

    }//GEN-LAST:event_jButton_RegistrarVentaActionPerformed
    void addEventoTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        ListSelectionModel modeloSeleccion = tabla.getSelectionModel();
        modeloSeleccion.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {

                }
            }
        });
    }

    float calcularDescuentoPorRango(float subtotal) {

        if (cliente != null) {
            switch (cliente.getRango()) {
                case 1:
                    subtotal += (subtotal * 0.02);
                    break;
                case 2:
                    subtotal += (subtotal * 0.05);
                    break;
                default:
            }
        }
        return subtotal;
    }

    float descuentoPorFecha(Producto p) {
        float porcentajeDescuento = 0;
        LocalDate fechaActual = LocalDate.now();
        Date fechaRetiro = Ctrl_Lote.getLote(p.getLote()).getFechaRetiro();
        LocalDate fechaFutura = fechaRetiro.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period periodo = fechaActual.until(fechaFutura);

        // Obtener la cantidad de días faltantes
        int diasFaltantes = periodo.getDays();
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
        return des;
    }

    void limpiar() {
        lista = new ArrayList<>();
        listaProductos = new ArrayList<>();
    }

    void recupararIndexDeTabla() {
        indexSeleccioado = jTable_Cajeros.getSelectedRow();
        String columna0 = jTable_Cajeros.getModel().getValueAt(indexSeleccioado, 3).toString();
        int ID = Integer.parseInt(columna0);
    }

    void pagar() {
        float pago=Integer.parseInt(txt_efectivo.getText());
        int facturaID = Ctrl_Factura.Crear(id, lista);
        descuento += calcularDescuentoPorRango(subtotal);
        txt_subtotal.setText(subtotal + "");
        txt_descuento.setText(descuento + "");
        float iva = subtotal * .16f;
        txt_iva.setText(iva + "");
        float total = subtotal - descuento + iva;
        txt_total_pagar.setText(total + "");
        float cambio=total-pago;
        JOptionPane.showMessageDialog(this,"Cambio:"+cambio,"Compráfinalizada",0);
         Ctrl_Factura.InsertarTotal(facturaID, total);
        limpiar();
    }

    void RetenerProduto(String C_Barras, int cantidad) {
        Producto produto = Ctrl_Producto.getProducto(C_Barras);
        if (produto != null) {
            if (cantidad <= produto.getStock()) {
                ProductosVendidos venimia = new ProductosVendidos();
                venimia.setCantidad(cantidad);
                venimia.setProdcuto(produto.getID());
                venimia.setSubTotal((float) ((cantidad * descuentoPorFecha(produto))));
                float descunetoPorProdcuto = (cantidad * descuentoPorFecha(produto) - (cantidad * produto.getPrecio()));
                subtotal += venimia.getSubTotal();
                descuento += descunetoPorProdcuto;
                listaProductos.add(produto);
                txt_subtotal.setText(subtotal + "");
                txt_descuento.setText(descuento + "");
                float iva = subtotal * .16f;
                txt_iva.setText(iva + "");
                float total = subtotal - descuento + iva;
                txt_total_pagar.setText(total + "");
                lista.add(venimia);
            } else {
                JOptionPane.showMessageDialog(this, "Productos insuficientes.\nRstante: " + cantidad);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Prodcuto no existe");
        }
    }

    public DefaultTableModel getTabla() {
        DefaultTableModel model = new DefaultTableModel();

        String fila[] = new String[7];
        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("Cantidad");
        model.addColumn("Precio");
        model.addColumn("Subtotal");
        for (ProductosVendidos i : lista) {

        }
        for (int i = 0; i < lista.size(); i++) {

            fila[0] = lista.get(i).getID() + "";
            fila[1] = listaProductos.get(i).getNombre();
            fila[2] = lista.get(i).getCantidad() + "";
            fila[3] = listaProductos.get(i).getPrecio() + "";
            fila[4] = lista.get(i).getSubTotal() + "";
            model.addRow(fila);
        }

        return model;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_RegistrarVenta;
    private javax.swing.JButton jButton_añadir_producto;
    private javax.swing.JButton jButton_busca_cliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField txt_Cantidad;
    private javax.swing.JTextField txt_Producto;
    private javax.swing.JTextField txt_cambio;
    private javax.swing.JTextField txt_cliente_buscar1;
    private javax.swing.JTextField txt_descuento;
    private javax.swing.JTextField txt_efectivo;
    private javax.swing.JTextField txt_iva;
    private javax.swing.JTextField txt_subtotal;
    public static javax.swing.JTextField txt_total_pagar;
    // End of variables declaration//GEN-END:variables

}
