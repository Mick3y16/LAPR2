package eventoscientificos.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste à classe Organizador
 * @author G01
 */
public class OrganizadorTest {

    public OrganizadorTest() {
    }

    /**
     * Teste do método getUtilizador, da classe Organizador.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        Organizador instance = new Organizador(new Utilizador(
                "Beatriz", "1140587@isep.ipp.pt", "bea", "1234"));
        Utilizador expResult = new Utilizador(
                "Beatriz", "1140587@isep.ipp.pt", "bea", "1234");
        Utilizador result = instance.getUtilizador();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método toString, da classe Organizador.
     */
    public void testToString() {
        Organizador instance = new Organizador(new Utilizador(
                "Beatriz", "1140587@isep.ipp.pt", "bea", "1234"));
        String expResult = "Beatriz (1140587@isep.ipp.pt)";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarOrganizador, da classe Organizador.
     */
    @Test
    public void testValidarOrganizador() {
        System.out.println("validarOrganizador");
        Organizador instance = new Organizador(new Utilizador(
                "Beatriz", "1140587@isep.ipp.pt", "bea", "1234"));
        boolean expResult = true;
        boolean result = instance.validarOrganizador();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarOrganizador, quando não é válido, da classe
     * Organizador.
     */
    @Test(expected = NullPointerException.class)
    public void testValidarOrganizadorNot() {
        System.out.println("validarOrganizadorNot");
        Organizador instance = new Organizador(null);
        instance.validarOrganizador();
    }

    /**
     * Teste do método equals, da classe Organizador.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = new Organizador(new Utilizador(
                "Beatriz", "1140587@isep.ipp.pt", "bea", "1234"));
        Organizador instance = new Organizador(new Utilizador(
                "Beatriz", "1140587@isep.ipp.pt", "bea", "1234"));
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe Organizador, para organizadores
     * diferentes.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equalsNot");
        Object outroObjeto = new Organizador(new Utilizador(
                "Beatriz", "1140587@isep.ipp.pt", "bea", "1234"));
        Organizador instance = new Organizador(new Utilizador(
                "Beatriz", "1140587@isep.ipp.pt", "beatriz", "1234"));
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

}
