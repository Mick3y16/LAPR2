package eventoscientificos.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste à classe Revisor
 *
 * @author G01
 */
public class RevisorTest {

    public RevisorTest() {
    }

    /**
     * Teste do método getUtilizador, da classe Revisor.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        Revisor instance = new Revisor(new Utilizador(
                            "Tiago", "1131658@isep.ipp.pt", "tiago", "1234"));
        Utilizador expResult = new Utilizador(
                            "Tiago", "1131658@isep.ipp.pt", "tiago", "1234");
        Utilizador result = instance.getUtilizador();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método toString, da classe Revisor.
     */
    public void testToString() {
        System.out.println("toString");
        Revisor instance = new Revisor(new Utilizador(
                            "Beatriz", "1140587@isep.ipp.pt", "bea", "1234"));
        String expResult = "Beatriz (1140587@isep.ipp.pt)";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarProponente, da classe Revisor.
     */
    @Test
    public void testValidarRevisor() {
        System.out.println("validarRevisor");
        Revisor instance = new Revisor(new Utilizador(
                            "Tiago", "1131658@isep.ipp.pt", "tiago", "1234"));
        boolean expResult = true;
        boolean result = instance.validarRevisor();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarProponente, quando não é válido, da classe
     * Revisor.
     */
    @Test(expected = NullPointerException.class)
    public void testValidarRevisorNot() {
        System.out.println("validarRevisor");
        Revisor instance = new Revisor(null);
        instance.validarRevisor();

    }

    /**
     * Teste do método equals, da classe Revisor.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = new Revisor(new Utilizador(
                            "Tiago", "1131658@isep.ipp.pt", "tiago", "1234"));
        Revisor instance = new Revisor(new Utilizador(
                            "Tiago", "1131658@isep.ipp.pt", "tiago", "1234"));
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe Revisor, para revisores diferentes.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equalsNot");
        Object outroObjeto = new Revisor(new Utilizador(
                            "Miguel", "0000000@isep.ipp.pt", "miguel", "4321"));
        Revisor instance = new Revisor(new Utilizador(
                            "Tiago", "1131658@isep.ipp.pt", "tiago", "1234"));
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);

    }
}
