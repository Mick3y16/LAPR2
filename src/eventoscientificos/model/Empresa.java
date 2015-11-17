package eventoscientificos.model;

import eventoscientificos.model.mecanismo.decisao.MecanismoDecisao;
import eventoscientificos.model.mecanismo.distribuicao.MecanismoDistribuicao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Representa uma instância de Empresa através de RegistoUtilizadores e
 * RegistoEventos.
 *
 * @author G01
 */
public class Empresa {

    /**
     * Lista de administradores da empresa.
     */
    List<Administrador> listaAdministradores;

    /**
     * Utilizador autenticado da empresa.
     */
    private Utilizador utilizadorAutenticado;

    /**
     * Registo de utilizadores da empresa.
     */
    private RegistoUtilizadores registoUtilizadores;

    /**
     * Registo de eventos da empresa.
     */
    private RegistoEventos registoEventos;

    /**
     * Registo de tipos de conflitos da empresa.
     */
    private RegistoTiposConflito registoTiposConflito;
    
    /**
     * Registo de mecanismos de leitura de ficheiros da empresa.
     */
    private RegistoMecanismosLeitura registoMecanismosLeitura;

    /**
     * Temporizador que controla a agenda da empresa.
     */
    private Timer temporizador;

    /**
     * Lista de mecanismo de distribuição.
     */
    private List<MecanismoDistribuicao> listaMecanismoDistribuicao;

    /**
     * Lista de mecanismo de decisão.
     */
    private List<MecanismoDecisao> listaMecanismoDecisao;

    /**
     * Constrói uma instância de Empresa nao recebendo quaisquer valores por
     * parametro.
     */
    public Empresa() {
        this.listaAdministradores = new ArrayList<>();
        this.listaAdministradores.add(new Administrador(
                new Utilizador("Hulk", "hulk@marvel.com", "hulk@marvel.com", "green.man")));
        this.registoUtilizadores = new RegistoUtilizadores();
        this.registoEventos = new RegistoEventos();
        this.registoTiposConflito = new RegistoTiposConflito();
        this.registoMecanismosLeitura = new RegistoMecanismosLeitura();
        this.listaMecanismoDistribuicao = new ArrayList<MecanismoDistribuicao>();
        this.listaMecanismoDecisao = new ArrayList<MecanismoDecisao>();
        this.temporizador = new Timer();
    }

    /**
     * Devolve o Utilizador Autenticado.
     *
     * @return Utilizador Autenticado.
     */
    public Utilizador getUtilizadorAutenticado() {
        return this.utilizadorAutenticado;
    }

    /**
     * Devolve o Registo de Utilizadores.
     *
     * @return Registo de Utilizadores.
     */
    public RegistoUtilizadores getRegistoUtilizadores() {
        return this.registoUtilizadores;
    }

    /**
     * Devolve o Registo de Eventos.
     *
     * @return RegistoEventos.
     */
    public RegistoEventos getRegistoEventos() {
        return this.registoEventos;
    }

    /**
     * Devolve o Registo de Tipos de Conflito.
     *
     * @return Registo de Tipos de Conflito.
     */
    public RegistoTiposConflito getRegistoTiposConflito() {
        return this.registoTiposConflito;
    }
    
    /**
     * Devolve o Registo de Mecanismos de Leitura
     *
     * @return Registo de Mecanismos de Leitura.
     */
    public RegistoMecanismosLeitura getRegistoMecanismosLeitura() {
        return this.registoMecanismosLeitura;
    }

    /**
     * Devolve a lista de mecanismos de distribuições que a empresa
     * disponibiliza para distribuir.
     *
     * @return Lista de mecanismos de distribuicao.
     */
    public List<MecanismoDistribuicao> getListaMecanismoDistribuicao() {
        return listaMecanismoDistribuicao;
    }
    
    /**
     * Devolve a lista de mecanismos de distribuições que a empresa
     * disponibiliza para distribuir.
     *
     * @return Lista de mecanismos de distribuicao.
     */
    public List<MecanismoDecisao> getListaMecanismoDecisao() {
        return this.listaMecanismoDecisao;
    }

    /**
     * Modifica o Utilizador Autenticado.
     *
     * @param utilizadorAutenticado Novo Utilizador Autenticado.
     */
    public void setUtilizadorAutenticado(Utilizador utilizadorAutenticado) {
        this.utilizadorAutenticado = utilizadorAutenticado;
    }

    /**
     * Agenda no temporizador da empresa uma tarefa a ser executada na data
     * definidia.
     *
     * @param task Tarefa a ser executada.
     * @param date Data em que a tarefa irá ser executada.
     */
    public void schedule(TimerTask task, Date date) {
        this.temporizador.schedule(task, date);
    }
    
    /**
     * Verifica se o utilizador passado por parâmetro é administrador da empresa.
     * 
     * @param administrador administrador
     * @return Verdadeiro se o utilizador está inserido na lista de administradores
     * e falso se não está.
     */
    public boolean isAdministrador(Administrador administrador) {
        return this.listaAdministradores.contains(administrador);
    }

}
