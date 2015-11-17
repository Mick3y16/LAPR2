package eventoscientificos.model.mecanismo.decisao;

import eventoscientificos.model.Decisao;
import eventoscientificos.model.ListaDecisoes;
import eventoscientificos.model.ListaRevisoes;
import eventoscientificos.model.Revisao;
import eventoscientificos.model.Revisor;
import eventoscientificos.model.Submissao;
import eventoscientificos.model.Utilizador;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G01
 */
public class MecanismoDecisao1Test {

    public MecanismoDecisao1Test() {

    }

    /**
     * Teste do método classificarSubmissoes, da classe MecanismoDecisao1.
     */
    @Test
    public void testClassificarSubmissoes() {
        System.out.println("classificarSubmissoes");
        Submissao submissao = new Submissao();
        Utilizador utilizador = new Utilizador("nome",
                "1140587@isep.ipp.pt",
                "username",
                "password");

        Revisor revisor = new Revisor(utilizador);

        Revisao revisao = new Revisao(submissao, revisor);
        revisao.setAdequacaoArtigo(5);
        revisao.setConfiancaRevisor(4);
        revisao.setOriginalidadeArtigo(3);
        revisao.setQualidadeArtigo(4);
        revisao.setRecomendacaoGlobal(2);
        revisao.setTextoJustificativo("ola");
        ListaRevisoes listaRevisoes = new ListaRevisoes();
        listaRevisoes.adicionarRevisao(revisao);
        Decisao decisao = new Decisao(5, submissao);
        MecanismoDecisao1 instance = new MecanismoDecisao1();
        instance.classificarSubmissoes(listaRevisoes);
        int expResult = 1;
        ListaDecisoes listaDecisoes = instance.classificarSubmissoes(listaRevisoes);
        int result = listaDecisoes.getListaDecisoes().size();
        assertEquals(expResult, result);
    }

}
