package eventoscientificos.controllers;

import eventoscientificos.model.Submissivel;
import java.util.TimerTask;

/**
 * Representa uma instância de AlterarStateParaEmCameraReady através de um
 * submissível.
 *
 * @author G01
 */
public class AlterarStateParaEmCameraReady extends TimerTask {

    /**
     * Submissível que é alterado para em camera ready.
     */
    private Submissivel submissivel;

    /**
     * Constrói uma instância de AlterarStateParaEmCameraReady recebendo um
     * submissível.
     *
     * @param submissivel submissivel
     */
    public AlterarStateParaEmCameraReady(Submissivel submissivel) {
        this.submissivel = submissivel;
    }

    /**
     * Método que despoleta o processo de alteração de estado do submissivel.
     */
    @Override
    public void run() {
        this.submissivel.setEmSubmissaoCameraReady();
    }

}
