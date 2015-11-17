package eventoscientificos.view;

import eventoscientificos.model.Autor;
import eventoscientificos.model.InstituicaoAfiliacao;
import eventoscientificos.model.ListaAutores;
import eventoscientificos.model.Utilizador;
import javax.swing.AbstractListModel;
import javax.swing.event.ListDataEvent;

/**
 * Representa uma instância de ModeloListaAutores através de uma lista de
 * autores.
 *
 * @author G01
 */
public class ModeloListaAutores extends AbstractListModel<Autor> {

    /**
     * Lista de autores.
     */
    private ListaAutores listaAutores;

    /**
     * Constrói uma instância de ModeloListaAutores recebendo uma lista de
     * autores.
     *
     * @param listaAutores Lista de autores.
     */
    public ModeloListaAutores(ListaAutores listaAutores) {
        this.listaAutores = listaAutores;
    }

    /**
     * Devolve o tamanho da lista de autores.
     *
     * @return Tamanho da lista de autores.
     */
    @Override
    public int getSize() {
        return this.listaAutores.getNumeroAutores();
    }

    /**
     * Devolve o autor de uma determinada posição.
     *
     * @param indice Posição do autor na lista.
     *
     * @return Autor.
     */
    @Override
    public Autor getElementAt(int indice) {
        return this.listaAutores.getAutorPeloID(indice);
    }

    /**
     * Adiciona um autor à lista de autores.
     * 
     * @param nome Nome do novo autor.
     * @param email Email do novo autor.
     * @param instituicaoAfiliacao Instituição de afiliação do novo autor.
     * @param utilizador Utilizador do novo autor.
     * 
     * @return Verdadeiro se o autor for adicionado à lista de autors
     * e falso se não for.
     */
    public boolean addElement(String nome, String email,
            String instituicaoAfiliacao, Utilizador utilizador) {

        boolean autorAdicionado = false;
        if (utilizador == null) {
            autorAdicionado = this.listaAutores.novoAutor(nome, email,
                    new InstituicaoAfiliacao(instituicaoAfiliacao));
        } else {
            autorAdicionado = this.listaAutores.novoAutor(utilizador,
                    new InstituicaoAfiliacao(instituicaoAfiliacao));
        }

//        Autor autor = this.listaAutores.getAutorPeloID(email);
        if (autorAdicionado) {
            fireIntervalAdded(this, this.getSize() - 1, this.getSize() - 1);
        }
        
        return autorAdicionado;
    }

    /**
     * Remove um autor da lista de autores recebendo o respetivo índice.
     * 
     * @param indice Indice do autor a remover.
     * @return Verdadeiro se o autor for removido e falso se não.
     */
    public boolean removeElement(int indice) {
        boolean autorRemovido = false;
        autorRemovido = this.listaAutores.removerAutor(indice);
        if (autorRemovido) {
            fireIntervalRemoved(this, indice, indice);
        }
        return autorRemovido;
    }

}
