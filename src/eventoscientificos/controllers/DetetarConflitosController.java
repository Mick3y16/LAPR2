package eventoscientificos.controllers;

import eventoscientificos.model.Detetavel;
import eventoscientificos.model.Empresa;
import eventoscientificos.model.RegistoTiposConflito;
import eventoscientificos.model.TipoConflito;
import java.util.List;
import java.util.TimerTask;

/**
 * Representa uma instância de DetetarConflitosController recebendo uma empresa
 * e um detétavel.
 *
 * @author G01
 */
public class DetetarConflitosController extends TimerTask {

    /**
     * Empresa que contém a lista de tipo de conflito de interesse.
     */
    private Empresa empresa;

    /**
     * Detetavel que é alterado para em deteção e posteriormente para em 
     * licitação.
     */
    private Detetavel detetavel;

    /**
     * Constrói uma instância de DetetarConflitosController através de uma
     * empresa e de um detetável.
     * 
     * @param empresa empresa 
     * @param detetavel evento/sessão temática onde vai detetar conflitos
     */
    public DetetarConflitosController(Empresa empresa, Detetavel detetavel) {
        this.empresa = empresa;
        this.detetavel = detetavel;
    }
    
    /**
     * Método que despoleta o processo de deteção de um detetavel.
     */
    @Override
    public void run() {
        RegistoTiposConflito registoTiposConflito 
                = this.empresa.getRegistoTiposConflito();
        List<TipoConflito> listaTiposConflitoComMecanismo 
                = registoTiposConflito.getListaTiposConflitoComMecanismo();
        this.detetavel.iniciarProcessoDetecao(listaTiposConflitoComMecanismo);
    }
    
}
