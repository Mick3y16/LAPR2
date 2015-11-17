package eventoscientificos.model;

import eventoscientificos.model.state.submissao.SubmissaoAceiteState;
import eventoscientificos.model.state.submissao.SubmissaoRejeitadaState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Representa uma instância de ListaRevisoes através de uma lista de Revisões
 *
 * @author G01
 */
public class ListaRevisoes {

    /**
     * Lista de revisões.
     */
    public List<Revisao> listaRevisoes;

    /**
     * Constrói instância de ListaRevisoes.
     */
    public ListaRevisoes() {
        this.listaRevisoes = new ArrayList<>();
    }
    
    /**
     * Devolve a lista de revisões.
     * 
     * @return Lista de revisões.
     */
    public List<Revisao> getListaRevisoes() {
        return listaRevisoes;
    }

    /**
     * Modifica a lista de revisões.
     * 
     * @param listaRevisoes lista de revisões.
     */
    public void setListaRevisoes(List<Revisao> listaRevisoes) {
        this.listaRevisoes = listaRevisoes;
    }

    /**
     * Constrói uma instância de revisão com os valores recebidos por parametro
     *
     * @param submissao submissão associada à revisão
     * @param revisor revisor associado à revisão
     * @return revisão criada
     */
    public Revisao novaRevisao(Submissao submissao, Revisor revisor) {
        return new Revisao(submissao, revisor);
    }

    /**
     * Adiciona uma instância de revisão à lista de revisões
     *
     * @param revisao revisão a adicionar
     * @return verdadeiro se for adicionada com sucesso e falso se não for
     * possível adicioná-la
     */
    public boolean adicionarRevisao(Revisao revisao) {
        return this.getListaRevisoes().add(revisao);
    }

    /**
     * Devolve uma lista de revisões cujo o utilizador em sistema é revisor
     *
     * @param u utilizador em sistema
     * @return lista de revisões do revisor
     */
    public List<Revisao> getRevisoesRevisor(Utilizador u) {
        Revisor revisor = new Revisor(u);
        List<Revisao> listaRevisoesDoRevisor = new ArrayList<>();
        for (Revisao r : this.getListaRevisoes()) {
            if ((r.getRevisor().equals(revisor)) && (r.validarRevisao() == false)) {
                listaRevisoesDoRevisor.add(r);
            }
        }
        return listaRevisoesDoRevisor;
    }

    /**
     * Compara dois objetos entre si. Comparando primariamente a posição de
     * memória, seguida do conteudo e das classes as quais cada um deles
     * pertence, e finalmente os seus atributos, lista de revisões.
     *
     * @param outroObjecto ListaRevisoes a comparar
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

        ListaRevisoes outraLista = (ListaRevisoes) outroObjecto;

        return this.getListaRevisoes().equals(outraLista.getListaRevisoes());
    }

    /**
     * Devolve a taxa de aceitação e as médias de cada parâmetro de avaliação
     * (adequação, confiança, originalidade, qualidade e recomendação)
     *
     * @param nSubmissoes numero total de submissões
     * @return taxa de aceitação e as médias de cada parâmetro de avaliação.
     */
    public float[] getValoresTotaisParaEstatisticaEvento(int nSubmissoes) {
        int nSubmissoesAceites = 0, totalAdequacao = 0, totalConfianca = 0, totalOriginalidade = 0,
                            totalQualidade = 0, totalRecomendacao = 0;

        float[] vecTaxaEMediaParametrosAvaliacao = new float[6];

        for (Revisao r : this.getListaRevisoes()) {
            Submissao s = r.getSubmissao();
            if (s.isStateAceite()) {
                nSubmissoesAceites++;

                totalAdequacao += r.getAdequacaoArtigo();
                totalConfianca += r.getConfiancaRevisor();
                totalOriginalidade += r.getOriginalidadeArtigo();
                totalQualidade += r.getQualidadeArtigo();
                totalRecomendacao += r.getRecomendacaoGlobal();
            }
        }
        vecTaxaEMediaParametrosAvaliacao[0] = nSubmissoesAceites / nSubmissoes;
        vecTaxaEMediaParametrosAvaliacao[1] = totalAdequacao / nSubmissoesAceites;
        vecTaxaEMediaParametrosAvaliacao[2] = totalConfianca / nSubmissoesAceites;
        vecTaxaEMediaParametrosAvaliacao[3] = totalOriginalidade / nSubmissoesAceites;
        vecTaxaEMediaParametrosAvaliacao[4] = totalQualidade / nSubmissoesAceites;
        vecTaxaEMediaParametrosAvaliacao[5] = totalRecomendacao / nSubmissoesAceites;

        return vecTaxaEMediaParametrosAvaliacao;
    }
    
    /**
     * Preenche os mapas com as palavras chaves e respetivas recomendações
     * globais.
     * 
     * @param hashMapSubmissoesAceites Mapa de submissões aceites.
     * @param hashMapSubmissoesRejeitadas Mapa de submissões rejeitadas.
     */
    public void hashMapSubmissoes(HashMap<String, Integer> hashMapSubmissoesAceites,
            HashMap<String, Integer> hashMapSubmissoesRejeitadas) {

        for (Revisao revisao : this.listaRevisoes) {
            if (revisao.getSubmissao().getEstado() instanceof SubmissaoAceiteState) {
                List<String> palavrasChaves = revisao.getSubmissao().getArtigoInicial().getPalavrasChave();

                for (String string : palavrasChaves) {
                    Integer valor = hashMapSubmissoesAceites.get(string);
                    if (valor == null) {
                        hashMapSubmissoesAceites.put(string, revisao.getRecomendacaoGlobal());
                    } else {
                        valor = new Integer(valor.intValue() + revisao.getRecomendacaoGlobal());
                        hashMapSubmissoesAceites.put(string, valor);
                    }
                }
            }
            if (revisao.getSubmissao().getEstado() instanceof SubmissaoRejeitadaState) {
                List<String> palavrasChaves = revisao.getSubmissao().getArtigoInicial().getPalavrasChave();
                for (String string : palavrasChaves) {
                    Integer valor = hashMapSubmissoesRejeitadas.get(string);
                    if (valor == null) {
                        hashMapSubmissoesRejeitadas.put(string, revisao.getRecomendacaoGlobal());
                    } else {
                        valor = new Integer(valor.intValue() + revisao.getRecomendacaoGlobal());
                        hashMapSubmissoesRejeitadas.put(string, valor);
                    }
                }
            }
        }
    }
    
    /**
     * Devolve a revisao correspondente ao indice.
     * 
     * @param indice Indie da revisao.
     * @return Revisao.
     */
    public Revisao getRevisaoPeloID(int indice) {
         return this.listaRevisoes.get(indice);
    }
    
    /**
     * Devolve o número de revisões.
     * 
     * @return Número de revisões.
     */
    public int numeroRevisoes() {
        return this.listaRevisoes.size();
    }
}
