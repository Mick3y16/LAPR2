/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma instância de Licitacao através do objeto revisor, objeto
 * submissão, grau de interesse e conflitos.
 *
 * @author G01
 */
public class Licitacao {

    /**
     * Revisor que licita.
     */
    private Revisor revisor;
    /**
     * Submissão a licitar.
     */
    private Submissao submissao;
    /**
     * Grau de interesse em rever.
     */
    private int grauInteresse;
    /**
     * Conflito de interesse entre o revisor e o submissão a rever
     */
    private Conflito conflito;
    /**
     * Grau de interesse por omissão.
     */
    private static final int GRAU_INTERESSE_POR_OMISSAO = 0;

    /**
     * Constrói uma instancia de Licitacao com os valores passados por parametro
     *
     * @param revisor revisor que licita o submissão
     * @param submissao submissão a licitar
     * @param grauInteresse grau de interesse em rever o submissão
     * @param conflito conflito entre o revisor com o submissão
     */
    public Licitacao(Revisor revisor, Submissao submissao, int grauInteresse,
                        Conflito conflito) {
        this.revisor = revisor;
        this.submissao = submissao;
        setGrauInteresse(grauInteresse);
        setConflito(conflito);
    }

    /**
     * Devolve a lista de conflitos do
     *
     * @return conflito entre revisor e a submissão
     */
    public Conflito getConflito() {
        return conflito;
    }

    /**
     * Devolve o grau de interesse apresentado pelo revisor na revisão do
     * submissao
     *
     * @return grau de interesse na revisão do submissao
     */
    public int getGrauInteresse() {
        return grauInteresse;
    }

    /**
     * Devolve o revisor licitador
     *
     * @return o objeto revisor que licita o submissao
     */
    public Revisor getRevisor() {
        return revisor;
    }

    /**
     * Devolve o submissao alvo de licitação por parte do revisor
     *
     * @return o submissao licitável
     */
    public Submissao getSubmissao() {
        return submissao;
    }

    /**
     * Modifica o grau de interesse do revisor rever o submissao
     *
     * @param grauInteresse grau de interesse indicado pelo revisor
     */
    public void setGrauInteresse(int grauInteresse) {
        if (grauInteresse > 3 || grauInteresse < 0) {
            this.grauInteresse = GRAU_INTERESSE_POR_OMISSAO;
        } else {
            this.grauInteresse = grauInteresse;
        }
    }

    /**
     * Modifica os conflitos detetados entre o revisor e o submissao a rever
     *
     * @param conflito conflito a alterar pelo revisor
     */
    public void setConflito(Conflito conflito) {
        if (conflito != null) {
            this.conflito = conflito;
        }
    }

    /**
     * Valida se a licitação se encontra devidamente preenchida
     *
     * @return verdadeira se cumprir todos os requisitos de preenchimento e
     * falso se não uma licitação válida
     */
    public boolean validarLicitacao() {
        return (this.submissao != null && this.revisor != null);

    }

    /**
     * Compara dois objetos entre si. Comparando primariamente a posição de
     * memória, seguida do conteudo e das classes as quais cada um deles
     * pertence, e finalmente os seus atributos revisor, submissao, grau de
     * interesse e conflitos.
     *
     * @param outroObjeto Licitação a comparar
     * @return Verdadeiro caso os objetos comparados sejam iguais e falso caso
     * não o sejam.
     */
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }

        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }

        Licitacao outraLicitacao = (Licitacao) outroObjeto;

        return this.revisor.equals(outraLicitacao.revisor)
                            && this.submissao.equals(outraLicitacao.submissao)
                            && this.grauInteresse == outraLicitacao.grauInteresse
                            && this.conflito == outraLicitacao.conflito;
    }
}
