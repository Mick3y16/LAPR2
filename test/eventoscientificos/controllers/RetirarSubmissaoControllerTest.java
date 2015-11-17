/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos.controllers;

import eventoscientificos.model.Artigo;
import eventoscientificos.model.CP;
import eventoscientificos.model.Empresa;
import eventoscientificos.model.Evento;
import eventoscientificos.model.InstituicaoAfiliacao;
import eventoscientificos.model.Licitacao;
import eventoscientificos.model.Local;
import eventoscientificos.model.Revisor;
import eventoscientificos.model.Submissao;
import eventoscientificos.model.Utilizador;
import eventoscientificos.model.state.evento.EventoEmLicitacaoState;
import eventoscientificos.model.state.evento.EventoEmSubmissaoState;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * Testa a classe RetirarSubmissaoController.
 *
 * @author G01
 */
public class RetirarSubmissaoControllerTest {

    private Empresa empresa;
    private Evento evento;
    private Submissao submissao;
    private Utilizador utilizador;

    public RetirarSubmissaoControllerTest() {
        this.utilizador = new Utilizador(
                            "fatima", "ola@iml.com", "fafa", "1234");

        this.empresa = new Empresa();
        this.empresa.setUtilizadorAutenticado(utilizador);
        this.evento = new Evento("titulo", "descricao", new Local("local"),
                            new Data(2016, 6, 8), new Data(2016, 6, 20),
                            new Data(2016, 7, 7), new Data(2016, 9, 10),
                            new Data(2016, 9, 11), new Data(2016, 10, 1),
                            new Data(2017, 6, 10));

        this.evento.setEstado(new EventoEmSubmissaoState(evento));

        Artigo artigoInicial = new Artigo();
        artigoInicial.getListaAutores().novoAutor(utilizador, new InstituicaoAfiliacao("Matosinhos"));
        Artigo artigoFinal = new Artigo();
        this.submissao = new Submissao();
        submissao.setArtigoInicial(artigoInicial);
        submissao.setArtigoFinal(artigoFinal);
        this.evento.getListaSubmissoes().adicionarSubmissao(submissao);
        this.empresa.getRegistoEventos().adicionarEvento(evento);

    }

    /**
     * Test of getListaSubmissiveisComArtigosUtilizadorParaRemover method, of
     * class RetirarSubmissaoController.
     */
    @Test
    public void testGetListaSubmissiveisComArtigosUtilizadorParaRemover() {
        System.out.println("getListaSubmissiveisComArtigosUtilizadorParaRemover");
        RetirarSubmissaoController instance = new RetirarSubmissaoController(this.empresa);
        boolean expResult = true;
        boolean result = instance.getListaSubmissiveisComArtigosUtilizadorParaRemover();
        assertEquals(expResult, result);
    }

    /**
     * Test of selecionarSubmissivel method, of class
     * RetirarSubmissaoController.
     */
    @Test
    public void testSelecionarSubmissivel() {
        System.out.println("selecionarSubmissivel");
        int indice = 0;
        RetirarSubmissaoController instance = new RetirarSubmissaoController(this.empresa);
        boolean expResult = true;
        instance.getListaSubmissiveisComArtigosUtilizadorParaRemover();
        boolean result = instance.selecionarSubmissivel(indice);
        assertEquals(expResult, result);
    }

    /**
     * Test of selecionaSubmissao method, of class RetirarSubmissaoController.
     */
    @Test
    public void testSelecionaSubmissao() {
        System.out.println("selecionaSubmissao");
        int indice = 0;
        RetirarSubmissaoController instance = new RetirarSubmissaoController(empresa);
        boolean expResult = true;
        instance.getListaSubmissiveisComArtigosUtilizadorParaRemover();
        instance.selecionarSubmissivel(indice);
        boolean result = instance.selecionaSubmissao(indice);
        assertEquals(expResult, result);
    }

    /**
     * Test of removerSubmissao method, of class RetirarSubmissaoController.
     */
    @Test
    public void testRemoverSubmissao() {
        System.out.println("removerSubmissao");
        int indice = 0;
        RetirarSubmissaoController instance = new RetirarSubmissaoController(this.empresa);
        boolean expResult = true;
        instance.getListaSubmissiveisComArtigosUtilizadorParaRemover();
        instance.selecionarSubmissivel(indice);
        instance.selecionaSubmissao(indice);
        boolean result = instance.removerSubmissao();
        assertEquals(expResult, result);
    }

}
