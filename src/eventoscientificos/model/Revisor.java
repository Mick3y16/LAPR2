package eventoscientificos.model;

/**
 * Representa uma instância de um revisor através de um utilizador registado.
 *
 * @author G01
 */
public class Revisor {

    /**
     * Utilizador que é revisor.
     */
    private Utilizador utilizador;

    /**
     * Constrói uma instância de um revisor recebendo o utilizador que assume o
     * papel.
     *
     * @param utilizador Utilizador que assume o papel de revisor.
     */
    public Revisor(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    /**
     * Devolve o utilizador que assume o papel de revisor.
     *
     * @return utilizador
     */
    public Utilizador getUtilizador() {
        return this.utilizador;
    }

    /**
     * Valida um revisor de forma a garantir que o mesmo possui os dados
     * corretos.
     *
     * @return Verdadeiro se possuir os dados corretos e falso caso não possua.
     */
    public boolean validarRevisor() {
        if (this.utilizador == null) {
            throw new NullPointerException("O utilizador não pode estar vazio");
        }

        return true;
    }

    /**
     * Devolve a descrição textual do revisor no formato: nome (email)
     *
     * @return Características do revisor.
     */
    public String toString() {
        return String.format("%s (%s)",
                this.getUtilizador().getNome(),
                this.getUtilizador().getEmail());
    }

    /**
     * Compara dois objetos entre si. Comparando primariamente a posição de
     * memória, seguida do conteudo e das classes as quais cada um deles
     * pertence, e finalmente o utilizador que assume o papel de revisor em cada
     * um deles.
     *
     * @param outroObjeto Revisor que vai ser usado na comparação.
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

        Revisor outroRevisor = (Revisor) outroObjeto;

        return this.utilizador.equals(outroRevisor.utilizador);
    }

}
