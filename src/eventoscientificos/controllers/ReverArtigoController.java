package eventoscientificos.controllers;

import eventoscientificos.model.Empresa;
import eventoscientificos.model.ListaRevisoes;
import eventoscientificos.model.ProcessoDistribuicao;
import eventoscientificos.model.RegistoEventos;
import eventoscientificos.model.Revisao;
import eventoscientificos.model.Revisivel;
import eventoscientificos.model.Utilizador;
import java.util.List;

/**
 * Representa uma instância de ReverArtigoController através de Empresa,
 *
 *
 * @author G01
 */
public class ReverArtigoController {

    /**
     * Instância de empresa.
     */
    private Empresa empresa;

    /**
     * Lista de Revisiveis onde o revisor(utilizador autenticado) tem artigos
     * por rever.
     */
    private List<Revisivel> listaRevisiveis;

    /**
     * Revisivel escolhido pelo revisor.
     */
    private Revisivel revisivel;

    /**
     * Lista de Revisoes do revisor.
     */
    private List<Revisao> listaRevisoesRevisor;

    /**
     * Revisão selecionada.
     */
    private Revisao revisao;

    /**
     * Revisão clone.
     */
    private Revisao revisaoClone;

    /**
     * Constrói uma instância de ReverArtigoController
     * @param empresa empresa 
     */
    public ReverArtigoController(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Revisivel> getListaRevisiveis() {
        return this.listaRevisiveis;
    }
    
    public List<Revisao> getListaRevisoesRevisor() {
        return this.listaRevisoesRevisor;
    }

    /**
     * Devolve uma lista de Revisiveis no qual o utilizador no sistema é revisor
     * e tem artigos por rever
     *
     * @return falso se a lista retornar vazia e verdadeiro se estiver
     * preenchida
     */
    public boolean getListaRevisiveisComArtigosPReverRevisor() {
        RegistoEventos re = empresa.getRegistoEventos();
        Utilizador u = empresa.getUtilizadorAutenticado();
        this.listaRevisiveis = re.getListaRevisiveisComArtigosPReverRevisor(u);
        return this.listaRevisiveis.size() > 0;
    }

    /**
     * Seleciona o revisivel pretendido e apresenta a lista de artigos onde pode
     * rever
     *
     * @param indice indice do revisivel (na lista de revisiveis)
     * @return verdadeiro se o revisor tiver submissões por rever no revisivel
     * escolhido e falso se não tiver
     */
    public boolean selecionarRevisivel(int indice) {
        this.revisivel = this.listaRevisiveis.get(indice);
        ProcessoDistribuicao pd = this.revisivel.getProcessoDistribuicao();
        ListaRevisoes listaRevisoes = pd.getListaRevisoes();
        this.listaRevisoesRevisor = listaRevisoes.getRevisoesRevisor(empresa.getUtilizadorAutenticado());
        return this.listaRevisoesRevisor.size() > 0;
    }

    /**
     * Seleciona a revisão da lista de revisões e cria um clone da mesma.
     *
     * @param indiceRevisao indice da revisão na lista de revisões
     * @return verdadeiro se for efetuada uma revisão clone com sucesso
     */
    public boolean selecionarRevisao(int indiceRevisao) {
        this.revisao = this.listaRevisoesRevisor.get(indiceRevisao);
        this.revisaoClone = this.revisao.criarCloneRevisao();
        return this.revisaoClone != null;
    }

    /**
     * Adiciona os dados da revisão no objeto revisaoClone.
     *
     * @param confianca valor dado pela confianca
     * @param adequacao valor dado pela adequacao
     * @param originalidade valor dado pela originalidade
     * @param qualidade valor dado pela qualidade
     * @param recomendacao valor dado pela recomendacao
     * @param textoJust texto jsutificativo pela revisão
     * @return verdadeiro se adicionar correstamente os dados e falso se não o
     * fizer
     */
    public boolean adicionarDadosRevisao(int confianca, int adequacao,
                        int originalidade, int qualidade, int recomendacao,
                        String textoJust) {
        return this.revisaoClone.adicionarDadosRevisao(
                            adequacao, confianca, originalidade, qualidade,
                            recomendacao, textoJust);
    }

    /**
     * Adiciona os valores da revisão clone (resultado da revisão) no objeto
     * revisão presente da lista de revisões.
     *
     * @return verdadeiro se adicionar o resultado da avaliação da revisão clone
     * na revisão e falso se não o conseguir.
     */
    public boolean adicionarResultadoRevisao() {
        return this.revisao.adicionarResultadoRevisao(revisaoClone);
    }

}
