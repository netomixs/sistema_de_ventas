package vista;

import controlador.Ctrl_Cajero;
import controlador.Ctrl_Lote;

import controlador.Ctrl_Producto;
import controlador.Ctrl_TipoProducto;
import java.awt.Dimension;
import java.util.Date;
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
import modelo.Categoria;
import modelo.Lote;
import modelo.Producto;
import modelo.TIpo_Producto;
import static vista.InterGestionarCajeros.jTable_Cajeros;

/**
 *
 * @author ediso
 */
public class InterGestionarLotes extends javax.swing.JInternalFrame implements VistaFormInterfaz<Lote>{
    
    private int idProducto;
    int obtenerIdCategoriaCombo = 0;
    Lote lote;
    int indexSeleccioado;
    
    public InterGestionarLotes() {
        initComponents();
        this.setSize(new Dimension(900, 500));
        this.setTitle("Gestionar Productos");
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Lote = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_Serie = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jDate_Retiro = new com.toedter.calendar.JDateChooser();
        jDate_Llegada = new com.toedter.calendar.JDateChooser();
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

        jTable_Lote.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_Lote);

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
        jPanel2.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, 100, 32));

        jButton_eliminar.setBackground(new java.awt.Color(255, 51, 51));
        jButton_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.setEnabled(false);
        jButton_eliminar.setFocusable(false);
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 80, 100, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 130, 270));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Serie:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Llegada:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 90, -1));

        txt_Serie.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_Serie.setEnabled(false);
        jPanel3.add(txt_Serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 170, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Retiro:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 140, -1));
        jPanel3.add(jDate_Retiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 170, -1));

        jDate_Llegada.setEnabled(false);
        jPanel3.add(jDate_Llegada, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 130));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        actualizar();

    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
       eliminar();
    }//GEN-LAST:event_jButton_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private com.toedter.calendar.JDateChooser jDate_Llegada;
    private com.toedter.calendar.JDateChooser jDate_Retiro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_Lote;
    private javax.swing.JTextField txt_Serie;
    // End of variables declaration//GEN-END:variables

    /*
     * *****************************************************
     * metodo para limpiar
     * *****************************************************
     */
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
        DefaultTableModel datos = Ctrl_Lote.getTabla();
        
        this.jTable_Lote.setModel(datos);
         addEventoTabla(jTable_Lote);
    }
    
    public void actualizarTabla() {
        DefaultTableModel datos = Ctrl_Cajero.getTablaCajeros();
        this.jTable_Lote.setModel(datos);
        addEventoTabla(jTable_Lote);
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
        lote = Ctrl_Lote.getLote(ID);
        llenarCampos(lote);
    }

    public void llenarCampos(Lote lote) {
        this.jDate_Llegada.setDate(lote.getFechaLLegada());
        this.jDate_Llegada.setDate(lote.getFechaRetiro());
        this.txt_Serie.setText(lote.getSerie());
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
        this.jDate_Llegada.setEnabled(false);
        this.jDate_Retiro.setEnabled(false);
        this.txt_Serie.setEnabled(false);
    }
    
    public void desBloquerCampos() {
        this.jDate_Llegada.setEnabled(true);
        this.jDate_Retiro.setEnabled(true);
        this.txt_Serie.setEnabled(true);
    }
    
    public boolean camposVacios() {
        return jDate_Llegada.getDate() == null || jDate_Retiro.getDate() == null || txt_Serie.getText().isEmpty();
    }
    
    public void recuperarCampos() {
        // Crear objeto de la clase Lote
        lote = new Lote();

        // Obtener fecha de llegada
        Date fechaLlegada = jDate_Llegada.getDate();
        lote.setFechaLLegada(fechaLlegada);

        // Obtener fecha de retiro
        Date fechaRetiro = jDate_Retiro.getDate();
        lote.setFechaRetiro(fechaRetiro);

        // Obtener serie
        String serie = txt_Serie.getText();
        lote.setSerie(serie);
    }
    
    boolean isDateOK(Date a, Date b) {

// Verificar que la fecha de llegada sea menor a la fecha de retiro
        if (a != null && b != null && a.before(b)) {
            // La fecha de llegada es menor a la fecha de retiro, hacer algo
            return true;
        } else {
            return false;
            // La fecha de llegada no es menor a la fecha de retiro, mostrar un mensaje de error o hacer algo
        }
    }
    
    public void actualizar() {
        if (camposVacios()) {
            JOptionPane.showMessageDialog(this, "No deje campos vacios");
        } else {
            recuperarCampos();
            if (Ctrl_Lote.Actualizar(lote)) {
                JOptionPane.showMessageDialog(this, "Lote actualizado");
                limpiarCampos();
                actualizarTabla();
            }
        }
    }
        
    public void eliminar() {
        
        if (Ctrl_Producto.Eliminar(lote.getID())) {
            indexSeleccioado = -1;
            activarBoton();
            limpiarCampos();
        }
    }
    
    public void limpiarCampos() {
        jDate_Llegada.setDate(null);
        jDate_Retiro.setDate(null);
        txt_Serie.setText("");
    }

    
 
 
}
