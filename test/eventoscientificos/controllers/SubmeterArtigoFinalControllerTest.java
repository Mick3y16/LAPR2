package eventoscientificos.controllers;

import eventoscientificos.model.Artigo;
import eventoscientificos.model.Autor;
import eventoscientificos.model.Empresa;
import eventoscientificos.model.Evento;
import eventoscientificos.model.InstituicaoAfiliacao;
import eventoscientificos.model.Local;
import eventoscientificos.model.RegistoEventos;
import eventoscientificos.model.Submissao;
import eventoscientificos.model.Utilizador;
import eventoscientificos.model.state.evento.EventoEmSubmissaoCameraReadyState;
import eventoscientificos.model.state.submissao.SubmissaoAceiteState;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * @author G01
 */
public class SubmeterArtigoFinalControllerTest {

    private Empresa empresa;
    private Utilizador utilizador;
    private RegistoEventos registoEventos;
    private Evento evento;
    private Submissao submissao;

    public SubmeterArtigoFinalControllerTest() {
        this.empresa = new Empresa();

        this.utilizador = new Utilizador(
                "Pedro", "1140781@isep.ipp.pt", "pedro", "1234");
        this.empresa.setUtilizadorAutenticado(utilizador);
        this.empresa.getRegistoUtilizadores().adicionaUtilizador(utilizador);
        this.registoEventos = this.empresa.getRegistoEventos();
        this.evento = new Evento("titulo", "descricao", new Local("local"),
                new Data(2016, 6, 8), new Data(2016, 6, 20),
                new Data(2016, 7, 7), new Data(2016, 9, 10),
                new Data(2016, 9, 11), new Data(2016, 10, 1),
                new Data(2017, 6, 10));
        this.evento.setEstado(new EventoEmSubmissaoCameraReadyState(evento));
        this.submissao = new Submissao();

        Artigo artigoInicial = submissao.novoArtigo();
        artigoInicial.setTitulo("titulo");
        artigoInicial.setResumo("resumo");
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("gato");
        palavrasChave.add("banho");
        artigoInicial.setPalavrasChave(palavrasChave);
        artigoInicial.getListaAutores().novoAutor(
                utilizador, new InstituicaoAfiliacao("ISEP"));
        artigoInicial.setFicheiro("wasdfg");
        submissao.adicionarArtigo(artigoInicial);

        evento.getListaSubmissoes().adicionarSubmissao(submissao);
        submissao.setEstado(new SubmissaoAceiteState(submissao));
        this.registoEventos.adicionarEvento(evento);
    }

