package vista;

import conexion.Conexion;
import controlador.Ctrl_Cajero;

import controlador.Ctrl_Producto;
import controlador.Ctrl_TipoProducto;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
import modelo.Categoria;
import modelo.Producto;
import modelo.TIpo_Producto;
import static vista.InterGestionarCajeros.jTable_Cajeros;

/**
 *
 * @author ediso
 */
public class InterGestionarProducto extends javax.swing.JInternalFrame implements VistaFormInterfaz<Producto> {

    private int idProducto;
    int obtenerIdCategoriaCombo = 0;
    Producto producto;
    int indexSeleccioado;

    public InterGestionarProducto() {
        initComponents();
        this.setSize(new Dimension(900, 500));
        this.setTitle("Gestionar Productos");
        cargarTiposProductos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
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
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Administrar Productos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

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
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_actualizar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, 100, 32));

        jButton_eliminar.setBackground(new java.awt.Color(255, 51, 51));
        jButton_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 60, 100, 32));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 130, 270));

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

        txt_cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_cantidad.setEnabled(false);
        jPanel3.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 170, -1));

        txt_lote.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_lote, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 170, -1));

        txt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 170, -1));

        comBox_Tipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(comBox_Tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 170, -1));

        txt_precio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 170, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Codigo de barras:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 140, -1));

        txt_Barra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_Barra.setEnabled(false);
        jPanel3.add(txt_Barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 130));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed

        actualizar();
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed

    }//GEN-LAST:event_jButton_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<TIpo_Producto> comBox_Tipo;
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
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

    public void llenarCampos(Producto producto) {
        this.txt_Barra.setText(producto.getC_Barras());
        this.txt_cantidad.setText(Integer.toString(producto.getStock()));
        this.txt_descripcion.setText(producto.getDescripcion());
        this.txt_lote.setText(Integer.toString(producto.getLote()));
        this.txt_nombre.setText(producto.getNombre());
        this.txt_precio.setText(Float.toString(producto.getPrecio()));
        this.comBox_Tipo.setSelectedIndex(producto.getTipo()); // Si el JComboBox está lleno con objetos de tipo Tipo_Producto, debes pasarle el objeto Tipo_Producto correspondiente a este producto
    }

    public void recuperarCampos() {
        producto = new Producto();

// Obtener los valores de los campos de texto
        String nombre = txt_nombre.getText();
        String descripcion = txt_descripcion.getText();
        String precioString = txt_precio.getText();
        float precio = Float.parseFloat(precioString);
        String cantidadString = txt_cantidad.getText();
        int cantidad = Integer.parseInt(cantidadString);
        String loteString = txt_lote.getText();
        int lote = Integer.parseInt(loteString);
        String codigoBarras = txt_Barra.getText();

// Obtener el tipo de producto seleccionado en el JComboBox
        TIpo_Producto tipoSeleccionado = (TIpo_Producto) comBox_Tipo.getSelectedItem();
        int tipo = tipoSeleccionado.getID();

// Establecer los valores obtenidos en el objeto Producto
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setStock(cantidad);
        producto.setLote(lote);
        producto.setC_Barras(codigoBarras);
        producto.setTipo(tipo);

    }

    public boolean camposVacios() {
        return txt_Barra.getText().isEmpty()
                && txt_cantidad.getText().isEmpty()
                && txt_descripcion.getText().isEmpty()
                && txt_lote.getText().isEmpty()
                && txt_nombre.getText().isEmpty()
                && txt_precio.getText().isEmpty() && comBox_Tipo.getSelectedItem() == null;
    }

    public void cargarTiposProductos() {
        List<TIpo_Producto> lista = Ctrl_TipoProducto.getAll();
        for (TIpo_Producto i : lista) {
            comBox_Tipo.addItem(i);
        }

    }
    PlainDocument doc = (PlainDocument) txt_nombre.getDocument();

// Crear un filtro de documento para limitar la cantidad de caracteres
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

    public void cargarTabla() {
        DefaultTableModel datos = Ctrl_Producto.getTabla();

        this.jTable_productos.setModel(datos);
        addEventoTabla(jTable_productos);
    }

    public void actualizarTabla() {
        DefaultTableModel datos = Ctrl_Producto.getTabla();
        this.jTable_productos.setModel(datos);
        addEventoTabla(jTable_productos);
    }

    public void addEventoTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        ListSelectionModel modeloSeleccion = tabla.getSelectionModel();
        modeloSeleccion.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    desBloquerCampos();
                    activarBoton();
                }
            }
        });
    }

    public void recupararIndexDeTabla() {
        indexSeleccioado = jTable_Cajeros.getSelectedRow();
        String columna0 = jTable_Cajeros.getModel().getValueAt(indexSeleccioado, 3).toString();
        int ID = Integer.parseInt(columna0);
        producto = Ctrl_Producto.getProducto(ID);
        llenarCampos(producto);
    }

    public void actualizar() {

        if (camposVacios()) {
            JOptionPane.showMessageDialog(this, "No deje campos vacios");
        } else {
            recuperarCampos();
            if (Ctrl_Producto.Actualizar(producto)) {
                JOptionPane.showMessageDialog(this, "Prodcuto actualizado");
                actualizarTabla();
                limpiarCampos();
            }
        }
    }

    public void eliminar() {

        if (Ctrl_Producto.Eliminar(producto.getID())) {
            indexSeleccioado = -1;
            activarBoton();
            limpiarCampos();
            actualizarTabla();
        }
    }

    public void activarBoton() {
        if (indexSeleccioado >= 0) {
            jButton_actualizar.setEnabled(true);
            jButton_eliminar.setEnabled(true);
        } else {
            jButton_actualizar.setEnabled(false);
            jButton_eliminar.setEnabled(false);
        }
    }

    public void bloquerCampos() {
        txt_Barra.setEnabled(false);
        txt_cantidad.setEnabled(false);
        txt_descripcion.setEnabled(false);
        txt_lote.setEnabled(false);
        txt_nombre.setEnabled(false);
        txt_precio.setEnabled(false);
        comBox_Tipo.setEnabled(false);
    }

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
