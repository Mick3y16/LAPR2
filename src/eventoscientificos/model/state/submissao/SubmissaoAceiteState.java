package eventoscientificos.model.state.submissao;

import eventoscientificos.model.Submissao;

/**
 * Representa uma instância de SubmissaoAceiteState através de uma submissão.
 *
 * @author G01
 */
public class SubmissaoAceiteState implements SubmissaoState {

    /**
     * Submissao que adota o estado.
     */
    private Submissao submissao;

    /**
     * Constroi uma instância de SubmissaoAceiteState recebendo uma Submissao
     *
     * @param submissao Submissao que adota o estado.
     */
    public SubmissaoAceiteState(Submissao submissao) {
        this.submissao = submissao;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Criada
     *
     * @return Falso, não deve ser possível mudar de Aceite para Criada.
     */
    @Override
    public boolean setCriada() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Em Submissão.
     *
     * @return Falso, não deve ser possível mudar de Aceite para EmSubmissao.
     */
    @Override
    public boolean setEmSubmissao() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Em Licitacao.
     *
     * @return Falso, não deve ser possível mudar de Aceite para EmLicitacao.
     */
    @Override
    public boolean setEmLicitacao() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Em Revisão.
     *
     * @return Falso, não deve ser possível mudar de Aceite para EmRevisão.
     */
    @Override
    public boolean setEmRevisao() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Revista.
     *
     * @return Falso, não deve ser possível mudar de Aceite para Revista.
     */
    @Override
    public boolean setRevista() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Aceite.
     *
     * @return Verdadeiro, a submissão encontra-se neste estado.
     */
    @Override
    public boolean setAceite() {
        return true;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Rejeitada.
     *
     * @return Falso, não deve ser possível mudar de Aceite para Rejeitada.
     */
    @Override
    public boolean setRejeitada() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão EmCameraReady.
     *
     * @return Verdadeiro se for possivel alterar o estado para EmCameraReady e
     * falso caso não seja.
     */
    @Override
    public boolean setEmCameraReady() {
        if (validarEstado()) {
            this.submissao.setEstado(
                                new SubmissaoEmCameraReadyState(this.submissao));
            return true;
        }
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão SemArtigoFinal.
     *
     * @return Verdadeiro se for possivel alterar o estado para SemArtigoFinal e
     * falso caso não seja.
     */
    @Override
    public boolean setSemArtigoFinal() {
        if (!validarEstado()) {
            this.submissao.setEstado(
                                new SubmissaoSemArtigoFinalState(this.submissao));
            return true;
        }
        
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Removida.
     *
     * @return verdadeiro, deve ser possível mudar de Aceite para Removida.
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
     * @return Verdadeiro se for possivel alterar o estado para EmCameraReady e
     * falso se não for, neste caso muda para SemArtigoFinal.
     */
    @Override
    public boolean validarEstado() {
        return this.submissao.getArtigoFinal() != null;
    }
}
