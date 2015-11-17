package eventoscientificos.model;

import eventoscientificos.model.mecanismo.decisao.MecanismoDecisao1;
import eventoscientificos.model.state.evento.EventoEmSubmissaoCameraReadyState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaCPDefinidaState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaCriadaState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmDetecaoState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmDistribuicaoState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmLicitacaoState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmRevisaoState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmSubmissaoCameraReadyState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmSubmissaoState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaFaseDecisaoState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaRegistadaState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaState;
import eventoscientificos.model.state.submissao.SubmissaoAceiteState;
import eventoscientificos.model.state.submissao.SubmissaoEmSubmissaoState;
import eventoscientificos.model.state.submissao.SubmissaoRejeitadaState;
import eventoscientificos.model.state.submissao.SubmissaoRemovidaState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * Testa a classe SessaoTematica
 *
 * @author G01
 */
public class SessaoTematicaTest {

    private SessaoTematica sessaoTematica;
    private Utilizador utilizador;
    private Licitacao licitacao;
    private Submissao submissao;
    private Artigo artigoInicial;
    private Artigo artigoFinal;
    private Revisao revisao;

    public SessaoTematicaTest() {
        this.sessaoTematica = new SessaoTematica(
                "#A9D24R",
                "LAPR2",
                new Data(2015, 5, 22),
                new Data(2015, 5, 28),
                new Data(2015, 6, 10),
                new Data(2015, 6, 20),
                new Data(2015, 6, 24),
                new Data(2015, 6, 28),
                new Data(2015, 6, 30));
        this.utilizador = new Utilizador(
                "Pedro", "1140781@isep.ipp.pt", "pedro", "1234");
        this.sessaoTematica.novoProponente(new Utilizador(
                "Beatriz", "1140587@isep.ipp.pt", "beatriz", "1234"));
        this.licitacao = new Licitacao(new Revisor(new Utilizador(
                "fatima", "ola@iml.com", "fafa", "1234")),
                new Submissao(), 0, null);
        this.artigoInicial = new Artigo();
        this.artigoFinal = new Artigo();
        this.submissao = new Submissao();
        submissao.setArtigoInicial(artigoInicial);
        submissao.setArtigoFinal(artigoFinal);
        this.revisao = new Revisao(submissao, new Revisor(utilizador));
    }

