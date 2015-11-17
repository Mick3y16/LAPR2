package eventoscientificos.controllers;

import eventoscientificos.model.Empresa;
import eventoscientificos.model.Evento;
import eventoscientificos.model.Local;
import eventoscientificos.model.Utilizador;
import eventoscientificos.model.state.evento.EventoSessoesTematicasDefinidasState;
import javax.swing.DefaultListModel;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 *
 * @author Pedro
 */
public class DefinirSessaoTematicaControllerTest {

    private Empresa empresa;

    public DefinirSessaoTematicaControllerTest() {
        Empresa empresa = new Empresa();
        Utilizador utilizador = new Utilizador(
                "Pedro", "1140781@isep.ipp.pt", "pedro", "1234");
        empresa.setUtilizadorAutenticado(utilizador);
        empresa.getRegistoUtilizadores().adicionaUtilizador(utilizador);
        Evento evento = new Evento("Titulo", "Descrição", new Local("Porto"),
                new Data(2016, 6, 8), new Data(2016, 6, 20),
                new Data(2016, 7, 7), new Data(2016, 8, 15),
                new Data(2016, 9, 10), new Data(2016, 10, 1),
                new Data(2017, 6, 10));
        evento.novoOrganizador(utilizador);
        evento.setEstado(new EventoSessoesTematicasDefinidasState(evento));
        empresa.getRegistoEventos().adicionarEvento(evento);
        
        this.empresa = empresa;
    }

