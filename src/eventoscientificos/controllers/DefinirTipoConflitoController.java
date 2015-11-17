package eventoscientificos.controllers;

import eventoscientificos.model.Empresa;
import eventoscientificos.model.RegistoTiposConflito;
import eventoscientificos.model.TipoConflito;

/**
 * Representa instância da classe DefinirTipoConflitoController
 * @author G01
 */
public class DefinirTipoConflitoController {

    /**
     * Empresa que contém os dados.
     */
    private Empresa empresa;

    /**
     * Registo dos tipos de conflito existentes.
     */
    private RegistoTiposConflito registoTiposConflito;

    /**
     * Novo tipo de conflito.
     */
    private TipoConflito tipoConflito;

    /**
     * Constrói uma instância de DefinirTippoConflitoController recebendo uma
     * empresa.
     * 
     * @param empresa Empresa que contém os dados.
     */
    public DefinirTipoConflitoController(Empresa empresa) {
        this.empresa = empresa;
        this.registoTiposConflito = null;
        this.tipoConflito = null;
    }

    /**
     * Trata de ir buscar o registo dos tipos de conflito existentes.
     * 
     * @return Verdadeiro se o registo for retornado com sucesso.
     */
    public boolean getRegistoTiposConflito() {
        this.registoTiposConflito = this.empresa.getRegistoTiposConflito();
        
        return this.registoTiposConflito != null;
    }

    /**
     * Trata de mandar criar um novo tipo de conflito.
     * 
     * @param descricao Descrição do novo tipo de conflito.
     * 
     * @return Verdadeiro se for possível criar o tipo de conflito.
     */
    public boolean novoTipoConflito(String descricao) {
        this.tipoConflito 
                = this.registoTiposConflito.novoTipoConflito(descricao);

        return this.tipoConflito != null;
    }

    /**
     * Adiciona o novo tipo de conflito ao registo de tipos de conflitos.
     * 
     * @return Verdadeiro se o tipo de conflito for adicionado com sucesso.
     */
    public boolean adicionarTipoConflito() {
        return this.registoTiposConflito.adicionarTipoConflito(
                this.tipoConflito);
    }

}
