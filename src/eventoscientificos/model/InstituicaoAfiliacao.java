package eventoscientificos.model;

/**
 * Representa uma instância de Instituicao de Afiliacao através do nome.
 * 
 * @author G01
 */
public class InstituicaoAfiliacao {
    
    /**
     * Nome da instituicao de afiliacao.
     */
    private String nome;
    
    /**
     * Constrói uma instância de uma instituição de afiliação recebendo o nome.
     * 
     * @param nome  Nome da instituição de afiliação.
     */
    public InstituicaoAfiliacao(String nome) {
        setNomeInstituicaoAfiliacao(nome);
    }
    
    /**
     * Devolve o nome da instituicao de afiliacao.
     * 
     * @return Nome da instituicao de afiliacao.
     */
    public String getNomeInstituicaoAfiliacao() {
        return this.nome;
    }
    
     /**
     * Modifica o nome da instituição de afiliação.
     *
     * @param nome Novo nome da instituição de afiliação.
     */
    public void setNomeInstituicaoAfiliacao(String nome) {
        if(nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da instituição de "
                    + "afiliação não pode estar vazio");
        }
        this.nome = nome;
    }
    
    /**
     * Verifica se o nome da instituição de afiliação 
     * @return Verdadeiro
     */
    public boolean validarInstituicaoAfiliacao() {
        return true;
    }
    
    /**
     * Devolve a descrição textual da instituiçao de afiliação no formato: nome.
     * 
     * @return Caracteristicas da instituição de afiliação.
     */
    @Override
    public String toString() {
        return String.format("%s", this.getNomeInstituicaoAfiliacao());
    }
    
}
