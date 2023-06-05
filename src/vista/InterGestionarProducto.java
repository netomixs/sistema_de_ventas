package vista;

import vista.Componentes.VistaFormInterfaz;
import vista.Componentes.DoublePositivoDocumentFilter;
import vista.Componentes.EnteroPositivoDocumentFilter;
import controlador.Ctrl_Lote;
import controlador.Ctrl_Producto;
import controlador.Ctrl_TipoProducto;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import modelo.Lote;
import modelo.Producto;
import modelo.TIpo_Producto;

/**
 * Formulario para visualizar productos
 * Y seleccionar productos para la eliminacion y la modificacion
 * @author Ernesto
 * 
 */
public class InterGestionarProducto extends javax.swing.JInternalFrame implements VistaFormInterfaz<Producto> {
    Ctrl_Producto ctrlProductos=new Ctrl_Producto();
    Ctrl_Lote ctrlLote=new Ctrl_Lote();
    private int idProducto;
    int obtenerIdCategoriaCombo = 0;
    Producto producto;
    int indexSeleccioado;
    List<TIpo_Producto> lista;

    /**
     *
     */
    public InterGestionarProducto() {
        initComponents();
        this.setSize(new Dimension(940, 500));
        this.setTitle("Gestionar Productos");

        lista = Ctrl_TipoProducto.getAll();
        cargarTiposProductos();
        cargarTabla();
        //Evitar que se ingresen valores negativos no enteros que no sean mas de 11 caractres a el campo de cantidad
        PlainDocument doc = (PlainDocument) txt_cantidad.getDocument();
        doc.setDocumentFilter(new EnteroPositivoDocumentFilter(11));
        txt_cantidad.setDocument(doc);
        //Evitar que se ingresen valores negativos del tipo souble que no sean mas de 11 caractres a el campo de cantidad
        doc = (PlainDocument) txt_precio.getDocument();
        doc.setDocumentFilter(new DoublePositivoDocumentFilter(11));
        //Restriccion de caractres
        limitarLongitudCampo(txt_Barra, 20);
        limitarLongitudCampo(txt_descripcion, 200);
        limitarLongitudCampo(txt_lote, 10);
        limitarLongitudCampo(txt_nombre, 50);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        txt_lote = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        comBox_Tipo = new javax.swing.JComboBox<>();
        txt_precio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_Barra = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        label_busqueda = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
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
        jScrollPane1.setViewportView(jTable_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 730, 270));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton_actualizar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/img/edit_modify_icon_149489.png"))); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.setDoubleBuffered(true);
        jButton_actualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton_actualizar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton_actualizar.setIconTextGap(0);
        jButton_actualizar.setMaximumSize(new java.awt.Dimension(142, 54));
        jButton_actualizar.setMinimumSize(new java.awt.Dimension(142, 54));
        jButton_actualizar.setPreferredSize(new java.awt.Dimension(142, 54));
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_actualizar);

        jButton_eliminar.setBackground(new java.awt.Color(255, 51, 51));
        jButton_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/img/trash_bin_icon-icons.com_67981.png"))); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.setPreferredSize(new java.awt.Dimension(142, 54));
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_eliminar);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 160, 270));
        jPanel2.getAccessibleContext().setAccessibleDescription("");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Cantidad:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Precio:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Descripcion:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Lote:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 90, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Categoria:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 90, -1));

        txt_cantidad.setEditable(false);
        txt_cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_cantidad.setEnabled(false);
        jPanel3.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 170, -1));

        txt_lote.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_lote, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 170, -1));

        txt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 170, -1));

        comBox_Tipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comBox_Tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comBox_TipoActionPerformed(evt);
            }
        });
        jPanel3.add(comBox_Tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 170, -1));

        txt_precio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 170, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Codigo de barras:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 140, -1));

        txt_Barra.setEditable(false);
        txt_Barra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_Barra.setEnabled(false);
        jPanel3.add(txt_Barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 130));

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5);
        flowLayout1.setAlignOnBaseline(true);
        jPanel4.setLayout(flowLayout1);

        label_busqueda.setMinimumSize(new java.awt.Dimension(64, 25));
        label_busqueda.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel4.add(label_busqueda);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemaDeventas1/src/img/search-svgrepo-com.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 230, 40));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh-icon (1).png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed

        actualizar();
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void comBox_TipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comBox_TipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comBox_TipoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Ctrl_Producto.buscarEnJTable(this.label_busqueda.getText(), jTable_productos);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_jButton2ActionPerformed
 
    /**
     *
     * @param e
     */
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        boolean ctrlPressed = e.isControlDown();
        if (ctrlPressed && keyCode == KeyEvent.VK_Q) {
            // Llamar al método que se quiere ejecutar
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comBox_Tipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField label_busqueda;
    private javax.swing.JTextField txt_Barra;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_lote;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables

    /*
     * *****************************************************
     * metodo para limpiar
     * *****************************************************
     */
    /**
     * Elimina todo el texto de los campos de texto
     */
    @Override
    public void limpiarCampos() {
        // Limpiar los campos de texto
        txt_nombre.setText("");
        txt_descripcion.setText("");
        txt_precio.setText("");
        txt_cantidad.setText("");
        txt_lote.setText("");
        txt_Barra.setText("");

// Limpiar el JComboBox
        comBox_Tipo.setSelectedIndex(0);

    }

    /**
     * Llena los campo de texto con los datos recuperados de la celda
     * seleccionada de la tabla
     *
     * @param producto
     */
    @Override
    public void llenarCampos(Producto producto) {
        this.txt_Barra.setText(producto.getC_Barras());
        this.txt_cantidad.setText(Integer.toString(producto.getStock()));
        this.txt_descripcion.setText(producto.getDescripcion());
        this.txt_lote.setText(ctrlLote.get(producto.getLoteID()).getSerie());
        this.txt_nombre.setText(producto.getNombre());
        this.txt_precio.setText(Float.toString(producto.getPrecio()));
        this.comBox_Tipo.setSelectedIndex(Ctrl_TipoProducto.getIndex(producto.getTipo())); // Si el JComboBox está lleno con objetos de tipo Tipo_Producto, debes pasarle el objeto Tipo_Producto correspondiente a este producto
    }

    /**
     * Recupera los datos de los campos de texto y los fomatea para guadarlo en
     * el modelo
     */
    @Override
    public void recuperarCampos() {
        producto = new Producto();
        try {

// Obtener los valores de los campos de texto
            String nombre = txt_nombre.getText();
            String descripcion = txt_descripcion.getText();
            String precioString = txt_precio.getText();
            float precio = Float.parseFloat(precioString);
            String cantidadString = txt_cantidad.getText();
            int cantidad = Integer.parseInt(cantidadString);
            String loteString = txt_lote.getText();
            Lote l = ctrlLote.get(loteString);
            int lote = 0;
            if (l != null) {
                lote = l.getID();

            }
            String codigoBarras = txt_Barra.getText();
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);
            producto.setStock(cantidad);
            producto.setLoteID(lote);
            producto.setC_Barras(codigoBarras);
            producto.setTipo(lista.get(comBox_Tipo.getSelectedIndex()).getID());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Formato de valores numericos no valido");
        }
// Obtener el tipo de producto seleccionado en el JComboBox

// Establecer los valores obtenidos en el objeto Producto
    }

    /**
     * Retorna true si lox campos contienen texto y false si no
     *
     * @return
     */
    @Override
    public boolean camposVacios() {

        return txt_Barra.getText().isEmpty()
               || txt_cantidad.getText().isEmpty()
                 || txt_descripcion.getText().isEmpty()
                 ||txt_lote.getText().isEmpty()
                 ||txt_nombre.getText().isEmpty()
                 || txt_precio.getText().isEmpty() || comBox_Tipo.getSelectedItem() == null;
    }

    /**
     *
     */
    public void cargarTiposProductos() {

        for (TIpo_Producto tipo : lista) {
            this.comBox_Tipo.addItem(tipo.getTipo());
        }
    }

