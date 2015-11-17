package eventoscientificos.model;

import eventoscientificos.model.mecanismo.decisao.MecanismoDecisao1;
import eventoscientificos.model.state.evento.EventoCriadoState;
import eventoscientificos.model.state.evento.EventoEmDetecaoConflitos;
import eventoscientificos.model.state.evento.EventoEmDistribuicaoState;
import eventoscientificos.model.state.evento.EventoEmLicitacaoState;
import eventoscientificos.model.state.evento.EventoEmRevisaoState;
import eventoscientificos.model.state.evento.EventoEmSubmissaoCameraReadyState;
import eventoscientificos.model.state.evento.EventoEmSubmissaoState;
import eventoscientificos.model.state.evento.EventoFaseDecisaoState;
import eventoscientificos.model.state.evento.EventoRegistadoState;
import eventoscientificos.model.state.evento.EventoSessoesTematicasDefinidasState;
import eventoscientificos.model.state.evento.EventoState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmSubmissaoCameraReadyState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmSubmissaoState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaFaseDecisaoState;
import eventoscientificos.model.state.submissao.SubmissaoAceiteState;
import eventoscientificos.model.state.submissao.SubmissaoEmCameraReadyState;
import eventoscientificos.model.state.submissao.SubmissaoEmSubmissaoState;
import eventoscientificos.model.state.submissao.SubmissaoRejeitadaState;
import eventoscientificos.model.state.submissao.SubmissaoRemovidaState;
import eventoscientificos.model.state.submissao.SubmissaoRevistaState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * @author G01
 */
public class EventoTest {

    private Evento evento;
    private Utilizador utilizador;
    private Licitacao licitacao;
    private Submissao submissao;
    private Artigo artigoInicial;
    private Artigo artigoFinal;
    private Revisao revisao;
    private Revisao revisao2;
    private Revisao r;

    public EventoTest() {
        this.evento = new Evento("titulo", "descricao", new Local("local"),
                new Data(2016, 6, 8), new Data(2016, 6, 20),
                new Data(2016, 7, 7), new Data(2016, 8, 15),
                new Data(2016, 9, 10), new Data(2016, 10, 1),
                new Data(2017, 6, 10));
        this.utilizador = new Utilizador(
                "Pedro", "1140781@isep.ipp.pt", "pedro", "12345");
        this.artigoInicial = new Artigo();
        this.artigoFinal = new Artigo();
        this.submissao = new Submissao();
        submissao.setArtigoInicial(artigoInicial);
        submissao.setArtigoFinal(artigoFinal);
        this.licitacao = new Licitacao(new Revisor(new Utilizador(
                "fatima", "ola@iml.com", "fafa", "1234")),
                this.submissao, 0, null);
        this.revisao = new Revisao(submissao, new Revisor(utilizador));

        this.r = new Revisao(submissao, new Revisor(utilizador));

        r.setAdequacaoArtigo(5);
        r.setConfiancaRevisor(4);
        r.setOriginalidadeArtigo(3);
        r.setQualidadeArtigo(4);
        r.setRecomendacaoGlobal(2);
        r.setTextoJustificativo("ola");
    }

