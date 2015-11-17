package eventoscientificos.model.mecanismo.leitura;

import eventoscientificos.model.Evento;
import eventoscientificos.model.RegistoUtilizadores;

/**
 * Todas as classes que implementam esta Interface herdam as responsabilidade de
 * descodificar submissões a partir de ficheiros. A forma como a descodifica-
 * ção é feita, diz respeito à maneira como cada uma delas é implementada. Esta
 * interface disponibiliza também grande parte dos erros que possam acontecer ao
 * importar uma submissão.
 *
 * @author G01
 */
public interface MecanismoLeitura {

    /**
     * Erros de importação.
     */
    String FICHEIRO = "Não foi possível importar o ficheiro da submissão.\n";
    String TOTAL_PARAMETROS = "A submissão não tem todos os parametros necessários.\n";
    String TITULO_VAZIO = "O titulo da submissão não existe.\n";
    String RESUMO_VAZIO = "O resumo da submissão não existe.\n";
    String PALAVRAS_CHAVE_VAZIO = "As palavras-chave da submissão não existem.\n";
    String LISTA_AUTORES_VAZIO = "A lista de autores da submissão não existe.\n";
    String AUTOR_CORRESPONDENTE_VAZIO = "O autor correspondente da submissão não existe.\n";
    String DATA_SUBMISSAO = "A data de submissão da submissão não existe.\n";
    String CAMINHO_FICHEIRO_VAZIO = "O caminho para o ficheiro não existe.\n";
    String SESSAO_TEMATICA_NAO_EXISTE = "A sessão temática à qual a submissão se destina, não existe.\n";
    String SESSAO_TEMATICA_NAO_ACEITA_SUBMISSAO = "A sessão temática à qual a submissão se destina não está dentro do periodo de submissão.\n";
    String TOTAL_PALAVRAS_CHAVE = "O número total de palavas-chave da submissão, deve estar entre 1 e 5.\n";
    String LISTA_AUTORES_FORMATO = "A lista de autores da submissão, não possui o formato correto.\n";
    String AUTOR_CORRESPONDENTE_NAO_CONSTA_NA_LISTA = "O autor correspondente não consta na lista de autores.\n";
    String DATA_ADIANTADA = "A data de submissão é superior à data atual.\n";

    /**
     * Lê uma submissão de um artigo, contida num ficheiro.
     *
     * @param registoUtilizadores Registo de utilizadores da empresa.
     * @param evento Evento ao qual a submissão se destina.
     * @param ficheiro Caminho para o ficheiro.
     * 
     * @return Verdadeiro se a submissão for importada com sucesso e falso caso
     * não o seja.
     */
    boolean lerFicheiroSubmissao(
            RegistoUtilizadores registoUtilizadores,
            Evento evento, String ficheiro);

}
