/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos.controllers;

import eventoscientificos.model.Empresa;
import eventoscientificos.model.RegistoUtilizadores;
import eventoscientificos.model.Utilizador;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testa a classe RegistarUtilizadorControllerTest.
 *
 * @author G01
 */
public class RegistarUtilizadorControllerTest {

    public RegistarUtilizadorControllerTest() {
    }

    /**
     * Teste do metodo getRegistoUtilizadores, da classe
     * RegistarUtilizadorController.
     */
    @Test
    public void testGetRegistoUtilizadores(){
        System.out.println("getRegistoUtilizadores");
        Empresa emp = new Empresa();
        RegistarUtilizadorController instance = new RegistarUtilizadorController(emp);
        RegistoUtilizadores expResult = new RegistoUtilizadores();
        RegistoUtilizadores result = instance.getRegistoUtilizadores();
        assertEquals(expResult, result);

    }

    /**
     * Teste do metodo novoUtilizador, da classe RegistarUtilizadorController.
     */
    @Test
    public void testNovoUtilizador() {
        Empresa emp = new Empresa();
        System.out.println("novoUtilizador");
        String nome = "fatima";
        String email = "ola@iml.com";
        String username = "fafa";
        String password = "1234";
        RegistarUtilizadorController instance
                            = new RegistarUtilizadorController(emp);
        boolean expResult = true;
        boolean result = instance.novoUtilizador(nome, email, username, password);
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo testAdicionarUtilizadorComUtilizadorCorreto, da classe
     * RegistarUtilizadorController.
     */
    @Test
    public void testAdicionarUtilizadorComUtilizadorCorreto(){
        Empresa emp = new Empresa();
        System.out.println("adicionarUtilizador");
        String nome = "Susana";
        String email = "frefre@mail.com";
        String username = "ferfer";
        String password = "1234";
        Utilizador u = new Utilizador(nome, email, username, password);
        RegistarUtilizadorController instance
                            = new RegistarUtilizadorController(emp);
        boolean expResult = true;
        boolean result = instance.getRegistoUtilizadores().adicionaUtilizador(u);
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo testAdicionarUtilizadorComUtilizadorNomeVazio, da classe
     * RegistarUtilizadorController.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAdicionarUtilizadorComUtilizadorNomeVazio() {
        Empresa emp = new Empresa();
        System.out.println("adicionarUtilizador");
        String nome = "";
        String email = "frefre@mail.com";
        String username = "ferfer";
        String password = "1234";
        Utilizador u = new Utilizador(nome, email, username, password);
        RegistarUtilizadorController instance
                            = new RegistarUtilizadorController(emp);
    }

    /**
     * Teste do metodo testAdicionarUtilizadorComUtilizadorEmailVazio, da classe
     * RegistarUtilizadorController.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAdicionarUtilizadorComUtilizadorEmailVazio() {
        Empresa emp = new Empresa();
        System.out.println("adicionarUtilizador");
        String nome = "Susana";
        String email = "";
        String username = "ferfer";
        String password = "1234";
        Utilizador u = new Utilizador(nome, email, username, password);
        RegistarUtilizadorController instance
                            = new RegistarUtilizadorController(emp);
    }

    /**
     * Teste do metodo testAdicionarUtilizadorComUtilizadorUsernameVazio, da
     * classe RegistarUtilizadorController.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAdicionarUtilizadorComUtilizadorUsernameVazio() {
        Empresa emp = new Empresa();
        System.out.println("adicionarUtilizador");
        String nome = "Susana";
        String email = "frefre@mail.com";
        String username = "";
        String password = "1234";
        Utilizador u = new Utilizador(nome, email, username, password);
        RegistarUtilizadorController instance
                            = new RegistarUtilizadorController(emp);
    }

    /**
     * Teste do metodo testAdicionarUtilizadorComUtilizadorPasswordVazio, da
     * classe RegistarUtilizadorController.
     */
    @Test

    public void testAdicionarUtilizadorComUtilizadorPasswordVazio(){
        Empresa emp = new Empresa();
        System.out.println("adicionarUtilizador");
        String nome = "Susana";
        String email = "frefre@mail.com";
        String username = "ferfer";
        String password = "";
        Utilizador u = new Utilizador(nome, email, username, password);
        RegistarUtilizadorController instance
                            = new RegistarUtilizadorController(emp);
    }
}
