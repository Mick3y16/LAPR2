package eventoscientificos.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste à classe Administrador.
 * @author G01
 */
public class AdministradorTest {
    
    public AdministradorTest() {
    }

    /**
     * Test of getUtilizador method, of class Administrador.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        Administrador instance = new Administrador(new Utilizador(
                "Tiago", "1131658@isep.ipp.pt", "tiago", "1234"));
        Utilizador expResult = new Utilizador(
                "Tiago", "1131658@isep.ipp.pt", "tiago", "1234");
        Utilizador result = instance.getUtilizador();
        assertEquals(expResult, result);
    }

    /**
     * Test of validarAdministrador method, of class Administrador.
     */
    @Test
    public void testValidarAdministrador() {
        System.out.println("validarAdministrador");
        Administrador instance = new Administrador(new Utilizador(
                "Tiago", "1131658@isep.ipp.pt", "tiago", "1234"));;
        boolean expResult = true;
        boolean result = instance.validarAdministrador();
        assertEquals(expResult, result);
    }
    
      /**
     * Teste do método validarProponente, quando não é válido, da classe
     * Revisor.
     */
    @Test(expected = NullPointerException.class)
    public void testValidarAdministradorNot() {
        System.out.println("validarAdministrador");
        Administrador instance = new Administrador(null);
        instance.validarAdministrador();
    }

    /**
     * Test of toString method, of class Administrador.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Administrador instance = new Administrador(new Utilizador(
                "Beatriz", "1140587@isep.ipp.pt", "bea", "1234"));
        String expResult = "Beatriz (1140587@isep.ipp.pt)";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Administrador.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = new Administrador(new Utilizador(
                "Tiago", "1131658@isep.ipp.pt", "tiago", "1234"));;
        Administrador instance =  new Administrador(new Utilizador(
                "Tiago", "1131658@isep.ipp.pt", "tiago", "1234"));;
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }
    
    /**
     * Teste do método equals, da classe Administrador, para administradores
     * diferentes.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equalsNot");
        Object outroObjeto = new Administrador(new Utilizador(
                "Miguel", "0000000@isep.ipp.pt", "miguel", "4321"));
        Administrador instance = new Administrador(new Utilizador(
                "Tiago", "1131658@isep.ipp.pt", "tiago", "1234"));
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }
}
