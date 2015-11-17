package eventoscientificos.model.state.submissao;

import eventoscientificos.model.Submissao;

/**
 * Representa uma instância de SubmissaoRevistaState através de uma submissão.
 * 
 * @author G01
 */
public class SubmissaoRevistaState implements SubmissaoState {

    /**
     * Submissao que adota o estado.
     */
    private Submissao submissao;

    /**
     * Constroi uma instância de SubmissaoRevistaState recebendo uma Submissao
     *
     * @param submissao Submissao que adota o estado.
     */
    public SubmissaoRevistaState(Submissao submissao) {
        this.submissao = submissao;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Criada
     * 
     * @return Falso, não deve ser possível mudar de Revista para Criada.
     */
    @Override
    public boolean setCriada() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Em Submissão.
     * 
     * @return Falso, não deve ser possível mudar de Revista para EmSubmissao.
     */
    @Override
    public boolean setEmSubmissao() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão EmLicitação.
     * 
     * @return Falso, não deve ser possível mudar de Revista para Em Licitação.
     */
    @Override
    public boolean setEmLicitacao() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Em Revisão.
     * 
     * @return Falso, não deve ser possível mudar de Revista para EmRevisão.
     */
    @Override
    public boolean setEmRevisao() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Revista
     * 
     * @return Verdadeiro, a submissão encontra-se neste estado.
     */
    @Override
    public boolean setRevista() {
        return true;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Aceite.
     * 
     * @return Verdadeiro se for possivel alterar o estado para Aceite e
     * falso caso não seja.
     */
    @Override
    public boolean setAceite() {
        if (validarEstado()) {
            this.submissao.setEstado(new SubmissaoAceiteState(this.submissao));
            return true;
        }

        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Rejeitada.
     * 
     * @return Verdadeiro se for possivel alterar o estado para Rejeitada e
     * falso caso não seja.
     */
    @Override
    public boolean setRejeitada() {
        if (validarEstado()) {
            this.submissao.setEstado(new SubmissaoRejeitadaState(this.submissao));
            return true;
        }

        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão EmCameraReady.
     * 
     * @return Falso, não deve ser possível mudar de revista para EmCameraReady.
     */
    @Override
    public boolean setEmCameraReady() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão SemArtigoFinal.
     * 
     * @return Falso, não deve ser possível mudar de Revista para SemArtigoFinal.
     */
    @Override
    public boolean setSemArtigoFinal() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Removida.
     * 
     * @return Verdadeiro, deve ser possível mudar de Revista para Removida.
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
