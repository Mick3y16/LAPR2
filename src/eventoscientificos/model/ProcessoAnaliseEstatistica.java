/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Constrói um instância de ProcessoAnaliseEstatistica através
 *
 * @author G01
 */
public class ProcessoAnaliseEstatistica {

    /**
     * Lista de revisoes.
     */
    private List<Revisao> listaRevisoes;

    /**
     * Lista de submissoes.
     */
    private List<Submissao> listaSubmissoes;

    /**
     * Lista de todos os revisores.
     */
    private List<Revisor> listaRevisores;
    /**
     * Matriz de médias classificações dos revisores por submissão.
     */
    private double[][] matrizMediasRevisorSubmissao;

    /**
     * Matriz com as diferenças entre a classificação do revisor com a
     * classificação média do artigo.
     */
    private double[][] matrizDiferencasClassRevisorComMediaArtigo;

    /**
     * Vetor com os desviosPadrao de cada revisor quanto á classificação final.
     */
    private double[] vecDesvioPadraoRevisor;
    /**
     * Média geral de todos os artigos.
     */
    private double mediaArtigos;
    /**
     * Vetor das médias dos desvios de cada revisor [dmédia].
     */
    private double[] mediaDesvio;
    /**
     * Vetor com o numero de revisões de cada revisor.
     */
    private int[] nrRevisoes;

    /**
     * Constrói uma instância de ProcessoAnaliseEstatistica através dos valores
     * recebidos por parâmetro
     *
     * @param lr lista de revisões
     * @param listaSubmissoes lista de submissões
     * @param listaRevisores lista de todos os revisores dos eventos da empresa
     */
    public ProcessoAnaliseEstatistica(List<Revisao> lr, List<Submissao> listaSubmissoes, List<Revisor> listaRevisores) {
        this.listaRevisoes = lr;
        this.listaSubmissoes = listaSubmissoes;
        this.listaRevisores = listaRevisores;
    }

    /**
     * Devolve os valores de estatística de cada submissao do artigo.
     * @return valores das estatísticas
     */
    public String[] getValoresEstatistica() {
        List<Submissao> listaSubmissoesAceites = listaSubmissoesAceites();
        if (listaSubmissoesAceites.size() > 0) {
            matrizSubmissoesRevisor();
            preencherMatrizMediasRevisorArtigo(listaSubmissoesAceites);
            // calcularMediaTodosArtigos();
            preencherMatrizDiferencasClassRevisorMediaArtigo();
            calcularVecMediaDesvioPorRevisorTodosArtigos();
            preencherVetorDesvioPadraoPorRevisor();
            return testesHipoteses();
        } else {
            throw new IllegalStateException("Não há submissoes aceites");
        }
    }

    /**
     * Devolve a lista de submissões aceites no revisivel
     *
     * @return a lista de submissões aceites no revisivel
     */
    private List<Submissao> listaSubmissoesAceites() {
        List<Submissao> listaSubmissoesAceites = new ArrayList<>();
        for (Submissao s : listaSubmissoes) {
            if (s.isStateAceite() && !listaSubmissoesAceites.contains(s)) {
                listaSubmissoesAceites.add(s);

            }
        }
        return listaSubmissoesAceites;
    }

    /**
     * Constrói uma inicial com -100 onde não existe ligação entre o revisor e a
     * submissão analisada
     */
    private void matrizSubmissoesRevisor() {
        this.matrizMediasRevisorSubmissao = new double[listaSubmissoesAceites().size()][listaRevisores.size()];
        for (Submissao s : listaSubmissoesAceites()) {
            int linha = listaSubmissoesAceites().indexOf(s);
            for (Revisao r : listaRevisoes) {
                if (r.getSubmissao().equals(s)) {
                    int coluna = listaRevisores.indexOf(r.getRevisor());
                    matrizMediasRevisorSubmissao[linha][coluna] = 1;
                    System.out.println(matrizMediasRevisorSubmissao[linha][coluna]);
                }
            }

        }
        for (int i = 0; i < matrizMediasRevisorSubmissao.length; i++) {
            for (int j = 0; j < matrizMediasRevisorSubmissao[0].length; j++) {
                if (matrizMediasRevisorSubmissao[i][j] != 1) {
                    matrizMediasRevisorSubmissao[i][j] = -100;
                } else {
                    matrizMediasRevisorSubmissao[i][j] = 0;
                }
            }
        }
    }

