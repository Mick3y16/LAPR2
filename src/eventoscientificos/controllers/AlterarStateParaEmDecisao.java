package eventoscientificos.controllers;

import eventoscientificos.model.Decidivel;
import java.util.TimerTask;

/**
 * Representa uma instância de AlterarStateParaEmDecisao através de um
 * decidivel.
 *
 * @author G01
 */
public class AlterarStateParaEmDecisao extends TimerTask {

    /**
     * Decidivel que é alterado para em decisão.
     */
    private Decidivel decidivel;

    /**
     * Constrói uma instância de AlterarStateParaEmDecisao recebendo um
     * decidivel.
     *
     * @param decidivel decidivel.
     */
    public AlterarStateParaEmDecisao(Decidivel decidivel) {
        this.decidivel = decidivel;
    }

    /**
     * Método que despoleta o processo de alteração de estado do decidivel.
     */
    @Override
    public void run() {
        this.decidivel.setEmDecisao();
    }

}
