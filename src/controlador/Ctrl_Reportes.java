/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author netom
 */
public class Ctrl_Reportes {
/**
 * abre una ventana emergente solicitando el rango de fechas
 * Posterior generar y abre un pdf con los datos solicictados
    */
    public static void solicitarRangoFechas() {
        JDateChooser fechaInicio = new JDateChooser();
        JDateChooser fechaFin = new JDateChooser();
        Object[] entradas = {"Fecha de inicio:", fechaInicio, "Fecha de fin:", fechaFin};
        int opcion = JOptionPane.showConfirmDialog(null, entradas, "Seleccione un rango de fechas", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            Date fechaInicioSeleccionada = fechaInicio.getDate();
            Date fechaFinSeleccionada = fechaFin.getDate();
            if (fechaInicioSeleccionada != null && fechaFinSeleccionada != null) {
                if (fechaInicioSeleccionada.before(fechaFinSeleccionada)) {
                    VentaPDF.generarRoporteVentas(fechaInicioSeleccionada, fechaFinSeleccionada);
                } else {
                    JOptionPane.showMessageDialog(null, "La fecha de inicio debe ser anterior a la fecha de fin");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar ambas fechas");
            }
        }
    }
    /**
 * abre una ventana emergente solicitando el rango de fechas
 * Posterior generar y abre un pdf con los datos solicictados
    */
 public static void solicitarRangoFechasClientes() {
        JDateChooser fechaInicio = new JDateChooser();
        JDateChooser fechaFin = new JDateChooser();
        Object[] entradas = {"Fecha de inicio:", fechaInicio, "Fecha de fin:", fechaFin};
        int opcion = JOptionPane.showConfirmDialog(null, entradas, "Seleccione un rango de fechas", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            Date fechaInicioSeleccionada = fechaInicio.getDate();
            Date fechaFinSeleccionada = fechaFin.getDate();
            if (fechaInicioSeleccionada != null && fechaFinSeleccionada != null) {
                if (fechaInicioSeleccionada.before(fechaFinSeleccionada)) {
                    VentaPDF.generarRoporteClientes(fechaInicioSeleccionada, fechaFinSeleccionada);
                } else {
                    JOptionPane.showMessageDialog(null, "La fecha de inicio debe ser anterior a la fecha de fin");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar ambas fechas");
            }
        }
    }
 /**
 * abre una ventana emergente solicitando el rango de fechas
 * Posterior generar y abre un pdf con los datos solicictados
    */
  public static void solicitarRangoFechasprodcutos() {
        JDateChooser fechaInicio = new JDateChooser();
        JDateChooser fechaFin = new JDateChooser();
        Object[] entradas = {"Fecha de inicio:", fechaInicio, "Fecha de fin:", fechaFin};
        int opcion = JOptionPane.showConfirmDialog(null, entradas, "Seleccione un rango de fechas", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            Date fechaInicioSeleccionada = fechaInicio.getDate();
            Date fechaFinSeleccionada = fechaFin.getDate();
            if (fechaInicioSeleccionada != null && fechaFinSeleccionada != null) {
                if (fechaInicioSeleccionada.before(fechaFinSeleccionada)) {
                    VentaPDF.generarRoporteProdcutosMasVendidso(fechaInicioSeleccionada, fechaFinSeleccionada);
                } else {
                    JOptionPane.showMessageDialog(null, "La fecha de inicio debe ser anterior a la fecha de fin");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar ambas fechas");
            }
        }
    }
 
}
