package eventoscientificos.model.state.sessaotematica;

import eventoscientificos.model.SessaoTematica;
import utils.Data;

/**
 * Representa uma instância de SessaoTematicaEmLicitacaoState atráves de uma
 * SessãoTemática.
 *
 * @author G01
 */
public class SessaoTematicaEmLicitacaoState implements SessaoTematicaState {

    /**
     * Sessão Temática que adota o estado.
     */
    private SessaoTematica sessaoTematica;

    /**
     * Constrói uma instância de SessaoTematicaEmLicitacaoState recebendo uma
     * Sessão Temática.
     *
     * @param sessaoTematica Sessão Temática que adota o estado.
     */
    public SessaoTematicaEmLicitacaoState(SessaoTematica sessaoTematica) {
        this.sessaoTematica = sessaoTematica;
    }

    /**
     * Método que permite a mudança de estado para Criada.
     *
     * @return Falso, não deve ser possível mudar de EmLicitacao para Criada.
     */
    @Override
    public boolean setCriada() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para Registada.
     *
     * @return Falso, não deve ser possível mudar de EmLicitacao para Registada.
     */
    @Override
    public boolean setRegistada() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para CPDefinida.
     *
     * @return Falso, não deve ser possível mudar de EmLicitacao para Criada.
     */
    @Override
    public boolean setCPDefinida() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para EmSubmissao.
     *
     * @return Falso, não deve ser possível mudar de EmLicitacao para
     * EmSubmissao.
     */
    @Override
    public boolean setEmSubmissao() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para EmDetecao.
     *
     * @return Falso, não deve ser possível mudar de EmLicitacao para EmDetecao.
     */
    @Override
    public boolean setEmDetecao() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para EmLicitacao.
     *
     * @return Verdadeiro, a sessão temática encontra-se neste estado.
     */
    @Override
    public boolean setEmLicitacao() {
        return true;
    }

    /**
     * Método que permite a mudança de estado para EmDistribuicao.
     *
     * @return Verdadeiro se for possivel alterar o estado para EmDetecao e
     * falso caso não seja.
     */
    @Override
    public boolean setEmDistribuicao() {
        if (validarEstado()) {
            this.sessaoTematica.setEstado(
                                new SessaoTematicaEmDistribuicaoState(this.sessaoTematica));
            return true;
        }

        return false;
    }

    /**
     * Método que permite a mudança de estado para EmRevisão.
     *
     * @return Falso, não deve ser possível mudar de EmLicitacao para EmRevisão.
     */
    @Override
    public boolean setEmRevisao() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para FaseDecisao.
     *
     * @return Falso, não deve ser possível mudar de EmLicitacao para
     * FaseDecisao.
     */
    @Override
    public boolean setFaseDecisao() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para EmSubmissaoCameraReady.
     *
     * @return Falso, não deve ser possível mudar de EmLicitacao para
     * EmSubmissaoCameraReady.
     */
    @Override
    public boolean setEmSubmissaoCameraReady() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para CameraReady.
     *
     * @return Falso, não deve ser possível mudar de EmLicitacao para
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
        return Data.dataAtual().isMaior(this.sessaoTematica.getDataInicioDistribuicao());
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
