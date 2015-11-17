/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.codificador.aritmetico;

/**
 * Todas as classes que implementam esta interface, herdam a responsabilidade de
 * codificar a palavra recebida por parâmetro.
 *
 * @author G01
 */
public interface Codificador {

    /**
     * Codifica a palavra recebida por parãmetro
     *
     * @param password password a codificar
     * @param tabela indice da tabela
     * @return palavra codificada
     */
    public String codificar(String password, int tabela);

}
