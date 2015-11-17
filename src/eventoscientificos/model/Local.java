package eventoscientificos.model;

/**
 * @author G01
 */
public class Local {

    /**
     * Nome do local de realização do evento.
     */
    private String nomeLocal;
    
    /**
     * Constrói uma instância de local, recebendo como parâmetro o nome do Local.
     *
     * @param nomeLocal nome do local
     */
    public Local(String nomeLocal) {
        setNomeLocal(nomeLocal);
    }

    /**
     * Devolve o nome do local de realização do evento.
     *
     * @return Nome do local de realização do Evento.
     */
    public String getNomeLocal() {
        return this.nomeLocal;
    }

    /**
     * Modifica o nome do local de realização do evento.
     *
     * @param nomeLocal Novo nome do local de realização do evento.
     */
    public void setNomeLocal(String nomeLocal) {
        if (nomeLocal == null || nomeLocal.trim().isEmpty()) {
            throw new NullPointerException("Nome do local não pode estar vazio!");
        }
        this.nomeLocal = nomeLocal;
    }

    /**
     * Devolve a descrição textual do nome do local no formato: O nome do local 
     * de realização do Evento é x.
     * 
     * @return Nome do local.
     */
    @Override
    public String toString() {
        return String.format("%s", this.nomeLocal);
    }
    
}
