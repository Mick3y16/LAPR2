package eventoscientificos.model.state.submissao;

import eventoscientificos.model.Submissao;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author G01
 */
public class SubmissaoEmCameraReadyStateTest {
    
    private Submissao submissao;
    
    public SubmissaoEmCameraReadyStateTest() {
        this.submissao = new Submissao();
        this.submissao.setEstado(new SubmissaoEmCameraReadyState(this.submissao));
    }

    /**
     * Teste do método setCriada, da classe SubmissaoEmCameraReadyState.
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
     * Teste do método setEmSubmissao, da classe SubmissaoEmCameraReadyState.
     */
    @Test
    public void testSetEmSubmissao() {
        System.out.println("setEmSubmissao");
        SubmissaoState instance = this.submissao.getEstado();;
        boolean expResult = false;
        boolean result = instance.setEmSubmissao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setEmLicitacao, da classe SubmissaoEmCameraReadyState.
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
     * Teste do método setEmRevisao, da classe SubmissaoEmCameraReadyState.
     */
    @Test
    public void testSetEmRevisao() {
        System.out.println("setEmRevisao");
        SubmissaoState instance = this.submissao.getEstado();
        boolean expResult = false;
        boolean result = instance.setEmRevisao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setRevista, da classe SubmissaoEmCameraReadyState.
     */
    @Test
    public void testSetRevista() {
        System.out.println("setRevista");
        SubmissaoState instance = this.submissao.getEstado();
        boolean expResult = false;
        boolean result = instance.setRevista();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setAceite method, da classe SubmissaoEmCameraReadyState.
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
     * Teste do método setRejeitada, da classe SubmissaoEmCameraReadyState.
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
     * Teste do método setEmCameraReady, da classe SubmissaoEmCameraReadyState.
     */
    @Test
    public void testSetEmCameraReady() {
        System.out.println("setEmCameraReady");
        SubmissaoState instance = this.submissao.getEstado();
        boolean expResult = true;
        boolean result = instance.setEmCameraReady();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setSemArtigoFinal, da classe SubmissaoEmCameraReadyState.
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
     * Teste do método setRemovida, da classe SubmissaoEmCameraReadyState.
     */
    @Test
    public void testSetRemovida() {
        System.out.println("setRemovida");
        SubmissaoState instance = this.submissao.getEstado();
        boolean expResult = false;
        boolean result = instance.setRemovida();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarEstado, da classe SubmissaoEmCameraReadyState.
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
