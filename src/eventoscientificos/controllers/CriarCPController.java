package eventoscientificos.controllers;

import eventoscientificos.model.CP;
import eventoscientificos.model.CPDefinivel;
import eventoscientificos.model.Empresa;
import eventoscientificos.model.RegistoEventos;
import eventoscientificos.model.RegistoUtilizadores;
import eventoscientificos.model.Revisor;
import eventoscientificos.model.Utilizador;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 * Representa uma instância de CriarCPController através de CPDefinivel.
 *
 * @author G01
 */
public class CriarCPController {

    /**
     * Intancia de Empresa.
     */
    private Empresa empresa;

    /**
     * Modelo da lista de revisores.
     */
    private DefaultListModel modeloLista;

    /**
     * Instancia de listaCPDefinivel
     */
    private List<CPDefinivel> listaCPDefinivel;

    /**
     * Instancia de CPDefinivel.
     */
    private CPDefinivel CPDefinivel;

    /**
     * Instancia de RegistoUtilizadores.
     */
    private RegistoUtilizadores registoUtilizadores;

    /**
     * Instancia de CP.
     */
    private CP CP;

    /**
     * Constrói uma instância de CriarCPController recebendo uma empresa por
     * parametro.
     *
     * @param empresa Empresa.
     */
    public CriarCPController(Empresa empresa) {
        this.empresa = empresa;
        this.modeloLista = new DefaultListModel<Revisor>();
        this.listaCPDefinivel = null;
        this.CPDefinivel = null;
        this.registoUtilizadores = null;
        this.CP = null;
    }

    /**
     * Devolve o modelo da lista de revisores.
     *
     * @return Modelo da lista de revisores.
     */
    public DefaultListModel getModeloLista() {
        return this.modeloLista;
    }

    /**
     * Devolve uma lista de eventos e sessões temáticas onde é possível definir
     * uma CP.
     *
     * @return Lista de eventos e sessões temáticas onde é possível definir CP.
     */
    public List<CPDefinivel> getListaCPDefinivel() {
        return this.listaCPDefinivel;
    }

    /**
     * Manda criar uma lista de eventos/sessão temáticas que se encontrem sem CP
     * definida e onde o utilizador é organizador/proponente.
     *
     * @return verdadeiro se a lista CPDefinivel estiver preenchida e falso se
     * não estiver
     */
    public boolean getListaCPDefiniveisSemCPOrganizadorProponente() {
        RegistoEventos registoEventos = this.empresa.getRegistoEventos();

        Utilizador utilizador = this.empresa.getUtilizadorAutenticado();

        this.listaCPDefinivel
                            = registoEventos.getListaCPDefiniveisSemCPOrganizadorProponente(
                                                utilizador);

        return this.listaCPDefinivel != null;
    }

    /**
     * Seleciona um CPDefinivel (evento/sessão temática) da lista de
     * CPDefiniveis pelo indice.
     *
     * @param indice Indice do evento/sessão temática selecionado.
     * @return verdadeiro se selecionar um CPDefinivel e falso se não 
     */
    public boolean selecionarCPDefinivel(int indice) {

        this.CPDefinivel = this.listaCPDefinivel.get(indice);

        this.CP = CPDefinivel.novaCP();

        this.registoUtilizadores = empresa.getRegistoUtilizadores();

        return this.CPDefinivel != null && this.CP != null
                            && this.registoUtilizadores != null;
    }

    /**
     * Cria uma instancia de Revisor recebendo como parametro uma String id
     *
     * @param id Id de utilizador do revisor.
     * @return verdadeuro se criar com sucesso um revisor e falso se não criar
     */
    public boolean novoRevisor(String id) {
        Utilizador utilizador = this.registoUtilizadores.getUtilizador(id);

        if (utilizador != null
                            && !this.modeloLista.contains(new Revisor(utilizador))) {
            this.modeloLista.addElement(new Revisor(utilizador));
        }

        return this.CP.novoRevisor(utilizador);
    }

    /**
     * Valida se a CP tem pelo menos um revisor.
     *
     * @return Verdadeiro se existir pelo menos um revisor e falso caso não
     * exista nenhum.
     */
    public boolean validarCP() {
        if (!this.CP.validarCP()) {
            throw new IllegalArgumentException("Deve introduzir pelo menos um "
                                + "revisor.");
        }

        return true;
    }

    /**
     * Adiciona a CP ao evento ou sessão temática escolhido previamente.
     *
     * @return Verdadeiro caso a CP seja adicionada e falso caso não seja.
     */
    public boolean adicionarCP() {
        return this.CPDefinivel.adicionarCP(this.CP);

    }

}
