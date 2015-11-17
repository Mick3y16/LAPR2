package eventoscientificos.model;

/**
 * Todas as classes que implementam esta interface, herdam a responsabilidade de
 * distribuir as submissões pelos revisores da CP, ficando obrigadas a
 * implementar um processo referente ao mesmo.
 *
 * @author G01
 */
public interface Distribuivel {

    /**
     * Constrói instância de ProcessoDistribuicao.
     *
     * @return ProcessoDistribuicao.
     */
    public ProcessoDistribuicao novoProcessoDistribuicao();

    /**
     * Adiciona um Processo Distribuição ao Distribuível.
     *
     * @param processoDistribuicao ProcessoDistribuicao a adicionar ao
     * distribuivel.
     * @return verdadeiro se adicionar ao distribuivel e falso se não for
     * possivel adicioná-lo.
     */
    public boolean adicionarProcessoDistribuicao(ProcessoDistribuicao processoDistribuicao);

    /**
     * Devolve o processo de distribuição.
     *
     * @return processo de distribuicao.
     */
    public ProcessoDistribuicao getProcessoDistribuicao();

    /**
     * Verifica se o distribuivel contém as condições necessárias para
     * distribuir as suas submissões pelos revisores
     *
     * @param u utilizador
     * @return verdadeiro cumprir as condições necessárias para distribuir e
     * falso se não estiver
     */
    public boolean isStateValidoParaDistribuir(Utilizador u);

    /**
     * Devolve a lista de submissões do distribuível.
     *
     * @return lista de submissões do distribuível.
     */
    public ListaSubmissoes getListaSubmissoes();

    /**
     * Devolve a comissão de programa do distribuivel.
     *
     * @return comissão de programa.
     */
    public CP getCP();
    
    /**
     * Altera o estado do distribuivel quando o mesmo atinge a data de inicio de 
     * distribuicao.
     * 
     * @return Verdadeiro se for possível alterar o estado e falso caso não 
     * seja.
     */
    boolean setEmDistribuicao();
}
