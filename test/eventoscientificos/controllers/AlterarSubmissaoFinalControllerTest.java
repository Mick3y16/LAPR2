package eventoscientificos.controllers;

import eventoscientificos.model.Artigo;
import eventoscientificos.model.Autor;
import eventoscientificos.model.AutorCorrespondente;
import eventoscientificos.model.Empresa;
import eventoscientificos.model.Evento;
import eventoscientificos.model.InstituicaoAfiliacao;
import eventoscientificos.model.Local;
import eventoscientificos.model.RegistoEventos;
import eventoscientificos.model.Submissao;
import eventoscientificos.model.Utilizador;
import eventoscientificos.model.state.evento.EventoEmSubmissaoCameraReadyState;
import eventoscientificos.model.state.submissao.SubmissaoEmCameraReadyState;
import eventoscientificos.model.state.submissao.SubmissaoEmSubmissaoState;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * @author G01
 */
public class AlterarSubmissaoFinalControllerTest {

    private Empresa empresa;
    private Evento evento;
    private Submissao submissao;
    private Utilizador utilizador;
    private RegistoEventos registoEventos;

    public AlterarSubmissaoFinalControllerTest() {
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
        this.evento.setEstado(new EventoEmSubmissaoCameraReadyState(evento));
        this.submissao = new Submissao();
        submissao.setEstado(new SubmissaoEmCameraReadyState(submissao));
        Artigo artigoFinal = submissao.novoArtigo();
        artigoFinal.setTitulo("titulo");
        artigoFinal.setResumo("resumo");
        artigoFinal.setFicheiro("wasdfg");
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("gato");
        palavrasChave.add("banho");
        artigoFinal.setPalavrasChave(palavrasChave);
        artigoFinal.getListaAutores().novoAutor(
                utilizador, new InstituicaoAfiliacao("ISEP"));
        artigoFinal.getListaAutores().novoAutor(
                utilizador1, new InstituicaoAfiliacao("ISEP"));
        artigoFinal.setAutorCorrespondente(new AutorCorrespondente(utilizador, new InstituicaoAfiliacao("ISEP")));
        artigoFinal.setDataSubmissao(Data.dataAtual());
        artigoFinal.setAutorSubmissor(new Autor(utilizador, new InstituicaoAfiliacao("ISEP")));
        
        submissao.setEstado(new SubmissaoEmSubmissaoState(submissao));
        submissao.adicionarArtigo(artigoFinal);
        submissao.setEstado(new SubmissaoEmCameraReadyState(submissao));
        submissao.adicionarArtigo(artigoFinal);
        evento.getListaSubmissoes().adicionarSubmissao(submissao);

        this.registoEventos.adicionarEvento(evento);
    }

