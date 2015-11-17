package eventoscientificos.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma instância de ListaDecisoes, através de uma lista de decisões.
 *
 * @author G01
 */
public class ListaDecisoes {

    /**
     * Lista de decisões.
     */
    private List<Decisao> listaDecisoes;

    /**
     * Constrói uma instância de ListaDecisoes vazia.
     */
    public ListaDecisoes() {
        listaDecisoes = new ArrayList<>();
    }

    /**
     * Devolve lista de decisões.
     *
     * @return listaDecisoes.
     */
    public List<Decisao> getListaDecisoes() {
        return this.listaDecisoes;
    }

    /**
     * Cria uma nova instância de Decisão.
     *
     * @param classificacao classificação da submissão.
     * @param submissao submissão a decidir.
     * @return Decisão criada.
     */
    public Decisao novaDecisao(int classificacao, Submissao submissao) {
        return new Decisao(classificacao, submissao);
    }

    /**
     * Adiciona na lista de decisões uma decisão.
     *
     * @param decisao Decisão a adicionar na lista.
     * @return Lista de decisões.
     */
    public boolean adicionarDecisao(Decisao decisao) {
        return listaDecisoes.add(decisao);
    }
    
    /**
     * Cria uma notificação para cada Decisão.
     * 
     * @return Resultado da notificação.
     */
    public boolean notificarSobreDecisao() {
        boolean result = false;
        for (Decisao element : listaDecisoes) {
            result = element.criarNotificacao();
        }
        return result;
    }

    /**
     * Compara dois objetos entre si. Comparando primariamente a posição de
     * memória, seguida do conteudo e das classes as quais cada um deles
     * pertence, e finalmente os seus atributos, lista de decisões .
     *
     * @param outroObjecto ListaDecisoes.
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

        ListaDecisoes outraLista = (ListaDecisoes) outroObjecto;

        return this.listaDecisoes.equals(outraLista.listaDecisoes);
    }
    
     /**
     * Devolve a decisao correspondente ao indice.
     * 
     * @param indice Indie da decisao.
     * @return Decisao.
     */
    public Decisao getDecisaoPeloID(int indice) {
         return this.listaDecisoes.get(indice);
    }
    
    /**
     * Devolve o número de Decisões.
     * 
     * @return Número de Decisões.
     */
    public int numeroDecisoes() {
        return this.listaDecisoes.size();
    }

}
