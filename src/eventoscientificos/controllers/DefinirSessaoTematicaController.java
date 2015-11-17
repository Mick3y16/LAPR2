package eventoscientificos.controllers;

import eventoscientificos.model.Empresa;
import eventoscientificos.model.Evento;
import eventoscientificos.model.ListaSessoesTematicas;
import eventoscientificos.model.Proponente;
import eventoscientificos.model.RegistoEventos;
import eventoscientificos.model.RegistoUtilizadores;
import eventoscientificos.model.SessaoTematica;
import eventoscientificos.model.Utilizador;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import javax.swing.DefaultListModel;
import utils.Data;

/**
 * Representa uma instância de DefinirSessaoTematicaController, através de uma
 * empresa, um modelo de uma lista de proponentes, uma lista de eventos, um
 * evento, uma lista de sessões temáticas, um registo de utilizador e uma sessão
 * temática.
 *
 * @author G01
 */
public class DefinirSessaoTematicaController {

    /**
     * Empresa que contém os dados.
     */
    private Empresa empresa;

    /**
     * Modelo da lista de proponentes.
     */
    private DefaultListModel modeloLista;

    /**
     * Lista de eventos onde é possivel definir sessões temáticas.
     */
    private List<Evento> listaEventos;

    /**
     * Evento onde vai ser definida a sessão temática.
     */
    private Evento evento;

    /**
     * Lista de sessões temáticas do evento.
     */
    private ListaSessoesTematicas listaSessoesTematicas;

    /**
     * Registo de utilizadores da empresa.
     */
    private RegistoUtilizadores registoUtilizadores;

    /**
     * Sessão temática que é criada.
     */
    private SessaoTematica sessaoTematica;

    /**
     * Constrói uma instância de DefinirSessaoTematicaController através de uma
     * empresa.
     *
     * @param empresa empresa
     */
    public DefinirSessaoTematicaController(Empresa empresa) {
        this.empresa = empresa;
        this.modeloLista = new DefaultListModel<Proponente>();
        this.listaEventos = null;
        this.evento = null;
        this.listaSessoesTematicas = null;
        this.registoUtilizadores = null;
        this.sessaoTematica = null;
    }

    /**
     * Devolve o modelo da lista de proponentes.
     * 
     * @return Modelo da lista de proponentes.
     */
    public DefaultListModel getModeloListaPapel() {
        return this.modeloLista;
    }

    /**
     * Devolve uma lista de eventos onde é possível definir sessões temáticas.
     *
     * @return Lista de eventos onde é possível definir sessões temáticas.
     */
    public List<Evento> getListaEventos() {
        return this.listaEventos;
    }

    /**
     * Retorna uma lista de eventos onde é possível definir uma sessão temática.
     *
     * @return Verdadeiro se existir pelo menos um evento nessa lista, falso
     * caso não exista nenhum.
     */
    public boolean getListaEventosOrganizador() {
        RegistoEventos registoEventos = empresa.getRegistoEventos();

        this.listaEventos = registoEventos.getListaEventosOrganizador(this.empresa.getUtilizadorAutenticado());

        return this.listaEventos != null;
    }

    /**
     * Seleciona o evento indicado pelo utilizador.
     *
     * @param index Indíce do evento.
     * @return Verdadeiro se o evento for selecionado com sucesso, falso caso
     * não seja.
     */
    public boolean selecionarEvento(int index) {
        this.evento = this.listaEventos.get(index);

        return this.evento != null;
    }