    /**
     * Preenche a matriz com as classificações médias do revisor para cada
     * submissao.
     *
     * @param listaSubmissoesAceites lista de submissões aceites
     */
    private void preencherMatrizMediasRevisorArtigo(List<Submissao> listaSubmissoesAceites) {
        double somaMediaClass = 0, numeroRevisoesContabilizadas = 0;
        for (Submissao s : listaSubmissoesAceites) {
            int linha = listaSubmissoesAceites.indexOf(s);
            for (Revisao r : listaRevisoes) {
                if (r.getSubmissao().equals(s)) {
                    Revisor revisor = r.getRevisor();
                    int coluna = listaRevisores.indexOf(revisor);
                    double mediaClassificacao = (r.getAdequacaoArtigo()
                                        + r.getConfiancaRevisor()
                                        + r.getOriginalidadeArtigo()
                                        + r.getQualidadeArtigo()
                                        + r.getRecomendacaoGlobal()) / 5;
                    this.matrizMediasRevisorSubmissao[linha][coluna] = mediaClassificacao;
                    somaMediaClass += mediaClassificacao;
                    numeroRevisoesContabilizadas++;
                }
            }
        }
        this.mediaArtigos = (double) (somaMediaClass / numeroRevisoesContabilizadas);
    }

    /**
     * Preenche a matriz das diferenças entre a classificação média atribuida
     * pelo revisor e a classificação média do artigo [d=xi-xt].
     */
    private void preencherMatrizDiferencasClassRevisorMediaArtigo() {
        int contaNrRevisoresPSubmissao = 0;
        this.matrizDiferencasClassRevisorComMediaArtigo = new double[matrizMediasRevisorSubmissao.length][matrizMediasRevisorSubmissao[0].length];
        for (int i = 0; i < matrizMediasRevisorSubmissao.length; i++) {
            for (int j = 0; j < matrizMediasRevisorSubmissao[0].length; j++) {
                if (matrizMediasRevisorSubmissao[i][j] != -100) {
                    matrizDiferencasClassRevisorComMediaArtigo[i][j] = Math.abs((matrizMediasRevisorSubmissao[i][j] - this.mediaArtigos));
                }
            }

        }
    }

    /**
     * Calcula o vector do desvio médio de cada revisor para todos os seus
     * artigos [d media=soma di/n].
     */
    private void calcularVecMediaDesvioPorRevisorTodosArtigos() {

        this.mediaDesvio = new double[matrizDiferencasClassRevisorComMediaArtigo[0].length];
        this.nrRevisoes = new int[matrizDiferencasClassRevisorComMediaArtigo[0].length];
        for (int i = 0; i < matrizDiferencasClassRevisorComMediaArtigo[0].length; i++) {
            double somaColuna = 0;
            int nrRevisoes = 0;
            for (int j = 0; j < matrizDiferencasClassRevisorComMediaArtigo.length; j++) {
                if (matrizDiferencasClassRevisorComMediaArtigo[j][i] != -100) {
                    somaColuna += matrizDiferencasClassRevisorComMediaArtigo[j][i];
                    nrRevisoes++;
                }

            }
            mediaDesvio[i] = somaColuna / nrRevisoes;
            this.nrRevisoes[i] = nrRevisoes;
        }
    }

    /**
     * Preenche o vetor com os valores dos desvios-padrão para cada submissão.
     */
    private void preencherVetorDesvioPadraoPorRevisor() {
        double somatorio = 0;
        int contador = 0;
        this.vecDesvioPadraoRevisor = new double[matrizMediasRevisorSubmissao[0].length];
        for (int j = 0; j < matrizMediasRevisorSubmissao[0].length; j++) {
            for (int i = 0; i < matrizMediasRevisorSubmissao.length; i++) {
                double d = matrizDiferencasClassRevisorComMediaArtigo[i][j];
                if (d != -100) {
                    double dMedia = this.mediaDesvio[j];
                    double calculo = Math.pow((d - dMedia), 2);
                    somatorio += calculo;
                    contador++;

                }
            }
            double valor = somatorio / contador;
            double desvioPadrao = Math.sqrt(valor);
            vecDesvioPadraoRevisor[j] = desvioPadrao;
        }

    }

    /**
     * Testes de hipótese
     *
     */
    private String[] testesHipoteses() {
        String[] vecHipoteses = new String[this.vecDesvioPadraoRevisor.length];
        for (int j = 0; j < this.vecDesvioPadraoRevisor.length; j++) {

            if (this.nrRevisoes[j] > 29) {
                if (vecDesvioPadraoRevisor[j] > 1) {
                    double z = this.mediaDesvio[j] - 1 / (this.vecDesvioPadraoRevisor[j] / Math.sqrt(this.nrRevisoes[j]));
                    if (z > 1.645) {
                        vecHipoteses[j] = "O revisor tem um desvio superior a 1 para um 95% de confiança";
                    } else {
                        vecHipoteses[j] = "O revisor não tem um desvio superior a 1 para um 95% de confiança";
                    }
                } else {
                    vecHipoteses[j] = "Não há diferença significativa do desvio para a média geral";
                }
            } else {
                vecHipoteses[j] = "Não é possivel analisar pois tem menos de 30 revisões";
            }
        }
        return vecHipoteses;
    }
}
