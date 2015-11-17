package eventoscientificos.model.state.submissao;

/** 
 * Interface implementada pelas várias classes que representam o estado da 
 * Submissão numa dada altura.
 * 
 * @author G01
 */
public interface SubmissaoState {
    
    boolean setCriada();
    
    boolean setEmSubmissao();
    
    boolean setEmLicitacao();
    
    boolean setEmRevisao();
    
    boolean setRevista();
        
    boolean setAceite();
    
    boolean setRejeitada();
    
    boolean setEmCameraReady();
    
    boolean setSemArtigoFinal();
    
    boolean setRemovida();
    
    boolean validarEstado();
    
}
