package eventoscientificos.controllers;

import eventoscientificos.model.SessaoTematica;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmDistribuicaoState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmLicitacaoState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaState;
import java.util.TimerTask;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * @author G01
 */
public class AlterarStateParaEmDistribuicaoTest {

    private SessaoTematica sessaoTematica;
    

    public AlterarStateParaEmDistribuicaoTest() {
        SessaoTematica sessaoTematica = new SessaoTematica(
                "#A9D24R",
                "LAPR2",
                new Data(2015, 5, 22),
                new Data(2015, 5, 28),
                new Data(2015, 6, 10),
                new Data(2018, 6, 20),
                new Data(2018, 6, 24),
                new Data(2018, 6, 28),
                new Data(2018, 6, 30));
        sessaoTematica.setEstado(
                new SessaoTematicaEmLicitacaoState(sessaoTematica));

        this.sessaoTematica = sessaoTematica;
    }

    /**
     * Test of run method, of class AlterarStateParaEmDistribuicao.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        TimerTask instance = new AlterarStateParaEmDistribuicao(sessaoTematica);
        instance.run();
        Class<? extends SessaoTematicaState> expResult
                = new SessaoTematicaEmDistribuicaoState(sessaoTematica).getClass();
        Class<? extends SessaoTematicaState> result
                = this.sessaoTematica.getEstado().getClass();
        assertEquals(expResult, result);
    }

}
