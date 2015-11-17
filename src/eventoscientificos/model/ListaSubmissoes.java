package eventoscientificos.model;

import eventoscientificos.model.state.submissao.SubmissaoAceiteState;
import eventoscientificos.model.state.submissao.SubmissaoRejeitadaState;
import java.util.ArrayList;
import java.util.List;

/**
 * @author G01
 */
public class ListaSubmissoes {

    /**
     * Lista das submissões.
     */
    private List<Submissao> listaSubmissoes;

    /**
     * Constroi uma instancia de Lista de submissoes em que a lista de
     * submissoes se encontra vazia.
     */
    public ListaSubmissoes() {
        this.listaSubmissoes = new ArrayList();
    }

    /**
     * Devolve a lista de submissões.
     *
     * @return lista de submissões.
     */
    public List<Submissao> getListaSubmissoes() {
        return this.listaSubmissoes;
    }

    /**
     * Cria e retorna uma instância de submissao.
     *
     * @return Submissao com os dados vazios
     */
    public Submissao novaSubmissao() {
        return new Submissao();
    }

    /**
     * Valida a lista de submissoes verificando se a lista já possui uma
     * submissão igual à passada por parametro.
     *
     * @param submissao Submissao de artigo
     * @return Verdadeiro se a lista de submissoes nao tem a submissao e falso
     * se tiver.
     */
    public boolean validarSubmissao(Submissao submissao) {
        if (!submissao.validarSubmissao()) {
            throw new IllegalArgumentException("A submissão não é valida");
        }

        if (this.listaSubmissoes.contains(submissao)) {
            throw new IllegalArgumentException("A submissão já existe na lista.");
        }

        return true;
    }

    /**
     * Verifica se a submissão passada por parametro já consta na lista de
     * submissoes, ignorando a submisaao que lhe deu origem.
     *
     * @param submissao Submissao clonada.
     * @param submissaoClone Submissao clone.
     *
     * @return Verdadeiro se a submissao clone não existir.
     */
    public boolean validarCloneSubmissao(
                        Submissao submissao, Submissao submissaoClone) {
        for (Submissao outraSubmissao : this.listaSubmissoes) {
            if (submissaoClone.equals(outraSubmissao)
                                && !submissao.equals(outraSubmissao)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Adiciona à lista de submissoes a submissao passada por parametro.
     *
     * @param submissao Submissao de artigo
     * @return verdareiro se a lista de submissoes 
     */
    public boolean adicionarSubmissao(Submissao submissao) {
        submissao.alterarEstadoSubmissao();
        return this.listaSubmissoes.add(submissao);
    }

    /**
     * Altera o artigo inicial da submissao.
     *
     * @param submissao Submissao a alterar o artigo.
     * @param artigo Novo artigo.
     * @return Verdadeiro se a submissao foi alterada e falso se nao for.
     */
    public boolean alterarSubmissao(Submissao submissao, Artigo artigo) {
        return submissao.adicionarArtigo(artigo);
    }

    /**
     * Devolve o número total de submissões na lista.
     * 
     * @return Número total de submissões na lista.
     */
    public int getNumeroSubmissoes() {
        return this.listaSubmissoes.size();
    }

    /**
     * Devolve uma submissão através da sua posição na lista.
     * 
     * @param indice Posição na lista.
     * 
     * @return Submissão através da sua posição na lista.
     */
    public Submissao getSubmissaoPeloID(int indice) {
        return this.listaSubmissoes.get(indice);
    }

    /**
     * Verifica se o utilizador passado por parâmetro é autor de alguma
     * submissão.
     *
     * @param utilizador Utilizador a verificar se é autor.
     * @return Verdadeiro se encontrar uma submissão em que o utilizador é autor
     * e falso se não encontrar.
     */
    public boolean isUtilizadorUmAutorSubmissao(Utilizador utilizador) {
        for (Submissao submissao : this.listaSubmissoes) {
            if (submissao.isAutorEmPeriodoSubmissao(utilizador)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Devolve uam lista de submissões associadas ao utilizador
     *
     * @param utilizador utilizador a verificar submissões
     * @return lista de submissões do utilizador
     */
    public List<Submissao> getListaSubmissoesUtilizadorEmPeriodoSubmissao(Utilizador utilizador) {
        List<Submissao> listaSubmissoesUtilizador = new ArrayList<>();

        for (Submissao submissao : this.listaSubmissoes) {
            if (submissao.isAutorEmPeriodoSubmissao(utilizador)) {
                listaSubmissoesUtilizador.add(submissao);
            }
        }
        return listaSubmissoesUtilizador;
    }

    /**
     * Verifica se determinado Utilizador (recebido por parâmetro) é autor do
     * artigo submetido
     *
     * @param u utilizador no sistema
     * @return verdadeiro se for autor do artigo e falso se não for
     */
    public boolean containsAutorNaListaAutoresArtigoInicial(Utilizador u) {
        for (Submissao s : listaSubmissoes) {
            if (s.getArtigoInicial().isAutor(u) && !s.isStateEmCameraReady()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Compara dois objetos entre si. Comparando primariamente a posição de
     * memória, seguida do conteudo e das classes as quais cada um deles
     * pertence, e finalmente os seus atributos, lista de submissoes.
     *
     * @param outroObjeto ListaSubmissoes que vai ser usada na comparação.
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

        ListaSubmissoes outraListaSubmissoes
                            = (ListaSubmissoes) outroObjeto;

        return this.listaSubmissoes.equals(
                            outraListaSubmissoes.listaSubmissoes);
    }

    /**
     * Verifica se na lista de submissoes existe submissao no estado removido.
     *
     * @return Verdadeiro caso esteja no estado removido e falso caso não
     * esteja.
     */
    public boolean temSubmissoesRetiradas() {
        for (Submissao submissao : this.listaSubmissoes) {
            if (submissao.isStateRemovida()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Devolve uma lista de submissões que se encontram no estado removido.
     *
     * @return Lista de submissões retiradas.
     */
    public List<Submissao> getListaSubmissoesRetiradas() {
        List<Submissao> listaSubmissoesRetiradas = new ArrayList<>();

        for (Submissao submissao : this.listaSubmissoes) {
            if (submissao.isStateRemovida()) {
                listaSubmissoesRetiradas.add(submissao);
            }
        }
        return listaSubmissoesRetiradas;
    }

    public boolean isUtilizadorUmAutorSubmissaoInicial(Utilizador utilizador) {
        for (Submissao submissao : this.listaSubmissoes) {
            if (submissao.isAutorArtigoInicial(utilizador)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Devolve uma lista de submissões em que o utilizador autenticado no
     * sistema é um dos autores
     *
     * @param u utilizador autenticado no sistema
     * @return lista de submissões do utilizador
     */
    public List<Submissao> getListaSubmissoesUtilizador(Utilizador u) {
        List<Submissao> listaSubmissoesAutor = new ArrayList<>();
        for (Submissao s : this.listaSubmissoes) {
            if (s.isAutorArtigo(u)) {
                listaSubmissoesAutor.add(s);
            }
        }
        return listaSubmissoesAutor;
    }

}
