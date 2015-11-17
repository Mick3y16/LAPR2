package eventoscientificos.model.state.submissao;

import eventoscientificos.model.Submissao;

/**
 * @author G01
 */
public class SubmissaoSemArtigoFinalState implements SubmissaoState {

    /**
     * Submissao que adota o estado.
     */
    private Submissao submissao;

    /**
     * Constroi uma instância de SubmissaoSemArtigoFinalState recebendo uma
     * Submissao
     *
     * @param submissao Submissao que adota o estado.
     */
    public SubmissaoSemArtigoFinalState(Submissao submissao) {
        this.submissao = submissao;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Criada
     *
     * @return Falso, não deve ser possível mudar de SemArtigoFinal para Criada.
     */
    @Override
    public boolean setCriada() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Em Submissão.
     *
     * @return Falso, não deve ser possível mudar de SemArtigoFinal para EmSubmissao.
     */
    @Override
    public boolean setEmSubmissao() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Em Licitacao.
     *
     * @return Falso, não deve ser possível mudar de SemArtigoFinal para EmLicitacao.
     */
    @Override
    public boolean setEmLicitacao() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Em Revisão.
     *
     * @return Falso, não deve ser possível mudar de SemArtigoFinal para EmRevisão.
     */
    @Override
    public boolean setEmRevisao() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Revista.
     *
     * @return Falso, não deve ser possível mudar de SemArtigoFinal para Revista.
     */
    @Override
    public boolean setRevista() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Aceite.
     *
     * @return Falso, não deve ser possível mudar de SemArtigoFinal para Aceite.
     */
    @Override
    public boolean setAceite() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Rejeitada.
     *
     * @return Falso, não deve ser possível mudar de SemArtigoFinal para Rejeitada.
     */
    @Override
    public boolean setRejeitada() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão EmCameraReady.
     *
     * @return Falso, não deve ser possível mudar de SemArtigoFinal 
     * para EmCameraReady
     */
    @Override
    public boolean setEmCameraReady() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão SemArtigoFinal.
     *
     * @return Verdadeiro, a submissão encontra-se neste estado.
     */
    @Override
    public boolean setSemArtigoFinal() {
        return true;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Removida.
     *
     * @return Falso, não deve ser possível mudar de SemArtigoFinal para Removida.
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
