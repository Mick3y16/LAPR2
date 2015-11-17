package eventoscientificos.model;

/**
 * Representa uma instância de um proponente através de um utilizador que assume
 * esse papel.
 *
 * @author G01
 */
public class Proponente {

    /**
     * Utilizador que assume o papel de proponente.
     */
    private Utilizador utilizador;

    /**
     * Constrói uma instância de um proponente recebendo o utilizador que assume
     * o papel.
     *
     * @param utilizador Utilizador que assume o papel de proponente.
     */
    public Proponente(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    /**
     * Devolve o utilizador que assume o papel de proponente.
     *
     * @return Utilizador que assume o papel de proponente.
     */
    public Utilizador getUtilizador() {
        return this.utilizador;
    }

    /**
     * Devolve a descrição textual do proponente no formato: nome (email)
     *
     * @return Características do proponente.
     */
    public String toString() {
        return String.format("%s (%s)", 
                this.getUtilizador().getNome(),
                this.getUtilizador().getEmail());
    }

    /*
     * Compara dois objetos entre si. Comparando primariamente a posição de 
     * memória, seguida do conteudo e das classes as quais cada um deles 
     * pertence, e finalmente o utilizador que assume o papel de proponente em
     * cada um deles. 
     * 
     * @param outroObjeto Proponente que vai ser usado na comparação.
     * @return Verdadeiro caso os objetos comparados sejam iguais e falso caso 
     * não o sejam.
     */
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }

        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }

        Proponente outroProponente = (Proponente) outroObjeto;

        return this.getUtilizador().equals(outroProponente.getUtilizador());
    }

    /**
     * Valida um proponente de forma a garantir que o mesmo possui os dados
     * corretos.
     *
     * @return Verdadeiro se possuir os dados corretos e falso caso não possua.
     */
    public boolean validarProponente() {
        if (this.utilizador == null) {
            throw new NullPointerException("O utilizador não pode estar vazio");
        }

        return true;
    }

}
