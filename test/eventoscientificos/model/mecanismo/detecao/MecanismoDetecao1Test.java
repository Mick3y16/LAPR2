package eventoscientificos.model.mecanismo.detecao;

import eventoscientificos.model.Artigo;
import eventoscientificos.model.Autor;
import eventoscientificos.model.InstituicaoAfiliacao;
import eventoscientificos.model.ListaAutores;
import eventoscientificos.model.ListaConflitos;
import eventoscientificos.model.Revisor;
import eventoscientificos.model.Submissao;
import eventoscientificos.model.TipoConflito;
import eventoscientificos.model.Utilizador;
import eventoscientificos.model.state.submissao.SubmissaoEmSubmissaoState;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author G01
 */
public class MecanismoDetecao1Test {
    
    public MecanismoDetecao1Test() {
        
    }

    /**
     * Test of detetarConflito method, of class MecanismoDetecao1.
     */
    @Test
    public void testDetetarConflito() {
        System.out.println("detetarConflito");
        ListaConflitos listaConflitos = new ListaConflitos();
        Utilizador utilizador = new Utilizador(
                "Pedro", "1140781@isep.ipp.pt", "pedro", "1234");
        Revisor revisor = new Revisor(utilizador);
        Artigo artigo = new Artigo();
        ListaAutores listaAutores = artigo.getListaAutores();
        listaAutores.novoAutor(utilizador, new InstituicaoAfiliacao("ISEP"));
        Submissao submissao = new Submissao();
        submissao.setEstado(new SubmissaoEmSubmissaoState(submissao));
        submissao.setArtigoInicial(artigo);
        TipoConflito tipoConflito = new TipoConflito(
                new MecanismoDetecao1(), "É autor do artigo!");
        MecanismoDetecao instance = tipoConflito.getMecanismoDetecao();
        boolean expResult = true;
        boolean result = instance.detetarConflito(
                listaConflitos, revisor, submissao, tipoConflito);
        assertEquals(expResult, result);
    }
    
}
