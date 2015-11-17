package eventoscientificos.controllers;

import eventoscientificos.model.Empresa;
import eventoscientificos.model.Evento;
import eventoscientificos.model.Local;
import eventoscientificos.model.RegistoEventos;
import eventoscientificos.model.RegistoUtilizadores;
import eventoscientificos.model.Utilizador;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * @author G01
 */
public class CriarEventoControllerTest {

    private Evento evento;
    private Empresa empresa;
    private RegistoEventos registoEventos;
    private RegistoUtilizadores registoUtilizadores;

    public CriarEventoControllerTest() {
        this.evento = new Evento("titulo", "descricao", new Local("local"),
                new Data(2017, 6, 8), new Data(2017, 6, 20),
                new Data(2017, 7, 7), new Data(2017, 8, 7),
                new Data(2017, 9, 10), new Data(2017, 10, 1),
                new Data(2017, 12, 10));

        this.empresa = new Empresa();
        this.registoEventos = this.empresa.getRegistoEventos();
        this.registoUtilizadores = this.empresa.getRegistoUtilizadores();
        Utilizador utilizador = this.registoUtilizadores.novoUtilizador(
                "beatriz", "1140587@isep.ipp.pt", "beatriz", "1234");
        this.registoUtilizadores.adicionaUtilizador(utilizador);
    }

    /**
     * Teste do método novoEvento, da classe CriarEventoController.
     */
    @Test
    public void testNovoEvento() {
        System.out.println("novoEvento");
        String titulo = "sem titulo";
        String descricao = "sem descricao";
        Local local = new Local("local");
        Data dataInicioSubmissao = new Data(2016, 6, 8);
        Data dataFimSubmissao = new Data(2016, 6, 20);
        Data dataInicioDistribuicao = new Data(2016, 7, 30);
        Data dataFimRevisao = new Data(2016, 8, 15);
        Data dataFimSubmissaoCameraReady = new Data(2016, 8, 30);
        Data dataInicio = new Data(2016, 10, 9);
        Data dataFim = new Data(2017, 6, 10);
        CriarEventoController instance = new CriarEventoController(this.empresa);
        boolean expResult = true;
        boolean result = instance.novoEvento(titulo, descricao, local,
                dataInicioSubmissao, dataFimSubmissao, dataInicioDistribuicao,
                dataFimRevisao, dataFimSubmissaoCameraReady, dataInicio, dataFim);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método novoOrganizador, da classe CriarEventoController.
     */
    @Test
    public void testNovoOrganizador() {
        System.out.println("novoOrganizador");
        String titulo = "sem titulo";
        String descricao = "sem descricao";
        Local local = new Local("local");
        Data dataInicioSubmissao = new Data(2016, 6, 8);
        Data dataFimSubmissao = new Data(2016, 6, 20);
        Data dataInicioDistribuicao = new Data(2016, 7, 30);
        Data dataFimRevisao = new Data(2016, 8, 15);
        Data dataFimSubmissaoCameraReady = new Data(2016, 8, 30);
        Data dataInicio = new Data(2016, 10, 9);
        Data dataFim = new Data(2017, 6, 10);
        CriarEventoController instance = new CriarEventoController(this.empresa);
        instance.novoEvento(titulo, descricao, local, dataInicioSubmissao, dataFimSubmissao, dataInicioDistribuicao, dataFimRevisao, dataFimSubmissaoCameraReady, dataInicio, dataFim);
        String id = "1140587@isep.ipp.pt";
        boolean expResult = true;
        boolean result = instance.novoOrganizador(id);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarEvento, da classe CriarEventoController.
     */
    @Test
    public void testValidarEvento() {
        System.out.println("validarEvento");
        String titulo = "sem titulo";
        String descricao = "sem descricao";
        Local local = new Local("local");
        Data dataInicioSubmissao = new Data(2016, 6, 8);
        Data dataFimSubmissao = new Data(2016, 6, 20);
        Data dataInicioDistribuicao = new Data(2016, 7, 30);
        Data dataFimRevisao = new Data(2016, 8, 15);
        Data dataFimSubmissaoCameraReady = new Data(2016, 8, 30);
        Data dataInicio = new Data(2016, 10, 9);
        Data dataFim = new Data(2017, 6, 10);
        CriarEventoController instance = new CriarEventoController(this.empresa);
        instance.novoEvento(titulo, descricao, local, dataInicioSubmissao, dataFimSubmissao, dataInicioDistribuicao, dataFimRevisao, dataFimSubmissaoCameraReady, dataInicio, dataFim);
        instance.novoOrganizador("1140587@isep.ipp.pt");
        boolean expResult = true;
        boolean result = instance.validarEvento();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validarEvento, da classe CriarEventoController.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidarEventoDadosInvalidos() {
        System.out.println("validarEvento");
        CriarEventoController instance = new CriarEventoController(this.empresa);
        Evento evento = new Evento("", "descricao", new Local("local"),
                new Data(2017, 6, 8), new Data(2017, 6, 20),
                new Data(2017, 7, 7), new Data(2017, 8, 7),
                new Data(2017, 9, 10), new Data(2017, 10, 1),
                new Data(2017, 12, 10));;
        boolean expResult = true;
        boolean result = this.evento.validarEvento();
    }

    /**
     * Teste do método validarEvento, da classe CriarEventoController.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidarEventoExiste() {
        System.out.println("validarEvento");
        String titulo = "sem titulo";
        String descricao = "sem descricao";
        Local local = new Local("local");
        Data dataInicioSubmissao = new Data(2016, 6, 8);
        Data dataFimSubmissao = new Data(2016, 6, 20);
        Data dataInicioDistribuicao = new Data(2016, 7, 30);
        Data dataFimRevisao = new Data(2016, 8, 15);
        Data dataFimSubmissaoCameraReady = new Data(2016, 8, 30);
        Data dataInicio = new Data(2016, 10, 9);
        Data dataFim = new Data(2017, 6, 10);
        CriarEventoController instance = new CriarEventoController(this.empresa);
        Evento evento = this.evento;
        this.registoEventos.adicionarEvento(evento);
        instance.novoEvento(titulo, descricao, local, dataInicioSubmissao, dataFimSubmissao, dataInicioDistribuicao, dataFimRevisao, dataFimSubmissaoCameraReady, dataInicio, dataFim);
        instance.validarEvento();
    }

    /**
     * Teste do método adicionarEvento, da classe CriarEventoController.
     */
    @Test
    public void testAdicionarEvento() {
        System.out.println("adicionarEvento");
        Evento evento = this.evento;
        CriarEventoController instance = new CriarEventoController(this.empresa);
        String titulo = "sem titulo";
        String descricao = "sem descricao";
        Local local = new Local("local");
        Data dataInicioSubmissao = new Data(2016, 6, 8);
        Data dataFimSubmissao = new Data(2016, 6, 20);
        Data dataInicioDistribuicao = new Data(2016, 7, 30);
        Data dataFimRevisao = new Data(2016, 8, 15);
        Data dataFimSubmissaoCameraReady = new Data(2016, 8, 30);
        Data dataInicio = new Data(2016, 10, 9);
        Data dataFim = new Data(2017, 6, 10);
        instance.novoEvento(titulo, descricao, local, dataInicioSubmissao, dataFimSubmissao, dataInicioDistribuicao, dataFimRevisao, dataFimSubmissaoCameraReady, dataInicio, dataFim);
        boolean expResult = true;
        boolean result = instance.adicionarEvento();
        assertEquals(expResult, result);
    }

}
