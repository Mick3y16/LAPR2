package eventoscientificos.model;

import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe de teste criada testar a classe do Utilizador e os seus metodos
 *
 * @author G01
 */
public class RegistoUtilizadoresTest {

    /**
     * Construtor do registoUtilizador teste
     */
    public RegistoUtilizadoresTest() {
    }

    /**
     * Teste ao metodo novoUtilizador da classe RegistoUtilizadores.
     */
    @Test
    public void testNovoUtilizador() throws IOException {
        System.out.println("novoUtilizador");
        String nome = "Rita";
        String email = "rita_susana@email.com";
        String username = "rita";
        String password = "1234";
        RegistoUtilizadores instance = new RegistoUtilizadores();
        Utilizador expResult = new Utilizador(nome, email, username, password);
        Utilizador result = instance.novoUtilizador(nome, email, username, password);
        assertEquals(expResult, result);
    }

    /**
     * Teste ao metodo AdicionarUtilizador da classe RegistoUtilizadores.
     */
    @Test
    public void testAdicionaUtilizador() throws IOException {
        System.out.println("adicionaUtilizador");
        Utilizador u = new Utilizador("Sususana", "email@gmail.com", "susus", "1234");
        RegistoUtilizadores instance = new RegistoUtilizadores();
        boolean expResult = true;
        boolean result = instance.adicionaUtilizador(u);
        assertEquals(expResult, result);
    }

    /**
     * Teste ao metodo getUtilizador da classe RegistoUtilizadores.
     */
    @Test
    public void testgetUtilizadorUsername() throws IOException {
        System.out.println("getUtilizadorUsername");
        RegistoUtilizadores instance = new RegistoUtilizadores();
        Utilizador expResult = new Utilizador("Sususana", "email@gmail.com", "susus", "1234");
        instance.adicionaUtilizador(expResult);
        Utilizador result = instance.getUtilizador("susus");
        assertEquals(expResult, result);

    }

    /**
     * Teste ao método validarUtilizadorClone, da classe RegistoUtilizadores.
     */
    @Test
    public void testValidarUtilizadorClone() throws IOException {
        System.out.println("validarUtilizadorClone");
        RegistoUtilizadores instance = new RegistoUtilizadores();
        Utilizador utilizador = new Utilizador(
                            "pedro", "1140781@isep.ipp.pt", "pedro", "1234");
        Utilizador utilizadorClone = utilizador.criarCloneUtilizador();
        instance.adicionaUtilizador(utilizador);
        boolean result = true;
        boolean expResult = instance.validarUtilizadorClone(utilizador, utilizadorClone);
        assertEquals(expResult, result);
    }

    /**
     * Teste ao método atualizarUtilizadorClone, da classe RegistoUtilizadores.
     */
    @Test
    public void testAtualizarUtilizador() throws IOException {
        System.out.println("atualizarUtilizador");
        RegistoUtilizadores instance = new RegistoUtilizadores();
        Utilizador utilizador = new Utilizador(
                            "pedro", "1140781@isep.ipp.pt", "pedro", "1234");
        Utilizador utilizadorClone = utilizador.criarCloneUtilizador();
        instance.adicionaUtilizador(utilizador);
        boolean result = true;
        boolean expResult = instance.atualizarUtilizador(utilizador, utilizadorClone);
        assertEquals(expResult, result);
    }

    /**
     * Teste ao metodo getUtilizador da classe RegistoUtilizadores.
     */
    @Test
    public void testgetUtilizadorEmail() throws IOException {
        System.out.println("getUtilizadorEmail");
        RegistoUtilizadores instance = new RegistoUtilizadores();
        Utilizador expResult = new Utilizador("Sususana", "email@gmail.com", "susus", "1234");
        instance.adicionaUtilizador(expResult);
        Utilizador result = instance.getUtilizador("email@gmail.com");
        assertEquals(expResult, result);

    }

    /**
     * Teste do método equals, da classe RegistoUtilizadores.
     */
    @Test
    public void testEquals() throws IOException {
        System.out.println("equals");
        Object outroObjeto = new RegistoUtilizadores();
        RegistoUtilizadores instance = new RegistoUtilizadores();
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe RegistoUtilizadores.
     */
    @Test
    public void testEqualsNot() throws IOException {
        System.out.println("equalsNot");
        Object outroObjeto = new RegistoUtilizadores();
        RegistoUtilizadores instance = new RegistoUtilizadores();
        instance.adicionaUtilizador(
                            new Utilizador("Susana", "email@gmail.com", "susus", "1234"));
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getNumeroUtilizadores, da classe RegistoUtilizadores.
     */
    @Test
    public void testGetNumeroUtilizadores() throws IOException {
        System.out.println("getNumeroUtilizadores");
        RegistoUtilizadores instance = new RegistoUtilizadores();
        instance.adicionaUtilizador(
                            new Utilizador("Susana", "email@gmail.com", "susus", "1234"));
        int expResult = 1;
        int result = instance.getNumeroUtilizadores();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getUtilizadorPeloID, da classe RegistoUtilizadores.
     */
    @Test
    public void testGetUtilizadorPeloID() throws IOException {
        System.out.println("getUtilizadorPeloID");
        int indice = 0;
        RegistoUtilizadores instance = new RegistoUtilizadores();
        instance.adicionaUtilizador(
                            new Utilizador("Susana", "email@gmail.com", "susus", "1234"));
        Utilizador expResult
                            = new Utilizador("Susana", "email@gmail.com", "susus", "1234");
        Utilizador result = instance.getUtilizadorPeloID(indice);
        assertEquals(expResult, result);
    }

    /**
     * Test of novoUtilizador method, of class RegistoUtilizadores.
     */
    @Test
    public void testNovoUtilizador_4args() throws IOException {
        System.out.println("novoUtilizador");
        String nome = "Rita";
        String email = "rita_susana@email.com";
        String username = "rita";
        String password = "1234";
        RegistoUtilizadores instance = new RegistoUtilizadores();
        Utilizador expResult = new Utilizador(nome, email, username, password);
        Utilizador result = instance.novoUtilizador(nome, email, username, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of novoUtilizador method, of class RegistoUtilizadores.
     */
    @Test
    public void testNovoUtilizador_5args() throws IOException {
        System.out.println("novoUtilizador");
        String nome = "Rita";
        String email = "rita_susana@email.com";
        String username = "rita";
        String password = "1234";
        String codificadorTabela = "CA;T001;4";
        RegistoUtilizadores instance = new RegistoUtilizadores();
        Utilizador expResult = new Utilizador(nome, email, username, password);
        Utilizador result = instance.novoUtilizador(nome, email, username, password, codificadorTabela);
        assertEquals(expResult, result);
    }

    /**
     * Teste ao método codificarPassword, da classe Registo Utilizadores.
     */
    @Test
    public void testCodificarPassword() throws IOException {
        System.out.println("codificarPassword");
        Empresa empresa = new Empresa();
        empresa.getRegistoUtilizadores().iniciarCodificadorAritmetico();
        String expResult = "0.0";
        String result = empresa.getRegistoUtilizadores().codificarPassword("!!", 0);
        assertEquals(expResult, result);
    }

}
