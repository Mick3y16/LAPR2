package eventoscientificos.model;

import eventoscientificos.model.state.evento.EventoEmSubmissaoCameraReadyState;
import eventoscientificos.model.state.submissao.SubmissaoAceiteState;
import eventoscientificos.model.state.submissao.SubmissaoRejeitadaState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * Teste à classe ListaRevisoes.
 *
 * @author G01
 */
public class ListaRevisoesTest {

    private Revisor revisor;
    private Submissao submissao;
    private Revisao revisao;
    private Revisao r;
    private Utilizador u;
    private List<Revisao> listaRevisoes;

    public ListaRevisoesTest() {
        Artigo artigoInicial = new Artigo();
        Artigo artigoFinal = new Artigo();
        this.submissao = new Submissao();
        this.u = new Utilizador("nome",
                "1140587@isep.ipp.pt",
                "username",
                "password");
        this.submissao.setArtigoInicial(artigoInicial);
        this.submissao.setArtigoFinal(artigoFinal);
        this.revisor = new Revisor(new Utilizador("nome",
                "1140587@isep.ipp.pt",
                "username",
                "password"));
        this.revisao = new Revisao(submissao, revisor);
        this.r = new Revisao(submissao, revisor);
        r.setAdequacaoArtigo(5);
        r.setConfiancaRevisor(4);
        r.setOriginalidadeArtigo(3);
        r.setQualidadeArtigo(4);
        r.setRecomendacaoGlobal(2);
        r.setTextoJustificativo("ola");
        this.listaRevisoes = new ArrayList<>();
        listaRevisoes.add(revisao);
        listaRevisoes.add(r);
    }

    /**
     * Test of novaRevisao method, of class ListaRevisoes.
     */
    @Test
    public void testNovaRevisao() {
        System.out.println("novaRevisao");
        Submissao submissao = this.submissao;
        Revisor revisor = this.revisor;
        ListaRevisoes instance = new ListaRevisoes();
        Revisao expResult = new Revisao(submissao, revisor);
        Revisao result = instance.novaRevisao(submissao, revisor);
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionarRevisao method, of class ListaRevisoes.
     */
    @Test
    public void testAdicionarRevisao() {
        System.out.println("adicionarRevisao");
        Revisao revisao = new Revisao(submissao, revisor);
        ListaRevisoes instance = new ListaRevisoes();
        boolean expResult = true;
        boolean result = instance.adicionarRevisao(revisao);
        assertEquals(expResult, result);

    }

    /**
     * Teste do método equals, da classe ListaRevisoes.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjecto = new ListaRevisoes();
        ListaRevisoes outraLista = (ListaRevisoes) outroObjecto;
        outraLista.adicionarRevisao(revisao);
        ListaRevisoes instance = new ListaRevisoes();
        instance.adicionarRevisao(revisao);
        boolean expResult = true;
        boolean result = instance.equals(outroObjecto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe ListaRevisoes.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equalsNot");
        Object outroObjecto = new ListaRevisoes();
        ListaRevisoes outraLista = (ListaRevisoes) outroObjecto;
        outraLista.adicionarRevisao(revisao);
        ListaRevisoes instance = new ListaRevisoes();
        boolean expResult = false;
        boolean result = instance.equals(outroObjecto);
        assertEquals(expResult, result);
    }

    /**
     * Test of getRevisoesRevisor method, of class ListaRevisoes.
     */
    @Test
    public void testGetRevisoesRevisor() {
        System.out.println("getRevisoesRevisor");
        Utilizador u = this.u;
        ListaRevisoes instance = new ListaRevisoes();
        instance.adicionarRevisao(revisao);
        instance.adicionarRevisao(r);
        int expResult = 1;
        int result = instance.getRevisoesRevisor(u).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValoresTotaisParaEstatisticaEvento method, of class
     * ListaRevisoes.
     */
    @Test
    public void testGetValoresTotaisParaEstatisticaEvento() {
        System.out.println("getValoresTotaisParaEstatisticaEvento");
        int nSubmissoes = 2;

        revisao.setAdequacaoArtigo(5);
        revisao.setConfiancaRevisor(4);
        revisao.setOriginalidadeArtigo(3);
        revisao.setQualidadeArtigo(4);
        revisao.setRecomendacaoGlobal(2);
        revisao.setTextoJustificativo("Fafa");

        this.r.getSubmissao().setEstado(new SubmissaoAceiteState(submissao));
        this.revisao.getSubmissao().setEstado(new SubmissaoAceiteState(submissao));

        ListaRevisoes instance = new ListaRevisoes();
        instance.adicionarRevisao(revisao);
        instance.adicionarRevisao(r);
        float[] result = instance.getValoresTotaisParaEstatisticaEvento(nSubmissoes);
        float[] expResult = {1f, 5f, 4f, 3f, 4f, 2f};
        Assert.assertArrayEquals(result, expResult, 0.00f);

    }

    /**
     * Teste do método setAndgetListaRevisoes, da classe ListaRevisoes.
     */
    @Test
    public void testSetAndGetListaRevisoes() {
        System.out.println("setAndgetListaRevisoes");
        ListaRevisoes instance = new ListaRevisoes();
        List<Revisao> expResult = new ArrayList<>();
        expResult.add(r);
        instance.setListaRevisoes(expResult);
        List<Revisao> result = instance.getListaRevisoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashMapSubmissoes method, of class ListaRevisoes.
     */
    @Test
    public void testHashMapSubmissoes() {
        System.out.println("hashMapSubmissoes");
        ListaRevisoes instance = new ListaRevisoes();
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

        instance.hashMapSubmissoes(hashMapSubmissoesAceites, hashMapSubmissoesRejeitadas);
    }

    /**
     * Test of getRevisaoPeloID method, of class ListaRevisoes.
     */
    @Test
    public void testGetRevisaoPeloID() {
        System.out.println("getRevisaoPeloID");
        int indice = 0;
        ListaRevisoes instance = new ListaRevisoes();
        this.revisao = new Revisao(submissao, revisor);
        Submissao submissao1 = new Submissao();
        Artigo artigo1 = new Artigo();
        artigo1.setFicheiro("c\\lapr.csv");
        submissao1.adicionarArtigo(artigo1);
        this.r = new Revisao(submissao1, revisor);
        instance.getListaRevisoes().add(revisao);
        instance.getListaRevisoes().add(r);
        Revisao expResult = this.revisao;
        Revisao result = instance.getRevisaoPeloID(indice);
        assertEquals(expResult, result);
    }

    /**
     * Test of numeroRevisoes method, of class ListaRevisoes.
     */
    @Test
    public void testNumeroRevisoes() {
        System.out.println("numeroRevisoes");
        ListaRevisoes instance = new ListaRevisoes();
        this.revisao = new Revisao(submissao, revisor);
        this.r = new Revisao(submissao, revisor);
        instance.getListaRevisoes().add(revisao);
        instance.getListaRevisoes().add(r);
        int expResult = 2;
        int result = instance.numeroRevisoes();
        assertEquals(expResult, result);
    }
}
