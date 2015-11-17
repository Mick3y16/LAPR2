package eventoscientificos.model;

import eventoscientificos.model.state.submissao.SubmissaoCriadaState;
import eventoscientificos.model.state.submissao.SubmissaoEmSubmissaoState;
import eventoscientificos.model.state.submissao.SubmissaoRemovidaState;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste à classe ListaSubmissoes
 *
 * @author G01
 */
public class ListaSubmissoesTest {

    private Submissao submissao;

    public ListaSubmissoesTest() {
        this.submissao = new Submissao();
        this.submissao.setArtigoInicial(new Artigo());
        this.submissao.setArtigoFinal(new Artigo());

    }

    /**
     * Teste do método novaSubmissao, da classe ListaSubmissoes.
     */
    @Test
    public void testNovaSubmissao() {
        System.out.println("novaSubmissao");
        ListaSubmissoes instance = new ListaSubmissoes();
        Submissao expResult = this.submissao;
        Submissao result = instance.novaSubmissao();
        result.setArtigoInicial(new Artigo());
        result.setArtigoFinal(new Artigo());
        assertEquals(expResult, result);
    }

    /**
     * Teste do método alterarEstadoSubmissao, da classe ListaSubmissoes.
     */
    @Test
    public void testValidarSubmissao() {
        System.out.println("validarSubmissao");
        Submissao submissao = this.submissao;
        ListaSubmissoes instance = new ListaSubmissoes();
        boolean expResult = true;
        boolean result = instance.validarSubmissao(submissao);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método adicionarSubmissao, da classe ListaSubmissoes.
     */
    @Test
    public void testAdicionarSubmissao() {
        System.out.println("adicionarSubmissao");
        Submissao submissao = this.submissao;
        ListaSubmissoes instance = new ListaSubmissoes();
        boolean expResult = true;
        boolean result = instance.adicionarSubmissao(submissao);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe ListaSubmissoes.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = new ListaSubmissoes();
        ListaSubmissoes instance = new ListaSubmissoes();
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe ListaSubmissoes.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equalsNot");
        Object outroObjeto = new ListaSubmissoes();
        ListaSubmissoes instance = new ListaSubmissoes();
        instance.adicionarSubmissao(this.submissao);
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaSubmissoes method, of class ListaSubmissoes.
     */
    @Test
    public void testGetListaSubmissoes() {
        System.out.println("getListaSubmissoes");
        ListaSubmissoes instance = new ListaSubmissoes();
        instance.adicionarSubmissao(submissao);
        List<Submissao> expResult = new ArrayList<>();
        expResult.add(submissao);
        List<Submissao> result = instance.getListaSubmissoes();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getListaSubmissoesUtilizadorEmPeriodoSubmissao, da classe
     * ListaSubmissoes.
     */
    @Test
    public void testGetListaSubmissoesUtilizadorEmPeriodoSubmissao() {
        System.out.println("getListaSubmissoesUtilizadorEmPeriodoSubmissao");
        Artigo artigo = new Artigo();
        artigo.getListaAutores().novoAutor(new Utilizador(
                "pedro", "1140781@isep.ipp.pt", "pedro", "12345"),
                new InstituicaoAfiliacao("ISEP"));
        this.submissao = new Submissao();
        this.submissao.setArtigoInicial(artigo);
        Utilizador utilizador
                = new Utilizador("pedro", "1140781@isep.ipp.pt", "pedro", "12345");
        ListaSubmissoes instance = new ListaSubmissoes();
        instance.adicionarSubmissao(this.submissao);
        int expResult = 1;
        int result = instance.getListaSubmissoesUtilizadorEmPeriodoSubmissao(utilizador).size();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarCloneSubmissao, da classe ListaSubmissoes.
     */
    @Test
    public void testValidarCloneSubmissaoTrue() {
        System.out.println("validarCloneSubmissao");
        Artigo artigo = new Artigo();
        this.submissao = new Submissao();
        List<String> listaPC = new ArrayList<>();
        listaPC.add("ola");
        listaPC.add("fafa");
        artigo.setPalavrasChave(listaPC);
        artigo.setAutorSubmissor(new Autor(new Utilizador("Noe", "Noe@email.com", "NaoENoe", "1234"), new InstituicaoAfiliacao("NaoENoe")));
        artigo.setAutorCorrespondente(new AutorCorrespondente(new Utilizador("Noe", "Noe@email.com", "NaoENoe", "1234"), new InstituicaoAfiliacao("Matosinhos")));
        this.submissao.setArtigoInicial(artigo);
        Submissao submissaoClone = submissao.criarCloneSubmissao();

        ListaSubmissoes instance = new ListaSubmissoes();
        instance.adicionarSubmissao(submissaoClone);
        boolean expResult = true;
        boolean result = instance.validarCloneSubmissao(submissao, submissaoClone);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarCloneSubmissao, da classe ListaSubmissoes.
     */
    @Test
    public void testValidarCloneSubmissaoFalse() {
        System.out.println("validarCloneSubmissao");
        this.submissao = new Submissao();

        Artigo artigo = new Artigo();
        List<String> listaPC = new ArrayList<>();
        listaPC.add("ola");
        listaPC.add("fafa");
        artigo.setTitulo("Tomate");
        artigo.setPalavrasChave(listaPC);
        artigo.setAutorSubmissor(new Autor(new Utilizador("Noe", "Noe@email.com", "NaoENoe", "1234"), new InstituicaoAfiliacao("NaoENoe")));
        artigo.setAutorCorrespondente(new AutorCorrespondente(new Utilizador("Noe", "Noe@email.com", "NaoENoe", "1234"), new InstituicaoAfiliacao("Matosinhos")));
        this.submissao.setArtigoInicial(artigo);
        Submissao sub2 = new Submissao();
        Artigo art1 = new Artigo();
        art1.setTitulo("Ananás");
        art1.setPalavrasChave(listaPC);
        art1.setAutorSubmissor(new Autor(new Utilizador("Noe", "Noe@email.com", "NaoENoe", "1234"), new InstituicaoAfiliacao("NaoENoe")));
        art1.setAutorCorrespondente(new AutorCorrespondente(new Utilizador("Noe", "Noe@email.com", "NaoENoe", "1234"), new InstituicaoAfiliacao("Matosinhos")));
        sub2.setArtigoInicial(art1);

        ListaSubmissoes instance = new ListaSubmissoes();
        instance.adicionarSubmissao(submissao);
        instance.adicionarSubmissao(sub2);

        Submissao submissaoClone = submissao.criarCloneSubmissao();
        submissaoClone.getArtigoInicial().setTitulo("Ananás");
        boolean expResult = false;
        boolean result = instance.validarCloneSubmissao(this.submissao, submissaoClone);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método isUtilizadorUmAutorSubmissao, da classe ListaSubmissoes.
     */
    @Test
    public void testIsUtilizadorUmAutorSubmissao() {
        System.out.println("isUtilizadorUmAutorSubmissao");
        Utilizador utilizador = new Utilizador(
                "Susana", "email@gmail.com", "susus", "1234");
        Submissao submissao = new Submissao();
        submissao.setEstado(new SubmissaoEmSubmissaoState(submissao));
        submissao.setArtigoInicial(new Artigo());
        submissao.getArtigoInicial().getListaAutores().novoAutor(utilizador, new InstituicaoAfiliacao("ISEP"));
        ListaSubmissoes instance = new ListaSubmissoes();
        instance.adicionarSubmissao(submissao);
        boolean expResult = true;
        boolean result = instance.isUtilizadorUmAutorSubmissao(utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método temSubmissoesRetiradas, da classe ListaSubmissoes.
     */
    @Test
    public void testTemSubmissoesRetiradasNot() {
        System.out.println("temSubmissoesRetiradasNot");
        ListaSubmissoes instance = new ListaSubmissoes();
        this.submissao.setEstado(new SubmissaoCriadaState(submissao));
        instance.adicionarSubmissao(submissao);

        boolean expResult = false;
        boolean result = instance.temSubmissoesRetiradas();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método temSubmissoesRetiradas, da classe ListaSubmissoes.
     */
    @Test
    public void testTemSubmissoesRetiradas() {
        System.out.println("temSubmissoesRetiradas");
        ListaSubmissoes instance = new ListaSubmissoes();
        this.submissao.setEstado(new SubmissaoRemovidaState(submissao));
        instance.adicionarSubmissao(submissao);
        boolean expResult = true;
        boolean result = instance.temSubmissoesRetiradas();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getListaSubmissoesRetiradas, da classe ListaSubmissoes.
     */
    @Test
    public void testGetListaSubmissoesRetiradas() {
        System.out.println("getListaSubmissoesRetiradas");
        Submissao submissao = new Submissao();
        submissao.setEstado(new SubmissaoRemovidaState(submissao));
        ListaSubmissoes instance = new ListaSubmissoes();
        instance.adicionarSubmissao(submissao);
        instance.getListaSubmissoesRetiradas();
        int expResult = 1;
        int result = (instance.getListaSubmissoesRetiradas()).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of containsAutorNaListaAutoresArtigoInicial method, of class
     * ListaSubmissoes.
     */
    @Test
    public void testContainsAutorNaListaAutoresArtigoInicial() {
        System.out.println("containsAutorNaListaAutoresArtigoInicial");
        Artigo artigoInicial = new Artigo();
        Utilizador u = new Utilizador(
                "Nome", "mail@isep.ipp.pt", "Username", "1234");
        artigoInicial.getListaAutores().novoAutor(u, new InstituicaoAfiliacao("MatosinhosSport"));
        this.submissao.setArtigoInicial(artigoInicial);
        ListaSubmissoes instance = new ListaSubmissoes();
        instance.adicionarSubmissao(submissao);
        boolean expResult = true;
        boolean result = instance.containsAutorNaListaAutoresArtigoInicial(u);
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaSubmissoesUtilizador method, of class ListaSubmissoes.
     */
    @Test
    public void testGetListaSubmissoesUtilizador() {
        System.out.println("getListaSubmissoesUtilizador");
        Utilizador u = new Utilizador(
                "Nana", "molly@isep.ipp.pt", "User2", "1234");
        Submissao s = new Submissao();
        s.setEstado(new SubmissaoEmSubmissaoState(s));
        s.setArtigoInicial(new Artigo());
        s.getArtigoInicial().getListaAutores().novoAutor(u, new InstituicaoAfiliacao("Porto"));

        Utilizador ut = new Utilizador(
                "fafa", "money@isep.ipp.pt", "Username", "1234");
        Submissao sub = new Submissao();
        sub.setEstado(new SubmissaoEmSubmissaoState(sub));
        sub.setArtigoInicial(new Artigo());
        sub.getArtigoInicial().getListaAutores().novoAutor(ut, new InstituicaoAfiliacao("Maia"));

        ListaSubmissoes instance = new ListaSubmissoes();
        instance.adicionarSubmissao(sub);
        instance.adicionarSubmissao(s);

        int expResult = 1;
        int result = instance.getListaSubmissoesUtilizador(u).size();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getNumeroSubmissoes, da classe ListaSubmissoes.
     */
    @Test
    public void testGetNumeroSubmissoes() {
        System.out.println("getNumeroSubmissoes");
        ListaSubmissoes instance = new ListaSubmissoes();
        instance.adicionarSubmissao(this.submissao);
        int expResult = 1;
        int result = instance.getNumeroSubmissoes();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getOrganizadorPeloID, da classe ListaSubmissoes.
     */
    @Test
    public void testGetSubmissaoPeloID() {
        System.out.println("getSubmissaoPeloID");
        int indice = 0;
        ListaSubmissoes instance = new ListaSubmissoes();
        instance.adicionarSubmissao(this.submissao);
        Submissao expResult = this.submissao;
        Submissao result = instance.getSubmissaoPeloID(indice);
        assertEquals(expResult, result);
    }

    /**
     * Test of isUtilizadorUmAutorSubmissaoInicial method, of class
     * ListaSubmissoes.
     */
    @Test
    public void testIsUtilizadorUmAutorSubmissaoInicial() {
        System.out.println("isUtilizadorUmAutorSubmissaoInicial");
        Utilizador utilizador = new Utilizador(
                "bea", "1140587@isep.ipp.pt", "bea", "12345");;
        ListaSubmissoes instance = new ListaSubmissoes();
        Submissao submissao = new Submissao();
        Artigo artigo = new Artigo();
        artigo.getListaAutores().novoAutor(utilizador, new InstituicaoAfiliacao("ISEP"));
        instance.getListaSubmissoes().add(submissao);
        boolean expResult = false;
        boolean result = instance.isUtilizadorUmAutorSubmissaoInicial(utilizador);
        assertEquals(expResult, result);
    }

}
