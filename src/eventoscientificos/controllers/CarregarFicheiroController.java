package eventoscientificos.controllers;

import eventoscientificos.model.Empresa;
import eventoscientificos.model.Evento;
import eventoscientificos.model.RegistoEventos;
import eventoscientificos.model.RegistoMecanismosLeitura;
import eventoscientificos.model.RegistoUtilizadores;
import eventoscientificos.model.mecanismo.leitura.MecanismoLeitura;
import java.util.List;

/**
 * Representa uma instância de CarregarFicheiroController, através de uma
 * empresa, uma lista de eventos e um evento.
 * 
 * @author G01
 */
public class CarregarFicheiroController {

    /**
     * Empresa que contém os dados.
     */
    private Empresa empresa;

    /**
     * Lista de eventos a aceitar artigos.
     */
    private List<Evento> listaEventosAceitarEventos;

    /**
     * Lista de eventos a aceitar artigos.
     */
    private Evento evento;

    /**
     * Constrói uma instância de CarregarFicheiroController através de uma
     * empresa.
     * 
     * @param empresa empresa a instanciar
     */
    public CarregarFicheiroController(Empresa empresa) {
        this.empresa = empresa;
        this.listaEventosAceitarEventos = null;
        this.evento = null;
    }

    /**
     * Devolve a lista de eventos.
     * 
     * @return Lista de Eventos. 
     */
    public List<Evento> getListaEventosAceitarEventos() {
        return listaEventosAceitarEventos;
    }

    /**
     * Trata de criar uma lista de eventos que estejam a aceitar artigos e 
     * guarda-a.
     * 
     * @return Verdadeiro se for possível obter a lista e falso caso não seja.
     */
    public boolean getListaEventosAceitarArtigos() {
        RegistoEventos registoEventos = this.empresa.getRegistoEventos();
        this.listaEventosAceitarEventos
                = registoEventos.getListaEventosAceitarArtigos();

        return this.listaEventosAceitarEventos != null;
    }

    /**
     * Seleciona o evento para o qual se destina a submissão por ficheiro.
     * 
     * @param indice Posição do evento na lista.
     * 
     * @return Verdadeiro se o evento for selecionado com sucesso e falso caso
     * não seja.
     */
    public boolean selecionarEvento(int indice) {
        this.evento = this.listaEventosAceitarEventos.get(indice);
        
        return this.evento != null;
    }

    /**
     * Tenta carregar a submissão de um artigo para dentro de um evento ou 
     * sessão temática que exista no mesmo.
     * 
     * @param ficheiro Ficheiro do qual é extraida a submissão.
     * 
     * @return Verdadeiro se a submissão do ficheiro ocorrer com sucesso e falso
     * caso falhe.
     */
    public boolean submeterFicheiro(String ficheiro) {
        RegistoMecanismosLeitura registoMecanismosLeitura
                = this.empresa.getRegistoMecanismosLeitura();

        MecanismoLeitura mecanismoLeitura
                = registoMecanismosLeitura.getMecanismoAdequadoAoFicheiro(ficheiro);

        if (mecanismoLeitura == null) {
            throw new NullPointerException();
        }

        RegistoUtilizadores registoUtilizadores = this.empresa.getRegistoUtilizadores();

        return mecanismoLeitura.lerFicheiroSubmissao(
                registoUtilizadores, this.evento, ficheiro);
    }
}
