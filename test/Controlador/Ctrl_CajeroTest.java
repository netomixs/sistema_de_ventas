/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controlador;

import controlador.Ctrl_Cajero;
import java.util.Calendar;
import java.util.Date;
import modelo.Cajero;
import modelo.Direccion;
import modelo.Persona;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author netom
 * En esta prueba solo se puede hacer de manera individual.
 * Ya que al crear un regsitro no es posible en contrarlo
 */
public class Ctrl_CajeroTest {

    Persona persona;
    Cajero cajero;

    /**
     *
     */
    public Ctrl_CajeroTest() {
        persona = new Persona();
        cajero=new Cajero();
        persona.setNombre("Juan");
        persona.setApellidoP("Pérez");
        persona.setApellidoM("García");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1990, 5, 15);
        Date fechaNacimiento = calendar.getTime();
        persona.setNacimiento(fechaNacimiento);
        persona.setCurp("PEJG900615HDFXXX");
        Date fechaRegistro = new Date();
        persona.setFechaRegistro(fechaRegistro);
        Direccion direccion = new Direccion();
        direccion.setCalle("Av. Insurgentes Sur");
        direccion.setNumero("1234");
        direccion.setCP("03100");
        direccion.setLocalidad("Col. del Valle");
        direccion.setEstado(1745);
        persona.setDireccion(direccion);
        cajero.setPersona(persona);
        cajero.setClave("12345");
    }

    /**
     *
     */
    @Before
    public void setUp() {
       
    }

    /**
     * Test of crear method, of class Ctrl_Cajero.
     */
    @Test
    public void testCrear() {
         assertTrue(Ctrl_Cajero.crear(cajero));
         cajero=Ctrl_Cajero.get(cajero);
    }


    /**
     * Test of actualizar method, of class Ctrl_Cajero.
     */
    @Test
    public void testActualizar() {
        cajero.setID(45);
         Ctrl_Cajero.actualizar(cajero);
    }

    /**
     * Test of get method, of class Ctrl_Cajero.
     */
    @Test
    public void testGet() {
        cajero.setClave("g2Gmzryr");
        cajero=Ctrl_Cajero.get(cajero);
        assertTrue(cajero.getID()!=0);
    }

    /**
     * Test of getTabla method, of class Ctrl_Cajero.
     */
    @Test
    public void testGetTabla() {
        assertNotNull(Ctrl_Cajero.getTabla());
    }

    /**
     * Test of eliminar method, of class Ctrl_Cajero.
     */
    @Test
    public void testEliminar() {
        // Cambiar la clave a la ultima creada con la test crear
        cajero.setClave("Qd8TDzXw");
        cajero=Ctrl_Cajero.get(cajero);
        Ctrl_Cajero.eliminar(cajero);
    }
}
