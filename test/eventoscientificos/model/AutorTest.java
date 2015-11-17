package eventoscientificos.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author G01
 */
public class AutorTest {
    
    private InstituicaoAfiliacao instituicaoAfiliacao;
    private Utilizador utilizador;
    private Autor autor, autorRegistado;
    
    public AutorTest() {
        this.instituicaoAfiliacao = new InstituicaoAfiliacao("ISEP");
        this.utilizador = new Utilizador(
                "Beatriz", "1140587@isep.ipp.pt", "bea", "12345");
        this.autor = new Autor(
                "bea", "1140587@isep.ipp.pt", this.instituicaoAfiliacao);
        this.autorRegistado = new Autor(this.utilizador, this.instituicaoAfiliacao);
    }

    /**
     * Teste do método set e get Nome, da classe Autor.
     */
    @Test
    public void testSetAndGetNome() {
        System.out.println("setAndGetNome");
        Autor instance = this.autor;
        String expResult = "pedro";
        instance.setNome(expResult);
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método set e get Email, da classe Autor.
     */
    @Test
    public void testSetAndGetEmail() {
        System.out.println("setAndGetEmail");
        Autor instance = this.autor;
        String expResult = "1140000@isep.ipp.pt";
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método set e get InstituicaoAfiliacao, da classe Autor.
     */
    @Test
    public void testSetAndGetInstituicaoAfiliacao() {
        System.out.println("getInstituicaoAfiliacao");
        Autor instance = this.autor;
        InstituicaoAfiliacao expResult = new InstituicaoAfiliacao("nome1");
        instance.setInstituicaoAfiliacao(expResult);
        InstituicaoAfiliacao result = instance.getInstituicaoAfiliacao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getUtilizador, da classe Autor.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        Autor instance = this.autorRegistado;
        Utilizador expResult = this.utilizador;
        Utilizador result = instance.getUtilizador();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe Autor.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = this.autor;
        Autor instance = this.autorRegistado;
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    
    }
    
    /**
     * Teste do método equals, da classe Autor.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equals");
        Object outroObjeto = this.autor;
        Autor instance = new Autor(
                "bea", "1111111@isep.ipp.pt", this.instituicaoAfiliacao);
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    
    }

    /**
     * Teste do método isAutorRegistado, da classe Autor.
     */
    @Test
    public void testIsAutorRegistado() {
        System.out.println("isAutorRegistado");
        Autor instance = this.autorRegistado;
        boolean expResult = true;
        boolean result = instance.isAutorRegistado();
        assertEquals(expResult, result);
    }
    
    /**
     * Teste do método isAutorRegistado, da classe Autor.
     */
    @Test
    public void testIsAutorRegistadoNot() {
        System.out.println("isAutorRegistado");
        Autor instance = this.autor;
        boolean expResult = false;
        boolean result = instance.isAutorRegistado();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método toString, da classe Autor.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Autor instance = this.autor;
        String expResult = "bea, 1140587@isep.ipp.pt, ISEP";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarAutor, da classe Autor.
     */
    @Test
    public void testValidarAutor() {
        System.out.println("validarAutor");
        Autor instance = this.autor;
        boolean expResult = true;
        boolean result = instance.validarAutor();
        assertEquals(expResult, result);
    }
    
}
