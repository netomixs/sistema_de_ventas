/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PruebasCajas;
import controlador.Ctrl_Cliente;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;
/**
 *Prueba de cja blanca 
 * @author netom
 */
public class Blanca {

    /**
     *Prueba de calculo de puntos para el rango basico
     */
    @Test
    public void testClienteRango0() {
        int puntos=Ctrl_Cliente.clacularPuntos(0, 1000);
        assertEquals(20, puntos);
    }

    /**
     *Prueba de calculo de puntos para el rango intermedio
     */
    public void testClienteRango1() {
        int puntos=Ctrl_Cliente.clacularPuntos(1, 1000);
        assertEquals(50, puntos);
    }

    /**
     *Prueba de calculo de puntos para el rango avanzado
     */
    public void testClienteRango2() {
        int puntos=Ctrl_Cliente.clacularPuntos(2, 1000);
        assertEquals(70, puntos);
    }
}
