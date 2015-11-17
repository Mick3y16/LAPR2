package eventoscientificos.model.state.sessaotematica;

import eventoscientificos.model.SessaoTematica;

/**
 * Representa uma instância de SessaoTematicaEmCameraReadyState atráves de uma 
 SessãoTemática.
 *
 * @author G01
 */
public class SessaoTematicaEmCameraReadyState implements SessaoTematicaState {

    /**
     * Sessão Temática que adota o estado.
     */
    private SessaoTematica sessaoTematica;

    /**
     * Constrói uma instância de SessaoTematicaEmCameraReadyState recebendo uma 
     * Sessão Temática.
     * 
     * @param sessaoTematica Sessão Temática que adota o estado. 
     */
    public SessaoTematicaEmCameraReadyState(
            SessaoTematica sessaoTematica) {
        this.sessaoTematica = sessaoTematica;
    }

    /**
     * Método que permite a mudança de estado para Criada.
     *
     * @return Falso, não deve ser possível mudar de EmCameraReady para
     * Criada.
     */
    @Override
    public boolean setCriada() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para Registada.
     *
     * @return Falso, não deve ser possível mudar de EmCameraReady para 
     * Registada.
     */
    @Override
    public boolean setRegistada() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para CPDefinida.
     *
     * @return Falso, não deve ser possível mudar de EmCameraReady para
     * CPDefinida.
     */
    @Override
    public boolean setCPDefinida() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para EmSubmissao.
     *
     * @return Falso, não deve ser possível mudar de EmCameraReady para
     * EmSubmissao.
     */
    @Override
    public boolean setEmSubmissao() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para EmDetecao.
     *
     * @return Falso, não deve ser possível mudar de EmCameraReady para 
     * EmDetecao.
     */
    @Override
    public boolean setEmDetecao() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para EmLicitacao.
     *
     * @return Falso, não deve ser possível mudar de EmCameraReady para 
     * EmLicitacao.
     */
    @Override
    public boolean setEmLicitacao() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para EmDistribuicao.
     *
     * @return Falso, não deve ser possível mudar de EmCameraReady para 
     * EmDistribuicao.
     */
    @Override
    public boolean setEmDistribuicao() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para EmRevisão.
     *
     * @return Falso, não deve ser possível mudar de EmCameraReady para 
     * EmRevisao.
     */
    @Override
    public boolean setEmRevisao() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para FaseDecisao.
     *
     * @return Falso, não deve ser possível mudar de EmCameraReady para 
     * FaseDecisao.
     */
    @Override
    public boolean setFaseDecisao() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para EmSubmissaoCameraReady.
     *
     * @return Falso, não deve ser possível mudar de EmCameraReady para 
     * EmSubmissaoCameraReady.
     */
    @Override
    public boolean setEmSubmissaoCameraReady() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para CameraReady.
     *
     * @return Verdadeiro, a sessão temática encontra-se neste estado.
     */
    @Override
    public boolean setCameraReady() {
        return true;
    }

    /**
     * Método que permite validar uma tentativa de mudança de estado.
     *
     * @return Verdadeiro se a mudança for possível e falso caso não seja.
     */
    @Override
    public boolean validarEstado() {
        return true;
    }
    /**
     * Valida se o evento se encontra num estado válido para ser removido
     *
     * @return verdadeiro se estiver no estado correto e falso se não estiver
     */
    @Override
    public boolean isStateValidoParaRemover() {
        return (!(setCriada() || setRegistada()|| setCPDefinida()|| setCameraReady()));
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
