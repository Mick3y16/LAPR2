package eventoscientificos.model;

import eventoscientificos.model.mecanismo.decisao.MecanismoDecisao;
import eventoscientificos.model.mecanismo.decisao.MecanismoDecisao1;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste à classe ProcessoDecisao.
 *
 * @author G01
 */
public class ProcessoDecisaoTest {

    public ProcessoDecisaoTest() {

    }

    /**
     * Teste do método adicionarMecanismoDecisao, da classe ProcessoDecisao.
     */
    @Test
    public void testAdicionarMecanismoDecisao() {
        System.out.println("adicionarMecanismoDecisao");
        MecanismoDecisao mecanismoDecisao = new MecanismoDecisao1();
        ProcessoDecisao instance = new ProcessoDecisao();
        boolean expResult = true;
        boolean result = instance.adicionarMecanismoDecisao(mecanismoDecisao);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método classificarSubmissoes, da classe ProcessoDecisao.
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

        int classificacao = 1;
        Decisao decisao = new Decisao(classificacao, submissao);

        Revisao revisao = new Revisao(submissao, revisor);
        revisao.setAdequacaoArtigo(5);
        revisao.setConfiancaRevisor(4);
        revisao.setOriginalidadeArtigo(3);
        revisao.setQualidadeArtigo(4);
        revisao.setRecomendacaoGlobal(2);
        revisao.setTextoJustificativo("ola");

        ListaRevisoes listaRevisoes = new ListaRevisoes();
        listaRevisoes.adicionarRevisao(revisao);

        MecanismoDecisao1 instance = new MecanismoDecisao1();

        instance.classificarSubmissoes(listaRevisoes);
        int expResult = 1;
        ListaDecisoes listaDecisoes = instance.classificarSubmissoes(listaRevisoes);
        int result = listaDecisoes.getListaDecisoes().size();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método notificarSobreDecisoes, da classe ProcessoDecisao.
     */
    @Test
    public void testNotificarSobreDecisao() {
        System.out.println("notificarSobreDecisao");

        Submissao submissao = new Submissao();
        Utilizador utilizador = new Utilizador("nome",
                            "1140587@isep.ipp.pt",
                            "username",
                            "password");
        submissao.setArtigoInicial(new Artigo());
        submissao.getArtigoInicial().setAutorCorrespondente(new AutorCorrespondente(utilizador, new InstituicaoAfiliacao("Matosinhos")));
        int classificacao = 1;
        Decisao decisao = new Decisao(classificacao, submissao);

        ProcessoDecisao instance = new ProcessoDecisao();
        instance.getListaDecisoes().adicionarDecisao(decisao);
        boolean expResult = true;
        boolean result = instance.notificarSobreDecisoes();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals, da classe ProcessoDecisao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
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

        MecanismoDecisao mecanismo = new MecanismoDecisao1();

        ProcessoDecisao outroProcesso = new ProcessoDecisao();
        outroProcesso.adicionarMecanismoDecisao(mecanismo);
        outroProcesso.classificarSubmissoes(listaRevisoes);

        ProcessoDecisao instance = new ProcessoDecisao();
        instance.adicionarMecanismoDecisao(mecanismo);
        instance.classificarSubmissoes(listaRevisoes);

        boolean expResult = true;
        boolean result = instance.equals(outroProcesso);
        assertEquals(expResult, result);
    }
//    

    /**
     * Teste do método equalsNot, da classe ProcessoDecisao.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equalsNot");
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

        Revisao revisao2 = new Revisao(submissao, revisor);
        revisao2.setAdequacaoArtigo(3);
        revisao2.setConfiancaRevisor(3);
        revisao2.setOriginalidadeArtigo(2);
        revisao2.setQualidadeArtigo(3);
        revisao2.setRecomendacaoGlobal(2);
        revisao2.setTextoJustificativo("ola");
        ListaRevisoes listaRevisoes2 = new ListaRevisoes();
        listaRevisoes2.adicionarRevisao(revisao2);

        MecanismoDecisao mecanismo = new MecanismoDecisao1();

        ProcessoDecisao outroProcesso = new ProcessoDecisao();
        outroProcesso.adicionarMecanismoDecisao(mecanismo);
        outroProcesso.classificarSubmissoes(listaRevisoes);

        ProcessoDecisao instance = new ProcessoDecisao();
        instance.adicionarMecanismoDecisao(mecanismo);
        instance.classificarSubmissoes(listaRevisoes2);

        boolean expResult = false;
        boolean result = instance.equals(outroProcesso);
        assertEquals(expResult, result);
    }

}
