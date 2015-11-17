package eventoscientificos.controllers;

import eventoscientificos.model.Empresa;
import eventoscientificos.model.Evento;
import eventoscientificos.model.RegistoEventos;
import eventoscientificos.model.Utilizador;
import java.util.List;

/**
 * Representa uma instância de GerarEstatisticasEventoController através de
 * Empresa, listaEventos e estatisticas do evento
 *
 *
 * @author G01
 */
public class GerarEstatisticasEventoController {

    /**
     * Instancia de empresa.
     */
    private Empresa empresa;

    /**
     * Lista de Eventos que permitem organizador gerar as estatísticas.
     */
    private List<Evento> listaEventos;

    /**
     * Estatisticas do evento.
     */
    private float[] estatisticas;

    /**
     * Constrói uma instância GerarEstatisticasEventoController com uma empresa
     *
     * @param empresa empresa
     */
    public GerarEstatisticasEventoController(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * Devolve o vetor de esttísticas.
     * 
     * @return Vetor de float.
     */
    public float[] getEstatisticas() {
        return this.estatisticas;
    }

    /**
     * Devolve a lista de eventos.
     * 
     * @return Lista de Eventos.
     */
    public List<Evento> getListaEventos() {
        return this.listaEventos;
    }
    
    /**
     * Devolve uma lista de Eventos em que o utilizador autenticado é um
     * Organizador e cujas as submissões se encontrem decidas
     *
     * @return verdadeiro de encontrar uma lista de eventos nas condições
     * necessárias e falso se vier vazia
     */
    public boolean getListaEventosOrganizadorDecididos() {
        RegistoEventos re = empresa.getRegistoEventos();
        Utilizador u = empresa.getUtilizadorAutenticado();
        this.listaEventos = re.getListaEventosOrganizadorEmSubmissaoCameraReady(u);
        return this.listaEventos.size() > 0;
    }

    /**
     * Seleciona um evento do organizador e gera as estatisticas do mesmo
     *
     * @param indice indice posicional do evento na lista
     * @return verdadeiro se for possivel gerar estatisticas do mesmo e falso se
     * não for possível
     */
    public boolean selecionarEventosEGerarEstatisticas(int indice) {
        Evento evento = this.listaEventos.get(indice);
        this.estatisticas = evento.getValoresTotaisEstatisticaEvento();
        return estatisticas.length > 0;
    }

}
