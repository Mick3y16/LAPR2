package eventoscientificos.model;

import eventoscientificos.model.state.submissao.SubmissaoRevistaState;

/**
 * Representa uma instância de um Revisao através de submissão e revisor.
 *
 * @author G01
 */
public class Revisao {

    /**
     * Instância de submissão.
     */
    private Submissao submissao;

    /**
     * Instância de revisor.
     */
    private Revisor revisor;

    /**
     * Nível de perícia em relação ao tópico.
     */
    private int confiancaRevisor;

    /**
     * Adequação do artigo em relação ao evento.
     */
    private int adequacaoArtigo;

    /**
     * Orgininalidade do artigo.
     */
    private int originalidadeArtigo;

    /**
     * Qualidade do artigo submetido.
     */
    private int qualidadeArtigo;
    /**
     * Recomendação global de um artigo.
     */
    private int recomendacaoGlobal;
    /**
     * Texto justificativo da avaliação efetuada.
     */
    private String textoJustificativo;

    /**
     * Estado revisto da revisão.
     */
    private boolean revisto;
    /**
     * Confiança do revisor em relação ao topico do artigo por omissão.
     */
    private static final int CONFIANCA_REVISOR_POR_OMISSAO = -1;
    /**
     * Adequação do artigo or omissão.
     */
    private static final int ADEQUACAO_ARTIGO_POR_OMISSAO = -1;
    /**
     * Orgininalidade do artigo por omissão.
     */
    private static final int ORIGINALIDADE_ARTIGO_POR_OMISSAO = -1;
    /**
     * Qualidade do artigo por omissão.
     */
    private static final int QUALIDADE_ARTIGO_POR_OMISSAO = -1;
    /**
     * Recomendação global por omissão.
     */
    private static final int RECOMENDACAO_GLOBAL_POR_OMISSAO = -3;

    /**
     * Breve texto justificativo por omissão.
     */
    private static final String BREVE_TEXTO_JUSTIFICATIVO_POR_OMISSAO = "";

    /**
     * Constrói uma instância de revisão através dos valores recebidos por
     * parâmetro e com os restantes por omissão.
     *
     * @param submissao submissão associado à revisão
     * @param revisor revisor associado à revisão
     */
    public Revisao(Submissao submissao, Revisor revisor) {
        this.submissao = submissao;
        this.revisor = revisor;
        this.revisto = false;
        this.adequacaoArtigo = ADEQUACAO_ARTIGO_POR_OMISSAO;
        this.confiancaRevisor = CONFIANCA_REVISOR_POR_OMISSAO;
        this.originalidadeArtigo = ORIGINALIDADE_ARTIGO_POR_OMISSAO;
        this.qualidadeArtigo = QUALIDADE_ARTIGO_POR_OMISSAO;
        this.recomendacaoGlobal = RECOMENDACAO_GLOBAL_POR_OMISSAO;
        this.textoJustificativo = BREVE_TEXTO_JUSTIFICATIVO_POR_OMISSAO;
    }

    /**
     * Devolve o revisor associado à revisão.
     *
     * @return Revisor
     */
    public Revisor getRevisor() {
        return this.revisor;
    }

    /**
     * Devolve a submissão associada à revisão.
     *
     * @return submissão
     */
    public Submissao getSubmissao() {
        return submissao;
    }

    /**
     * Devolve o valor atribuido pelo revisor à adequação do artigo
     *
     * @return valor da adequação
     */
    public int getAdequacaoArtigo() {
        return adequacaoArtigo;
    }

    /**
     * Devolve o valor atribuido à confiança que o revisor tem em rever o artigo
     *
     * @return valor da confiança
     */
    public int getConfiancaRevisor() {
        return confiancaRevisor;
    }

    /**
     * Devolve o valor atribuido pelo revisor à originalidade do artigo
     *
     * @return valor da originalidade
     */
    public int getOriginalidadeArtigo() {
        return originalidadeArtigo;
    }

    /**
     * Devolve o valor atribuido pelo revisor à qualidade do artigo
     *
     * @return valor da qualidade do artigo
     */
    public int getQualidadeArtigo() {
        return qualidadeArtigo;
    }

    /**
     * Devolve o valor atribuido pelo revisor referente à recomendação global do
     * artigo
     *
     * @return valor da recomendação global.
     */
    public int getRecomendacaoGlobal() {
        return recomendacaoGlobal;
    }

    /**
     * Devolve o texto justificativo da revisão
     *
     * @return texto justificativo da revisão.
     */
    public String getTextoJustificativo() {
        return textoJustificativo;
    }

    /**
     * Modifica o valor de Adequação do Artigo.
     *
     * @param adequacaoArtigo novo valor da adequação do artigo.
     */
    public void setAdequacaoArtigo(int adequacaoArtigo) {
        if (adequacaoArtigo < 6 && adequacaoArtigo >= 0) {
            this.adequacaoArtigo = adequacaoArtigo;
        } else {
            throw new IllegalArgumentException("O valor da adequação deve estar compreendido entre os valores 0 e 5");
        }
    }

    /**
     * Modifica o valor de confiança do revisor.
     *
     * @param confiancaRevisor novo valor da confiança do revisor.
     */
    public void setConfiancaRevisor(int confiancaRevisor) {
        if (confiancaRevisor < 6 && confiancaRevisor >= 0) {
            this.confiancaRevisor = confiancaRevisor;
        } else {
            throw new IllegalArgumentException("O valor da confiança deve estar compreendido entre os valores 0 e 5");
        }
    }

