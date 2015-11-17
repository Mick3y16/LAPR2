package eventoscientificos.model.mecanismo.detecao;

import eventoscientificos.model.Conflito;
import eventoscientificos.model.ListaConflitos;
import eventoscientificos.model.Revisor;
import eventoscientificos.model.Submissao;
import eventoscientificos.model.TipoConflito;

/**
 * Constrói uma instância de MecanismoDetecao1 que verifica se o revisor é autor
 * de uma submissão.
 *
 * @author G01
 */
public class MecanismoDetecao1 implements MecanismoDetecao {

    /**
     * Constrói uma instância de MecanismoDetecao1.
     */
    public MecanismoDetecao1() {
    }

    /**
     * Deteta um conflito entre um revisor e uma submissão da forma indicada.
     *
     * @return Verdadeiro se encontrar um conflito e falso caso não encontre.
     */
    @Override
    public boolean detetarConflito(ListaConflitos listaConflitos, Revisor revisor,
            Submissao submissao, TipoConflito tipoConflito) {
        if (submissao.isAutorArtigo(revisor.getUtilizador())) {
            Conflito conflito = listaConflitos.validarExistenciaConflito(
                    revisor, submissao);

            if (conflito != null) {
                conflito.adicionarTipoConflito(tipoConflito);
            } else {
                listaConflitos.adicionarConflito(
                        listaConflitos.novoConflito(
                                revisor, submissao, tipoConflito));
            }

            return true;
        }

        return false;
    }

}
