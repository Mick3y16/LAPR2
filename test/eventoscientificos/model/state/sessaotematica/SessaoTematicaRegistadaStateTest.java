package eventoscientificos.model.state.sessaotematica;

import eventoscientificos.model.SessaoTematica;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * Teste à classe SessaoTematicaRegistadaState
 *
 * @author G01
 */
public class SessaoTematicaRegistadaStateTest {

    private SessaoTematica sessaoTematica;

    public SessaoTematicaRegistadaStateTest() {
        SessaoTematica sessaoTematica = new SessaoTematica(
                            "#A9D24R",
                            "LAPR2",
                            new Data(2015, 5, 22),
                            new Data(2015, 5, 28),
                            new Data(2015, 6, 20),
                            new Data(2015, 6, 24),
                            new Data(2015, 6, 28),
                            new Data(2016, 7, 1),
                            new Data(2015, 7, 7));
        sessaoTematica.setEstado(
                            new SessaoTematicaRegistadaState(sessaoTematica));

        this.sessaoTematica = sessaoTematica;
    }

    /**
     * Teste do método setCriada, da classe SessaoTematicaRegistadaState.
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
     * Teste do método setRegistada, da classe SessaoTematicaRegistadaState.
     */
    @Test
    public void testSetRegistada() {
        System.out.println("setRegistada");
        SessaoTematicaState instance = this.sessaoTematica.getEstado();
        boolean expResult = true;
        boolean result = instance.setRegistada();
        assertEquals(expResult, result);
    }

    /**
     * Test do método setCPDefinida, da classe SessaoTematicaRegistadaState.
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
     * Teste do método setEmSubmissao, da classe SessaoTematicaRegistadaState.
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
     * Test of setEmDetecao method, of class SessaoTematicaRegistadaState.
     */
    @Test
    public void testSetEmDetecao() {
        System.out.println("setEmDetecao");
        SessaoTematicaState instance = this.sessaoTematica.getEstado();
        boolean expResult = false;
        boolean result = instance.setEmDetecao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do méotodo setEmLicitacao, da classe SessaoTematicaRegistadaState.
     */
    @Test
    public void testSetEmLicitacao() {
        System.out.println("setEmLicitacao");
        SessaoTematicaState instance = this.sessaoTematica.getEstado();
        boolean expResult = false;
        boolean result = instance.setEmLicitacao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setEmDistribuicao, da classe
     * SessaoTematicaRegistadaState.
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
     * Teste do método setEmRevisao, da classe SessaoTematicaRegistadaState.
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
     * Teste do método setFaseDecisao, da classe SessaoTematicaRegistadaState.
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
     * SessaoTematicaRegistadaState.
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
     * Teste do método setCameraReady, da classe SessaoTematicaRegistadaState.
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
     * Teste do método validarEstado, da classe SessaoTematicaRegistadaState.
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
     * SessaoTematicaRegistadaState.
     */
    @Test
    public void testIsStateValidoParaRemover() {
        System.out.println("isStateValidoParaRemover");
        sessaoTematica.setEstado(new SessaoTematicaEmSubmissaoState(sessaoTematica));
        SessaoTematicaState instance = this.sessaoTematica.getEstado();
        boolean expResult = true;
        boolean result = instance.isStateValidoParaRemover();
        assertEquals(expResult, result);

    }

    /**
     * Teste ao método testIsStateValidoParaRemoverNot, da classe
     * SessaoTematicaRegistadaState.
     */
    @Test
    public void testIsStateValidoParaRemoverNot() {
        System.out.println("isStateValidoParaRemoverNot");
        SessaoTematicaState instance = this.sessaoTematica.getEstado();
        boolean expResult = false;
        boolean result = instance.isStateValidoParaRemover();
        assertEquals(expResult, result);

    }

    /**
     * Teste ao método testIsStateValidoParaSubmeter, da classe
     * SessaoTematicaRegistadaState.
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
     * SessaoTematicaRegistadaState.
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
     * SessaoTematicaRegistadaState.
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
     * SessaoTematicaRegistadaState.
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
     * SessaoTematicaRegistadaState.
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