    /**
     * Trata de mandar criar uma instância de sessão temática no evento definido
     * pelo utilizador, recebendo os seus parametros.
     *
     * @param codigoUnico Código Único da sessão temática.
     * @param descricao Descrição da sessão temática.
     * @param dataInicioSubmissao Data de início de submissão da sessão
     * temática.
     * @param dataFimSubmissao Data de fim de submissão da sessão temática.
     * @param dataInicioDistribuicao Data de início de distribuição da sessão
     * temática.
     * @param dataFimRevisao Data de fim de revisão da sessão temática.
     * @param dataFimSubmissaoFinal Data de fim de submissão Camera Ready da
     * sessão temática.
     * @param dataInicio Data de inicio da sessão temática.
     * @param dataFim Data de fim da sessão temática.
     * @return Verdadeiro se for possível criar a sessão temática e falso caso
     * não seja.
     */
    public boolean novaSessaoTematica(String codigoUnico, String descricao,
            Data dataInicioSubmissao, Data dataFimSubmissao,
            Data dataInicioDistribuicao, Data dataFimRevisao,
            Data dataFimSubmissaoFinal, Data dataInicio, Data dataFim) {
        this.listaSessoesTematicas = this.evento.getListaSessoesTematicas();

        this.sessaoTematica = this.listaSessoesTematicas.novaSessaoTematica(
                codigoUnico, descricao, dataInicioSubmissao, dataFimSubmissao,
                dataInicioDistribuicao, dataFimRevisao, dataFimSubmissaoFinal,
                dataInicio, dataFim);

        this.registoUtilizadores = this.empresa.getRegistoUtilizadores();

        return this.listaSessoesTematicas != null && sessaoTematica != null
                && this.registoUtilizadores != null;
    }

    /**
     * Trata de mandar criar uma instância de proponente recebendo uma String.
     * 
     * @param id ID do utilizador que assume o papel de proponente.
     * 
     * @return Verdadeiro se o proponente for adicionado à sessão temática e
     * falso caso não o seja.
     */
    public boolean novoProponente(String id) {
        Utilizador utilizador = this.registoUtilizadores.getUtilizador(id);

        if (utilizador != null 
                && !this.modeloLista.contains(new Proponente(utilizador))) {
            this.modeloLista.addElement(new Proponente(utilizador));
        }

        return this.sessaoTematica.novoProponente(utilizador);
    }

    /**
     * Verifica se a sessão temática tem os seus dados preenchidos de forma
     * correta e se é única no evento.
     * 
     * @return Verdadeiro se os dados forem corretos, e a sessão temática for
     * única no evento e falso caso não o seja.
     */
    public boolean validarSessaoTematica() {
        this.sessaoTematica.validarSessaoTematica();
        
        if (!this.listaSessoesTematicas.validarSessaoTematica(
                this.sessaoTematica)) {
            throw new IllegalArgumentException("A sessão temática já existe no"
                    + " evento.");
        }

        return true;
    }

    /**
     * Adiciona a sessão temática ao evento que a contém.
     * 
     * @return Verdadeiro se for possível adicionar e falso caso não seja.
     */
    public boolean adicionarSessaoTematica() {
        criarTimers();

        return this.listaSessoesTematicas.adicionarSessaoTematica(
                this.sessaoTematica)
                && this.evento.temSessoesTematicasDefinidas();
    }

    /**
     * Método responsável por criar as Timertasks que alteram o estado da sessão
     * temática, quando a mesma atinge uma data.
     */
    private void criarTimers() {
        TimerTask t1 = new AlterarStateParaEmSubmissao(sessaoTematica);
        TimerTask t2 = new DetetarConflitosController(empresa, sessaoTematica);
        TimerTask t3 = new AlterarStateParaEmDistribuicao(sessaoTematica);
        TimerTask t4 = new AlterarStateParaEmCameraReady(sessaoTematica);

        empresa.schedule(t1, new Date(
                sessaoTematica.getDataInicioSubmissao().toMilisegundos()));
        empresa.schedule(t2, new Date(
                sessaoTematica.getDataFimSubmissao().toMilisegundos()));
        empresa.schedule(t3, new Date(
                sessaoTematica.getDataInicioDistribuicao().toMilisegundos()));
        empresa.schedule(t4, new Date(
                sessaoTematica.getDataFimSubmissaoCameraReady().toMilisegundos()));
    }

}
