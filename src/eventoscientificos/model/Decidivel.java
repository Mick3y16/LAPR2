package eventoscientificos.model;

/**
 * Todas as classes que implementam esta interface, herdam a responsabilidade de
 * decidir as submissões do decidivel pelos revisores da CP, ficando obrigadas a
 * implementar um processo referente ao mesmo.
 *
 * @author G01
 */
public interface Decidivel {

    /**
     * Devolve o Processo de Decisão de um decidivel.
     *
     * @return Processo de decisão de um decidível.
     */
    ProcessoDecisao getProcessoDecisao();

    /**
     * Modifica o processo de decisão um decidivel.
     *
     * @param processoDecisao Novo processo de decisão de um decidível.
     */
    void setProcessoDecisao(ProcessoDecisao processoDecisao);

    /**
     * Constrói instância de ProcessoDecisao.
     *
     * @return Processo de decisão.
     */
    public ProcessoDecisao novoProcessoDecisao();

    /**
     * Adiciona um Processo Distribuição ao Decidivel.
     *
     * @param processoDecisao Processo decisão a adicionar.
     * @return Verdadeiro caso adicione e falso se não adicionar.
     */
    public boolean adicionarProcessoDecisao(ProcessoDecisao processoDecisao);
    
    /**
     * Altera o estado do decidivel quando o mesmo atinge a data de fim de 
     * revisão.
     * 
     * @return Verdadeiro se for possível alterar o estado e falso caso não 
     * seja.
     */
    boolean setEmDecisao();

    /**
     * Devolve o processo de distribuição.
     *
     * @return processo de distribuição.
     */
    public ProcessoDistribuicao getProcessoDistribuicao();

}
