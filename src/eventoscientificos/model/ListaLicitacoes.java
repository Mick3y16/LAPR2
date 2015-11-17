/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma instância de ListaLicitacoes através de uma lista de
 * licitações
 *
 * @author G01
 */
public class ListaLicitacoes {

    /**
     * Lista de licitações realizadas às submissões do licitável.
     */
    private List<Licitacao> listaLicitacoes;

    /**
     * Constrói uma instância de ListaLicitações
     *
     */
    public ListaLicitacoes() {
        listaLicitacoes = new ArrayList<>();
    }

    /**
     * Cria uma lista de licitações temporária.
     *
     * @return uma lista de licitações vazia.
     */
    public List<Licitacao> criarListaLicitacoesTemporaria() {
        return new ArrayList<>();
    }

    /**
     * Cria uma nova instância do tipo Licitação
     *
     * @param revisor revisor licitador
     * @param submissao submissao a licitar
     * @param grauInteresse grau de interesse na revisão do submissao em questão
     * @param conflito conflito
     * @return licitação
     */
    public Licitacao novaLicitacao(Revisor revisor, Submissao submissao, int grauInteresse, Conflito conflito) {
        return new Licitacao(revisor, submissao, grauInteresse, conflito);
    }

    /**
     * Adiciona uma lista recebido por parâmetro à lista de licitações existente
     *
     * @param listaTemporaria lista de licitações a adicionar
     * @return verdadeiro se for adicionada com sucesso e falso se não o for
     */
    public boolean adicionarListaLicitacoesTemporaria(List<Licitacao> listaTemporaria) {
        if (listaTemporaria != null) {
            this.listaLicitacoes.addAll(listaTemporaria);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Compara dois objetos entre si. Comparando primariamente a posição de
     * memória, seguida do conteudo e das classes as quais cada um deles
     * pertence, e finalmente o seu atributo, lista de licitações.
     *
     * @param outroObjecto Lista de Licitações a comparar
     * @return Verdadeiro caso os objetos comparados sejam iguais e falso caso
     * não o sejam.
     */
    @Override
    public boolean equals(Object outroObjecto) {
        if (this == outroObjecto) {
            return true;
        }

        if (outroObjecto == null || this.getClass() != outroObjecto.getClass()) {
            return false;
        }

        ListaLicitacoes outraLista = (ListaLicitacoes) outroObjecto;

        return listaLicitacoes.equals(outraLista.listaLicitacoes);
    }

    /**
     * Verifica se existe alguma licitação associada ao utilizador
     *
     * @param u utilizador a verificar
     * @return verdadeiro se encontrou a licitação e falso se não
     */
    public boolean contains(Utilizador u) {
        for (Licitacao licitacao : this.listaLicitacoes) {
            Utilizador ut = licitacao.getRevisor().getUtilizador();
            if (ut.equals(u)) {
                return true;
            }
        }
        return false;
    }
}
