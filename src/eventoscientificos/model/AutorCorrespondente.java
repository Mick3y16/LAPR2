package eventoscientificos.model;

/**
 * Representa um autor correspondente através do utilizador e da instituição de
 * afiliação.
 * 
 * @author G01
 */
public class AutorCorrespondente extends Autor {
    
    /**
     * Constrói uma instância de autor recebendo um utilizador e uma instituição
     * de afiliação.
     * 
     * @param utilizador Utilizador do autor.
     * @param instituicaoAfiliacao Instituicao de afiliacao do autor.
     */
    public AutorCorrespondente(
            Utilizador utilizador, InstituicaoAfiliacao instituicaoAfiliacao) {
        
        super(utilizador, instituicaoAfiliacao);
    }

    /**
     * Constrói uma cópia de um autor correspondente através de um outro passado
     * por parametro.
     * 
     * @param autorCorrespondente Autor correspondente que irá ser copiado.
     */
    public AutorCorrespondente(AutorCorrespondente autorCorrespondente) {
        super(autorCorrespondente);
    }
    
}
