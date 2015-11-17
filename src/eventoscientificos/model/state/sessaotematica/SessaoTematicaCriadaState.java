package eventoscientificos.model.state.sessaotematica;

import eventoscientificos.model.SessaoTematica;

/**
 * Representa uma instância de SessaoTematicaCriadaState através de uma sessão
 * temática.
 *
 * @author G01
 */
public class SessaoTematicaCriadaState implements SessaoTematicaState {

    /**
     * Sessão temática que adota o estado.
     */
    private SessaoTematica sessaoTematica;

    /**
     * Constrói uma instância de SessaoTematicaCriadaState recebendo uma sessão
     * temática.
     *
     * @param sessaoTematica Sessão Temática que adota o estado.
     */
    public SessaoTematicaCriadaState(SessaoTematica sessaoTematica) {
        this.sessaoTematica = sessaoTematica;
    }

    /**
     * Método que permite a mudança de estado para Criada.
     *
     * @return Verdadeiro, a sessão temática encontra-se neste estado.
     */
    @Override
    public boolean setCriada() {
        return true;
    }

    /**
     * Método que permite a mudança de estado para CPDefinida.
     *
     * @return Verdadeiro se for possivel alterar o estado para Registada e
     * falso caso não seja.
     */
    @Override
    public boolean setRegistada() {
        if (validarEstado()) {
            this.sessaoTematica.setEstado(
                    new SessaoTematicaRegistadaState(this.sessaoTematica));
            return true;
        }

        return false;
    }

    /**
     * Método que permite a mudança de estado para CPDefinida.
     *
     * @return Falso, não deve ser possível mudar de Criada para CPDefinida.
     */
    @Override
    public boolean setCPDefinida() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para EmSubmissao.
     *
     * @return Falso, não deve ser possível mudar de Criada para EmSubmissao.
     */
    @Override
    public boolean setEmSubmissao() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para EmDetecao.
     *
     * @return Falso, não deve ser possível mudar de Criada para EmDetecao.
     */
    @Override
    public boolean setEmDetecao() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para EmLicitacao.
     *
     * @return Falso, não deve ser possível mudar de Criada para EmLicitacao.
     */
    @Override
    public boolean setEmLicitacao() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para EmDistribuicao.
     *
     * @return Falso, não deve ser possível mudar de Criada para EmDistribuicao.
     */
    @Override
    public boolean setEmDistribuicao() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para EmRevisão.
     *
     * @return Falso, não deve ser possível mudar de Criada para EmRevisão.
     */
    @Override
    public boolean setEmRevisao() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para FaseDecisao.
     *
     * @return Falso, não deve ser possível mudar de Criada para FaseDecisao.
     */
    @Override
    public boolean setFaseDecisao() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para EmSubmissaoCameraReady.
     *
     * @return Falso, não deve ser possível mudar de Criada para
     * EmSubmissaoCameraReady.
     */
    @Override
    public boolean setEmSubmissaoCameraReady() {
        return false;
    }

    /**
     * Método que permite a mudança de estado para CameraReady.
     *
     * @return Falso, não deve ser possível mudar de Criada para CameraReady.
     */
    @Override
    public boolean setCameraReady() {
        return false;
    }

    /**
     * Método que permite validar uma tentativa de mudança de estado.
     *
     * @return Verdadeiro se a mudança for possível e falso caso não seja..
     */
    @Override
    public boolean validarEstado() {
        if (this.sessaoTematica.getDataInicioSubmissao().isMaior(
                this.sessaoTematica.getDataFimSubmissao())) {
            throw new IllegalArgumentException("A data de fim de submissão não "
                    + "pode ser menor que a data de inicio de submissão.");
        }

        if (this.sessaoTematica.getDataFimSubmissao().isMaior(
                this.sessaoTematica.getDataInicioDistribuicao())) {
            throw new IllegalArgumentException("A data de inicio de distribuição"
                    + " não pode ser menor que a data de fim de submissão.");
        }

        if (this.sessaoTematica.getDataInicioDistribuicao().isMaior(
                this.sessaoTematica.getDataFimRevisao())) {
            throw new IllegalArgumentException("A data de fim de revisão "
                    + "não pode ser menor que a data de início de distribuição.");
        }

        if (this.sessaoTematica.getDataFimRevisao().isMaior(
                this.sessaoTematica.getDataFimSubmissaoCameraReady())) {
            throw new IllegalArgumentException("A data de fim de submissão "
                    + "CameraReady não pode ser menor que a data de fim de "
                    + "revisão.");
        }

        if (this.sessaoTematica.getDataFimSubmissaoCameraReady().isMaior(
                this.sessaoTematica.getDataInicio())) {
            throw new IllegalArgumentException("A data de início não pode ser"
                    + "menor que a data de submissão CameraReady.");
        }

        if (this.sessaoTematica.getDataInicio().isMaior(
                this.sessaoTematica.getDataFim())) {
            throw new IllegalArgumentException("A data de fim não pode ser menor"
                    + " que a data de inicio.");
        }

        if (!this.sessaoTematica.temProponentes()) {
            throw new IllegalArgumentException("Deve introduzir pelo menos um"
                    + "proponente.");
        }

        return true;
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
