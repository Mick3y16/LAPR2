package eventoscientificos.model;

import java.util.List;

/**
 * Todas as classes que implementam esta interface, herdam a responsabilidade de
 * permitir submissões de artigos cientificos, ficando obrigadas a implementar
 * uma lista com as mesmas.
 *
 * @author G01
 */
public interface Submissivel {

    /**
     * Devolve a lista de submissões do submissivel.
     *
     * @return Devolve a lista de submissões do submissivel.
     */
    ListaSubmissoes getListaSubmissoes();

    /**
     * Altera o estado do submissivel quando o mesmo atinge a data de inicio de
     * submissão.
     *
     * @return Verdadeiro se for possível alterar o estado e falso caso não
     * seja.
     */
    boolean setEmSubmissao();

    /**
     * Verifica se um evento ou sessão temática estão a aceitar submissões de
     * artigos.
     *
     * @return Verdadeiro se é possivel submeter e falso se não é possível
     */
    boolean isStateValidoParaSubmeter();

    /**
     * Verifica se um evento ou sessão temática estão a aceitar alterações nas
     * submissões de artigos.
     *
     * @return Verdadeiro se é possivel alterar e falso se não é possível
     */
    boolean isStateValidoParaAlterar();

    /**
     * Devolve uma lista de submissões retiradas.
     *
     * @return Lista de submissões retiradas.
     */
    List<Submissao> getListaSubmissoesRetiradas();

    /**
     * Verifica se um evento ou sessão temática estão a aceitar submissões de
     * artigos finais.
     *
     * @return Verdadeiro se é possivel submeter e falso se não é possível
     */
    boolean isStateValidoParaSubmeterArtigoFinal();

    /**
     * Verifica se determinado Submissivel cumpre os critérios necessários para
     * remover.
     *
     * @param u utilizador
     * @return verdadeiro se poder remover e falso se não for possível remover.
     */
    boolean isStateValidoParaRemover(Utilizador u);

    /**
     * Altera o estado do submissivel quando o mesmo atinge a data de fim de 
     * submissao camera ready.
     *
     * @return Verdadeiro se for possível alterar o estado e falso caso não
     * seja.
     */
    boolean setEmSubmissaoCameraReady();

}
