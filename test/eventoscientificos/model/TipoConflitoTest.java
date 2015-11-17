package eventoscientificos.model;

import eventoscientificos.model.mecanismo.detecao.MecanismoDetecao;
import eventoscientificos.model.mecanismo.detecao.MecanismoDetecao1;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste à classe TipoCOnflito.
 * @author G01
 */
public class TipoConflitoTest {

    private TipoConflito tipoConflito;
    
    public TipoConflitoTest() {
        this.tipoConflito = new TipoConflito(
                new MecanismoDetecao1(), "Uma descrição");
    }

    /**
     * Teste dos métodos set e get MecanismoDetecao, da classe TipoConflito.
     */
    @Test
    public void testSetAndGetMecanismoDetecao() {
        System.out.println("setAndGetMecanismoDetecao");
        TipoConflito instance = this.tipoConflito;
        MecanismoDetecao expResult = null;
        instance.setMecanismoDetecao(expResult);
        MecanismoDetecao result = instance.getMecanismoDetecao();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos métodos set e get Descricao, da classe TipoConflito.
     */
    @Test
    public void testSetAndGetDescricao() {
        System.out.println("setAndGetDescricao");
        TipoConflito instance = this.tipoConflito;
        String expResult = "Uma descrição";
        instance.setDescricao(expResult);
        String result = instance.getDescricao();
        assertEquals(expResult, result);
    }

    /**
     * Test do método setDescricao, da classe TipoConflito.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDescricaoEmpty() {
        System.out.println("setDescricaoEmpty");
        String descricao = "";
        TipoConflito instance = this.tipoConflito;
        instance.setDescricao(descricao);
    }
    
    /**
     * Teste do método equals, da classe Tipo Conflitto.
     */
    @Test
    public void testEqualsDescricao() {
        System.out.println("equalsDescricao");
        Object outroObjeto = new TipoConflito(null, "Uma descrição");
        TipoConflito instance = this.tipoConflito;
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe Tipo Conflitto.
     */
    @Test
    public void testEqualsMecanimo() {
        System.out.println("equalsMecanismo");
        Object outroObjeto = new TipoConflito(new MecanismoDetecao1(), "Descrição");
        TipoConflito instance = this.tipoConflito;
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe Tipo Conflitto.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equalsNot");
        Object outroObjeto = new TipoConflito(null, "Descrição");
        TipoConflito instance = this.tipoConflito;
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarTipoConflito, da classe TipoConflito.
     */
    @Test
    public void testValidarTipoConflito() {
        System.out.println("validarTipoConflito");
        TipoConflito instance = this.tipoConflito;
        boolean expResult = true;
        boolean result = instance.validarTipoConflito();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método temMecanismo, da classe TipoConflito.
     */
    @Test
    public void testTemMecanismo() {
        System.out.println("temMecanismo");
        TipoConflito instance = this.tipoConflito;
        boolean expResult = true;
        boolean result = instance.temMecanismo();
        assertEquals(expResult, result);
    }
    
}
