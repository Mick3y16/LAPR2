package utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Representa uma instância de CSVParser.
 *
 * Esta classe utiliza uma biblioteca denominada de OpenCSV, capaz de ler e
 * escrever ficheiros .csv.
 *
 * @author G01
 */
public class CSVParser {

    /**
     * Caminho para o ficheiro .csv que contém as tabelas de frequência.
     */
    private static final String ficheiro = "tabelas.csv";
    
    /**
     * Nome para o ficheiro de estátisticas de tópicos.
     */
    private static final String ficheiroEstatisticas = "EstatísticaDeTópicos.csv";

    /**
     * Separador pelo qual é feito o split dos dados.
     */
    private static final char separador = ';';

    /**
     * Constrói uma instância de CSVParser.
     */
    public CSVParser() {
    }

    /**
     * Devolve uma matriz de inteiros com todas as tabelas de frequência
     * contidas no ficheiro .csv.
     *
     * @return Matriz de inteiros com as tabelas de frequência.
     * @throws IOException Lançada no caso do ficheiro não ser encontrado.
     */
    public double[][] lerTabelasFrequencia() throws IOException {
        CSVReader csv = new CSVReader(
                new FileReader(new File(ficheiro)), separador);

        String[] proximaLinha = csv.readNext();
        int totalTabelas = proximaLinha.length - 2;

        double[][] matrizTabelasFrequencia = new double[totalTabelas][257];

        while ((proximaLinha = csv.readNext()) != null) {

            if (!proximaLinha[0].isEmpty()) {

                int simbolo = proximaLinha[0].codePointAt(0);

                for (int tabela = 0; tabela < totalTabelas; tabela++) {
                    int coluna = tabela + 2;

                    matrizTabelasFrequencia[tabela][simbolo] 
                            = Double.parseDouble(proximaLinha[coluna].replace(",", "."));
                }
            }
        }

        return matrizTabelasFrequencia;
    }

    /**
     * Cria um ficheiro CSV com os dados estatisticos dos tópicos dos artigos
     * de todos os eventos e sessões temáticas presentes na aplicação.
     * 
     * @param palavrasChaveAceites HashMap com todas as palavras-chave dos 
     * artigos aceites e respetiva recomendação global.
     * @param palavrasChaveRejeitados HashMap com todas as palavras-chave dos
     * artigos rejeitados e respetiva recomendação global.
     */
    public void gerarFicheiroCSVEstatisticas(
            HashMap<String, Integer> palavrasChaveAceites,
            HashMap<String, Integer> palavrasChaveRejeitados) {
        try {
            CSVWriter csv = new CSVWriter(new FileWriter(
                    new File(ficheiroEstatisticas)), separador);
            
            List<String[]> listaResultados = new ArrayList();
            
            String[] resultado = new String[2];
            
            for (String key : palavrasChaveAceites.keySet()) {
                resultado[0] = key;
                resultado[1] = palavrasChaveAceites.get(key).toString();
                
                listaResultados.add(resultado);
            }
            
            for (String key : palavrasChaveRejeitados.keySet()) {
                resultado[0] = key;
                resultado[1] = palavrasChaveRejeitados.get(key).toString();
                
                listaResultados.add(resultado);
            }
            
            csv.writeAll(listaResultados);
            csv.close();
        } catch (IOException ex) {
        }
    }
    
}
