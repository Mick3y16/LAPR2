package eventoscientificos.model;

import eventoscientificos.model.state.evento.EventoEmSubmissaoCameraReadyState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmSubmissaoCameraReadyState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmSubmissaoState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaFaseDecisaoState;
import eventoscientificos.model.state.submissao.SubmissaoAceiteState;
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
 * Teste à classe ListaSessoesTematicas.
 *
 * @author G01
 */
public class ListaSessoesTematicasTest {

    private Evento evento;
    private ListaSessoesTematicas listaSessoesTematicas;
    private SessaoTematica sessaoTematica;
    private Submissao submissao;

    public ListaSessoesTematicasTest() {
        this.evento = new Evento("titulo", "descricao", new Local("local"),
                new Data(2016, 6, 8), new Data(2016, 6, 20),
                new Data(2016, 7, 7), new Data(2016, 8, 15),
                new Data(2016, 9, 10), new Data(2016, 10, 1),
                new Data(2017, 6, 10));
        this.listaSessoesTematicas = new ListaSessoesTematicas(this.evento);
        this.sessaoTematica = new SessaoTematica("#123456", "Uma descrição",
                new Data(2016, 6, 9), new Data(2016, 6, 21),
                new Data(2016, 7, 8), new Data(2016, 8, 16),
                new Data(2016, 9, 11), new Data(2016, 10, 2),
                new Data(2017, 5, 20));
        this.submissao = new Submissao();
        submissao.setArtigoInicial(new Artigo());
        submissao.setArtigoFinal(new Artigo());
    }

    /**
     * Teste do método novaSessaoTematica, of class ListaSessoesTematicas.
     */
    @Test
    public void testNovaSessaoTematica() {
        ListaSessoesTematicas instance = this.listaSessoesTematicas;
        System.out.println("novaSessaoTematica");
        SessaoTematica expResult = this.sessaoTematica;
        SessaoTematica result = instance.novaSessaoTematica(
                "#123456", "Uma descrição", new Data(2015, 5, 22),
                new Data(2015, 5, 28), new Data(2015, 6, 20),
                new Data(2015, 6, 24), new Data(2015, 6, 28),
                new Data(2015, 7, 1), new Data(2015, 7, 7));
        assertEquals(expResult, result);
    }

