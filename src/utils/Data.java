package utils;

import java.util.Calendar;

/**
 * Representa uma data através do dia, mês e ano.
 */
public class Data {

    /**
     * O ano da data.
     */
    private int ano;

    /**
     * O mês da data.
     */
    private int mes;

    /**
     * O dia da data.
     */
    private int dia;

    /**
     * Número de dias de cada mês do ano.
     */
    private static int[] diasPorMes
            = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * O dia por omissão.
     */
    private static final int DIA_POR_OMISSAO = 1;

    /**
     * O mês por omissão.
     */
    private static final int MES_POR_OMISSAO = 1;

    /**
     * O ano por omissão.
     */
    private static final int ANO_POR_OMISSAO = 3000;

    /**
     * Constrói uma instância de Data recebendo o ano, o mês e o dia.
     *
     * @param ano o ano da data.
     * @param mes o mês da data.
     * @param dia o dia da data.
     */
    public Data(int ano, int mes, int dia) {
        setAno(ano);
        setMes(mes);
        setDia(dia);
    }

    /**
     * Constrói uma instância de Data com os valores por omissão.
     */
    public Data() {
        this(Data.ANO_POR_OMISSAO, Data.MES_POR_OMISSAO, Data.DIA_POR_OMISSAO);
    }

    /**
     * Devolve o ano da data.
     *
     * @return ano da data
     */
    public int getAno() {
        return this.ano;
    }

    /**
     * Devolve o mês da data.
     *
     * @return mês da data.
     */
    public int getMes() {
        return this.mes;
    }

    /**
     * Devolve o dia da data.
     *
     * @return dia da data.
     */
    public int getDia() {
        return this.dia;
    }

    /**
     * Modifica a ano da data.
     *
     * @param ano Novo ano da data.
     */
    public void setAno(int ano) {
        if (ano < 1) {
            throw new IllegalArgumentException("O ano da data não é válido.");
        }

        this.ano = ano;
    }

    /**
     * Modifica o mês da data.
     *
     * @param mes Novo mês da data.
     */
    public void setMes(int mes) {
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("O mês da data não é válido.");
        }

        this.mes = mes;
    }

    /**
     * Modifica o dia da data.
     *
     * @param dia Novo dia da data.
     */
    public void setDia(int dia) {
        if (dia < 1 || (getMes() == 2 && Data.isAnoBissexto(getAno())
                ? dia > 29
                : dia > Data.diasPorMes[getMes()])) {
            throw new IllegalArgumentException("O dia da data não é válido.");
        }

        this.dia = dia;
    }

    /**
     * Devolve a descrição textual da data no formato: aaaa/mm/dd
     *
     * @return Características da data.
     */
    @Override
    public String toString() {
        return String.format("%d/%d/%d", this.getAno(), this.getMes(), this.getDia());
    }

    /**
     * Compara a data com o objeto recebido.
     *
     * @param outroObjeto o objeto a comparar com a data.
     * @return true se o objeto recebido representar uma data equivalente à
     * data. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }

        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }

        Data outraData = (Data) outroObjeto;

        return this.getAno() == outraData.getAno()
                && this.getMes() == outraData.getMes()
                && this.getDia() == outraData.getDia();
    }

    /**
     * Devolve o número de dias desde o dia 1/1/1 até à data.
     *
     * @return Número de dias desde o dia 1/1/1 até à data.
     */
    private int contaDias() {
        int totalDias = 0;

        for (int i = 1; i < this.getAno(); i++) {
            totalDias += Data.isAnoBissexto(i) ? 366 : 365;
        }

        for (int i = 1; i < this.getMes(); i++) {
            totalDias += Data.diasPorMes[i];
        }

        totalDias += (Data.isAnoBissexto(this.getAno()) && this.getMes() > 2) ? 1 : 0;
        totalDias += this.getDia();

        return totalDias;
    }

    /**
     * Comparar duas datas de forma a verificar se uma sucede a outra.
     *
     * @param outraData Data com a qual se faz a comparação.
     * @return Verdadeiro se a data for maior do que a data recebida por
     * parâmetro, caso contrário retorna falso.
     */
    public boolean isMaior(Data outraData) {
        int totalDias = this.contaDias();
        int totalDias1 = outraData.contaDias();

        return totalDias > totalDias1;
    }

    /**
     * Devolve o valor de uma data, em milisegundos ,a contar desde 1 de Janeiro
     * de 1970.
     * 
     * @return Valor de uma data, em milisegundos, a contar desde 1 de Janeiro 
     * de 1970.
     */
    public long toMilisegundos() {
        int totalDias = 0;

        for (int i = 1970; i < this.getAno(); i++) {
            totalDias += Data.isAnoBissexto(i) ? 366 : 365;
        }

        for (int i = 1; i < this.getMes(); i++) {
            totalDias += Data.diasPorMes[i];
        }
        
        for (int i = 1; i < this.getDia(); i++) {
            totalDias += 1;
        }
        totalDias += (Data.isAnoBissexto(this.getAno()) && this.getMes() > 2) ? 1 : 0;
        
        return (long) totalDias * 24 * 60 * 60 * 1000;
    }

    /**
     * Verifica se o ano passado por parametro é ou não um ano bissexto.
     *
     * @param ano o ano a validar.
     * @return Verdadeiro se o ano passado por parâmetro for bissexto, caso
     * contrário retorna falso.
     */
    public static boolean isAnoBissexto(int ano) {
        return ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;
    }

    /**
     * Converte uma data no formato aaaa-mm-dd ou aaaa/mm/dd, num objeto do tipo
     * Data.
     * 
     * @param dataEmTexto Data em formato de texto.
     * @return Data convertida em objeto.
     */
    public static Data converterString(String dataEmTexto) {
        String[] data = dataEmTexto.split("[-/]");
        
        if (data.length != 3) {
            throw new IllegalArgumentException("A data não possui os 3 atributos");
        }

        int ano = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]);
        int dia = Integer.parseInt(data[2]);
        
        return new Data(ano, mes, dia);
    }

    /**
     * Devolve a data atual do sistema.
     *
     * @return Data atual do sistema.
     */
    public static Data dataAtual() {
        Calendar hoje = Calendar.getInstance();
        int ano = hoje.get(Calendar.YEAR);
        int mes = hoje.get(Calendar.MONTH) + 1;
        int dia = hoje.get(Calendar.DAY_OF_MONTH);
        return new Data(ano, mes, dia);
    }

}
