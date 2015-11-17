package eventoscientificos.model.mecanismo.leitura;

import eventoscientificos.model.Artigo;
import eventoscientificos.model.Autor;
import eventoscientificos.model.AutorCorrespondente;
import eventoscientificos.model.Evento;
import eventoscientificos.model.InstituicaoAfiliacao;
import eventoscientificos.model.ListaAutores;
import eventoscientificos.model.ListaSessoesTematicas;
import eventoscientificos.model.ListaSubmissoes;
import eventoscientificos.model.RegistoUtilizadores;
import eventoscientificos.model.SessaoTematica;
import eventoscientificos.model.Submissao;
import eventoscientificos.model.Utilizador;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import utils.Data;

/**
 * Representa uma instância MecanismLeituraCSV1, responsável por ler e
 * interpretar ficheiros csv.
 *
 * @author G01
 */
public class MecanismoLeituraCSV1 implements MecanismoLeitura {

    /**
     * Contrói uma instância de Mecanismo de Leitura CSV1.
     */
    public MecanismoLeituraCSV1() {
    }

    /**
     * Lê uma submissão de um artigo, contida num ficheiro.
     *
     * @param registoUtilizadores Registo de utilizadores da empresa.
     * @param evento Evento ao qual a submissão se destina.
     * @param ficheiro Caminho para o ficheiro.
     */
    @Override
    public boolean lerFicheiroSubmissao(RegistoUtilizadores registoUtilizadores, Evento evento, String ficheiro) {
        String errorLog = "";
        try {
            Scanner ler = new Scanner(new File(ficheiro));
            String conteudo = ler.nextLine();

            String dadosSubmissao[] = conteudo.split(";", 8);

            if (dadosSubmissao.length != 8) {
                throw new IllegalArgumentException(MecanismoLeitura.TOTAL_PARAMETROS);
            }

            String destino = dadosSubmissao[0].trim();

            String titulo;
            if ((titulo = dadosSubmissao[1].trim()).isEmpty()) {
                throw new IllegalArgumentException(MecanismoLeitura.TITULO_VAZIO);
            }

            String resumo;
            if ((resumo = dadosSubmissao[5].trim()).isEmpty()) {
                throw new IllegalArgumentException(MecanismoLeitura.RESUMO_VAZIO);
            }

            String palavrasChave;
            if ((palavrasChave = dadosSubmissao[4].trim()).isEmpty()) {
                throw new IllegalArgumentException(MecanismoLeitura.PALAVRAS_CHAVE_VAZIO);
            }

            String listaAutores;
            if ((listaAutores = dadosSubmissao[7].trim()).isEmpty()) {
                throw new IllegalArgumentException(MecanismoLeitura.LISTA_AUTORES_VAZIO);
            }

            String autorCorrespondente;
            if ((autorCorrespondente = dadosSubmissao[2].trim()).isEmpty()) {
                throw new IllegalArgumentException(MecanismoLeitura.AUTOR_CORRESPONDENTE_VAZIO);
            }

            String dataSubmissaoTexto;
            if ((dataSubmissaoTexto = dadosSubmissao[3].trim()).isEmpty()) {
                throw new IllegalArgumentException(MecanismoLeitura.DATA_SUBMISSAO);
            }

            String caminhoFicheiro;
            if ((caminhoFicheiro = dadosSubmissao[6].trim()).isEmpty()) {
                throw new IllegalArgumentException(MecanismoLeitura.CAMINHO_FICHEIRO_VAZIO);
            }

            ListaSubmissoes listaSubmissoes;
            if (!destino.isEmpty()) {
                ListaSessoesTematicas listaSessoesTematicas
                        = evento.getListaSessoesTematicas();
                SessaoTematica sessaoTematica
                        = listaSessoesTematicas.getSessaoTematicaComCodigoUnico(destino);

                if (sessaoTematica != null) {
                    if (sessaoTematica.isStateValidoParaSubmeter()) {
                        listaSubmissoes = sessaoTematica.getListaSubmissoes();
                    } else {
                        throw new IllegalArgumentException(MecanismoLeitura.SESSAO_TEMATICA_NAO_ACEITA_SUBMISSAO);
                    }
                } else {
                    throw new IllegalArgumentException(MecanismoLeitura.SESSAO_TEMATICA_NAO_EXISTE);
                }
            } else {
                listaSubmissoes = evento.getListaSubmissoes();
            }

            Submissao submissao = listaSubmissoes.novaSubmissao();

            Data dataSubmissao = Data.converterString(dataSubmissaoTexto);

            if (dataSubmissao.isMaior(Data.dataAtual())) {
                throw new IllegalArgumentException(MecanismoLeitura.DATA_ADIANTADA);
            }

            String[] palavrasChaveSeparadas = palavrasChave.split(",");
            List<String> listaPalavrasChave = new ArrayList();
            for (String palavra : palavrasChaveSeparadas) {
                if (!palavra.trim().isEmpty()) {
                    listaPalavrasChave.add(palavra);
                }
            }

            if (listaPalavrasChave.size() > 5 || listaPalavrasChave.isEmpty()) {
                throw new IllegalArgumentException(MecanismoLeitura.TOTAL_PALAVRAS_CHAVE);
            }

            Artigo artigo = submissao.novoArtigo();

            artigo.setTitulo(titulo);
            artigo.setResumo(resumo);
            artigo.setPalavrasChave(listaPalavrasChave);
            artigo.setFicheiro(caminhoFicheiro);
            artigo.setDataSubmissao(dataSubmissao);

            ListaAutores listaAutoresArtigo = artigo.getListaAutores();

            String listaAutoresPartida[] = listaAutores.split(";");

            if (listaAutoresPartida.length % 3 != 0) {
                throw new IllegalArgumentException(MecanismoLeitura.LISTA_AUTORES_FORMATO);
            }

            String nome, filiacao, email;
            for (int i = 0; i < listaAutoresPartida.length; i = i + 3) {
                nome = listaAutoresPartida[i];
                filiacao = listaAutoresPartida[i + 1];
                email = listaAutoresPartida[i + 2];

                Utilizador utilizador = registoUtilizadores.getUtilizador(email);

                if (utilizador == null) {
                    listaAutoresArtigo.novoAutor(nome, email, new InstituicaoAfiliacao(filiacao));
                } else {
                    listaAutoresArtigo.novoAutor(utilizador, new InstituicaoAfiliacao(filiacao));
                }
            }

            List<Autor> listaAutoresRegistados = listaAutoresArtigo.getListaAutoresRegistados();

            for (Autor autor : listaAutoresRegistados) {
                if (autor.getEmail().equals(autorCorrespondente)) {
                    artigo.setAutorCorrespondente(new AutorCorrespondente(autor.getUtilizador(), autor.getInstituicaoAfiliacao()));
                    artigo.setAutorSubmissor(autor);
                }
            }

            if (artigo.getAutorCorrespondente() == null) {
                throw new IllegalArgumentException(MecanismoLeitura.AUTOR_CORRESPONDENTE_NAO_CONSTA_NA_LISTA);
            }

            submissao.adicionarArtigo(artigo);
            listaSubmissoes.validarSubmissao(submissao);
            listaSubmissoes.adicionarSubmissao(submissao);
        } catch (FileNotFoundException ex) {
            errorLog += MecanismoLeitura.FICHEIRO;
        } catch (IllegalArgumentException ex) {
            errorLog += ex.getMessage();
        }

        if (!errorLog.isEmpty()) {
            try {
                int indice = ficheiro.lastIndexOf("\\");
                String nomeErrorLog = ficheiro.substring(indice + 1) + ".error.log";
                gerarRelatorioErros(nomeErrorLog, errorLog);
                return false;
            } catch (FileNotFoundException ex) {
                // Não foi possível gravar o ficheiro...???
                return false;
            }
        }

        return true;
    }

    /**
     * Gera um relatório com os erros detetados aquando da submissão do artigo
     * por ficheiro.
     *
     * @param nomeErrorLog Nome do ficheiro de erros.
     * @param errorLog Relatório com o erro gerado.
     *
     * @throws FileNotFoundException Lançada no caso de não ser possível gerar o
     * relatório de erros.
     */
    private void gerarRelatorioErros(String nomeErrorLog, String errorLog)
            throws FileNotFoundException {
        Formatter write = new Formatter(new File(nomeErrorLog));

        write.format("%s", errorLog);
        write.close();
    }

}
