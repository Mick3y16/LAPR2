package eventoscientificos.controllers;

import eventoscientificos.model.Empresa;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author G01
 */
public class DefinirTipoConflitoControllerTest {

    private Empresa empresa;

    public DefinirTipoConflitoControllerTest() {
        this.empresa = new Empresa();
    }

    /**
     * Teste ao método getRegistoTiposConflito, da classe
     * DefinirTipoConflitoController.
     */
    @Test
    public void testGetRegistoTiposConflito() {
        System.out.println("getRegistoTiposConflito");
        DefinirTipoConflitoController instance
                = new DefinirTipoConflitoController(this.empresa);
        boolean expResult = true;
        boolean result = instance.getRegistoTiposConflito();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método novoTipoConflito, da classe
     * DefinirTipoConflitoController.
     */
    @Test
    public void testNovoTipoConflito() {
        System.out.println("novoTipoConflito");
        String descricao = "O revisor é primo em 3º grau de um dos autores.";
        DefinirTipoConflitoController instance
                = new DefinirTipoConflitoController(this.empresa);
        instance.getRegistoTiposConflito();
        boolean expResult = true;
        boolean result = instance.novoTipoConflito(descricao);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método adicionarTipoConflito, da classe
     * DefinirTipoConflitoController.
     */
    @Test
    public void testAdicionarTipoConflito() {
        System.out.println("adicionarTipoConflito");
        String descricao = "O revisor é primo em 3º grau de um dos autores.";
        DefinirTipoConflitoController instance
                = new DefinirTipoConflitoController(this.empresa);
        instance.getRegistoTiposConflito();
        instance.novoTipoConflito(descricao);
        boolean expResult = true;
        boolean result = instance.adicionarTipoConflito();
        assertEquals(expResult, result);
    }

}
