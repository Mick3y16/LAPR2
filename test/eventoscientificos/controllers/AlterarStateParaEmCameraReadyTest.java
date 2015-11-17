package eventoscientificos.controllers;

import eventoscientificos.model.Evento;
import eventoscientificos.model.Local;
import eventoscientificos.model.ProcessoDecisao;
import eventoscientificos.model.mecanismo.decisao.MecanismoDecisao1;
import eventoscientificos.model.state.evento.EventoEmCameraReadyState;
import eventoscientificos.model.state.evento.EventoEmDistribuicaoState;
import eventoscientificos.model.state.evento.EventoFaseDecisaoState;
import eventoscientificos.model.state.evento.EventoState;
import java.util.TimerTask;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * @author G01
 */
public class AlterarStateParaEmCameraReadyTest {

    private Evento evento;

    public AlterarStateParaEmCameraReadyTest() {
        Evento evento = new Evento(
                "titulo",
                "LAPR2",
                new Local("ISEP"),
                new Data(2015, 5, 22),
                new Data(2018, 5, 28),
                new Data(2018, 6, 10),
                new Data(2018, 6, 20),
                new Data(2018, 6, 24),
                new Data(2018, 6, 28),
                new Data(2018, 6, 30));
        evento.setEstado(
                new EventoFaseDecisaoState(evento));
        this.evento = evento;
    }

    /**
     * Test of run method, of class AlterarStateParaEmCameraReady.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        TimerTask instance = new AlterarStateParaEmCameraReady(evento);
        instance.run();
        Class<? extends EventoState> expResult
                = new EventoEmCameraReadyState(evento).getClass();
        Class<? extends EventoState> result
                = this.evento.getEstado().getClass();
        assertEquals(expResult, result);

    }

}
