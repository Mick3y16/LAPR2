package eventoscientificos.controllers;

import eventoscientificos.model.Empresa;
import eventoscientificos.model.Utilizador;

/**
 * Representa uma instância de LoginController através de uma empresa na qual se
 * pretende realizar a autenticação.
 *
 * @author G01
 */
public class LoginController {

    /**
     * Empresa na qual se pretende realizar a autenticação.
     */
    private Empresa empresa;

    /**
     * Constrói uma instância de LoginController recebendo uma empresa.
     *
     * @param empresa Empresa na qual se pretende realizar a autenticação.
     */
    public LoginController(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * Procura um utilizador no RegistoUtilizadores e caso o encontre e os dados
     * estejam corretos, realiza a autenticação.
     *
     * @param username Username do utilizador.
     * @param password Password do utilizador.
     */
    public void login(String username, String password) {
        Utilizador utilizador
                = this.empresa.getRegistoUtilizadores().getUtilizador(username);

        if (username.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Deve preencher o campo do username.");
        }

        if (password.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Deve preencher o campo da password.");
        }

        if (utilizador == null) {
            throw new NullPointerException("O utilizador não existe.");
        }

        String codificacao[] = utilizador.getCodificadorTabela().split(";");
        String passwordCodificada;
        switch (codificacao[0]) {
            case "CA":
                int tabela = Integer.parseInt(codificacao[1].substring(3)) - 1;
                passwordCodificada
                        = this.empresa.getRegistoUtilizadores().codificarPassword(
                                password, tabela);
                break;
            default:
                passwordCodificada = password;
        }

        if (!utilizador.getPassword().equals(passwordCodificada)) {
            throw new IllegalArgumentException("A password está errada.");
        }

        this.empresa.setUtilizadorAutenticado(utilizador);
    }

}
