package eventoscientificos.controllers;

import eventoscientificos.model.Artigo;
import eventoscientificos.model.Autor;
import eventoscientificos.model.AutorCorrespondente;
import eventoscientificos.model.Empresa;
import eventoscientificos.model.InstituicaoAfiliacao;
import eventoscientificos.model.ListaAutores;
import eventoscientificos.model.ListaSubmissoes;
import eventoscientificos.model.RegistoEventos;
import eventoscientificos.model.RegistoUtilizadores;
import eventoscientificos.model.Submissao;
import eventoscientificos.model.Submissivel;
import eventoscientificos.model.Utilizador;
import java.util.List;
import javax.swing.DefaultListModel;
import utils.Data;

/**
 * Representa uma instância de SubmeterArtigoController através de uma empresa.
 *
 * @author G01
 */
public class SubmeterArtigoController {

    /**
     * Instância de Empresa.
     */
    private Empresa empresa;

    /**
     * Modelo da lista de autores.
     */
    private DefaultListModel<Autor> modeloLista;

    /**
     * Lista de Submissiveis.
     */
    private List<Submissivel> listaSubmissiveis;

    /**
     * Instância de Submissivel.
     */
    private Submissivel submissivel;

    /**
     * Instância de Lista de Submissões.
     */
    private ListaSubmissoes listaSubmissoes;

    /**
     * Instância de Submissao.
     */
    private Submissao submissao;

    /**
     * Instncia de Artigo.
     */
    private Artigo artigo;

    /**
     * Intância de Registo de Utiliazadores.
     */
    private RegistoUtilizadores registoUtilizadores;

    /**
     * Intância de Lista de Autores.
     */
    private ListaAutores listaAutores;

    /**
     * Lista de autores registados.
     */
    private List<Autor> listaAutoresRegistados;

    /**
     * Constrói uma instância de SubmeterArtigoController.
     *
     * @param empresa Empresa.
     */
    public SubmeterArtigoController(Empresa empresa) {
        this.empresa = empresa;
        this.modeloLista = new DefaultListModel();
        this.listaSubmissiveis = null;
        this.submissivel = null;
        this.listaSubmissoes = null;
        this.submissao = null;
        this.artigo = null;
        this.registoUtilizadores = null;
        this.listaAutores = null;
        this.listaAutoresRegistados = null;
    }

    /**
     * Devolve a lista de submissiveis.
     *
     * @return Lista submissiveis.
     */
    public List<Submissivel> getListaSubmissiveis() {
        return this.listaSubmissiveis;
    }

    /**
     * Devolve a modelo da lista de autores.
     *
     * @return Modelo da lista de autores.
     */
    public DefaultListModel getModeloLista() {
        return this.modeloLista;
    }

    /**
     * Devolve a lista de autores registados.
     *
     * @return Lista de autores registados.
     */
    public List<Autor> getListaAutores() {
        return this.listaAutoresRegistados;
    }

    /**
     * Devolve uma lista de Submissiveis que estão a aceitar submissoes de
     * artigos.
     *
     * @return Lista de Submissiveis.
     */
    public boolean getListaSubmissiveisAceitarArtigo() {
        RegistoEventos registoEventos = this.empresa.getRegistoEventos();
        this.listaSubmissiveis
                = registoEventos.getListaSubmissiveisAceitarArtigo();
        
        return this.listaSubmissiveis != null;
    }

    /**
     * Cria uma nova submissão no submissível selecionado.
     * @param indice indice do submíssivel na lista de submissiveis
     * @return verdadeiro se selecionar se submissivel, a lista de submissoes,
     * submissao, o artigo e a lista de autores foram instanciadas e falso 
     * se não forem
     */
    public boolean selecionarSubmissivel(int indice) {
        this.submissivel = this.listaSubmissiveis.get(indice);
        this.listaSubmissoes = this.submissivel.getListaSubmissoes();
        this.submissao = listaSubmissoes.novaSubmissao();
        this.artigo = submissao.novoArtigo();
        this.listaAutores = artigo.getListaAutores();
        
        return this.submissivel != null && this.listaSubmissoes != null
                && this.submissao != null && this.artigo != null
                && this.listaAutores != null;
    }

