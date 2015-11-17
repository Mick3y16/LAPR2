package eventoscientificos.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * Teste á classe ListaConflitos.
 * 
 * @author G01
 */
public class ListaConflitosTest {

    private Revisor revisor;
    private Submissao submissao;
    private List<TipoConflito> listaTiposConflito;
    private Conflito conflito;
    
    public ListaConflitosTest() {
        Utilizador utilizador = new Utilizador(
                "Pedro", "1140781@isep.ipp.pt", "pedro", "1234");
        Revisor revisor = new Revisor(utilizador);
        Artigo artigo = new Artigo();
        artigo.setTitulo("Um artigo sobre testes unitários");
        Submissao submissao = new Submissao();
        submissao.setArtigoInicial(artigo);
        submissao.setArtigoFinal(artigo);
        TipoConflito tipoConflito = new TipoConflito("Caiu do tricilo aos 6 anos.");
        List<TipoConflito> listaTiposConflito = new ArrayList();
        listaTiposConflito.add(tipoConflito);
        
        this.conflito = new Conflito(revisor, submissao, listaTiposConflito);
        this.listaTiposConflito = listaTiposConflito;
        this.submissao = submissao;
        this.revisor = revisor;
    }

    /**
     * Teste do método validarExistenciaConflito, da classe ListaConflitos.
     */
    @Test
    public void testValidarExistenciaConflito() {
        System.out.println("validarExistenciaConflito");
        Revisor revisor = this.revisor;
        Submissao submissao = this.submissao;
        ListaConflitos instance = new ListaConflitos();
        instance.adicionarConflito(this.conflito);
        Conflito expResult = new Conflito(revisor, submissao, new ArrayList());
        Conflito result = instance.validarExistenciaConflito(revisor, submissao);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método novoConflito, da classe ListaConflitos.
     */
    @Test
    public void testNovoConflito() {
        System.out.println("novoConflito");
        Revisor revisor = this.revisor;
        Submissao submissao = this.submissao;
        TipoConflito tipoConflito = new TipoConflito("Falta-lhe o dedo mindinho"
                + " não chega ao CTRL quando está a programar.");
        ListaConflitos instance = new ListaConflitos();
        Conflito expResult = new Conflito(revisor, submissao, new ArrayList());
        Conflito result = instance.novoConflito(revisor, submissao, tipoConflito);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método adicionarConflito, da classe ListaConflitos.
     */
    @Test
    public void testAdicionarConflito() {
        System.out.println("adicionarConflito");
        Conflito conflito = this.conflito;
        ListaConflitos instance = new ListaConflitos();
        boolean expResult = true;
        boolean result = instance.adicionarConflito(conflito);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe ListaConflitos.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = new ListaConflitos();
        ListaConflitos instance = new ListaConflitos();
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe ListaConflitos.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equalsNot");
        Object outroObjeto = new ListaConflitos();
        ListaConflitos instance = new ListaConflitos();
        instance.adicionarConflito(this.conflito);
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }
    
}