    /**
     * Test of getListaSubmissiveis method, of class
     * AlterarSubmissaoFinalController.
     */
    @Test
    public void testGetListaSubmissiveis() {
        System.out.println("getListaSubmissiveis");
        AlterarSubmissaoFinalController instance
                = new AlterarSubmissaoFinalController(empresa);
        instance.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador();
        int expResult = 1;
        int result = instance.getListaSubmissiveis().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaSubmissoes method, of class
     * AlterarSubmissaoFinalController.
     */
    @Test
    public void testGetListaSubmissoes() {
        System.out.println("getListaSubmissoes");
        AlterarSubmissaoFinalController instance
                = new AlterarSubmissaoFinalController(empresa);
        instance.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador();
        instance.selecionarSubmissivel(0);
        int expResult = 1;
        int result = instance.getListaSubmissoes().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getArtigoTitulo method, of class AlterarSubmissaoController.
     */
    @Test
    public void testGetArtigoTitulo() {
        System.out.println("getArtigoTitulo");
        AlterarSubmissaoFinalController instance
                = new AlterarSubmissaoFinalController(empresa);
        instance.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador();
        instance.selecionarSubmissivel(0);
        instance.selecionarSubmissao(0);
        String expResult = "titulo";
        String result = instance.getArtigoTitulo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getArtigoResumo method, of class AlterarSubmissaoController.
     */
    @Test
    public void testGetArtigoResumo() {
        System.out.println("getArtigoResumo");
        AlterarSubmissaoFinalController instance
                = new AlterarSubmissaoFinalController(empresa);
        instance.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador();
        instance.selecionarSubmissivel(0);
        instance.selecionarSubmissao(0);
        instance.getArtigoTitulo();
        String expResult = "resumo";
        String result = instance.getArtigoResumo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getArtigoPalavrasChave method, of class
     * AlterarSubmissaoController.
     */
    @Test
    public void testGetArtigoPalavrasChave() {
        System.out.println("getArtigoPalavrasChave");
        AlterarSubmissaoFinalController instance
                = new AlterarSubmissaoFinalController(empresa);
        instance.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador();
        instance.selecionarSubmissivel(0);
        instance.selecionarSubmissao(0);
        instance.getArtigoTitulo();
        instance.getArtigoTitulo();
        instance.getArtigoResumo();
        List<String> expResult = new ArrayList<>();
        expResult.add("gato");
        expResult.add("banho");
        List<String> result = instance.getArtigoPalavrasChave();
        assertEquals(expResult, result);

    }

    /**
     * Test of getModeloListaAutores method, of class
     * AlterarSubmissaoController.
     */
    @Test
    public void testGetModeloListaAutores() {
        System.out.println("getModeloListaAutores");
        AlterarSubmissaoFinalController instance
                = new AlterarSubmissaoFinalController(empresa);
        instance.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador();
        instance.selecionarSubmissivel(0);
        instance.selecionarSubmissao(0);
        String expResult = "ModeloListaAutores";
        String result = instance.getModeloListaAutores().getClass().getSimpleName();
        instance.getModeloListaAutores();
    }

    /**
     * Test of getArtigoFicheiro method, of class AlterarSubmissaoController.
     */
    @Test
    public void testGetArtigoFicheiro() {
        System.out.println("getArtigoFicheiro");
        AlterarSubmissaoFinalController instance
                = new AlterarSubmissaoFinalController(empresa);
        instance.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador();
        instance.selecionarSubmissivel(0);
        instance.selecionarSubmissao(0);
        instance.getListaAutoresRegistados();
        String expResult = "wasdfg";
        String result = instance.getArtigoFicheiro();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador method,
     * of class AlterarSubmissaoController.
     */
    @Test
    public void testGetListaSubmissiveisAceitarArtigoComSubmissaoUtilizador() {
        System.out.println("getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador");
        AlterarSubmissaoFinalController instance
                = new AlterarSubmissaoFinalController(empresa);
        boolean expResult = true;
        boolean result = instance.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador();
        assertEquals(expResult, result);
    }

    /**
     * Test of selecionarSubmissivel method, of class
     * AlterarSubmissaoController.
     */
    @Test
    public void testSelecionarSubmissivel() {
        System.out.println("selecionarSubmissivel");
        int indice = 0;
        AlterarSubmissaoFinalController instance
                = new AlterarSubmissaoFinalController(empresa);
        instance.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador();
        boolean expResult = true;
        boolean result = instance.selecionarSubmissivel(indice);
        assertEquals(expResult, result);
    }

    /**
     * Test of selecionarSubmissao method, of class AlterarSubmissaoController.
     */
    @Test
    public void testSelecionarSubmissao() {
        System.out.println("selecionarSubmissao");
        int indice = 0;
        AlterarSubmissaoFinalController instance
                = new AlterarSubmissaoFinalController(empresa);
        instance.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador();
        instance.selecionarSubmissivel(indice);
        boolean expResult = true;
        boolean result = instance.selecionarSubmissao(indice);
        assertEquals(expResult, result);
    }

    /**
     * Test of alterarDados method, of class AlterarSubmissaoController.
     */
    @Test
    public void testAlterarDados() {
        System.out.println("alterarDados");
        int indice = 0;
        String titulo = "titulo1";
        String resumo = "resumo1";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("bolachas");
        AlterarSubmissaoFinalController instance
                = new AlterarSubmissaoFinalController(empresa);
        instance.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador();
        instance.selecionarSubmissivel(indice);
        instance.selecionarSubmissao(indice);
        instance.alterarDados(titulo, resumo, palavrasChave);
    }

    /**
     * Test of apagarAutor method, of class AlterarSubmissaoController.
     */
    @Test
    public void testApagarAutor() {
        System.out.println("apagarAutor");
        int indice = 0;
        AlterarSubmissaoFinalController instance
                = new AlterarSubmissaoFinalController(empresa);
        String nome = "beatriz12";
        String email = "beatriz12@hotmail.com";
        String instituicaoAfiliacao = "WWE";
        String titulo = "titulo1";
        String resumo = "resumo1";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("bolachas");
        instance.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador();
        instance.selecionarSubmissivel(indice);
        instance.selecionarSubmissao(indice);
        instance.alterarDados(titulo, resumo, palavrasChave);
        int indiceApagar = 1;
        boolean expResult = true;
        boolean result = instance.apagarAutor(indiceApagar);
        assertEquals(expResult, result);
    }

    /**
     * Test of novoAutor method, of class AlterarSubmissaoController.
     */
    @Test
    public void testNovoAutor() {
        System.out.println("novoAutor");
        int indice = 0;
        String nome = "titulo";
        String email = "email@mol.pt";
        String instituicaoAfiliacao = "QQQ";
        AlterarSubmissaoFinalController instance
                = new AlterarSubmissaoFinalController(empresa);
        String nome1 = "beatriz12";
        String email1 = "beatriz12@hotmail.com";
        String instituicaoAfiliacao1 = "WWE";
        String titulo = "titulo1";
        String resumo = "resumo1";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("bolachas");
        instance.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador();
        instance.selecionarSubmissivel(indice);
        instance.selecionarSubmissao(indice);
        instance.alterarDados(titulo, resumo, palavrasChave);
        boolean expResult = true;
        boolean result = instance.novoAutor(nome, email, instituicaoAfiliacao);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaAutoresRegistados method, of class
     * AlterarSubmissaoController.
     */
    @Test
    public void testGetListaAutoresRegistados() {
        System.out.println("getListaAutoresRegistados");
        AlterarSubmissaoFinalController instance
                = new AlterarSubmissaoFinalController(empresa);
        int indice = 0;
        String nome = "titulo";
        String email = "email@mol.pt";
        String instituicaoAfiliacao = "QQQ";
        String nome1 = "beatriz12";
        String email1 = "beatriz12@hotmail.com";
        String instituicaoAfiliacao1 = "WWE";
        String titulo = "titulo1";
        String resumo = "resumo1";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("bolachas");
        instance.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador();
        instance.selecionarSubmissivel(indice);
        instance.selecionarSubmissao(indice);
        instance.alterarDados(titulo, resumo, palavrasChave);
        instance.novoAutor(nome, email, instituicaoAfiliacao);
        boolean expResult = true;
        boolean result = instance.getListaAutoresRegistados();
        assertEquals(expResult, result);
    }

    /**
     * Test of alterarAutorCorrespondente method, of class
     * AlterarSubmissaoController.
     */
    @Test
    public void testAlterarAutorCorrespondente() {
        System.out.println("alterarAutorCorrespondente");
        int indice = 0;
        AlterarSubmissaoFinalController instance
                = new AlterarSubmissaoFinalController(empresa);
        String nome = "titulo";
        String email = "email@mol.pt";
        String instituicaoAfiliacao = "QQQ";
        String nome1 = "beatriz12";
        String email1 = "beatriz12@hotmail.com";
        String instituicaoAfiliacao1 = "WWE";
        String titulo = "titulo1";
        String resumo = "resumo1";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("bolachas");
        instance.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador();
        instance.selecionarSubmissivel(indice);
        instance.selecionarSubmissao(indice);
        instance.alterarDados(titulo, resumo, palavrasChave);
        instance.novoAutor(nome, email, instituicaoAfiliacao);
        instance.getListaAutoresRegistados();
        boolean expResult = true;
        boolean result = instance.alterarAutorCorrespondente(indice);
        assertEquals(expResult, result);
    }

    /**
     * Test of alterarFicheiroPDF method, of class AlterarSubmissaoController.
     */
    @Test
    public void testAlterarFicheiroPDF() {
        System.out.println("alterarFicheiroPDF");
        String ficheiro = "C:\\Users\\Utilizador\\Downloads\\BTNext";
        AlterarSubmissaoFinalController instance
                = new AlterarSubmissaoFinalController(empresa);
        int indice = 0;
        String nome = "titulo";
        String email = "email@mol.pt";
        String instituicaoAfiliacao = "QQQ";
        String nome1 = "beatriz12";
        String email1 = "beatriz12@hotmail.com";
        String instituicaoAfiliacao1 = "WWE";
        String titulo = "titulo1";
        String resumo = "resumo1";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("bolachas");
        instance.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador();
        instance.selecionarSubmissivel(indice);
        instance.selecionarSubmissao(indice);
        instance.alterarDados(titulo, resumo, palavrasChave);
        instance.novoAutor(nome, email, instituicaoAfiliacao);
        instance.getListaAutoresRegistados();
        instance.alterarAutorCorrespondente(indice);
        boolean expResult = true;
        boolean result = instance.alterarFicheiroPDF(ficheiro);
        assertEquals(expResult, result);
    }

    /**
     * Test of validarSubmissao method, of class AlterarSubmissaoController.
     */
    @Test
    public void testValidarSubmissao() {
        System.out.println("validarSubmissao");
        AlterarSubmissaoFinalController instance
                = new AlterarSubmissaoFinalController(empresa);
        int indice = 0;
        String nome = "titulo";
        String email = "email@mol.pt";
        String instituicaoAfiliacao = "QQQ";
        String nome1 = "beatriz12";
        String email1 = "beatriz12@hotmail.com";
        String instituicaoAfiliacao1 = "WWE";
        String titulo = "titulo1";
        String resumo = "resumo1";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("bolachas");
        String ficheiro = "C:\\Users\\Utilizador\\Downloads\\BTNext";
        instance.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador();
        instance.selecionarSubmissivel(indice);
        instance.selecionarSubmissao(indice);
        instance.alterarDados(titulo, resumo, palavrasChave);
        instance.novoAutor(nome, email, instituicaoAfiliacao);
        instance.getListaAutoresRegistados();
        instance.alterarAutorCorrespondente(indice);
        instance.alterarFicheiroPDF(ficheiro);
        boolean expResult = true;
        boolean result = instance.validarSubmissao();
        assertEquals(expResult, result);
    }

    /**
     * Test of alterarSubmissao method, of class AlterarSubmissaoController.
     */
    @Test
    public void testAlterarSubmissao() {
        System.out.println("alterarSubmissao");
        AlterarSubmissaoFinalController instance
                = new AlterarSubmissaoFinalController(empresa);
        int indice = 0;
        String nome = "titulo";
        String email = "email@mol.pt";
        String instituicaoAfiliacao = "QQQ";
        String nome1 = "beatriz12";
        String email1 = "beatriz12@hotmail.com";
        String instituicaoAfiliacao1 = "WWE";
        String titulo = "titulo1";
        String resumo = "resumo1";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("bolachas");
        String ficheiro = "C:\\Users\\Utilizador\\Downloads\\BTNext";
        instance.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador();
        instance.selecionarSubmissivel(indice);
        instance.selecionarSubmissao(indice);
        instance.alterarDados(titulo, resumo, palavrasChave);
        instance.novoAutor(nome, email, instituicaoAfiliacao);
        instance.getListaAutoresRegistados();
        instance.alterarAutorCorrespondente(indice);
        instance.alterarFicheiroPDF(ficheiro);
        instance.validarSubmissao();
        boolean expResult = true;
        boolean result = instance.alterarSubmissao();
        assertEquals(expResult, result);

    }

    /**
     * Test of getModeloListaAutoresRegistados method, of class
     * AlterarSubmissaoController.
     */
    @Test
    public void testGetModeloListaAutoresRegistados() {
        System.out.println("getModeloListaAutoresRegistados");
        AlterarSubmissaoFinalController instance
                = new AlterarSubmissaoFinalController(empresa);
        int indice = 0;
        String nome = "titulo";
        String email = "email@mol.pt";
        String instituicaoAfiliacao = "QQQ";
        String nome1 = "beatriz12";
        String email1 = "beatriz12@hotmail.com";
        String instituicaoAfiliacao1 = "WWE";
        String titulo = "titulo1";
        String resumo = "resumo1";
        List<String> palavrasChave = new ArrayList<>();
        palavrasChave.add("bolachas");
        String ficheiro = "C:\\Users\\Utilizador\\Downloads\\BTNext";
        instance.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador();
        instance.selecionarSubmissivel(indice);
        instance.selecionarSubmissao(indice);
        instance.alterarDados(titulo, resumo, palavrasChave);
        instance.novoAutor(nome, email, instituicaoAfiliacao);
        DefaultComboBoxModel<Autor> expResult = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<Autor> result = instance.getModeloListaAutoresRegistados();
        assertEquals(expResult.getClass().getSimpleName(), result.getClass().getSimpleName());
    }

}
