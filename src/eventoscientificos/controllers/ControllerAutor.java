package eventoscientificos.controllers;

/**
 * Todas as classes que implementam a interface herdam a responsabilidade de
 * permitir adição de utilizador a uma lista de utilizador. Para tal a interface
 * obrigada à implementação de um método chamado novoAutor.
 *
 * @author G01
 */
public interface ControllerAutor {

    /**
     * Manda adicionar um autor à lista de autores.
     * 
     * @param nome Nome do autor.
     * @param email Email do autor.
     * @param intituicaoAfiliacao Instituição de Afiliação do autor.
     * 
     * @return Verdadeiro se o autor for adicionado com sucesso à lista.
     */
    boolean novoAutor(String nome, String email, String intituicaoAfiliacao);

}
