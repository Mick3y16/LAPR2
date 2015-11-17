package eventoscientificos.controllers;

import eventoscientificos.model.Artigo;
import eventoscientificos.model.CP;
import eventoscientificos.model.Conflito;
import eventoscientificos.model.Empresa;
import eventoscientificos.model.Evento;
import eventoscientificos.model.Licitacao;
import eventoscientificos.model.Local;
import eventoscientificos.model.Revisor;
import eventoscientificos.model.Submissao;
import eventoscientificos.model.TipoConflito;
import eventoscientificos.model.Utilizador;
import eventoscientificos.model.state.evento.EventoEmDetecaoConflitos;
import eventoscientificos.model.state.evento.EventoEmLicitacaoState;
import eventoscientificos.model.state.evento.EventoEmSubmissaoState;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * Teste à classe LicitarArtigoController
 *
 * @author G01
 */
public class LicitarArtigoControllerTest {

    private Empresa empresa;
    private Evento evento;
    private Submissao submissao;
    private Utilizador utilizador;
    private Licitacao licitacao;
    private Revisor revisor;

    public LicitarArtigoControllerTest() {
        this.utilizador = new Utilizador(
                            "fatima", "ola@iml.com", "fafa", "1234");
        this.revisor = new Revisor(utilizador);
        this.empresa = new Empresa();
        this.empresa.setUtilizadorAutenticado(utilizador);
        this.evento = new Evento("titulo", "descricao", new Local("local"),
                            new Data(2015, 5, 8), new Data(2015, 5, 20),
                            new Data(2016, 6, 7), new Data(2016, 6, 10),
                            new Data(2016, 9, 11), new Data(2016, 10, 1),
                            new Data(2017, 6, 10));
        CP cp = new CP();
        cp.novoRevisor(utilizador);
        this.empresa.getRegistoEventos().adicionarEvento(evento);
        this.evento.setCP(cp);
        this.evento.setEstado(new EventoEmSubmissaoState(evento));
        List<TipoConflito> listTC = new ArrayList<TipoConflito>();
        listTC.add(new TipoConflito("Parente"));
        listTC.add(new TipoConflito("Autor"));
        this.evento.iniciarProcessoDetecao(listTC);
        //this.evento.setEstado(new EventoEmLicitacaoState(evento));

        Artigo artigoInicial = new Artigo();
        Artigo artigoFinal = new Artigo();
        this.submissao = new Submissao();
        submissao.setArtigoInicial(artigoInicial);
        submissao.setArtigoFinal(artigoFinal);

        this.licitacao = new Licitacao(new Revisor(new Utilizador(
                            "fatima", "ola@iml.com", "fafa", "1234")),
                            this.submissao, 0, null);
    }

    /**
     * Test of getListaLicitaveisComArtigosPorLicitarRevisor method, of class
     * LicitarArtigoController.
     */
    @Test
    public void testGetListaLicitaveisComArtigosPorLicitarRevisor() {
        System.out.println("getListaLicitaveisComArtigosPorLicitarRevisor");
        LicitarArtigoController instance = new LicitarArtigoController(empresa);
        boolean expResult = true;
        boolean result = instance.getListaLicitaveisComArtigosPorLicitarRevisor();
        assertEquals(expResult, result);
    }

    /**
     * Test of selecionarLicitavel method, of class LicitarArtigoController.
     */
    @Test
    public void testSelecionarLicitavel() {
        System.out.println("selecionarLicitavel");
        int indice = 0;
        LicitarArtigoController instance = new LicitarArtigoController(this.empresa);
        boolean expResult = true;
        instance.getListaLicitaveisComArtigosPorLicitarRevisor();
        boolean result = instance.selecionarLicitavel(indice);
        assertEquals(expResult, result);
    }

    /**
     * Test of novaLicitacao method, of class LicitarArtigoController.
     */
    @Test
    public void testNovaLicitacao() {
        System.out.println("novaLicitacao");
        Revisor revisor = this.revisor;
        Submissao s = this.submissao;
        LicitarArtigoController instance = new LicitarArtigoController(this.empresa);
        instance.getListaLicitaveisComArtigosPorLicitarRevisor();
        instance.selecionarLicitavel(0);
        boolean expResult = true;
        boolean result = instance.novaLicitacao(revisor, s);
        assertEquals(expResult, result);
    }

    /**
     * Test of inserirDadosLicitacao method, of class LicitarArtigoController.
     */
    @Test
    public void testInserirDadosLicitacao() {
        System.out.println("inserirDadosLicitacao");
        int grauInteresse = 0;
        Conflito conflito = new Conflito(revisor, submissao, new ArrayList());
        LicitarArtigoController instance = new LicitarArtigoController(this.empresa);
        instance.getListaLicitaveisComArtigosPorLicitarRevisor();
        instance.selecionarLicitavel(0);
        instance.novaLicitacao(revisor, this.submissao);
        boolean expResult = true;
        boolean result = instance.inserirDadosLicitacao(grauInteresse, conflito);
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionarListaLicitacoesTemporaria method, of class
     * LicitarArtigoController.
     */
    @Test
    public void testAdicionarListaLicitacoesTemporaria() {
        System.out.println("adicionarListaLicitacoesTemporaria");
        int grauInteresse = 0;
        Conflito conflito = new Conflito(revisor, submissao, new ArrayList());
        LicitarArtigoController instance = new LicitarArtigoController(this.empresa);
        instance.getListaLicitaveisComArtigosPorLicitarRevisor();
        instance.selecionarLicitavel(0);
        instance.novaLicitacao(revisor, this.submissao);
        //    instance.inserirDadosLicitacao(grauInteresse, conflito);
        boolean expResult = true;
        boolean result = instance.adicionarListaLicitacoesTemporaria();
        assertEquals(expResult, result);
    }

}
