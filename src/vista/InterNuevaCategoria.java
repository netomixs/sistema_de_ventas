package vista;

import vista.Componentes.FormaterJtextField;
import controlador.Ctrl_Producto;
import controlador.Ctrl_TipoProducto;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.TIpo_Producto;

/**
 *@deprecated 
 * @author ediso
 */
public class InterNuevaCategoria extends javax.swing.JInternalFrame {

    TIpo_Producto tipo;
    private int indexSeleccioado,idSeleccionado;

    /**
     *
     */
    public InterNuevaCategoria() {
        initComponents();
        actualizarTabla();
        FormaterJtextField.limitarLongitudCampo(txt_descripcion, 50);
        this.setTitle("Categorias");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.BorderLayout());

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
        jTable_productos.setMinimumSize(new java.awt.Dimension(150, 300));
        jTable_productos.setPreferredSize(null);
        jScrollPane1.setViewportView(jTable_productos);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 310, 410));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        jButton2.setBackground(new java.awt.Color(0, 255, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Agregar");
        jButton2.setMaximumSize(new java.awt.Dimension(142, 54));
        jButton2.setMinimumSize(new java.awt.Dimension(142, 54));
        jButton2.setPreferredSize(new java.awt.Dimension(142, 54));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton_actualizar.setBackground(new java.awt.Color(51, 153, 255));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.setMaximumSize(new java.awt.Dimension(142, 54));
        jButton_actualizar.setMinimumSize(new java.awt.Dimension(142, 54));
        jButton_actualizar.setPreferredSize(new java.awt.Dimension(142, 54));
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_actualizar);

        jButton_eliminar.setBackground(new java.awt.Color(255, 0, 0));
        jButton_eliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.setMaximumSize(new java.awt.Dimension(142, 54));
        jButton_eliminar.setMinimumSize(new java.awt.Dimension(142, 54));
        jButton_eliminar.setPreferredSize(new java.awt.Dimension(142, 54));
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_eliminar);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 170, 270));

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tipo de producto:");
        jPanel3.add(jLabel2);

        txt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_descripcion.setPreferredSize(new java.awt.Dimension(130, 24));
        jPanel3.add(txt_descripcion);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemaDeventas1/src/img/search-svgrepo-com.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, 50));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Ctrl_Producto.buscarEnJTable(this.txt_descripcion.getText(), jTable_productos);
    }//GEN-LAST:event_jButton1ActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField txt_descripcion;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @return
     */
     public boolean camposVacios() {
        return txt_descripcion.getText().isEmpty();
    }

    void recuperarCampos() {
        tipo = new TIpo_Producto();
        tipo.setTipo(txt_descripcion.getText());
    }

    void registrar() {
       
        if (!camposVacios()) {
           recuperarCampos();
            if (Ctrl_TipoProducto.existe(tipo.getTipo())) {
                JOptionPane.showMessageDialog(this, "Ya existe un nombre igual");
            } else {
                if (Ctrl_TipoProducto.Crear(tipo.getTipo())) {
                    JOptionPane.showMessageDialog(this, "Registro existoso");
                    limpiarCampos();
                    actualizarTabla();
                } else {
                    JOptionPane.showMessageDialog(this, "Error");
                }
            }
        }else{
              JOptionPane.showMessageDialog(this, "Rellene todos los campos");
        }
    }

    private void limpiarCampos() {
        txt_descripcion.setText("");
    }
    void recupararIndexDeTabla() {
       
        indexSeleccioado = jTable_productos.getSelectedRow();
        if(indexSeleccioado>=0){
        String columna0 = jTable_productos.getValueAt(indexSeleccioado, 0).toString();
        idSeleccionado = Integer.parseInt(columna0);
        tipo =Ctrl_TipoProducto.getTipo(idSeleccionado);
            System.out.println("Se maando a buscas el ID"+idSeleccionado);
            System.out.println("Se recupero el id"+tipo.getID());
        llenarCampos(tipo);
       }
       
       
    }

    void actualizar() {

        if (CamposVacios()) {
            JOptionPane.showMessageDialog(this, "No deje campos vacios");
        } else {
            recuperarCampos();
             
            if (Ctrl_TipoProducto.Actualizar(idSeleccionado, tipo.getTipo())) {
                System.out.println("Se actualizo el produco con IS"+tipo.getID());
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
        Ctrl_Producto ctrlProcudto=new Ctrl_Producto();
        DefaultTableModel datos = ctrlProcudto.getTabla();

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
                   recupararIndexDeTabla() ;
                }
            }
        });
    }
}
