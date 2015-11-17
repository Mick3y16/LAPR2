package eventoscientificos.model.mecanismo.detecao;

import eventoscientificos.model.ListaConflitos;
import eventoscientificos.model.Revisor;
import eventoscientificos.model.Submissao;
import eventoscientificos.model.TipoConflito;

/**
 * Todas as classes que implementam esta interface, herdam a responsabilidade de
 * detetar conflitos de interesse entre revisores e artigos retornando os mesmos.
 * 
 * @author G01
 */
public interface MecanismoDetecao {

    /**
     * Método responsável por detetar um conflito entre um revisor e uma 
     * submissão, aplicando-lhe uma descrição.
     * 
     * @param listaConflitos Lista de conflitos encontrados.
     * @param revisor Revisor da CP do detetável.
     * @param submissao Submissão do detetável.
     * @param tipoConflito Tipo de conflito que vai ser procurado.
     * 
     * @return Verdadeiro se encontrar um tipo de conflito e falso caso não
     * encontre.
     */
    boolean detetarConflito(ListaConflitos listaConflitos, Revisor revisor,
            Submissao submissao, TipoConflito tipoConflito);

}
