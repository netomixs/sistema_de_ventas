package vista;

import vista.Componentes.DoublePositivoDocumentFilter;
import vista.Componentes.EnteroPositivoDocumentFilter;
import controlador.Ctrl_Lote;
import controlador.Ctrl_Producto;
import controlador.Ctrl_TipoProducto;
import java.awt.Dimension;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import modelo.Lote;
import modelo.Producto;
import modelo.TIpo_Producto;

/**
 *
 * @author ediso
 */
public class InterNuevoProducto extends javax.swing.JInternalFrame {

    Producto producto;
    List<TIpo_Producto> lista;

    public InterNuevoProducto() {
        PlainDocument doc;
        lista = Ctrl_TipoProducto.getAll();
        initComponents();
        this.setSize(new Dimension(421, 383));
        this.setTitle("Nuevo Producto");
       
        //Evitar que se ingresen valores negativos no enteros que no sean mas de 11 caractres a el campo de cantidad
        doc = (PlainDocument) txt_cantidad.getDocument();
        doc.setDocumentFilter(new EnteroPositivoDocumentFilter(11));
        txt_cantidad.setDocument(doc);
        //Evitar que se ingresen valores negativos del tipo souble que no sean mas de 11 caractres a el campo de cantidad
        doc=(PlainDocument) txt_precio.getDocument();
        doc.setDocumentFilter(new DoublePositivoDocumentFilter(11));
        //Restriccion de caractres
         limitarLongitudCampo(txt_Barra, 20);
        limitarLongitudCampo(txt_descripcion1, 200);
        limitarLongitudCampo(txt_lote, 10);
        limitarLongitudCampo(txt_nombre, 50);
        cargarTiposProductos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        txt_Barra = new javax.swing.JTextField();
        jButton_Guardar = new javax.swing.JButton();
        txt_descripcion1 = new javax.swing.JTextField();
        comBox_Tipo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txt_lote = new javax.swing.JTextField();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Nuevo Producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Cantidad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Precio:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Descripcion:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Serie de lote:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 110, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Categorias:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 90, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 170, -1));

        txt_cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 170, -1));

        txt_precio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_precioActionPerformed(evt);
            }
        });
        getContentPane().add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 170, -1));

        txt_Barra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_Barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 170, -1));

        jButton_Guardar.setBackground(new java.awt.Color(129, 221, 37));
        jButton_Guardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Guardar.setText("Guardar");
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 90, 30));

        txt_descripcion1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_descripcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 170, -1));

        getContentPane().add(comBox_Tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 170, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Codigo de producto:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 150, -1));

        txt_lote.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_lote, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 170, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarActionPerformed
        registrar();
    }//GEN-LAST:event_jButton_GuardarActionPerformed

    private void txt_precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_precioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comBox_Tipo;
    private javax.swing.JButton jButton_Guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txt_Barra;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_descripcion1;
    private javax.swing.JTextField txt_lote;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
     /**
     *
     * Metodo para limpiar campos
     */
    void registrar() {
        Ctrl_Producto ctrlProducto=new Ctrl_Producto();
        Ctrl_Lote ctrLote=new Ctrl_Lote();
        if (camposVacios()) {
            JOptionPane.showMessageDialog(this, "Rellena todos los campos");

        } else {
            recuperarCampos();
            if (ctrlProducto.existe(producto.getC_Barras())) {
                JOptionPane.showMessageDialog(this, "El codigo de barras asociado ya existe");
            } else {
                if (ctrLote.existe(this.txt_lote.getText())) {
                    if (ctrlProducto.Crear(producto)) {
                        JOptionPane.showMessageDialog(this, "Prodcuto registrado");
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(this, "Prodcuto no registrado");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Lote no existe");
                }

            }
        }
    }

    private void limpiar() {
        // Limpiar los campos de texto
        txt_nombre.setText("");
        txt_descripcion1.setText("0");
        this.txt_precio.setText("0");
        txt_cantidad.setText("");
        txt_lote.setText("");
        txt_Barra.setText("");

// Limpiar el JComboBox
        comBox_Tipo.setSelectedIndex(0);

    }

    void recuperarCampos() {
        producto = new Producto();
        Ctrl_Lote ctrlLote=new Ctrl_Lote();
// Obtener los valores de los campos de texto
        String nombre = txt_nombre.getText();
        String descripcion = txt_descripcion1.getText();
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

// Establecer los valores obtenidos en el objeto Producto
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setStock(cantidad);
        producto.setLoteID(lote);
        producto.setC_Barras(codigoBarras);

        producto.setTipo(lista.get(comBox_Tipo.getSelectedIndex()).getID());

    }

    public boolean camposVacios() {
        return txt_Barra.getText().isEmpty()
               || txt_cantidad.getText().isEmpty()
                || txt_descripcion1.getText().isEmpty()
                || txt_lote.getText().isEmpty()
                || txt_nombre.getText().isEmpty()
               || txt_precio.getText().isEmpty();
    }

    private void cargarTiposProductos() {

        System.out.println(lista.get(0).getTipo());
        for (TIpo_Producto tipo : lista) {
            this.comBox_Tipo.addItem(tipo.getTipo());
        }

    }

// Crear un filtro de documento para limitar la cantidad de caracteres
    static void limitarLongitudCampo(JTextField campo, int maxChars) {
        PlainDocument doc = (PlainDocument) campo.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException {
                if ((fb.getDocument().getLength() + str.length()) <= maxChars) {
                    super.insertString(fb, offs, str, a);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a) throws BadLocationException {
                if ((fb.getDocument().getLength() + str.length() - length) <= maxChars) {
                    super.replace(fb, offs, length, str, a);
                }
            }
        });

    }

}
