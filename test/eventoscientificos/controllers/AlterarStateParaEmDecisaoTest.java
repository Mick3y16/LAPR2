package eventoscientificos.controllers;

import eventoscientificos.model.Evento;
import eventoscientificos.model.Local;
import eventoscientificos.model.Submissao;
import eventoscientificos.model.state.evento.EventoEmRevisaoState;
import eventoscientificos.model.state.evento.EventoFaseDecisaoState;
import eventoscientificos.model.state.evento.EventoState;
import eventoscientificos.model.state.submissao.SubmissaoRevistaState;
import java.util.TimerTask;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * @author G01
 */
public class AlterarStateParaEmDecisaoTest {

    private Evento evento;

    public AlterarStateParaEmDecisaoTest() {
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
                new EventoEmRevisaoState(evento));
        Submissao submissao = new Submissao();
        submissao.setEstado(new SubmissaoRevistaState(submissao));

        this.evento = evento;
        this.evento.getListaSubmissoes().adicionarSubmissao(submissao);
    }

    /**
     * Test of run method, of class AlterarStateParaEmDecisao.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        TimerTask instance = new AlterarStateParaEmDecisao(this.evento);
        instance.run();
        Class<? extends EventoState> expResult
                = new EventoFaseDecisaoState(evento).getClass();
        Class<? extends EventoState> result
                = this.evento.getEstado().getClass();
        assertEquals(expResult, result);
    }

}
