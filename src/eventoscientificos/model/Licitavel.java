/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos.model;

import java.util.List;

/**
 * Todas as classes que implementam esta interface, herdam a responsabilidade de
 * permitir a licitação de artigos cientificos, ficando obrigadas a implementar
 * uma lista com as mesmas.
 *
 * @author G01
 */
public interface Licitavel {

    /**
     * Valida se o licitável se encontra em periodo de licitação
     *
     * @param utilizador utilizador
     * @return verdadeiro se estiver em periodo de licitação e falso se não
     * estiver
     */
    public boolean isStateValidoParaLicitar(Utilizador utilizador);

    /**
     * Devolve a lista de licitações do do artigo.
     *
     * @return Devolve a lista de submissões do submissivel.
     */
    public ListaLicitacoes getListaLicitacoes();

    /**
     * Devolve uma lista de conflitos detetados entre o revisor e o artigo
     *
     * @param revisor revisor a licitar
     * @param submissao submissão a rever
     * @return lista de conflitos detetados entre o revisor e o artigo
     */
    public Conflito getConflitoRevisorSubmissao(Revisor revisor, Submissao submissao);

    /**
     * Devolve uma instância de ListaSubmissões.
     *
     * @return ListaSubmissoes
     */
    public ListaSubmissoes getListaSubmissoes();

    /**
     * Devolve a Comissão de Programa (CP).
     * @return CP
     */
    public CP getCP();

}
