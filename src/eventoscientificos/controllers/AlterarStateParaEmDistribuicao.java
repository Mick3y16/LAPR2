package eventoscientificos.controllers;

import eventoscientificos.model.Distribuivel;
import java.util.TimerTask;

/**
 * Representa uma instância de AlterarStateParaEmDistribuicao através de um
 * distribuivel
 * 
 * @author G01
 */
public class AlterarStateParaEmDistribuicao extends TimerTask {

    /**
     * Distribuivel que é alterado para em distribuição.
     */
    private Distribuivel distribuivel;
    
    /**
     * Constrói uma instância de AlterarStateParaEmDistribuicao recebendo um
     * distribuivel.
     * 
     * @param distribuivel Distribuivel.
     */
    public AlterarStateParaEmDistribuicao(Distribuivel distribuivel) {
        this.distribuivel = distribuivel;
    }

     /**
     * Método que despoleta o processo de alteração de estado do distribuivel.
     */
    @Override
    public void run() {
        this.distribuivel.setEmDistribuicao();
    }
    
}
