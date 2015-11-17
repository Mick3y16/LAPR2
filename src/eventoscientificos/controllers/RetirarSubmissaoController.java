/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos.controllers;

import eventoscientificos.model.Empresa;
import eventoscientificos.model.ListaSubmissoes;
import eventoscientificos.model.RegistoEventos;
import eventoscientificos.model.Submissao;
import eventoscientificos.model.Submissivel;
import eventoscientificos.model.Utilizador;
import java.util.List;

/**
 * Representa uma instância de RetirarSubmissaoController através de Empresa, s
 *
 * @author G01
 */
public class RetirarSubmissaoController {

    /**
     * Instância de empresa.
     */
    private Empresa empresa;

    /**
     * Lista de Submissiveis que podem ser removidos.
     */
    private List<Submissivel> listaSubmissiveisParaRemover;
    /**
     * Submissivel que contém a submissao a remover.
     */
    private Submissivel submissivel;

    /**
     * Utilizador autenticado no sistema.
     */
    private Utilizador utilizador;

    /**
     * Lista de submissões do utilizador.
     */
    private List<Submissao> listaSubmissoesUtilizador;
    /**
     * Submissão a retirar.
     */
    private Submissao submissao;

    /**
     * Constrói uma instância de RetirarSubmissaoController associado à empresa
     * que recebe como parãmetro.
     *
     * @param empresa empresa.
     */
    public RetirarSubmissaoController(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * Devolve a lista de submissiveis que podem ser removidos
     *
     * @return verdadeiro se houver submissiveis para remover e falso se não
     * houver
     */
    public boolean getListaSubmissiveisComArtigosUtilizadorParaRemover() {
        RegistoEventos re = empresa.getRegistoEventos();
        this.utilizador = empresa.getUtilizadorAutenticado();
        this.listaSubmissiveisParaRemover = re.getListaSubmissiveisComArtigosUtilizadorParaRemover(utilizador);
        return this.listaSubmissiveisParaRemover.size() > 0;
    }
    
    /**
     * Devolve a lista de submissíveis.
     * 
     * @return Lista de Submissíveis.
     */
    public List<Submissivel> getListaSubmissiveis() {
        return this.listaSubmissiveisParaRemover;
    }
    
    /**
     * Devolve a lista de Submissões.
     * 
     * @return Lista de Submissões.
     */
    public List<Submissao> getListaSubmissoes() {
        return this.listaSubmissoesUtilizador;
    }

    /**
     * Seleciona o Submissivel que contem a submissão a remover e apresenta
     * todas as submissões do utilizador autenticado no sistema as suas
     * submissões que podem ser removidas
     *
     * @param indice indice da posição do submissivel na lista
     * @return verdadeiro se houver submissões para remover e falso se não
     * houver.
     */
    public boolean selecionarSubmissivel(int indice) {
        this.submissivel = this.listaSubmissiveisParaRemover.get(indice);
        ListaSubmissoes listaSubmissoes = this.submissivel.getListaSubmissoes();
        this.listaSubmissoesUtilizador = listaSubmissoes.getListaSubmissoesUtilizador(this.utilizador);
        return this.listaSubmissoesUtilizador.size() > 0;
    }

    /**
     * Seleciona a submissão pretendida
     *
     * @param indice indice da posição da submissão pretendida na lista.
     * @return verdadeiro de a submissão não for nula e falso se o for.
     */
    public boolean selecionaSubmissao(int indice) {
        this.submissao = this.listaSubmissoesUtilizador.get(indice);
        return this.submissao != null;
    }

    /**
     * Remove a submissao.
     *
     * @return verdadeiro se for removida e falso se não for.
     */
    public boolean removerSubmissao() {
        return this.submissao.setEstadoRemovida();
    }
}
