package eventoscientificos.controllers;

import eventoscientificos.model.Empresa;
import eventoscientificos.model.RegistoUtilizadores;
import eventoscientificos.model.Utilizador;

/**
 * Representa uma instância de RegistarUtilizadorController através de
 * RegistoUtilizadores e Utilizador.
 *
 * @author G01
 */
public class RegistarUtilizadorController {

    /**
     * Instancia de RegistoUtilizadores.
     */
    private RegistoUtilizadores registoUtilizadores;

    /**
     * Instancia de Utilizador.
     */
    private Utilizador utilizador;

    /**
     * Constrói uma instância de RegistarUtilizadorController recebendo uma
     * empresa por parametro.
     * @param empresa empresa
     */
    public RegistarUtilizadorController(Empresa empresa) {
        this.registoUtilizadores = empresa.getRegistoUtilizadores();
    }

    /**
     * Devolve instancia de RegistoUtilizadores.
     *
     * @return RegistoUtilizadores.
     */
    public RegistoUtilizadores getRegistoUtilizadores() {
        return this.registoUtilizadores;
    }

    /**
     * Cria uma instancia de Utilizador recebendo como parametro uma String
     * nome, String email, String username,String password.
     *
     * @param nome nome do novo utilizador.
     * @param email email do novo utilizador.
     * @param username username do novo utilizador.
     * @param password password do novo utilizador.
     * @return nova instancia de utilizador.
     */
    public boolean novoUtilizador(String nome, String email, String username,
            String password) {
        this.utilizador = registoUtilizadores.novoUtilizador(nome, email, username, password);

        return this.utilizador != null;
    }

    /**
     * Adiciona a instancia de utilizador a lista de utilizadores do
     * RegistoUtilizadores.
     *
     * @return verdadeiro se for adicionado e falso se nao for possivel
     * adiciona-lo.
     */
    public boolean adicionarUtilizador() {
        return registoUtilizadores.adicionaUtilizador(this.utilizador);
    }

}
