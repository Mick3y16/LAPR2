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
import eventoscientificos.model.state.evento.EventoEmSubmissaoState;
import eventoscientificos.model.state.submissao.SubmissaoCriadaState;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * @author G01
 */
public class SubmeterArtigoControllerTest {

    private Empresa empresa;
    private Evento evento;
    private Submissao submissao;
    private Utilizador utilizador;
    private RegistoEventos registoEventos;

    public SubmeterArtigoControllerTest() {
        this.empresa = new Empresa();

        this.utilizador = new Utilizador(
                "Pedro", "1140781@isep.ipp.pt", "pedro", "1234");
        Utilizador utilizador1 = new Utilizador(
                "Pedro123", "11111@isep.ipp.pt", "pedro123", "1234");
        this.empresa.setUtilizadorAutenticado(utilizador);
        this.empresa.getRegistoUtilizadores().adicionaUtilizador(utilizador1);
        this.registoEventos = this.empresa.getRegistoEventos();
        this.evento = new Evento("titulo", "descricao", new Local("local"),
                new Data(2016, 6, 8), new Data(2016, 6, 20),
                new Data(2016, 7, 7), new Data(2016, 9, 10),
                new Data(2016, 9, 11), new Data(2016, 10, 1),
                new Data(2017, 6, 10));
        this.evento.setEstado(new EventoEmSubmissaoState(evento));
        this.submissao = new Submissao();
        submissao.setEstado(new SubmissaoCriadaState(submissao));
        Artigo artigoInicial = submissao.novoArtigo();
        artigoInicial.setTitulo("titulo");
        artigoInicial.setResumo("resumo");
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("gato");
        palavrasChave.add("banho");
        artigoInicial.setPalavrasChave(palavrasChave);
        artigoInicial.getListaAutores().novoAutor(
                utilizador, new InstituicaoAfiliacao("ISEP"));
        artigoInicial.getListaAutores().novoAutor(
                utilizador1, new InstituicaoAfiliacao("ISEP"));
        artigoInicial.setFicheiro("wasdfg");
        submissao.adicionarArtigo(artigoInicial);
        evento.getListaSubmissoes().adicionarSubmissao(submissao);

        this.registoEventos.adicionarEvento(evento);
    }

