package vista;

import controlador.Ctrl_Cliente;
import controlador.Ctrl_Factura;
import controlador.Ctrl_Persona;
import controlador.Ctrl_Producto;
import controlador.Ctrl_RangoCliente;
import controlador.Ctrl_RegistrarVenta;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
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
import modelo.RangoCliente;
import static vista.InterGestionarCajeros.jTable_Cajeros;

/**
 *Ventana de facturacion o de ventas
 * @author Ernesto
 */
public class InterFacturacion extends javax.swing.JInternalFrame {

    float total;
    boolean clienteActivo = false;
    private int indexSeleccioado;
    Cliente cliente;
    Factura factura;
    float subtotal, descuento;
    int id = -1;
    List<ProductosVendidos> lista;
    List<Producto> listaProductos;
    private float iva;

    /**
     *
     */
    public InterFacturacion() {
        initComponents();
        this.setSize(new Dimension(800, 600));

        this.setTitle("Facturacion");
        cliente = new Cliente();
        lista = new ArrayList<>();
        listaProductos = new ArrayList<>();
        this.panelCliente.setVisible(false);

        txt_Producto.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                boolean ctrlPressed = e.isControlDown();
                if (ctrlPressed && keyCode == KeyEvent.VK_Q) {
                    cosultarPrecio();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    void cosultarPrecio() {
        // Llamar al método que se quiere ejecutar
        String idProducto = JOptionPane.showInputDialog(null, "Introduzca el ID del producto:");
        if (idProducto != null) {
            Ctrl_Producto ctrlProducto = new Ctrl_Producto();
            Producto p = ctrlProducto.getProducto(idProducto);
            float precioProducto = p.getPrecio();
            if (precioProducto == 0) {
                JOptionPane.showMessageDialog(null, "El producto con ID " + idProducto + " no fue encontrado.", "No found", 0);
            } else {
                JOptionPane.showMessageDialog(null, "<html><font size='14'>$" + precioProducto + "</font></html>", p.getNombre(), 1);
            }
        }
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
        txt_subtotal = new javax.swing.JTextField();
        txt_descuento = new javax.swing.JTextField();
        txt_iva = new javax.swing.JTextField();
        txt_total_pagar = new javax.swing.JTextField();
        txt_efectivo = new javax.swing.JTextField();
        jButton_RegistrarVenta = new javax.swing.JButton();
        txt_cliente_buscar1 = new javax.swing.JTextField();
        txt_Producto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        panelCliente = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        label_Id_Cliente = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        label_Nombre_cliente = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        label_RangoCliente = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        label_dinero = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Producto:");

        setClosable(true);
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
                {},
                {},
                {},
                {}
            },
            new String [] {

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

        panelCliente.setBackground(new java.awt.Color(255, 255, 255));
        panelCliente.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelCliente.setLayout(new java.awt.GridLayout(4, 1, 20, 5));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Id cliente: ");
        jLabel15.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jPanel3.add(jLabel15);

        label_Id_Cliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_Id_Cliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_Id_Cliente.setText("#########");
        label_Id_Cliente.setToolTipText("");
        jPanel3.add(label_Id_Cliente);

        panelCliente.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Nombre: ");
        jLabel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jPanel4.add(jLabel12);

        label_Nombre_cliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_Nombre_cliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_Nombre_cliente.setText("#########");
        label_Nombre_cliente.setToolTipText("");
        jPanel4.add(label_Nombre_cliente);

        panelCliente.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Rango: ");
        jLabel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jPanel5.add(jLabel13);

        label_RangoCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_RangoCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_RangoCliente.setText("#########");
        label_RangoCliente.setToolTipText("");
        jPanel5.add(label_RangoCliente);

        panelCliente.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Dinero electronico: ");
        jLabel14.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jPanel6.add(jLabel14);

        label_dinero.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_dinero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_dinero.setText("#########");
        label_dinero.setToolTipText("");
        jPanel6.add(label_dinero);

        panelCliente.add(jPanel6);

        getContentPane().add(panelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 380, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_busca_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_busca_clienteActionPerformed
        String idCliente = txt_cliente_buscar1.getText();
        Ctrl_RangoCliente ctrlRango = new Ctrl_RangoCliente();

        if (!idCliente.isEmpty()) {
            if (idCliente.startsWith("52")) {
                if (idCliente.length() > 2) {
                    String resultado = idCliente.substring(2);
                    id = Integer.parseInt(resultado);
                } else {
                    JOptionPane.showMessageDialog(null, "Numero de cliente es incorrecto");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El nuemero de cliente no pertenece a esta tienda.\n Debe de empezar por :\"52\".");
            }

            System.out.println(id);
            try {
                cliente = Ctrl_Cliente.get(id);
                if (cliente.getID() != 0) {
                    clienteActivo = true;
                    RangoCliente rango = Ctrl_RangoCliente.getRango(cliente.getRango());
                    this.panelCliente.setVisible(true);
                    this.label_Id_Cliente.setText("52" + cliente.getID());
                    this.label_Nombre_cliente.setText(cliente.getPersona().getNombre() + " "
                            + cliente.getPersona().getApellidoP());

                    this.label_RangoCliente.setText(rango.getNombre());
                    Color color = Color.decode("#" + rango.getColor());
                    //label_RangoCliente.setForeground(color);
                    this.label_dinero.setText(cliente.getPuntos() + "");
                    panelCliente.setBackground(color);
                } else {
                    JOptionPane.showMessageDialog(this, "Cliente no encontrado", "error", 0);
                    this.panelCliente.setVisible(false);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }


    }//GEN-LAST:event_jButton_busca_clienteActionPerformed

    private void jButton_añadir_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_añadir_productoActionPerformed
        try {
            if (txt_Cantidad.getText().isEmpty()) {
                txt_Cantidad.setText("1");

            }
            RetenerProduto(txt_Producto.getText(), Integer.parseInt(this.txt_Cantidad.getText()));
        } catch (Exception e) {

        }


    }//GEN-LAST:event_jButton_añadir_productoActionPerformed

    private void jTable_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_productosMouseClicked

    }//GEN-LAST:event_jTable_productosMouseClicked

    private void jButton_RegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarVentaActionPerformed
        if (!txt_efectivo.getText().isEmpty()) {
            pagar();
        } else {
            JOptionPane.showMessageDialog(this, "Ingresa pago");
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

    void limpiar() {
        lista = new ArrayList<>();
        listaProductos = new ArrayList<>();
        jTable_productos.setModel(getTabla());
        subtotal = 0;
        descuento = 0;
        total = 0;
        cliente = new Cliente();
        this.setVisible(false);
        FrmMenuCajero.abrirVentas();
    }

    void recupararIndexDeTabla() {
        indexSeleccioado = jTable_Cajeros.getSelectedRow();
        String columna0 = jTable_Cajeros.getModel().getValueAt(indexSeleccioado, 3).toString();
        int ID = Integer.parseInt(columna0);
    }

    void pagar() {
        int cantidadPagarPuntos = 0;
        float pago = Integer.parseInt(txt_efectivo.getText());
        if (lista.size() > 0) {
            if (clienteActivo) {
                if (cliente.getPuntos() > 0) {
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres pagar con puntos?");
                    if (opcion == JOptionPane.YES_OPTION) {
                        do {
                            cantidadPagarPuntos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la cantidad de puntos a utilizar"));
                            if (cantidadPagarPuntos > cliente.getPuntos()) {
                                JOptionPane.showMessageDialog(null, "No tienes suficientes puntos disponibles, ingresa una cantidad menor");
                            }
                        } while (cantidadPagarPuntos > cliente.getPuntos());
                        JOptionPane.showMessageDialog(null, "Has pagado con " + cantidadPagarPuntos + " puntos");
                        txt_total_pagar.setText(txt_total_pagar.getText());
                        txt_efectivo.setText(txt_efectivo.getText() + " + " + cantidadPagarPuntos);
                        // Ctrl_Cliente.actualizarPuntos(cliente.getID(), -cantidadPagarPuntos);
                        pago = pago + cantidadPagarPuntos;
                    } else {
                        JOptionPane.showMessageDialog(null, "Has decidido no pagar con puntos");
                    }
                }
            }
            float cambio = 0;
            if (pago >= total) {
                try {
                    int facturaID = Ctrl_Factura.Crear(id, lista);
                    cambio = pago - total;
                    String idCliente = "";
                    Ctrl_Factura.InsertarTotal(facturaID, total);
                    if (clienteActivo) {
                        Ctrl_Cliente.actualizarPuntos(cliente.getID(), -cantidadPagarPuntos);
                        Ctrl_Cliente.actualizarPuntos(cliente.getID(), Ctrl_Cliente.clacularPuntos(cliente.getRango(), total));
                        idCliente = cliente.getID() + "";
                    }
                    Ctrl_RegistrarVenta.generarTicket(id, getTabla(), total, subtotal, descuento, iva, idCliente);
                    JOptionPane.showMessageDialog(this, "<html><h1>Cambio</n><font size='14'> $" + (Math.round(cambio*100.0)/100.0 )+ "</font></html>", "Comprá finalizada", 1);

                } catch (Exception e) {
                    System.out.println(e);
                }

                limpiar();
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese una cantidad superior o igual al monto total", "Pago insuficiente", 0);
            
            pago=0;
            txt_efectivo.setText("");}

        } else {
            JOptionPane.showMessageDialog(this, "No hay prodcutos en la lista de compras", "Lista vacia", 2);

        }

    }

    void reset() {
        factura = null;

    }

    void RetenerProduto(String C_Barras, int cantidad) {
        Ctrl_Producto ctrlProducto = new Ctrl_Producto();

        if (ctrlProducto.existe(C_Barras)) {
            Producto produto = ctrlProducto.getProducto(C_Barras);
            int indexProdcuto = buscarEnLista(produto);
            if (indexProdcuto >= 0) {
                if ((cantidad + lista.get(indexProdcuto).getCantidad()) <= produto.getStock()) {
                    cantidad = cantidad + lista.get(indexProdcuto).getCantidad();
                    lista.get(indexProdcuto).setCantidad(cantidad);
                    indexProdcuto=-1;
                } else {
                    JOptionPane.showMessageDialog(this, "Productos insuficientes.\nRstante: " + produto.getStock());
                }

            } else {
                if (cantidad <= produto.getStock()) {
                    ProductosVendidos venimia = new ProductosVendidos();
                    venimia.setCantidad(cantidad);
                    venimia.setProdcuto(produto.getID());
                    listaProductos.add(produto);
                    lista.add(venimia);

                } else {
                    JOptionPane.showMessageDialog(this, "Productos insuficientes.\nRstante: " + produto.getStock());
                }
            }
            indexProdcuto=-1;
        } else {
            JOptionPane.showMessageDialog(this, "Prodcuto no existe");
        }

        subtotal = 0;
        descuento = 0;
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).setSubTotal((lista.get(i).getCantidad() * listaProductos.get(i).getPrecio()) - (lista.get(i).getCantidad() * ctrlProducto.descuentoPorFecha(listaProductos.get(i))));
            lista.get(i).setDescuento(lista.get(i).getCantidad() * ctrlProducto.descuentoPorFecha(listaProductos.get(i)));
            subtotal = subtotal + lista.get(i).getSubTotal();
            descuento = descuento + lista.get(i).getDescuento();
        }
        iva = subtotal * .16f;

        if (clienteActivo) {
            descuento = descuento + Ctrl_Cliente.descuentoPorRango(cliente.getRango(), subtotal);
        }
        total = subtotal - descuento;
        txt_descuento.setText(descuento + "");
        txt_iva.setText(iva + "");
        txt_total_pagar.setText(total + "");
        txt_subtotal.setText(subtotal + "");
        this.jTable_productos.setModel(getTabla());
    }

    /**
     *
     * @return
     */
    public DefaultTableModel getTabla() {
        DefaultTableModel model = new DefaultTableModel();

        String fila[] = new String[7];
        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("Cantidad");
        model.addColumn("Precio");

        model.addColumn("Descuento");
        model.addColumn("Subtotal");
        for (ProductosVendidos i : lista) {

        }
        for (int i = 0; i < lista.size(); i++) {

            fila[0] = i + "";
            fila[1] = listaProductos.get(i).getNombre();
            fila[2] = lista.get(i).getCantidad() + "";
            fila[3] = listaProductos.get(i).getPrecio() + "";
            fila[4] = lista.get(i).getDescuento() + "";
            fila[5] = lista.get(i).getCantidad() * listaProductos.get(i).getPrecio() + "";
            model.addRow(fila);
        }

        return model;
    }

    /**
     *
     * @param p
     * @return
     */
    public int buscarEnLista(Producto p) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getProdcuto() == p.getID()) {
                return i;
            }
        }
        return -1;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_RegistrarVenta;
    private javax.swing.JButton jButton_añadir_producto;
    private javax.swing.JButton jButton_busca_cliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JLabel label_Id_Cliente;
    private javax.swing.JLabel label_Nombre_cliente;
    private javax.swing.JLabel label_RangoCliente;
    private javax.swing.JLabel label_dinero;
    private javax.swing.JPanel panelCliente;
    private javax.swing.JTextField txt_Cantidad;
    private javax.swing.JTextField txt_Producto;
    private javax.swing.JTextField txt_cliente_buscar1;
    private javax.swing.JTextField txt_descuento;
    private javax.swing.JTextField txt_efectivo;
    private javax.swing.JTextField txt_iva;
    private javax.swing.JTextField txt_subtotal;
    public static javax.swing.JTextField txt_total_pagar;
    // End of variables declaration//GEN-END:variables

}
