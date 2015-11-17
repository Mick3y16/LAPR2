package eventoscientificos.model;

/**
 * Todas as classes que implementam esta interface, herdam a responsabilidade de
 * decidir as submissões do decidivel pelos revisores da CP, segundo
 * diferentes critérios.
 * 
 * @author G01
 */
public interface MecanismoDecisao {
    
    /**
     * Classifica submissões.
     * @param listaRevisoes lista revisões
     * @return lista de decisões
     */
    public ListaDecisoes classificarSubmissoes (ListaRevisoes listaRevisoes);
    
}