    /**
     * Modifica o valor da originalidade dada ao artigo.
     *
     * @param originalidadeArtigo novo valor da originalidade.
     */
    public void setOriginalidadeArtigo(int originalidadeArtigo) {
        if (originalidadeArtigo < 6 && originalidadeArtigo >= 0) {
            this.originalidadeArtigo = originalidadeArtigo;
        } else {
            throw new IllegalArgumentException("O valor da originalidade deve estar compreendido entre os valores 0 e 5");
        }
    }

    /**
     * Modifica o valor da qualidade do artigo.
     *
     * @param qualidadeArtigo novo valor da qualidade do artigo.
     */
    public void setQualidadeArtigo(int qualidadeArtigo) {
        if (qualidadeArtigo < 6 && qualidadeArtigo >= 0) {
            this.qualidadeArtigo = qualidadeArtigo;
        } else {
            throw new IllegalArgumentException("O valor da qualidade deve estar compreendido entre os valores 0 e 5");
        }
    }

    /**
     * Modifica o valor da recomendação global do artigo.
     *
     * @param recomendacaoGlobal novo valor da recomendação do artigo.
     */
    public void setRecomendacaoGlobal(int recomendacaoGlobal) {
        if (recomendacaoGlobal <= 2 && recomendacaoGlobal >= -2) {
            this.recomendacaoGlobal = recomendacaoGlobal;
        } else {
            throw new IllegalArgumentException("O valor da recomendação global deve estar entre [-2,2]");
        }
    }

    /**
     * Modifica o texto justificativo da revisão do artigo.
     *
     * @param textoJustificativo novo texto justificativo.
     */
    public void setTextoJustificativo(String textoJustificativo) {
        if (textoJustificativo.length() > 0) {
            this.textoJustificativo = textoJustificativo;
        } else {
            throw new IllegalArgumentException("O texto justificativo não pode estar vazio.");
        }
    }

    /**
     * Cria uma instância de clone à instãncia que o invoca
     *
     * @return Revisao
     */
    public Revisao criarCloneRevisao() {
        return new Revisao(this.submissao, this.revisor);
    }

    /**
     * Adiciona os dados da revisão introduzidos pelo utilizador.
     *
     * @param adequacao adequação
     * @param confianca confiança
     * @param originalidade originalidade
     * @param qualidade qualidade
     * @param recomendacao recomendação
     * @param textoJustificativo texto justificativo 
     * @return verddeira se for adicionada com sucesso e falso se não
     */
    public boolean adicionarDadosRevisao(int adequacao, int confianca,
                        int originalidade, int qualidade, int recomendacao,
                        String textoJustificativo) {
        setAdequacaoArtigo(adequacao);
        setConfiancaRevisor(confianca);
        setOriginalidadeArtigo(originalidade);
        setQualidadeArtigo(qualidade);
        setRecomendacaoGlobal(recomendacao);
        setTextoJustificativo(textoJustificativo);
        return true;
    }

    /**
     * Adiciona à revisão os valores de revisão atribuidos pelo revisor ao
     * artigo e altera o estado da revisão para revista.
     *
     * @param revisaoClone revisaoClone
     * @return verdadeiro se modificar todos os valores correctamente e falso se
     * não o conseguir.
     */
    public boolean adicionarResultadoRevisao(Revisao revisaoClone) {
        setAdequacaoArtigo(revisaoClone.adequacaoArtigo);
        setConfiancaRevisor(revisaoClone.confiancaRevisor);
        setOriginalidadeArtigo(revisaoClone.originalidadeArtigo);
        setQualidadeArtigo(revisaoClone.qualidadeArtigo);
        setRecomendacaoGlobal(revisaoClone.recomendacaoGlobal);
        setTextoJustificativo(revisaoClone.textoJustificativo);
        this.revisto = true;
        return true;
    }

    /**
     * Valida se a revisão se encontra devidamente preenchida
     *
     * @return verdadeiro se for uma revisão válida e se
     */
    public boolean validarRevisao() {
        return (this.adequacaoArtigo != ADEQUACAO_ARTIGO_POR_OMISSAO
                            && this.confiancaRevisor != CONFIANCA_REVISOR_POR_OMISSAO
                            && this.originalidadeArtigo != ORIGINALIDADE_ARTIGO_POR_OMISSAO
                            && this.qualidadeArtigo != QUALIDADE_ARTIGO_POR_OMISSAO
                            && this.recomendacaoGlobal != RECOMENDACAO_GLOBAL_POR_OMISSAO
                            && !this.textoJustificativo.equalsIgnoreCase(BREVE_TEXTO_JUSTIFICATIVO_POR_OMISSAO));
    }

    /**
     * Compara dois objetos entre si. Comparando primariamente a posição de
     * memória, seguida do conteudo e das classes as quais cada um deles
     * pertence, e finalmente os seus atributos, submissao e revisor.
     *
     * @param outroObjecto Revisao que vai ser comparado.
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

        Revisao outraRevisao = (Revisao) outroObjecto;

        return this.revisor.equals(outraRevisao.revisor)
                            && this.submissao.equals(outraRevisao.submissao);
    }
}
