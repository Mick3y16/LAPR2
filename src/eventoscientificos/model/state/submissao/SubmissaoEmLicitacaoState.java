package eventoscientificos.model.state.submissao;

import eventoscientificos.model.Submissao;

/**
 * Representa uma instância de SubmissaoEmLicitacaoState através de uma
 * submissão
 *
 * @author G01
 */
public class SubmissaoEmLicitacaoState implements SubmissaoState {

    /**
     * Submissao que adota o estado.
     */
    private Submissao submissao;

    /**
     * Constroi uma instância de SubmissaoEmLicitacaoState recebendo uma
     * Submissao
     *
     * @param submissao Submissao que adota o estado.
     */
    public SubmissaoEmLicitacaoState(Submissao submissao) {
        this.submissao = submissao;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Criada
     *
     * @return Falso, não deve ser possível mudar de EmLicitacao para Criada.
     */
    @Override
    public boolean setCriada() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Em Submissão.
     *
     * @return Falso, não deve ser possível mudar de EmLicitacao para EmSubmissao.
     */
    @Override
    public boolean setEmSubmissao() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Em Licitacao.
     *
     * @return Verdadeiro, a submissão encontra-se neste estado.
     */
    @Override
    public boolean setEmLicitacao() {
        return true;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Em Revisão.
     *
     * @return Verdadeiro se for possivel alterar o estado para EmRevisao e
     * falso caso não seja.
     */
    @Override
    public boolean setEmRevisao() {
        if (validarEstado()) {
            this.submissao.setEstado(new SubmissaoEmRevisaoState(this.submissao));
            return true;
        }
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Revista.
     *
     * @return Falso, não deve ser possível mudar de EmLicitacao para Revista.
     */
    @Override
    public boolean setRevista() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Aceite.
     *
     * @return Falso, não deve ser possível mudar de EmLicitacao para Aceite.
     */
    @Override
    public boolean setAceite() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Rejeitada.
     *
     * @return Falso, não deve ser possível mudar de EmLicitacao para Rejeitada.
     */
    @Override
    public boolean setRejeitada() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão EmCameraReady.
     *
     * @return Falso, não deve ser possível mudar de EmLicitacao para EmCameraReady.
     */
    @Override
    public boolean setEmCameraReady() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão SemArtigoFinal.
     *
     * @return Falso, não deve ser possível mudar de EmLicitacao para SemArtigoFinal.
     */
    @Override
    public boolean setSemArtigoFinal() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Removida.
     *
     * @return Verdadeiro, deve ser possível mudar de EmLicitacao para Removida.
     */
    @Override
    public boolean setRemovida() {
        submissao.setEstado(new SubmissaoRemovidaState(submissao));
        return true;
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
