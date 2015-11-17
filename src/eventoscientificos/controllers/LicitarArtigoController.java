package eventoscientificos.controllers;

import eventoscientificos.model.Conflito;
import eventoscientificos.model.Empresa;
import eventoscientificos.model.Licitacao;
import eventoscientificos.model.Licitavel;
import eventoscientificos.model.ListaLicitacoes;
import eventoscientificos.model.RegistoEventos;
import eventoscientificos.model.RegistoTiposConflito;
import eventoscientificos.model.Revisor;
import eventoscientificos.model.Submissao;
import java.util.List;

/**
 * Representa uma instância de LicitarArtigoController através de Empresa,
 * Revisor, RegistoTiposConflito, listaLicitaveis, listaLicitacaoTemporaria, 
 * listaSubmissoes e Licitacao.
 *
 * @author G01
 */
public class LicitarArtigoController {

    /**
     * Instancia de empresa.
     */
    private Empresa empresa;
    /**
     * Instância de revisor.F
     */
    private Revisor revisor;
    /**
     * Instancia de RegistoTiposConflito.
     */
    private RegistoTiposConflito registoTiposConflito;

    /**
     * Lista de Licitáveis que permitem o revisor licitar.
     */
    private List<Licitavel> listaLicitaveis;

    /**
     * Lista de licitacoes temporária.
     */
    private List<Licitacao> listaLicitacaoTemporaria;

    /**
     * Lista de submissões do licitável.
     */
    private List<Submissao> listaSubmissoes;

    /**
     * Instância de Licitavel.
     */
    private Licitavel licitavel;

    /**
     * Instância de licitacao.
     */
    private Licitacao licitacao;

    /**
     * Constrói uma instância de LicitarArtigoController.
     * @param empresa empresa
     */
    public LicitarArtigoController(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * Retorna a lista de licitáveis (eventos e sessões temáticas) com artigos
     * por licitar associados ao revisor
     *
     * @return verdadeiro se encontrar eventos e sessões temáticas para licitar
     * e falso se não existir
     */
    public boolean getListaLicitaveisComArtigosPorLicitarRevisor() {
        RegistoEventos registoEventos = empresa.getRegistoEventos();
        this.registoTiposConflito = empresa.getRegistoTiposConflito();
        this.listaLicitaveis
                            = registoEventos.getListaLicitaveisComArtigosPorLicitarRevisor(empresa.getUtilizadorAutenticado());
        return listaLicitaveis.size() > 0;
    }

    public boolean selecionarLicitavel(int indice) {
        this.licitavel = listaLicitaveis.get(indice);
        ListaLicitacoes listaLicitacoes = licitavel.getListaLicitacoes();
        this.listaLicitacaoTemporaria = listaLicitacoes.criarListaLicitacoesTemporaria();
        this.listaSubmissoes = licitavel.getListaSubmissoes().getListaSubmissoes();
        this.revisor = this.licitavel.getCP().getRevisor(empresa.getUtilizadorAutenticado());
        if (listaLicitacaoTemporaria != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Devolve uma nova licitação associada ao revisor e a submissão recebidas
     * por parâmetro.
     *
     * @param revisor revisor 
     * @param s submissao
     * @return verdadeiro se instanciar uma nova licitação e falso se não o
     * fizer
     */
    public boolean novaLicitacao(Revisor revisor, Submissao s) {
        Conflito conflito = this.licitavel.getConflitoRevisorSubmissao(revisor, s);
        this.licitacao = this.licitavel.getListaLicitacoes().novaLicitacao(revisor, s, 0, conflito);
        return licitacao != null;
    }

    /**
     * Permite modificar os dados da Licitação e verificar se a mesma é válida
     *
     * @param grauInteresse grau de interesse do revisor
     * @param conflito novo conflito
     * @return verdadeiro se a licitação for válida e falso se não for.
     */
    public boolean inserirDadosLicitacao(int grauInteresse, Conflito conflito) {
        boolean valida = false;
        this.licitacao.setGrauInteresse(grauInteresse);
        this.licitacao.setConflito(conflito);
        valida = this.licitacao.validarLicitacao();
        this.listaLicitacaoTemporaria.add(licitacao);
        return valida;
    }

    /**
     * Adiciona uma lista de licitações provisórias à lista de licitações do
     * licitável
     *
     * @return verdadeiro se a licitação for adicionada à lista de licitações do
     * revisor e falso se não for
     */
    public boolean adicionarListaLicitacoesTemporaria() {
        return this.licitavel.getListaLicitacoes().adicionarListaLicitacoesTemporaria(listaLicitacaoTemporaria);
    }
}
