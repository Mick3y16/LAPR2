package eventoscientificos.controllers;

import eventoscientificos.model.Empresa;
import eventoscientificos.model.Evento;
import eventoscientificos.model.Local;
import eventoscientificos.model.Organizador;
import eventoscientificos.model.RegistoEventos;
import eventoscientificos.model.RegistoUtilizadores;
import eventoscientificos.model.Utilizador;
import java.util.Date;
import java.util.TimerTask;
import javax.swing.DefaultListModel;
import utils.Data;

/**
 * Representa uma instância de CriarEventoController através de RegistoEventos
 *
 * @author G01
 */
public class CriarEventoController {

    /**
     * Intancia de Empresa.
     */
    private Empresa empresa;

    /**
     * Modelo da lista de organizadores.
     */
    private DefaultListModel modeloLista;

    /**
     * Instancia de RegistoEventos.
     */
    private RegistoEventos registoEventos;

    /**
     * Instancia de Evento.
     */
    private Evento evento;

    /**
     * Instancia de RegistoUtilizadores.
     */
    private RegistoUtilizadores registoUtilizadores;

    /**
     * Constrói uma instância de CriarEventoController recebendo uma empresa por
     * parametro.
     *
     * @param empresa Empresa.
     */
    public CriarEventoController(Empresa empresa) {
        this.empresa = empresa;
        this.modeloLista = new DefaultListModel<Organizador>();
        this.registoEventos = null;
        this.evento = null;
        this.registoUtilizadores = null;
    }

    /**
     * Devolve o modelo da lista de organizadores.
     * 
     * @return Modelo da lista de organizadores.
     */
    public DefaultListModel getModeloListaPapel() {
        return this.modeloLista;
    }

    /**
     * Cria uma instancia de Evento recebendo como parametro o titulo, a
     * descricao, o local, a data de inicio de submissao, a data de fim de
     * submissao, a data de inicio de distribuicao, date de inicio do evento e
     * data d fim do evento.
     *
     * @param titulo Titulo do evento.
     * @param descricao Descricao do evento.
     * @param local Local do evento.
     * @param dataInicioSubmissao Data de Inicio de Submissão do Evento.
     * @param dataFimSubmissao Data de Fim de Submissão do Evento.
     * @param dataInicioDistribuicao Data de Inicio de Distribuição do Evento.
     * @param dataFimRevisao Data Fim de Revisao.
     * @param dataFimSubmissaoCameraReady Data Dim de Submissao de Camera Ready.
     * @param dataInicio Data de Início do Evento.
     * @param dataFim Data de Fim do Evento.
     * @return verdadeiro se instanciar um novo evento e falso se não ocorrer
     */
    public boolean novoEvento(String titulo, String descricao, Local local,
            Data dataInicioSubmissao, Data dataFimSubmissao,
            Data dataInicioDistribuicao, Data dataFimRevisao, 
            Data dataFimSubmissaoCameraReady, Data dataInicio, Data dataFim) {

        this.registoEventos = this.empresa.getRegistoEventos();

        this.evento = this.registoEventos.novoEvento(titulo, descricao, local,
                dataInicioSubmissao, dataFimSubmissao, dataInicioDistribuicao,
                dataFimRevisao, dataFimSubmissaoCameraReady, dataInicio, dataFim);
        
        this.registoUtilizadores = this.empresa.getRegistoUtilizadores();

        return this.registoEventos != null && this.evento != null && this.registoUtilizadores != null;
    }

    /**
     * Cria uma instancia de Organizador recebendo como parametro uma String id.
     *
     * @param id Id de utilizador do organizador.
     *
     * @return Verdadeiro se o organziador for adicionado e falso se nao for.
     */
    public boolean novoOrganizador(String id) {
        Utilizador utilizador = this.registoUtilizadores.getUtilizador(id);

        if (utilizador != null 
                && !this.modeloLista.contains(new Organizador(utilizador))) {
            this.modeloLista.addElement(new Organizador(utilizador));
        }

        return this.evento.novoOrganizador(utilizador);
    }

    /**
     * Verifica se o evento tem todos os dados preenchidos e se o evento ja
     * existe.
     *
     * @return Verdadeiro de o Evento é válido
     */
    public boolean validarEvento() {
        if (!evento.validarEvento()) {
            throw new IllegalArgumentException("Deve introduzir pelo menos um organizador.");
        }

        if (!this.registoEventos.validarEvento(evento)) {
            throw new IllegalArgumentException("O evento já existe.");
        }

        return true;
    }

    /**
     * Adiciona um evento ao Registo de Eventos.
     *
     * @return Verdadeiro se o evento for adicionado e falso se não for.
     */
    public boolean adicionarEvento() {
        criarTimers();
        
        return this.registoEventos.adicionarEvento(this.evento);
    }

    /**
     * Responsável por criar as TimerTasks que alteram o estada do evento, 
     * quando o mesmo atinge uma data.
     */
    private void criarTimers() {
        TimerTask alterarParaEmSubmissao
                = new AlterarStateParaEmSubmissao(this.evento);

        this.empresa.schedule(alterarParaEmSubmissao, new Date(
                this.evento.getDataInicioSubmissao().toMilisegundos()));

        TimerTask detetarConflitosController
                = new DetetarConflitosController(this.empresa, this.evento);

        this.empresa.schedule(detetarConflitosController, new Date(
                this.evento.getDataFimSubmissao().toMilisegundos()));

        TimerTask alterarParaEmDistribuicao
                = new AlterarStateParaEmDistribuicao(this.evento);

        this.empresa.schedule(alterarParaEmDistribuicao, new Date(
                this.evento.getDataInicioDistribuicao().toMilisegundos()));

        TimerTask alterarParaEmDecisao
                = new AlterarStateParaEmDecisao(this.evento);

        this.empresa.schedule(alterarParaEmDecisao, new Date(
                this.evento.getDataFimRevisao().toMilisegundos()));

        TimerTask alterarParaEmCameraReady
                = new AlterarStateParaEmCameraReady(this.evento);

        this.empresa.schedule(alterarParaEmCameraReady, new Date(
                this.evento.getDataFimSubmissaoCameraReady().toMilisegundos()));
    }
}
