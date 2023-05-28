/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controlador;

import controlador.Ctrl_Persona;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import modelo.Direccion;
import modelo.Persona;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author netom
 */
public class Ctrl_PersonaTest {

    Direccion direccion;
    private Persona persona;
    Ctrl_Persona ctrl;

    /**
     *
     */
    public Ctrl_PersonaTest() {
        ctrl = new Ctrl_Persona();
        persona = new Persona();
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
        direccion = new Direccion();
        direccion.setCalle("Av. Insurgentes Sur");
        direccion.setNumero("1234");
        direccion.setCP("03100");
        direccion.setLocalidad("Col. del Valle");
        direccion.setEstado(1745);
        persona.setDireccion(direccion);
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     * Test of Crear method, of class Ctrl_Persona.
     */
    @Test
    public void testCrear() {
        persona = ctrl.Crear(persona);
        assertTrue(persona.getID() > 0);
    }

    /**
     * Test of Actualizar method, of class Ctrl_Persona.
     */
    @Test
    public void testActualizar() {
        ctrl.Actualizar(persona);
    }

    /**
     * Test of crearDireccion method, of class Ctrl_Persona.
     */
    @Test
    public void testCrearDireccion() {
        assertTrue(ctrl.crearDireccion(direccion) > 0);
    }

    /**
     * Test of ActualizarDireccion method, of class Ctrl_Persona.
     */
    @Test
    public void testActualizarDireccion() {
        ctrl.ActualizarDireccion(direccion);
    }

    /**
     * Test of eliminarPersona method, of class Ctrl_Persona.
     */
    @Test
    public void testEliminarPersona() {
        Ctrl_Persona.eliminarPersona(persona);
    }

    /**
     * Test of hashPassword method, of class Ctrl_Persona.
     */
    @Test
    public void testHashPassword() {
        String p = "holsssa";
        System.out.println(Ctrl_Persona.hashPassword(p).length());
        assertTrue(Ctrl_Persona.hashPassword(p).length() == 64);
    }

    /**
     * Test of esContrasenaSegura method, of class Ctrl_Persona.
     */
    @Test
    public void testEsContrasenaSegura() {
        assertTrue(Ctrl_Persona.esContrasenaSegura("hola") == false);
        assertTrue(Ctrl_Persona.esContrasenaSegura("holsssssa") == false);
        assertTrue(Ctrl_Persona.esContrasenaSegura("hola1") == false);
        assertTrue(Ctrl_Persona.esContrasenaSegura("hola@1"));
    }

    /**
     * Test of validarCurp method, of class Ctrl_Persona.
     */
    @Test
    public void testValidarCurp() {
        assertTrue(Ctrl_Persona.validarCurp("wewwew") == false);
        assertTrue(Ctrl_Persona.validarCurp("FOAC000818MVZLRRA") == false);
        assertTrue(Ctrl_Persona.validarCurp("FOAC000818MVZLRRA81") == false);
        assertTrue(Ctrl_Persona.validarCurp("FOAC000818MVZLwRA8") == false);
        assertTrue(Ctrl_Persona.validarCurp("FOAC000818MVZLRRA8"));

    }

    /**
     * Test of esMayor method, of class Ctrl_Persona.
     */
    @Test
    public void testEsMayor() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendarMayorEdad = Calendar.getInstance();
        Calendar calendarMenorEdad = Calendar.getInstance();
        calendarMayorEdad.set(2000, Calendar.MAY, 10); // Fecha de nacimiento válida (mayor de edad)
        calendarMenorEdad.set(2010, Calendar.MAY, 10); // Fecha de nacimiento no válida (menor de edad)
        Date fechaNacimientoMayorEdad = calendarMayorEdad.getTime();
        Date fechaNacimientoMenorEdad = calendarMenorEdad.getTime();
       
          assertTrue( Ctrl_Persona.esMayor(fechaNacimientoMayorEdad));
          assertFalse(Ctrl_Persona.esMayor(fechaNacimientoMenorEdad));
    }

}
