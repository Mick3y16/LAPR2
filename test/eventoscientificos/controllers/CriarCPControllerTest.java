package eventoscientificos.controllers;

import eventoscientificos.model.CP;
import eventoscientificos.model.Empresa;
import eventoscientificos.model.Evento;
import eventoscientificos.model.Local;
import eventoscientificos.model.SessaoTematica;
import eventoscientificos.model.Utilizador;
import eventoscientificos.model.state.evento.EventoSessoesTematicasDefinidasState;
import javax.swing.DefaultListModel;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 *
 * @author Tiago Ferreira
 */
public class CriarCPControllerTest {

    private Empresa empresa;
    private Evento evento;
    private SessaoTematica st;
    private Utilizador utilizador;

    public CriarCPControllerTest() {
        Utilizador utilizador = new Utilizador(
                "fatima", "ola@iml.com", "fafa", "1234");
        CP cp = new CP();
        cp.novoRevisor(utilizador);
        Evento evento = new Evento("titulo", "descricao", new Local("local"),
                new Data(2016, 6, 8), new Data(2016, 6, 20),
                new Data(2016, 7, 7), new Data(2016, 9, 10),
                new Data(2016, 9, 11), new Data(2016, 10, 1),
                new Data(2017, 6, 10));
        evento.novoOrganizador(utilizador);
        evento.setEstado(new EventoSessoesTematicasDefinidasState(evento));
        Evento outroEvento = new Evento("Francisca", "descricao", new Local("local"),
                new Data(2016, 6, 8), new Data(2016, 6, 20),
                new Data(2016, 7, 7), new Data(2016, 9, 10),
                new Data(2016, 9, 11), new Data(2016, 10, 1),
                new Data(2017, 6, 10));
        outroEvento.novoOrganizador(utilizador);
        outroEvento.setEstado(new EventoSessoesTematicasDefinidasState(outroEvento));
        
        Empresa empresa = new Empresa();
        empresa.setUtilizadorAutenticado(utilizador);
        empresa.getRegistoUtilizadores().adicionaUtilizador(utilizador);
        empresa.getRegistoEventos().adicionarEvento(evento);
        empresa.getRegistoEventos().adicionarEvento(outroEvento);
        
        this.utilizador = utilizador;
        this.evento = evento;
        this.empresa = empresa;
    }

    /**
     * Teste do método getListaCPDefiniveisSemCPOrganizadorProponente, da classe
     * CriarCPController.
     */
    @Test
    public void testGetListaCPDefiniveisSemCPOrganizadorProponente() {
        System.out.println("getListaCPDefiniveisSemCPOrganizadorProponente");
        CriarCPController instance = new CriarCPController(empresa);
        empresa.setUtilizadorAutenticado(utilizador);
        boolean expResult = true;
        boolean result = instance.getListaCPDefiniveisSemCPOrganizadorProponente();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método selecionarCPDefinivel, da classe CriarCPController.
     */
    @Test
    public void testSelecionarCPDefinivel() {
        System.out.println("selecionarCPDefinivel");
        int indice = 0;
        CriarCPController instance = new CriarCPController(empresa);
        instance.getListaCPDefiniveisSemCPOrganizadorProponente();
        boolean expResult = true;
        boolean result = instance.selecionarCPDefinivel(indice);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método novoRevisor, da class CriarCPController.
     */
    @Test
    public void testNovoRevisor() {
        System.out.println("novoRevisor");
        Empresa emp = new Empresa();
        String id = "fafa";
        CriarCPController instance = new CriarCPController(this.empresa);
        instance.getListaCPDefiniveisSemCPOrganizadorProponente();
        instance.selecionarCPDefinivel(0);
        boolean expResult = true;
        boolean result = instance.novoRevisor(id);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarCP, da classe CriarCPController.
     */
    @Test
    public void testValidarCP() {
        System.out.println("validarCP");
        CriarCPController instance =  new CriarCPController(this.empresa);
        instance.getListaCPDefiniveisSemCPOrganizadorProponente();
        instance.selecionarCPDefinivel(0);
        instance.novoRevisor("fafa");
        boolean expResult = true;
        boolean result = instance.validarCP();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método adicionarCP, da classe CriarCPController.
     */
    @Test
    public void testAdicionarCP() {
        System.out.println("adicionarCP");
        CriarCPController instance = new CriarCPController(this.empresa);
        instance.getListaCPDefiniveisSemCPOrganizadorProponente();
        instance.selecionarCPDefinivel(0);
        instance.novoRevisor("ola@iml.com");
        instance.validarCP();
        boolean expResult = true;
        boolean result = instance.adicionarCP();
        assertEquals(expResult, result);
    }

    /**
     * Test of getModeloLista method, of class CriarCPController.
     */
    @Test
    public void testGetModeloLista() {
        System.out.println("getModeloLista");
        CriarCPController instance = new CriarCPController(this.empresa);
        String expResult = new DefaultListModel().getClass().getSimpleName();
        String result = instance.getModeloLista().getClass().getSimpleName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaCPDefinivel method, of class CriarCPController.
     */
    @Test
    public void testGetListaCPDefinivel() {
        System.out.println("getListaCPDefinivel");
        CriarCPController instance = new CriarCPController(this.empresa);
        instance.getListaCPDefiniveisSemCPOrganizadorProponente();
        int expResult = 2;
        int result = instance.getListaCPDefinivel().size();
        assertEquals(expResult, result);
    }

}
