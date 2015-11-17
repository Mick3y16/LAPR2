package eventoscientificos.controllers;

import eventoscientificos.model.Submissivel;
import java.util.TimerTask;

/**
 * Representa uma instância de AlterarStateParaEmSubmissao através de um
 * submissível.
 *
 * @author G01
 */
public class AlterarStateParaEmSubmissao extends TimerTask {

    /**
     * Submissível que é alterado para em submissão.
     */
    private Submissivel submissivel;

    /**
     * Constrói uma instância de AlterarStateParaEmSubmissao recebendo um
     * submissível.
     * 
     * @param submissivel submissivel
     */
    public AlterarStateParaEmSubmissao(Submissivel submissivel) {
        this.submissivel = submissivel;
    }

    /**
     * Método que despoleta o processo de alteração de estado do submissivel.
     */
    @Override
    public void run() {
        this.submissivel.setEmSubmissao();
    }
    
}
