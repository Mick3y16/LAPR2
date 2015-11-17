package eventoscientificos.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma instância de RegistoTiposConflito através de uma lista de
 * tipos de conflito.
 *
 * @author G01
 */
public class RegistoTiposConflito {

    /**
     * Lista de tipos de conflito.
     */
    private List<TipoConflito> listaTiposConflito;

    /**
     * Constrói uma instância de RegistoTiposConflito com uma lista de tipos de
     * conflito vazia.
     */
    public RegistoTiposConflito() {
        this.listaTiposConflito = new ArrayList();
    }

    /**
     * Compara dois objetos entre si. Comparando primariamente a posição de
     * memória, seguida do conteudo e das classes as quais cada um deles
     * pertence, e finalmente os seus atributos, lista de tipos de conflito.
     *
     * @param outroObjeto RegistoTiposConflito que vai ser usado na comparação.
     * @return Verdadeiro caso os objetos comparados sejam iguais e falso caso
     * não o sejam.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }

        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }

        RegistoTiposConflito outroRegistoTiposConflito
                = (RegistoTiposConflito) outroObjeto;

        return this.listaTiposConflito.equals(
                outroRegistoTiposConflito.listaTiposConflito);
    }

    /**
     * Devolve uma lista de tipos de conflito com mecanismo de deteção
     * associado.
     *
     * @return Lista de tipos de conflito com mecanismo de deteção associado.
     */
    public List<TipoConflito> getListaTiposConflitoComMecanismo() {
        List<TipoConflito> listaTiposConflitoComMecanismo = new ArrayList();

        for (TipoConflito tipoConflito : this.listaTiposConflito) {
            if (tipoConflito.temMecanismo()) {
                listaTiposConflitoComMecanismo.add(tipoConflito);
            }
        }

        return listaTiposConflitoComMecanismo;
    }

    /**
     * Cria e valida uma instância de tipo de conflito recebendo uma descrição.
     *
     * @param descricao Descrição do tipo de conflito.
     * @return Tipo de conflito.
     */
    public TipoConflito novoTipoConflito(String descricao) {
        TipoConflito tipoConflito = new TipoConflito(descricao);

        if (!tipoConflito.validarTipoConflito()) {
            throw new IllegalArgumentException(
                    "O tipo de conflito não é válido.");
        }

        if (!validarTipoConflito(tipoConflito)) {
            throw new IllegalArgumentException(
                    "O tipo de conflito já se encontra definido.");
        }

        return new TipoConflito(descricao);
    }

    /**
     * Verifica se um determinado tipo de conflito já se encontra definido ou
     * não.
     *
     * @param tipoConflito Tipo de conflito que vai ser definido.
     * @return Verdadeiro se ainda não tiver sido definido e falso, se já tiver.
     */
    private boolean validarTipoConflito(TipoConflito tipoConflito) {
        return !this.listaTiposConflito.contains(tipoConflito);
    }

    /**
     * Adiciona um tipo de conflito à lista de conflitos.
     *
     * @param tipoConflito Tipo de conflito que vai ser adicionado.
     * @return Verdadeiro se for possível adicionar o conflito e falso caso não
     * seja.
     */
    public boolean adicionarTipoConflito(TipoConflito tipoConflito) {
        return this.listaTiposConflito.add(tipoConflito);
    }

}
