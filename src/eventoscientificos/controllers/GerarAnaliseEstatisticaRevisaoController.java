package eventoscientificos.controllers;

import eventoscientificos.model.Empresa;
import eventoscientificos.model.Evento;
import eventoscientificos.model.RegistoEventos;
import eventoscientificos.model.Revisor;
import java.util.List;

/**
 * Representa instância da classe GerarAnaliseEstatisticaRevisaoController
 *
 * @author G01
 */
public class GerarAnaliseEstatisticaRevisaoController {

    /**
     * Empresa na qual é executada a análise estatistica.
     */
    private Empresa empresa;

    /**
     * RegistoEventos da empresa.
     */
    private RegistoEventos re;
    /**
     * Lista de eventos a apresentar ao administrador.
     */
    private List<Evento> listaEventosApresentados;

    /**
     * Vector com os resultados finais obtidos na análise.
     */
    private String[] resultadosFinais;

    /**
     * Lista de emails dos organizadores.
     */
    private List<String> listaEmail;

    /**
     * Constrói uma instância de GerarAnaliseEstatisticaRevisaoController
     * através de empresa que recebe como parâmetro.
     *
     * @param empresa empresa
     */
    public GerarAnaliseEstatisticaRevisaoController(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * Devolve um vetor do tipo string com os resultados dos revisores.
     *
     * @return Vetor do tipo string
     */
    public String[] getResultadosFinais() {
        return this.resultadosFinais;
    }

    /**
     * Devolve a lista de emails dos organizadores.
     * 
     * @return Lista de emails.
     */
    public List<String> getListaEmail() {
        return this.listaEmail;
    }

    /**
     * Devolve os resultados da análise estatística.
     *
     * @return verdadeiro se houver resultados da análise e falso se não for
     * possível analisar.
     */
    public boolean gerarAnaliseEstatisticas() {
        this.re = empresa.getRegistoEventos();
        this.listaEventosApresentados = re.getListaEventosGerarAnaliseEstatistica();
        re.getTodosRevisores(listaEventosApresentados);
        this.resultadosFinais = re.getValoresTotaisAnaliseEstatistica(listaEventosApresentados);
        return this.resultadosFinais.length > 0;
    }

    /**
     * Notifica os organizadores dos eventos em que o revisor é membro ad CP.
     *
     * @param indice indice do revisor na lista de revisores
     * @return verdadeiro devolver uma lista de emails preenchida e falso se
     * ficar estiver vazia.
     */
    public boolean notificarOrganizadoresEventos(int indice) {

        Revisor revisor = re.getListaRevisores().get(indice);
        List<Evento> listaEventosRevisor = this.re.getListaEventosRevisor(revisor, listaEventosApresentados);
        for (Evento e : listaEventosRevisor) {
            this.listaEmail = e.notificarOrganizador();
        }
        return this.listaEmail.size() > 0;
    }

}
