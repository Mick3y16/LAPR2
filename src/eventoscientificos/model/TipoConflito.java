package eventoscientificos.model;

import eventoscientificos.model.mecanismo.detecao.MecanismoDetecao;

/**
 * Representa uma instância de TipoConflito através de um mecanismo de deteção e
 * uma descrição.
 *
 * @author G01
 */
public class TipoConflito {

    /**
     * Mecanismo que deteta determinado tipo de conflito.
     */
    private MecanismoDetecao mecanismoDetecao;

    /**
     * Descrição do tipo de conflito.
     */
    private String descricao;

    /**
     * Constrói uma instância de Tipo de Conflito recebendo um mecanismo de
     * deteção e de uma descrição.
     * 
     * @param mecanismoDetecao Mecanismo capaz de detetar conflitos.
     * @param descricao Descrição do tipo de conflito.
     */
    public TipoConflito(MecanismoDetecao mecanismoDetecao, String descricao) {
        setMecanismoDetecao(mecanismoDetecao);
        setDescricao(descricao);
    }

    /**
     * Constrói uma instância de TipoConflito recebendo uma descrição.
     * 
     * @param descricao Descrição do tipo de conflito.
     */
    public TipoConflito(String descricao) {
        this(null, descricao);
    }

    /**
     * Devolve o mecanismo de deteção do tipo de conflito.
     * 
     * @return Mecanismo de deteção do tipo de conflito.
     */
    public MecanismoDetecao getMecanismoDetecao() {
        return this.mecanismoDetecao;
    }

    /**
     * Devolve a descrição do tipo de conflito.
     * 
     * @return Descrição do tipo de conflito.
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * Modifica o mecanismo de deteção.
     * 
     * @param mecanismoDetecao Novo mecanismo de deteção.
     */
    public void setMecanismoDetecao(MecanismoDetecao mecanismoDetecao) {
        this.mecanismoDetecao = mecanismoDetecao;
    }

    public void setDescricao(String descricao) {
        if(descricao.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "A descrição não pode estar vazia.");
        }

        this.descricao = descricao;
    }

    /**
     * Compara dois objetos entre si. Comparando primariamente a posição de
     * memória, seguida do conteudo e das classes as quais cada um deles
     * pertence, e finalmente os seus atributos, o mecanismo de deteção e a
     * descrição.
     * 
     * @param outroObjeto Tipo de conflito que vai ser usado na comparação.
     * @return Verdadeiro caso os objetos comparados sejam iguais e falso caso
     * não o sejam.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        
        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }
        
        TipoConflito outroTipoConflito = (TipoConflito) outroObjeto;
        
        if (this.getMecanismoDetecao() == null
                || outroTipoConflito.getMecanismoDetecao() == null) {
            return this.getDescricao().equals(outroTipoConflito.getDescricao());
        }
        
        return this.getMecanismoDetecao().getClass().equals(
                outroTipoConflito.getMecanismoDetecao().getClass()); 
    }

    /**
     * Valida o tipo de conflito na sua totalidade.
     * 
     * @return Verdadeiro se o tipo de conflito possuir todas as características
     * e falso caso não possua.
     */
    public boolean validarTipoConflito() {
        return true;
    }

    /**
     * Verifica se o tipo de conflito tem um mecanismo de deteção associado a si
     * mesmo.
     * 
     * @return Verdadeiro se existir um mecanismo de deteção associado ao tipo
     * de conflito e falso caso não exista.
     */
    public boolean temMecanismo() {
        return getMecanismoDetecao() != null;
    }

}
