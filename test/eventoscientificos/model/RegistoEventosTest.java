package eventoscientificos.model;

import eventoscientificos.model.state.evento.EventoEmCameraReadyState;
import eventoscientificos.model.state.evento.EventoEmLicitacaoState;
import eventoscientificos.model.state.evento.EventoEmRevisaoState;
import eventoscientificos.model.state.evento.EventoEmSubmissaoCameraReadyState;
import eventoscientificos.model.state.evento.EventoEmSubmissaoState;
import eventoscientificos.model.state.evento.EventoFaseDecisaoState;
import eventoscientificos.model.state.evento.EventoRegistadoState;
import eventoscientificos.model.state.evento.EventoSessoesTematicasDefinidasState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmCameraReadyState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmSubmissaoCameraReadyState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmSubmissaoState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaFaseDecisaoState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaRegistadaState;
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
public class RegistoEventosTest {

    private Evento evento;
    private Utilizador utilizador;
    private SessaoTematica st;
    private Revisao revisao;

    public RegistoEventosTest() {
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
        RegistoEventos instance = new RegistoEventos();
        this.evento = new Evento(titulo, descricao, local, dataInicioSubmissao,
                dataFimSubmissao, dataInicioDistribuicao, dataFimRevisao,
                dataFimSubmissaoCameraReady, dataInicio, dataFim);

        this.utilizador = new Utilizador(
                "pedro", "1140781@isep.ipp.pt", "pedro", "12345");
        this.st = new SessaoTematica(
                "#123456", "Uma descrição", new Data(2016, 5, 9),
                new Data(2016, 6, 21), new Data(2016, 7, 8),
                new Data(2016, 7, 20), new Data(2016, 9, 24),
                new Data(2017, 5, 28), new Data(2017, 6, 8));

        Artigo artigoInicial = new Artigo();
        Artigo artigoFinal = new Artigo();
        Submissao submissao = new Submissao();
        submissao.setArtigoInicial(artigoInicial);
        submissao.setArtigoFinal(artigoFinal);

        this.revisao = new Revisao(submissao, new Revisor(utilizador));
    }