    /**
     * Teste dos metodos set e get do titulo, da classe Evento.
     */
    @Test
    public void testSetAndGetTitulo() {
        System.out.println("setAngetTitulo");
        Evento instance = this.evento;
        String expResult = "titulo";
        instance.setTitulo(expResult);
        String result = instance.getTitulo();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos metodos set e get da descricao, da classe Evento..
     */
    @Test
    public void testSetAndGetDescricao() {
        System.out.println("setAndGetDescricao");
        Evento instance = this.evento;
        String expResult = "descricao";
        instance.setDescricao(expResult);
        String result = instance.getDescricao();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos metodos set e get do local, da classe Evento.
     */
    @Test
    public void testSetAndGetLocal() {
        System.out.println("setAndGetLocal");
        Evento instance = this.evento;
        Local expResult = new Local("isep");
        instance.setLocal(expResult);
        Local result = instance.getLocal();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos metodos set e get da data de inicio, da classe Evento.
     */
    @Test
    public void testSetAndGetDataInicio() {
        System.out.println("setAndGetDataInicio");
        Evento instance = this.evento;
        Data expResult = new Data();
        instance.setDataInicio(expResult);
        Data result = instance.getDataInicio();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos metodos set e get da data de fim, da classe Evento.
     */
    @Test
    public void testSetAndGetDataFim() {
        System.out.println("setAndGetDataFim");
        Evento instance = this.evento;
        Data expResult = new Data();
        instance.setDataFim(expResult);
        Data result = instance.getDataFim();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos metodos set e get da data de inicio de submissao, da classe
     * Evento.
     */
    @Test
    public void testSetAndGetDataInicioSubmissao() {
        System.out.println("setAndGetDataInicioSubmissao");
        Evento instance = this.evento;
        Data expResult = new Data();
        instance.setDataInicioSubmissao(expResult);
        Data result = instance.getDataInicioSubmissao();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos metodos set e get da data de fim de submissao, da classe
     * Evento.
     */
    @Test
    public void testSetAndGetDataFimSubmissao() {
        System.out.println("setAndGetDataFimSubmissao");
        Evento instance = this.evento;
        Data expResult = new Data();
        instance.setDataFimSubmissao(expResult);
        Data result = instance.getDataFimSubmissao();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos metodos set e get da data de inicio de distribuicao, da classe
     * Evento.
     */
    @Test
    public void testSetAndGetDataInicioDistribuicao() {
        System.out.println("setAndGetDataInicioDistribuicao");
        Evento instance = this.evento;
        Data expResult = new Data();
        instance.setDataInicioDistribuicao(expResult);
        Data result = instance.getDataInicioDistribuicao();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos metodos set e get da data de fim de revisao, da classe Evento.
     */
    @Test
    public void testSetAndGetDataFimRevisao() {
        System.out.println("setAndGetDataFimRevisao");
        Evento instance = this.evento;
        Data expResult = new Data();
        instance.setDataFimRevisao(expResult);
        Data result = instance.getDataFimRevisao();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos metodos set e get da data de fim de submissao camera ready, da
     * classe Evento.
     */
    @Test
    public void testSetAndGetDataFimSubmissaoCameraReady() {
        System.out.println("setAndGetDataFimSubmissaoCameraReady");
        Evento instance = this.evento;
        Data expResult = new Data();
        instance.setDataFimSubmissaoCameraReady(expResult);
        Data result = instance.getDataFimSubmissaoCameraReady();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos métodos set e get do estado do evento, da classe evento.
     */
    @Test
    public void testSetAndGetEstado() {
        System.out.println("setAndGetEstado");
        Evento instance = this.evento;
        EventoState estado = new EventoCriadoState(this.evento);
        Class<? extends EventoState> expResult = estado.getClass();
        Class<? extends EventoState> result = instance.getEstado().getClass();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos metodos set e get da CP, da classe Evento.
     */
    @Test
    public void testSetAndGetCP() {
        System.out.println("setAndGetCP");
        Evento instance = this.evento;
        instance.setCP(new CP());
        CP expResult = new CP();
        CP result = instance.getCP();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getListaSessoesTematicas, da classe Evento.
     */
    @Test
    public void testGetListaSessoesTematica() {
        System.out.println("getListaSessoesTematicas");
        Evento instance = this.evento;
        ListaSessoesTematicas expResult
                = new ListaSessoesTematicas(this.evento);
        ListaSessoesTematicas result = instance.getListaSessoesTematicas();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo setTitulo, da classe Evento.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetTituloEmpty() {
        System.out.println("setTituloEmpty");
        String titulo = "";
        Evento instance = this.evento;
        instance.setTitulo(titulo);
    }

    /**
     * Teste do metodo setDescricao, da classe Evento.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDescricaoEmpty() {
        System.out.println("setDescricaoEmpty");
        String descricao = "";
        Evento instance = this.evento;
        instance.setTitulo(descricao);
    }

    /**
     * Teste do método setDataInicio, da classe Evento.
     */
    @Test(expected = NullPointerException.class)
    public void testSetDataInicioNull() {
        System.out.println("setDataInicioNull");
        Data dataInicio = null;
        Evento instance = this.evento;
        instance.setDataInicio(dataInicio);
    }

    /**
     * Teste do método setDataFim, da classe Evento.
     */
    @Test(expected = NullPointerException.class)
    public void testSetDataFimNull() {
        System.out.println("setDataFimNull");
        Data dataFim = null;
        Evento instance = this.evento;
        instance.setDataFim(dataFim);
    }

    /**
     * Teste do método setDataInicioSubmissao, da classe Evento.
     */
    @Test(expected = NullPointerException.class)
    public void testSetDataInicioSubmissaoNull() {
        System.out.println("setDataInicioSubmissaoNull");
        Data dataInicioSubmissao = null;
        Evento instance = this.evento;
        instance.setDataInicioSubmissao(dataInicioSubmissao);
    }

    /**
     * Teste do método setDataInicioSubmissao, da classe Evento.
     */
    @Test
    public void testSetDataInicioSubmissaoDatePassed() {
        System.out.println("setDataInicioSubmissaoDatePassed");
        Data dataInicioSubmissao = new Data(1, 1, 1);
        Evento instance = this.evento;
        instance.setDataInicioSubmissao(dataInicioSubmissao);
    }

    /**
     * Teste do método setDataFimSubmissao, da classe Evento.
     */
    @Test(expected = NullPointerException.class)
    public void testSetDataFimSubmissaoNull() {
        System.out.println("setDataFimSubmissaoNull");
        Data dataFimSubmissao = null;
        Evento instance = this.evento;
        instance.setDataFimSubmissao(dataFimSubmissao);
    }

    /**
     * Teste do método setDataFimSubmissao, da classe Evento.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDataFimSubmissaoDatePassed() {
        System.out.println("setDataFimSubmissaoDatePassed");
        Data dataFimSubmissao = new Data(2015, 6, 8);
        Evento instance = this.evento;
        instance.setDataFimSubmissao(dataFimSubmissao);
    }

    /**
     * Teste do método setDataInicioDistribuicao, da classe Evento.
     */
    @Test(expected = NullPointerException.class)
    public void testSetDataInicioDistribuicaoNull() {
        System.out.println("setDataInicioDistribuicaoNull");
        Data dataInicioDistribuicao = null;
        Evento instance = this.evento;
        instance.setDataInicioDistribuicao(dataInicioDistribuicao);
    }

    /**
     * Teste do método setDataInicioDistribuicao, da classe Evento.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDataInicioDistribuicaoDatePassed() {
        System.out.println("setDataInicioDistribuicaoDatePassed");
        Data dataInicioDistribuicao = new Data(2015, 6, 8);
        Evento instance = this.evento;
        instance.setDataInicioDistribuicao(dataInicioDistribuicao);
    }

    /**
     * Teste do método temSessoesTematicasDefinidas, da classe Evento.
     */
    @Test
    public void testTemSessoesTematicasDefinidas() {
        System.out.println("temSessoesTematicasDefinidas");
        boolean expResult = false;
        boolean result = this.evento.temSessoesTematicasDefinidas();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe Evento.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = this.evento;
        Evento instance = this.evento;
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe Evento.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equalsNot");
        Object outroObjeto = new Evento("sem titulo", "descricao", new Local("local"),
                new Data(2016, 6, 8), new Data(2016, 6, 20),
                new Data(2016, 7, 7), new Data(2016, 8, 15),
                new Data(2016, 9, 10), new Data(2016, 11, 1),
                new Data(2017, 6, 10));
        Evento instance = this.evento;
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método novoOrganizador, da classe Evento.
     */
    @Test
    public void testNovoOrganizador() {
        System.out.println("novoOrganizador");
        Evento instance = this.evento;
        boolean expResult = true;
        boolean result = instance.novoOrganizador(new Utilizador("Bea",
                "1140587@isep.ipp.pt", "beatriz", "111"));
        assertEquals(expResult, result);
    }

    /**
     * Teste do método novoOrganizador, da classe Evento.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNovoOrganizadorExists() {
        System.out.println("novoOrganizadorExists");
        Evento instance = this.evento;
        instance.novoOrganizador(new Utilizador(
                "Beatriz", "1140587@isep.ipp.pt", "bea", "1234"));
        instance.novoOrganizador(new Utilizador(
                "Beatriz", "1140587@isep.ipp.pt", "bea", "1234"));
    }

    /**
     * Teste do método validarEvento, da classe Evento.
     */
    @Test
    public void testValidarEvento() {
        System.out.println("validarEvento");
        Evento instance = this.evento;
        instance.novoOrganizador(this.utilizador);
        boolean expResult = true;
        boolean result = instance.validarEvento();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método novaCP, da classe Evento.
     */
    @Test
    public void testNovaCP() {
        System.out.println("novaCP");
        Evento instance = this.evento;
        CP expResult = new CP();
        CP result = instance.novaCP();
        assertEquals(expResult, result);
    }

    /**
     * Teste ao metodo adicionarCP, da classe Evento.
     */
    @Test
    public void testAdicionarCP() {
        System.out.println("adicionarCP");
        Evento instance = this.evento;
        instance.setEstado(new EventoSessoesTematicasDefinidasState(instance));
        CP cp = new CP();
        boolean expResult = true;
        boolean result = instance.adicionarCP(cp);
        assertEquals(expResult, result);
    }

    /**
     * Teste ao método isOrganizador, da classe Evento.
     */
    @Test
    public void testIsOrganizador() {
        System.out.println("isOrganizador");
        Evento instance = this.evento;
        instance.novoOrganizador(this.utilizador);
        boolean expResult = true;
        boolean result = instance.isOrganizador(this.utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Teste ao método iniciarProcessoDetecao, da classe Evento.
     */
    @Test
    public void testIniciarProcessoDetecao() {
        System.out.println("iniciarProcessoDetecao");
        Evento evento = new Evento("titulo", "descricao", new Local("local"),
                new Data(2015, 5, 22),
                new Data(2015, 5, 28),
                new Data(2015, 6, 10),
                new Data(2015, 6, 18),
                new Data(2015, 6, 24),
                new Data(2015, 6, 28),
                new Data(2015, 6, 30));
        List<TipoConflito> listaTiposConflito = new ArrayList();
        Evento instance = this.evento;
        instance.adicionarCP(new CP());
        instance.setEstado(new EventoEmLicitacaoState(evento));
        instance.iniciarProcessoDetecao(listaTiposConflito);
        Class<? extends EventoState> expResult
                = new EventoEmLicitacaoState(instance).getClass();
        Class<? extends EventoState> result
                = instance.getEstado().getClass();
        assertEquals(expResult, result);
    }

    /**
     * Teste ao método isRegistadoOuSessoesTematicasDefinidas, da classe evento.
     */
    @Test
    public void testIsRegistadoOuSessoesTematicasDefinidas() {
        System.out.println("isRegistadoOuSessoesTematicasDefinidas");
        Evento instance = this.evento;
        instance.setEstado(new EventoRegistadoState(instance));
        boolean expResult = true;
        boolean result = instance.isRegistadoOuSessoesTematicasDefinidas();
        assertEquals(expResult, result);
    }

    /**
     * Teste ao método isSessoesTematicasDefinidas, da classe Evento.
     */
    @Test
    public void testTemSessoesTematicasDefinidasSemSessoesDefinidas() {
        System.out.println("temSessoesTematicasDefinidasSemSessoesDefinidas");
        Evento instance = this.evento;
        instance.setEstado(new EventoRegistadoState(evento));
        boolean expResult = false;
        boolean result = instance.isSessoesTematicasDefinidas();
        assertEquals(expResult, result);
    }

    /**
     * Teste ao método isSessoesTematicasDefinidas, da classe Evento.
     */
    @Test
    public void testIsSessoesTematicasDefinidasComSessoesDefinidas() {
        System.out.println("isSessoesTematicasDefinidasComSessoesDefinidas");
        Evento instance = this.evento;
        instance.setEstado(new EventoSessoesTematicasDefinidasState(evento));
        boolean expResult = true;
        boolean result = instance.isSessoesTematicasDefinidas();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getListaCPDefiniveisSemCPOrganizadorProponente, da classe
     * Evento.
     */
    @Test
    public void testGetListaCPDefiniveisSemCPOrganizadorProponente() {
        System.out.println("getListaCPDefiniveisSemCPOrganizadorProponente");
        Utilizador utilizador = new Utilizador(this.utilizador);
        Evento instance = new Evento("titulo", "descricao", new Local("local"),
                new Data(2016, 6, 8), new Data(2016, 6, 20),
                new Data(2016, 7, 7), new Data(2016, 7, 14), new Data(2016, 8, 1),
                new Data(2017, 6, 10), new Data(2018, 6, 10));
        Proponente prop = new Proponente(utilizador);
        List<CPDefinivel> expResult = new ArrayList<>();
        List<CPDefinivel> result = instance.getListaCPDefiniveisSemCPOrganizadorProponente(utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaLicitacoes method, of class Evento.
     */
    @Test
    public void testGetListaLicitacoes() {
        System.out.println("getListaLicitacoes");
        Evento instance = this.evento;
        ListaLicitacoes expResult = new ListaLicitacoes();
        ListaLicitacoes result = instance.getListaLicitacoes();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getListaSubmissiveisAceitarArtigo, da classe Evento.
     */
    @Test
    public void testGetListaSubmissiveisAceitarArtigo() {
        System.out.println("getListaSubmissiveisAceitarArtigo");
        ListaSessoesTematicas listaSessoesTematicas = new ListaSessoesTematicas(this.evento);
        SessaoTematica instance = new SessaoTematica("#A9D24R",
                "LAPR2",
                new Data(2015, 5, 22),
                new Data(2015, 5, 28),
                new Data(2015, 6, 10),
                new Data(2015, 6, 20),
                new Data(2015, 6, 24),
                new Data(2015, 6, 28),
                new Data(2017, 6, 8));
        listaSessoesTematicas.adicionarSessaoTematica(instance);
        instance.setEstado(new SessaoTematicaEmSubmissaoState(instance));
        int expResult = 1;
        int result = listaSessoesTematicas.getListaSubmissiveisAceitarArtigo().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getConflitoRevisorSubmissao method, of class Evento.
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
        Evento instance = this.evento;
        instance.setProcessoDetecao(new ProcessoDetecao(instance, new ArrayList()));
        instance.getProcessoDetecao().getListaConflito().adicionarConflito(c);

        Conflito expResult = c;
        Conflito result = instance.getConflitoRevisorSubmissao(revisor, submissao);
        assertEquals(expResult, result);

    }

    /**
     * Teste dos métodos set e get ProcessoDetecao, da classe Evento.
     */
    @Test
    public void testSetAndGetProcessoDetecao() {
        System.out.println("setAndGetProcessoDetecao");
        Evento instance = this.evento;
        instance.setProcessoDetecao(
                new ProcessoDetecao(instance, new ArrayList()));
        ProcessoDetecao expResult
                = new ProcessoDetecao(instance, new ArrayList());
        ProcessoDetecao result = instance.getProcessoDetecao();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos métodos set e get do processo de decisão da classe Evento.
     */
    @Test
    public void testSetAndGetProcessoDecisao() {
        System.out.println("setAndGetProcessoDecisao");
        Evento instance = this.evento;
        ProcessoDecisao processoDecisao = new ProcessoDecisao();
        processoDecisao.adicionarMecanismoDecisao(new MecanismoDecisao1());
        processoDecisao.classificarSubmissoes(new ListaRevisoes());
        instance.setProcessoDecisao(processoDecisao);
        ProcessoDecisao expResult = processoDecisao;
        ProcessoDecisao result = instance.getProcessoDecisao();
        assertEquals(expResult, result);
    }

    /**
     * Test of isStateValidoParaLicitar method, of class Evento.
     */
    @Test
    public void testIsStateValidoParaLicitarValido() {
        System.out.println("isStateValidoParaLicitarValido");
        this.evento.setEstado(new EventoEmLicitacaoState(evento));
        this.evento.setCP(new CP());
        this.evento.getCP().novoRevisor(this.utilizador);
        boolean expResult = true;
        boolean result = this.evento.isStateValidoParaLicitar(this.utilizador);
        assertEquals(expResult, result);

    }

    /**
     * Test of isStateValidoParaLicitar method, of class Evento.
     */
    @Test
    public void testIsStateValidoParaLicitarNot() {
        System.out.println("isStateValidoParaLicitarNot");
        this.evento.setEstado(new EventoCriadoState(evento));
        EventoState instance = this.evento.getEstado();
        boolean expResult = false;
        boolean result = instance.isStateValidoParaLicitar();
        assertEquals(expResult, result);

    }

    /**
     * Test of isStateValidoParaLicitar method, of class Evento.
     */
    @Test
    public void testIsStateValidoParaLicitarEstadoInvalido() {
        System.out.println("isStateValidoParaLicitarValido");
        this.evento.setEstado(new EventoEmDetecaoConflitos(evento));
        this.evento.setCP(new CP());
        this.evento.getCP().novoRevisor(this.utilizador);
        boolean expResult = false;
        boolean result = this.evento.isStateValidoParaLicitar(this.utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Test of isStateValidoParaLicitar method, of class Evento.
     */
    @Test
    public void testIsStateValidoParaLicitarComLicitacao() {
        System.out.println("isStateValidoParaLicitarValido");
        this.evento.setEstado(new EventoEmLicitacaoState(evento));
        this.evento.setCP(new CP());
        this.evento.getCP().novoRevisor(this.utilizador);
        List<Licitacao> listaTeste = new ArrayList<>();
        listaTeste.add(licitacao);
        this.evento.getListaLicitacoes().adicionarListaLicitacoesTemporaria(listaTeste);
        boolean expResult = true;
        boolean result = this.evento.isStateValidoParaLicitar(this.utilizador);
        assertEquals(expResult, result);

    }

    /**
     * Teste do método isStateValidoParaSubmeter, da classe Evento.
     */
    @Test
    public void testIsStateValidoParaSubmeter() {
        System.out.println("isStateValidoParaSubmeter");
        Evento instance = this.evento;
        instance.setEstado(new EventoEmSubmissaoState(evento));
        boolean expResult = true;
        boolean result = instance.isStateValidoParaSubmeter();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método isStateValidoParaAlterar, da classe Evento.
     */
    @Test
    public void testIsStateValidoParaAlterar() {
        System.out.println("isStateValidoParaSubmeter");
        Evento instance = this.evento;
        instance.setEstado(new EventoEmSubmissaoState(evento));
        boolean expResult = true;
        boolean result = instance.isStateValidoParaAlterar();
        assertEquals(expResult, result);
    }

    /**
     * Test of isUtilizadorUmAutorSubmissao method, of class Evento.
     */
    @Test
    public void testIsUtilizadorUmAutorSubmissao() {
        System.out.println("isUtilizadorUmAutorSubmissao");
        Utilizador utilizador = this.utilizador;
        Autor autor = new Autor(utilizador, new InstituicaoAfiliacao("ISEP"));
        Submissao submissao = new Submissao();
        submissao.setEstado(new SubmissaoEmSubmissaoState(submissao));
        submissao.setArtigoInicial(this.artigoInicial);
        submissao.getArtigoInicial().getListaAutores().novoAutor(
                utilizador, new InstituicaoAfiliacao("ISEP"));
        ListaSubmissoes instance = new ListaSubmissoes();
        instance.adicionarSubmissao(submissao);
        boolean expResult = true;
        boolean result = instance.isUtilizadorUmAutorSubmissao(utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método temOrganizadores, da classe Evento.
     */
    @Test
    public void testTemOrganizadores() {
        System.out.println("temOrganizadores");
        Evento instance = this.evento;
        this.evento.novoOrganizador(new Utilizador(
                "nome", "email@isep.ipp.pt", "username", "password"));
        boolean expResult = true;
        boolean result = instance.temOrganizadores();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método novoProcessoDistribuicao, da classe Evento.
     */
    @Test(expected = NullPointerException.class)
    public void testNovoProcessoDistribuicao() {
        System.out.println("novoProcessoDistribuicao");
        Evento instance = this.evento;
        this.evento.setEstado(new EventoEmDistribuicaoState(evento));
        ProcessoDistribuicao expResult = new ProcessoDistribuicao();
        ProcessoDistribuicao result = instance.novoProcessoDistribuicao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método adicionarProcessoDistribuicao, da classe Evento.
     */
    @Test
    public void testAdicionarProcessoDistribuicao() {
        System.out.println("adicionarProcessoDistribuicao");
        this.evento.setEstado(new EventoEmDistribuicaoState(evento));
        ProcessoDistribuicao pd = new ProcessoDistribuicao();
        boolean expResult = false;
        Evento instance = this.evento;
        boolean result = instance.adicionarProcessoDistribuicao(pd);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getProcessoDistribuicao, da classe Evento.
     */
    @Test(expected = NullPointerException.class)
    public void testGetProcessoDistribuicao() {
        System.out.println("getProcessoDistribuicao");
        this.evento.adicionarProcessoDistribuicao(new ProcessoDistribuicao());
        ProcessoDistribuicao expResult = new ProcessoDistribuicao();
        Evento instance = this.evento;
        ProcessoDistribuicao result = instance.getProcessoDistribuicao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método isStateValidoParaDistribuir, da classe Evento.
     */
    @Test
    public void testIsStateValidoParaDistribuir() {
        System.out.println("isStateValidoParaDistribuir");
        this.evento.setEstado(new EventoEmDistribuicaoState(evento));
        boolean adicionado = this.evento.novoOrganizador(utilizador);
        boolean expResult = true;
        boolean result = this.evento.isStateValidoParaDistribuir(utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método isStateValidoParaDistribuir, da classe Evento.
     */
    @Test
    public void testIsStateValidoParaDistribuirNot() {
        System.out.println("isStateValidoParaDistribuir");
        this.evento.setEstado(new EventoEmLicitacaoState(evento));
        this.evento.novoOrganizador(utilizador);
        boolean expResult = false;
        boolean result = this.evento.isStateValidoParaDistribuir(utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método temSubmissoesRetiradas, da classe Evento.
     */
    @Test
    public void testTemSubmissoesRetiradas() {
        System.out.println("temSubmissoesRetiradas");
        Utilizador utilizador = new Utilizador(
                "Pedro", "1140781@isep.ipp.pt", "pedro", "1234");
        Proponente proponente = new Proponente(utilizador);
        evento.novoOrganizador(utilizador);
        this.submissao.setEstado(new SubmissaoRemovidaState(submissao));
        this.evento.getListaSubmissoes().adicionarSubmissao(submissao);
        boolean expResult = true;
        boolean result = this.evento.temSubmissoesRetiradas(utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método
     * getListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente, da
     * classe Evento.
     */
    @Test
    public void testGetListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente() {
        System.out.println("getListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente");
        Utilizador utilizador = new Utilizador(this.utilizador);
        Evento instance = this.evento;
        Proponente proponente = new Proponente(utilizador);
        List<Submissivel> expResult = new ArrayList<>();
        List<Submissivel> result = instance.getListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente(utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método toString, da classe Evento.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Evento instance = this.evento;
        this.evento.setTitulo("Titulo");
        this.evento.setDescricao("Descrição");
        String expResult = "Titulo - Descrição";
        String result = instance.toString();
    }

    /**
     * Teste do método isStateValidoParaRever, da classe Evento.
     */
    @Test
    public void testIsStateValidoParaRever() {
        System.out.println("isStateValidoParaRever");
        this.evento.setEstado(new EventoEmRevisaoState(evento));
        this.evento.adicionarCP(new CP());
        this.evento.getCP().novoRevisor(utilizador);
        ProcessoDistribuicao pd = this.evento.novoProcessoDistribuicao();
        this.evento.adicionarProcessoDistribuicao(pd);
        ListaRevisoes lr = pd.getListaRevisoes();
        lr.adicionarRevisao(this.revisao);
        boolean expResult = true;
        boolean result = this.evento.isStateValidoParaRever(utilizador);
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
        Evento instance = this.evento;
        instance.setEstado(new EventoEmSubmissaoCameraReadyState(instance));
        instance.novoOrganizador(this.utilizador);
        instance.getListaSubmissoes().adicionarSubmissao(submissao);
        instance.getListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente(utilizador);
        int expResult = 1;
        int result = (instance.getListaSubmissoesRetiradas()).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of isStateValidoParaRemover method, of class Evento.
     */
    @Test
    public void testIsStateValidoParaRemover() {
        System.out.println("isStateValidoParaRemover");
        Utilizador u = new Utilizador("fatima", "mail@isep.ipp.pt", "fafa", "1235");
        Evento instance = this.evento;
        instance.setEstado(new EventoEmSubmissaoState(evento));
        instance.getListaSubmissoes().adicionarSubmissao(submissao);
        boolean expResult = false;
        boolean result = instance.isStateValidoParaRemover(u);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getNumeroOrgnizadores, da classe Eventos.
     */
    @Test
    public void testGetNumeroOrganizadores() {
        System.out.println("getNumeroOrganizadores");
        Evento instance = this.evento;
        instance.novoOrganizador(utilizador);
        int expResult = 1;
        int result = instance.getNumeroOrganizadores();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getOrganizadorPeloID, da classe Evento.
     */
    @Test
    public void testGetOrganizadorPeloID() {
        System.out.println("getOrganizadorPeloID");
        int indice = 0;
        Evento instance = this.evento;
        instance.novoOrganizador(utilizador);
        Organizador expResult = new Organizador(this.utilizador);
        Organizador result = instance.getOrganizadorPeloID(indice);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método isEstadoValidoParaDecidir, da classe Evento.
     */
    @Test
    public void testIsEstadoValidoParaDecidir() {
        System.out.println("isEstadoValidoParaDecidir");
        Utilizador u = new Utilizador("fatima", "mail@isep.ipp.pt", "fafa", "1235");
        Evento instance = this.evento;
        instance.setEstado(new EventoEmRevisaoState(evento));
        instance.getListaSubmissoes().adicionarSubmissao(submissao);
        boolean expResult = false;
        boolean result = instance.isEstadoValidoParaDecidir();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getListaDecidivelOrganizadorProponente, da classe Evento.
     */
    @Test
    public void testGetListaDecidivelOrganizadorProponente() {
        System.out.println("getListaDecidivelOrganizadorProponente");
        Submissao submissao = this.submissao;
        submissao.setEstado(new SubmissaoRevistaState(submissao));

        SessaoTematica sessaoTematica = new SessaoTematica("#A9D24R",
                "LAPR2",
                new Data(2015, 5, 22),
                new Data(2015, 5, 28),
                new Data(2015, 6, 10),
                new Data(2015, 6, 20),
                new Data(2015, 6, 24),
                new Data(2015, 6, 28),
                new Data(2017, 6, 8));
        sessaoTematica.setEstado(new SessaoTematicaFaseDecisaoState(sessaoTematica));
        sessaoTematica.novoProponente(utilizador);
        sessaoTematica.getListaSubmissoes().adicionarSubmissao(submissao);

        Evento instance = this.evento;
        instance.setEstado(new EventoFaseDecisaoState(instance));
        instance.novoOrganizador(this.utilizador);
        instance.getListaSubmissoes().adicionarSubmissao(submissao);
        instance.getListaDecidivelOrganizadorProponente(utilizador);
        instance.getListaSessoesTematicas().adicionarSessaoTematica(sessaoTematica);
        int expResult = 1;
        int result = (instance.getListaDecidivelOrganizadorProponente(utilizador)).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValoresTotaisEstatisticaEvento method, of class Evento.
     */
    @Test
    public void testGetValoresTotaisEstatisticaEvento() {
        System.out.println("getValoresTotaisEstatisticaEvento");

        int nSubmissoes = 2;
        this.submissao.setEstado(new SubmissaoAceiteState(submissao));
        this.evento.setEstado(new EventoEmSubmissaoCameraReadyState(evento));
        this.revisao2 = new Revisao(submissao, new Revisor(utilizador));
        revisao2.setAdequacaoArtigo(5);
        revisao2.setConfiancaRevisor(4);
        revisao2.setOriginalidadeArtigo(3);
        revisao2.setQualidadeArtigo(4);
        revisao2.setRecomendacaoGlobal(2);
        revisao2.setTextoJustificativo("Fafa");

        Submissao sb = new Submissao();
        sb.setEstado(new SubmissaoAceiteState(submissao));
        sb.setArtigoFinal(artigoFinal);
        sb.setArtigoInicial(artigoInicial);

        this.evento.getListaSubmissoes().adicionarSubmissao(submissao);
        this.evento.getListaSubmissoes().adicionarSubmissao(sb);
        this.r.getSubmissao().setEstado(new SubmissaoAceiteState(submissao));
        this.revisao2.getSubmissao().setEstado(new SubmissaoAceiteState(submissao));
        ProcessoDistribuicao pd = new ProcessoDistribuicao();
        this.evento.adicionarProcessoDistribuicao(pd);
        ListaRevisoes lr = this.evento.getProcessoDistribuicao().getListaRevisoes();
        lr.adicionarRevisao(revisao2);
        lr.adicionarRevisao(r);

        Evento instance = this.evento;
        float[] expResult = {1, 5f, 4f, 3f, 4f, 2f};
        float[] result = instance.getValoresTotaisEstatisticaEvento();
        assertArrayEquals(expResult, result, 0.00f);

    }

    /**
     * Test of isStateValidoParaGerarEstatisticasEvento method, of class Evento.
     */
    @Test
    public void testIsStateValidoParaGerarEstatisticasEvento() {
        System.out.println("isStateValidoParaGerarEstatisticasEvento");
        Evento instance = this.evento;
        this.evento.setEstado(new EventoEmSubmissaoCameraReadyState(evento));
        boolean expResult = true;
        boolean result = instance.isStateValidoParaGerarEstatisticasEvento();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método adicionarProcessoDecisao, da classe Evento.
     */
    @Test
    public void testAdicionarProcessoDecisao() {
        System.out.println("adicionarProcessoDecisao");
        this.evento.setEstado(new EventoFaseDecisaoState(evento));
        ProcessoDecisao processoDecisao = new ProcessoDecisao();
        boolean expResult = true;
        Evento instance = this.evento;
        boolean result = instance.adicionarProcessoDecisao(processoDecisao);
        assertEquals(expResult, result);
    }

    /**
     * Test of isStateValidoParaGerarAnaliseEstatisticas method, of class
     * Evento.
     */
    @Test
    public void testIsStateValidoParaGerarAnaliseEstatisticas() {
        System.out.println("isStateValidoParaGerarAnaliseEstatisticas");
        Evento instance = this.evento;
        this.evento.setEstado(new EventoEmSubmissaoCameraReadyState(evento));
        boolean expResult = true;
        boolean result = instance.isStateValidoParaGerarAnaliseEstatisticas();
        assertEquals(expResult, result);
    }

    /**
     * Test of notificarOrganizador method, of class Evento.
     */
    @Test
    public void testNotificarOrganizador() {
        System.out.println("notificarOrganizador");
        Evento instance = this.evento;
        instance.novoOrganizador(utilizador);
        int expResult = 1;
        int result = instance.notificarOrganizador().size();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaSubmissiveisAceitarAlteracaoArtigoComSubmissaoUtilizador
     * method, of class Evento.
     */
    @Test
    public void testGetListaSubmissiveisAceitarAlteracaoArtigoComSubmissaoUtilizador() {
        System.out.println("getListaSubmissiveisAceitarAlteracaoArtigoComSubmissaoUtilizador");
        Utilizador utilizador = this.utilizador;
        Evento instance = this.evento;
        SessaoTematica st = new SessaoTematica(
                "#A9D24R",
                "LAPR2",
                new Data(2015, 5, 22),
                new Data(2015, 5, 28),
                new Data(2015, 6, 10),
                new Data(2015, 6, 20),
                new Data(2015, 6, 24),
                new Data(2015, 6, 28),
                new Data(2015, 6, 30));
        st.setEstado(new SessaoTematicaEmSubmissaoState(st));
        instance.setEstado(new EventoEmSubmissaoCameraReadyState(evento));
        Submissao submissao = new Submissao();

        Artigo artigo = new Artigo();
        artigo.getListaAutores().novoAutor(utilizador, new InstituicaoAfiliacao("ISEP"));
        submissao.setArtigoInicial(artigo);
        st.getListaSubmissoes().adicionarSubmissao(submissao);
        submissao.setEstado(new SubmissaoAceiteState(submissao));
        submissao.setEstado(new SubmissaoEmSubmissaoState(submissao));
        evento.getListaSessoesTematicas().adicionarSessaoTematica(st);
        instance.getListaSubmissoes().adicionarSubmissao(submissao);
        int expResult = 1;
        int result = instance.getListaSubmissiveisAceitarAlteracaoArtigoComSubmissaoUtilizador(utilizador).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of isUtilizadorUmAutorSubmissaoInicial method, of class Evento.
     */
    @Test
    public void testIsUtilizadorUmAutorSubmissaoInicial() {
        System.out.println("isUtilizadorUmAutorSubmissaoInicial");
        Utilizador utilizador = this.utilizador;
        Evento instance = this.evento;
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
     * Test of getListaSubmissiveisAceitarArtigoFinal method, of class Evento.
     */
    @Test
    public void testGetListaSubmissiveisAceitarArtigoFinal() {
        System.out.println("getListaSubmissiveisAceitarArtigoFinal");
        Utilizador utilizador = this.utilizador;
        Evento instance = this.evento;
        SessaoTematica st = new SessaoTematica(
                "#A9D24R",
                "LAPR2",
                new Data(2015, 5, 22),
                new Data(2015, 5, 28),
                new Data(2015, 6, 10),
                new Data(2015, 6, 20),
                new Data(2015, 6, 24),
                new Data(2015, 6, 28),
                new Data(2015, 6, 30));
        st.setEstado(new SessaoTematicaEmSubmissaoCameraReadyState(st));
        instance.setEstado(new EventoEmSubmissaoCameraReadyState(evento));
        Submissao submissao = new Submissao();
        submissao.setEstado(new SubmissaoEmSubmissaoState(submissao));
        Artigo artigo = new Artigo();
        artigo.getListaAutores().novoAutor(utilizador, new InstituicaoAfiliacao("ISEP"));
        submissao.setArtigoInicial(artigo);
        st.getListaSubmissoes().adicionarSubmissao(submissao);
        submissao.setEstado(new SubmissaoAceiteState(submissao));
        evento.getListaSessoesTematicas().adicionarSessaoTematica(st);
        instance.getListaSubmissoes().adicionarSubmissao(submissao);
        int expResult = 1;
        int result = instance.getListaSubmissiveisAceitarArtigoFinal(utilizador).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of isStateValidoParaSubmeterArtigoFinal method, of class Evento.
     */
    @Test
    public void testIsStateValidoParaSubmeterArtigoFinal() {
        System.out.println("isStateValidoParaSubmeterArtigoFinal");
        Evento instance = this.evento;
        instance.setEstado(new EventoEmSubmissaoCameraReadyState(evento));
        boolean expResult = true;
        boolean result = instance.isStateValidoParaSubmeterArtigoFinal();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashMapSubmissoes method, of class Evento.
     */
    @Test
    public void testHashMapSubmissoes() {
        System.out.println("hashMapSubmissoes");
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
