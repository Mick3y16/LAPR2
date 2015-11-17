package eventoscientificos.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * Teste a classe Artigo
 * @author G01
 */
public class ArtigoTest {

    /**
     *
     */
    private Artigo artigo;

    public ArtigoTest() {
        this.artigo = new Artigo();
    }

    /**
     * Teste do método set e get Titulo, da classe Artigo.
     */
    @Test
    public void testSetAndGetTitulo() {
        System.out.println("setAndGetTitulo");
        Artigo instance = this.artigo;
        String expResult = "titulo1";
        instance.setTitulo(expResult);
        String result = instance.getTitulo();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método set e get Resumo, da classe Artigo.
     */
    @Test
    public void testSetAndGetResumo() {
        System.out.println("setAndGetResumo");
        Artigo instance = this.artigo;
        String expResult = "saude1";
        instance.setResumo(expResult);
        String result = instance.getResumo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPalavrasChave method, of class Artigo.
     */
    @Test
    public void testSetAndGetPalavrasChave() {
        System.out.println("setAndgetPalavrasChave");
        Artigo instance = this.artigo;
        List<String> palavraChave = new ArrayList<>();
        palavraChave.add("Cebola");
        instance.setPalavrasChave(palavraChave);
        int expResult = 1;
        int result = instance.getPalavrasChave().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPalavrasChave method, of class Artigo.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetAndGetPalavrasChaveNull() {
        System.out.println("setAndgetPalavrasChave");
        Artigo instance = this.artigo;
        List<String> palavraChave = new ArrayList<>();
        instance.setPalavrasChave(palavraChave);
        int expResult = 0;
        int result = instance.getPalavrasChave().size();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método set e get ListaAutores, da classe Artigo.
     */
    @Test
    public void testGetListaAutores() {
        System.out.println("getListaAutores");
        Artigo instance = this.artigo;
        ListaAutores expResult = new ListaAutores();
        ListaAutores result = instance.getListaAutores();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setFicheiro, da classe Artigo.
     */
    @Test
    public void testGetAndSetFicheiro() {
        System.out.println("getAndSetFicheiro");
        Artigo instance = this.artigo;
        String expResult = "ficheiro";
        instance.setFicheiro(expResult);
        String result = instance.getFicheiro();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método set e get AutorCorrespondente, da classe Submissao.
     */
    @Test
    public void testSetAndGetAutorCorrespondente() {
        System.out.println("setAndGetAutorCorrespondente");
        Artigo instance = new Artigo();
        AutorCorrespondente expResult = new AutorCorrespondente(
                new Utilizador("nome", "1140587@isep.ipp.pt", "username", "password"),
                new InstituicaoAfiliacao("ISEP"));
        instance.setAutorCorrespondente(expResult);
        AutorCorrespondente result = instance.getAutorCorrespondente();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método set e get AutorSubmissorInicial, da classe Submissao.
     */
    @Test
    public void testGetAndSetAutorSubmissor() {
        System.out.println("setAndGetAutorSubmissor");
        Artigo instance = new Artigo();
        Autor expResult = new Autor(
                new Utilizador("nome", "1140587@isep.ipp.pt", "username", "password"),
                new InstituicaoAfiliacao("ISEP"));
        instance.setAutorSubmissor(expResult);
        Autor result = instance.getAutorSubmissor();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe Artigo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = this.artigo;
        Artigo instance = this.artigo;
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
        Object outroObjeto = new Artigo();
        Artigo instance = this.artigo;
        instance.setTitulo("E tudo o vento testou...");
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDataSubmissao method, of class Artigo.
     */
    @Test
    public void testSetAndGetDataSubmissao() {
        System.out.println("setAndGetDataSubmissao");
        Artigo instance = this.artigo;
        Data expResult = new Data(2017, 05, 05);
        instance.setDataSubmissao(expResult);
        Data result = instance.getDataSubmissao();
        assertEquals(expResult, result);
    }

    /**
     * Test of validarArtigo method, of class Artigo.
     */
    @Test
    public void testValidarArtigo() {
        System.out.println("validarArtigo");
        Artigo instance = this.artigo;
        boolean expResult = true;
        boolean result = instance.validarArtigo();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAutor method, of class Artigo.
     */
    @Test
    public void testIsAutor() {
        System.out.println("isAutor");
        Utilizador utilizador = new Utilizador("nome", "email@isep.com",
                "username", "password");
        Artigo instance = new Artigo();
        instance.getListaAutores().novoAutor(utilizador,
                new InstituicaoAfiliacao("ISEP"));
        boolean expResult = true;
        boolean result = instance.isAutor(utilizador);
        assertEquals(expResult, result);
    }

}
