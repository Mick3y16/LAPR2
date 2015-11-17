package eventoscientificos.view;

import eventoscientificos.view.ModeloListaAutores;
import eventoscientificos.model.Autor;
import eventoscientificos.model.InstituicaoAfiliacao;
import eventoscientificos.model.ListaAutores;
import eventoscientificos.model.Utilizador;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author G01
 */
public class ModeloListaAutoresTest {

    private ListaAutores listaAutores;

    public ModeloListaAutoresTest() {
        ListaAutores listaAutores = new ListaAutores();
        listaAutores.novoAutor(
                new Utilizador("Pedro Moreira", "1140781@isep.ipp.pt", "pedro", "1234"),
                new InstituicaoAfiliacao("ISEP"));
        listaAutores.novoAutor("bea", "eda@isep.com", new InstituicaoAfiliacao("ISEP"));

        this.listaAutores = listaAutores;
    }

    /**
     * Teste do método getSize, da classe ModeloListaAutores.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        ModeloListaAutores instance = new ModeloListaAutores(listaAutores);
        int expResult = 2;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getElementAt, da classe ModeloListaAutores.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int index = 0;
        ModeloListaAutores instance = new ModeloListaAutores(listaAutores);
        Autor expResult = new Autor(
                new Utilizador("Pedro Moreira", "1140781@isep.ipp.pt", "pedro", "1234"),
                new InstituicaoAfiliacao("ISEP"));
        Autor result = instance.getElementAt(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of addElement method, of class ModeloListaAutores.
     */
    @Test
    public void testAddElementUtilizador() {
        System.out.println("addElement");
        String nome = "luis";
        String email = "adsf@isep.pt";
        String instituicaoAfiliacao = "faculdade";
        Utilizador utilizador = new Utilizador("Pedro", "114@isep.ipp.pt",
                "pedro1234", "1234");
        ModeloListaAutores instance = new ModeloListaAutores(listaAutores);
        boolean expResult = true;
        boolean result = instance.addElement(nome, email, instituicaoAfiliacao, utilizador);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of addElement method, of class ModeloListaAutores.
     */
    @Test
    public void testAddElementSemUtilizador() {
        System.out.println("addElement");
        String nome = "luis";
        String email = "adsf@isep.pt";
        String instituicaoAfiliacao = "faculdade";
        Utilizador utilizador = null;
        ModeloListaAutores instance = new ModeloListaAutores(listaAutores);
        boolean expResult = true;
        boolean result = instance.addElement(nome, email, instituicaoAfiliacao, utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeElement method, of class ModeloListaAutores.
     */
    @Test
    public void testRemoveElement() {
        System.out.println("removeElement");
        int indice = 1;
        ModeloListaAutores instance = new ModeloListaAutores(listaAutores);
        boolean expResult = true;
        boolean result = instance.removeElement(indice);
        assertEquals(expResult, result);
    }

}