    /**
     * Test of getListaSubmissiveisAceitarArtigoFinal method, of class
     * SubmeterArtigoFinalController.
     */
    @Test
    public void testGetListaSubmissiveisAceitarArtigoFinal() {
        System.out.println("getListaSubmissiveisAceitarArtigoFinal");
        SubmeterArtigoFinalController instance = new SubmeterArtigoFinalController(empresa);
        boolean expResult = true;
        boolean result = instance.getListaSubmissiveisAceitarArtigoFinal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaSubmissiveis method, of class
     * SubmeterArtigoFinalController.
     */
    @Test
    public void testGetListaSubmissiveis() {
        System.out.println("getListaSubmissiveis");
        SubmeterArtigoFinalController instance = new SubmeterArtigoFinalController(empresa);
        instance.getListaSubmissiveisAceitarArtigoFinal();
        int expResult = 1;
        int result = instance.getListaSubmissiveis().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of selecionarSubmissivel method, of class
     * SubmeterArtigoFinalController.
     */
    @Test
    public void testSelecionarSubmissivel() {
        System.out.println("selecionarSubmissivel");
        int indice = 0;
        SubmeterArtigoFinalController instance = new SubmeterArtigoFinalController(empresa);
        instance.getListaSubmissiveisAceitarArtigoFinal();
        instance.getListaSubmissiveis();
        boolean expResult = true;
        boolean result = instance.selecionarSubmissivel(indice);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaSubmissoes method, of class
     * SubmeterArtigoFinalController.
     */
    @Test
    public void testGetListaSubmissoes() {
        System.out.println("getListaSubmissoes");
        int indice = 0;
        SubmeterArtigoFinalController instance = new SubmeterArtigoFinalController(empresa);
        instance.getListaSubmissiveisAceitarArtigoFinal();
        instance.getListaSubmissiveis();
        instance.selecionarSubmissivel(indice);
        int expResult = 1;
        int result = instance.getListaSubmissoes().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of selecionarSubmissaoAceite method, of class
     * SubmeterArtigoFinalController.
     */
    @Test
    public void testSelecionarSubmissaoAceite() {
        System.out.println("selecionarSubmissaoAceite");
        int indice = 0;
        SubmeterArtigoFinalController instance = new SubmeterArtigoFinalController(empresa);
        instance.getListaSubmissiveisAceitarArtigoFinal();
        instance.getListaSubmissiveis();
        instance.selecionarSubmissivel(indice);
        instance.getListaSubmissoes();
        boolean expResult = true;
        boolean result = instance.selecionarSubmissaoAceite(indice);
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionarDadosArtigoFinal method, of class
     * SubmeterArtigoFinalController.
     */
    @Test
    public void testAdicionarDadosArtigoFinal() {
        System.out.println("adicionarDadosArtigoFinal");
        String titulo = "titulo123";
        String resumo = "resumo123";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("gato");
        palavrasChave.add("banho");
        int indice = 0;
        SubmeterArtigoFinalController instance = new SubmeterArtigoFinalController(empresa);
        instance.getListaSubmissiveisAceitarArtigoFinal();
        instance.getListaSubmissiveis();
        instance.selecionarSubmissivel(indice);
        instance.getListaSubmissoes();
        instance.selecionarSubmissaoAceite(indice);
        boolean expResult = true;
        boolean result = instance.adicionarDadosArtigoFinal(titulo, resumo, palavrasChave);
        assertEquals(expResult, result);
    }

    /**
     * Test of novoAutor method, of class SubmeterArtigoFinalController. //
     */
    @Test
    public void testNovoAutor() {
        System.out.println("novoAutor");
        String nome = "lllll";
        String email = "asdf@email.com";
        String instituicaoAfiliacao = "qqq";
        SubmeterArtigoFinalController instance = new SubmeterArtigoFinalController(empresa);
        instance.getListaSubmissiveisAceitarArtigoFinal();
        instance.getListaSubmissiveis();
        String titulo = "titulo123";
        String resumo = "resumo123";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("gato");
        palavrasChave.add("banho");
        int indice = 0;
        instance.selecionarSubmissivel(indice);
        instance.getListaSubmissoes();
        instance.selecionarSubmissaoAceite(indice);
        instance.adicionarDadosArtigoFinal(titulo, resumo, palavrasChave);
        boolean expResult = true;
        boolean result = instance.novoAutor(nome, email, instituicaoAfiliacao);
        assertEquals(expResult, result);
    }

    /**
     * Test of apagarAutor method, of class SubmeterArtigoFinalController.
     */
    @Test
    public void testApagarAutor() {
        System.out.println("apagarAutor");
        int indice = 0;
        String nome = "lllll";
        String email = "asdf@email.com";
        String instituicaoAfiliacao = "qqq";
        SubmeterArtigoFinalController instance = new SubmeterArtigoFinalController(empresa);
        instance.getListaSubmissiveisAceitarArtigoFinal();
        instance.getListaSubmissiveis();
        String titulo = "titulo123";
        String resumo = "resumo123";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("gato");
        palavrasChave.add("banho");
        instance.selecionarSubmissivel(indice);
        instance.getListaSubmissoes();
        instance.selecionarSubmissaoAceite(indice);
        instance.adicionarDadosArtigoFinal(titulo, resumo, palavrasChave);
        instance.novoAutor(nome, email, instituicaoAfiliacao);
        boolean expResult = false;
        boolean result = instance.apagarAutor(indice);
    }

    /**
     * Test of getListaAutoresRegistados method, of class
     * SubmeterArtigoFinalController.
     */
    @Test
    public void testGetListaAutoresRegistados() {
        System.out.println("getListaAutoresRegistados");
        SubmeterArtigoFinalController instance = new SubmeterArtigoFinalController(empresa);
        int indice = 0;
        String nome = "lllll";
        String email = "asdf@email.com";
        String instituicaoAfiliacao = "qqq";
        instance.getListaSubmissiveisAceitarArtigoFinal();
        instance.getListaSubmissiveis();
        String titulo = "titulo123";
        String resumo = "resumo123";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("gato");
        palavrasChave.add("banho");
        instance.selecionarSubmissivel(indice);
        instance.getListaSubmissoes();
        instance.selecionarSubmissaoAceite(indice);
        instance.adicionarDadosArtigoFinal(titulo, resumo, palavrasChave);
        instance.novoAutor(nome, email, instituicaoAfiliacao);
        instance.apagarAutor(indice);
        boolean expResult = true;
        boolean result = instance.getListaAutoresRegistados();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaAutores method, of class SubmeterArtigoFinalController.
     */
    @Test
    public void testGetModeloListaAutores() {
        System.out.println("getListaAutores");
        SubmeterArtigoFinalController instance = new SubmeterArtigoFinalController(empresa);
        int indice = 0;
        String nome = "lllll";
        String email = "asdf@email.com";
        String instituicaoAfiliacao = "qqq";
        instance.getListaSubmissiveisAceitarArtigoFinal();
        instance.getListaSubmissiveis();
        String titulo = "titulo123";
        String resumo = "resumo123";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("gato");
        palavrasChave.add("banho");
        instance.selecionarSubmissivel(indice);
        instance.getListaSubmissoes();
        instance.selecionarSubmissaoAceite(indice);
        instance.adicionarDadosArtigoFinal(titulo, resumo, palavrasChave);
        instance.novoAutor(nome, email, instituicaoAfiliacao);
        int expResult = 1;
        int result = instance.getModeloListaAutores().getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionarAutorCorrespondente method, of class
     * SubmeterArtigoFinalController.
     */
    @Test
    public void testAdicionarAutorCorrespondente() {
        System.out.println("adicionarAutorCorrespondente");
        int indice = 0;
        SubmeterArtigoFinalController instance = new SubmeterArtigoFinalController(empresa);
        String nome = "lllll";
        String email = "1140781@isep.ipp.pt";
        String instituicaoAfiliacao = "qqq";
        instance.getListaSubmissiveisAceitarArtigoFinal();
        String titulo = "titulo123";
        String resumo = "resumo123";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("gato");
        palavrasChave.add("banho");
        instance.selecionarSubmissivel(indice);
        instance.selecionarSubmissaoAceite(indice);
        instance.adicionarDadosArtigoFinal(titulo, resumo, palavrasChave);
        instance.novoAutor(nome, email, instituicaoAfiliacao);
        instance.getListaAutoresRegistados();
        boolean expResult = true;
        boolean result = instance.adicionarAutorCorrespondente(indice);
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionarFicheiroPDF method, of class
     * SubmeterArtigoFinalController.
     */
    @Test
    public void testAdicionarFicheiroPDF() {
        System.out.println("adicionarFicheiroPDF");
        String ficheiro = "c\\lapr2";
        SubmeterArtigoFinalController instance = new SubmeterArtigoFinalController(empresa);
        int indice = 0;
        String nome = "lllll";
        String email = "1140781@isep.ipp.pt";
        String instituicaoAfiliacao = "qqq";
        instance.getListaSubmissiveisAceitarArtigoFinal();
        String titulo = "titulo123";
        String resumo = "resumo123";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("gato");
        palavrasChave.add("banho");
        instance.selecionarSubmissivel(indice);
        instance.selecionarSubmissaoAceite(indice);
        instance.adicionarDadosArtigoFinal(titulo, resumo, palavrasChave);
        instance.novoAutor(nome, email, instituicaoAfiliacao);
        instance.getListaAutoresRegistados();
        boolean expResult = true;
        boolean result = instance.adicionarFicheiroPDF(ficheiro);
        assertEquals(expResult, result);
    }

    /**
     * Test of validarSubmissao method, of class SubmeterArtigoFinalController.
     */
    @Test
    public void testValidarSubmissao() {
        System.out.println("validarSubmissao");
        SubmeterArtigoFinalController instance = new SubmeterArtigoFinalController(empresa);
        int indice = 0;
        String nome = "lllll";
        String email = "1140781@isep.ipp.pt";
        String instituicaoAfiliacao = "qqq";
        String ficheiro = "c\\lapr2";
        String titulo = "olatudo bem?";
        String resumo = "tudo";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("gato");
        palavrasChave.add("banho");
        instance.getListaSubmissiveisAceitarArtigoFinal();
        instance.selecionarSubmissivel(indice);
        instance.selecionarSubmissaoAceite(indice);
        instance.adicionarDadosArtigoFinal(titulo, resumo, palavrasChave);
        instance.novoAutor(nome, email, instituicaoAfiliacao);
        instance.getListaAutoresRegistados();
        instance.adicionarAutorCorrespondente(indice);
        instance.adicionarFicheiroPDF(ficheiro);
        boolean expResult = true;
        boolean result = instance.validarSubmissao();
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionarSubmissao method, of class SubmeterArtigoFinalController.
     */
    @Test
    public void testAdicionarSubmissao() {
        System.out.println("adicionarSubmissao");
        SubmeterArtigoFinalController instance = new SubmeterArtigoFinalController(empresa);
       int indice = 0;
        String nome = "lllll";
        String email = "1140781@isep.ipp.pt";
        String instituicaoAfiliacao = "qqq";
        String ficheiro = "c\\lapr2";
        String titulo = "olatudo bem?";
        String resumo = "tudo";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("gato");
        palavrasChave.add("banho");
        instance.getListaSubmissiveisAceitarArtigoFinal();
        instance.selecionarSubmissivel(indice);
        instance.selecionarSubmissaoAceite(indice);
        instance.adicionarDadosArtigoFinal(titulo, resumo, palavrasChave);
        instance.novoAutor(nome, email, instituicaoAfiliacao);
        instance.getListaAutoresRegistados();
        instance.adicionarAutorCorrespondente(indice);
        instance.adicionarFicheiroPDF(ficheiro);
        boolean expResult = true;
        boolean result = instance.adicionarSubmissao();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getModeloListaAutoresRegistados method, of class
     * SubmeterArtigoFinalController.
     */
    @Test
    public void testGetModeloListaAutoresRegistados() {
        System.out.println("getModeloListaAutoresRegistados");
        SubmeterArtigoFinalController instance = new SubmeterArtigoFinalController(empresa);
        int indice = 0;
        String nome = "lllll";
        String email = "asdf@email.com";
        String instituicaoAfiliacao = "qqq";
        instance.getListaSubmissiveisAceitarArtigoFinal();
        instance.getListaSubmissiveis();
        String titulo = "titulo123";
        String resumo = "resumo123";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("gato");
        palavrasChave.add("banho");
        instance.selecionarSubmissivel(indice);
        instance.getListaSubmissoes();
        instance.selecionarSubmissaoAceite(indice);
        instance.adicionarDadosArtigoFinal(titulo, resumo, palavrasChave);
        instance.novoAutor(nome, email, instituicaoAfiliacao);
        DefaultComboBoxModel<Autor> expResult = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<Autor> result = instance.getModeloListaAutoresRegistados();
        assertEquals(expResult.getClass().getSimpleName(), result.getClass().getSimpleName());
    }

}