    /**
     * Teste do método adicionarSessaoTematica, da classe ListaSessoesTematicas.
     */
    @Test
    public void testAdicionarSessaoTematica() {
        System.out.println("adicionarSessaoTematica");
        SessaoTematica sessaoTematica = this.sessaoTematica;
        ListaSessoesTematicas instance = this.listaSessoesTematicas;
        boolean expResult = true;
        boolean result = instance.adicionarSessaoTematica(sessaoTematica);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarSessaoTematica, da classe ListaSessoesTematicas.
     */
    @Test
    public void testValidarSessaoTematica() {
        System.out.println("validarSessaoTematica");
        ListaSessoesTematicas instance = this.listaSessoesTematicas;
        SessaoTematica sessaoTematica = this.sessaoTematica;
        boolean expResult = true;
        boolean result = instance.validarSessaoTematica(sessaoTematica);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarSessaoTematica, da classe ListaSessoesTematicas.
     */
    @Test
    public void testValidarSessaoTematicaNot() {
        System.out.println("validarSessaoTematicaNot");
        ListaSessoesTematicas instance = this.listaSessoesTematicas;
        SessaoTematica sessaoTematica = this.sessaoTematica;
        instance.adicionarSessaoTematica(sessaoTematica);
        boolean expResult = false;
        boolean result = instance.validarSessaoTematica(sessaoTematica);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe ListaSessoesTematicas.
     */
    @Test
    public void testEquals() {
        Object outroObject = new ListaSessoesTematicas(this.evento);
        ListaSessoesTematicas instance = this.listaSessoesTematicas;
        boolean expResult = true;
        boolean result = instance.equals(outroObject);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe ListaSessoesTematicas.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equalsNot");
        Object outroObject = new ListaSessoesTematicas(this.evento);
        ListaSessoesTematicas instance = this.listaSessoesTematicas;
        instance.adicionarSessaoTematica(this.sessaoTematica);
        boolean expResult = false;
        boolean result = instance.equals(outroObject);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método temSessoesTematicasDefinidasPreenchida, da classe
     * ListaSessoesTematicas.
     */
    @Test
    public void testTemSessoesTematicasDefinidasPreenchida() {
        System.out.println("temSessoesTematicasDefinidasPreenchida");
        ListaSessoesTematicas instance = new ListaSessoesTematicas(this.evento);
        instance.adicionarSessaoTematica(sessaoTematica);
        boolean expResult = true;
        boolean result = instance.temSessoesTematicasDefinidas();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método temSessoesTematicasDefinidasVazia, da classe
     * ListaSessoesTematicas.
     */
    @Test
    public void testTemSessoesTematicasDefinidasVazia() {
        System.out.println("temSessoesTematicasDefinidasVazia");
        ListaSessoesTematicas instance = new ListaSessoesTematicas(this.evento);
        boolean expResult = false;
        boolean result = instance.temSessoesTematicasDefinidas();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getListaCPDefiniveisSemCPOrganizadorProponente, da classe
     * ListaSessoesTematicas.
     */
    @Test
    public void testGetListaCPDefiniveisSemCPOrganizadorProponente() {
        System.out.println("getListaCPDefiniveisSemCPOrganizadorProponente");
        Utilizador utilizador = new Utilizador(
                "pedro", "1140781@isep.ipp.pt", "pedro", "12345");
        Proponente prop = new Proponente(utilizador);
        ListaSessoesTematicas instance = new ListaSessoesTematicas(this.evento);
        List<CPDefinivel> expResult = new ArrayList<>();
        List<CPDefinivel> result = instance.getListaCPDefiniveisSemCPOrganizadorProponente(utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getListaSessoesTematicas, da classe
     * ListaSessoesTematicas.
     */
    @Test
    public void testGetListaSessoesTematicas() {
        System.out.println("getListaSessoesTematicas");
        ListaSessoesTematicas listaSessoesTematicas = this.listaSessoesTematicas;
        listaSessoesTematicas.adicionarSessaoTematica(this.sessaoTematica);
        listaSessoesTematicas.adicionarSessaoTematica(new SessaoTematica(
                "#1234567", "Uma descrição", new Data(2016, 6, 9),
                new Data(2016, 6, 21), new Data(2016, 7, 8),
                new Data(2016, 7, 9), new Data(2017, 3, 25),
                new Data(2017, 5, 29), new Data(2017, 6, 1)));
        int expResult = 2;
        int result = listaSessoesTematicas.getListaSessoesTematicas().size();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getListaSubmissiveisAceitarArtigo, da classe
     * ListaSessoesTematicas.
     */
    @Test
    public void testGetListaSubmissiveisAceitarArtigo() {
        System.out.println("getListaSubmissiveisAceitarArtigo");
        ListaSessoesTematicas instance = this.listaSessoesTematicas;
        SessaoTematica sessaoTematica = this.sessaoTematica;
        SessaoTematica sessaoTematica1 = new SessaoTematica(
                "#1234567", "Uma descrição", new Data(2016, 6, 9),
                new Data(2016, 6, 21), new Data(2016, 7, 8),
                new Data(2016, 7, 9), new Data(2017, 3, 25),
                new Data(2017, 5, 29), new Data(2017, 6, 1));
        sessaoTematica.setEstado(new SessaoTematicaEmSubmissaoState(sessaoTematica));
        instance.adicionarSessaoTematica(sessaoTematica);
        instance.adicionarSessaoTematica(sessaoTematica1);
        int expResult = 1;
        int result = instance.getListaSubmissiveisAceitarArtigo().size();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método temSessoesTematicasDefinidas, da classe
     * ListaSessoesTematicas.
     */
    @Test
    public void testTemSessoesTematicasDefinidas() {
        System.out.println("temSessoesTematicasDefinidas");
        ListaSessoesTematicas instance = this.listaSessoesTematicas;
        SessaoTematica sessaoTematica = this.sessaoTematica;
        SessaoTematica sessaoTematica1 = new SessaoTematica(
                "#1234567", "Uma descrição", new Data(2016, 6, 9),
                new Data(2016, 6, 21), new Data(2016, 7, 8),
                new Data(2016, 7, 9), new Data(2017, 3, 25),
                new Data(2017, 5, 29), new Data(2017, 6, 1));
        instance.adicionarSessaoTematica(sessaoTematica);
        instance.adicionarSessaoTematica(sessaoTematica1);
        boolean expResult = true;
        boolean result = instance.temSessoesTematicasDefinidas();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método
     * getListaSubmissiveisAceitarAlteracaoArtigoComSubmissaoUtilizador, da
     * classe ListaSessoesTematicas.
     */
    @Test
    public void testGetListaSubmissiveisAceitarArtigoComSubmissaoUtilizador() {
        System.out.println("getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador");
        SessaoTematica sessaoTematica = this.sessaoTematica;
        sessaoTematica.setEstado(new SessaoTematicaEmSubmissaoState(sessaoTematica));
        Utilizador utilizador = new Utilizador(
                "pedro", "1140781@isep.ipp.pt", "pedro", "12345");
        SessaoTematica sessaoTematica1 = new SessaoTematica(
                "#1234567", "Uma descrição", new Data(2016, 6, 9),
                new Data(2016, 6, 21), new Data(2016, 7, 8),
                new Data(2016, 7, 9), new Data(2017, 3, 25),
                new Data(2017, 5, 29), new Data(2017, 6, 1));
        ListaSessoesTematicas instance = this.listaSessoesTematicas;
        Submissao submissao = new Submissao();
        submissao.setArtigoInicial(new Artigo());
        submissao.getArtigoInicial().getListaAutores().novoAutor(utilizador, new InstituicaoAfiliacao("ISEP"));
        sessaoTematica.getListaSubmissoes().adicionarSubmissao(submissao);
        instance.adicionarSessaoTematica(sessaoTematica);
        instance.adicionarSessaoTematica(sessaoTematica1);
        int expResult = 1;
        int result = instance.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador(utilizador).size();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método
     * getListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente, da class
     * ListaSessoesTematicas.
     */
    @Test
    public void testGetListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente() {
        System.out.println("getListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente");
        Utilizador utilizador = new Utilizador(
                "Pedro", "1140781@isep.ipp.pt", "pedro", "1234");
        Proponente proponente = new Proponente(utilizador);
        sessaoTematica.novoProponente(utilizador);
        this.submissao.setEstado(new SubmissaoRemovidaState(submissao));
        this.sessaoTematica.getListaSubmissoes().adicionarSubmissao(submissao);
        listaSessoesTematicas = new ListaSessoesTematicas(evento);
        listaSessoesTematicas.adicionarSessaoTematica(sessaoTematica);
        int expResult = 1;
        int result = listaSessoesTematicas.getListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente(utilizador).size();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getNumeroSessoesTematicas, da classe
     * ListaSessoesTematicas.
     */
    @Test
    public void testGetNumeroSessoesTematicas() {
        System.out.println("getNumeroSessoesTematicas");
        ListaSessoesTematicas instance = this.listaSessoesTematicas;
        instance.adicionarSessaoTematica(this.sessaoTematica);
        int expResult = 1;
        int result = instance.getNumeroSessoesTematicas();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getSessoesTematicasPeloID, da classe
     * ListaSessoesTematicas.
     */
    @Test
    public void testGetSessoesTematicasPeloID() {
        System.out.println("getSessoesTematicasPeloID");
        int indice = 0;
        ListaSessoesTematicas instance = this.listaSessoesTematicas;
        instance.adicionarSessaoTematica(this.sessaoTematica);
        SessaoTematica expResult = this.sessaoTematica;
        SessaoTematica result = instance.getSessoesTematicasPeloID(indice);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getListaDecidivelOrganizadorProponente, da classe
     * ListaSessoesTematicas.
     */
    @Test
    public void testGetListaDecidivelOrganizadorProponente() {
        System.out.println("getListaDecidivelOrganizadorProponente");
        Utilizador utilizador = new Utilizador(
                "Pedro", "1140781@isep.ipp.pt", "pedro", "1234");
        Proponente proponente = new Proponente(utilizador);
        sessaoTematica.novoProponente(utilizador);
        sessaoTematica.setEstado(new SessaoTematicaFaseDecisaoState(sessaoTematica));
        this.submissao.setEstado(new SubmissaoRevistaState(submissao));
        this.sessaoTematica.getListaSubmissoes().adicionarSubmissao(submissao);
        listaSessoesTematicas = new ListaSessoesTematicas(evento);
        listaSessoesTematicas.adicionarSessaoTematica(sessaoTematica);
        int expResult = 1;
        int result = listaSessoesTematicas.getListaDecidivelOrganizadorProponente(utilizador).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSessaoTematicaComCodigoUnico method, of class
     * ListaSessoesTematicas.
     */
    @Test
    public void testGetSessaoTematicaComCodigoUnico() {
        System.out.println("getSessaoTematicaComCodigoUnico");
        String codigoUnico = "codigo";
        ListaSessoesTematicas instance = new ListaSessoesTematicas(evento);
        instance.adicionarSessaoTematica(this.sessaoTematica);
        this.sessaoTematica.setCodigoUnico("codigo");
        SessaoTematica expResult = this.sessaoTematica;
        SessaoTematica result = instance.getSessaoTematicaComCodigoUnico(codigoUnico);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSessaoTematicaComCodigoUnico method, of class
     * ListaSessoesTematicas.
     */
    @Test
    public void testGetSessaoTematicaComCodigoUnicoNull() {
        System.out.println("getSessaoTematicaComCodigoUnico");
        String codigoUnico = "codigo";
        ListaSessoesTematicas instance = new ListaSessoesTematicas(evento);
        instance.adicionarSessaoTematica(this.sessaoTematica);
        SessaoTematica expResult = null;
        SessaoTematica result = instance.getSessaoTematicaComCodigoUnico(codigoUnico);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaSubmissiveisAceitarAlteracaoArtigoComSubmissaoUtilizador
     * method, of class ListaSessoesTematicas.
     */
    @Test
    public void testGetListaSubmissiveisAceitarAlteracaoArtigoComSubmissaoUtilizador() {
        System.out.println("getListaSubmissiveisAceitarAlteracaoArtigoComSubmissaoUtilizador");
        Utilizador utilizador = new Utilizador(
                "bea", "1140587@isep.ipp.pt", "bea", "12345");;
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

        ListaSessoesTematicas instance = new ListaSessoesTematicas(evento);
        int expResult = 1;
        int result = evento.getListaSubmissiveisAceitarAlteracaoArtigoComSubmissaoUtilizador(utilizador).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaSubmissiveisAceitarArtigoFinal method, of class
     * ListaSessoesTematicas.
     */
    @Test
    public void testGetListaSubmissiveisAceitarArtigoFinal() {
        System.out.println("getListaSubmissiveisAceitarArtigoFinal");
        Utilizador utilizador = new Utilizador(
                "Bea", "1140781@isep.ipp.pt", "bea", "12345");;
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
     * Test of hashMapSubmissoesSessaoTematica method, of class
     * ListaSessoesTematicas.
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
        ListaSessoesTematicas instance = new ListaSessoesTematicas(evento);
        instance.hashMapSubmissoesSessaoTematica(hashMapSubmissoesAceites, hashMapSubmissoesRejeitadas);
    }

}
