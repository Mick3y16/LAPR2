package eventoscientificos.controllers;

import eventoscientificos.model.Empresa;
import eventoscientificos.model.RegistoUtilizadores;
import eventoscientificos.model.Utilizador;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author G01
 */
public class LoginControllerTest {

    public LoginControllerTest() {
    }

    /**
     * Teste do método login, da classe LoginController.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        Empresa empresa = new Empresa();
        RegistoUtilizadores registoUtilizador = empresa.getRegistoUtilizadores();
        Utilizador utilizador = new Utilizador(
                "Pedro Moreira",
                "1140781@isep.ipp.pt",
                "pedro",
                "1234");
        registoUtilizador.adicionaUtilizador(utilizador);
        String username = "pedro";
        String password = "1234";
        LoginController instance = new LoginController(empresa);
        instance.login(username, password);
        assertEquals(empresa.getUtilizadorAutenticado(), utilizador);
    }

}
