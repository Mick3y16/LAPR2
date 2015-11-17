package eventoscientificos.controllers;

import eventoscientificos.model.Artigo;
import eventoscientificos.model.CP;
import eventoscientificos.model.Empresa;
import eventoscientificos.model.Evento;
import eventoscientificos.model.Local;
import eventoscientificos.model.Organizador;
import eventoscientificos.model.ProcessoDistribuicao;
import eventoscientificos.model.Proponente;
import eventoscientificos.model.RegistoEventos;
import eventoscientificos.model.Revisao;
import eventoscientificos.model.Revisor;
import eventoscientificos.model.SessaoTematica;
import eventoscientificos.model.Submissao;
import eventoscientificos.model.Utilizador;
import eventoscientificos.model.state.evento.EventoEmCameraReadyState;
import eventoscientificos.model.state.submissao.SubmissaoAceiteState;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import utils.Data;

/**
 * Testa a classe GerarAnaliseEstatisticaRevisaoController
 *
 * @author G01
 */
public class GerarAnaliseEstatisticaRevisaoControllerTest {

    private Empresa empresa;

    public GerarAnaliseEstatisticaRevisaoControllerTest() {

    }

    /**
     * Test of gerarAnaliseEstatisticas method, of class
     * GerarAnaliseEstatisticaRevisaoController.
     */
    @Test
    public void testGerarAnaliseEstatisticas() {
        System.out.println("gerarAnaliseEstatisticas");
        Empresa empresa = inicializarModeloTeste();
        GerarAnaliseEstatisticaRevisaoController instance = new GerarAnaliseEstatisticaRevisaoController(empresa);
        boolean expResult = true;
        boolean result = instance.gerarAnaliseEstatisticas();
        assertEquals(expResult, result);
    }

    /**
     * Test of notificarOrganizadoresEventos method, of class
     * GerarAnaliseEstatisticaRevisaoController.
     */
    @Test
    public void testNotificarOrganizadoresEventos() {
        System.out.println("notificarOrganizadoresEventos");
        int indice = 0;
        Empresa empresa = inicializarModeloTeste();
        GerarAnaliseEstatisticaRevisaoController instance = new GerarAnaliseEstatisticaRevisaoController(empresa);
        boolean expResult = true;
        instance.gerarAnaliseEstatisticas();
        boolean result = instance.notificarOrganizadoresEventos(indice);
        assertEquals(expResult, result);
    }

