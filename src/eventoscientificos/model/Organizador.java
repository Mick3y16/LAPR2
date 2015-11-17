package eventoscientificos.model;

/**
 *
 * @author G01
 */
public class Organizador {

    /**
     * Utilizador que assume o papel de organizador.
     */
    private Utilizador utilizador;

    /**
     * Constrói uma instância de um organizador recebendo o utilizador que
     * assume o papel.
     *
     * @param utilizador Utilizador que assume o papel de organizador.
     */
    public Organizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    /**
     * Devolve o utilizador que assume o papel de organizador.
     *
     * @return Utilizador que assume o papel de organizador.
     */
    public Utilizador getUtilizador() {
        return this.utilizador;
    }

    /**
     * Devolve a descrição textual do organizador no formato: nome (email)
     *
     * @return Características do organizador.
     */
    @Override
    public String toString() {
        return String.format("%s (%s)",
                this.getUtilizador().getNome(),
                this.getUtilizador().getEmail());
    }

    /*
     * Compara dois objetos entre si. Comparando primariamente a posição de 
     * memória, seguida do conteudo e das classes as quais cada um deles 
     * pertence, e finalmente o utilizador que assume o papel de organizador em
     * cada um deles. 
     * 
     * @param outroObjeto Organizador que vai ser usado na comparação.
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

        Organizador outroOrganizador = (Organizador) outroObjeto;

        return this.getUtilizador().equals(outroOrganizador.getUtilizador());
    }

    /**
     * Valida um organizador de forma a garantir que o mesmo possui os dados
     * corretos.
     *
     * @return Verdadeiro se possuir os dados corretos e falso caso não possua.
     */
    public boolean validarOrganizador() {
        if (this.utilizador == null) {
            throw new NullPointerException("O utilizador não pode estar vazio");
        }

        return true;
    }

}
