package vista;

import controlador.Ctrl_Cajero;
import controlador.Ctrl_Lote;
import controlador.Ctrl_Producto;
import controlador.Ctrl_TipoProducto;
import java.awt.Dimension;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import modelo.Lote;
import modelo.TIpo_Producto;
import static vista.InterGestionarCajeros.jTable_Cajeros;

/**
 *
 * @author ediso
 */
public class InterNuevaCategoria extends javax.swing.JInternalFrame {

    TIpo_Producto tipo;
    private int indexSeleccioado;

    public InterNuevaCategoria() {
        initComponents();
         
        this.setTitle("Nueva Categoria");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        jButton_actualizar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Nuevo tipo de producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tipo de producto:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 120, -1));

        jButton_actualizar.setBackground(new java.awt.Color(0, 0, 255));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 110, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 260, 270));

        jButton2.setBackground(new java.awt.Color(0, 255, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 110, 30));

        jButton_eliminar.setBackground(new java.awt.Color(255, 0, 0));
        jButton_eliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 110, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        actualizar();
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       registrar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
     eliminar();
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    public boolean camposVacios() {
        return txt_descripcion.getText().isEmpty();
    }

    void recuperarCampos() {
        tipo = new TIpo_Producto();
        tipo.setTipo(txt_descripcion.getText());
    }

    void registrar() {
        if (camposVacios()) {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos");
            if (Ctrl_TipoProducto.existe(tipo.getTipo())) {
                JOptionPane.showMessageDialog(this, "Ya existe un nombre igual");
            } else {
                if (Ctrl_TipoProducto.Crear(tipo.getTipo())) {
                    JOptionPane.showMessageDialog(this, "Registro existoso");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Error");
                }
            }
        }
    }

    private void limpiarCampos() {
        txt_descripcion.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField txt_descripcion;
    // End of variables declaration//GEN-END:variables
   void recupararIndexDeTabla() {
        indexSeleccioado = jTable_Cajeros.getSelectedRow();
        String columna0 = jTable_Cajeros.getModel().getValueAt(indexSeleccioado, 3).toString();
        int ID = Integer.parseInt(columna0);
        tipo =Ctrl_TipoProducto.getTipo(ID);
        llenarCampos(tipo);
    }

    void actualizar() {

        if (CamposVacios()) {
            JOptionPane.showMessageDialog(this, "No deje campos vacios");
        } else {
            recuperarCampos();
            if (Ctrl_TipoProducto.Actualizar(tipo.getID(), tipo.getTipo())) {
                JOptionPane.showMessageDialog(this, "Prodcuto actualizado");
                actualizarTabla();
                limpiarCampos();
            }
        }
    }

    void eliminar() {

        if (Ctrl_TipoProducto.Elimniar(tipo.getID()) ){
            indexSeleccioado = -1;
            activarBoton();
            limpiarCampos();
            actualizarTabla();
        }
    }

    void activarBoton() {
        if (indexSeleccioado >= 0) {
            jButton_actualizar.setEnabled(true);
            jButton_eliminar.setEnabled(true);
        } else {
            jButton_actualizar.setEnabled(false);
            jButton_eliminar.setEnabled(false);
        }
    }

    void bloquerCampos() {

        txt_descripcion.setEnabled(false);

    }

    void desBloquerCampos() {
        txt_descripcion.setEnabled(true);
    }

    void cargarTabla() {
        DefaultTableModel datos = Ctrl_Producto.getTabla();

        this.jTable_productos.setModel(datos);
        addEventoTabla(jTable_productos);
    }

    void actualizarTabla() {
        DefaultTableModel datos = Ctrl_TipoProducto.getTabla();
        this.jTable_productos.setModel(datos);
         addEventoTabla(jTable_productos);
    }

    private boolean CamposVacios() {
        return txt_descripcion.getText().isEmpty();
    }

    private void llenarCampos(TIpo_Producto tipo) {
        txt_descripcion.setText(tipo.getTipo());
     }
        void addEventoTabla(JTable tabla) {
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
}
