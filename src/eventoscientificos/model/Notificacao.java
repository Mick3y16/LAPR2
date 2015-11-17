package eventoscientificos.model;

/**
 * Representa uma instância de notificação através de uma classificação.
 * 
 * @author G01
 */
public class Notificacao {
    
    /**
     * Classificação
     */
    private int classificacao;

    /**
     * Constrói uma instância de notificação recebendo uma classificação.
     * 
     * @param classificacao Classificação.
     */
    public Notificacao(int classificacao) {
        this.classificacao = classificacao;
    }
}
