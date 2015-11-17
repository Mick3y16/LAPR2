package eventoscientificos.model.mecanismo.leitura;

import eventoscientificos.model.Empresa;
import eventoscientificos.model.Evento;
import eventoscientificos.model.Local;
import eventoscientificos.model.RegistoUtilizadores;
import eventoscientificos.model.SessaoTematica;
import eventoscientificos.model.Utilizador;
import eventoscientificos.model.state.evento.EventoEmSubmissaoState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmSubmissaoState;
import org.junit.Test;
import utils.Data;

/**
 * @author G01
 */
public class MecanismoLeituraCSV1Test {

    private Empresa empresa;
    private Evento evento;
    
    public MecanismoLeituraCSV1Test() {
        Empresa empresa = new Empresa();
        Evento evento = new Evento("titulo", "descricao", new Local("local"),
                            new Data(2015, 6, 8), new Data(2016, 6, 20),
                            new Data(2016, 7, 7), new Data(2016, 8, 15),
                            new Data(2016, 9, 10), new Data(2016, 10, 1),
                            new Data(2017, 6, 10));
        evento.setEstado(new EventoEmSubmissaoState(evento));
        SessaoTematica sessaoTematica = new SessaoTematica(
                            "#A9D24R", "LAPR2", new Data(2015, 5, 22),
                            new Data(2015, 5, 28), new Data(2015, 6, 10),
                            new Data(2015, 6, 20), new Data(2015, 6, 24),
                            new Data(2015, 6, 28), new Data(2015, 6, 30));
        sessaoTematica.setEstado(new SessaoTematicaEmSubmissaoState(sessaoTematica));
        evento.getListaSessoesTematicas().adicionarSessaoTematica(sessaoTematica);
        Utilizador utilizador
                = new Utilizador("Pedro", "1140781@isep.ipp.pt", "pedro", "12345");
        empresa.getRegistoUtilizadores().adicionaUtilizador(utilizador);
        this.empresa = empresa;
        this.evento = evento;
    }

    /**
     * Teste do método lerFicheiroSubmissao, da classe MecanismoLeituraCSV1.
     */
    @Test
    public void testLerFicheiroSubmissao() {
        System.out.println("lerFicheiroSubmissao");
        RegistoUtilizadores registoUtilizadores = this.empresa.getRegistoUtilizadores();
        Evento evento = this.evento;
        String ficheiro = "submissao.csv";
        MecanismoLeituraCSV1 instance = new MecanismoLeituraCSV1();
        instance.lerFicheiroSubmissao(registoUtilizadores, evento, ficheiro);
    }
    
}
