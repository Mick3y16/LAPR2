package eventoscientificos.model;

/**
 * Esta interface tem como objetivo definir a CP em todas as classes que a
 * implementam.
 *
 * @author G01
 */
public interface CPDefinivel {

    /**
     * Devolve a CP.
     *
     * @return CP
     */
    CP getCP();

    /**
     * Modifica a CP.
     * 
     * @param cp Nova CP
     */
    void setCP(CP cp);

    /**
     * Cria uma instância de CP com uma lista de revisores vazia.
     *
     * @return CP
     */
    CP novaCP();

    /**
     * Adiciona uma CP.
     *
     * @param cp CP a adicionar.
     * @return True caso a CP tenha sido adicionado e falso se a adição falhar.
     */
    boolean adicionarCP(CP cp);

}
