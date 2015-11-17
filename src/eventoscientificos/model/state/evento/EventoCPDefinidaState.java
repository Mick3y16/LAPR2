package eventoscientificos.model.state.evento;

import eventoscientificos.model.Evento;
import utils.Data;

/**
 * Representa uma instância de EventoCPDefinidaState tendo acesso ao respetivo
 * Evento através do objeto Evento que tem como atributo.
 *
 * @author G01
 */
public class EventoCPDefinidaState implements EventoState {

    private Evento e;

    /**
     * Instancia de Evento
     */
    /**
     * Constroi uma instância de EventoCPDefinidaState recebendo um Evento como
     * parametro.
     *
     * @param evento evento
     */
    public EventoCPDefinidaState(Evento evento) {
        this.e = evento;
    }

    /**
     * Modifica o estado do evento para o estado Evento Criado
     *
     * @return falso visto ja se encontrar num estado mais avançado
     */
    @Override
    public boolean setCriado() {
        return false;
    }

    /**
     * Modifica o estado do evento para o estado Evento Registado
     *
     * @return falso visto ja se encontrar num estado mais avançado
     */
    @Override
    public boolean setRegistado() {
        return false;
    }

    /**
     * Modifica o estado do evento para o estado Evento Sessoes Tematicas
     * Definidas
     *
     * @return falso visto ja se encontrar num estado mais avançado
     */
    @Override
    public boolean setSessoesTematicasDefinidas() {
        return false;
    }

    /**
     * Modifica o estado do evento para o estado Evento CP definida
     *
     * @return verdadeiro pois corresponde ao estado atual
     */
    @Override
    public boolean setCPDefinida() {
        return true;
    }

    /**
     * Modifica o estado do evento para o estado Evento Em Submissao
     *
     * @return verdadeiro se poder mudar para o estado em submissao e falso se
     * nao cumprir as condicoes necessarias de mudanca de estado
     */
    @Override
    public boolean setEmSubmissao() {
        if (validarEstado()) {
            e.setEstado(new EventoEmSubmissaoState(e));
            return true;
        }
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
     * @return verdadeiro se puder passar de estado e falso se nao cumprir as
     * condicoes necessarias de mudanca de estado
     */
    @Override
    public boolean validarEstado() {
        return Data.dataAtual().isMaior(e.getDataInicioSubmissao());
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
