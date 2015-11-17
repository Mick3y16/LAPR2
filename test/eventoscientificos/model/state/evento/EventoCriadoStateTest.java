/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos.model.state.evento;

import eventoscientificos.model.Evento;
import eventoscientificos.model.Local;
import eventoscientificos.model.Organizador;
import eventoscientificos.model.Utilizador;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * Testa a classe EventoCriadoState
 *
 * @author G01
 */
public class EventoCriadoStateTest {

    /**
     * Instancia de evento
     */
    private Evento e;

    /**
     * Constroi instancia de EventoCriadoStateTest recebendo uma instancia de
     * evento
     */
    public EventoCriadoStateTest() {
        this.e = new Evento("titulo", "descricao", new Local("local"),
                new Data(2016, 6, 8), new Data(2016, 6, 20),
                new Data(2016, 7, 7), new Data(2016, 8, 15),
                new Data(2016, 9, 10), new Data(2016, 10, 1),
                new Data(2017, 6, 10));
        e.novoOrganizador(new Utilizador(
                "beatriz", "  1140587@isep.ipp.pt", "bea", "1234"));
        e.setEstado(new EventoCriadoState(e));
        
    }

    /**
     * Teste do metodo setCriado, da classe EventoCriadoState.
     */
    @Test
    public void testSetCriado() {
        System.out.println("setCriado");
        EventoState instance = e.getEstado();
        boolean expResult = true;
        boolean result = instance.setCriado();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo setRegistado, da classe EventoCriadoState.
     */
    @Test
    public void testSetRegistado() {
        System.out.println("setRegistado");
        EventoState instance = e.getEstado();
        Evento e = this.e;
        boolean expResult = true;
        boolean result = instance.setRegistado();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo SetSessoesTematicasDefinidas, da classe
     * EventoCriadoState.
     */
    @Test
    public void testSetSessoesTematicasDefinidas() {
        System.out.println("setSessoesTematicasDefinidas");
        EventoCriadoState instance = new EventoCriadoState(e);
        boolean expResult = false;
        boolean result = instance.setSessoesTematicasDefinidas();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo SetCPDefinida, da classe EventoCriadoState.
     */
    @Test
    public void testSetCPDefinida() {
        System.out.println("setCPDefinida");
        EventoCriadoState instance = new EventoCriadoState(e);
        boolean expResult = false;
        boolean result = instance.setCPDefinida();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo SetEmSubmissao, da classe EventoCriadoState.
     */
    @Test
    public void testSetEmSubmissao() {
        System.out.println("setEmSubmissao");
        EventoCriadoState instance = new EventoCriadoState(e);
        boolean expResult = false;
        boolean result = instance.setEmSubmissao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo SetEmDetecao, da classe EventoCriadoState.
     */
    @Test
    public void testSetEmDetecao() {
        System.out.println("setEmDetecao");
        EventoCriadoState instance = new EventoCriadoState(e);
        boolean expResult = false;
        boolean result = instance.setEmDetecao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo SetEmLicitacao, da classe EventoCriadoState.
     */
    @Test
    public void testSetEmLicitacao() {
        System.out.println("setEmLicitacao");
        EventoCriadoState instance = new EventoCriadoState(e);
        boolean expResult = false;
        boolean result = instance.setEmLicitacao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo SetEmDistribuicao, da classe EventoCriadoState.
     */
    @Test
    public void testSetEmDistribuicao() {
        System.out.println("setEmDistribuicao");
        EventoCriadoState instance = new EventoCriadoState(e);
        boolean expResult = false;
        boolean result = instance.setEmDistribuicao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo SetEmRevisao, da classe EventoCriadoState.
     */
    @Test
    public void testSetEmRevisao() {
        System.out.println("setEmRevisao");
        EventoCriadoState instance = new EventoCriadoState(e);
        boolean expResult = false;
        boolean result = instance.setEmRevisao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo SetFaseDecisao, da classe EventoCriadoState.
     *
     */
    @Test
    public void testSetFaseDecisao() {
        System.out.println("setFaseDecisao");
        EventoCriadoState instance = new EventoCriadoState(e);
        boolean expResult = false;
        boolean result = instance.setFaseDecisao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo SetEmSubmissaoCameraReady, da classe EventoCriadoState.
     */
    @Test
    public void testSetEmSubmissaoCameraReady() {
        System.out.println("setEmSubmissaoCameraReady");
        EventoCriadoState instance = new EventoCriadoState(e);
        boolean expResult = false;
        boolean result = instance.setEmSubmissaoCameraReady();
        assertEquals(expResult, result);

    }

    /**
     * Teste do metodo SetCameraReady, da classe EventoCriadoState.
     */
    @Test
    public void testSetCameraReady() {
        System.out.println("setCameraReady");
        EventoCriadoState instance = new EventoCriadoState(e);
        boolean expResult = false;
        boolean result = instance.setCameraReady();
        assertEquals(expResult, result);
    }

    /**
     * Teste ao metodo validarEstado, da classe EventoCriadoState.
     */
    @Test
    public void testValidarEstado() {
        System.out.println("validarEstado");
        EventoState instance = e.getEstado();
        boolean expResult = true;
        boolean result = instance.validarEstado();
        assertEquals(expResult, result);
    }
    /**
     * Teste ao método isStateValidoParaRemover, da classe EventoCriadoState.
     */
    @Test
    public void testIsStateValidoParaRemover() {
        System.out.println("isStateValidoParaRemover");
        e.setEstado(new EventoEmDistribuicaoState(e));
        EventoState instance = e.getEstado();
        boolean expResult = true;
        boolean result = instance.isStateValidoParaRemover();
        assertEquals(expResult, result);

    }

    /**
     * Teste ao método testIsStateValidoParaRemoverNot, da classe
     * EventoCriadoState.
     */
    @Test
    public void testIsStateValidoParaRemoverNot() {
        System.out.println("isStateValidoParaRemoverNot");
        EventoState instance = e.getEstado();
        boolean expResult = false;
        boolean result = instance.isStateValidoParaRemover();
        assertEquals(expResult, result);

    }

    /**
     * Teste ao método testIsStateValidoParaSubmeter, da classe
     * EventoCriadoState.
     */
    @Test
    public void testIsStateValidoParaSubmeter() {
        System.out.println("isStateValidoParaSubmeter");
        EventoState instance = e.getEstado();
        e.setEstado(new EventoEmSubmissaoState(e));
        boolean expResult = false;
        boolean result = instance.isStateValidoParaSubmeter();
        assertEquals(expResult, result);
    }

    /**
     * Teste ao método testIsStateValidoParaSubmeterNot, da classe
     * EventoCriadoState.
     */
    @Test
    public void testIsStateValidoParaSubmeterNot() {
        System.out.println("isStateValidoParaSubmeterNot");
        EventoState instance = e.getEstado();
        boolean expResult = false;
        boolean result = instance.isStateValidoParaSubmeter();
        assertEquals(expResult, result);
    }

    /**
     * Teste ao método testIsStateValidoParaAlterar, da classe
     * EventoCriadoState.
     */
    @Test
    public void testIsStateValidoParaAlterar() {
        System.out.println("isStateValidoParaAlterar");
        EventoState instance = e.getEstado();
        boolean expResult = false;
        boolean result = instance.isStateValidoParaAlterar();
        assertEquals(expResult, result);
    }

    /**
     * Teste ao método testIsStateValidoParaLicitar, da classe
     * EventoCriadoState.
     */
    @Test
    public void testIsStateValidoParaLicitar() {
        System.out.println("isStateValidoParaLicitar");
        e.setEstado(new EventoEmLicitacaoState(e));
        EventoState instance = e.getEstado();
        boolean expResult = true;
        boolean result = instance.isStateValidoParaLicitar();
        assertEquals(expResult, result);
    }

    /**
     * Teste ao método testIsStateValidoParaDistribuir, da classe
     * EventoCriadoState.
     */
    @Test
    public void testIsStateValidoParaDistribuir() {
        System.out.println("isStateValidoParaDistribuir");
        e.setEstado(new EventoEmDistribuicaoState(e));
        EventoState instance = e.getEstado();
        boolean expResult = true;
        boolean result = instance.isStateValidoParaDistribuir();
        assertEquals(expResult, result);

    }
}
