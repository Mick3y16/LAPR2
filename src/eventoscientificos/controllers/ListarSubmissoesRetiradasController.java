package eventoscientificos.controllers;

import eventoscientificos.model.Empresa;
import eventoscientificos.model.RegistoEventos;
import eventoscientificos.model.Submissao;
import eventoscientificos.model.Submissivel;
import eventoscientificos.model.Utilizador;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 * Representa instância da classe ListarSubmissoesRetiradasController
 *
 * @author G01
 */
public class ListarSubmissoesRetiradasController {

    /**
     * Instância de empresa.
     */
    private Empresa empresa;

    /**
     * Modelo da lista de submissões retiradas.
     */
    private DefaultListModel<Submissao> modeloLista;

    /**
     * Instância de listaSubmissiveisComSubRetiradas.
     */
    private List<Submissivel> listaSubmissiveisComSubRetiradas;

    /**
     * Constrói uma instância de ListarSubmissoesRetiradasController.
     *
     * @param empresa empresa.
     */
    public ListarSubmissoesRetiradasController(Empresa empresa) {
        this.empresa = empresa;
        this.modeloLista = new DefaultListModel();
        this.listaSubmissiveisComSubRetiradas = null;
    }

    /**
     * Devolve a lista de submissiveis.
     *
     * @return Lista de submissiveis.
     */
    public List<Submissivel> getListaSubmissiveis() {
        return this.listaSubmissiveisComSubRetiradas;
    }

    /**
     * Devolve o modelo da lista de submissões retiradas.
     *
     * @return Modelo da lista de submissões retiradas.
     */
    public DefaultListModel<Submissao> getModeloLista() {
        return this.modeloLista;
    }

    /**
     * Retorna uma lista de submissiveis com submissões retiradas do
     * evento/sessão temática em que o utilizador autenticado é
     * organizador/proponente.
     *
     * @return Verdadeiro caso exista uma lista e falso se não existir.
     */
    public boolean getListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente() {
        RegistoEventos registoEventos = this.empresa.getRegistoEventos();

        Utilizador utilizador = this.empresa.getUtilizadorAutenticado();

        this.listaSubmissiveisComSubRetiradas = registoEventos.
                            getListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente(utilizador);

        return listaSubmissiveisComSubRetiradas != null;
    }

    /**
     * Retorna uma lista de submissões retiradas do evento/sessão temática que
     * tenham submissões retiradas.
     *
     * @param indice Indice do submissivel selecionado.
     * @return Verdadeiro caso exista uma lista com submissoes retiradas e falso
     * se não existir.
     */
    public boolean selecionarSubmissivel(int indice) {
        Submissivel submissivel = this.listaSubmissiveisComSubRetiradas.get(indice);

        for (Submissao submissao : submissivel.getListaSubmissoesRetiradas()) {
            this.modeloLista.addElement(submissao);
        }

        return true;
    }

}