// Crear un filtro de documento para limitar la cantidad de caracteres
    /**
     * Limita los caracteres permitidos en un campo de texto
     *
     * @param campo
     * @param maxChars
     */
    @Override
    public void limitarLongitudCampo(JTextField campo, int maxChars) {
        PlainDocument doc = (PlainDocument) campo.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException {
                if ((fb.getDocument().getLength() + str.length()) <= maxChars) {
                    super.insertString(fb, offs, str, a);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offs, int length, String str, AttributeSet a) throws BadLocationException {
                if ((fb.getDocument().getLength() + str.length() - length) <= maxChars) {
                    super.replace(fb, offs, length, str, a);
                }
            }
        });
    }

    /**
     * Carga kis datos de la base de datos
     */
    @Override
    public void cargarTabla() {
        DefaultTableModel datos = ctrlProductos.getTabla();

        this.jTable_productos.setModel(datos);
        addEventoTabla(jTable_productos);
    }

    /**
     * Recupera los datos de la base de datos
     */
    @Override
    public void actualizarTabla() {
        DefaultTableModel datos = ctrlProductos.getTabla();
        this.jTable_productos.setModel(datos);
        addEventoTabla(jTable_productos);
    }

    /**
     * Agrega un evento a la tabla que cuado se toca la tabla seleccione la fila
     * cliqueada
     *
     * @param tabla
     */
    @Override
    public void addEventoTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        ListSelectionModel modeloSeleccion = tabla.getSelectionModel();
        modeloSeleccion.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    desBloquerCampos();
                    activarBoton();
                    recupararIndexDeTabla();
                }
            }
        });
    }

    /**
     * Recupera el indice seleccionado de la tabla y ejecuta el metodo para
     * recuperar los datos del producto
     */
    @Override
    public void recupararIndexDeTabla() {
        indexSeleccioado = jTable_productos.getSelectedRow();
        if (indexSeleccioado >= 0) {
            String columna0 = jTable_productos.getValueAt(indexSeleccioado, 0).toString();
            int ID = Integer.parseInt(columna0);
            producto = ctrlProductos.getProducto(ID);
            llenarCampos(producto);
        }

    }

    /**
     * Se ejectua al precionar el boton actualizar
     */
    @Override
    public void actualizar() {

        boolean lote = ctrlLote.existe(txt_lote.getText());
        if (!lote) {
            JOptionPane.showMessageDialog(this, "Lote no existe");
        }
        if (camposVacios()) {
            JOptionPane.showMessageDialog(this, "No deje campos vacios");
        } else {
            recuperarCampos();
            if (lote) {
                if (ctrlProductos.Actualizar(producto)) {
                    JOptionPane.showMessageDialog(this, "Prodcuto actualizado");
                    actualizarTabla();
                    limpiarCampos();
                }
            }

        }
    }

    /**
     * metodo que se ejecuta al precionar el boton de eliminar
     */
    @Override
    public void eliminar() {

        if (ctrlProductos.Eliminar(producto.getID())) {
            indexSeleccioado = -1;
            activarBoton();
            limpiarCampos();
            actualizarTabla();
        }
    }

    /**
     * Activa los botones de actualizar y eliminar al detectar que se selecciono
     * un elemento de la tabla
     */
    @Override
    public void activarBoton() {
        if (indexSeleccioado >= 0) {
            jButton_actualizar.setEnabled(true);
            jButton_eliminar.setEnabled(true);
        } else {
            jButton_actualizar.setEnabled(false);
            jButton_eliminar.setEnabled(false);
        }
    }

    /**
     * Bloque los campos de entrada de texto
     */
    @Override
    public void bloquerCampos() {
        txt_Barra.setEnabled(false);
        txt_cantidad.setEnabled(false);
        txt_descripcion.setEnabled(false);
        txt_lote.setEnabled(false);
        txt_nombre.setEnabled(false);
        txt_precio.setEnabled(false);
        comBox_Tipo.setEnabled(false);
    }

    /**
     * Desbloque los campos de texto que se permiten editar
     */
    @Override
    public void desBloquerCampos() {
        txt_Barra.setEnabled(false);
        txt_cantidad.setEnabled(false);
        txt_descripcion.setEnabled(true);
        txt_lote.setEnabled(true);
        txt_nombre.setEnabled(true);
        txt_precio.setEnabled(true);
        comBox_Tipo.setEnabled(true);
    }
}
