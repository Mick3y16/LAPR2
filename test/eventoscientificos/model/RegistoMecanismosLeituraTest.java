/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos.model;

import eventoscientificos.model.mecanismo.leitura.MecanismoLeitura;
import eventoscientificos.model.mecanismo.leitura.MecanismoLeituraCSV1;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste à classe RegistoMecanismosLeitura
 * @author G01
 */
public class RegistoMecanismosLeituraTest {
    
    public RegistoMecanismosLeituraTest() {
    }

    /**
     * Test of getListaMecanismosLeitura method, of class RegistoMecanismosLeitura.
     */
    @Test
    public void testGetListaMecanismosLeitura() {
        System.out.println("getListaMecanismosLeitura");
        RegistoMecanismosLeitura instance = new RegistoMecanismosLeitura();
        HashMap<String, MecanismoLeitura> expResult = new HashMap<String, MecanismoLeitura>();
        expResult.put("csv", new MecanismoLeituraCSV1());
        HashMap<String, MecanismoLeitura> result = instance.getListaMecanismosLeitura();
        assertEquals(expResult.size(), result.size());
    }

    /**
     * Test of getMecanismoAdequadoAoFicheiro method, of class RegistoMecanismosLeitura.
     */
    @Test
    public void testGetMecanismoAdequadoAoFicheiro() {
        System.out.println("getMecanismoAdequadoAoFicheiro");
        String ficheiro = "ficheiro.csv";
        RegistoMecanismosLeitura instance = new RegistoMecanismosLeitura();
        MecanismoLeitura expResult = new MecanismoLeituraCSV1();
        MecanismoLeitura result = instance.getMecanismoAdequadoAoFicheiro(ficheiro);
        assertEquals(expResult.getClass().getSimpleName(), result.getClass().getSimpleName());
    }
    
}
