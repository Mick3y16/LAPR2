package utils.codificador.aritmetico;

import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Soraia
 */
public class CATest {

    public CATest() throws IOException {
    }

    /**
     * Teste do método codificar, da class CA.
     */
    @Test
    public void testCodificar() throws IOException {
        System.out.println("codificar");
        CA instance = new CA();
        int tabela = 2;
        String password = "((";
        String expResult = "0.005025";
        String result = instance.codificar(password, tabela);
        assertEquals(expResult, result);
    }
    
    /**
     * Teste do método getSizeListaTabelasFreq, da classe CA.
     */
    @Test
    public void testGetSizeListaTabelasFreq() throws IOException {
        System.out.println("getSizeListaTabelasFreq");
        CA instance = new CA();
        int expResult = 4;
        int result = instance.getSizeListaTabelasFreq();
        assertEquals(expResult, result);
    }

}
