package utils;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author G01
 */
public class DataTest {
    
    public DataTest() {
    }

    /**
     * Teste dos métodos set e get do ano, da classe Data.
     */
    @Test
    public void testSetAndGetAno() {
        System.out.println("setAndGetAno");
        Data instance = new Data();
        int expResult = 1111;
        instance.setAno(expResult);
        int result = instance.getAno();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos métodos set e get do mes, da classe Data.
     */
    @Test
    public void testSetAndGetMes() {
        System.out.println("setAndGetMes");
        Data instance = new Data();
        int expResult = 2;
        instance.setMes(expResult);
        int result = instance.getMes();
        assertEquals(expResult, result);
    }

    /**
     * Teste dos métodos set e get do dia, da classe Data.
     */
    @Test
    public void testSetAndGetDia() {
        System.out.println("setAndGetDia");
        Data instance = new Data();
        int expResult = 2;
        instance.setDia(expResult);
        int result = instance.getDia();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método set do ano, quando o ano não é válido.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetAnoInvalido() {
        System.out.println("setAnoInvalido");
        int ano = 0;
        Data instance = new Data();
        instance.setAno(ano);
    }
    
    /**
     * Teste do método set do mês, quando o mês não é válido.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetMesZero() {
        System.out.println("setMesZero");
        int mes = 0;
        Data instance = new Data();
        instance.setMes(mes);
    }

    /**
     * Teste do método set do mês, quando o mês não é válido.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetMesTreze() {
        System.out.println("setMesTreze");
        int mes = 13;
        Data instance = new Data();
        instance.setMes(mes);
    }

    /**
     * Teste do método set do dia, quando o dia não é válido.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDiaInvalido() {
        System.out.println("setDiaInvalido");
        int dia = 0;
        Data instance = new Data();
        instance.setDia(dia);
    }

    /**
     * Teste do método toString, da classe Data.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Data instance = new Data(1989, 5, 22);
        String expResult = "1989/5/22";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe Data.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = new Data();;
        Data instance = new Data();
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }
    
    /**
     * Teste do método equals, da classe Data.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equalsNot");
        Object outroObjeto = new Data(1989, 05, 22);
        Data instance = new Data();
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método isMaior, da classe Data.
     */
    @Test
    public void testIsMaior() {
        System.out.println("isMaior");
        Data outraData = new Data(1989, 05, 22);
        Data instance = new Data(2015, 05, 22);
        boolean expResult = true;
        boolean result = instance.isMaior(outraData);
        assertEquals(expResult, result);
    }
    
    /**
     * Teste do método isMaior, da classe Data.
     */
    @Test
    public void testIsMaiorNot() {
        System.out.println("isMaiorNot");
        Data outraData = new Data();
        Data instance = new Data();
        boolean expResult = false;
        boolean result = instance.isMaior(outraData);
        assertEquals(expResult, result);
    }
    
    /**
     * Teste do método toMilisegundos, da classe Data.
     */
    @Test
    public void testToMilisegundos() {
        System.out.println("toMilisegundos");
        Data instance = new Data(1989, 5, 22);
        long expResult = 611798400000L;
        long result = instance.toMilisegundos();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método isAnoBissexto, da classe Data.
     */
    @Test
    public void testIsAnoBissexto() {
        System.out.println("isAnoBissexto");
        int ano = 400;
        boolean expResult = true;
        boolean result = Data.isAnoBissexto(ano);
        assertEquals(expResult, result);
    }
    /*
     * Teste do método isAnoBissexto, da classe Data.
     */
    @Test
    public void testIsAnoBissextoNot() {
        System.out.println("isAnoBissextoNot");
        int ano = 399;
        boolean expResult = false;
        boolean result = utils.Data.isAnoBissexto(ano);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método converterString, da classe Data.
     */
    @Test
    public void testConverterString() {
        System.out.println("converterString");
        String instance = "2015-05/22";
        Data expResult = new Data(2015, 5, 22);
        Data result = Data.converterString(instance);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método dataAtual, da classe Data.
     */
    @Test
    public void testDataAtual() {
        System.out.println("dataAtual");
        Calendar hoje = Calendar.getInstance();
        Data expResult = new Data(
                hoje.get(Calendar.YEAR),
                hoje.get(Calendar.MONTH) + 1,
                hoje.get(Calendar.DAY_OF_MONTH));
        Data result = Data.dataAtual();
        assertEquals(expResult, result);
    }
    
}
