package eventoscientificos.model.mecanismo.distribuicao;

import eventoscientificos.model.Artigo;
import eventoscientificos.model.CP;
import eventoscientificos.model.Distribuivel;
import eventoscientificos.model.Evento;
import eventoscientificos.model.ListaRevisoes;
import eventoscientificos.model.Local;
import eventoscientificos.model.ProcessoDistribuicao;
import eventoscientificos.model.RegistoEventos;
import eventoscientificos.model.Revisor;
import eventoscientificos.model.Submissao;
import eventoscientificos.model.Utilizador;
import eventoscientificos.model.mecanismo.distribuicao.MecanismoDistribuicaoTodasSubmissoesPorRevisor;
import eventoscientificos.model.state.submissao.SubmissaoAceiteState;
import eventoscientificos.model.state.submissao.SubmissaoEmLicitacaoState;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Data;

/**
 * Testa a classe MecanismoDistribuicaoTodasSubmissoesPorRevisor.
 *
 * @author G01
 */
public class MecanismoDistribuicaoTodasSubmissoesPorRevisorTest {

    private Submissao submissao1;
    private Submissao submissao2;
    private Submissao submissao3;

    private Revisor revisor1;
    private Revisor revisor2;
    private Revisor revisor3;

    private Evento evento;

    public MecanismoDistribuicaoTodasSubmissoesPorRevisorTest() {
        String titulo = "sem titulo";
        String descricao = "descricao";
        Local local = new Local("local");
        Data dataInicioSubmissao = new Data(2016, 6, 8);
        Data dataFimSubmissao = new Data(2016, 6, 20);
        Data dataInicioDistribuicao = new Data(2016, 7, 30);
        Data dataFimRevisao = new Data(2016, 8, 15);
        Data dataFimSubmissaoCameraReady = new Data(2016, 8, 30);
        Data dataInicio = new Data(2016, 10, 9);
        Data dataFim = new Data(2017, 6, 10);
        RegistoEventos instance = new RegistoEventos();
        this.evento = new Evento(titulo, descricao, local, dataInicioSubmissao,
                            dataFimSubmissao, dataInicioDistribuicao, dataFimRevisao,
                            dataFimSubmissaoCameraReady, dataInicio, dataFim);

        submissao1 = new Submissao();
        submissao1.setArtigoInicial(new Artigo());
        submissao1.setArtigoFinal(new Artigo());
        submissao1.setEstado(new SubmissaoEmLicitacaoState(submissao1));

        submissao2 = new Submissao();
        submissao2.setArtigoInicial(new Artigo());
        submissao2.setArtigoFinal(new Artigo());
        submissao2.setEstado(new SubmissaoEmLicitacaoState(submissao2));

        submissao3 = new Submissao();
        submissao3.setArtigoInicial(new Artigo());
        submissao3.setArtigoFinal(new Artigo());
        submissao3.setEstado(new SubmissaoEmLicitacaoState(submissao3));

        this.evento.getListaSubmissoes().adicionarSubmissao(submissao1);
        this.evento.getListaSubmissoes().adicionarSubmissao(submissao2);
        this.evento.getListaSubmissoes().adicionarSubmissao(submissao3);

        this.evento.adicionarCP(new CP());
        this.evento.getCP().novoRevisor(new Utilizador("nome",
                            "1140587@isep.ipp.pt",
                            "username",
                            "password"));
        this.evento.getCP().novoRevisor(new Utilizador("nome",
                            "1140805@isep.ipp.pt",
                            "user",
                            "password"));
        this.evento.getCP().novoRevisor(new Utilizador("nome",
                            "1130909@isep.ipp.pt",
                            "fifi",
                            "password"));

        this.evento.adicionarProcessoDistribuicao(new ProcessoDistribuicao());
    }

    /**
     * Test of distribuirRevisoes method, of class
     * MecanismoDistribuicaoTodasSubmissoesPorRevisor.
     */
    @Test
    public void testDistribuirRevisoes() {
        System.out.println("distribuirRevisoes");
        Distribuivel distribuivel = this.evento;
        ListaRevisoes lr = new ListaRevisoes();
        MecanismoDistribuicaoTodasSubmissoesPorRevisor instance = new MecanismoDistribuicaoTodasSubmissoesPorRevisor();
        boolean expResult = true;
        boolean result = instance.distribuirRevisoes(distribuivel, lr);
        assertEquals(expResult, result);

    }

}
