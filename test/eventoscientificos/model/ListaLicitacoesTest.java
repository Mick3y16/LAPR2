/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testa a classe Lista Licitacoes
 *
 * @author G01
 */
public class ListaLicitacoesTest {

    private List<Licitacao> listaLicitacoes;
    private Submissao submissao;
    private Revisor revisor;
    private Conflito conflito;

    public ListaLicitacoesTest() {

        Artigo artigoInicial = new Artigo();
        Artigo artigoFinal = new Artigo();
        this.submissao = new Submissao();
        submissao.setArtigoInicial(artigoInicial);
        submissao.setArtigoFinal(artigoFinal);

        ListaLicitacoes listaLicitacoes = new ListaLicitacoes();
        this.listaLicitacoes = new ArrayList<>();
        Licitacao instance = new Licitacao(new Revisor(new Utilizador(
                            "fatima", "ola@iml.com", "fafa", "1234")),
                            this.submissao, 0, null);
        this.listaLicitacoes.add(instance);
        this.revisor = new Revisor(new Utilizador(
                            "Tiago", "1131658@isep.ipp.pt", "tiago", "1234"));

        this.conflito = new Conflito(revisor, submissao, new ArrayList());

    }

    /**
     * Test of criarListaLicitacoesTemporaria method, of class ListaLicitacoes.
     */
    @Test
    public void testCriarListaLicitacoesTemporaria() {
        System.out.println("criarListaLicitacoesTemporaria");
        ListaLicitacoes instance = new ListaLicitacoes();
        List<Licitacao> expResult = new ArrayList<>();
        List<Licitacao> result = instance.criarListaLicitacoesTemporaria();
        assertEquals(expResult, result);
    }

    /**
     * Test of novaLicitacao method, of class ListaLicitacoes.
     */
    @Test
    public void testNovaLicitacao() {
        System.out.println("novaLicitacao");
        Revisor revisor = new Revisor(new Utilizador("Soraia", "freitas@mail.com", "fafa", "1234"));
        int grauInteresse = 0;
        ListaLicitacoes instance = new ListaLicitacoes();
        Licitacao expResult = new Licitacao(revisor, this.submissao, grauInteresse, conflito);
        Licitacao result = instance.novaLicitacao(revisor, this.submissao, grauInteresse, conflito);
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionarListaLicitacoesTemporaria method, of class
     * ListaLicitacoes.
     */
    @Test
    public void testAdicionarListaLicitacoesTemporaria() {
        System.out.println("adicionarListaLicitacoesTemporaria");
        Revisor revisor = new Revisor(new Utilizador("Soraia", "freitas@mail.com", "fafa", "1234"));
        Artigo artigo = new Artigo();
        int grauInteresse = 0;
        List<Licitacao> listaTemporaria = new ArrayList<>();
        listaTemporaria.add(new Licitacao(revisor, submissao, grauInteresse, conflito));
        ListaLicitacoes instance = new ListaLicitacoes();
        boolean expResult = true;
        boolean result = instance.adicionarListaLicitacoesTemporaria(listaTemporaria);
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionarListaLicitacoesTemporaria method, of class
     * ListaLicitacoes.
     */
    @Test
    public void testAdicionarListaLicitacoesTemporariaNull() {
        System.out.println("adicionarListaLicitacoesTemporariaNull");
        List<Licitacao> listaTemporaria = null;
        ListaLicitacoes instance = new ListaLicitacoes();
        boolean expResult = false;
        boolean result = instance.adicionarListaLicitacoesTemporaria(listaTemporaria);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ListaLicitacoes.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjecto = new ListaLicitacoes();
        ((ListaLicitacoes) outroObjecto).adicionarListaLicitacoesTemporaria(listaLicitacoes);
        ListaLicitacoes instance = new ListaLicitacoes();
        instance.adicionarListaLicitacoesTemporaria(listaLicitacoes);
        boolean expResult = true;
        boolean result = instance.equals(outroObjecto);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ListaLicitacoes.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equalsNot");
        Object outroObjecto = new ListaLicitacoes();
        ListaLicitacoes instance = new ListaLicitacoes();
        instance.adicionarListaLicitacoesTemporaria(listaLicitacoes);
        boolean expResult = false;
        boolean result = instance.equals(outroObjecto);
        assertEquals(expResult, result);
    }

    /**
     * Test of contains method, of class ListaLicitacoes.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        ListaLicitacoes instance = new ListaLicitacoes();
        instance.adicionarListaLicitacoesTemporaria(listaLicitacoes);
        Utilizador utilizador = new Utilizador("fatima", "ola@iml.com", "fafa", "1234");
        boolean expResult = true;
        boolean result = instance.contains(utilizador);
        assertEquals(expResult, result);
    }

}
