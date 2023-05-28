/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PruebasCajas;

import controlador.Ctrl_Persona;
import static org.junit.Assert.*;
import org.junit.Test;

public class Girs {

    @Test
    public void testPassworSegura() {
        boolean valor = Ctrl_Persona.esContrasenaSegura("@!@121QWsdqw");
        assertTrue(valor);
    }

    public void testPassworSeguraInsegura() {
        boolean valor = Ctrl_Persona.esContrasenaSegura("qwerty");
        assertTrue(valor);
    }

    public void testPassworVacia() {
        boolean valor = Ctrl_Persona.esContrasenaSegura("qwerty");
        assertTrue(valor);
    }

    public void testPasswordWithoutSpecialCharacters() {
        boolean result = Ctrl_Persona.esContrasenaSegura("Password123");
        assertFalse(result);
    }

    @Test
    public void testShortPassword() {
        boolean result = Ctrl_Persona.esContrasenaSegura("1234");
        assertFalse(result);
    }

    @Test
    public void testPasswordWithSpecialCharactersButShort() {
        boolean result = Ctrl_Persona.esContrasenaSegura("@#$%");
        assertFalse(result);
    }

}
