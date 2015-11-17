package eventoscientificos.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author G01
 */
public class ProponenteTest {
    
    private Utilizador utilizador;

    public ProponenteTest() {
        this.utilizador = new Utilizador(
                "Pedro", "1140781@isep.ipp.pt", "pedro", "1234");
    }

    /**
     * Teste do método getUtilizador, da classe Proponente.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        Proponente instance = new Proponente(this.utilizador);
        Utilizador expResult = this.utilizador;
        Utilizador result = instance.getUtilizador();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método toString, da classe Organizador.
     */
    public void testToString() {
        Proponente instance = new Proponente(new Utilizador(
                "Beatriz", "1140587@isep.ipp.pt", "bea", "1234"));
        String expResult = "Beatriz (1140587@isep.ipp.pt)";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarProponente, da classe Proponente.
     */
    @Test
    public void testValidarProponente() {
        System.out.println("validarProponente");
        Proponente instance = new Proponente(this.utilizador);
        boolean expResult = true;
        boolean result = instance.validarProponente();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarProponente, quando não é válido, da classe
     * Proponente.
     */
    @Test(expected = NullPointerException.class)
    public void testValidarProponenteNot() {
        System.out.println("validarProponenteNot");
        Proponente instance = new Proponente(null);
        instance.validarProponente();
    }

    /**
     * Teste do método equals, da classe Proponente.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = new Proponente(this.utilizador);
        Proponente instance = new Proponente(this.utilizador);
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe Proponente, para proponentes
     * diferentes.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equalsNot");
        Object outroObjeto = new Proponente(this.utilizador);
        Proponente instance = new Proponente(new Utilizador(
                "Pedro", "0000000@isep.ipp.pt", "user", "1234"));
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

}