    /**
     * Teste dos metodos set e get do código único, da classe SessaoTematica.
     */
    @Test
    public void testSetAndGetCodigoUnico() {
        System.out.println("setAndGetCodigoUnico");
        SessaoTematica instance = this.sessaoTematica;
        String expResult = "#123456";
        instance.setCodigoUnico(expResult);
        String result = instance.getCodigoUnico();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos metodos set e get da descrição, da classe SessaoTematica.
     */
    @Test
    public void testSetAndGetDescricao() {
        System.out.println("setAndGetDescricao");
        SessaoTematica instance = this.sessaoTematica;
        String expResult = "uma descrição";
        instance.setDescricao(expResult);
        String result = instance.getDescricao();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos metodos set e get da data de inicio de submissão, da classe
     * SessaoTematica.
     */
    @Test
    public void testSetAndGetDataInicioSubmissao() {
        System.out.println("setAndGetDataInicioSubmissao");
        SessaoTematica instance = this.sessaoTematica;
        Data expResult = new Data(2016, 5, 23);
        instance.setDataInicioSubmissao(expResult);
        Data result = instance.getDataInicioSubmissao();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos metodos set e get da data de fim de submissão, da classe
     * SessaoTematica.
     */
    @Test
    public void testSetAndGetDataFimSubmissao() {
        System.out.println("setAndGetDataFimSubmissao");
        SessaoTematica instance = this.sessaoTematica;
        Data expResult = new Data(2016, 5, 29);
        instance.setDataFimSubmissao(expResult);
        Data result = instance.getDataFimSubmissao();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos metodos set e get da data de início de distribuição, da classe
     * SessaoTematica.
     */
    @Test
    public void testSetAndGetDataInicioDistribuicao() {
        System.out.println("setAndGetDataInicioDistribuicao");
        SessaoTematica instance = this.sessaoTematica;
        Data expResult = new Data(2016, 5, 29);
        instance.setDataInicioDistribuicao(expResult);
        Data result = instance.getDataInicioDistribuicao();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos metodos set e get da data de fim de revisão, da classe
     * SessaoTematica.
     */
    @Test
    public void testSetAndGetDataFimRevisao() {
        System.out.println("setAndGetDataFimRevisao");
        SessaoTematica instance = this.sessaoTematica;
        Data expResult = new Data(2016, 5, 29);
        instance.setDataFimRevisao(expResult);
        Data result = instance.getDataFimRevisao();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos metodos set e get da data de fim submissão CameraReady, da
     * classe SessaoTematica.
     */
    @Test
    public void testSetAndGetDataFimSubmissaoCameraReady() {
        System.out.println("setAndGetDataFimSubmissaoCameraReady");
        SessaoTematica instance = this.sessaoTematica;
        Data expResult = new Data(2016, 6, 21);
        instance.setDataFimSubmissaoCameraReady(expResult);
        Data result = instance.getDataFimSubmissaoCameraReady();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos metodos set e get da data de inicio, da classe SessaoTematica.
     */
    @Test
    public void testSetAndGetDataInicio() {
        System.out.println("setAndGetDataInicio");
        SessaoTematica instance = this.sessaoTematica;
        Data expResult = new Data(2016, 6, 25);
        instance.setDataInicio(expResult);
        Data result = instance.getDataInicio();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos metodos set e get da data de fim, da classe SessaoTematica.
     */
    @Test
    public void testSetAndGetDataFim() {
        System.out.println("setAndGetDataFim");
        SessaoTematica instance = this.sessaoTematica;
        Data expResult = new Data(2016, 6, 29);
        instance.setDataFim(expResult);
        Data result = instance.getDataFim();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos metodos set e get da CP, da classe SessaoTematica.
     */
    @Test
    public void testSetAndGetCP() {
        System.out.println("setAndGetCP");
        SessaoTematica instance = this.sessaoTematica;
        CP expResult = new CP();
        instance.setCP(expResult);
        assertEquals(expResult, instance.getCP());
    }

    /**
     * Teste do método setAndGetEstado, da classe SessaoTematica.
     */
    @Test
    public void testSetAndGetEstado() {
        System.out.println("setAndGetEstado");
        SessaoTematica instance = this.sessaoTematica;
        SessaoTematicaState estado
                = new SessaoTematicaCriadaState(this.sessaoTematica);
        Class<? extends SessaoTematicaState> expResult = estado.getClass();
        Class<? extends SessaoTematicaState> result
                = instance.getEstado().getClass();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getListaSubmissoes, da classe SessaoTematica.
     */
    @Test
    public void testGetListaSubmissoes() {
        System.out.println("getListaSubmissoes");
        SessaoTematica instance = this.sessaoTematica;
        ListaSubmissoes expResult = new ListaSubmissoes();
        ListaSubmissoes result = instance.getListaSubmissoes();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos métodos set e get ProcessoDetecao, da classe SessaoTematica.
     */
    @Test
    public void testSetAndGetProcessoDetecao() {
        System.out.println("setAndGetProcessoDetecao");
        SessaoTematica instance = this.sessaoTematica;
        instance.setProcessoDetecao(new ProcessoDetecao(instance, new ArrayList()));
        ProcessoDetecao expResult = new ProcessoDetecao(instance, new ArrayList());
        ProcessoDetecao result = instance.getProcessoDetecao();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos métodos set e get do processo de decisão da classe
     * SessaoTematica.
     */
    @Test
    public void testSetAndGetProcessoDecisao() {
        System.out.println("setAndGetProcessoDecisao");
        SessaoTematica instance = this.sessaoTematica;
        ProcessoDecisao processoDecisao = new ProcessoDecisao();
        processoDecisao.adicionarMecanismoDecisao(new MecanismoDecisao1());
        processoDecisao.classificarSubmissoes(new ListaRevisoes());
        instance.setProcessoDecisao(processoDecisao);
        ProcessoDecisao expResult = processoDecisao;
        ProcessoDecisao result = instance.getProcessoDecisao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setCodigoUnico, da classe SessaoTematica.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetCodigoUnicoEmpty() {
        System.out.println("setCodigoUnicoEmpty");
        SessaoTematica instance = this.sessaoTematica;
        String codigoUnico = "";
        instance.setCodigoUnico(codigoUnico);
    }

    /**
     * Teste do método setCodigoUnico, da classe SessaoTematica.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDescricaoEmpty() {
        System.out.println("setDescricao");
        SessaoTematica instance = this.sessaoTematica;
        String descricao = "";
        instance.setDescricao(descricao);
    }

    /**
     * Teste do método setDataInicioSubmissao, da classe SessaoTematica.
     */
    @Test(expected = NullPointerException.class)
    public void testSetDataInicioSubmissaoNull() {
        System.out.println("setDataInicioSubmissaoNull");
        SessaoTematica instance = this.sessaoTematica;
        Data dataInicioSubmissao = null;
        instance.setDataInicioSubmissao(dataInicioSubmissao);
    }

    /**
     * Teste do método setDataFimRevisao, da classe SessaoTematica.
     */
    @Test(expected = NullPointerException.class)
    public void testSetDataFimRevisaoNull() {
        System.out.println("setDataFimRevisao");
        SessaoTematica instance = this.sessaoTematica;
        Data dataFimRevisao = null;
        instance.setDataFimRevisao(dataFimRevisao);
    }

    /**
     * Teste do método setDataFimSubmissao, da classe SessaoTematica.
     */
    @Test(expected = NullPointerException.class)
    public void testSetDataFimSubmissaoNull() {
        System.out.println("setDataFimSubmissaoNull");
        SessaoTematica instance = this.sessaoTematica;
        Data dataFimSubmissao = null;
        instance.setDataFimSubmissao(dataFimSubmissao);
    }

    /**
     * Teste do método setDataInicioDistribuicao, da classe SessaoTematica.
     */
    @Test(expected = NullPointerException.class)
    public void testSetDataInicioDistribuicaoNull() {
        System.out.println("setDataInicioDistribuicao");
        SessaoTematica instance = this.sessaoTematica;
        Data dataInicioDistribuicao = null;
        instance.setDataInicioDistribuicao(dataInicioDistribuicao);
    }

    /**
     * Teste do método setDataFimSubmissaoCameraReady, da classe SessaoTematica.
     */
    @Test(expected = NullPointerException.class)
    public void testSetDataFimSubmissaoCameraReadyNull() {
        System.out.println("setDataFimSubmissaoCameraReadyNull");
        SessaoTematica instance = this.sessaoTematica;
        Data dataFimSubmissaoCameraReady = null;
        instance.setDataFimSubmissaoCameraReady(dataFimSubmissaoCameraReady);
    }

    /**
     * Teste do método setDataInicio, da classe SessaoTematica.
     */
    @Test(expected = NullPointerException.class)
    public void testSetDataInicioNull() {
        System.out.println("setDataInicioNull");
        SessaoTematica instance = this.sessaoTematica;
        Data dataInicio = null;
        instance.setDataInicio(dataInicio);
    }

    /**
     * Teste do método setDataFim, da classe SessaoTematica.
     */
    @Test(expected = NullPointerException.class)
    public void testSetDataFimNull() {
        System.out.println("setDataNull");
        SessaoTematica instance = this.sessaoTematica;
        Data dataFim = null;
        instance.setDataFim(dataFim);
    }

    /**
     * Teste do método toString, da classe SessaoTematica.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SessaoTematica instance = this.sessaoTematica;
        String expResult = "    #A9D24R - LAPR2";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe SessaoTematica.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = this.sessaoTematica;
        SessaoTematica instance = this.sessaoTematica;
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe SessaoTematica.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equalsNot");
        Object outroObjeto = new SessaoTematica("#1234", "Sem descrição",
                new Data(2016, 1, 1), new Data(2016, 1, 7),
                new Data(2016, 1, 9), new Data(2016, 1, 26),
                new Data(2016, 2, 4), new Data(2016, 2, 6),
                new Data(2016, 2, 8));
        SessaoTematica instance = this.sessaoTematica;
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método novoProponente, da classe SessaoTematica.
     */
    @Test
    public void testNovoProponente() {
        System.out.println("novoProponente");
        SessaoTematica instance = this.sessaoTematica;
        boolean expResult = true;
        boolean result = instance.novoProponente(this.utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método novoProponente, da classe SessaoTematica.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNovoProponenteExists() {
        System.out.println("novoProponenteExists");
        SessaoTematica instance = this.sessaoTematica;
        instance.novoProponente(this.utilizador);
        instance.novoProponente(this.utilizador);
    }

    /**
     * Test of validarSessaoTematica method, of class SessaoTematica.
     */
    @Test
    public void testValidarSessaoTematica() {
        System.out.println("validarSessaoTematica");
        SessaoTematica instance = this.sessaoTematica;
        boolean expResult = true;
        boolean result = instance.validarSessaoTematica();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método temProponentes, da classe SessaoTematica.
     */
    @Test
    public void testTemProponentes() {
        System.out.println("temProponentes");
        SessaoTematica instance = this.sessaoTematica;
        boolean expResult = true;
        boolean result = instance.temProponentes();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método novaCP, da classe SessaoTematica.
     */
    @Test
    public void testNovaCP() {
        System.out.println("novaCP");
        SessaoTematica instance = this.sessaoTematica;
        CP expResult = new CP();
        CP result = instance.novaCP();
        assertEquals(expResult, result);
    }

    /**
     * Teste ao metodo adicionarCP, da classe SessaoTematica.
     */
    @Test
    public void testAdicionarCP() {
        System.out.println("adicionarCP");
        SessaoTematica instance = this.sessaoTematica;
        sessaoTematica.setEstado(
                new SessaoTematicaRegistadaState(sessaoTematica));
        CP cp = new CP();
        boolean expResult = true;
        boolean result = instance.adicionarCP(cp);
        assertEquals(expResult, result);
    }

    /**
     * Teste ao método setEmSubmissao, da classe SessaoTematica.
     */
    @Test
    public void testSetEmSubmissao() {
        System.out.println("setEmSubmissao");
        SessaoTematica instance = this.sessaoTematica;
        instance.setEstado(new SessaoTematicaCPDefinidaState(instance));
        boolean expResult = true;
        boolean result = instance.setEmSubmissao();
        assertEquals(expResult, result);
    }

    /**
     * Teste ao método isProponente, da classe SessaoTematica.
     */
    @Test
    public void testIsProponente() {
        System.out.println("isProponente");
        SessaoTematica instance = this.sessaoTematica;
        instance.novoProponente(this.utilizador);
        boolean expResult = true;
        boolean result = instance.isProponente(this.utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Teste ao método iniciarProcessoDetecao, da classe SessaoTematica.
     */
    @Test
    public void testIniciarProcessoDetecao() {
        System.out.println("iniciarProcessoDetecao");
        List<TipoConflito> listaTiposConflito = new ArrayList();
        SessaoTematica instance = this.sessaoTematica;
        instance.adicionarCP(new CP());
        instance.setEstado(new SessaoTematicaEmSubmissaoState(instance));
        instance.iniciarProcessoDetecao(listaTiposConflito);
        Class<? extends SessaoTematicaState> expResult
                = new SessaoTematicaEmLicitacaoState(instance).getClass();
        Class<? extends SessaoTematicaState> result
                = instance.getEstado().getClass();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaLicitacoes method, of class SessãoTematica.
     */
    @Test
    public void testGetListaLicitacoes() {
        System.out.println("getListaLicitacoes");
        SessaoTematica instance = this.sessaoTematica;
        ListaLicitacoes expResult = new ListaLicitacoes();
        ListaLicitacoes result = instance.getListaLicitacoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getConflitoRevisorSubmissao method, of class SessaoTematica.
     */
    @Test
    public void testGetConflitoRevisorSubmissao() {
        System.out.println("getConflitoRevisorSubmissao");
        Revisor revisor = new Revisor(new Utilizador(
                "Tiago", "1131658@isep.ipp.pt", "tiago", "1234"));
        Submissao submissao = new Submissao();
        submissao.setArtigoFinal(new Artigo());
        submissao.setArtigoInicial(new Artigo());

        Conflito c = new Conflito(revisor, submissao, new ArrayList());
        SessaoTematica instance = this.sessaoTematica;
        instance.setProcessoDetecao(new ProcessoDetecao(instance, new ArrayList()));
        instance.getProcessoDetecao().getListaConflito().adicionarConflito(c);

        Conflito expResult = c;
        Conflito result = instance.getConflitoRevisorSubmissao(revisor, submissao);
        assertEquals(expResult, result);
    }

    /**
     * Test of isStateValidoParaLicitar method, of class SessaoTematica.
     */
    @Test
    public void testIsStateValidoParaLicitarNot() {
        System.out.println("isStateValidoParaLicitarNot");
        this.sessaoTematica.setEstado(new SessaoTematicaCriadaState(sessaoTematica));
        SessaoTematicaState instance = this.sessaoTematica.getEstado();
        boolean expResult = false;
        boolean result = instance.isStateValidoParaLicitar();
        assertEquals(expResult, result);

    }

    /**
     * Test of isStateValidoParaLicitar method, of class SessaoTematica.
     */
    @Test
    public void testIsStateValidoParaLicitarValido() {
        System.out.println("isStateValidoParaLicitarValido");
        this.sessaoTematica.setEstado(new SessaoTematicaEmLicitacaoState(sessaoTematica));
        this.sessaoTematica.setCP(new CP());
        this.sessaoTematica.getCP().novoRevisor(this.utilizador);
        boolean expResult = true;
        boolean result = this.sessaoTematica.isStateValidoParaLicitar(this.utilizador);
        assertEquals(expResult, result);

    }

    /**
     * Test of isStateValidoParaLicitar method, of class Evento.
     */
    @Test
    public void testIsStateValidoParaLicitarEstadoInvalido() {
        System.out.println("isStateValidoParaLicitarValido");
        this.sessaoTematica.setEstado(new SessaoTematicaEmDetecaoState(sessaoTematica));
        this.sessaoTematica.setCP(new CP());
        this.sessaoTematica.getCP().novoRevisor(this.utilizador);
        boolean expResult = false;
        boolean result = this.sessaoTematica.isStateValidoParaLicitar(this.utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Test of isStateValidoParaLicitar method, of class Evento.
     */
    @Test
    public void testIsStateValidoParaLicitarComLicitacao() {
        System.out.println("isStateValidoParaLicitarValido");
        this.sessaoTematica.setEstado(new SessaoTematicaEmLicitacaoState(sessaoTematica));
        this.sessaoTematica.setCP(new CP());
        this.sessaoTematica.getCP().novoRevisor(this.utilizador);
        List<Licitacao> listaTeste = new ArrayList<>();
        listaTeste.add(licitacao);
        this.sessaoTematica.getListaLicitacoes().adicionarListaLicitacoesTemporaria(listaTeste);
        boolean expResult = true;
        boolean result = this.sessaoTematica.isStateValidoParaLicitar(this.utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Test of isRegistada method, of class SessaoTematica.
     */
    @Test
    public void testIsRegistada() {
        System.out.println("isRegistada");
        SessaoTematica instance = this.sessaoTematica;
        instance.setEstado(new SessaoTematicaRegistadaState(instance));
        boolean expResult = true;
        boolean result = instance.isRegistada();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método isStateValidoParaSubmeter, da classe SessaoTematica.
     */
    @Test
    public void testIsStateValidoParaSubmeter() {
        System.out.println("isStateValidoParaSubmeter");
        SessaoTematica instance = this.sessaoTematica;
        instance.setEstado(new SessaoTematicaEmSubmissaoState(sessaoTematica));
        boolean expResult = true;
        boolean result = instance.isStateValidoParaSubmeter();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método isStateValidoParaAlterar, da classe SessaoTematica.
     */
    @Test
    public void testIsStateValidoParaAlterar() {
        System.out.println("isStateValidoParaAlterar");
        SessaoTematica instance = this.sessaoTematica;
        instance.setEstado(new SessaoTematicaEmSubmissaoState(sessaoTematica));
        boolean expResult = true;
        boolean result = instance.isStateValidoParaAlterar();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método isUtilizadorUmAutorSubmissao, da classe SessaoTematica.
     */
    @Test
    public void testIsUtilizadorUmAutorSubmissao() {
        System.out.println("isUtilizadorUmAutorSubmissao");
        Utilizador utilizador = this.utilizador;
        Submissao submissao = new Submissao();
        submissao.setEstado(new SubmissaoEmSubmissaoState(submissao));
        submissao.setArtigoInicial(this.artigoInicial);
        submissao.getArtigoInicial().getListaAutores().novoAutor(utilizador, new InstituicaoAfiliacao("ISEP"));
        ListaSubmissoes instance = new ListaSubmissoes();
        instance.adicionarSubmissao(submissao);
        boolean expResult = true;
        boolean result = instance.isUtilizadorUmAutorSubmissao(utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método NovoProcessoDistribuicao, da classe SessaoTematica.
     */
    @Test(expected = NullPointerException.class)
    public void testNovoProcessoDistribuicao() {
        System.out.println("novoProcessoDistribuicao");
        SessaoTematica instance = this.sessaoTematica;
        this.sessaoTematica.setEstado(new SessaoTematicaEmDistribuicaoState(sessaoTematica));
        ProcessoDistribuicao expResult = new ProcessoDistribuicao();
        ProcessoDistribuicao result = instance.novoProcessoDistribuicao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método AdicionarProcessoDistribuicao, da classe SessaoTematica.
     */
    @Test
    public void testAdicionarProcessoDistribuicao() {
        System.out.println("adicionarProcessoDistribuicao");
        this.sessaoTematica.setEstado(new SessaoTematicaEmDistribuicaoState(sessaoTematica));
        ProcessoDistribuicao pd = new ProcessoDistribuicao();
        boolean expResult = true;
        SessaoTematica instance = this.sessaoTematica;
        boolean result = instance.adicionarProcessoDistribuicao(pd);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getProcessoDistribuicao, da classe SessaoTematica.
     */
    @Test(expected = NullPointerException.class)
    public void testGetProcessoDistribuicao() {
        System.out.println("getProcessoDistribuicao");
        this.sessaoTematica.adicionarProcessoDistribuicao(new ProcessoDistribuicao());
        ProcessoDistribuicao expResult = new ProcessoDistribuicao();
        SessaoTematica instance = this.sessaoTematica;
        ProcessoDistribuicao result = instance.getProcessoDistribuicao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método isStateValidoParaDistribuir, da classe SessaoTematica.
     */
    @Test
    public void testIsStateValidoParaDistribuir() {
        System.out.println("isStateValidoParaDistribuir");
        this.sessaoTematica.setEstado(new SessaoTematicaEmDistribuicaoState(sessaoTematica));
        boolean adicionado = this.sessaoTematica.novoProponente(utilizador);
        boolean expResult = true;
        boolean result = this.sessaoTematica.isStateValidoParaDistribuir(utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método isStateValidoParaDistribuir, da classe SessaoTematica.
     */
    @Test
    public void testIsStateValidoParaDistribuirNot() {
        System.out.println("isStateValidoParaDistribuir");
        this.sessaoTematica.setEstado(new SessaoTematicaEmLicitacaoState(sessaoTematica));
        this.sessaoTematica.novoProponente(utilizador);
        boolean expResult = false;
        boolean result = this.sessaoTematica.isStateValidoParaDistribuir(utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método temSubmissoesRetiradas method, da classe SessaoTematica.
     */
    @Test
    public void testTemSubmissoesRetiradas() {
        System.out.println("temSubmissoesRetiradas");
        Utilizador utilizador = new Utilizador(
                "Pedro", "1140781@isep.ipp.pt", "pedro", "1234");
        Proponente proponente = new Proponente(utilizador);
        sessaoTematica.novoProponente(utilizador);
        this.submissao.setEstado(new SubmissaoRemovidaState(submissao));
        this.sessaoTematica.getListaSubmissoes().adicionarSubmissao(submissao);
        boolean expResult = true;
        boolean result = this.sessaoTematica.temSubmissoesRetiradas(utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getListaSubmissoesRetiradas, na classe Evento.
     */
    @Test
    public void testGetListaSubmissoesRetiradas() {
        System.out.println("getListaSubmissoesRetiradas");
        Submissao submissao = this.submissao;
        submissao.setEstado(new SubmissaoRemovidaState(submissao));
        SessaoTematica instance = this.sessaoTematica;
        instance.setEstado(new SessaoTematicaEmSubmissaoCameraReadyState(sessaoTematica));
        instance.novoProponente(utilizador);
        instance.getListaSubmissoes().adicionarSubmissao(submissao);
        instance.getListaSubmissoesRetiradas().add(submissao);
        int expResult = 1;
        int result = (instance.getListaSubmissoesRetiradas()).size();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método isStateValidoParaRever, da classe SessaoTematica.
     */
    @Test
    public void testIsStateValidoParaRever() {
        System.out.println("isStateValidoParaRever");
        this.sessaoTematica.setEstado(new SessaoTematicaEmRevisaoState(sessaoTematica));
        this.sessaoTematica.adicionarCP(new CP());
        this.sessaoTematica.getCP().novoRevisor(utilizador);
        ProcessoDistribuicao pd = this.sessaoTematica.novoProcessoDistribuicao();
        this.sessaoTematica.adicionarProcessoDistribuicao(pd);
        ListaRevisoes lr = pd.getListaRevisoes();
        lr.adicionarRevisao(this.revisao);
        boolean expResult = true;
        boolean result = this.sessaoTematica.isStateValidoParaRever(utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método isEstadoValidoParaDecidir, da classe SessaoTematica.
     */
    @Test
    public void testIsEstadoValidoParaDecidir() {
        System.out.println("isEstadoValidoParaDecidir");
        SessaoTematica instance = this.sessaoTematica;
        instance.setEstado(new SessaoTematicaEmRevisaoState(sessaoTematica));
        boolean expResult = false;
        boolean result = instance.isEstadoValidoParaDecidir();
        assertEquals(expResult, result);
    }

    /**
     * Test of isStateValidoParaRemover method, of class SessaoTematica.
     */
    @Test
    public void testIsStateValidoParaRemover() {
        System.out.println("isStateValidoParaRemover");
        Utilizador u = new Utilizador("fatima", "mail@isep.ipp.pt", "fafa", "1235");
        SessaoTematica instance = this.sessaoTematica;
        instance.setEstado(new SessaoTematicaEmSubmissaoState(sessaoTematica));
        instance.getListaSubmissoes().adicionarSubmissao(submissao);
        boolean expResult = false;
        boolean result = instance.isStateValidoParaRemover(u);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getNumeroProponentes, da classe SessoesTematica.
     */
    @Test
    public void testGetNumeroProponentes() {
        System.out.println("getNumeroProponentes");
        SessaoTematica instance = this.sessaoTematica;
        instance.novoProponente(this.utilizador);
        int expResult = 2;
        int result = instance.getNumeroProponentes();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getProponentePeloID, da classe SessaoTematica.
     */
    @Test
    public void testGetProponentePeloID() {
        System.out.println("getProponentePeloID");
        int indice = 1;
        SessaoTematica instance = this.sessaoTematica;
        instance.novoProponente(this.utilizador);
        Proponente expResult = new Proponente(this.utilizador);
        Proponente result = instance.getProponentePeloID(indice);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método novoProcessoDecisao, da classe SessaoTematica.
     */
    @Test
    public void testNovoProcessoDecisao() {
        System.out.println("novoProcessoDecisao");
        SessaoTematica instance = this.sessaoTematica;
        instance.setEstado(new SessaoTematicaFaseDecisaoState(sessaoTematica));
        ProcessoDecisao expResult = new ProcessoDecisao();
        ProcessoDecisao result = instance.novoProcessoDecisao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método adicionarProcessoDecisao, da classe SessaoTematica.
     */
    @Test
    public void testAdicionarProcessoDecisao() {
        System.out.println("adicionarProcessoDecisao");
        this.sessaoTematica.setEstado(new SessaoTematicaFaseDecisaoState(sessaoTematica));
        ProcessoDecisao processoDecisao = new ProcessoDecisao();
        boolean expResult = true;
        SessaoTematica instance = this.sessaoTematica;
        boolean result = instance.adicionarProcessoDecisao(processoDecisao);
        assertEquals(expResult, result);
    }

    /**
     * Test of isStateValidoParaSubmeterArtigoFinal method, of class
     * SessaoTematica.
     */
    @Test
    public void testIsStateValidoParaSubmeterArtigoFinal() {
        System.out.println("isStateValidoParaSubmeterArtigoFinal");
        SessaoTematica instance = this.sessaoTematica;
        instance.setEstado(new SessaoTematicaEmSubmissaoCameraReadyState(sessaoTematica));
        boolean expResult = true;
        boolean result = instance.isStateValidoParaSubmeterArtigoFinal();
        assertEquals(expResult, result);

    }

    /**
     * Test of isUtilizadorUmAutorSubmissaoInicial method, of class
     * SessaoTematica.
     */
    @Test
    public void testIsUtilizadorUmAutorSubmissaoInicial() {
        System.out.println("isUtilizadorUmAutorSubmissaoInicial");
        SessaoTematica instance = this.sessaoTematica;

        Utilizador utilizador = new Utilizador(
                "bea", "11405431@isep.ipp.pt", "bea", "12345");
        Submissao submissao = new Submissao();
        submissao.setEstado(new SubmissaoAceiteState(submissao));
        Artigo artigo = new Artigo();
        artigo.getListaAutores().novoAutor(utilizador, new InstituicaoAfiliacao("ISEP"));
        submissao.setArtigoInicial(artigo);
        instance.getListaSubmissoes().adicionarSubmissao(submissao);

        boolean expResult = true;
        boolean result = instance.isUtilizadorUmAutorSubmissaoInicial(utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashMapSubmissoesSessaoTematica method, of class SessaoTematica.
     */
    @Test
    public void testHashMapSubmissoesSessaoTematica() {
        System.out.println("hashMapSubmissoesSessaoTematica");
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
