package eventoscientificos.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testa a classe Licitação
 *
 * @author G01
 */
public class LicitacaoTest {

    /**
     * Revisor que licita.
     */
    private Revisor revisor;
    /**
     * Submissao a licitar.
     */
    private Submissao submissao;
    /**
     * Grau de interesse em rever.
     */
    private int grauInteresse;
    /**
     * Lista de conflitos de interesse entre o revisor e o submissao a rever
     */
    private Conflito conflito;

    /**
     * Constrói uma instancia de LicitacaoTest.
     */
    public LicitacaoTest() {
        Artigo artigoInicial = new Artigo();
        Artigo artigoFinal = new Artigo();
        this.submissao = new Submissao();
        submissao.setArtigoInicial(artigoInicial);
        submissao.setArtigoFinal(artigoFinal);
        Licitacao instance = new Licitacao(new Revisor(new Utilizador(
                            "fatima", "ola@iml.com", "fafa", "1234")),
                            this.submissao, 0, null);
        this.revisor = new Revisor(new Utilizador(
                            "Tiago", "1131658@isep.ipp.pt", "tiago", "1234"));
        this.submissao = new Submissao();
        this.submissao.setArtigoFinal(new Artigo());
        this.submissao.setArtigoInicial(new Artigo());
        conflito = new Conflito(revisor, submissao, new ArrayList());
        this.grauInteresse = 2;

    }

    /**
     * Test of setGrauInteresse method, of class Licitacao.
     */
    @Test
    public void testSetGrauInteresse() {
        System.out.println("setGrauInteresse");
        int grauInteresse = 3;
        Licitacao instance = new Licitacao(new Revisor(new Utilizador(
                            "fatima", "ola@iml.com", "fafa", "1234")),
                            new Submissao(), 0, null);

        instance.setGrauInteresse(grauInteresse);
    }

    /**
     * Test of validarLicitacao method, of class Licitacao.
     */
    @Test
    public void testValidarLicitacao() {
        System.out.println("validarLicitacao");
        Licitacao instance = new Licitacao(new Revisor(new Utilizador(
                            "fatima", "ola@iml.com", "fafa", "1234")),
                            new Submissao(), 0, null);
        boolean expResult = true;
        boolean result = instance.validarLicitacao();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Licitacao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = new Licitacao(new Revisor(new Utilizador(
                            "fatima", "ola@iml.com", "fafa", "1234")),
                            this.submissao, 0, null);;
        Licitacao instance = new Licitacao(new Revisor(new Utilizador(
                            "fatima", "ola@iml.com", "fafa", "1234")),
                            this.submissao, 0, null);;
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Licitacao.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equalsNot");
        Object outroObjeto = new Licitacao(new Revisor(new Utilizador(
                            "fatima", "ola@iml.com", "fafa", "1234")),
                            this.submissao, 0, null);;
        Licitacao instance = new Licitacao(new Revisor(new Utilizador(
                            "fatima", "fifi@iml.com", "fafa", "1234")),
                            this.submissao, 0, null);;
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);

    }

    /**
     * Test of getConflito method, of class Licitacao.
     */
    @Test
    public void testSetAndGetConflito() {
        System.out.println("setAndGetConflito");
        List<TipoConflito> listaTc = new ArrayList<>();
        listaTc.add(new TipoConflito("Empregado"));
        Licitacao instance = new Licitacao(revisor, submissao, grauInteresse, new Conflito(revisor, submissao, listaTc));
        instance.setConflito(new Conflito(revisor, submissao, listaTc));
        Conflito expResult = new Conflito(revisor, submissao, listaTc);
        Conflito result = instance.getConflito();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGrauInteresse method, of class Licitacao.
     */
    @Test
    public void testGetGrauInteresse() {
        System.out.println("getGrauInteresse");
        Licitacao instance = new Licitacao(revisor, submissao, grauInteresse, conflito);
        int expResult = 2;
        int result = instance.getGrauInteresse();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRevisor method, of class Licitacao.
     */
    @Test
    public void testGetRevisor() {
        System.out.println("getRevisor");
        Licitacao instance = new Licitacao(revisor, submissao, grauInteresse, conflito);
        Revisor expResult = this.revisor;
        Revisor result = instance.getRevisor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSubmissao method, of class Licitacao.
     */
    @Test
    public void testGetSubmissao() {
        System.out.println("getSubmissao");
        Licitacao instance = new Licitacao(revisor, submissao, grauInteresse, conflito);
        Submissao expResult = this.submissao;
        Submissao result = instance.getSubmissao();
        assertEquals(expResult, result);
    }

}
