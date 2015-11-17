package eventoscientificos.model.state.sessaotematica;

import eventoscientificos.model.SessaoTematica;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * Teste à classe SessaoTematicaEmDetecaoState
 * @author G01
 */
public class SessaoTematicaEmDetecaoStateTest {

    private SessaoTematica sessaoTematica;

    public SessaoTematicaEmDetecaoStateTest() {
        SessaoTematica sessaoTematica = new SessaoTematica(
                            "#12345",
                            "Um descrição",
                            new Data(2015, 5, 22),
                            new Data(2015, 5, 28),
                            new Data(2015, 6, 10),
                            new Data(2015, 6, 20),
                            new Data(2015, 6, 24),
                            new Data(2015, 6, 28),
                            new Data(2015, 7, 7));
        sessaoTematica.setEstado(
                            new SessaoTematicaEmDetecaoState(sessaoTematica));

        this.sessaoTematica = sessaoTematica;
    }

    /**
     * Teste do método setCriada, da classe SessaoTematicaEmDetecaoState.
     */
    @Test
    public void testSetCriada() {
        System.out.println("setCriada");
        SessaoTematicaState instance = this.sessaoTematica.getEstado();
        boolean expResult = false;
        boolean result = instance.setCriada();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setRegistada, da classe SessaoTematicaEmDetecaoState.
     */
    @Test
    public void testSetRegistada() {
        System.out.println("setRegistada");
        SessaoTematicaState instance = this.sessaoTematica.getEstado();
        boolean expResult = false;
        boolean result = instance.setRegistada();
        assertEquals(expResult, result);
    }

    /**
     * Test do método setCPDefinida, da classe SessaoTematicaEmDetecaoState.
     */
    @Test
    public void testSetCPDefinida() {
        System.out.println("setCPDefinida");
        SessaoTematicaState instance = this.sessaoTematica.getEstado();
        boolean expResult = false;
        boolean result = instance.setCPDefinida();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setEmSubmissao, da classe SessaoTematicaEmDetecaoState.
     */
    @Test
    public void testSetEmSubmissao() {
        System.out.println("setEmSubmissao");
        SessaoTematicaState instance = this.sessaoTematica.getEstado();
        boolean expResult = false;
        boolean result = instance.setEmSubmissao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmDetecao method, of class SessaoTematicaEmDetecaoState.
     */
    @Test
    public void testSetEmDetecao() {
        System.out.println("setEmDetecao");
        SessaoTematicaState instance = this.sessaoTematica.getEstado();
        boolean expResult = true;
        boolean result = instance.setEmDetecao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do méotodo setEmLicitacao, da classe SessaoTematicaEmDetecaoState.
     */
    @Test
    public void testSetEmLicitacao() {
        System.out.println("setEmLicitacao");
        this.sessaoTematica.setEstado(new SessaoTematicaEmDetecaoState(sessaoTematica));
        SessaoTematicaState instance = this.sessaoTematica.getEstado();
        boolean expResult = false;
        boolean result = instance.setEmLicitacao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setEmDistribuicao, da classe
     * SessaoTematicaEmDetecaoState.
     */
    @Test
    public void testSetEmDistribuicao() {
        System.out.println("setEmDistribuicao");
        SessaoTematicaState instance = this.sessaoTematica.getEstado();
        boolean expResult = false;
        boolean result = instance.setEmDistribuicao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setEmRevisao, da classe SessaoTematicaEmDetecaoState.
     */
    @Test
    public void testSetEmRevisao() {
        System.out.println("setEmRevisao");
        SessaoTematicaState instance = this.sessaoTematica.getEstado();
        boolean expResult = false;
        boolean result = instance.setEmRevisao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setFaseDecisao, da classe SessaoTematicaEmDetecaoState.
     */
    @Test
    public void testSetFaseDecisao() {
        System.out.println("setFaseDecisao");
        SessaoTematicaState instance = this.sessaoTematica.getEstado();
        boolean expResult = false;
        boolean result = instance.setFaseDecisao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setEmSubmissaoCameraReady, da classe
     * SessaoTematicaEmDetecaoState.
     */
    @Test
    public void testSetEmSubmissaoCameraReady() {
        System.out.println("setEmSubmissaoCameraReady");
        SessaoTematicaState instance = this.sessaoTematica.getEstado();
        boolean expResult = false;
        boolean result = instance.setEmSubmissaoCameraReady();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setCameraReady, da classe SessaoTematicaEmDetecaoState.
     */
    @Test
    public void testSetCameraReady() {
        System.out.println("setCameraReady");
        SessaoTematicaState instance = this.sessaoTematica.getEstado();
        boolean expResult = false;
        boolean result = instance.setCameraReady();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarEstado, da classe SessaoTematicaEmDetecaoState.
     */
    @Test
    public void testValidarEstado() {
        System.out.println("validarEstado");
        SessaoTematicaState instance = this.sessaoTematica.getEstado();
        boolean expResult = false;
        boolean result = instance.validarEstado();
        assertEquals(expResult, result);
    }

    /**
     * Teste ao método isStateValidoParaRemover, da classe
     * SessaoTematicaEmDetecaoState.
     */
    @Test
    public void testIsStateValidoParaRemover() {
        System.out.println("isStateValidoParaRemover");
        SessaoTematicaState instance = this.sessaoTematica.getEstado();

        boolean expResult = true;
        boolean result = instance.isStateValidoParaRemover();
        assertEquals(expResult, result);

    }

    /**
     * Teste ao método testIsStateValidoParaRemoverNot, da classe
     * SessaoTematicaEmDetecaoState.
     */
    @Test
    public void testIsStateValidoParaRemoverNot() {
        System.out.println("isStateValidoParaRemoverNot");
        sessaoTematica.setEstado(new SessaoTematicaCriadaState(sessaoTematica));
        SessaoTematicaState instance = this.sessaoTematica.getEstado();
        boolean expResult = false;
        boolean result = instance.isStateValidoParaRemover();
        assertEquals(expResult, result);

    }

    /**
     * Teste ao método testIsStateValidoParaSubmeter, da classe
     * SessaoTematicaEmDetecaoState.
     */
    @Test
    public void testIsStateValidoParaSubmeter() {
        System.out.println("isStateValidoParaSubmeter");
        sessaoTematica.setEstado(new SessaoTematicaEmSubmissaoState(sessaoTematica));
        SessaoTematicaState instance = this.sessaoTematica.getEstado();
        boolean expResult = true;
        boolean result = instance.isStateValidoParaSubmeter();
        assertEquals(expResult, result);
    }

    /**
     * Teste ao método testIsStateValidoParaSubmeterNot, da classe
     * SessaoTematicaEmDetecaoState.
     */
    @Test
    public void testIsStateValidoParaSubmeterNot() {
        System.out.println("isStateValidoParaSubmeterNot");
        SessaoTematicaState instance = sessaoTematica.getEstado();
        boolean expResult = false;
        boolean result = instance.isStateValidoParaSubmeter();
        assertEquals(expResult, result);
    }

    /**
     * Teste ao método testIsStateValidoParaAlterar, da classe
     * SessaoTematicaEmDetecaoState.
     */
    @Test
    public void testIsStateValidoParaAlterar() {
        System.out.println("isStateValidoParaAlterar");
        SessaoTematicaState instance = sessaoTematica.getEstado();
        boolean expResult = false;
        boolean result = instance.isStateValidoParaAlterar();
        assertEquals(expResult, result);
    }

    /**
     * Teste ao método testIsStateValidoParaLicitar, da classe
     * SessaoTematicaEmDetecaoState.
     */
    @Test
    public void testIsStateValidoParaLicitar() {
        System.out.println("isStateValidoParaLicitar");
        sessaoTematica.setEstado(new SessaoTematicaEmLicitacaoState(sessaoTematica));
        SessaoTematicaState instance = sessaoTematica.getEstado();
        boolean expResult = true;
        boolean result = instance.isStateValidoParaLicitar();
        assertEquals(expResult, result);
    }

    /**
     * Teste ao método testIsStateValidoParaDistribuir, da classe
     * SessaoTematicaEmDetecaoState.
     */
    @Test
    public void testIsStateValidoParaDistribuir() {
        System.out.println("isStateValidoParaDistribuir");
        sessaoTematica.setEstado(new SessaoTematicaEmDistribuicaoState(sessaoTematica));
        SessaoTematicaState instance = sessaoTematica.getEstado();
        boolean expResult = true;
        boolean result = instance.isStateValidoParaDistribuir();
        assertEquals(expResult, result);

    }

}
