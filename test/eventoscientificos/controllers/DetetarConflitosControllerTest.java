package eventoscientificos.controllers;

import eventoscientificos.model.CP;
import eventoscientificos.model.Empresa;
import eventoscientificos.model.Evento;
import eventoscientificos.model.Local;
import eventoscientificos.model.state.evento.EventoEmDetecaoConflitos;
import eventoscientificos.model.state.evento.EventoEmLicitacaoState;
import eventoscientificos.model.state.evento.EventoEmSubmissaoState;
import eventoscientificos.model.state.evento.EventoState;
import java.util.TimerTask;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import utils.Data;

/**
 * @author G01
 */
public class DetetarConflitosControllerTest {
    
    private Evento evento;
    Empresa empresa = new Empresa();
    
    public DetetarConflitosControllerTest() {
        this.empresa = new Empresa();
        Evento evento = new Evento(
                "titulo",
                "LAPR2",
                new Local("ISEP"),
                new Data(2015, 5, 22),
                new Data(2015, 6, 10),
                new Data(2018, 6, 12),
                new Data(2018, 6, 20),
                new Data(2018, 6, 24),
                new Data(2018, 6, 28),
                new Data(2018, 6, 30));
        evento.adicionarCP(new CP());
        evento.setEstado(
                new EventoEmSubmissaoState(evento));
        
        this.evento = evento;
    }

    /**
     * Teste do método run, da classe DetetarConflitosController.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        TimerTask instance = new DetetarConflitosController(empresa, evento);
        instance.run();
        Class<? extends EventoState> expResult
                = new EventoEmLicitacaoState(evento).getClass();
        Class<? extends EventoState> result
                = this.evento.getEstado().getClass();
        assertEquals(expResult, result);;
    }
    
}
