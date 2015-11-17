package eventoscientificos.controllers;

import eventoscientificos.model.Empresa;
import eventoscientificos.model.RegistoEventos;
import java.util.HashMap;
import utils.CSVParser;

/**
 * @author G01
 */
public class GerarEstatisticasTopicosController {

    /**
     * Instãncia de Empresa.
     */
    private Empresa empresa;

    /**
     * Mapa de submissões aceites.
     */
    private HashMap<String, Integer> hashMapSubmissoesAceites;

    /**
     * Instância de submissões rejeitadas.
     */
    private HashMap<String, Integer> hashMapSubmissoesRejeitadas;

    /**
     * Constói uma instância de GerarEstatisticasTopicosController recebendo uma 
     * empresa.
     * 
     * @param empresa Empresa.
     */
    public GerarEstatisticasTopicosController(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * Preenche os mapas com as palavras chaves e respetivas recomendações
     * globais nos respetivos mapas dependendo se a submissão foi aceite ou
     * rejeitada.
     */
    public boolean getHashMap() {

        RegistoEventos registoEventos = this.empresa.getRegistoEventos();

        this.hashMapSubmissoesAceites = new HashMap();

        this.hashMapSubmissoesRejeitadas = new HashMap();

        registoEventos.hashMapSubmissoes(hashMapSubmissoesAceites,
                hashMapSubmissoesRejeitadas);
        
        return this.hashMapSubmissoesAceites.size() > 0 
                && this.hashMapSubmissoesRejeitadas.size() > 0;
    }

    /**
     * Produz um ficheiro CSV com os dados contidos nos mapas.
     */
    public void gerarFicheiroCSV() {

        CSVParser csvParser = new CSVParser();
        csvParser.gerarFicheiroCSVEstatisticas(hashMapSubmissoesAceites,
                hashMapSubmissoesRejeitadas);
    }
}
