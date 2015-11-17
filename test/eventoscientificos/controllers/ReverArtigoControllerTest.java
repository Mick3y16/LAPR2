package eventoscientificos.controllers;

import eventoscientificos.model.Artigo;
import eventoscientificos.model.CP;
import eventoscientificos.model.Empresa;
import eventoscientificos.model.Evento;
import eventoscientificos.model.Local;
import eventoscientificos.model.ProcessoDistribuicao;
import eventoscientificos.model.Revisao;
import eventoscientificos.model.Revisor;
import eventoscientificos.model.Submissao;
import eventoscientificos.model.Utilizador;
import eventoscientificos.model.state.evento.EventoEmLicitacaoState;
import eventoscientificos.model.state.evento.EventoEmRevisaoState;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * Teste à classe ReverArtigoController
 *
 * @author G01
 */
public class ReverArtigoControllerTest {

    private Empresa empresa;
    private Evento evento;
    private Submissao submissao;
    private Utilizador utilizador;
    private Revisor revisor;
    private Revisao revisao;

    public ReverArtigoControllerTest() {
        this.utilizador = new Utilizador(
                            "fatima", "ola@iml.com", "fafa", "1234");
        this.revisor = new Revisor(utilizador);
        this.empresa = new Empresa();
        this.empresa.setUtilizadorAutenticado(utilizador);
        this.evento = new Evento("titulo", "descricao", new Local("local"),
                            new Data(2016, 6, 8), new Data(2016, 6, 20),
                            new Data(2016, 7, 7), new Data(2016, 9, 10),
                            new Data(2016, 9, 11), new Data(2016, 10, 1),
                            new Data(2017, 6, 10));
        CP cp = new CP();
        cp.novoRevisor(utilizador);
        this.evento.setCP(cp);
        this.evento.setEstado(new EventoEmRevisaoState(evento));

        Artigo artigoInicial = new Artigo();
        Artigo artigoFinal = new Artigo();
        this.submissao = new Submissao();
        submissao.setArtigoInicial(artigoInicial);
        submissao.setArtigoFinal(artigoFinal);
        this.revisao = new Revisao(submissao, revisor);
        ProcessoDistribuicao pd = this.evento.novoProcessoDistribuicao();
        this.evento.adicionarProcessoDistribuicao(pd);
        this.evento.getProcessoDistribuicao().getListaRevisoes().adicionarRevisao(revisao);
        this.empresa.getRegistoEventos().adicionarEvento(evento);
    }

    /**
     * Test of getListaRevisiveisComArtigosPReverRevisor method, of class
     * ReverArtigoController.
     */
    @Test
    public void testGetListaRevisiveisComArtigosPReverRevisor() {
        System.out.println("getListaRevisiveisComArtigosPReverRevisor");
        ReverArtigoController instance = new ReverArtigoController(empresa);
        boolean expResult = true;
        boolean result = instance.getListaRevisiveisComArtigosPReverRevisor();
        assertEquals(expResult, result);
    }

    /**
     * Test of selecionarRevisivel method, of class ReverArtigoController.
     */
    @Test
    public void testSelecionarRevisivel() {
        System.out.println("selecionarRevisivel");
        int indice = 0;
        ReverArtigoController instance = new ReverArtigoController(empresa);
        boolean expResult = true;
        instance.getListaRevisiveisComArtigosPReverRevisor();
        boolean result = instance.selecionarRevisivel(indice);
        assertEquals(expResult, result);
    }

    /**
     * Test of selecionarRevisao method, of class ReverArtigoController.
     */
    @Test
    public void testSelecionarRevisao() {
        System.out.println("selecionarRevisao");
        int indiceRevisao = 0;
        ReverArtigoController instance = new ReverArtigoController(empresa);
        boolean expResult = true;
        instance.getListaRevisiveisComArtigosPReverRevisor();
        instance.selecionarRevisivel(0);
        boolean result = instance.selecionarRevisao(indiceRevisao);
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionarDadosRevisao method, of class ReverArtigoController.
     */
    @Test
    public void testAdicionarDadosRevisao() {
        System.out.println("adicionarDadosRevisao");
        int confianca = 0;
        int adequacao = 0;
        int originalidade = 0;
        int qualidade = 0;
        int recomendacao = 0;
        String textoJust = "ola";
        ReverArtigoController instance = new ReverArtigoController(empresa);
        instance.getListaRevisiveisComArtigosPReverRevisor();
        instance.selecionarRevisivel(0);
        instance.selecionarRevisao(0);
        boolean expResult = true;
        boolean result = instance.adicionarDadosRevisao(confianca, adequacao, originalidade, qualidade, recomendacao, textoJust);
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionarResultadoRevisao method, of class ReverArtigoController.
     */
    @Test
    public void testAdicionarResultadoRevisao() {
        System.out.println("adicionarResultadoRevisao");
        int confianca = 0;
        int adequacao = 1;
        int originalidade = 0;
        int qualidade = 0;
        int recomendacao = 0;
        String textoJust = "olaia";
        ReverArtigoController instance = new ReverArtigoController(empresa);
        instance.getListaRevisiveisComArtigosPReverRevisor();
        instance.selecionarRevisivel(0);
        instance.selecionarRevisao(0);
        instance.adicionarDadosRevisao(confianca, adequacao, originalidade, qualidade, recomendacao, textoJust);
        boolean expResult = true;
        boolean result = instance.adicionarResultadoRevisao();

        assertEquals(expResult, result);
    }

}
