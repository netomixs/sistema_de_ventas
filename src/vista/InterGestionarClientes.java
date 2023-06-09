package vista;

import conexion.Conexion;
import controlador.Ctrl_Admin;
import controlador.Ctrl_Cajero;
import controlador.Ctrl_Cliente;
import controlador.Ctrl_Producto;
import java.awt.Dimension;
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
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.plaf.DesktopPaneUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Cajero;
import modelo.Cliente;

/**
 *
 * @author ediso
 */
public class InterGestionarClientes extends javax.swing.JInternalFrame {

    InterEditarCajero editCajero;
    private int idCliente;
    private int indexSelecionado = -1;
    List<Cliente> listaClientes;
    JDesktopPane desk;
   
    public InterGestionarClientes(JDesktopPane desk) {
        this.desk = desk;
        initComponents();
        this.setSize(new Dimension(940, 500));
        this.setTitle("Gestionar clientes");
        this.repaint();
        DefaultTableModel datos = Ctrl_Cliente.getTabla();
        this.jTable_clientes.setModel(datos);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                jInternalFrame1InternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
    }

    private void jInternalFrame1InternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
        this.dispose();
        if (editCajero != null) {
            editCajero.setVisible(false);
            desk.remove(editCajero);
        }

    }
 
    void actualizarTabla() {
        DefaultTableModel datos = Ctrl_Cliente.getTabla();
        this.jTable_clientes.setModel(datos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_clientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        label_busqueda = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_clientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_clientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 710, 370));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 730, 390));

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5);
        flowLayout1.setAlignOnBaseline(true);
        jPanel2.setLayout(flowLayout1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh-icon (1).png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        label_busqueda.setMinimumSize(new java.awt.Dimension(64, 25));
        label_busqueda.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel2.add(label_busqueda);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemaDeventas1/src/img/search-svgrepo-com.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 280, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jButton_actualizar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/img/edit_modify_icon_149489.png"))); // NOI18N
        jButton_actualizar.setText("Modificar");
        jButton_actualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton_actualizar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton_actualizar.setPreferredSize(new java.awt.Dimension(142, 54));
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_actualizar);

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
        jPanel3.add(jButton_eliminar);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 160, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
 
        String opcioes[] = {"Si", "No"};
         if (indexSelecionado >= 0) {
            int op = JOptionPane.showOptionDialog(this, "¿Esta seguro de esta acción?", "¿Eliminar?", JOptionPane.OK_OPTION, 0, null, opcioes, false);
         if (op == 0) {
            //Si
            Cliente cliente = new Cliente();
                String clave = jTable_clientes.getValueAt(indexSelecionado, 0).toString();
               
                System.out.println(clave);
                cliente = Ctrl_Cliente.get(Integer.parseInt(clave));
                Ctrl_Cliente.eliminar(cliente);
                actualizarTabla();

        } else {
            //No
        }
               
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un cajero");
            }
  
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed

        if (indexSelecionado >= 0) {
            String clave = jTable_clientes.getModel().getValueAt(indexSelecionado, 0).toString();
            System.out.println(clave);
            InterEditarCliente editCliente = new InterEditarCliente(Integer.parseInt(clave));
            desk.add(editCliente);
            editCliente.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente");
        }


    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jTable_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_clientesMouseClicked
        indexSelecionado = jTable_clientes.getSelectedRow();
        System.out.println(indexSelecionado);

    }//GEN-LAST:event_jTable_clientesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Ctrl_Producto.buscarEnJTable(this.label_busqueda.getText(), jTable_clientes);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_clientes;
    private javax.swing.JTextField label_busqueda;
    // End of variables declaration//GEN-END:variables

}
