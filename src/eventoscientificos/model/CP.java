package eventoscientificos.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma instância de CP através de uma lista de revisores.
 *
 * @author G01
 */
public class CP {

    /**
     * Lista de revisores.
     */
    private List<Revisor> listaRevisores;

    /**
     * Contrói uma instância de CP com a lista de revisores vazia.
     */
    public CP() {
        this.listaRevisores = new ArrayList<>();
    }

    /**
     * Compara dois objetos entre si. Comparando primariamente a posição de
     * memória, seguida do conteudo e das classes as quais cada um deles
     * pertence, e finalmente a lista de revisores da CP.
     *
     * @param outroObjeto CP que vai ser usado na comparação.
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

        CP outraCP = (CP) outroObjeto;

        return this.listaRevisores.equals(outraCP.listaRevisores);
    }

    /**
     * Cria um objeto do tipo Revisor através de um utilizador.
     *
     * @param utilizador Utilizador que é revisor.
     * @return Novo revisor.
     */
    public boolean novoRevisor(Utilizador utilizador) {
        Revisor revisor = new Revisor(utilizador);

        if (!revisor.validarRevisor()) {
            throw new IllegalArgumentException("O revisor não existe.");
        }

        if (!validarRevisor(revisor)) {
            throw new IllegalArgumentException("O revisor"
                                + " já se encontra na lista.");
        }

        return adicionarRevisor(revisor);
    }

    /**
     * Adiciona um novo revisor à lista de revisores.
     *
     * @param revisor Revisor a adicionar na lista.
     * @return Retorna verdadeiro caso o revisor tenha sido adicionado à lista e
     * falso se a adição falhar.
     */
    private boolean adicionarRevisor(Revisor revisor) {
        return this.listaRevisores.add(revisor);
    }

    /**
     * Verifica se o revisor já existe na lista de revisores.
     *
     * @param revisor Revisor a verificar na lista.
     * @return Retorna verdadeiro caso o revisor não exista na lista e false
     * caso exista.
     */
    private boolean validarRevisor(Revisor revisor) {
        return !this.listaRevisores.contains(revisor);
    }

    /**
     * Verifica se a lista de revisores está vazia.
     *
     * @return Verdadeiro caso a lista não esteja vazia e false caso esteja
     * vazia.
     */
    public boolean validarCP() {
        return !this.listaRevisores.isEmpty();
    }

    /**
     * Verifica se existe alguma licitação associada ao utilizador
     *
     * @param u utilizador a verificar
     * @return verdadeiro se encontrou a licitação e falso se não encontrar
     */
    public boolean contains(Utilizador u) {
        for (Revisor r : listaRevisores) {
            Utilizador ut = r.getUtilizador();
            if (ut.equals(u)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Devolve um revisor associado ao utilizador recebido por parâmetro
     *
     * @param u utilizador a procurar
     * @return revisor associado ao utilizador
     */
    public Revisor getRevisor(Utilizador u) {
        Revisor r = new Revisor(u);
        int indice = this.listaRevisores.indexOf(r);
        return this.listaRevisores.get(indice);
    }

    /**
     * Devolve o número de revisores existentes na CP.
     *
     * @return Número de revisores existentes na CP.
     */
    public int getNumeroRevisores() {
        return this.listaRevisores.size();
    }

    /**
     * Devolve um revisor pela sua posição na lista de revisores da CP.
     *
     * @param indice Posição do revisor.
     *
     * @return Revisor na posição dada.
     */
    public Revisor getRevisorPeloID(int indice) {
        return this.listaRevisores.get(indice);
    }

    /**
     * Devolve a lista de revisores
     *
     * @return devolve a lista de revisores
     */
    public List<Revisor> getListaRevisores() {
        return listaRevisores;
    }
}
