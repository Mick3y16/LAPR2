package eventoscientificos.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste à classe InstituicaoAfiliacao
 * @author G01
 */
public class InstituicaoAfiliacaoTest {

    private InstituicaoAfiliacao instituicaoAfiliacao;
    
    public InstituicaoAfiliacaoTest() {
        this.instituicaoAfiliacao = new InstituicaoAfiliacao("ISEP");
    }

    /**
     * Teste do método setAndGetNomeInstituicaoAfiliacao, da classe
     * InstituicaoAfiliacao.
     */
    @Test
    public void testSetAndGetNomeInstituicaoAfiliacao() {
        System.out.println("setAndGetNomeInstituicaoAfiliacao");
        InstituicaoAfiliacao instance = this.instituicaoAfiliacao;
        String expResult = "porto ISEP";
        instance.setNomeInstituicaoAfiliacao(expResult);
        String result = instance.getNomeInstituicaoAfiliacao();
        assertEquals(expResult, result);
    }
    
    /**
     * Teste do método setNomeInstituicaoAfiliacao, da classe
     * InstituicaoAfiliacao.
     */
    @Test(expected = NullPointerException.class)
    public void testSetNomeInstituicaoAfiliacaoNull() {
        System.out.println("setNomeInstituicaoAfiliacao");
        InstituicaoAfiliacao instance = null;
        String expResult = "ISEP";
        instance.setNomeInstituicaoAfiliacao(expResult);
        String result = instance.getNomeInstituicaoAfiliacao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método toString, da classe InstituicaoAfiliacao.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        InstituicaoAfiliacao instance = this.instituicaoAfiliacao;
        String expResult = "ISEP";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarInstituicaoAfiliacao, 
     * da classe InstituicaoAfiliacao.
     */
    @Test
    public void testValidarInstituicaoAfiliacao() {
        System.out.println("validarInstituicaoAfiliacao");
        InstituicaoAfiliacao instance = this.instituicaoAfiliacao;
        boolean expResult = true;
        boolean result = instance.validarInstituicaoAfiliacao();
        assertEquals(expResult, result);
    }

}
