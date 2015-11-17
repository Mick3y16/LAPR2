package eventoscientificos.controllers;

import eventoscientificos.model.Empresa;
import eventoscientificos.model.Evento;
import eventoscientificos.model.Local;
import eventoscientificos.model.SessaoTematica;
import eventoscientificos.model.Utilizador;
import eventoscientificos.model.state.evento.EventoEmSubmissaoState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmSubmissaoState;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * @author G01
 */
public class CarregarFicheiroControllerTest {

    private Empresa empresa;
    private Evento evento;

    public CarregarFicheiroControllerTest() {
        Empresa empresa = new Empresa();
        Evento evento = new Evento("titulo", "descricao", new Local("local"),
                new Data(2015, 6, 8), new Data(2016, 6, 20),
                new Data(2016, 7, 7), new Data(2016, 8, 15),
                new Data(2016, 9, 10), new Data(2016, 10, 1),
                new Data(2017, 6, 10));
        evento.setEstado(new EventoEmSubmissaoState(evento));
        empresa.getRegistoEventos().adicionarEvento(evento);
        SessaoTematica sessaoTematica = new SessaoTematica(
                "#A9D24R", "LAPR2", new Data(2015, 5, 22),
                new Data(2015, 5, 28), new Data(2015, 6, 10),
                new Data(2015, 6, 20), new Data(2015, 6, 24),
                new Data(2015, 6, 28), new Data(2015, 6, 30));
        sessaoTematica.setEstado(new SessaoTematicaEmSubmissaoState(sessaoTematica));
        evento.getListaSessoesTematicas().adicionarSessaoTematica(sessaoTematica);
        Utilizador utilizador
                = new Utilizador("Pedro", "1140781@isep.ipp.pt", "pedro", "12345");
        empresa.getRegistoUtilizadores().adicionaUtilizador(utilizador);
        this.empresa = empresa;
        this.evento = evento;
    }

    /**
     * Test of getListaEventosAceitarEventos method, of class
     * CarregarFicheiroController.
     */
    @Test
    public void testGetListaEventosAceitarEventos() {
        System.out.println("getListaEventosAceitarEventos");
        CarregarFicheiroController instance = new CarregarFicheiroController(empresa);
        instance.getListaEventosAceitarArtigos();
        int expResult = 1;
        int result = instance.getListaEventosAceitarEventos().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaEventosAceitarArtigos method, of class
     * CarregarFicheiroController.
     */
    @Test
    public void testGetListaEventosAceitarArtigos() {
        System.out.println("getListaEventosAceitarArtigos");
        CarregarFicheiroController instance = new CarregarFicheiroController(empresa);
        boolean expResult = true;
        boolean result = instance.getListaEventosAceitarArtigos();
        assertEquals(expResult, result);
    }

    /**
     * Test of selecionarEvento method, of class CarregarFicheiroController.
     */
    @Test
    public void testSelecionarEvento() {
        System.out.println("selecionarEvento");
        int indice = 0;
        CarregarFicheiroController instance = new CarregarFicheiroController(empresa);
        instance.getListaEventosAceitarArtigos();
        boolean expResult = true;
        boolean result = instance.selecionarEvento(indice);
        assertEquals(expResult, result);
    }

    /**
     * Test of submeterFicheiro method, of class CarregarFicheiroController.
     */
    @Test
    public void testSubmeterFicheiro() {
        System.out.println("submeterFicheiro");
        String ficheiro = "submissao.csv";
        CarregarFicheiroController instance = new CarregarFicheiroController(empresa);
        instance.getListaEventosAceitarArtigos();
        instance.selecionarEvento(0);
        boolean expResult = true;
        boolean result = instance.submeterFicheiro(ficheiro);
        assertEquals(expResult, result);
    }
}