    /**
     * Teste do método getModeloListaPapel, da classe
     * DefinirSessaoTematicaController.
     */
    @Test
    public void testGetModeloListaPapel() {
        System.out.println("getModeloListaPapel");
        DefinirSessaoTematicaController instance
                = new DefinirSessaoTematicaController(this.empresa);
        String expResult = new DefaultListModel().getClass().getSimpleName();
        String result 
                = instance.getModeloListaPapel().getClass().getSimpleName();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getListaEventos, da classe 
     * DefinirSessaoTematicaController.
     */
    @Test
    public void testGetListaEventos() {
        System.out.println("getListaEventos");
        DefinirSessaoTematicaController instance
                = new DefinirSessaoTematicaController(this.empresa);
        instance.getListaEventosOrganizador();
        int expResult = 1;
        int result = instance.getListaEventos().size();
        assertEquals(expResult, result);
    }

    /**
     * Test do método getListaEventosOrganizador, da classe
     * DefinirSessaoTematicaController.
     */
    @Test
    public void testGetListaEventosOrganizador() {
        System.out.println("getListaEventosOrganizador");
        DefinirSessaoTematicaController instance 
                = new DefinirSessaoTematicaController(this.empresa);
        boolean expResult = true;
        boolean result = instance.getListaEventosOrganizador();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método selecionarEvento, da classe 
     * DefinirSessaoTematicaController.
     */
    @Test
    public void testSelecionarEvento() {
        System.out.println("selecionarEvento");
        DefinirSessaoTematicaController instance
                = new DefinirSessaoTematicaController(this.empresa);
        instance.getListaEventosOrganizador();
        boolean expResult = true;
        int index = 0;
        boolean result = instance.selecionarEvento(index);
        assertEquals(expResult, result);
    }

    /**
     * Teste dp método novaSessaoTematica, da classe
     * DefinirSessaoTematicaController.
     */
    @Test
    public void testNovaSessaoTematica() {
        System.out.println("novaSessaoTematica");
        String codigoUnico = "#ALFA";
        String descricao = "Descrição";
        Data dataInicioSubmissao = new Data(2016, 6, 9);
        Data dataFimSubmissao = new Data(2016, 6, 21);
        Data dataInicioDistribuicao = new Data(2016, 7, 8);
        Data dataFimRevisao = new Data(2016, 8, 16);
        Data dataFimSubmissaoFinal = new Data(2016, 9, 11);
        Data dataInicio = new Data(2016, 10, 2);
        Data dataFim = new Data(2017, 6, 9);
        DefinirSessaoTematicaController instance
                = new DefinirSessaoTematicaController(this.empresa);
        instance.getListaEventosOrganizador();
        instance.selecionarEvento(0);
        boolean expResult = true;
        boolean result = instance.novaSessaoTematica(codigoUnico, descricao, 
                dataInicioSubmissao, dataFimSubmissao, dataInicioDistribuicao,
                dataFimRevisao, dataFimSubmissaoFinal, dataInicio, dataFim);
        assertEquals(expResult, result);
    }

    /**
     * Test of novoProponente method, of class DefinirSessaoTematicaController.
     */
    @Test
    public void testNovoProponente() {
        System.out.println("novoProponente");
        String codigoUnico = "#ALFA";
        String descricao = "Descrição";
        Data dataInicioSubmissao = new Data(2016, 6, 9);
        Data dataFimSubmissao = new Data(2016, 6, 21);
        Data dataInicioDistribuicao = new Data(2016, 7, 8);
        Data dataFimRevisao = new Data(2016, 8, 16);
        Data dataFimSubmissaoFinal = new Data(2016, 9, 11);
        Data dataInicio = new Data(2016, 10, 2);
        Data dataFim = new Data(2017, 6, 9);
        DefinirSessaoTematicaController instance
                = new DefinirSessaoTematicaController(this.empresa);
        instance.getListaEventosOrganizador();
        instance.selecionarEvento(0);
        instance.novaSessaoTematica(codigoUnico, descricao, dataInicioSubmissao,
                dataFimSubmissao, dataInicioDistribuicao, dataFimRevisao,
                dataFimSubmissaoFinal, dataInicio, dataFim);
        String id = "1140781@isep.ipp.pt";
        boolean expResult = true;
        boolean result = instance.novoProponente(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of validarSessaoTematica method, of class
     * DefinirSessaoTematicaController.
     */
    @Test
    public void testValidarSessaoTematica() {
        System.out.println("validarSessaoTematica");
        String codigoUnico = "#ALFA";
        String descricao = "Descrição";
        Data dataInicioSubmissao = new Data(2016, 6, 9);
        Data dataFimSubmissao = new Data(2016, 6, 21);
        Data dataInicioDistribuicao = new Data(2016, 7, 8);
        Data dataFimRevisao = new Data(2016, 8, 16);
        Data dataFimSubmissaoFinal = new Data(2016, 9, 11);
        Data dataInicio = new Data(2016, 10, 2);
        Data dataFim = new Data(2017, 6, 9);
        DefinirSessaoTematicaController instance
                = new DefinirSessaoTematicaController(this.empresa);
        instance.getListaEventosOrganizador();
        instance.selecionarEvento(0);
        instance.novaSessaoTematica(codigoUnico, descricao, dataInicioSubmissao,
                dataFimSubmissao, dataInicioDistribuicao, dataFimRevisao,
                dataFimSubmissaoFinal, dataInicio, dataFim);
        instance.novoProponente("1140781@isep.ipp.pt");
        boolean expResult = true;
        boolean result = instance.validarSessaoTematica();
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionarSessaoTematica method, of class
     * DefinirSessaoTematicaController.
     */
    @Test
    public void testAdicionarSessaoTematica() {
        System.out.println("adicionarSessaoTematica");
        String codigoUnico = "#ALFA";
        String descricao = "Descrição";
        Data dataInicioSubmissao = new Data(2016, 6, 9);
        Data dataFimSubmissao = new Data(2016, 6, 21);
        Data dataInicioDistribuicao = new Data(2016, 7, 8);
        Data dataFimRevisao = new Data(2016, 8, 16);
        Data dataFimSubmissaoFinal = new Data(2016, 9, 11);
        Data dataInicio = new Data(2016, 10, 2);
        Data dataFim = new Data(2017, 6, 9);
        DefinirSessaoTematicaController instance
                = new DefinirSessaoTematicaController(this.empresa);
        instance.getListaEventosOrganizador();
        instance.selecionarEvento(0);
        instance.novaSessaoTematica(codigoUnico, descricao, dataInicioSubmissao,
                dataFimSubmissao, dataInicioDistribuicao, dataFimRevisao,
                dataFimSubmissaoFinal, dataInicio, dataFim);
        instance.novoProponente("1140781@isep.ipp.pt");
        instance.validarSessaoTematica();
        boolean expResult = true;
        boolean result = instance.adicionarSessaoTematica();
        assertEquals(expResult, result);
    }

}