    public Empresa inicializarModeloTeste() {
        Empresa empresa = new Empresa();
        Utilizador u1 = new Utilizador("Beatriz Velho", "beatriz_velho@gmail.com", "beaVelho", "1234");
        Utilizador u2 = new Utilizador("Soraia Freitas", "freitas.soraia@gmail.com", "SuFreitas", "2345");
        Utilizador u3 = new Utilizador("Nuno Sousa", "sousa@isep.ipp.pt", "sousaN", "3456");
        Utilizador u4 = new Utilizador("Susana Vieira", "vieirinha@isep.ipp.pt", "VieirinhaSusy", "3457");
        Utilizador u5 = new Utilizador("Eduardo Ramalho", "eduardo_rama@hotmail.com", "edURamalho", "567810");
        Utilizador u6 = new Utilizador("Laura Freitas", "lauraFreitas@sapo.ipp.pt", "lauraF", "9876");
        Utilizador u7 = new Utilizador("Fernando Mesquita", "mesquita_fernando@gmail.com", "mesquita_fernando", "1010");

        // criar objetos do tipo revisor
        Revisor r1 = new Revisor(u1);
        Revisor r2 = new Revisor(u2);
        Revisor r3 = new Revisor(u3);
        Revisor r4 = new Revisor(u4);
        Revisor r5 = new Revisor(u5);
        Revisor r6 = new Revisor(u6);
        Revisor r7 = new Revisor(u7);

        //CP evento1 e 2
        List<Revisor> lr1 = new ArrayList<>();
        lr1.add(r1);
        lr1.add(r2);
        lr1.add(r4);
        lr1.add(r7);
        lr1.add(r6);

        List<Revisor> lr2 = new ArrayList<>();
        lr2.add(r1);
        lr2.add(r2);
        lr2.add(r4);
        lr2.add(r7);
        lr2.add(r3);
        lr2.add(r6);

        CP cpe1 = new CP();
        cpe1.getListaRevisores().addAll(lr1);
        CP cpe2 = new CP();
        cpe2.getListaRevisores().addAll(lr2);

        // criar Data de inicio e de fim de evento
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

        RegistoEventos instance = empresa.getRegistoEventos();

        Evento evento1 = new Evento(titulo, descricao, local, dataInicioSubmissao,
                            dataFimSubmissao, dataInicioDistribuicao, dataFimRevisao,
                            dataFimSubmissaoCameraReady, dataInicio, dataFim);
        evento1.adicionarCP(cpe1);
        evento1.novoOrganizador(u7);
        evento1.setEstado(new EventoEmCameraReadyState(evento1));

        Evento evento2 = new Evento("MarVermelho", descricao, local, dataInicioSubmissao,
                            dataFimSubmissao, dataInicioDistribuicao, dataFimRevisao,
                            dataFimSubmissaoCameraReady, dataInicio, dataFim);
        evento2.adicionarCP(cpe2);
        evento2.novoOrganizador(u6);
        evento2.setEstado(new EventoEmCameraReadyState(evento2));

        Evento evento3 = new Evento("MarVermelho", descricao, local, dataInicioSubmissao,
                            dataFimSubmissao, dataInicioDistribuicao, dataFimRevisao,
                            dataFimSubmissaoCameraReady, dataInicio, dataFim);
        evento3.adicionarCP(cpe1);
        evento3.novoOrganizador(u5);
        evento3.setEstado(new EventoEmCameraReadyState(evento3));

        //adicionar eventos ao registoEventos
        instance.adicionarEvento(evento2);
        instance.adicionarEvento(evento1);
        instance.adicionarEvento(evento3);

        //artigos
        Artigo art1 = new Artigo();
        art1.setTitulo("titulo");
        art1.setResumo("nana");
        art1.setFicheiro("fich1");

        Artigo art2 = new Artigo();
        art2.setTitulo("Art");
        art2.setResumo("fifi");
        art2.setFicheiro("fich2");

        Artigo art3 = new Artigo();
        art3.setTitulo("title");
        art3.setResumo("xaxa");
        art3.setFicheiro("fich3");

        //Submissões
        Submissao sub1 = new Submissao();
        sub1.setArtigoInicial(art1);
        sub1.setArtigoFinal(new Artigo());
        sub1.setEstado(new SubmissaoAceiteState(sub1));

        Submissao sub2 = new Submissao();
        sub2.setArtigoInicial(art2);
        sub2.setArtigoFinal(new Artigo());

        Submissao sub3 = new Submissao();
        sub3.setArtigoInicial(art3);
        sub3.setArtigoFinal(new Artigo());
        sub3.setEstado(new SubmissaoAceiteState(sub3));
        //Revisoes
        List<Revisao> listaRev1 = new ArrayList<>();
        listaRev1.add(new Revisao(sub1, r1));
        listaRev1.add(new Revisao(sub2, r1));
        listaRev1.add(new Revisao(sub3, r3));
        listaRev1.add(new Revisao(sub1, r4));

        listaRev1.get(0).adicionarDadosRevisao(5, 5, 5, 5, 2, "teste0");
        listaRev1.get(1).adicionarDadosRevisao(5, 5, 5, 5, 2, "teste1");
        listaRev1.get(2).adicionarDadosRevisao(5, 5, 5, 5, 2, "teste2");
        listaRev1.get(3).adicionarDadosRevisao(5, 5, 5, 5, 2, "teste3");

        List<Revisao> listaRev2 = new ArrayList<>();
        listaRev2.add(new Revisao(sub2, r4));
        listaRev2.add(new Revisao(sub3, r6));
        listaRev2.add(new Revisao(sub1, r7));

        listaRev2.get(0).adicionarDadosRevisao(5, 5, 5, 5, 2, "teste4");
        listaRev2.get(1).adicionarDadosRevisao(5, 5, 5, 5, 2, "teste5");
        listaRev2.get(2).adicionarDadosRevisao(5, 5, 5, 5, 2, "teste6");

        List<Revisao> listaRev3 = new ArrayList<>();
        listaRev3.add(new Revisao(sub2, r6));
        listaRev3.add(new Revisao(sub3, r2));
        listaRev3.get(0).adicionarDadosRevisao(5, 5, 5, 5, 2, "teste7");
        listaRev3.get(1).adicionarDadosRevisao(5, 5, 5, 5, 2, "teste8");

        //iniciar o processo distribuicao e a lista de revisões.
        evento1.adicionarProcessoDistribuicao(new ProcessoDistribuicao());
        evento1.getProcessoDistribuicao().getListaRevisoes().getListaRevisoes().addAll(listaRev1);

        evento2.adicionarProcessoDistribuicao(new ProcessoDistribuicao());
        evento2.getProcessoDistribuicao().getListaRevisoes().getListaRevisoes().addAll(listaRev2);

        evento3.adicionarProcessoDistribuicao(new ProcessoDistribuicao());
        evento3.getProcessoDistribuicao().getListaRevisoes().getListaRevisoes().addAll(listaRev3);

        evento1.getListaSubmissoes().adicionarSubmissao(sub1);
        sub1.setEstado(new SubmissaoAceiteState(sub1));
        evento1.getListaSubmissoes().adicionarSubmissao(sub2);
        sub2.setEstado(new SubmissaoAceiteState(sub2));
        evento1.getListaSubmissoes().adicionarSubmissao(sub3);
        sub3.setEstado(new SubmissaoAceiteState(sub3));
        evento2.getListaSubmissoes().adicionarSubmissao(sub1);
        sub1.setEstado(new SubmissaoAceiteState(sub1));
        evento2.getListaSubmissoes().adicionarSubmissao(sub2);
        sub2.setEstado(new SubmissaoAceiteState(sub2));
        evento2.getListaSubmissoes().adicionarSubmissao(sub3);
        sub3.setEstado(new SubmissaoAceiteState(sub3));
        evento3.getListaSubmissoes().adicionarSubmissao(sub1);
        sub1.setEstado(new SubmissaoAceiteState(sub1));
        evento3.getListaSubmissoes().adicionarSubmissao(sub2);
        sub2.setEstado(new SubmissaoAceiteState(sub2));
        evento3.getListaSubmissoes().adicionarSubmissao(sub3);
        sub3.setEstado(new SubmissaoAceiteState(sub3));

        return empresa;
    }
}
