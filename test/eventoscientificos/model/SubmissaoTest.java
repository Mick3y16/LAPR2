package eventoscientificos.model;

import eventoscientificos.model.state.submissao.SubmissaoAceiteState;
import eventoscientificos.model.state.submissao.SubmissaoEmLicitacaoState;
import eventoscientificos.model.state.submissao.SubmissaoEmSubmissaoState;
import eventoscientificos.model.state.submissao.SubmissaoRejeitadaState;
import eventoscientificos.model.state.submissao.SubmissaoState;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * Teste à classe Submissão
 * @author G01
 */
public class SubmissaoTest {

    private Artigo artigoInicial;
    private Artigo artigoFinal;
    private Utilizador utilizador;

    public SubmissaoTest() {
        this.artigoInicial = new Artigo();
        this.artigoFinal = new Artigo();
        this.utilizador = new Utilizador("nome", "1140587@isep.ipp.pt", "username", "password");
    }

    /**
     * Teste do método set e get ArtigoInicial, da classe Submissao.
     */
    @Test
    public void testSetGetArtigoInicial() {
        System.out.println("setAndGetArtigoInicial");
        Submissao instance = new Submissao();
        Artigo expResult = this.artigoInicial;
        instance.setArtigoInicial(expResult);
        Artigo result = instance.getArtigoInicial();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método set e get ArtigoFinal, da classe Submissao.
     */
    @Test
    public void testSetAndGetArtigoFinal() {

        System.out.println("setAndGetArtigoFinal");
        Submissao instance = new Submissao();
        Artigo expResult = this.artigoFinal;
        instance.setArtigoFinal(expResult);
        Artigo result = instance.getArtigoFinal();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método set e get Estado method, da classe Submissao.
     */
    @Test
    public void testSetAndGetEstado() {
        System.out.println("setAndGetEstado");
        Submissao instance = new Submissao();
        SubmissaoState expResult = new SubmissaoAceiteState(instance);
        instance.setEstado(expResult);
        SubmissaoState result = instance.getEstado();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método alterarEstadoSubmissao, da classe Submissao.
     */
    @Test
    public void testValidarSubmissao() {
        System.out.println("validarSubmissao");
        Submissao instance = new Submissao();
        boolean expResult = true;
        boolean result = instance.alterarEstadoSubmissao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método adicionarArtigo, da classe Submissao.
     */
    @Test
    public void testAdicionarArtigoInicial() {
        System.out.println("adicionarArtigoInicial");
        Artigo artigo = this.artigoInicial;
        Submissao instance = new Submissao();
        boolean expResult = true;
        boolean result = instance.adicionarArtigo(artigo);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método adicionarArtigo, da classe Submissao.
     */
    @Test
    public void testAdicionarArtigoFinal() {
        System.out.println("adicionarArtigoFinal");
        Artigo artigo = this.artigoFinal;
        Submissao instance = new Submissao();
        instance.setEstado(new SubmissaoAceiteState(instance));
        boolean expResult = true;
        boolean result = instance.adicionarArtigo(artigo);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe Submissao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjecto = new Submissao();
        Submissao outraSubmissao = (Submissao) outroObjecto;
        outraSubmissao.setArtigoInicial(this.artigoInicial);
        outraSubmissao.setArtigoFinal(this.artigoFinal);
        Submissao instance = new Submissao();
        instance.setArtigoInicial(this.artigoInicial);
        instance.setArtigoFinal(this.artigoFinal);
        boolean expResult = true;
        boolean result = instance.equals(outroObjecto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe Submissao.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equalsNot");
        Object outroObjecto = new Submissao();
        Submissao instance = new Submissao();
        instance.setArtigoInicial(this.artigoInicial);
        instance.setArtigoFinal(this.artigoFinal);
        boolean expResult = false;
        boolean result = instance.equals(outroObjecto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método novoArtigo method, da classe Submissao.
     */
    @Test
    public void testNovoArtigo() {
        System.out.println("novoArtigo");
        Submissao instance = new Submissao();
        Artigo expResult = this.artigoInicial;
        Artigo result = instance.novoArtigo();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método alterarEstadoSubmissao, da classe Submissao.
     */
    @Test
    public void testAlterarEstadoSubmissao() {
        System.out.println("alterarEstadoSubmissao");
        Submissao instance = new Submissao();
        boolean expResult = true;
        boolean result = instance.alterarEstadoSubmissao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarSubmissao, da classe Submissao.
     */
    @Test
    public void testValidarArtigoEmSubmissao() {
        System.out.println("validarArtigo");
        Submissao instance = new Submissao();
        boolean expResult = true;
        boolean result = this.artigoInicial.validarArtigo();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarSubmissao, da classe Submissao.
     */
    @Test
    public void testValidarArtigoAceite() {
        System.out.println("validarArtigo");
        Submissao instance = new Submissao();
        instance.setEstado(new SubmissaoAceiteState(instance));
        boolean expResult = true;
        boolean result = this.artigoFinal.validarArtigo();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método adicionarArtigo, da classe Submissao.
     */
    @Test
    public void testAdicionarArtigoEmSubmissao() {
        System.out.println("adicionarArtigo");
        Artigo artigo = this.artigoInicial;
        Submissao instance = new Submissao();
        boolean expResult = true;
        boolean result = instance.adicionarArtigo(artigo);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método adicionarArtigo, da classe Submissao.
     */
    @Test
    public void testAdicionarArtigoAceite() {
        System.out.println("adicionarArtigo");
        Artigo artigo = this.artigoInicial;
        Submissao instance = new Submissao();
        instance.setEstado(new SubmissaoAceiteState(instance));
        boolean expResult = true;
        boolean result = instance.adicionarArtigo(artigo);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método criarCloneSubmissao, da classe Submissao.
     */
    @Test
    public void testCriarCloneSubmissao() {
        System.out.println("criarCloneSubmissao");
        Submissao instance = new Submissao();
        Artigo artigo = new Artigo();
        artigo.setTitulo("Era uma vez um teste...");
        List<String> palavrasChave = new ArrayList();
        palavrasChave.add("20 valores");
        artigo.setPalavrasChave(palavrasChave);
        artigo.setAutorCorrespondente(new AutorCorrespondente(this.utilizador, new InstituicaoAfiliacao("ISEP")));
        artigo.setAutorSubmissor(new Autor(this.utilizador, new InstituicaoAfiliacao("ISEP")));
        artigo.setDataSubmissao(Data.dataAtual());
        instance.setArtigoInicial(artigo);
        Submissao novaInstance = instance.criarCloneSubmissao();
        novaInstance.setArtigoInicial(this.artigoInicial);
        boolean expResult = false;
        boolean result = instance.equals(novaInstance);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método isAutor, da classe Submissao.
     */
    @Test
    public void testIsAutor() {
        System.out.println("isAutor");
        Utilizador utilizador = this.utilizador;
        Submissao instance = new Submissao();
        instance.setEstado(new SubmissaoEmSubmissaoState(instance));
        instance.setArtigoInicial(new Artigo());
        instance.getArtigoInicial().getListaAutores().novoAutor(
                            this.utilizador, new InstituicaoAfiliacao("ISEP"));
        boolean expResult = true;
        boolean result = instance.isAutorEmPeriodoSubmissao(utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método isStateRemovida, da classe Submissao.
     */
    @Test
    public void testIsStateRemovida() {
        System.out.println("isStateRemovida");
        Submissao instance = new Submissao();
        instance.setEstado(new SubmissaoRejeitadaState(instance));
        boolean expResult = false;
        boolean result = instance.isStateRemovida();
        assertEquals(expResult, result);
    }
/**
     * Teste do método isStateAceite, da classe Submissao.
     */
    @Test
    public void testIsStateAceite() {
        System.out.println("isStateAceite");
        Submissao instance = new Submissao();
        instance.setEstado(new SubmissaoAceiteState(instance));
        boolean expResult = true;
        boolean result = instance.isStateAceite();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método isStateRemovida, da classe Submissao.
     */
    @Test
    public void testIsStateRemovidaNot() {
        System.out.println("isStateRemovidaNot");
        Submissao instance = new Submissao();
        boolean expResult = false;
        boolean result = instance.isStateRemovida();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAutorArtigo method, of class Submissao.
     */
    @Test
    public void testIsAutorArtigo() {
        System.out.println("isAutorArtigo");
        Utilizador utilizador = new Utilizador("susana", "peixoto@gmail.com ", "susy", "1234");
        Submissao instance = new Submissao();
        instance.setEstado(new SubmissaoEmSubmissaoState(instance));
        instance.setArtigoInicial(artigoInicial);
        instance.setArtigoFinal(artigoFinal);
        ListaAutores listaAutores = this.artigoInicial.getListaAutores();
        listaAutores.novoAutor(utilizador, new InstituicaoAfiliacao("MatosinhosSport"));
        boolean expResult = true;
        boolean result = instance.isAutorArtigo(utilizador);
        assertEquals(expResult, result);

    }

    /**
     * Test of setEstadoRemovida method, of class Submissao.
     */
    @Test
    public void testSetEstadoRemovida() {
        System.out.println("setEstadoRemovida");
        Submissao instance = new Submissao();
        instance.setEstado(new SubmissaoEmLicitacaoState(instance));
        boolean expResult = true;
        boolean result = instance.setEstadoRemovida();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método alterarEstadoParaAceite, da classe Submissao.
     */
    @Test
    public void testAlterarEstadoParaAceite() {
        System.out.println("alterarEstadoParaAceite");
        Submissao instance = new Submissao();
        instance.alterarEstadoParaAceite();
    }

    /**
     * Teste do método alterarEstadoParaRejeitado, da classe Submissao.
     */
    @Test
    public void testAlterarEstadoParaRejeitado() {
        System.out.println("alterarEstadoParaRejeitado");
        Submissao instance = new Submissao();
        instance.alterarEstadoParaRejeitado();
    }

    /**
     * Test of toString method, of class Submissao.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Submissao instance = new Submissao();
        instance.setEstado(new SubmissaoEmSubmissaoState(instance));
        Artigo artigo = new Artigo();
        artigo.setTitulo("ISEP");
        instance.adicionarArtigo(artigo);
        instance.setEstado(new SubmissaoEmSubmissaoState(instance));
        String expResult = "ISEP";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}