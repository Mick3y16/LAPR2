package eventoscientificos.model.state.submissao;

import eventoscientificos.model.Submissao;

/**
 * Representa uma instância de SubmissaoCriadaState através de uma submissão.
 *
 * @author G01
 */
public class SubmissaoCriadaState implements SubmissaoState {

    /**
     * Submissao que adota o estado.
     */
    private Submissao submissao;

    /**
     * Constroi uma instância de SubmissaoCriadaState recebendo uma Submissao
     *
     * @param submissao Submissao que adota o estado.
     */
    public SubmissaoCriadaState(Submissao submissao) {
        this.submissao = submissao;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Criada
     * 
     * @return Verdadeiro, a submissão encontra-se neste estado.
     */
    @Override
    public boolean setCriada() {
        return true;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Em Submissão.
     * 
     * @return Verdadeiro se for possivel alterar o estado para EmSubmissao e
     * falso caso não seja.
     */
    @Override
    public boolean setEmSubmissao() {
        if (validarEstado()) {
            this.submissao.setEstado(
                    new SubmissaoEmSubmissaoState(this.submissao));
            return true;
        }
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Em Licitacao.
     * 
     * @return Falso, não deve ser possível mudar de Criada para EmLicitacao.
     */
    @Override
    public boolean setEmLicitacao() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Em Revisão.
     * 
     * @return Falso, não deve ser possível mudar de Criada para EmRevisão.
     */
    @Override
    public boolean setEmRevisao() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Revista.
     * 
     * @return Falso, não deve ser possível mudar de Criada para Revista.
     */
    @Override
    public boolean setRevista() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Aceite.
     * 
     * @return Falso, não deve ser possível mudar de Criada para Aceite.
     */
    @Override
    public boolean setAceite() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Rejeitada.
     * 
     * @return Falso, não deve ser possível mudar de Criada para Rejeitada.
     */
    @Override
    public boolean setRejeitada() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão EmCameraReady.
     * 
     * @return Falso, não deve ser possível mudar de Criada para EmCameraReady.
     */
    @Override
    public boolean setEmCameraReady() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão SemArtigoFinal.
     * 
     * @return Falso, não deve ser possível mudar de Criada para SemArtigoFinal.
     */
    @Override
    public boolean setSemArtigoFinal() {
        return false;
    }

    /**
     * Modifica o estado da submissão para o estado Submissão Removida.
     * 
     * @return Falso, não deve ser possível mudar de Criada para Removida.
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
