package eventoscientificos.controllers;

import eventoscientificos.model.SessaoTematica;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaCPDefinidaState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmSubmissaoState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaState;
import java.util.TimerTask;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * @author G01
 */
public class AlterarStateParaEmSubmissaoTest {

    private SessaoTematica sessaoTematica;

    public AlterarStateParaEmSubmissaoTest() {
        SessaoTematica sessaoTematica = new SessaoTematica(
                "#A9D24R",
                "LAPR2",
                new Data(2015, 5, 22),
                new Data(2018, 5, 28),
                new Data(2018, 6, 10),
                new Data(2018, 6, 20),
                new Data(2018, 6, 24),
                new Data(2018, 6, 28),
                new Data(2018, 6, 30));
        sessaoTematica.setEstado(
                new SessaoTematicaCPDefinidaState(sessaoTematica));

        this.sessaoTematica = sessaoTematica;
    }

    /**
     * Teste do método run, da classe AlterarStateParaEmSubmissao.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        TimerTask instance = new AlterarStateParaEmSubmissao(this.sessaoTematica);
        instance.run();
        Class<? extends SessaoTematicaState> expResult
                = new SessaoTematicaEmSubmissaoState(sessaoTematica).getClass();
        Class<? extends SessaoTematicaState> result
                = this.sessaoTematica.getEstado().getClass();
        assertEquals(expResult, result);
    }

}
