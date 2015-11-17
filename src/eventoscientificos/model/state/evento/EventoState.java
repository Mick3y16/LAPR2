/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos.model.state.evento;

/**
 * Interface implementada pelas varias classes que representam o estado do
 * evento numa dada altura
 *
 * @author G01
 */
public interface EventoState {

    /**
     * Modifica o estado do evento para o estado Evento Criado.
     *
     * @return verdadeiro se puder mudar o estado e falso se não puder
     */
    public boolean setCriado();

    /**
     * Modifica o estado do evento para o estado Evento Registado.
     *
     * @return verdadeiro se puder mudar o estado e falso se não puder
     *
     */
    public boolean setRegistado();

    /**
     * Modifica o estado do evento para o estado Evento Sessoes Tematicas
     * Definidas.
     *
     * @return verdadeiro se puder mudar o estado e falso se não puder
     */
    public boolean setSessoesTematicasDefinidas();

    /**
     * Modifica o estado do evento para o estado Evento CP definida
     *
     * @return verdadeiro se puder mudar o estado e falso se não puder
     */
    public boolean setCPDefinida();

    /**
     * Modifica o estado do evento para o estado Evento Em Submissao
     *
     * @return verdadeiro se puder mudar o estado e falso se não puder
     */
    public boolean setEmSubmissao();

    /**
     * Modifica o estado do evento para o estado Evento Em Detecao
     *
     * @return verdadeiro se puder mudar o estado e falso se não puder
     */
    public boolean setEmDetecao();

    /**
     * Modifica o estado do evento para o estado Evento Em Licitacao
     *
     * @return verdadeiro se puder mudar o estado e falso se não puder
     */
    public boolean setEmLicitacao();

    /**
     * Modifica o estado do evento para o estado Evento Em Distribuicao
     *
     * @return verdadeiro se puder mudar o estado e falso se não puder
     */
    public boolean setEmDistribuicao();

    /**
     * Modifica o estado do evento para o estado Evento Em Revisao
     *
     * @return verdadeiro se puder mudar o estado e falso se não puder
     */
    public boolean setEmRevisao();

    /**
     * Modifica o estado do evento para o estado Evento Em Fase de Decisao
     *
     * @return verdadeiro se puder mudar o estado e falso se não puder
     */
    public boolean setFaseDecisao();

    /**
     * Modifica o estado do evento para o estado Evento Em Submissao Camera
     * Ready
     *
     * @return verdadeiro se puder mudar o estado e falso se não puder
     */
    public boolean setEmSubmissaoCameraReady();

    /**
     * Modifica o estado do evento para o estado Evento Camera Ready
     *
     * @return verdadeiro se puder mudar o estado e falso se não puder
     */
    public boolean setCameraReady();

    /**
     * validarEstado se cumpre as condicoes necessarias para efetuar a mudanca
     * de estado pretendida
     *
     * @return verdadeiro se poder passar de estado e falso se nao cumprir as
     * condicoes necessarias de mudanca de estado
     */
    public boolean validarEstado();

    public boolean isStateValidoParaRemover();

    public boolean isStateValidoParaSubmeter();

    public boolean isStateValidoParaAlterar();

    public boolean isStateValidoParaLicitar();

    public boolean isStateValidoParaDistribuir();
}
