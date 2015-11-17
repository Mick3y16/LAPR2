package eventoscientificos.controllers;

import eventoscientificos.model.Empresa;
import eventoscientificos.model.RegistoUtilizadores;
import eventoscientificos.model.Utilizador;

/**
 * Representa uma instância de AlterarUtilizadorController, através de um
 * registo de utilizadores
 *
 * @author G01
 */
public class AlterarUtilizadorController {

    /**
     * Empresa que contém todos os dados.
     */
    private Empresa empresa;

    /**
     * Registo de utilizadores da empresa.
     */
    private RegistoUtilizadores registoUtilizadores;

    /**
     * Utilizador que vai ser alterado.
     */
    private Utilizador utilizador;

    /**
     * Utilizador que contém as alterações.
     */
    private Utilizador utilizadorClone;

    /**
     * Representa uma instância de AlterarUtilizadorController recebendo uma
     * empresa.
     *
     * @param empresa Empresa que contém todos os dados.
     */
    public AlterarUtilizadorController(Empresa empresa) {
        this.empresa = empresa;
        this.registoUtilizadores = null;
        this.utilizador = null;
        this.utilizadorClone = null;
    }

    /**
     * Devolve nome do utilizador
     *
     * @return nome do utilizador
     */
    public String getUtilizadorNome() {
        return this.utilizadorClone.getNome();
    }

    /**
     * Devolve o email do utilizador
     *
     * @return email do utilizador
     */
    public String getUtilizadorEmail() {
        return this.utilizadorClone.getEmail();
    }

    /**
     * Devolve o username do utilizador
     *
     * @return username do utilizador
     */
    public String getUtilizadorUsername() {
        return this.utilizadorClone.getUsername();
    }

    /**
     * Devolve a password do uilizador
     *
     * @return password do uilizador
     */
    public String getUtilizadorPassword() {
        return this.utilizadorClone.getPassword();
    }

    /**
     * Cria um clone do utilizador ao qual se pretende efetuar a alteração dos
     * dados.
     *
     * @return Verdadeiro se for possível clonar o utilizador e falso caso não
     * seja.
     */
    public boolean criarCloneUtilizador() {
        this.registoUtilizadores = this.empresa.getRegistoUtilizadores();

        this.utilizador = this.registoUtilizadores.getUtilizador(
                this.empresa.getUtilizadorAutenticado().getEmail());

        this.utilizadorClone = this.utilizador.criarCloneUtilizador();

        return this.registoUtilizadores != null
                && this.utilizador != null
                && this.utilizadorClone != null;
    }

    /**
     * Altera os dados do utilizador no clone que foi criado.
     *
     * @param username Username do utilizador.
     * @param password Password do utilizador.
     * @param nome Nome do utilizador.
     * @param email Email do utilizador.
     *
     * @return Verdadeiro se for possível alterar os dados do utilizador.
     */
    public boolean alterarDadosUtilizador(
            String username, String password, String nome, String email) {
        this.utilizadorClone.setUsername(username);

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

        this.utilizadorClone.setPassword(passwordCodificada);
        this.utilizadorClone.setNome(nome);
        this.utilizadorClone.setEmail(email);

        return this.registoUtilizadores.validarUtilizadorClone(
                this.utilizador, this.utilizadorClone);
    }

    /**
     * Altera os dados do utilizador substituindo o mesmo na lista, pelo clone.
     *
     * @return Verdadeiro se for possível alterar os dados do utilizador e falso
     * caso não seja.
     */
    public boolean atualizarUtilizador() {
        this.empresa.setUtilizadorAutenticado(utilizadorClone);

        return this.registoUtilizadores.atualizarUtilizador(
                utilizador, utilizadorClone);
    }

}
