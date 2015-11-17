package eventoscientificos.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste à classe ListaAutores
 * @author G01
 */
public class ListaAutoresTest {

    private Autor autor;
    private Utilizador utilizador;
    public ListaAutoresTest() {
        this.autor = new Autor("Beatriz", "1140587@isep.ipp.pt",
                new InstituicaoAfiliacao("ISEP"));
        this.utilizador = new Utilizador("nome", "11111@isep.ipp.pt", "username", "1234");
    }

    /**
     * Teste do método novoAutor, da classe ListaAutores.
     */
    @Test
    public void testNovoAutor() {
        System.out.println("novoAutor");
        Utilizador utilizador = this.utilizador;
        String nome = "Beatriz";
        String email = "12345@isep.ipp.pt";
        InstituicaoAfiliacao instituicaoAfiliacao = new InstituicaoAfiliacao("isep");
        ListaAutores instance = new ListaAutores();
        instance.novoAutor(utilizador, instituicaoAfiliacao);
        boolean expResult = true;
        boolean result = instance.novoAutor(nome, email, instituicaoAfiliacao);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getListaAutoresRegistados, da classe ListaAutores.
     */
    @Test
    public void testGetListaAutoresRegistados() {
        System.out.println("getListaAutoresRegistados");
        String nome = "Beatriz";
        String email = "12345@isep.ipp.pt";
        InstituicaoAfiliacao instituicaoAfiliacao = new InstituicaoAfiliacao("isep");
        ListaAutores instance = new ListaAutores();
        instance.novoAutor(nome, email, instituicaoAfiliacao);
        Utilizador utilizador = this.utilizador;
        Utilizador utilizador1 = new Utilizador("nome1", "111112@isep.ipp.pt", "username1", "12341");
        instance.novoAutor(utilizador, instituicaoAfiliacao);
        instance.novoAutor(utilizador1, instituicaoAfiliacao);
        int expResult = 2;
        int result = instance.getListaAutoresRegistados().size();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe ListaAutores.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equalsNot");
        Utilizador utilizador = this.utilizador;
        Utilizador utilizador1 = new Utilizador("nome1", "00000@isep.ipp.pt", "username1", "12341");
        Object outroObjeto = new ListaAutores();
        ((ListaAutores) outroObjeto).novoAutor(utilizador, new InstituicaoAfiliacao("isep"));
        ListaAutores instance = new ListaAutores();
        instance.novoAutor(utilizador1, new InstituicaoAfiliacao("isep"));
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe ListaAutores.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = new ListaAutores();
        Utilizador utilizador = this.utilizador;
        ((ListaAutores) outroObjeto).novoAutor(utilizador, new InstituicaoAfiliacao("isep"));
        ListaAutores instance = new ListaAutores();
        instance.novoAutor(utilizador, new InstituicaoAfiliacao("isep"));
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método removerAutor, da classe ListaAutores.
     */
    @Test
    public void testRemoverAutor() {
        System.out.println("removerAutor");
        ListaAutores instance = new ListaAutores();
        Utilizador utilizador = this.utilizador;
        instance.novoAutor(utilizador, new InstituicaoAfiliacao("isep"));
        boolean expResult = true;
        boolean result = instance.removerAutor(0);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método isAutor, da classe ListaAutores.
     */
    @Test
    public void testIsAutor() {
        System.out.println("isAutor");
        ListaAutores instance = new ListaAutores();
        Utilizador utilizador = this.utilizador;
        instance.novoAutor(utilizador, new InstituicaoAfiliacao("isep"));
        boolean expResult = true;
        boolean result = instance.isAutor(utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getNumeroAutores, da classe ListaAutores.
     */
    @Test
    public void testGetNumeroAutores() {
        System.out.println("getNumeroAutores");
        ListaAutores instance = new ListaAutores();
        Utilizador utilizador = this.utilizador;
        instance.novoAutor(utilizador, new InstituicaoAfiliacao("isep"));
        int expResult = 1;
        int result = instance.getNumeroAutores();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getAutorPeloID, da classe ListaAutores.
     */
    @Test
    public void testGetAutorPeloID() {
        System.out.println("getAutorPeloID");
        ListaAutores instance = new ListaAutores();
        Utilizador utilizador = this.utilizador;
        instance.novoAutor(utilizador, new InstituicaoAfiliacao("isep"));
        int indice = 0;
        Autor expResult = new Autor(utilizador, new InstituicaoAfiliacao("isep"));
        Autor result = instance.getAutorPeloID(indice);
        assertEquals(expResult, result);
    }

}
