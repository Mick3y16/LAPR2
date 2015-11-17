package eventoscientificos.model;

import java.util.ArrayList;
import java.util.List;
import utils.Data;

/**
 * Representa uma instância de Artigo
 *
 * @author G01
 */
public class Artigo {

    /**
     * Título do artigo.
     */
    private String titulo;

    /**
     * Descrição do resumo.
     */
    private String resumo;

    /**
     * Caminho para o artigo.
     */
    private String ficheiro;

    /**
     * Lista de autores.
     */
    private ListaAutores listaAutores;

    /**
     * Lista de palavras chave.
     */
    private List<String> palavrasChave;

    /**
     * Autor Correspondente do artigoInicial.
     */
    private AutorCorrespondente autorCorrespondente;

    /**
     * Autor que realiza a submissão.
     */
    private Autor autorSubmissor;

    /**
     * Data de submissão do artigo.
     */
    private Data dataSubmissao;

    /**
     * Titulo do artigo por omissão.
     */
    private static final String TITULO_POR_OMISSAO = "Sem Titulo!";

    /**
     * Resumo do artigo por omissão.
     */
    private static final String RESUMO_POR_OMISSAO = "Sem Resumo!";

    /**
     * Caminho para o ficheiro com o artigo por omissão.
     */
    private static final String FICHEIRO_POR__OMISSAO = "Sem Ficheiro!";

    /**
     * Constrói uma instância de artigo com os dados por omissão.
     */
    public Artigo() {
        this.titulo = TITULO_POR_OMISSAO;
        this.resumo = RESUMO_POR_OMISSAO;
        this.ficheiro = FICHEIRO_POR__OMISSAO;
        this.listaAutores = new ListaAutores();
    }

    /**
     * Constrói uma cópia de um artigo com os mesmos atributos que o artigo
     * passado por parametro.
     *
     * @param artigo Artigo que vai ser copiado.
     */
    public Artigo(Artigo artigo) {
        setTitulo(artigo.getTitulo());
        setResumo(artigo.getResumo());
        setFicheiro(artigo.getFicheiro());
        setPalavrasChave(artigo.getPalavrasChave());
        this.listaAutores = new ListaAutores(artigo.getListaAutores());
        setAutorCorrespondente(artigo.getAutorCorrespondente());
        setAutorSubmissor(new Autor(artigo.getAutorSubmissor()));
        setDataSubmissao(Data.dataAtual());
    }

    /**
     * Devolve o titulo do artigo.
     *
     * @return Titulo do artigo.
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Devolve o resumo do artigo.
     *
     * @return Resumo do artigo.
     */
    public String getResumo() {
        return this.resumo;
    }

    /**
     * Devolve o caminho do ficheiro do artigo
     *
     * @return Caminho do ficheiro do artigo.
     */
    public String getFicheiro() {
        return ficheiro;
    }

    /**
     * Devolve a lista com os autores do artigo.
     *
     * @return Lista dos autores do artigo
     */
    public ListaAutores getListaAutores() {
        return this.listaAutores;
    }

    /**
     * Devolve o autor correspondente da submissao
     *
     * @return Autor correspondente da submissao
     */
    public AutorCorrespondente getAutorCorrespondente() {
        return this.autorCorrespondente;
    }

    /**
     * Devolve o autor submissor que realiza a submissão inicial.
     *
     * @return Autor que realiza a submissão inicial.
     */
    public Autor getAutorSubmissor() {
        return this.autorSubmissor;
    }

    /**
     * Devolve a lista de palavras de chave.do artigo.
     *
     * @return Lista de palavras chave do artigo.
     */
    public List<String> getPalavrasChave() {
        return this.palavrasChave;
    }

    /**
     * Devolve a data de submissão do artigo inicial.
     *
     * @return Data de submissaão do artigo inicial.
     */
    public Data getDataSubmissao() {
        return this.dataSubmissao;
    }

    /**
     * Modifica o titulo do artigo.
     *
     * @param titulo Novo titulo do artigo
     */
    public void setTitulo(String titulo) {
        if (titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O titulo do artigo não"
                                + " pode estar vazio.");
        }

        this.titulo = titulo;
    }

    /**
     * Modifica o resumo do artigo.
     *
     * @param resumo Novo resumo do artigo
     */
    public void setResumo(String resumo) {
        if (resumo.trim().isEmpty()) {
            throw new IllegalArgumentException("O resumo do artigo"
                                + " não pode estar vazio.");
        }

        this.resumo = resumo;
    }

    /**
     * Modifica o caminho para o ficheiro com o artigo.
     *
     * @param ficheiro Novo caminho para o ficheiro do artigo.
     */
    public void setFicheiro(String ficheiro) {
        if (ficheiro.trim().isEmpty()) {
            throw new IllegalArgumentException(
                                "Não submeteu um ficheiro válido.");
        }

        this.ficheiro = ficheiro;
    }

    /**
     * Modifica o autor correspondente da submissão.
     *
     * @param autorCorrespondente Novo autor correspondente do artigoInicial.
     */
    public void setAutorCorrespondente(AutorCorrespondente autorCorrespondente) {
        this.autorCorrespondente = autorCorrespondente;
    }

    /**
     * Modifica o autor submissor da submissão.
     *
     * @param autorSubmissor Novo autor submissor.
     */
    public void setAutorSubmissor(Autor autorSubmissor) {
        this.autorSubmissor = autorSubmissor;
    }

    /**
     * Modifica a lista de palavras chave do artigo.
     *
     * @param palavrasChave Nova lista de palavras chave.
     */
    public void setPalavrasChave(List<String> palavrasChave) {
        if (palavrasChave.isEmpty() || palavrasChave.size() > 5) {
            throw new IllegalArgumentException("O artigo deve ter pelo menos uma"
                                + "palavra chave e no máximo 5");
        }

        this.palavrasChave = palavrasChave;
    }

    /**
     * Modifica a data de submissão do artigo.
     *
     * @param dataSubmissao Nova data de submissão do artigo.
     */
    public void setDataSubmissao(Data dataSubmissao) {
        this.dataSubmissao = dataSubmissao;
    }

    /**
     * Verifica se o artigo é válido.
     *
     * @return Verdadeiro se o artigo é válido e falso se não é.
     */
    public boolean validarArtigo() {
        return true;
    }

    /**
     * Verifica se o utilizador passado por parâmetro está inserido na lista.
     *
     * @param utilizador Utilizador a verificar.
     * @return Verdadeiro se já existe na lista de autores e falso se não está.
     */
    public boolean isAutor(Utilizador utilizador) {
        return this.listaAutores.isAutor(utilizador);
    }

    /**
     * Compara dois objetos entre si. Comparando primariamente a posição de
     * memória, seguida do conteudo e das classes as quais cada um deles
     * pertence, e finalmente os seus atributos, titulo, resumo, ficheiro, lista
     * de autores.
     *
     * @param outroObjeto Artigo que vai ser comparado.
     * @return Verdadeiro caso os objetos comparados sejam iguais e falso caso
     * não o sejam.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }

        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }

        Artigo outroArtigo = (Artigo) outroObjeto;

        return this.getTitulo().equals(outroArtigo.getTitulo());
    }

}