    /**
     * Teste do método novoEvento, da classe RegistoEventos.
     */
    @Test
    public void testNovoEvento() {
        System.out.println("novoEvento");
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
        RegistoEventos instance = new RegistoEventos();
        Evento expResult = this.evento;
        Evento result = instance.novoEvento(
                titulo, descricao, local, dataInicioSubmissao, dataFimSubmissao,
                dataInicioDistribuicao, dataFimRevisao, dataFimSubmissaoCameraReady,
                dataInicio, dataFim);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarEvento, da classe RegistoEventos.
     */
    @Test
    public void testValidarEvento() {
        System.out.println("validarEvento");
        Evento evento = this.evento;
        RegistoEventos instance = new RegistoEventos();
        boolean expResult = true;
        boolean result = instance.validarEvento(evento);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método adicionarEvento, da classe RegistoEventos.
     */
    @Test
    public void testAdicionarEvento() {
        System.out.println("adicionarEvento");
        Evento evento = this.evento;
        RegistoEventos instance = new RegistoEventos();
        boolean expResult = true;
        boolean result = instance.adicionarEvento(evento);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe RegistoEventos.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        RegistoEventos outroObjeto = new RegistoEventos();

        outroObjeto.adicionarEvento(this.evento);
        RegistoEventos instance = new RegistoEventos();
        instance.adicionarEvento(this.evento);
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe RegistoEventos.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equalsNot");
        Object outroObjeto = new RegistoEventos();
        RegistoEventos instance = new RegistoEventos();
        instance.adicionarEvento(this.evento);
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getListaEventosOrganizador, da classe RegistoEventos.
     */
    @Test
    public void testGetListaEventosOrganizador() {
        this.evento.setEstado(new EventoRegistadoState(this.evento));
        this.evento.novoOrganizador(this.utilizador);
        RegistoEventos instance = new RegistoEventos();
        instance.adicionarEvento(evento);
        List<Evento> expResult = new ArrayList();
        expResult.add(this.evento);
        List<Evento> result
                = instance.getListaEventosOrganizador(this.utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getListaCPDefiniveisSemCPOrganizadorProponente, da classe
     * RegistoEventos.
     */
    @Test
    public void testGetListaCPDefiniveisSemCPOrganizadorProponente() {
        System.out.println("getListaCPDefiniveisSemOrganizadorProponente");
        this.evento.setEstado(new EventoSessoesTematicasDefinidasState(evento));
        evento.novoOrganizador(this.utilizador);
        st.setEstado(new SessaoTematicaRegistadaState(st));
        st.novoProponente(this.utilizador);
        evento.getListaSessoesTematicas().adicionarSessaoTematica(st);
        RegistoEventos instance = new RegistoEventos();
        instance.adicionarEvento(evento);
        int expResult = 2;
        int result = (instance.getListaCPDefiniveisSemCPOrganizadorProponente(this.utilizador)).size();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getListaCPDefiniveisSemCPOrganizadorProponente, da classe
     * RegistoEventos.
     */
    @Test
    public void testGetListaCPDefiniveisSemCPOrganizadorProponenteSemEvento() {
        System.out.println("getListaCPDefiniveisSemOrganizadorProponenteSemEvento");
        this.evento.setEstado(new EventoSessoesTematicasDefinidasState(evento));
        evento.novoOrganizador(new Utilizador("fafa", "fafa@imal.com", "nana", "1234"));
        st.setEstado(new SessaoTematicaRegistadaState(st));
        st.novoProponente(this.utilizador);
        evento.getListaSessoesTematicas().adicionarSessaoTematica(st);
        RegistoEventos instance = new RegistoEventos();
        instance.adicionarEvento(evento);
        int expResult = 1;
        int result = (instance.getListaCPDefiniveisSemCPOrganizadorProponente(this.utilizador)).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaLicitaveisComArtigosPorLicitarRevisor method, of class
     * RegistoEventos.
     */
    @Test
    public void testGetListaLicitaveisComArtigosPorLicitarRevisor() {
        System.out.println("getListaLicitaveisComArtigosPorLicitarRevisor");
        Utilizador u = this.utilizador;
        this.evento.setCP(new CP());
        this.evento.getCP().novoRevisor(utilizador);
        RegistoEventos instance = new RegistoEventos();
        instance.adicionarEvento(evento);
        boolean expResult = true;
        boolean result = instance.getListaLicitaveisComArtigosPorLicitarRevisor(u) != null;
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getListaSubmissiveisAceitarArtigo, da classe
     * RegistoEventos.
     */
    @Test
    public void testGetListaSubmissiveisAceitarArtigo() {
        System.out.println("getListaSubmissiveisAceitarArtigo");
        RegistoEventos instance = new RegistoEventos();
        Evento evento = this.evento;
        evento.setEstado(new EventoEmSubmissaoState(evento));
        instance.adicionarEvento(evento);
        instance.adicionarEvento(new Evento("sem titulo", "descricao",
                new Local("local"), new Data(2016, 6, 8), new Data(2016, 6, 20),
                new Data(2016, 7, 30), new Data(2016, 8, 15), new Data(2016, 8, 30),
                new Data(2016, 10, 9), new Data(2017, 6, 10)));
        int expResult = 1;
        int result = instance.getListaSubmissiveisAceitarArtigo().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaDistribuiveisOrganizadorProponente method, of class
     * RegistoEventos.
     */
    @Test
    public void testgetListaDistribuiveisOrganizadorProponente() {
        System.out.println("getListaDistribuiveisOrganizadorProponente");
        Utilizador u = this.utilizador;
        this.evento.setCP(new CP());
        this.evento.getCP().novoRevisor(utilizador);
        RegistoEventos instance = new RegistoEventos();
        instance.adicionarEvento(evento);
        boolean expResult = true;
        boolean result = instance.getListaDistribuiveisOrganizadorProponente(u) != null;
        assertEquals(expResult, result);
    }

    /**
     * Teste do método
     * getListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente, da
     * classe RegistoEventos.
     */
    @Test
    public void testGetListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente() {
        System.out.println(
                "getListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente");
        Submissao submissao = new Submissao();
        submissao.setEstado(new SubmissaoRemovidaState(submissao));

        SessaoTematica st = this.st;
        st.setEstado(new SessaoTematicaEmSubmissaoCameraReadyState(st));
        st.novoProponente(this.utilizador);
        st.getListaSubmissoes().adicionarSubmissao(submissao);

        Evento evento = this.evento;
        evento.setEstado(new EventoEmSubmissaoCameraReadyState(evento));
        evento.novoOrganizador(this.utilizador);
        evento.getListaSubmissoes().adicionarSubmissao(submissao);
        evento.getListaSessoesTematicas().adicionarSessaoTematica(st);

        RegistoEventos instance = new RegistoEventos();
        instance.adicionarEvento(evento);

        int expResult = 2;
        int result = (instance.getListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente(this.utilizador)).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaRevisiveisComArtigosPReverRevisor method, of class
     * RegistoEventos.
     */
    @Test
    public void testGetListaRevisiveisComArtigosPReverRevisor() {
        System.out.println("getListaRevisiveisComArtigosPReverRevisor");
        this.evento.setEstado(new EventoEmRevisaoState(evento));
        this.evento.adicionarCP(new CP());
        this.evento.getCP().novoRevisor(utilizador);
        ProcessoDistribuicao pd = this.evento.novoProcessoDistribuicao();
        this.evento.adicionarProcessoDistribuicao(pd);

        ListaRevisoes lr = pd.getListaRevisoes();
        lr.adicionarRevisao(this.revisao);

        RegistoEventos instance = new RegistoEventos();
        instance.adicionarEvento(evento);

        int expResult = 1;
        int result = instance.getListaRevisiveisComArtigosPReverRevisor(utilizador).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaSubmissiveisComArtigosUtilizadorParaRemover method, of
     * class RegistoEventos.
     */
    @Test
    public void testGetListaSubmissiveisComArtigosUtilizadorParaRemover() {
        System.out.println("getListaSubmissiveisComArtigosUtilizadorParaRemover");
        Utilizador u = this.utilizador;
        this.evento.setEstado(new EventoEmSubmissaoState(evento));
        Artigo a = new Artigo();
        a.getListaAutores().novoAutor(utilizador, new InstituicaoAfiliacao("Matosinhos"));
        Submissao s = new Submissao();
        s.setEstado(new SubmissaoEmSubmissaoState(s));
        s.adicionarArtigo(a);
        this.evento.getListaSubmissoes().adicionarSubmissao(s);
        RegistoEventos instance = new RegistoEventos();
        instance.adicionarEvento(evento);
        int expResult = 1;
        int result = instance.getListaSubmissiveisComArtigosUtilizadorParaRemover(u).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaEventosOrganizadorEmSubmissaoCameraReady method, of class
     * RegistoEventos.
     */
    @Test
    public void testGetListaEventosOrganizadorEmSubmissaoCameraReady() {
        System.out.println("getListaEventosOrganizadorEmSubmissaoCameraReady");
        Utilizador u = this.utilizador;
        Artigo a = new Artigo();
        a.getListaAutores().novoAutor(utilizador, new InstituicaoAfiliacao("Matosinhos"));
        Submissao s = new Submissao();
        s.adicionarArtigo(a);
        s.setEstado(new SubmissaoEmCameraReadyState(s));
        this.evento.getListaSubmissoes().adicionarSubmissao(s);
        this.evento.novoOrganizador(utilizador);
        this.evento.setEstado(new EventoEmSubmissaoCameraReadyState(evento));
        RegistoEventos instance = new RegistoEventos();
        instance.adicionarEvento(evento);
        int expResult = 1;
        int result = instance.getListaEventosOrganizadorEmSubmissaoCameraReady(u).size();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getNumeroEventos, da classe RegistoEventos.
     */
    @Test
    public void testGetNumeroEventos() {
        System.out.println("getNumeroEventos");
        RegistoEventos instance = new RegistoEventos();
        instance.adicionarEvento(this.evento);
        int expResult = 1;
        int result = instance.getNumeroEventos();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getEventoPeloID, da classe RegistoEventos.
     */
    @Test
    public void testGetEventoPeloID() {
        System.out.println("getEventoPeloID");
        int indice = 0;
        RegistoEventos instance = new RegistoEventos();
        instance.adicionarEvento(this.evento);
        Evento expResult
                = this.evento;
        Evento result = instance.getEventoPeloID(indice);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getListaDecidiveisOrganizadorProponente, da classe
     * RegistoEventos.
     */
    @Test
    public void testGetListaDecidivelOrganizadorProponente() {
        System.out.println("getListaDecidivelOrganizadorProponente");
        Submissao submissao = new Submissao();
        submissao.setEstado(new SubmissaoRevistaState(submissao));

        SessaoTematica sessaoTematica = this.st;
        sessaoTematica.setEstado(new SessaoTematicaFaseDecisaoState(sessaoTematica));
        sessaoTematica.novoProponente(this.utilizador);
        sessaoTematica.getListaSubmissoes().adicionarSubmissao(submissao);

        Evento evento = this.evento;
        evento.setEstado(new EventoFaseDecisaoState(evento));
        evento.novoOrganizador(this.utilizador);
        evento.getListaSubmissoes().adicionarSubmissao(submissao);
        evento.getListaSessoesTematicas().adicionarSessaoTematica(sessaoTematica);

        RegistoEventos instance = new RegistoEventos();
        instance.adicionarEvento(evento);

        int expResult = 2;
        int result = (instance.getListaDecidiveisOrganizadorProponente(this.utilizador)).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaEventosRevisor method, of class RegistoEventos.
     */
    @Test
    public void testGetListaEventosGerarAnaliseEstatistica() {
        System.out.println("getListaEventosGerarAnaliseEstatistica");
        Empresa empresa = inicializarModeloTeste();
        RegistoEventos instance = empresa.getRegistoEventos();
        int expResult = 3;
        int result = instance.getListaEventosGerarAnaliseEstatistica().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaEventosRevisor method, of class RegistoEventos.
     */
    @Test
    public void testGetListaEventosRevisor() {
        System.out.println("getListaEventosRevisor");
        Revisor revisor = new Revisor(utilizador);
        RegistoEventos instance = new RegistoEventos();
        instance.adicionarEvento(evento);
        CP cp = new CP();

        cp.novoRevisor(utilizador);
        this.st.adicionarCP(cp);
        this.st.setEstado(new SessaoTematicaEmCameraReadyState(st));
        this.evento.adicionarCP(new CP());
        this.evento.getCP().novoRevisor(
                new Utilizador("fafa", "mmi@gmail.com", "mfmf", "1234"));
        this.evento.getListaSessoesTematicas().adicionarSessaoTematica(st);
        List<Evento> listaEventos = instance.getListaEventosGerarAnaliseEstatistica();
        int expResult = 0;
        int result = instance.getListaEventosRevisor(revisor, listaEventos).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaEventosAceitarArtigos method, of class RegistoEventos.
     */
    @Test
    public void testGetListaEventosAceitarArtigos() {
        System.out.println("getListaEventosAceitarArtigos");
        RegistoEventos instance = new RegistoEventos();
        Evento evento = this.evento;
        evento.setEstado(new EventoEmSubmissaoState(evento));
        instance.adicionarEvento(evento);
        int expResult = 1;
        int result = instance.getListaEventosAceitarArtigos().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTodosRevisores method, of class RegistoEventos.
     */
    @Test
    public void testGetTodosRevisores() {
        System.out.println("getTodosRevisores");
        Empresa empresa = inicializarModeloTeste();
        RegistoEventos instance = empresa.getRegistoEventos();
        List<Evento> listaEventosApresentados
                = instance.getListaEventosGerarAnaliseEstatistica();
        boolean expResult = true;
        boolean result = instance.getTodosRevisores(listaEventosApresentados);
        assertEquals(expResult, result);
    }

    /**
     * Test of notificarOrganizador method, of class RegistoEventos.
     */
    @Test
    public void testNotificarOrganizador() {
        System.out.println("notificarOrganizador");
        Empresa empresa = inicializarModeloTeste();
        RegistoEventos instance = empresa.getRegistoEventos();
        List<Evento> listaEventos = instance.getListaEventosGerarAnaliseEstatistica();
        int expResult = 3;
        int result = instance.notificarOrganizador(listaEventos).size();
        assertEquals(expResult, result);

    }

    /**
     * Test of getValoresTotaisAnaliseEstatistica method, of class
     * RegistoEventos.
     */
    @Test
    public void testGetValoresTotaisAnaliseEstatistica() {
        System.out.println("getValoresTotaisAnaliseEstatistica");
        Empresa empresa = inicializarModeloTeste();
        RegistoEventos instance = empresa.getRegistoEventos();
        List<Evento> listaEventosApresentados = instance.getListaEventosGerarAnaliseEstatistica();
        instance.getTodosRevisores(listaEventosApresentados);
        int expResult = instance.getListaRevisores().size();
        int result = instance.getValoresTotaisAnaliseEstatistica(listaEventosApresentados).length;
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaRevisores method, of class RegistoEventos.
     */
    @Test
    public void testGetListaRevisores() {
        System.out.println("getListaRevisores");
        Empresa empresa = inicializarModeloTeste();
        RegistoEventos instance = empresa.getRegistoEventos();
        List<Evento> listaEv = instance.getListaEventosGerarAnaliseEstatistica();
        instance.getTodosRevisores(listaEv);
        int expResult = 6;
        int result = instance.getListaRevisores().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaRevisoes method, of class RegistoEventos.
     */
    @Test
    public void testGetListaRevisoes() {
        System.out.println("getListaRevisoes");
        Empresa empresa = inicializarModeloTeste();
        RegistoEventos instance = empresa.getRegistoEventos();
        List<Evento> listaEv = instance.getListaEventosGerarAnaliseEstatistica();
        instance.getTodosRevisores(listaEv);
        int expResult = 9;
        int result = instance.getListaRevisoes().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaSubmissao method, of class RegistoEventos.
     */
    @Test
    public void testGetListaSubmissao() {
        System.out.println("getListaSubmissao");
        Empresa empresa = inicializarModeloTeste();
        RegistoEventos instance = empresa.getRegistoEventos();
        List<Evento> listaEv = instance.getListaEventosGerarAnaliseEstatistica();
        instance.getTodosRevisores(listaEv);
        int expResult = 1;
        int result = instance.getListaSubmissao().size();
        assertEquals(expResult, result);
    }

    public Empresa inicializarModeloTeste() {
        Empresa empresa = new Empresa();
        Utilizador u1 = new Utilizador("Beatriz Velho", "beatriz_velho@gmail.com", "beaVelho", "1234");
        Utilizador u2 = new Utilizador("Soraia Freitas", "freitas.soraia@gmail.com", "SuFreitas", "2345");
        Utilizador u3 = new Utilizador("Nuno Sousa", "sousa@isep.ipp.pt", "sousaN", "3456");
        Utilizador u4 = new Utilizador("Susana Vieira", "vieirinha@isep.ipp.pt", "VieirinhaSusy", "3457");
        Utilizador u5 = new Utilizador("Eduardo Ramalho", "eduardo_rama@hotmail.com", "edURamalho", "567810");
        Utilizador u6 = new Utilizador("Laura Freitas", "lauraFreitas@sapo.ipp.pt", "lauraF", "9876");
        Utilizador u7 = new Utilizador("Fernando Mesquita", "mesquita_fernando@gmail.com", "mesquita_fernando", "1010");

        // criar objetos do tipo revisor
        Revisor r1 = new Revisor(u1);
        Revisor r2 = new Revisor(u2);
        Revisor r3 = new Revisor(u3);
        Revisor r4 = new Revisor(u4);
        Revisor r5 = new Revisor(u5);
        Revisor r6 = new Revisor(u6);
        Revisor r7 = new Revisor(u7);

        //CP evento1 e 2
        List<Revisor> lr1 = new ArrayList<>();
        lr1.add(r1);
        lr1.add(r2);
        lr1.add(r4);
        lr1.add(r7);
        lr1.add(r6);

        List<Revisor> lr2 = new ArrayList<>();
        lr2.add(r1);
        lr2.add(r2);
        lr2.add(r4);
        lr2.add(r7);
        lr2.add(r3);
        lr2.add(r6);

        CP cpe1 = new CP();
        cpe1.getListaRevisores().addAll(lr1);
        CP cpe2 = new CP();
        cpe2.getListaRevisores().addAll(lr2);

        // criar Data de inicio e de fim de evento
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

        RegistoEventos instance = empresa.getRegistoEventos();

        Evento evento1 = new Evento(titulo, descricao, local, dataInicioSubmissao,
                dataFimSubmissao, dataInicioDistribuicao, dataFimRevisao,
                dataFimSubmissaoCameraReady, dataInicio, dataFim);
        evento1.adicionarCP(cpe1);
        evento1.novoOrganizador(u7);
        evento1.setEstado(new EventoEmCameraReadyState(evento1));

        Evento evento2 = new Evento("MarVermelho", descricao, local, dataInicioSubmissao,
                dataFimSubmissao, dataInicioDistribuicao, dataFimRevisao,
                dataFimSubmissaoCameraReady, dataInicio, dataFim);
        evento2.adicionarCP(cpe2);
        evento2.novoOrganizador(u6);
        evento2.setEstado(new EventoEmCameraReadyState(evento2));

        Evento evento3 = new Evento("MarVermelho", descricao, local, dataInicioSubmissao,
                dataFimSubmissao, dataInicioDistribuicao, dataFimRevisao,
                dataFimSubmissaoCameraReady, dataInicio, dataFim);
        evento3.adicionarCP(cpe1);
        evento3.novoOrganizador(u5);
        evento3.setEstado(new EventoEmCameraReadyState(evento3));

        //adicionar eventos ao registoEventos
        instance.adicionarEvento(evento2);
        instance.adicionarEvento(evento1);
        instance.adicionarEvento(evento3);

        //artigos
        Artigo art1 = new Artigo();
        art1.setTitulo("titulo");
        art1.setResumo("nana");
        art1.setFicheiro("fich1");

        Artigo art2 = new Artigo();
        art2.setTitulo("Art");
        art2.setResumo("fifi");
        art2.setFicheiro("fich2");

        Artigo art3 = new Artigo();
        art3.setTitulo("title");
        art3.setResumo("xaxa");
        art3.setFicheiro("fich3");

        //Submissões
        Submissao sub1 = new Submissao();
        sub1.setArtigoInicial(art1);
        sub1.setArtigoFinal(new Artigo());
        sub1.setEstado(new SubmissaoAceiteState(sub1));

        Submissao sub2 = new Submissao();
        sub2.setArtigoInicial(art2);
        sub2.setArtigoFinal(new Artigo());

        Submissao sub3 = new Submissao();
        sub3.setArtigoInicial(art3);
        sub3.setArtigoFinal(new Artigo());
        sub3.setEstado(new SubmissaoAceiteState(sub3));
        //Revisoes
        List<Revisao> listaRev1 = new ArrayList<>();
        listaRev1.add(new Revisao(sub1, r1));
        listaRev1.add(new Revisao(sub2, r1));
        listaRev1.add(new Revisao(sub3, r3));
        listaRev1.add(new Revisao(sub1, r4));

        listaRev1.get(0).adicionarDadosRevisao(5, 5, 5, 5, 2, "teste0");
        listaRev1.get(1).adicionarDadosRevisao(5, 5, 5, 5, 2, "teste1");
        listaRev1.get(2).adicionarDadosRevisao(5, 5, 5, 5, 2, "teste2");
        listaRev1.get(3).adicionarDadosRevisao(5, 5, 5, 5, 2, "teste3");

        List<Revisao> listaRev2 = new ArrayList<>();
        listaRev2.add(new Revisao(sub2, r4));
        listaRev2.add(new Revisao(sub3, r6));
        listaRev2.add(new Revisao(sub1, r7));

        listaRev2.get(0).adicionarDadosRevisao(5, 5, 5, 5, 2, "teste4");
        listaRev2.get(1).adicionarDadosRevisao(5, 5, 5, 5, 2, "teste5");
        listaRev2.get(2).adicionarDadosRevisao(5, 5, 5, 5, 2, "teste6");

        List<Revisao> listaRev3 = new ArrayList<>();
        listaRev3.add(new Revisao(sub2, r6));
        listaRev3.add(new Revisao(sub3, r2));
        listaRev3.get(0).adicionarDadosRevisao(5, 5, 5, 5, 2, "teste7");
        listaRev3.get(1).adicionarDadosRevisao(5, 5, 5, 5, 2, "teste8");

        //iniciar o processo distribuicao e a lista de revisões.
        evento1.adicionarProcessoDistribuicao(new ProcessoDistribuicao());
        evento1.getProcessoDistribuicao().getListaRevisoes().getListaRevisoes().addAll(listaRev1);

        evento2.adicionarProcessoDistribuicao(new ProcessoDistribuicao());
        evento2.getProcessoDistribuicao().getListaRevisoes().getListaRevisoes().addAll(listaRev2);

        evento3.adicionarProcessoDistribuicao(new ProcessoDistribuicao());
        evento3.getProcessoDistribuicao().getListaRevisoes().getListaRevisoes().addAll(listaRev3);

        evento1.getListaSubmissoes().adicionarSubmissao(sub1);
        sub1.setEstado(new SubmissaoAceiteState(sub1));
        evento1.getListaSubmissoes().adicionarSubmissao(sub2);
        sub2.setEstado(new SubmissaoAceiteState(sub2));
        evento1.getListaSubmissoes().adicionarSubmissao(sub3);
        sub3.setEstado(new SubmissaoAceiteState(sub3));
        evento2.getListaSubmissoes().adicionarSubmissao(sub1);
        sub1.setEstado(new SubmissaoAceiteState(sub1));
        evento2.getListaSubmissoes().adicionarSubmissao(sub2);
        sub2.setEstado(new SubmissaoAceiteState(sub2));
        evento2.getListaSubmissoes().adicionarSubmissao(sub3);
        sub3.setEstado(new SubmissaoAceiteState(sub3));
        evento3.getListaSubmissoes().adicionarSubmissao(sub1);
        sub1.setEstado(new SubmissaoAceiteState(sub1));
        evento3.getListaSubmissoes().adicionarSubmissao(sub2);
        sub2.setEstado(new SubmissaoAceiteState(sub2));
        evento3.getListaSubmissoes().adicionarSubmissao(sub3);
        sub3.setEstado(new SubmissaoAceiteState(sub3));

        return empresa;
    }

    /**
     * Test of getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador method,
     * of class RegistoEventos.
     */
    @Test
    public void testGetListaSubmissiveisAceitarArtigoComSubmissaoUtilizador() {
        System.out.println("getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador");
        RegistoEventos instance = new RegistoEventos();
        Evento evento = new Evento("titulo", "descricao", new Local("local"),
                new Data(2016, 6, 8), new Data(2016, 6, 20),
                new Data(2016, 7, 7), new Data(2016, 8, 15),
                new Data(2016, 9, 10), new Data(2016, 10, 1),
                new Data(2017, 6, 10));
        SessaoTematica sessaoTematica = new SessaoTematica("#123456", "Uma descrição",
                new Data(2016, 6, 9), new Data(2016, 6, 21),
                new Data(2016, 7, 8), new Data(2016, 8, 16),
                new Data(2016, 9, 11), new Data(2016, 10, 2),
                new Data(2017, 5, 20));
        sessaoTematica.setEstado(new SessaoTematicaEmSubmissaoState(sessaoTematica));
        Utilizador utilizador = new Utilizador(
                "pedro", "1140781@isep.ipp.pt", "pedro", "12345");
        SessaoTematica sessaoTematica1 = new SessaoTematica(
                "#1234567", "Uma descrição", new Data(2016, 6, 9),
                new Data(2016, 6, 21), new Data(2016, 7, 8),
                new Data(2016, 7, 9), new Data(2017, 3, 25),
                new Data(2017, 5, 29), new Data(2017, 6, 1));
        Submissao submissao = new Submissao();
        submissao.setArtigoInicial(new Artigo());
        submissao.getArtigoInicial().getListaAutores().novoAutor(utilizador, new InstituicaoAfiliacao("ISEP"));
        sessaoTematica.getListaSubmissoes().adicionarSubmissao(submissao);
        evento.getListaSessoesTematicas().adicionarSessaoTematica(sessaoTematica);
        evento.getListaSessoesTematicas().adicionarSessaoTematica(sessaoTematica1);
        instance.adicionarEvento(evento);
        int expResult = 1;
        int result = instance.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador(utilizador).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaSubmissiveisAceitarArtigoFinal method, of class
     * RegistoEventos.
     */
    @Test
    public void testGetListaSubmissiveisAceitarArtigoFinal() {
        System.out.println("getListaSubmissiveisAceitarArtigoFinal");
        RegistoEventos instance = new RegistoEventos();

        Utilizador utilizador = new Utilizador(
                "Bea", "1140781@isep.ipp.pt", "bea", "12345");;
        Evento evento = this.evento;
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
        evento.setEstado(new EventoEmSubmissaoCameraReadyState(evento));
        Submissao submissao = new Submissao();
        submissao.setEstado(new SubmissaoEmSubmissaoState(submissao));
        Artigo artigo = new Artigo();
        artigo.getListaAutores().novoAutor(utilizador, new InstituicaoAfiliacao("ISEP"));
        submissao.setArtigoInicial(artigo);
        st.getListaSubmissoes().adicionarSubmissao(submissao);
        submissao.setEstado(new SubmissaoAceiteState(submissao));
        evento.getListaSessoesTematicas().adicionarSessaoTematica(st);
        evento.getListaSubmissoes().adicionarSubmissao(submissao);
        instance.adicionarEvento(evento);
        int expResult = 2;
        int result = instance.getListaSubmissiveisAceitarArtigoFinal(utilizador).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaSubmissiveisAceitarAlteracaoArtigoComSubmissaoUtilizador
     * method, of class RegistoEventos.
     */
    @Test
    public void testGetListaSubmissiveisAceitarAlteracaoArtigoComSubmissaoUtilizador() {
        System.out.println("getListaSubmissiveisAceitarAlteracaoArtigoComSubmissaoUtilizador");
        RegistoEventos instance = new RegistoEventos();

        Utilizador utilizador = this.utilizador;
        Evento evento = this.evento;
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
        evento.setEstado(new EventoEmSubmissaoCameraReadyState(evento));
        Submissao submissao = new Submissao();

        Artigo artigo = new Artigo();
        artigo.getListaAutores().novoAutor(utilizador, new InstituicaoAfiliacao("ISEP"));
        submissao.setArtigoInicial(artigo);
        st.getListaSubmissoes().adicionarSubmissao(submissao);
        submissao.setEstado(new SubmissaoAceiteState(submissao));
        submissao.setEstado(new SubmissaoEmSubmissaoState(submissao));
        evento.getListaSessoesTematicas().adicionarSessaoTematica(st);
        evento.getListaSubmissoes().adicionarSubmissao(submissao);
        instance.adicionarEvento(evento);
        int expResult = 2;
        int result = instance.getListaSubmissiveisAceitarAlteracaoArtigoComSubmissaoUtilizador(utilizador).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashMapSubmissoes method, of class RegistoEventos.
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