    /**
     * Modifica os dados do artigo.
     *
     * @param titulo Titulo do Artigo.
     * @param resumo Resumo do Artigo.
     * @param palavrasChaves palavras-chave do artigo
     * @return verdadeiro se o registoUtilizadores for instanciado 
     * e falso se não for
     */
    public boolean adicionarDadosArtigo(String titulo, String resumo,
            List<String> palavrasChaves) {
        this.artigo.setTitulo(titulo);
        this.artigo.setResumo(resumo);
        this.artigo.setPalavrasChave(palavrasChaves);
        this.registoUtilizadores = this.empresa.getRegistoUtilizadores();
        
        Utilizador submissor = this.empresa.getUtilizadorAutenticado();
        this.novoAutor(submissor.getNome(), submissor.getEmail(), new InstituicaoAfiliacao("ISEP"));
        
        return this.registoUtilizadores != null;
    }

    /**
     * Devolve uma instancia de autor ou autor registado dependendo dos dados
     * recebidos por parametro.
     *
     * @param nome Nome do autor.
     * @param email Email do autor.
     * @param instituicaoAfiliacao Instituição de Afiliação do autor.
     * @return verdadeiro se for instanciado um novo autor e falso se não for
     */
    public boolean novoAutor(
            String nome, String email, InstituicaoAfiliacao instituicaoAfiliacao) {
        
        Utilizador utilizador = this.registoUtilizadores.getUtilizador(email);
        
        if (utilizador == null) {
            if (!this.modeloLista.contains(new Autor(nome, email, instituicaoAfiliacao))) {
                this.modeloLista.addElement(new Autor(nome, email, instituicaoAfiliacao));
            }
            
            return this.listaAutores.novoAutor(nome, email, instituicaoAfiliacao);
        } else {
            if (!this.modeloLista.contains(new Autor(utilizador, instituicaoAfiliacao))) {
                this.modeloLista.addElement(new Autor(utilizador, instituicaoAfiliacao));
            }
            
            return this.listaAutores.novoAutor(utilizador, instituicaoAfiliacao);
        }
    }

    /**
     * Devolveuma lista de autores registados.
     *
     * @return Lista de autores registados.
     */
    public boolean getListaAutoresRegistados() {
        this.listaAutoresRegistados = this.listaAutores.getListaAutoresRegistados();
        return this.listaAutoresRegistados != null;
    }

    /**
     * Modifica o autor correspondente da submissão.
     * @param indice indice da posição do autor correspondente na lista de autores
     * @return verdadeiro 
     */
    public boolean adicionarAutorCorrespondente(int indice) {
        Autor autor = this.listaAutoresRegistados.get(indice);
        AutorCorrespondente autorCorrespondente = new AutorCorrespondente(
                autor.getUtilizador(), autor.getInstituicaoAfiliacao());
        this.artigo.setAutorCorrespondente(autorCorrespondente);
        
        return true;
    }

    /**
     * Modifica o ficheiro da submissão.
     *
     * @param ficheiro Ficheiro da submissão.
     * @return Verdadeiro se o ficheiro for válido e falso se não for.
     */
    public boolean adicionarFicheiroPDF(String ficheiro) {
        this.artigo.setFicheiro(ficheiro);
        return true;
    }

    /**
     * Verifica se a submissão já existe no evento ou sessão temática.
     * 
     * @return Verdadeiro se não existir e falso caso exista.
     */
    public boolean validarSubmissao() {
        return this.listaSubmissoes.validarSubmissao(submissao);
    }

    /**
     * Adiciona uma submissão ao Submissível selecionado.
     *
     * @return Verdaeiro se a submissao for adicionada e falso se não for.
     */
    public boolean adicionarSubmissao() {
        Autor autorSubmissor = new Autor(
                this.empresa.getUtilizadorAutenticado(),
                new InstituicaoAfiliacao("ISEP"));
        
        this.artigo.setAutorSubmissor(autorSubmissor);
        this.artigo.setDataSubmissao(Data.dataAtual());
        return this.listaSubmissoes.adicionarSubmissao(this.submissao);
    }
    
}