    /**
     * Test of getListaSubmissiveis method, of class SubmeterArtigoController.
     */
    @Test
    public void testGetListaSubmissiveis() {
        System.out.println("getListaSubmissiveis");
        SubmeterArtigoController instance = new SubmeterArtigoController(this.empresa);
        instance.getListaSubmissiveisAceitarArtigo();
        int expResult = 1;
        int result = instance.getListaSubmissiveis().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getModeloLista method, of class SubmeterArtigoController.
     */
    @Test
    public void testGetModeloLista() {
        System.out.println("getModeloLista");
        SubmeterArtigoController instance = new SubmeterArtigoController(this.empresa);
        String expResult = "DefaultListModel";
        String result = instance.getModeloLista().getClass().getSimpleName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaAutores method, of class SubmeterArtigoController.
     */
    @Test
    public void testGetListaAutores() {
        System.out.println("getListaAutores");
        SubmeterArtigoController instance = new SubmeterArtigoController(this.empresa);
        String titulo = "titulo123";
        String resumo = "resumo123";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("gato");
        palavrasChave.add("banho");
        instance.getListaSubmissiveisAceitarArtigo();
        instance.selecionarSubmissivel(0);
        instance.adicionarDadosArtigo(titulo, resumo, palavrasChave);
        instance.novoAutor("Pedro123", "11111@isep.ipp.pt", new InstituicaoAfiliacao("ISEP"));
        instance.getListaAutoresRegistados();
        int expResult = 1;
        int result = instance.getListaAutores().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaSubmissiveisAceitarArtigo method, of class
     * SubmeterArtigoController.
     */
    @Test
    public void testGetListaSubmissiveisAceitarArtigo() {
        System.out.println("getListaSubmissiveisAceitarArtigo");
        SubmeterArtigoController instance = new SubmeterArtigoController(empresa);
        boolean expResult = true;
        boolean result = instance.getListaSubmissiveisAceitarArtigo();
        assertEquals(expResult, result);
    }

    /**
     * Test of selecionarSubmissivel method, of class SubmeterArtigoController.
     */
    @Test
    public void testSelecionarSubmissivel() {
        System.out.println("selecionarSubmissivel");
        int indice = 0;
        SubmeterArtigoController instance = new SubmeterArtigoController(empresa);
        instance.getListaSubmissiveisAceitarArtigo();
        instance.getListaSubmissiveis();
        boolean expResult = true;
        boolean result = instance.selecionarSubmissivel(indice);
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionarDadosArtigo method, of class SubmeterArtigoController.
     */
    @Test
    public void testAdicionarDadosArtigo() {
        System.out.println("adicionarDadosArtigo");
        String titulo = "titulo123";
        String resumo = "resumo123";
        int indice = 0;
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("gato");
        palavrasChave.add("banho");
        SubmeterArtigoController instance = new SubmeterArtigoController(empresa);
        instance.getListaSubmissiveisAceitarArtigo();
        instance.getListaSubmissiveis();
        instance.selecionarSubmissivel(indice);
        boolean expResult = true;
        boolean result = instance.adicionarDadosArtigo(titulo, resumo, palavrasChave);
        assertEquals(expResult, result);
    }

    /**
     * Test of novoAutor method, of class SubmeterArtigoController.
     */
    @Test
    public void testNovoAutor() {
        System.out.println("novoAutor");
        String nome = "lllll";
        String email = "asdf@email.com";
        InstituicaoAfiliacao instituicaoAfiliacao = new InstituicaoAfiliacao("ISEP");
        SubmeterArtigoController instance = new SubmeterArtigoController(empresa);
        instance.getListaSubmissiveisAceitarArtigo();
        instance.getListaSubmissiveis();
        String titulo = "titulo123";
        String resumo = "resumo123";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("gato");
        palavrasChave.add("banho");
        int indice = 0;
        instance.selecionarSubmissivel(indice);
        instance.adicionarDadosArtigo(titulo, resumo, palavrasChave);
        boolean expResult = true;
        boolean result = instance.novoAutor(nome, email, instituicaoAfiliacao);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaAutoresRegistados method, of class
     * SubmeterArtigoController.
     */
    @Test
    public void testGetListaAutoresRegistados() {
        System.out.println("getListaAutoresRegistados");
        SubmeterArtigoController instance = new SubmeterArtigoController(empresa);
        instance.getListaSubmissiveisAceitarArtigo();
        instance.selecionarSubmissivel(0);
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("gato");
        palavrasChave.add("banho");
        instance.adicionarDadosArtigo("titulo111", "resumo111", palavrasChave);
        instance.novoAutor("su", "su@pt.pt", new InstituicaoAfiliacao("ISEP"));
        boolean expResult = true;
        boolean result = instance.getListaAutoresRegistados();
        assertEquals(expResult, result);

    }

    /**
     * Test of adicionarAutorCorrespondente method, of class
     * SubmeterArtigoController.
     */
    @Test
    public void testAdicionarAutorCorrespondente() {
        System.out.println("adicionarAutorCorrespondente");
        SubmeterArtigoController instance = new SubmeterArtigoController(empresa);
        String nome = "bea";
        String email = "bea@isep.ipp.pt";
        InstituicaoAfiliacao instituicaoAfiliacao = new InstituicaoAfiliacao("ISEP");
        instance.getListaSubmissiveisAceitarArtigo();
        instance.selecionarSubmissivel(0);
        String titulo = "titulo123";
        String resumo = "resumo123";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("gato");
        palavrasChave.add("banho");
        instance.adicionarDadosArtigo(titulo, resumo, palavrasChave);
        instance.novoAutor("Pedro123", "11111@isep.ipp.pt", new InstituicaoAfiliacao("ISEP"));
        instance.getListaAutoresRegistados();
        boolean expResult = true;
        boolean result = instance.adicionarAutorCorrespondente(0);
        assertEquals(expResult, result);

    }

    /**
     * Test of adicionarFicheiroPDF method, of class SubmeterArtigoController.
     */
    @Test
    public void testAdicionarFicheiroPDF() {
        System.out.println("adicionarFicheiroPDF");
        String ficheiro = "c\\lapr2";
        SubmeterArtigoController instance = new SubmeterArtigoController(empresa);
        int indice = 0;
        String titulo = "titulo123";
        String resumo = "resumo123";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("gato");
        palavrasChave.add("banho");
        instance.getListaSubmissiveisAceitarArtigo();
        instance.selecionarSubmissivel(0);
        instance.adicionarDadosArtigo(titulo, resumo, palavrasChave);
        instance.novoAutor("Pedro123", "11111@isep.ipp.pt", new InstituicaoAfiliacao("ISEP"));
        instance.getListaAutoresRegistados();
        boolean expResult = true;
        boolean result = instance.adicionarFicheiroPDF(ficheiro);
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionarSubmissao method, of class SubmeterArtigoController.
     */
    @Test
    public void testAdicionarSubmissao() {
        System.out.println("adicionarSubmissao");
        SubmeterArtigoController instance = new SubmeterArtigoController(empresa);
        int indice = 0;
        String ficheiro = "c\\lapr2";
        String titulo = "olatudo bem?";
        String resumo = "tudo";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("gato");
        palavrasChave.add("banho");
        instance.getListaSubmissiveisAceitarArtigo();
        instance.selecionarSubmissivel(indice);
        instance.adicionarDadosArtigo(titulo, resumo, palavrasChave);
        instance.novoAutor("Pedro123", "11111@isep.ipp.pt", new InstituicaoAfiliacao("ISEP"));
        instance.getListaAutoresRegistados();
        instance.adicionarAutorCorrespondente(indice);
        instance.adicionarFicheiroPDF(ficheiro);
        boolean expResult = true;
        boolean result = instance.adicionarSubmissao();
        assertEquals(expResult, result);
    }

    /**
     * Test of validarSubmissao method, of class SubmeterArtigoController.
     */
    @Test
    public void testValidarSubmissao() {
        System.out.println("validarSubmissao");
        SubmeterArtigoController instance = new SubmeterArtigoController(empresa);
        int indice = 0;
        String ficheiro = "c\\lapr22";
        String titulo = "dxjis?";
        String resumo = "tudo";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("gato");
        palavrasChave.add("banho");
        instance.getListaSubmissiveisAceitarArtigo();
        instance.selecionarSubmissivel(indice);
        instance.adicionarDadosArtigo(titulo, resumo, palavrasChave);
        instance.novoAutor("Pedro123", "11111@isep.ipp.pt", new InstituicaoAfiliacao("ISEP"));
        instance.getListaAutoresRegistados();
        instance.adicionarAutorCorrespondente(indice);
        instance.adicionarFicheiroPDF(ficheiro);
        boolean expResult = true;
        boolean result = instance.validarSubmissao();
        assertEquals(expResult, result);
    }
}
