package eventoscientificos.model;

import eventoscientificos.model.mecanismo.decisao.MecanismoDecisao;
import eventoscientificos.model.mecanismo.decisao.MecanismoDecisao1;

/**
 * Representa uma instância de ProcessoDecisao através de RegistoEventos.
 *
 * @author G01
 */
public class ProcessoDecisao {

    /**
     * Instância de ListaRevisoes.
     */
    private ListaDecisoes listaDecisoes;

    /**
     * Instância de MecanismoDecisao.
     */
    private MecanismoDecisao mecanismoDecisao;

    /**
     * Constroi uma instancia de ProcessoDecisao, sem parâmetros.
     */
    public ProcessoDecisao() {
        this.listaDecisoes = new ListaDecisoes();
        this.mecanismoDecisao = new MecanismoDecisao1();
    }

    /**
     * Devolve a lista de decisões.
     *
     * @return Lista de decisões.
     */
    public ListaDecisoes getListaDecisoes() {
        return this.listaDecisoes;
    }

    /**
     * Adiciona um Mecanismo de Decisão ao processo de decisão.
     *
     * @param mecanismoDecisao Mecanismo de decisão a adicionar.
     * @return Verdadeiro.
     */
    public boolean adicionarMecanismoDecisao(MecanismoDecisao mecanismoDecisao) {
        if (mecanismoDecisao != null) {
            this.mecanismoDecisao = mecanismoDecisao;
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Retorna uma lista de decisões com as classificações das submissões.
     *
     * @param listaRevisoes Lista de revisões.
     * @return Lista de decisões.
     */
    public ListaDecisoes classificarSubmissoes(ListaRevisoes listaRevisoes) {

        ListaDecisoes listaDecisoes = this.mecanismoDecisao.classificarSubmissoes(listaRevisoes);
        adicionarListaDecisoes(listaDecisoes);

        return listaDecisoes;
    }

    /**
     * Verifica se é possivel adicionar uma lista de decisões.
     *
     * @param listaDecisoes Lista de decisões.
     * @return Verdadeiro caso consiga adicionar e falso se não conseguir.
     */
    private boolean adicionarListaDecisoes(ListaDecisoes listaDecisoes) {
        return (this.listaDecisoes = listaDecisoes) != null;
    }

    /**
     * Cria uma notificação para cada uma das decisões.
     *
     * @return Verdadeiro.
     */
    public boolean notificarSobreDecisoes() {
        return listaDecisoes.notificarSobreDecisao();
    }

    /**
     * Compara dois objetos entre si. Comparando primariamente a posição de
     * memória, seguida do conteudo e das classes as quais cada um deles
     * pertence, e finalmente os seus atributos, lista de revisões e mecanismo
     * de decisao.
     *
     * @param outroObjecto Processo de decisão a comparar.
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

        ProcessoDecisao outroProcesso = (ProcessoDecisao) outroObjecto;

        return this.listaDecisoes.equals(outroProcesso.listaDecisoes)
                            && this.mecanismoDecisao.getClass().getSimpleName().equalsIgnoreCase(outroProcesso.mecanismoDecisao.getClass().getSimpleName());
    }
}
