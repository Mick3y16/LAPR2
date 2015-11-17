package eventoscientificos.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.codificador.aritmetico.Codificador;
import utils.codificador.aritmetico.CA;
import utils.codificador.aritmetico.NFN;

/**
 * Representa uma instancia de RegistoUtilizadores que representa uma lista de
 * utilizadores do sistema
 *
 * @author G01
 */
public class RegistoUtilizadores {

    /**
     * Lista de Utilizadores do sistema
     */
    private List<Utilizador> listaUtilizadores;

    /**
     * Constrói um map com os dados da tabela.
     */
    public Map<String, Codificador> tabelasCodificacao;

    /**
     * Constrói uma instância de RegistoUtilizadores sem parametros.
     */
    public RegistoUtilizadores() {
        this.tabelasCodificacao = new HashMap<>();
        this.tabelasCodificacao.put("NFN", new NFN());
        this.listaUtilizadores = new ArrayList<>();
    }

    /**
     * Compara dois objetos entre si. Comparando primariamente a posição de
     * memória, seguida do conteudo e das classes as quais cada um deles
     * pertence, e finalmente os seus atributos lista de utilizadores.
     *
     * @param outroObjeto Utilizador que vai ser usado na comparação.
     * @return Verdadeiro caso os objetos comparados sejam iguais e falso caso
     * não o sejam.
     */
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }

        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }

        RegistoUtilizadores outroRegisto = (RegistoUtilizadores) outroObjeto;

        return this.listaUtilizadores.equals(outroRegisto.listaUtilizadores);
    }

    /**
     * Cria uma instancia de utilizador recebendo como parametros o nome, o
     * email, o username e password de utilizador
     *
     * @param nome nome do utilizador a criar
     * @param email email do utilizador a criar
     * @param username username do utilizador a criar
     * @param password password do utilizado a criar
     * @return Utilizador
     */
    public Utilizador novoUtilizador(String nome, String email,
            String username, String password) {
        String novaPassword, codificadorTabela = "";

        if (this.tabelasCodificacao.size() == 1) {
            NFN nfn = (NFN) this.tabelasCodificacao.get("NFN");

            codificadorTabela = nfn.getClass().getSimpleName();

            novaPassword = nfn.codificar(password, 0);
        } else {
            CA ca = (CA) this.tabelasCodificacao.get("CA");

            int tabelaEscolhida = (int) (Math.random() * ca.getSizeListaTabelasFreq());
            codificadorTabela = String.join(";", ca.getClass().getSimpleName(), "T00" + (tabelaEscolhida + 1), "" + password.length());

            novaPassword = ca.codificar(password, tabelaEscolhida);
        }

        Utilizador utilizador = new Utilizador(nome, email, username, novaPassword);
        utilizador.setCodificadorTabela(codificadorTabela);

        if (!utilizador.validarUtilizador()) {
            throw new IllegalArgumentException(" Utilizador invalido");
        }

        if (!validarUtilizador(utilizador)) {
            throw new IllegalArgumentException("Utilizador ja consta na lista"
                    + " de utilizadores da empresa");
        }

        return utilizador;
    }

    /**
     * Cria uma instancia de utilizador recebendo como parametros o nome, o
     * email, o username, password de utilizador, numeroCarateres e
     * codificadorTabela
     *
     * @param nome nome do utilizador a criar
     * @param email email do utilizador a criar
     * @param username username do utilizador a criar
     * @param password password do utilizado a criar
     * @param codificadorTabela tabela do codificador utilizador
     * @return novo utilizador criado
     */
    public Utilizador novoUtilizador(String nome, String email, String username,
            String password, String codificadorTabela) {

        Utilizador utilizador = new Utilizador(nome, email, username, password);
        utilizador.setCodificadorTabela(codificadorTabela);

        if (!utilizador.validarUtilizador()) {
            throw new IllegalArgumentException(" Utilizador invalido");
        }
        if (!validarUtilizador(utilizador)) {
            throw new IllegalArgumentException("Utilizador ja consta na lista"
                    + " de utilizadores da empresa");
        }
        return utilizador;
    }

    /**
     * Adiciona o utilizador passado por parametro a lista de utilizadores caso
     * este nao exista na lista
     *
     * @param utilizador instancia de Utilizador a adicionar
     * @return true quando adicionado caso o utilizador nao exista na lista de
     * utilizadores e adicionado e false caso o utilizador
     */
    public boolean adicionaUtilizador(Utilizador utilizador) {
        return this.listaUtilizadores.add(utilizador);
    }

    /**
     * Verifica se o utilizador passado por parametro ja consta na lista de
     * utilizadores
     *
     * @param utilizador instancia de Utilizador a verificar
     * @return true caso nao exista na lista e false caso ja conste
     */
    private boolean validarUtilizador(Utilizador utilizador) {
        return !listaUtilizadores.contains(utilizador);
    }

    /**
     * Verifica se o utilizador passado por paraemtro já consta na lista de
     * utilizadores, ignorando o utilizador que lhe deu origem.
     *
     * @param utilizador utilizador
     * @param utilizadorClone utilizador clone
     * @return Verdadeiro se o utilizador passado por parametro não existir
     */
    public boolean validarUtilizadorClone(
            Utilizador utilizador, Utilizador utilizadorClone) {
        for (Utilizador outroUtilizador : this.listaUtilizadores) {
            if (utilizadorClone.equals(outroUtilizador)
                    && !utilizador.equals(outroUtilizador)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Atualiza um utilizador na lista de utilizadores, substituindo o atual
     * pelo novo.
     *
     * @param utilizador Utilizador antigo.
     * @param utilizadorClone Utilizador novo.
     * @return Verdadeiro se for possível realizar a atualização e falso caso
     * não seja.
     */
    public boolean atualizarUtilizador(
            Utilizador utilizador, Utilizador utilizadorClone) {
        return this.listaUtilizadores.remove(utilizador)
                && this.listaUtilizadores.add(utilizadorClone);
    }

    /**
     * Devolve o número total de utilizadores na lista.
     *
     * @return Número total de utilizadores na lista.
     */
    public int getNumeroUtilizadores() {
        return this.listaUtilizadores.size();
    }

    /**
     * Devolve um utilizador através da sua posição na lista.
     *
     * @param indice Posição na lista.
     *
     * @return Utilizador através da sua posição na lista.
     */
    public Utilizador getUtilizadorPeloID(int indice) {
        return this.listaUtilizadores.get(indice);
    }

    /**
     * Procura um utilizador na lista de utilizadores através dos seus
     * identificadores (username ou email).
     *
     * @param id ID do utilizador, pode ser o seu utilizador ou email
     * @return Um objeto do tipo utilizador, caso o mesmo exista, senão retorna
     * null.
     */
    public Utilizador getUtilizador(String id) {
        for (Utilizador utilizador : this.listaUtilizadores) {
            if (utilizador.getEmail().equals(id)
                    || utilizador.getUsername().equals(id)) {
                return utilizador;
            }
        }

        return null;
    }

    /**
     * Inicia a criação do codificador aritmético.
     *
     * @throws java.io.IOException 
     */
    public void iniciarCodificadorAritmetico() throws IOException {
        this.tabelasCodificacao.put("CA", new CA());
    }

    /**
     * Codifica uma password através de uma tabela de probabilidades.
     * 
     * @param password Password a codificar.
     * @param tabela Tabela de codificação.
     * 
     * @return Password codificada.
     */
    public String codificarPassword(String password, int tabela) {
        return this.tabelasCodificacao.get("CA").codificar(password, tabela);
    }

}
