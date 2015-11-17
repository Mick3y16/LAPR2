package eventoscientificos.model;

import eventoscientificos.model.state.sessaotematica.SessaoTematicaCriadaState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmSubmissaoCameraReadyState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmSubmissaoState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaFaseDecisaoState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import utils.Data;

/**
 * Representa uma instância de uma sessão temática através de um código único,
 * uma descrição e uma data limite de submissão.
 *
 * @author G01
 */
public class SessaoTematica implements CPDefinivel, Submissivel, Detetavel,
        Licitavel, Distribuivel, Revisivel, Decidivel {

    /**
     * Código único da sessão temática.
     */
    private String codigoUnico;

    /**
     * Descrição da sessão temática.
     */
    private String descricao;

    /**
     * Data de inicio de submissão da sessão temática.
     */
    private Data dataInicioSubmissao;

    /**
     * Data de fim de submissão da sessão temática.
     */
    private Data dataFimSubmissao;

    /**
     * Data de início de distribuição da sessão temática.
     */
    private Data dataInicioDistribuicao;

    /**
     * Data de fim de revisão da sessão temática.
     */
    private Data dataFimRevisao;

    /**
     * Data de fim de submissão CameraReady da sessão temática.
     */
    private Data dataFimSubmissaoCameraReady;

    /**
     * Data de inicio da sessão temática.
     */
    private Data dataInicio;

    /**
     * Data de fim da sessão temática
     */
    private Data dataFim;

    /**
     * Lista de proponentes da sessão temática.
     */
    private List<Proponente> listaProponentes;
    
    /**
     * Lista de Licitações da sessão temática.
     */
    private ListaLicitacoes listaLicitacoes;
    
    /**
     * CP de sessão temática.
     */
    private CP cp;

    /**
     * Lista de submissões da sessão temática.
     */
    private ListaSubmissoes listaSubmissoes;

    /**
     * Processo de deteção da sessão temática.
     */
    private ProcessoDetecao processoDetecao;

    /**
     * Processo de Distribuição.
     */
    private ProcessoDistribuicao processoDistribuicao;

    /**
     * Processo de Decisão.
     */
    private ProcessoDecisao processoDecisao;
    /**
     * Processo de análise estatística.
     */
    private ProcessoAnaliseEstatistica processoAnaliseEstatistica;

    /**
     * Estado da sessão temática.
     */
    private SessaoTematicaState estado;

    /**
     * Constrói uma instância de uma sessão temática recebendo um código único,
     * uma descrição e uma data limite de submissão.
     *
     * @param codigoUnico Código único da sessão temática.
     * @param descricao Descrição da sessão temática.
     * @param dataInicioSubmissao Data de inicio de submissão da sessão
     * temática.
     * @param dataFimSubmissao Data de fim de submissão da sessão temática.
     * @param dataInicioDistribuicao Data de início de distribuição da sessão
     * temática.
     * @param dataFimRevisao data fim de revisão
     * @param dataFimSubmissaoCameraReady Data de fim de submissão de artigo
     * final da sessão temática.
     * @param dataInicio Data de início da sessão temática.
     * @param dataFim Data de fim da sessão temática.
     */
    public SessaoTematica(
            String codigoUnico,
            String descricao,
            Data dataInicioSubmissao,
            Data dataFimSubmissao,
            Data dataInicioDistribuicao,
            Data dataFimRevisao,
            Data dataFimSubmissaoCameraReady,
            Data dataInicio,
            Data dataFim) {
        setCodigoUnico(codigoUnico);
        setDescricao(descricao);
        setDataInicioSubmissao(dataInicioSubmissao);
        setDataFimSubmissao(dataFimSubmissao);
        setDataInicioDistribuicao(dataInicioDistribuicao);
        setDataFimRevisao(dataFimRevisao);
        setDataFimSubmissaoCameraReady(dataFimSubmissaoCameraReady);
        setDataInicio(dataInicio);
        setDataFim(dataFim);
        this.listaProponentes = new ArrayList();
        this.listaLicitacoes = new ListaLicitacoes();
        setCP(null);
        this.listaSubmissoes = new ListaSubmissoes();
        setProcessoDetecao(null);
        setEstado(new SessaoTematicaCriadaState(this));

    }

    /**
     * Devolve o código único da sessão temática.
     *
     * @return Código único da sessão temática.
     */
    public String getCodigoUnico() {
        return this.codigoUnico;
    }

    /**
     * Devolve a descrição da sessão temática.
     *
     * @return Descrição da sessão temática.
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * Devolve a data de inicio de submissão da sessão temática.
     *
     * @return Data de inicio de submissão da sessão temática.
     */
    public Data getDataInicioSubmissao() {
        return this.dataInicioSubmissao;
    }

    /**
     * Devolve a data de fim de submissão da sessão temática.
     *
     * @return Data de fim de submissão da sessão temática.
     */
    public Data getDataFimSubmissao() {
        return this.dataFimSubmissao;
    }

    /**
     * Devolve a data de inicio de distribuição da sessão temática.
     *
     * @return Data de início de distribuição da sessão temática.
     */
    public Data getDataInicioDistribuicao() {
        return this.dataInicioDistribuicao;
    }

    /**
     * Devolve a data de fim de revisão da sessão temática.
     *
     * @return Data de fim de revisão da sessão temática.
     */
    public Data getDataFimRevisao() {
        return this.dataFimRevisao;
    }

    /**
     * Devolve a data de fim de submissão CameraReady da sessão temática.
     *
     * @return Data de fim de submissão CameraReady da sessão temática.
     */
    public Data getDataFimSubmissaoCameraReady() {
        return this.dataFimSubmissaoCameraReady;
    }

    /**
     * Devolve a data de inicio da sessão temática.
     *
     * @return Data de início da sessão temática.
     */
    public Data getDataInicio() {
        return dataInicio;
    }

    /**
     * Devolve a data de fim da sessão temática.
     *
     * @return Data de fim da sessão temática.
     */
    public Data getDataFim() {
        return dataFim;
    }

    /**
     * Devolve a CP da sessão temática.
     *
     * @return CP da sessão temática.
     */
    @Override
    public CP getCP() {
        return this.cp;
    }

    /**
     * Devolve a lista de submissões da sessão temática.
     *
     * @return Lista de submissões da sessão temática.
     */
    @Override
    public ListaSubmissoes getListaSubmissoes() {
        return this.listaSubmissoes;
    }

    /**
     * Devolve o processo de deteção da sessão temática.
     *
     * @return Processo de deteção da sessão temática.
     */
    @Override
    public ProcessoDetecao getProcessoDetecao() {
        return this.processoDetecao;
    }

    /**
     * Devolve a lista de licitações da sessão temática.
     *
     * @return Lista de licitações da sessão temática
     */
    @Override
    public ListaLicitacoes getListaLicitacoes() {
        return this.listaLicitacoes;
    }

    /**
     * Devolve o estado da sessão temática.
     *
     * @return Estado da sessão temática.
     */
    public SessaoTematicaState getEstado() {
        return this.estado;
    }

    /**
     * Devolve o processo de distribuição.
     *
     * @return processo de distribuição
     */
    @Override
    public ProcessoDistribuicao getProcessoDistribuicao() {
        return this.processoDistribuicao;
    }

    /**
     * Devolve o processo de decisão.
     *
     * @return processo de decisão
     */
    @Override
    public ProcessoDecisao getProcessoDecisao() {
        return this.processoDecisao;
    }

    /**
     * Modifica o código único da sessão temática.
     *
     * @param codigoUnico Novo código único da sessão temática.
     */
    public void setCodigoUnico(String codigoUnico) {
        if (codigoUnico.trim().isEmpty()) {
            throw new IllegalArgumentException("O código único da sessão "
                    + "temática não pode estar vazio.");
        }

        this.codigoUnico = codigoUnico;
    }

    /**
     * Modifica a descrição da sessão temática.
     *
     * @param descricao Nova descrição da sessão temática.
     */
    public void setDescricao(String descricao) {
        if (descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição da sessão temática"
                    + "não pode estar vazia.");
        }

        this.descricao = descricao;
    }

    /**
     * Modifica a data de inicio de submissão da sessão temática.
     *
     * @param dataInicioSubmissao Nova data de inicio de submissão da sessão
     * temática.
     */
    public void setDataInicioSubmissao(Data dataInicioSubmissao) {
        if (dataInicioSubmissao == null) {
            throw new NullPointerException("A data de inicio de submissão não "
                    + "pode estar vazia.");
        }

        this.dataInicioSubmissao = dataInicioSubmissao;
    }

    /**
     * Modifica a data de fim de submissão da sessão temática.
     *
     * @param dataFinalSubmissao Nova data de fim de submissão da sessão
     * temática.
     */
    public void setDataFimSubmissao(Data dataFinalSubmissao) {
        if (dataFinalSubmissao == null) {
            throw new NullPointerException("A data de fim de submissão não pode"
                    + "estar vazia.");
        }

        this.dataFimSubmissao = dataFinalSubmissao;
    }

    /**
     * Modifica a data de início de distribuição da sessão temática.
     *
     * @param dataInicioDistribuicao Nova data de início de distribuição da
     * sessão temática.
     */
    public void setDataInicioDistribuicao(Data dataInicioDistribuicao) {
        if (dataInicioDistribuicao == null) {
            throw new NullPointerException("A data de início de distribuição "
                    + "não pode estar vazia.");
        }

        this.dataInicioDistribuicao = dataInicioDistribuicao;
    }

    public void setDataFimRevisao(Data dataFimRevisao) {
        if (dataFimRevisao == null) {
            throw new NullPointerException("A data de fim de revisão não pode "
                    + "estar vazia.");
        }

        this.dataFimRevisao = dataFimRevisao;
    }

    /**
     * Modifica a data de fim de submissão da sessão temática.
     *
     * @param dataFimSubmissaoCameraReady Nova data de fim de submissão
     * CameraReady da sessão temática.
     */
    public void setDataFimSubmissaoCameraReady(
            Data dataFimSubmissaoCameraReady) {
        if (dataFimSubmissaoCameraReady == null) {
            throw new NullPointerException("A data de fim de submissão "
                    + "CameraReady não pode estar vazia.");
        }

        this.dataFimSubmissaoCameraReady = dataFimSubmissaoCameraReady;
    }

    /**
     * Modifica a data de início da sessão temática.
     *
     * @param dataInicio Nova data de início da sessão temática.
     */
    public void setDataInicio(Data dataInicio) {
        if (dataInicio == null) {
            throw new NullPointerException("A data de início não pode estar"
                    + "vazia.");
        }

        this.dataInicio = dataInicio;
    }

    /**
     * Modifica a data de fim da sessão temática.
     *
     * @param dataFim Nova data de fim da sessão temática.
     */
    public void setDataFim(Data dataFim) {
        if (dataFim == null) {
            throw new NullPointerException("A data de fim não pode estar"
                    + "vazia.");
        }

        this.dataFim = dataFim;
    }

    /**
     * Modifica a CP da sessão temática.
     *
     * @param cp Nova CP da sessão temática.
     */
    @Override
    public void setCP(CP cp) {
        this.cp = cp;
    }

    /**
     * Modifica o processo de deteção da sessão temática.
     *
     * @param processoDetecao Novo processo de deteção da sessão temática.
     */
    @Override
    public void setProcessoDetecao(ProcessoDetecao processoDetecao) {
        this.processoDetecao = processoDetecao;
    }

    /**
     * Modifica o processo de decissão da sessão temática.
     *
     * @param processoDecisao Novo processo de decisão.
     */
    @Override
    public void setProcessoDecisao(ProcessoDecisao processoDecisao) {
        this.processoDecisao = processoDecisao;
    }

    /**
     * Modifica o estado da sessão temática.
     *
     * @param estado Novo estado da sessão temática.
     */
    public void setEstado(SessaoTematicaState estado) {
        this.estado = estado;
    }

    /**
     * Devolve a descrição textual da sessão temática no formato: código único -
     * descrição
     *
     * @return Características da sessão temática.
     */
    @Override
    public String toString() {
        return String.format("    %s - %s",
                this.getCodigoUnico(),
                this.getDescricao());
    }

    /**
     * Compara dois objetos entre si. Comparando primariamente a posição de
     * memória, seguida do conteudo e das classes as quais cada um deles
     * pertence, e finalmente os seus atributos, código único.
     *
     * @param outroObjeto Sessão Temática que vai ser usada na comparação.
     * @return Verdadeiro caso os objetos comparados sejam iguais e falso caso
     * não o sejam.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }

        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }

        SessaoTematica outraSessaoTematica = (SessaoTematica) outroObjeto;

        return this.getCodigoUnico().equals(
                outraSessaoTematica.getCodigoUnico());
    }

    /**
     * Cria uma instância de proponente através de um utilizador que assume esse
     * papel.
     *
     * @param utilizador Utilizador que assume o papel de proponente.
     * @return Verdadeiro se o proponente for criado e adicionado à lista com
     * sucesso e falso caso não seja.
     */
    public boolean novoProponente(Utilizador utilizador) {
        Proponente proponente = new Proponente(utilizador);

        if (!proponente.validarProponente()) {
            throw new IllegalArgumentException("Não introduziu um proponente"
                    + "válido.");
        }

        if (!validarProponente(proponente)) {
            throw new IllegalArgumentException("O proponente introduzido já"
                    + "se encontra na lista.");
        }

        return adicionarProponente(proponente);
    }

    /**
     * Valida uma instância de proponente verificando se o mesmo já existe numa
     * lista.
     *
     * @param proponente Proponente que vai ser procurado na lista.
     * @return Verdadeiro se o proponente não existir na lista e falso caso
     * exista.
     */
    private boolean validarProponente(Proponente proponente) {
        return !this.listaProponentes.contains(proponente);
    }

    /**
     * Adiciona uma instância de proponente a uma lista.
     *
     * @param proponente Proponente que vai ser adicionado na lista.
     * @return Verdadeiro caso o proponente seja adicionado à lista e falso caso
     * a adição falhe.
     */
    private boolean adicionarProponente(Proponente proponente) {
        return this.listaProponentes.add(proponente);
    }

    /**
     * Valida a sessão temática, verificando se todos os seus atributos se
     * encontram devidamente preenchidos.
     *
     * @return Verdadeiro se o objeto for válido e falso caso não seja.
     */
    public boolean validarSessaoTematica() {
        return this.estado.setRegistada();
    }

    /**
     * Verifica se a sessão temática tem pelo menos um proponente.
     *
     * @return Verdadeiro se tem pelo menos um proponente e falso se a lista
     * está vazia.
     */
    public boolean temProponentes() {
        return this.listaProponentes.size() > 0;
    }

    /**
     * Devolve o número total de proponentes na lista.
     *
     * @return Número total de proponentes na lista.
     */
    public int getNumeroProponentes() {
        return this.listaProponentes.size();
    }

    /**
     * Devolve um proponente através da sua posição na lista.
     *
     * @param indice Posição na lista.
     *
     * @return Proponente através da sua posição na lista.
     */
    public Proponente getProponentePeloID(int indice) {
        return this.listaProponentes.get(indice);
    }

    /**
     * Cria uma instância de CP vazia.
     *
     * @return CP
     */
    public CP novaCP() {
        return new CP();
    }

    /**
     * Adiciona uma nova CP à sessão temática.
     *
     * @param cp CP a adicionar à sessão temática.
     *
     * @return Verdadeiro caso a CP tenha sido adicionada à sessão temática e
     * falso se a adição falhar.
     */
    @Override
    public boolean adicionarCP(CP cp) {
        setCP(cp);

        return this.estado.setCPDefinida();
    }

    /**
     * Método que altera o estado da Sessão Temática para em Submissão.
     */
    @Override
    public boolean setEmSubmissao() {
        return this.estado.setEmSubmissao();
    }

    /**
     * Verifica se determinado utilizador é proponente de sessão temática.
     *
     * @param utilizador Utilizador que se pretende verificar.
     * @return Verdadeiro caso seja e falso se não for.
     */
    public boolean isProponente(Utilizador utilizador) {
        for (Proponente proponente : this.listaProponentes) {
            if (utilizador.equals(proponente.getUtilizador())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Verifica se a sessão temática está registada.
     *
     * @return Verdadeira se estiver registada e falso se não estiver.
     */
    public boolean isRegistada() {
        return estado.setRegistada();
    }

    /**
     * Inicia o processo de deteção da sessão temática, recebendo uma lista de
     * tipos de conflito a detetar.
     *
     * @param listaTiposConflito Lista de tipos de conflito a detetar.
     */
    @Override
    public void iniciarProcessoDetecao(List<TipoConflito> listaTiposConflito) {
        ProcessoDetecao processoDetecao = novoProcessoDetecao(listaTiposConflito);

        processoDetecao.detetarConflitos();

        adicionarProcessoDetecao(processoDetecao);
    }

    /**
     * Cria e devolve uma instância de ProcessoDetecao alterando o estado da
     * sessão temática para EmDetecao.
     *
     * @param listaTiposConflito Tipos de conflito pelos quais o processo de
     * deteção vai procurar.
     * @return ProcessoDetecao.
     */
    private ProcessoDetecao novoProcessoDetecao(
            List<TipoConflito> listaTiposConflito) {
        this.estado.setEmDetecao();

        return new ProcessoDetecao(this, listaTiposConflito);
    }

    /**
     * Guarda o processo de deteção na sessão temática e altera o seu estado
     * para emLicitacao.
     *
     * @param processoDetecao Processo de Deteção a guardar.
     * @return Verdadeiro se o processo e a alteração de estado forem executados
     * com sucesso e falso caso não sejam.
     */
    private boolean adicionarProcessoDetecao(ProcessoDetecao processoDetecao) {
        setProcessoDetecao(processoDetecao);

        return this.estado.setEmLicitacao();
    }

    /**
     * Devolve o conflito detetado entre o revisor e a submissao
     *
     * @param revisor revisor associado ao conflito
     * @param submissao submissão associada ao conflito
     * @return conflito detetado na caso de existir e null caso não seja
     * encontrado
     */
    @Override
    public Conflito getConflitoRevisorSubmissao(Revisor revisor, Submissao submissao) {
        return this.processoDetecao.getListaConflito()
                .validarExistenciaConflito(revisor, submissao);
    }

    /**
     * Verifica se a Sessão Temática está no estado EmSubmissao.
     *
     * @return Verdadeiro se está no estado EmSubmissao e falso se não está.
     */
    @Override
    public boolean isStateValidoParaSubmeter() {
        return getEstado() instanceof SessaoTematicaEmSubmissaoState;
    }

    /**
     * Valida se a sessão temática se encontra em periodo de licitação
     *
     * @param u utilizador no sistema
     * @return verdadeiro se estiver em periodo de licitação e falso se não
     * estiver
     */
    @Override
    public boolean isStateValidoParaLicitar(Utilizador u) {
        if (this.estado.isStateValidoParaLicitar()) {
            if (this.cp.contains(u) && !this.listaLicitacoes.contains(u)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se a Sessão Tematica está no estado EmSubmissao.
     *
     * @return Verdadeiro se está no estado EmSubmissao e falso se não está.
     */
    @Override
    public boolean isStateValidoParaAlterar() {
        return getEstado() instanceof SessaoTematicaEmSubmissaoState
                || getEstado() instanceof SessaoTematicaEmSubmissaoCameraReadyState;
    }

    /**
     * Verifica se o utilizador passado por parâmetro é autor de alguma
     * submissão da lista de Submissões da Sessão Temática.
     *
     * @param utilizador Utilizador a verificar.
     * @return Verdadeiro se é autor e falso se não é.
     */
    public boolean isUtilizadorUmAutorSubmissao(Utilizador utilizador) {
        return this.listaSubmissoes.isUtilizadorUmAutorSubmissao(utilizador);
    }

    /**
     * Constrói instância de ProcessoDistribuicao.
     *
     * @return ProcessoDistribuicao.
     */
    @Override
    public ProcessoDistribuicao novoProcessoDistribuicao() {
        return new ProcessoDistribuicao();
    }

    /**
     * Adiciona um Processo Distribuição ao Distribuível.
     *
     * @param processoDistribuicao ProcessoDistribuicao a adicionar ao
     * distribuivel.
     * @return verdadeiro se adicionar ao distribuivel e falso se não for
     * possivel adicioná-lo.
     */
    @Override
    public boolean adicionarProcessoDistribuicao(ProcessoDistribuicao processoDistribuicao) {
        this.processoDistribuicao = processoDistribuicao;
        if (estado.setEmRevisao()) {
            List<Submissao> listaSubmissoes = this.listaSubmissoes.getListaSubmissoes();
            for (Submissao s : listaSubmissoes) {
                s.getEstado().setEmRevisao();
            }
            return true;
        }
        return false;
    }

    /**
     * Verifica se evento se encontra reune as condições necessárias para ser
     * possível distribuir
     *
     * @param u Utilizador.
     *
     * @return verdadeiro cumprir as condições necessárias distribuir e falso se
     * não estiver
     */
    @Override
    public boolean isStateValidoParaDistribuir(Utilizador u) {
        if (this.estado.isStateValidoParaDistribuir()) {
            Proponente p = new Proponente(u);
            if (listaProponentes.contains(p)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se o revisivel contém as condições necessárias para as
     * submissões serem revistas pelos revisores
     *
     * @param u Utilizador.
     *
     * @return verdadeiro cumprir as condições necessárias para rever e falso se
     * não estiver
     */
    @Override
    public boolean isStateValidoParaRever(Utilizador u) {
        if (estado.setEmRevisao() && this.cp.contains(u)) {
            ListaRevisoes lr = this.processoDistribuicao.getListaRevisoes();
            if (lr.getRevisoesRevisor(u).size() > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se existem submissões retiradas e onde o utilizador é
     * proponente.
     *
     * @param utilizador Utilizador a verificar é proponente.
     * @return Verdadeiro caso existam submissoes retiradas e falso se não
     * existir.
     */
    public boolean temSubmissoesRetiradas(Utilizador utilizador) {
        return isProponente(utilizador) && this.listaSubmissoes.temSubmissoesRetiradas();
    }

    /**
     * Devolve uma lista de submissões retiradas.
     *
     * @return Lista de submissões retiradas.
     */
    @Override
    public List<Submissao> getListaSubmissoesRetiradas() {
        return this.listaSubmissoes.getListaSubmissoesRetiradas();
    }

    /**
     * Verifica se a Sessão Temática está no estado EmSubmissaoCmeraReady.
     *
     * @return Verdadeiro se está no estado EmSubmissaoCameraReady e falso se
     * não está.
     */
    @Override
    public boolean isStateValidoParaSubmeterArtigoFinal() {
        return this.estado instanceof SessaoTematicaEmSubmissaoCameraReadyState;
    }

    /**
     * Verifica se o utilizador passado por parâmetro é autor de alguma
     * submissão da lista de Submissões da sessão temática
     *
     * @param utilizador Utilizador a verificar.
     * @return Verdadeiro se é autor e falso se não é.
     */
    public boolean isUtilizadorUmAutorSubmissaoInicial(Utilizador utilizador) {
        return this.listaSubmissoes.isUtilizadorUmAutorSubmissaoInicial(utilizador);
    }

    /**
     * Verifica se a Sessão Temática está no estado FaseDeDecisao
     *
     * @return Verdadeiro se está no estado FaseDecisao e falso se não está.
     */
    public boolean isEstadoValidoParaDecidir() {
        return this.estado instanceof SessaoTematicaFaseDecisaoState;
    }

    /**
     * Verifica se determinado Submissivel cumpre os critérios necessários para
     * remover.
     *
     * @param u Utilizador.
     *
     * @return verdadeiro se a sessão temática reunir as condições necessárias
     * de remoção e falso se não for possível remover.
     */
    @Override
    public boolean isStateValidoParaRemover(Utilizador u) {
        if (estado.isStateValidoParaRemover()) {
            return this.listaSubmissoes.containsAutorNaListaAutoresArtigoInicial(u);
        }
        return false;
    }

    /**
     * Constrói instância de ProcessoDecisao
     *
     * @return ProcessoDecisao
     */
    @Override
    public ProcessoDecisao novoProcessoDecisao() {
        return new ProcessoDecisao();
    }

    /**
     * Preenche os mapas com as palavras chaves e respetivas recomendações
     * globais.
     *
     * @param hashMapSubmissoesAceites Mapa de submissões aceites.
     * @param hashMapSubmissoesRejeitadas Mapa de submissões rejeitadas.
     */
    public void hashMapSubmissoesSessaoTematica(
            HashMap<String, Integer> hashMapSubmissoesAceites,
            HashMap<String, Integer> hashMapSubmissoesRejeitadas) {

        this.processoDistribuicao.hashMapSubmissoes(hashMapSubmissoesAceites,
                hashMapSubmissoesRejeitadas);
    }

    /**
     * Adiciona um Processo de Decisão ao Decidivel.
     *
     * @param processoDecisao ProcessoDecisão a adicionar ao decidivel.
     * @return verdadeiro se adicionar ao decidivel e falso se não for possivel
     * adicioná-lo.
     */
    @Override
    public boolean adicionarProcessoDecisao(ProcessoDecisao processoDecisao) {
        this.processoDecisao = processoDecisao;
        setEstado(new SessaoTematicaEmSubmissaoCameraReadyState(this));
        if (getEstado() instanceof SessaoTematicaEmSubmissaoCameraReadyState) {
            return true;
        }
        return false;
    }

    /**
     * Método que altera o estado do Evento para em distribuição.
     */
    @Override
    public boolean setEmDistribuicao() {
        return this.estado.setEmDistribuicao();
    }

    /**
     * Método que altera o estado do Evento para em decisão.
     */
    @Override
    public boolean setEmDecisao() {
        return this.estado.setFaseDecisao();
    }

    /**
     * Método que altera o estado do Evento para em submissao camera ready
     */
    @Override
    public boolean setEmSubmissaoCameraReady() {
        return this.estado.setEmSubmissaoCameraReady();
    }
}
