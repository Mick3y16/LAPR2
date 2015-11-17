package eventoscientificos.model.mecanismo.decisao;

import eventoscientificos.model.ListaDecisoes;
import eventoscientificos.model.ListaRevisoes;

/**
 * Todas as classes que implementam esta interface, herdam a responsabilidade de
 * decidir as submissões do decidivel pelos revisores da CP, segundo diferentes
 * critérios.
 *
 * @author G01
 */
public interface MecanismoDecisao {

    /**
     * Classifica submissões.
     *
     * @param listaRevisoes lista de revisoes
     * @return lista de decisoes
     */
    public ListaDecisoes classificarSubmissoes(ListaRevisoes listaRevisoes);

}
