package eventoscientificos.model.state.submissao;

import eventoscientificos.model.Submissao;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author G01
 */
public class SubmissaoEmRevisaoStateTest {
    
    private Submissao submissao;

    public SubmissaoEmRevisaoStateTest() {
        this.submissao = new Submissao();
        this.submissao.setEstado(new SubmissaoEmRevisaoState(this.submissao));
    }

    /**
     * Teste do método setCriada, da classe SubmissaoEmRevisaoState.
     */
    @Test
    public void testSetCriada() {
        System.out.println("setCriada");
        SubmissaoState instance = this.submissao.getEstado();
        boolean expResult = false;
        boolean result = instance.setCriada();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setEmSubmissao, da classe SubmissaoEmRevisaoState.
     */
    @Test
    public void testSetEmSubmissao() {
        System.out.println("setEmSubmissao");
        SubmissaoState instance = this.submissao.getEstado();
        boolean expResult = false;
        boolean result = instance.setEmSubmissao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setEmLicitacao, da classe SubmissaoEmRevisaoState.
     */
    @Test
    public void testSetEmLicitacao() {
        System.out.println("setEmLicitacao");
        SubmissaoState instance = this.submissao.getEstado();
        boolean expResult = false;
        boolean result = instance.setEmLicitacao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setEmRevisao, da classe SubmissaoEmRevisaoState.
     */
    @Test
    public void testSetEmRevisao() {
        System.out.println("setEmRevisao");
        SubmissaoState instance = this.submissao.getEstado();
        boolean expResult = true;
        boolean result = instance.setEmRevisao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setRevista, da classe SubmissaoEmRevisaoState.
     */
    @Test
    public void testSetRevista() {
        System.out.println("setRevista");
        SubmissaoState instance = this.submissao.getEstado();
        boolean expResult = true;
        boolean result = instance.setRevista();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setAceite, da classe SubmissaoEmRevisaoState.
     */
    @Test
    public void testSetAceite() {
        System.out.println("setAceite");
        SubmissaoState instance = this.submissao.getEstado();
        boolean expResult = false;
        boolean result = instance.setAceite();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setRejeitada, da classe SubmissaoEmRevisaoState.
     */
    @Test
    public void testSetRejeitada() {
        System.out.println("setRejeitada");
        SubmissaoState instance = this.submissao.getEstado();
        boolean expResult = false;
        boolean result = instance.setRejeitada();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setEmCameraReady, da classe SubmissaoEmRevisaoState.
     */
    @Test
    public void testSetEmCameraReady() {
        System.out.println("setEmCameraReady");
        SubmissaoState instance = this.submissao.getEstado();
        boolean expResult = false;
        boolean result = instance.setEmCameraReady();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setSemArtigoFinal, da classe SubmissaoEmRevisaoState.
     */
    @Test
    public void testSetSemArtigoFinal() {
        System.out.println("setSemArtigoFinal");
        SubmissaoState instance = this.submissao.getEstado();
        boolean expResult = false;
        boolean result = instance.setSemArtigoFinal();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setRemovida, da classe SubmissaoEmRevisaoState.
     */
    @Test
    public void testSetRemovida() {
        System.out.println("setRemovida");
        SubmissaoState instance = this.submissao.getEstado();
        boolean expResult = true;
        boolean result = instance.setRemovida();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarEstado, da classe SubmissaoEmRevisaoState.
     */
    @Test
    public void testValidarEstado() {
        System.out.println("validarEstado");
        SubmissaoState instance = this.submissao.getEstado();
        boolean expResult = true;
        boolean result = instance.validarEstado();
        assertEquals(expResult, result);
    }

}
