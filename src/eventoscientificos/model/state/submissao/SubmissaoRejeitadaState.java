package eventoscientificos.model.state.submissao;

import eventoscientificos.model.Submissao;

/**
 * Representa uma instância de SubmissaoRejeitadaState através de uma submissão.
 *
 * @author G01
 */
public class SubmissaoRejeitadaState implements SubmissaoState {

    /**
     * Submissao que adota o estado.
     */
    private Submissao submissao;

    /**
     * Constroi uma instância de SubmissaoRejeitadaState recebendo uma Submissao
     *
     * @param submissao Submissao que adota o estado.
     */
    public SubmissaoRejeitadaState(Submissao submissao) {
        this.submissao = submissao;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Criada
     *
     * @return Falso, não deve ser possível mudar de Rejeitada para Criada.
     */
    @Override
    public boolean setCriada() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Em Submissão.
     *
     * @return Falso, não deve ser possível mudar de Rejeitada para EmSubmissao.
     */
    @Override
    public boolean setEmSubmissao() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Em Licitacao.
     *
     * @return Falso, não deve ser possível mudar de Rejeitada para EmLicitacao.
     */
    @Override
    public boolean setEmLicitacao() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Em Revisão.
     *
     * @return Falso, não deve ser possível mudar de Rejeitada para EmRevisão.
     */
    @Override
    public boolean setEmRevisao() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Revista.
     *
     * @return Falso, não deve ser possível mudar de Rejeitada para Revista.
     */
    @Override
    public boolean setRevista() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Aceite.
     *
     * @return Falso, não deve ser possível mudar de Rejeitada para Aceite.
     */
    @Override
    public boolean setAceite() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Rejeitada.
     *
     * @return Verdadeiro, a submissão encontra-se neste estado.
     */
    @Override
    public boolean setRejeitada() {
        return true;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão EmCameraReady.
     *
     * @return Falso, não deve ser possível mudar de Rejeitada para EmCameraReady.
     */
    @Override
    public boolean setEmCameraReady() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão SemArtigoFinal.
     *
     * @return Falso, não deve ser possível mudar de Rejeitada para SemArtigoFinal.
     */
    @Override
    public boolean setSemArtigoFinal() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Removida.
     *
     * @return Falso, não deve ser possível mudar de Rejeitada para Removida.
     */
    @Override
    public boolean setRemovida() {
        return false;
    }

    /**
     * valida se cumpre as condicoes necessarias para efetuar a mudanca de
     * estado pretendida
     *
     * @return verdadeiro se poder passar de estado e falso se nao cumprir as
     * condicoes necessarias de mudanca de estado
     */
    @Override
    public boolean validarEstado() {
        return true;
    }

}
