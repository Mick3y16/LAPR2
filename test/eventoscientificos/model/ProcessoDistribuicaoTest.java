/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos.model;

import eventoscientificos.model.mecanismo.distribuicao.MecanismoDistribuicao;
import eventoscientificos.model.mecanismo.distribuicao.MecanismoDistribuicaoTodasSubmissoesPorRevisor;
import eventoscientificos.model.state.evento.EventoEmSubmissaoCameraReadyState;
import eventoscientificos.model.state.submissao.SubmissaoAceiteState;
import eventoscientificos.model.state.submissao.SubmissaoEmLicitacaoState;
import eventoscientificos.model.state.submissao.SubmissaoRejeitadaState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * Teste à classe ProcessoDistribuicao
 *
 * @author G01
 */
public class ProcessoDistribuicaoTest {

    private Submissao submissao;
    private Revisor revisor;
    private Evento evento;

    public ProcessoDistribuicaoTest() {
        String titulo = "sem titulo";
        String descricao = "descricao";
        Local local = new Local("local");
        Data dataInicioSubmissao = new Data(2016, 6, 8);
        Data dataFimSubmissao = new Data(2016, 6, 20);
        Data dataInicioDistribuicao = new Data(2016, 7, 30);
        Data dataFimRevisao = new Data(2016, 8, 15);
        Data dataFimSubmissaoCameraReady = new Data(2016, 8, 30);
        Data dataInicio = new Data(2016, 10, 9);
        Data dataFim = new Data(2017, 6, 10);

        Artigo artigoInicial = new Artigo();
        Artigo artigoFinal = new Artigo();
        this.submissao = new Submissao();

        this.revisor = new Revisor(new Utilizador("nome",
                            "1140587@isep.ipp.pt",
                            "username",
                            "password"));
        this.evento = new Evento(titulo, descricao, local, dataInicioSubmissao,
                            dataFimSubmissao, dataInicioDistribuicao, dataFimRevisao,
                            dataFimSubmissaoCameraReady, dataInicio, dataFim);
  Submissao submissao1 = new Submissao();
        submissao1.setArtigoInicial(new Artigo());
        submissao1.setArtigoFinal(new Artigo());
        submissao1.setEstado(new SubmissaoEmLicitacaoState(submissao1));

        Submissao submissao2 = new Submissao();
        submissao2.setArtigoInicial(new Artigo());
        submissao2.setArtigoFinal(new Artigo());
        submissao2.setEstado(new SubmissaoEmLicitacaoState(submissao2));

        Submissao submissao3 = new Submissao();
        submissao3.setArtigoInicial(new Artigo());
        submissao3.setArtigoFinal(new Artigo());
        submissao3.setEstado(new SubmissaoEmLicitacaoState(submissao3));

        this.evento.getListaSubmissoes().adicionarSubmissao(submissao1);
        this.evento.getListaSubmissoes().adicionarSubmissao(submissao2);
        this.evento.getListaSubmissoes().adicionarSubmissao(submissao3);

        this.evento.adicionarCP(new CP());
        this.evento.getCP().novoRevisor(new Utilizador("nome",
                            "1140587@isep.ipp.pt",
                            "username",
                            "password"));
        this.evento.getCP().novoRevisor(new Utilizador("nome",
                            "1140805@isep.ipp.pt",
                            "user",
                            "password"));
        this.evento.getCP().novoRevisor(new Utilizador("nome",
                            "1130909@isep.ipp.pt",
                            "fifi",
                            "password"));

        this.evento.adicionarProcessoDistribuicao(new ProcessoDistribuicao());

        Distribuivel distribuivel = this.evento;
    }

    /**
     * Test of adicionarMecanismoDistribuicao method, of class
     * ProcessoDistribuicao.
     */
    @Test
    public void testAdicionarMecanismoDistribuicao() {
        System.out.println("adicionarMecanismoDistribuicao");
        MecanismoDistribuicao mecanismoDistribuicao = new MecanismoDistribuicaoTodasSubmissoesPorRevisor();
        ProcessoDistribuicao instance = new ProcessoDistribuicao();
        boolean expResult = true;
        boolean result = instance.adicionarMecanismoDistribuicao(mecanismoDistribuicao);
        assertEquals(expResult, result);

    }

