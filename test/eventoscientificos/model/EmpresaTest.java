package eventoscientificos.model;


import eventoscientificos.model.mecanismo.decisao.MecanismoDecisao;
import eventoscientificos.model.mecanismo.distribuicao.MecanismoDistribuicao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste à classe Empresa.
 * @author G01
 */
public class EmpresaTest {

    /**
     * Construtor da empresa teste.
     */
    public EmpresaTest() {
    }

    /**
     * Testa o método set e get UtilizadorAutenticado, da classe Empresa.
     */
    @Test
    public void testSetAndGetUtilizadorAutenticado() {
        System.out.println("setAndGetUtilizadorAutenticado");
        Empresa instance = new Empresa();
        Utilizador utilizador = new Utilizador(
                            "Pedro Moreira", "1140781@isep.ipp.pt", "pedro", "1234");
        instance.setUtilizadorAutenticado(utilizador);
        Utilizador expResult = utilizador;
        Utilizador result = instance.getUtilizadorAutenticado();
        assertEquals(expResult, result);
    }

    /**
     * Testa o metodo getRegistoUtilizadores da classe Empresa.
     */
    @Test
    public void testGetRegistoUtilizadores() {
        System.out.println("getRegistoUtilizadores");
        Empresa instance = new Empresa();
        RegistoUtilizadores expResult = new RegistoUtilizadores();
        RegistoUtilizadores result = instance.getRegistoUtilizadores();
        assertEquals(expResult, result);
    }

    /**
     * Testa o metodo getRegistoEventos da classe Empresa.
     */
    @Test
    public void testGetRegistoEventos() {
        System.out.println("getRegistoEventos");
        Empresa instance = new Empresa();
        RegistoEventos expResult = new RegistoEventos();
        RegistoEventos result = instance.getRegistoEventos();
        assertEquals(expResult, result);
    }

    /**
     * Testa o metodo getRegistoTiposConflito da classe Empresa.
     */
    @Test
    public void testGetRegistoTiposConflito() {
        System.out.println("getRegistoTiposConflito");
        Empresa instance = new Empresa();
        RegistoTiposConflito expResult = new RegistoTiposConflito();
        RegistoTiposConflito result = instance.getRegistoTiposConflito();
        assertEquals(expResult, result);
    }

    /**
     * Testa o metodo testgetListaMecanismoDistribuicao da classe Empresa.
     */
    @Test
    public void testgetListaMecanismoDistribuicao() {
        System.out.println("getListaMecanismoDistribuicao");
        Empresa instance = new Empresa();
        List<MecanismoDistribuicao> expResult
                            = new ArrayList<MecanismoDistribuicao>();
        List<MecanismoDistribuicao> result = instance.getListaMecanismoDistribuicao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getListaMecanismoDecisao, da classe Empresa.
     */
    @Test
    public void testGetListaMecanismoDecisao() {
        System.out.println("getListaMecanismoDecisao");
        Empresa instance = new Empresa();
        List<MecanismoDecisao> expResult = new ArrayList<MecanismoDecisao>();
        List<MecanismoDecisao> result = instance.getListaMecanismoDecisao();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isAdministrador method, of class Empresa.
     */
    @Test
    public void testIsAdministrador() {
        System.out.println("isAdministrador");
        Utilizador utilizador =  new Utilizador(
                "Hulk", "hulk@marvel.com", "hulk@marvel.com", "green.man");
        Administrador administrador = new Administrador(utilizador);
        Empresa instance = new Empresa();
        boolean expResult = true;
        boolean result = instance.isAdministrador(administrador);
        assertEquals(expResult, result);
    }
}
