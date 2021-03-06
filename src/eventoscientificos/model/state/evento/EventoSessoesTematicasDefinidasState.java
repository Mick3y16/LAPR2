package eventoscientificos.model.state.evento;

import eventoscientificos.model.Evento;
import utils.Data;

/**
 * Representa uma instância de EventoSessoesTematicasDefinidasState tendo acesso
 * ao respetivo * Evento através do objeto Evento que tem como atributo.
 *
 * @author G01
 */
public class EventoSessoesTematicasDefinidasState implements EventoState {

    /**
     * Instancia de Evento
     */
    private Evento e;

    /**
     * Constroi uma instância de EventoSessoesTematicasDefinidasState recebendo
     * um Evento como parametro.
     *
     * @param e evento em questão
     */
    public EventoSessoesTematicasDefinidasState(Evento e) {
        this.e = e;
    }

    /**
     * Modifica o estado do evento para o estado Evento Criado
     *
     * @return falso visto ja se encontrar num estado avançado
     */
    @Override
    public boolean setCriado() {
        return false;
    }

    /**
     * Modifica o estado do evento para o estado Evento Registado
     *
     * @return falso visto ja se encontrar num estado avançado
     */
    @Override
    public boolean setRegistado() {
        return false;
    }

    /**
     * Modifica o estado do evento para o estado Evento Sessoes Tematicas
     * Definidas
     *
     * @return verdadeiro pois corresponde ao estado atual
     *
     */
    @Override
    public boolean setSessoesTematicasDefinidas() {
        return true;
    }

    /**
     * Modifica o estado do evento para o estado Evento CP definida
     *
     * @return verdadeiro se mudou de estado e falso se nao mudou de estado
     */
    @Override
    public boolean setCPDefinida() {
        if (validarEstado()) {
            e.setEstado(new EventoCPDefinidaState(this.e));
            return true;
        }
        return false;

    }

    /**
     * Modifica o estado do evento para o estado Evento Em Submissao
     *
     * @return falso visto ja se encontrar num estado anterior
     */
    @Override
    public boolean setEmSubmissao() {
        return false;

    }

    /**
     * Modifica o estado do evento para o estado Evento Em Detecao
     *
     * @return falso visto ja se encontrar num estado anterior
     */
    @Override
    public boolean setEmDetecao() {
        return false;

    }

    /**
     * Modifica o estado do evento para o estado Evento Em Licitacao
     *
     * @return falso visto ja se encontrar num estado anterior
     */
    @Override
    public boolean setEmLicitacao() {
        return false;

    }

    /**
     * Modifica o estado do evento para o estado Evento Em Distribuicao
     *
     * @return falso visto ja se encontrar num estado anterior
     */
    @Override
    public boolean setEmDistribuicao() {
        return false;

    }

    /**
     * Modifica o estado do evento para o estado Evento Em Revisao
     *
     * @return falso visto ja se encontrar num estado anterior
     */
    @Override
    public boolean setEmRevisao() {
        return false;

    }

    /**
     * Modifica o estado do evento para o estado Evento Em Fase de Decisao
     *
     * @return falso visto ja se encontrar num estado anterior
     */
    @Override
    public boolean setFaseDecisao() {
        return false;

    }

    /**
     * Modifica o estado do evento para o estado Evento Em Submissao Camera
     * Ready
     *
     * @return falso visto ja se encontrar num estado anterior
     */
    @Override
    public boolean setEmSubmissaoCameraReady() {
        return false;

    }

    /**
     * Modifica o estado do evento para o estado Evento Camera Ready
     *
     * @return falso visto ja se encontrar num estado anterior
     */
    @Override
    public boolean setCameraReady() {
        return false;

    }

    /**
     * validarEstado se cumpre as condicoes necessarias para efetuar a mudanca
     * de estado pretendida
     *
     * @return verdadeiro se poder passar de estado e falso se nao cumprir as
     * condicoes necessarias de mudanca de estado
     */
    @Override
    public boolean validarEstado() {
        return e.getCP() != null;
    }

    /**
     * Valida se o evento se encontra num estado válido para ser removido
     *
     * @return verdadeiro se estiver no estado correto e falso se não estiver
     */
    @Override
    public boolean isStateValidoParaRemover() {
        return (!(setCriado() || setRegistado() || setSessoesTematicasDefinidas() || setCPDefinida() || setCameraReady()));

    }

    /**
     * Valida se o evento se encontra num estado válido para submeter artigos
     *
     * @return verdadeiro se estiver no estado correto e falso se não estiver
     */
    @Override
    public boolean isStateValidoParaSubmeter() {
              return setEmSubmissao();

    }

    /**
     * Valida se o evento se encontra num estado válido para efetuar alterações
     * nos artigos
     *
     * @return verdadeiro se estiver no estado correto e falso se não estiver
     */
    @Override
    public boolean isStateValidoParaAlterar() {
               return setEmSubmissao();

    }

    /**
     * Valida se o evento se encontra num estado válido para os revisores
     * licitarem as artigos
     *
     * @return verdadeiro se estiver no estado correto e falso se não estiver
     */
    @Override
    public boolean isStateValidoParaLicitar() {
        return setEmLicitacao();
    }

    /**
     * Valida se o evento se encontra num estado válido para distribuir revisões
     *
     * @return verdadeiro se estiver no estado correto e falso se não estiver
     */
    @Override
    public boolean isStateValidoParaDistribuir() {
        return setEmDistribuicao();
    }

}
