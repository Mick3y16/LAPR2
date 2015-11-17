package eventoscientificos.model.state.sessaotematica;

/**
 * Interface implementada pelas várias classes que representam o estado da
 * Sessão Temática numa dada altura.
 *
 * @author G01
 */
public interface SessaoTematicaState {

    boolean setCriada();

    boolean setRegistada();

    boolean setCPDefinida();

    boolean setEmSubmissao();

    boolean setEmDetecao();

    boolean setEmLicitacao();

    boolean setEmDistribuicao();

    boolean setEmRevisao();

    boolean setFaseDecisao();

    boolean setEmSubmissaoCameraReady();

    boolean setCameraReady();

    boolean validarEstado();

    boolean isStateValidoParaRemover();

    boolean isStateValidoParaSubmeter();

    boolean isStateValidoParaAlterar();

    boolean isStateValidoParaLicitar();

    boolean isStateValidoParaDistribuir();

}
