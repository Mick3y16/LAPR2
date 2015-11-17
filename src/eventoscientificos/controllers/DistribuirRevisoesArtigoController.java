/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos.controllers;

import eventoscientificos.model.Distribuivel;
import eventoscientificos.model.Empresa;
import eventoscientificos.model.ListaRevisoes;
import eventoscientificos.model.mecanismo.distribuicao.MecanismoDistribuicao;
import eventoscientificos.model.ProcessoDistribuicao;
import eventoscientificos.model.RegistoEventos;
import java.util.List;

/**
 * Representa uma instância de DistribuirRevisoesArtigoController, através de um
 * registo de utilizadores
 *
 * @author G01
 */
/**
 * Representa uma instância de DistribuirRevisoesArtigoController através dos
 * objetos
 *
 * @author G01
 */
public class DistribuirRevisoesArtigoController {

    /**
     * Instância de empresa.
     */
    private Empresa empresa;

    /**
     * Lista de distribuiveis.
     */
    private List<Distribuivel> listaDistribuivel;

    /**
     * Instância de Distribuivel.
     */
    private Distribuivel distribuivel;

    /**
     * Instância de ProcessoDistrbuição.
     */
    private ProcessoDistribuicao processoDistribuicao;

    /**
     * Lista de Mecanismos de Distribuição.
     */
    private List<MecanismoDistribuicao> listaMecanismoDistribuicao;

    /**
     * Lista de Revisões.
     */
    private ListaRevisoes listaRevisoes;

    /**
     * Constrói uma instância de DistribuirRevisoesArtigoController.
     *
     * @param empresa empresa
     */
    public DistribuirRevisoesArtigoController(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * Devolve a uma lista de distribuiveis onde o utilizador em sistema está
     * nomeado como organizador ou proponente
     *
     * @return verdadeiro se encontrar distribuiveis diferentes
     */
    public boolean getListaDistribuiveisOrganizadorProponente() {
        RegistoEventos re = this.empresa.getRegistoEventos();
        this.listaDistribuivel = re.getListaDistribuiveisOrganizadorProponente(
                            this.empresa.getUtilizadorAutenticado());
        return this.listaDistribuivel != null;

    }

    /**
     * Seleciona o distribuivel da lista de distribuiveis onde o utilizador
     * pretende efetuar a distribuição
     *
     * @param indice indice do distribuivel na lista de detetáveis
     * @return verdadeiro se for importado os mecanismos de distribuição da empresa com sucesso e falso se não
     * for possivel criá-lo
     */
    public boolean selecionarDistribuivel(int indice) {
        this.distribuivel = this.listaDistribuivel.get(indice);
        this.processoDistribuicao = this.distribuivel.novoProcessoDistribuicao();
        this.listaMecanismoDistribuicao = empresa.getListaMecanismoDistribuicao();
        return listaMecanismoDistribuicao.size() > 0;
    }

    /**
     * Adiciona o mecanismo distribuição selecionado ao processo de distribuição
     *
     * @param indice indice do mecanismo de deteção selecionado na lista de
     * mecanismos
     * @return verdadeiro se for gerada uma lista de revisões e false se não for
     */
    public boolean adicionarMecanismoDistribuicao(int indice) {
        MecanismoDistribuicao md = this.listaMecanismoDistribuicao.get(indice);
        this.processoDistribuicao.adicionarMecanismoDistribuicao(md);
        this.listaRevisoes = this.processoDistribuicao.distribuirRevisoes(distribuivel);
        return this.listaRevisoes != null;
    }

    /**
     * Adiciona o processo de distribuição ao distribuivel.
     *
     * @return verdadeiro se adicionar com sucesso e falso se não for possível
     * adicionar
     */
    public boolean adicionarProcessoDistribuicao() {
        return this.distribuivel.adicionarProcessoDistribuicao(processoDistribuicao);
    }
}
