package eventoscientificos.model;

import java.util.List;

/**
 * Representa uma instância de conflito através
 *
 * @author G01
 */
public class Conflito {

    /**
     * Revisor do conflito.
     */
    private Revisor revisor;

    /**
     * Submissão do conflito.
     */
    private Submissao submissao;

    /**
     * Tipo do conflito.
     */
    private List<TipoConflito> listaTipoConflito;

    /**
     * Constrói uma instância de Conflito recebendo um revisor, uma submissão e
     * um tipo de conflito.
     *
     * @param revisor Revisor do conflito.
     * @param submissao Submissão do conflito.
     * @param listaConflitos lista de Tipos do conflito.
     */
    public Conflito(Revisor revisor, Submissao submissao,
            List<TipoConflito> listaConflitos) {
        this.revisor = revisor;
        this.submissao = submissao;
        this.listaTipoConflito = listaConflitos;
    }

    /**
     * Devolve o revisor associado ao conflito
     *
     * @return revisor
     */
    public Revisor getRevisor() {
        return revisor;
    }

    /**
     * Devolve a submissão associada ao conflito
     *
     * @return submissao
     */
    public Submissao getSubmissao() {
        return submissao;
    }

    /**
     * Devolve os tipos de conflitos associados entre o revisor e artigo
     *
     * @return lista de conflitos
     */
    public List<TipoConflito> getListaTipoConflito() {
        return listaTipoConflito;
    }

    /**
     * Modifica a lista de tipos de conflitos do conflito detetado
     *
     * @param listaTipoConflito nova lista de conflitos
     */
    public void setListaTipoConflito(List<TipoConflito> listaTipoConflito) {
        this.listaTipoConflito = listaTipoConflito;
    }

    /**
     * Compara dois objetos entre si. Comparando primariamente a posição de
     * memória, seguida do conteudo e das classes as quais cada um deles
     * pertence, e finalmente os seus atributos, revisor, submissao e lista de
     * tipos de conflitos.
     *
     * @param outroObjecto Conflito a comparar
     * @return Verdadeiro caso os objetos comparados sejam iguais e falso caso
     * não o sejam.
     */
    @Override
    public boolean equals(Object outroObjecto) {
        if (this == outroObjecto) {
            return true;
        }

        if (outroObjecto == null || this.getClass() != outroObjecto.getClass()) {
            return false;
        }

        Conflito outroConflito = (Conflito) outroObjecto;

        return this.revisor.equals(outroConflito.revisor)
                            && this.submissao.equals(outroConflito.submissao);
    }

    /**
     * Adiciona um tipo de conflito ao conflito.
     * 
     * @param tipoConflito Tipo de conflito que vai ser adicionado.
     * 
     * @return Verdadeiro se o tipo de conflito for adicionado com sucesso e 
     * falso caso não seja.
     */
    public boolean adicionarTipoConflito(TipoConflito tipoConflito) {
        return this.listaTipoConflito.add(tipoConflito);
    }

}
