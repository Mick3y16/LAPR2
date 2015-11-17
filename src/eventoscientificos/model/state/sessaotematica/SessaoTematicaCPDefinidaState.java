package eventoscientificos.model.state.sessaotematica;

import eventoscientificos.model.SessaoTematica;
import utils.Data;

/**
 * Representa uma instância de SessaoTematicaCPDefinidaState através de uma
 * Sessão Temática.
 *
 * @author G01
 */
public class SessaoTematicaCPDefinidaState implements SessaoTematicaState {

    /**
     * Sessão Temática que adota o estado.
     */
    private SessaoTematica sessaoTematica;

    /**
     * Constrói uma instância de SessaoTematicaCPDefinidaState recebendo uma
     * Sessão Temática.
     *
     * @param sessaoTematica Sessão Temática que adota o estado.
     */
    public SessaoTematicaCPDefinidaState(SessaoTematica sessaoTematica) {
        this.sessaoTematica = sessaoTematica;
    }

    /**
     * Método que permite a mudança de estado para Criada.
     *
     * @return Falso, não deve ser possível mudar de CPDefinida para Criada.
     */
    @Override
    public boolean setCriada() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para CPDefinida.
     *
     * @return Falso, não deve ser possível mudar de CPDefinida para Registada.
     */
    @Override
    public boolean setRegistada() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para CPDefinida.
     *
     * @return Verdadeiro, a sessão temática encontra-se neste estado.
     */
    @Override
    public boolean setCPDefinida() {
        return true;
    }

    /**
     * Método que permite a mudança de estado para EmSubmissao.
     *
     * @return Verdadeiro se for possivel alterar o estado para EmSubmisao e
     * falso caso não seja.
     */
    @Override
    public boolean setEmSubmissao() {
        if (validarEstado()) {
            this.sessaoTematica.setEstado(
                                new SessaoTematicaEmSubmissaoState(this.sessaoTematica));
            return true;
        }

        return false;
    }

    /**
     * Método que permite a mudança de estado para EmDetecao.
     *
     * @return Falso, não deve ser possível mudar de CPDefinida para EmDetecao.
     */
    @Override
    public boolean setEmDetecao() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para EmLicitacao.
     *
     * @return Falso, não deve ser possível mudar de CPDefinida para
     * EmLicitacao.
     */
    @Override
    public boolean setEmLicitacao() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para EmDistribuicao.
     *
     * @return Falso, não deve ser possível mudar de CPDefinida para
     * EmDistribuicao.
     */
    @Override
    public boolean setEmDistribuicao() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para EmRevisão.
     *
     * @return Falso, não deve ser possível mudar de CPDefinida para EmRevisão.
     */
    @Override
    public boolean setEmRevisao() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para FaseDecisao.
     *
     * @return Falso, não deve ser possível mudar de CPDefinida para
     * FaseDecisao.
     */
    @Override
    public boolean setFaseDecisao() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para EmSubmissaoCameraReady.
     *
     * @return Falso, não deve ser possível mudar de CPDefinida para
     * EmSubmissaoCameraReady.
     */
    @Override
    public boolean setEmSubmissaoCameraReady() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para CameraReady.
     *
     * @return Falso, não deve ser possível mudar de CPDefinida para
     * CameraReady.
     */
    @Override
    public boolean setCameraReady() {
        return false;
    }

    /**
     * Método que permite validar uma tentativa de mudança de estado.
     *
     * @return Verdadeiro se a mudança for possível e falso caso não seja.
     */
    @Override
    public boolean validarEstado() {
        return Data.dataAtual().isMaior(
                            this.sessaoTematica.getDataInicioSubmissao());
    }

    /**
     * Valida se o evento se encontra num estado válido para ser removido
     *
     * @return verdadeiro se estiver no estado correto e falso se não estiver
     */
    @Override
    public boolean isStateValidoParaRemover() {
        return (!(setCriada() || setRegistada() || setCPDefinida() || setCameraReady()));
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
