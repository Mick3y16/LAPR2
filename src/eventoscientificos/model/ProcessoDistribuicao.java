/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos.model;

import eventoscientificos.model.mecanismo.distribuicao.MecanismoDistribuicao;
import java.util.HashMap;

/**
 * Representa uma instância de ProcessoDistribuicao através de
 * RegistoUtilizadores e RegistoEventos.
 *
 * @author G01
 */
public class ProcessoDistribuicao {

    /**
     * Instância de ListaRevisoes.
     */
    private ListaRevisoes listaRevisoes;

    /**
     * Instância de MecanismoDistribuicao.
     */
    private MecanismoDistribuicao mecanismoDistribuicao;

    /**
     * Constrói uma instância de Processo de Distribuição.
     */
    public ProcessoDistribuicao() {
        this.listaRevisoes = new ListaRevisoes();
    }

    /**
     * Devolve a ListaRevisões.
     *
     * @return Lista Revisões
     */
    public ListaRevisoes getListaRevisoes() {
        return this.listaRevisoes;
    }

    /**
     * Adiciona uma Mecanismo de Distribuição ao processo de distribuição.
     *
     * @param mecanismoDistribuicao mecanismo de distribuicao a adicionar
     * @return verdadeiro
     */
    public boolean adicionarMecanismoDistribuicao(MecanismoDistribuicao mecanismoDistribuicao) {
        if (mecanismoDistribuicao != null) {
            this.mecanismoDistribuicao = mecanismoDistribuicao;
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Promove a distribuição das revisões, através da criação de uma lista de
     * revisões e encarregando o mecanismo da distribuição propriamente dita
     *
     * @param distribuivel ao qual é pretendido fazer a distribuição das
     * revisões
     * @return se for distribuido com sucesso retorna listaRevisoes e caso não o
     * tenha sido, retorna null
     */
    public ListaRevisoes distribuirRevisoes(Distribuivel distribuivel) {
        this.listaRevisoes = new ListaRevisoes();
        this.mecanismoDistribuicao.
                distribuirRevisoes(distribuivel, listaRevisoes);
        if (listaRevisoes == null) {
            throw new NullPointerException("Não foi possível distribuir");
        } else {
            return listaRevisoes;
        }
    }

    /**
     * Compara dois objetos entre si. Comparando primariamente a posição de
     * memória, seguida do conteudo e das classes as quais cada um deles
     * pertence, e finalmente os seus atributos, lista de revisões e mecanismo
     * de distribuição.
     *
     * @param outroObjecto Processo de distribuição a comparar
     * @return Verdadeiro caso os objetos comparados sejam iguais e falso caso
     * não o sejam.
     */
    @Override
    public boolean equals(Object outroObjecto
    ) {
        if (this == outroObjecto) {
            return true;
        }

        if (outroObjecto == null || this.getClass() != outroObjecto.getClass()) {
            return false;
        }

        ProcessoDistribuicao outroProcesso = (ProcessoDistribuicao) outroObjecto;

        return this.listaRevisoes.equals(outroProcesso.listaRevisoes)
                && this.mecanismoDistribuicao.equals(outroProcesso.mecanismoDistribuicao);
    }

    /**
     * Preenche os mapas com as palavras chaves e respetivas recomendações
     * globais.
     *
     * @param hashMapSubmissoesAceites Mapa de submissões aceites.
     * @param hashMapSubmissoesRejeitadas Mapa de submissões rejeitadas.
     */
    public void hashMapSubmissoes(
            HashMap<String, Integer> hashMapSubmissoesAceites,
            HashMap<String, Integer> hashMapSubmissoesRejeitadas) {

        this.listaRevisoes.hashMapSubmissoes(hashMapSubmissoesAceites,
                hashMapSubmissoesRejeitadas);
    }
}
