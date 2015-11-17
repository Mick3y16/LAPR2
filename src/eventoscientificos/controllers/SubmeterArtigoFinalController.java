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
 * Representa instância da classe SubmeterArtigoFinalController
 * 
 * @author G01
 */
public class SubmeterArtigoFinalController {

    /**
     * Instância de empresa.
     */
    private Empresa empresa;

    /**
     * Modelo da lista de autores.
     */
    private ModeloListaAutores modeloLista;

    /**
     * Lista de Submissiveis que estão a aceitar a submissão de artigos finais.
     */
    private List<Submissivel> listaSubmissivesAceitarArtigoFinal;

    /**
     * Instância de Submissivel.
     */
    private Submissivel submissivel;

    /**
     * Lista de submissões aceites do utilizador.
     */
    private List<Submissao> listaSubmissoesAceiteUtilizador;

    /**
     * Instância de submissao.
     */
    private Submissao submissao;

    /*
     Instância de artigo.
     */
    private Artigo artigo;

    /**
     * Instância de registo de utilizadores.
     */
    private RegistoUtilizadores registoUtilizadores;

    /**
     * Modelo da lista de autores registados.
     */
    private DefaultComboBoxModel<Autor> modeloListaAutoresRegistados;

    /**
     * Instância de Lista de Submissões.
     */
    private ListaSubmissoes listaSubmissoes;

    /**
     * Constrói uma instância de SubmeterArtigoFinalController.
     *
     * @param empresa Empresa.
     */
    public SubmeterArtigoFinalController(Empresa empresa) {
        this.empresa = empresa;
        this.modeloLista = null;
        this.artigo = null;
        this.listaSubmissivesAceitarArtigoFinal = null;
        this.listaSubmissoes = null;
        this.listaSubmissoesAceiteUtilizador = null;
        this.registoUtilizadores = null;
        this.submissao = null;
        this.submissivel = null;
    }
    
    /**
     * Devolve a lista de submissiveis.
     *
     * @return Lista submissiveis.
     */
    public List<Submissivel> getListaSubmissiveis() {
        return this.listaSubmissivesAceitarArtigoFinal;
    }
    
    /**
     * Devolve uma lista de submissoes aceites do utilizador.
     *
     * @return Lista de Submissoes.
     */
    public List<Submissao> getListaSubmissoes() {
        return this.listaSubmissoesAceiteUtilizador;
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
     * Preenche a lista de sumissiveis que estao a aceitar a submissao de
     * artigos finais.
     *
     * @return Verdadeiro se o registo eventos e lista de submissiveis for
     * diferente de null e falso se não for.
     */
    public boolean getListaSubmissiveisAceitarArtigoFinal() {
        RegistoEventos registoEventos = this.empresa.getRegistoEventos();

        this.listaSubmissivesAceitarArtigoFinal
                = registoEventos.getListaSubmissiveisAceitarArtigoFinal(
                        this.empresa.getUtilizadorAutenticado());

        return this.listaSubmissivesAceitarArtigoFinal != null;
    }

    /**
     * Prenche a lista de submissoes aceites do utilizador.
     *
     * @param indice Indice do submissivel selecionado.
     *
     * @return Verdadeiro se o submissivel, lista de submissoes e lista de
     * submissoes aceites do utilizador for diferente de null e falso se não
     * for.
     */
    public boolean selecionarSubmissivel(int indice) {
        this.submissivel = this.listaSubmissivesAceitarArtigoFinal.get(indice);
        this.listaSubmissoes = this.submissivel.getListaSubmissoes();
        this.listaSubmissoesAceiteUtilizador = listaSubmissoes.
                getListaSubmissoesUtilizador(this.empresa.getUtilizadorAutenticado());

        return this.submissivel != null && listaSubmissoes != null
                && this.listaSubmissivesAceitarArtigoFinal != null;
    }

    /**
     * Cria um novo artigo na submissão selecionada.
     *
     * @param indice Indice da submissao.
     *
     * @return Verdadeiro se a submissao for diferente de null e falso se for
     * igual a null.
     */
    public boolean selecionarSubmissaoAceite(int indice) {
        this.submissao = this.listaSubmissoesAceiteUtilizador.get(indice);
        this.artigo = this.submissao.novoArtigo();

        this.modeloLista = new ModeloListaAutores(this.artigo.getListaAutores());
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

        return this.submissao != null && this.artigo != null;
    }

    /**
     * Modifica os dados do artigo.
     *
     * @param titulo Titulo do Artigo.
     * @param resumo Resumo do Artigo.
     * @param palavrasChave Palavras Chave do Artigo.
     *
     * @return Verdadeiro se o registo de utilizadores for diferente de null e
     * falso se não for.
     */
    public boolean adicionarDadosArtigoFinal(String titulo, String resumo,
            List<String> palavrasChave) {
        this.artigo.setTitulo(titulo);
        this.artigo.setResumo(resumo);
        this.artigo.setPalavrasChave(palavrasChave);
        this.registoUtilizadores = this.empresa.getRegistoUtilizadores();

        return this.registoUtilizadores != null;
    }

    /**
     * Devolve uma instancia de autor ou autor registado dependendo dos dados
     * recebidos por parametro.
     *
     * @param nome Nome do autor.
     * @param email Email do autor.
     * @param instituicaoAfiliacao Instituição de Afiliação do autor.
     *
     * @return Verdaeiro se o autor for adicionado e falso se não for.
     */
    public boolean novoAutor(
            String nome, String email, String instituicaoAfiliacao) {

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
     * Preenche a lista de autores registados.
     *
     * @return Verdadeira se a lista de autores registados for diferente de null
     * e falso se for igual a null.
     */
    public boolean getListaAutoresRegistados() {
        this.modeloListaAutoresRegistados.removeAllElements();

        for (Autor autor
                : this.artigo.getListaAutores().getListaAutoresRegistados()) {
            this.modeloListaAutoresRegistados.addElement(autor);
        }

        return this.modeloListaAutoresRegistados != null;
    }

    /**
     * Modifica o autor correspondente da submissão.
     *
     * @param indice Indice do autor correspondente.
     *
     * @return Verdadeiro se o autor correspondente for diferente de null e
     * falso se não for.
     */
    public boolean adicionarAutorCorrespondente(int indice) {
        Autor autor = this.modeloListaAutoresRegistados.getElementAt(indice);
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
        return submissao.validarSubmissao();
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
