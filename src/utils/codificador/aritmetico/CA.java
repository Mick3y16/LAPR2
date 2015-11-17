package utils.codificador.aritmetico;

import java.io.IOException;
import java.math.BigDecimal;
import utils.CSVParser;

/**
 * Esta classe tem a responsabilidade de codificar através da codificação
 * aritmética.
 *
 * @author G01
 */
public class CA implements Codificador {

    /**
     * Lista de tabelas de frequências.
     */
    double[][] listaTabelasProbabilidades;

    /**
     * Constrói uma instância de CodificadorAritmetico.
     * @throws java.io.IOException exceção
     */
    public CA() throws IOException {
        this.listaTabelasProbabilidades = new CSVParser().lerTabelasFrequencia();
    }

    /**
     * Codifica a password recebida por parametro, aritméticamente.
     *
     * @param password Password a codificar.
     * @param tabela Tabela utilizada na codificação.
     * 
     * @return Password codificada.
     */
    @Override
    public String codificar(String password, int tabela) {
        char[] sequenciaCarateres = password.toCharArray();
        
        double[] intervalos = new double[256];
        
        for (int i = 1; i < intervalos.length; i++) {
            intervalos[i] = (double) Math.round((intervalos[i - 1] + this.listaTabelasProbabilidades[tabela][i - 1]) * 10000000) / 10000000;
        }
        
        BigDecimal f = new BigDecimal(0);
        BigDecimal g = new BigDecimal(1);
        for (int i = 0; i < sequenciaCarateres.length; i++) {
            double probabilidade = this.listaTabelasProbabilidades[tabela][sequenciaCarateres[i]];
            double intervalo = intervalos[sequenciaCarateres[i]];
            
            BigDecimal pG = g.multiply(new BigDecimal(probabilidade));
            BigDecimal qG = g.multiply(new BigDecimal(intervalo));
            
            f = f.add(qG);
            g = pG;
        }

        return String.valueOf(f.doubleValue());
    }

    /**
     * Devolve o tamanho de tabelas de frequência.
     *
     * @return numero de tabelas
     */
    public int getSizeListaTabelasFreq() {
        return listaTabelasProbabilidades.length;
    }

}