    /**
     * Test of distribuirRevisoes method, of class ProcessoDistribuicao.
     */
    @Test
    public void testDistribuirRevisoes() {
        System.out.println("distribuirRevisoes");

        Submissao submissao1 = new Submissao();
        submissao1.setArtigoInicial(new Artigo());
        submissao1.setArtigoFinal(new Artigo());
        submissao1.setEstado(new SubmissaoEmLicitacaoState(submissao1));

        Submissao submissao2 = new Submissao();
        submissao2.setArtigoInicial(new Artigo());
        submissao2.setArtigoFinal(new Artigo());
        submissao2.setEstado(new SubmissaoEmLicitacaoState(submissao2));

        Submissao submissao3 = new Submissao();
        submissao3.setArtigoInicial(new Artigo());
        submissao3.setArtigoFinal(new Artigo());
        submissao3.setEstado(new SubmissaoEmLicitacaoState(submissao3));

        this.evento.getListaSubmissoes().adicionarSubmissao(submissao1);
        this.evento.getListaSubmissoes().adicionarSubmissao(submissao2);
        this.evento.getListaSubmissoes().adicionarSubmissao(submissao3);

        this.evento.adicionarCP(new CP());
        this.evento.getCP().novoRevisor(new Utilizador("nome",
                            "1140587@isep.ipp.pt",
                            "username",
                            "password"));
        this.evento.getCP().novoRevisor(new Utilizador("nome",
                            "1140805@isep.ipp.pt",
                            "user",
                            "password"));
        this.evento.getCP().novoRevisor(new Utilizador("nome",
                            "1130909@isep.ipp.pt",
                            "fifi",
                            "password"));

        this.evento.adicionarProcessoDistribuicao(new ProcessoDistribuicao());

        Distribuivel distribuivel = this.evento;
        ProcessoDistribuicao instance = this.evento.getProcessoDistribuicao();
        instance.adicionarMecanismoDistribuicao(new MecanismoDistribuicaoTodasSubmissoesPorRevisor());
        ListaRevisoes expResult = distribuivel.getProcessoDistribuicao().distribuirRevisoes(distribuivel);
        ListaRevisoes result = instance.distribuirRevisoes(distribuivel);
        assertEquals(expResult, result);
    }

    /**
     * Test of distribuirRevisoes method, of class ProcessoDistribuicao.
     */
    @Test(expected = NullPointerException.class)
    public void testDistribuirRevisoesNull() {
        System.out.println("distribuirRevisoesNull");
        Distribuivel distribuivel = this.evento;
        ProcessoDistribuicao instance = new ProcessoDistribuicao();
        ListaRevisoes expResult = new ListaRevisoes();
        ListaRevisoes result = instance.distribuirRevisoes(distribuivel);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaRevisoes method, of class ProcessoDistribuicao.
     */
    @Test
    public void testGetListaRevisoes() {
        System.out.println("getListaRevisoes");
        ProcessoDistribuicao instance = new ProcessoDistribuicao();
        ListaRevisoes expResult = new ListaRevisoes();
        ListaRevisoes result = instance.getListaRevisoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ProcessoDistribuicao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjecto = null;
        ProcessoDistribuicao instance = new ProcessoDistribuicao();
        boolean expResult = false;
        boolean result = instance.equals(outroObjecto);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashMapSubmissoes method, of class ProcessoDistribuicao.
     */
    @Test
    public void testHashMapSubmissoes() {
                Evento evento = new Evento("titulo", "descricao", new Local("local"),
                new Data(2016, 6, 8), new Data(2016, 6, 20),
                new Data(2016, 7, 7), new Data(2016, 8, 15),
                new Data(2016, 9, 10), new Data(2016, 10, 1),
                new Data(2017, 6, 10));

        List<String> palavrasChaves = new ArrayList<>();
        palavrasChaves.add("praia");
        Submissao submissao = new Submissao();
        Artigo artigo = new Artigo();
        artigo.getListaAutores().novoAutor(new Utilizador("nome", "sad@isep.pt", "isernamo", "FVD"), new InstituicaoAfiliacao("ISEP"));
        artigo.setPalavrasChave(palavrasChaves);
        submissao.setArtigoInicial(artigo);

        Revisao revisao = new Revisao(submissao, new Revisor(new Utilizador(
                "bea", "1140781@isep.ipp.pt", "pedro", "12345")));
        revisao.setRecomendacaoGlobal(1);
        submissao.setEstado(new SubmissaoAceiteState(submissao));

        List<String> palavrasChaves1 = new ArrayList<>();
        palavrasChaves1.add("sumo");
        Submissao submissao1 = new Submissao();
        Artigo artigo1 = new Artigo();
        artigo1.setTitulo("isep");
        artigo1.getListaAutores().novoAutor(new Utilizador("nome", "sad@isep.pt", "isernamo", "FVD"), new InstituicaoAfiliacao("ISEP"));
        artigo1.setPalavrasChave(palavrasChaves1);
        submissao1.setArtigoInicial(artigo1);
        Revisao revisao1 = new Revisao(submissao1, new Revisor(new Utilizador(
                "bea", "1140781@isep.ipp.pt", "pedro", "12345")));
        revisao1.setRecomendacaoGlobal(0);
        submissao1.setEstado(new SubmissaoRejeitadaState(submissao1));

        ProcessoDistribuicao processo = new ProcessoDistribuicao();
        processo.getListaRevisoes().adicionarRevisao(revisao);
        processo.getListaRevisoes().adicionarRevisao(revisao1);
        evento.adicionarProcessoDistribuicao(processo);

        evento.setEstado(new EventoEmSubmissaoCameraReadyState(evento));

        HashMap<String, Integer> hashMapSubmissoesAceites = new HashMap<>();
        HashMap<String, Integer> hashMapSubmissoesRejeitadas = new HashMap<>();
        evento.hashMapSubmissoes(hashMapSubmissoesAceites, hashMapSubmissoesRejeitadas);
    }
}
