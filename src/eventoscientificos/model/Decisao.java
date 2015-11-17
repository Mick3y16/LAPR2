package eventoscientificos.model;

/**
 * Representa uma instância de uma decisão através de uma classificação e de uma
 * submissão.
 *
 * @author G01
 */
public class Decisao {

    /**
     * Classificação.
     */
    private int classificacao;

    /**
     * Instância de submissão.
     */
    private Submissao submissao;

    /**
     * Notificação de decisão.
     */
    private Notificacao notificacao;

    /**
     * Constrói uma instância de Decisao
     *
     * @param classificacao Classificação associado à submissão.
     * @param submissao Submissão associado à decisão.
     */
    public Decisao(int classificacao, Submissao submissao) {
        this.classificacao = classificacao;
        this.submissao = submissao;
    }

    /**
     * Devolve a classificação da decisão.
     *
     * @return Classificação da decisão.
     */
    public int getClassificacao() {
        return this.classificacao;
    }

    /**
     * Devolve a Submissão.
     *
     * @return Submissão.
     */
    public Submissao getSubmissao() {
        return this.submissao;
    }

    /**
     * Cria notificação a ser enviada para o autor.
     *
     * @return Verdadeiro
     */
    public boolean criarNotificacao() {
        Notificacao notificacao = new Notificacao(classificacao);
        AutorCorrespondente autorC = this.submissao.getArtigoInicial().getAutorCorrespondente();
        setEstadoSubmissao(classificacao);
        return enviarNotificacao(notificacao, autorC);
    }

    /**
     * Modifica o estado da submissão mediante a classificação.
     *
     * @param classificacao Classificação da decisão.
     * @return Verdadeiro.
     */
    private boolean setEstadoSubmissao(int classificacao) {
        if (classificacao > 2) {
            this.submissao.alterarEstadoParaAceite();
        } else {
            this.submissao.alterarEstadoParaRejeitado();
        }
        return true;
    }

    /**
     * Envia notificação passando por parâmetro a notificação e o autor
     * correspondente.
     *
     * @param notificacao Notificação
     * @param autorCorrespondente Autor Correspondente
     * @return Verdadeiro
     */
    private boolean enviarNotificacao(Notificacao notificacao, AutorCorrespondente autorCorrespondente) {
        return true;
    }

    /**
     * Compara dois objetos entre si. Comparando primariamente a posição de
     * memória, seguida do conteudo e das classes as quais cada um deles
     * pertence, e finalmente os seus atributos, classificação e submissão.
     *
     * @param outroObjecto Decisão a comparar.
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

        Decisao outraDecisao = (Decisao) outroObjecto;

        return this.classificacao == (outraDecisao.classificacao)
                            && this.submissao.equals(outraDecisao.submissao);
    }

}
