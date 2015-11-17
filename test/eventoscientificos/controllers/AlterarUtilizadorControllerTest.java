package eventoscientificos.controllers;

import eventoscientificos.model.Empresa;
import eventoscientificos.model.Utilizador;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author G01
 */
public class AlterarUtilizadorControllerTest {

    private Empresa empresa;
    private Utilizador utilizador;

    public AlterarUtilizadorControllerTest() {
        this.empresa = new Empresa();
        this.utilizador = new Utilizador(
                "Beatriz", "1140587@isep.ipp.pt", "beatrizVelho", "isep2014");
        this.utilizador.setCodificadorTabela("NFN");
        empresa.setUtilizadorAutenticado(utilizador);
        empresa.getRegistoUtilizadores().adicionaUtilizador(utilizador);

    }

    /**
     * Test of getUtilizadorNome method, of class AlterarUtilizadorController.
     */
    @Test
    public void testGetUtilizadorNome() {
        System.out.println("getUtilizadorNome");
        AlterarUtilizadorController instance = new AlterarUtilizadorController(empresa);
        instance.criarCloneUtilizador();
        String expResult = "Beatriz";
        String result = instance.getUtilizadorNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUtilizadorEmail method, of class AlterarUtilizadorController.
     */
    @Test
    public void testGetUtilizadorEmail() {
        System.out.println("getUtilizadorEmail");
        AlterarUtilizadorController instance = new AlterarUtilizadorController(empresa);
        instance.criarCloneUtilizador();
        String expResult = "1140587@isep.ipp.pt";
        String result = instance.getUtilizadorEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUtilizadorUsername method, of class
     * AlterarUtilizadorController.
     */
    @Test
    public void testGetUtilizadorUsername() {
        System.out.println("getUtilizadorUsername");
        AlterarUtilizadorController instance = new AlterarUtilizadorController(empresa);
        instance.criarCloneUtilizador();
        String expResult = "beatrizVelho";
        String result = instance.getUtilizadorUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUtilizadorPassword method, of class
     * AlterarUtilizadorController.
     */
    @Test
    public void testGetUtilizadorPassword() {
        System.out.println("getUtilizadorPassword");
        AlterarUtilizadorController instance = new AlterarUtilizadorController(empresa);
        instance.criarCloneUtilizador();
        String expResult = "isep2014";
        String result = instance.getUtilizadorPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of criarCloneUtilizador method, of class
     * AlterarUtilizadorController.
     */
    @Test
    public void testCriarCloneUtilizador() {
        System.out.println("criarCloneUtilizador");
        AlterarUtilizadorController instance = new AlterarUtilizadorController(empresa);
        boolean expResult = true;
        boolean result = instance.criarCloneUtilizador();
        assertEquals(expResult, result);
    }

    /**
     * Test of alterarDadosUtilizador method, of class
     * AlterarUtilizadorController.
     */
    @Test
    public void testAlterarDadosUtilizador() {
        System.out.println("alterarDadosUtilizador");
        String username = "Joao";
        String password = "12345";
        String nome = "JoaoPedro";
        String email = "joao@isep.ipp.pt";
        AlterarUtilizadorController instance = new AlterarUtilizadorController(empresa);
        instance.criarCloneUtilizador();
        boolean expResult = true;
        boolean result = instance.alterarDadosUtilizador(username, password, nome, email);
        assertEquals(expResult, result);
    }

    /**
     * Test of atualizarUtilizador method, of class AlterarUtilizadorController.
     */
    @Test
    public void testAtualizarUtilizador() {
        System.out.println("atualizarUtilizador");
        String username = "Joao";
        String password = "12345";
        String nome = "JoaoPedro";
        String email = "joao@isep.ipp.pt";
        AlterarUtilizadorController instance = new AlterarUtilizadorController(empresa);
        instance.criarCloneUtilizador();
        instance.alterarDadosUtilizador(username, password, nome, email);
        boolean expResult = true;
        boolean result = instance.atualizarUtilizador();
        assertEquals(expResult, result);
    }
}
