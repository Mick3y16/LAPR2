package eventoscientificos.controllers;

import eventoscientificos.model.Empresa;
import eventoscientificos.model.Evento;
import eventoscientificos.model.Local;
import eventoscientificos.model.RegistoEventos;
import eventoscientificos.model.SessaoTematica;
import eventoscientificos.model.Submissao;
import eventoscientificos.model.Utilizador;
import eventoscientificos.model.state.evento.EventoEmSubmissaoCameraReadyState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmSubmissaoCameraReadyState;
import eventoscientificos.model.state.submissao.SubmissaoRemovidaState;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 *
 * @author G01
 */
public class ListarSubmissoesRetiradasControllerTest {

    private Empresa empresa;
    private Evento evento;
    private SessaoTematica sessaoTematica;
    private Submissao submissao;
    private Utilizador utilizador;
    private RegistoEventos registoEventos;

    public ListarSubmissoesRetiradasControllerTest() {
        this.utilizador = new Utilizador(
                "fatima", "ola@iml.com", "fafa", "1234");

        this.submissao = new Submissao();
        submissao.setEstado(new SubmissaoRemovidaState(submissao));
        
        this.sessaoTematica = new SessaoTematica(
                "#A9D24R",
                "LAPR2",
                new Data(2015, 5, 22),
                new Data(2018, 5, 28),
                new Data(2018, 6, 10),
                new Data(2018, 6, 20),
                new Data(2018, 6, 24),
                new Data(2018, 6, 28),
                new Data(2018, 6, 30));
        sessaoTematica.novoProponente(utilizador);
        sessaoTematica.setEstado(new SessaoTematicaEmSubmissaoCameraReadyState(sessaoTematica));
        sessaoTematica.getListaSubmissoes().adicionarSubmissao(submissao);
        
        this.evento = new Evento("titulo", "descricao", new Local("local"),
                new Data(2016, 6, 8), new Data(2016, 6, 20),
                new Data(2016, 7, 7), new Data(2016, 9, 10),
                new Data(2016, 9, 11), new Data(2016, 10, 1),
                new Data(2017, 6, 10));
        evento.novoOrganizador(utilizador);
        evento.setEstado(new EventoEmSubmissaoCameraReadyState(evento));
        evento.getListaSubmissoes().adicionarSubmissao(submissao);

        evento.getListaSessoesTematicas().adicionarSessaoTematica(sessaoTematica);
        
        this.registoEventos = new RegistoEventos();
        registoEventos.adicionarEvento(evento);
        
        this.empresa = new Empresa();
        empresa.setUtilizadorAutenticado(utilizador);
        empresa.getRegistoUtilizadores().adicionaUtilizador(utilizador);
        empresa.getRegistoEventos().adicionarEvento(evento);
        
    }

    /**
     * Teste do método
     * getListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente, da
     * classe ListarSubmissoesRetiradasController.
     */
    @Test
    public void testGetListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente() {
        System.out.println("getListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente");
        ListarSubmissoesRetiradasController instance = new ListarSubmissoesRetiradasController(empresa);
        empresa.getRegistoEventos().adicionarEvento(evento);
        boolean expResult = true;
        boolean result = instance.getListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método selecionarSubmissivel, da classe
     * ListarSubmissoesRetiradasController.
     */
    @Test
    public void testSelecionarSubmissivel() {
        System.out.println("selecionarSubmissivel");
        int indice = 0;
        ListarSubmissoesRetiradasController instance = new ListarSubmissoesRetiradasController(empresa);
        instance.getListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente();
        boolean expResult = true;
        boolean result = instance.selecionarSubmissivel(indice);
        assertEquals(expResult, result);
    }

}
