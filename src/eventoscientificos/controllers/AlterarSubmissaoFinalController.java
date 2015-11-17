package eventoscientificos.controllers;

import eventoscientificos.view.ModeloListaAutores;
import eventoscientificos.model.Artigo;
import eventoscientificos.model.Autor;
import eventoscientificos.model.AutorCorrespondente;
import eventoscientificos.model.Empresa;
import eventoscientificos.model.InstituicaoAfiliacao;
import eventoscientificos.model.ListaSubmissoes;
import eventoscientificos.model.RegistoEventos;
import eventoscientificos.model.RegistoUtilizadores;
import eventoscientificos.model.Submissao;
import eventoscientificos.model.Submissivel;
import eventoscientificos.model.Utilizador;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import utils.Data;

/**
 * Representa instância da classe AlterarSubmissaoFinalController
 * @author G01
 */
public class AlterarSubmissaoFinalController implements ControllerAutor {

    /**
     * Instância de empresa.
     */
    private Empresa empresa;

    /**
     * Instância de registo eventos.
     */
    private RegistoUtilizadores registoUtilizadores;

    /**
     * Lista de submissiveis.
     */
    private List<Submissivel> listaSubmissiveis;

    /**
     * Submissivel que tem a submissao pretendida para alterar.
     */
    private Submissivel submissivel;

    /**
     * Instância de lista de submissoes.
     */
    private ListaSubmissoes listaSubmissoes;

    /**
     * Lista de Submissoes do utilizador.
     */
    private List<Submissao> listaSubmissoesUtilizador;

    /**
     * Instancia de submissao.
     */
    private Submissao submissao;

    /**
     * Instância de submissao.
     */
    private Submissao submissaoClone;

    /**
     * Instância de artigo.
     */
    private Artigo artigoClone;

    /**
     * Modelo da lista de autores.
     */
    private ModeloListaAutores modeloLista;

    /**
     * Modelo da lista de autores registados.
     */
    private DefaultComboBoxModel<Autor> modeloListaAutoresRegistados;

    /**
     * Constrói uma instância de AlterarSubmissaoFinalController recebendo uma
     * empresa por parametro.
     *
     * @param empresa Empresa.
     */
    public AlterarSubmissaoFinalController(Empresa empresa) {
        this.empresa = empresa;
        this.registoUtilizadores = empresa.getRegistoUtilizadores();
        this.listaSubmissiveis = null;
        this.submissivel = null;
        this.listaSubmissoes = null;
        this.listaSubmissoesUtilizador = null;
        this.submissao = null;
        this.submissaoClone = null;
        this.artigoClone = null;
        this.modeloLista = null;
    }

    /**
     * Devolve a lista de submissiveis a aceitar artigos finais com submissão do
     * utilizador.
     *
     * @return Lista de submissíveis a aceitar artigos finais com submissão do
     * utilizador.
     */
    public List<Submissivel> getListaSubmissiveis() {
        return this.listaSubmissiveis;
    }

    /**
     * Devolve a lista de submissões do utilizador dentro de um submissivel.
     *
     * @return Lista de submissões do utilizador dentro de um submissivel.
     */
    public List<Submissao> getListaSubmissoes() {
        return this.listaSubmissoesUtilizador;
    }

    /**
     * Devolve o titulo do artigo.
     *
     * @return Titulo do artigo.
     */
    public String getArtigoTitulo() {
        return this.artigoClone.getTitulo();
    }

    /**
     * Devolve o resumo do artigo
     *
     * @return Resumo do artigo.
     */
    public String getArtigoResumo() {
        return this.artigoClone.getResumo();
    }

    /**
     * Devolve as palavras-chave do artigo.
     *
     * @return Lista de palavras-chave do artigo.
     */
    public List<String> getArtigoPalavrasChave() {
        return this.artigoClone.getPalavrasChave();
    }

    /**
     * Devolve o modelo da lista de autores do artigo.
     *
     * @return Modelo da lista de autores do artigo.
     */
    public ModeloListaAutores getModeloListaAutores() {
        return this.modeloLista;
    }

    /**
     * Devolve o modelo da lista de autores registados do artigo.
     *
     * @return Modelo da lista de autores do artigo.
     */
    public DefaultComboBoxModel<Autor> getModeloListaAutoresRegistados() {
        return this.modeloListaAutoresRegistados;
    }

    /**
     * Devolve o caminho para o ficheiro que contém o artigo científico.
     *
     * @return Caminho para o ficheiro que contém o artigo científico.
     */
    public String getArtigoFicheiro() {
        return this.artigoClone.getFicheiro();
    }

    /**
     * Devolve uma lista de submissiveis nos quais é possivel alterar uma
     * submissao.
     *
     * @return Verdadeiro se o utilizador, registo eventos e lista de
     * submissiveis forem diferente de null
     */
    public boolean getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador() {
        Utilizador utilizador = this.empresa.getUtilizadorAutenticado();
        RegistoEventos registoEventos = this.empresa.getRegistoEventos();

        this.listaSubmissiveis
                = registoEventos.getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador(
                        this.empresa.getUtilizadorAutenticado());

        return this.listaSubmissiveis != null;
    }

    /**
     *
     * @param indice Indice do submissivel selecionado.
     * @return Verdadeiro se a lista de submissoes e a lista de submisoes do
     * utilizador são diferentes de null.
     */
    public boolean selecionarSubmissivel(int indice) {
        this.submissivel = this.listaSubmissiveis.get(indice);
        this.listaSubmissoes = this.submissivel.getListaSubmissoes();
        this.listaSubmissoesUtilizador
                = listaSubmissoes.getListaSubmissoesUtilizadorEmPeriodoSubmissao(
                        this.empresa.getUtilizadorAutenticado());

        return this.submissivel != null && this.listaSubmissoes != null
                || this.listaSubmissoesUtilizador != null;
    }

