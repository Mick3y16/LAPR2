package eventoscientificos.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Teste à classe Local
 * @author G01
 */
public class LocalTest {

    public LocalTest() {
    }

    /**
     * Teste dos métodos set e get do atributo nome do local, da classe Local.
     */
    @Test
    public void testSetAndGetLocal() {
        System.out.println("SetAndGetgetLocal");
        Local instance = new Local("Régua");
        String expResult = "Régua";
        instance.setNomeLocal(expResult);
        assertEquals(expResult, instance.getNomeLocal());
    }

    /**
     * Teste do método toString, da classe Local..
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Local instance = new Local("Régua");
        String expResult = "Régua";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo setLocal, da classe Evento.
     */
    @Test(expected = NullPointerException.class)
    public void testSetLocalNull() {
        System.out.println("setLocalNull");
        String local = null;
        Local instance = new Local("isep");
        instance.setNomeLocal(local);
    }

}
