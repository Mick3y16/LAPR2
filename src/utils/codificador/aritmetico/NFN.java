package utils.codificador.aritmetico;

/**
 * Esta classe tem a responsabidade de codificar utilizando o codificador NFN
 *
 * @author G01
 */
public class NFN implements Codificador {

    /**
     * Constrói uma instância de NFN.
     */
    public NFN() {
    }

    /**
     * Codifica a palavra recebida por parãmetro
     *
     * @param password password a codificar
     * @return palavra codificada
     */
    @Override
    public String codificar(String password, int tabela) {
        if (password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password do utilizador não "
                                + "pode estar vazia.");
        }
        if (password.contains("[()<>,;:.\\[\\]{}]\\\\\\\\")) {
            throw new IllegalArgumentException("Password do "
                                + "utilizador não pode conter "
                                + "caracteres.");
        }
        if (password.length() > 16) {
            throw new IllegalArgumentException("A password pode ter no máximo "
                                + "16 caracteres");
        }
        return password;
    }

}
