package eventoscientificos.model;

import java.util.List;

/**
 * Todas as classes que implementam esta interface, herdam a responsabilidade de
 * guardar todos os conflitos detetados entre revisores e artigos, ficando
 * obrigadas a implementar um processo de deteção.
 *
 * @author G01
 */
public interface Detetavel {

    /**
     * Devolve o Processo de Deteção.
     *
     * @return Processo de Deteção.
     */
    ProcessoDetecao getProcessoDetecao();

    /**
     * Modifica o Processo de Deteção.
     *
     * @param processoDetecao Novo Processo de Deteção.
     */
    void setProcessoDetecao(ProcessoDetecao processoDetecao);

    /**
     * Inicia o Processo de Deteção de um detetável, recebendo uma lista de
     * tipos de conflito.
     *
     * @param listaTiposConflito Lista de tipos de conflito.
     */
    public void iniciarProcessoDetecao(List<TipoConflito> listaTiposConflito);

}