    /**
     * Cria um clone da submissao selecionada.
     *
     * @param indice indice da submissao selecionada
     * @return verdadeiro se o artigo, a lista de autores e o registo
     * utilizadores forem diferentes de null.
     */
    public boolean selecionarSubmissao(int indice) {
        this.submissao = this.listaSubmissoesUtilizador.get(indice);
        this.submissaoClone = this.submissao.criarCloneSubmissao();
        this.artigoClone = this.submissaoClone.getArtigoFinal();
        this.modeloLista = new ModeloListaAutores(this.artigoClone.getListaAutores());
        this.modeloListaAutoresRegistados = new DefaultComboBoxModel<Autor>();
        this.modeloLista.addListDataListener(new ListDataListener() {

            @Override
            public void intervalAdded(ListDataEvent e) {
                getListaAutoresRegistados();
            }

            @Override
            public void intervalRemoved(ListDataEvent e) {
                getListaAutoresRegistados();
            }

            @Override
            public void contentsChanged(ListDataEvent e) {
            }
        });

        this.registoUtilizadores = this.empresa.getRegistoUtilizadores();

        return this.submissao != null && this.submissaoClone != null
                && this.artigoClone != null && this.registoUtilizadores != null;
    }

    /**
     * Modifica o título e o resumo da submissão clone.
     *
     * @param titulo Titulo da submissao clone.
     * @param resumo Resumo da submissao clone.
     * @param palavrasChave Lista das palavras-chave da submissão clone.
     */
    public void alterarDados(String titulo, String resumo, List<String> palavrasChave) {
        this.artigoClone.setTitulo(titulo);
        this.artigoClone.setResumo(resumo);
        this.artigoClone.setPalavrasChave(palavrasChave);
    }

    /**
     * Adiciona um autor à lista de autores.
     *
     * @param nome Nome do autor.
     * @param email Email do autor.
     * @param instituicaoAfiliacao Instituicao de afiliacao do autor.
     *
     * @return Verdadeiro se o autor for adicionado e falso se não for.
     */
    public boolean novoAutor(String nome, String email,
            String instituicaoAfiliacao) {

        Utilizador utilizador = this.registoUtilizadores.getUtilizador(email);

        return this.modeloLista.addElement(
                nome, email, instituicaoAfiliacao, utilizador);
    }

    /**
     * Elimina um autor da lista de autores.
     *
     * @param indice Posição do autor na lista.
     *
     * @return Verdadeiro se o autor for removido com sucesso e falso caso não
     * seja possível remover.
     */
    public boolean apagarAutor(int indice) {
        if (this.empresa.getUtilizadorAutenticado().equals(
                this.modeloLista.getElementAt(indice).getUtilizador())) {
            throw new IllegalArgumentException("Não se pode remover a si próprio"
                    + " da lista.");
        }

        return this.modeloLista.removeElement(indice);
    }

    /**
     * Devolve uma lista de autores registados da lista de autores.
     *
     * @return Lista de autores rgistados.
     */
    public boolean getListaAutoresRegistados() {
        this.modeloListaAutoresRegistados.removeAllElements();

        for (Autor autor
                : this.artigoClone.getListaAutores().getListaAutoresRegistados()) {
            this.modeloListaAutoresRegistados.addElement(autor);
        }

        return this.modeloListaAutoresRegistados != null;
    }

    /**
     * Modifica o autor correspondente.
     *
     * @param indice Indice do autor nomeado a autor correspondente.
     *
     * @return Verdadeiro.
     */
    public boolean alterarAutorCorrespondente(int indice) {
        Autor autor = this.modeloListaAutoresRegistados.getElementAt(indice);
        AutorCorrespondente autorCorrespondente
                = new AutorCorrespondente(autor.getUtilizador(), autor.getInstituicaoAfiliacao());
        this.artigoClone.setAutorCorrespondente(autorCorrespondente);

        return true;
    }

    /**
     * Modifica o ficheiro.
     *
     * @param ficheiro Novo Ficheiro.
     *
     * @return Verdadeiro se o ficheiro for um caminho válido e falso caso não
     * seja.
     */
    public boolean alterarFicheiroPDF(String ficheiro) {
        this.artigoClone.setFicheiro(ficheiro);

        return true;
    }

    /**
     * Verifica se a submissao é válida e se já existe.
     *
     * @return Verdadeiro se a submissão é válida e se não exista na lista de
     * submissões e falso se não for.
     */
    public boolean validarSubmissao() {
        this.submissaoClone.validarSubmissao();

        if (!this.listaSubmissoes.validarCloneSubmissao(this.submissao, this.submissaoClone)) {
            throw new IllegalArgumentException("A submissão já existe na lista.");
        }

        return true;
    }

    /**
     * Altera uma Submissão.
     *
     * @return Verdadeiro se a submissão foi alterada e falso se não foi.
     */
    public boolean alterarSubmissao() {
        Autor autorSubmissor = new Autor(
                this.empresa.getUtilizadorAutenticado(),
                new InstituicaoAfiliacao("ISEP"));

        this.artigoClone.setAutorSubmissor(autorSubmissor);
        this.artigoClone.setDataSubmissao(Data.dataAtual());
        return this.listaSubmissoes.alterarSubmissao(this.submissao, this.artigoClone);
    }
}
