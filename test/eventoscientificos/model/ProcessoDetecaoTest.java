/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos.model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * Teste à classe Processo Deteção
 *
 * @author G01
 */
public class ProcessoDetecaoTest {

    private Conflito conflito;
    private SessaoTematica sessaoTematica;

    public ProcessoDetecaoTest() {
        SessaoTematica sessaoTematica = new SessaoTematica(
                "#A9D24R",
                "LAPR2",
                new Data(2015, 5, 22),
                new Data(2015, 5, 28),
                new Data(2015, 6, 10),
                new Data(2015, 6, 20),
                new Data(2015, 6, 24),
                new Data(2015, 6, 28),
                new Data(2015, 6, 30));
        sessaoTematica.adicionarCP(new CP());
        Revisor r = new Revisor(new Utilizador(
                "fatima", "ola@iml.com", "fafa", "1234"));
        Submissao s = new Submissao();
        s = new Submissao();
        s.setArtigoFinal(new Artigo());
        s.setArtigoInicial(new Artigo());
        this.conflito = new Conflito(r, s, new ArrayList<TipoConflito>());
        this.sessaoTematica = sessaoTematica;
    }

    /**
     * Teste do método getListaConflito, da classe ProcessoDetecao.
     */
    @Test
    public void testGetListaConflito() {
        System.out.println("getListaConflito");
        ProcessoDetecao instance = new ProcessoDetecao(
                this.sessaoTematica, new ArrayList());
        ListaConflitos listaConflitos = instance.getListaConflito();
        listaConflitos.adicionarConflito(this.conflito);
        Conflito expResult = this.conflito;
        Conflito result = instance.getListaConflito().validarExistenciaConflito(
                this.conflito.getRevisor(), this.conflito.getSubmissao());
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe ProcessoDetecao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        Object outroObjecto = new ProcessoDetecao(
                this.sessaoTematica, new ArrayList());
        ListaConflitos listaConflitos
                = ((ProcessoDetecao) outroObjecto).getListaConflito();
        listaConflitos.adicionarConflito(
                this.conflito);
        ProcessoDetecao instance = new ProcessoDetecao(
                this.sessaoTematica, new ArrayList());
        ListaConflitos OutraListaConflitos = instance.getListaConflito();
        OutraListaConflitos.adicionarConflito(this.conflito);
        boolean expResult = true;
        boolean result = instance.equals(outroObjecto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe ProcessoDetecao.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equalsNot");
        Object outroObjecto = new ProcessoDetecao(
                this.sessaoTematica, new ArrayList());
        Revisor revisor = new Revisor(new Utilizador(
                "Fernando", "ola@iml.com", "fafa", "1234"));
        Submissao submissao = new Submissao();
        Conflito conflito = new Conflito(
                revisor, submissao, new ArrayList<TipoConflito>());
        ListaConflitos listaConflitos = ((ProcessoDetecao) outroObjecto).getListaConflito();
        ProcessoDetecao instance = new ProcessoDetecao(
                this.sessaoTematica, new ArrayList());
        ListaConflitos outraListaConflitos = instance.getListaConflito();
        outraListaConflitos.adicionarConflito(conflito);
        boolean expResult = false;
        boolean result = instance.equals(outroObjecto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método detetarConflito, da classe ProcessoDetecao.
     */
    @Test
    public void testDetetarConflitos() {
        System.out.println("detetarConflitos");
        ProcessoDetecao instance = new ProcessoDetecao(
                this.sessaoTematica, new ArrayList());
        boolean expResult = true;
        boolean result = instance.detetarConflitos();
    }

}
