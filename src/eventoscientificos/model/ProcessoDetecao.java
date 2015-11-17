package eventoscientificos.model;

import eventoscientificos.model.mecanismo.detecao.MecanismoDetecao;
import java.util.List;

/**
 * @author G01
 */
public class ProcessoDetecao {

    /**
     * Detetável.
     */
    private Detetavel detetavel;

    /**
     * Lista de Tipos de Conflito.
     */
    private List<TipoConflito> listaTiposConflito;

    /**
     * Lista de conflitos detetados
     */
    private ListaConflitos listaConflitos;

    /**
     * Constrói uma instância de Processo de Deteção
     *
     * @param detetavel detetavel
     * @param listaTiposConflito lista de tipos de conflitos
     */
    public ProcessoDetecao(
            Detetavel detetavel, List<TipoConflito> listaTiposConflito) {
        this.detetavel = detetavel;
        this.listaTiposConflito = listaTiposConflito;
        this.listaConflitos = new ListaConflitos();
    }

    /**
     * Devolve uma lista de conflitos detetados entre revisor e submissão
     *
     * @return lista de conflitos detetados
     */
    public ListaConflitos getListaConflito() {
        return this.listaConflitos;
    }

    /**
     * Compara dois objetos entre si. Comparando primariamente a posição de
     * memória, seguida do conteudo e das classes as quais cada um deles
     * pertence, e finalmente os seus atributos, lista de conflitos.
     *
     * @param outroObjecto Processo de deteção a comparar
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

        ProcessoDetecao outroProcesso = (ProcessoDetecao) outroObjecto;

        return this.detetavel.equals(outroProcesso.detetavel)
                && this.listaConflitos.equals(outroProcesso.listaConflitos);
    }

    public boolean detetarConflitos() {
        CP cp = ((CPDefinivel) this.detetavel).getCP();
        ListaSubmissoes listaSubmissoes
                = ((Submissivel) this.detetavel).getListaSubmissoes();

        for (int i = 0; i < cp.getNumeroRevisores(); i++) {
            Revisor revisor = cp.getRevisorPeloID(i);

            for (Submissao submissao : listaSubmissoes.getListaSubmissoes()) {
                for (TipoConflito tipoConflito : this.listaTiposConflito) {
                    MecanismoDetecao mecanismo
                            = tipoConflito.getMecanismoDetecao();

                    mecanismo.detetarConflito(
                            this.listaConflitos, revisor,
                            submissao, tipoConflito);
                }
            }
        }

        return true;
    }

}
