package eventoscientificos.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testa a classe Decisao.
 * @author G01
 */
public class DecisaoTest {
    
    private int classificacao;
    
    public DecisaoTest() {
        this.classificacao = 1;
    }

    /**
     * Teste do método equals, da classe Decisao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Submissao submissao = new Submissao();
        Object outroObjecto = new Decisao(this.classificacao, submissao);
        Decisao outraDecisao = (Decisao) outroObjecto;
        Decisao instance = new Decisao(this.classificacao, submissao);
        boolean expResult = true;
        boolean result = instance.equals(outroObjecto);
        assertEquals(expResult, result);
    }
    
    /**
     * Teste do método equalsNot, da classe Decisao.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equalsNot");
        Submissao submissao = new Submissao();
        Object outroObjecto = new Decisao(this.classificacao, submissao);
        Decisao outraDecisao = (Decisao) outroObjecto;       
        this.classificacao = 2;
        Decisao instance = new Decisao(this.classificacao, submissao);
        boolean expResult = false;
        boolean result = instance.equals(outroObjecto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método criarNotificacao, da classe Decisao.
     */
    @Test(expected = NullPointerException.class)
    public void testCriarNotificacao() {
        System.out.println("criarNotificacao");
        InstituicaoAfiliacao instituicao = new InstituicaoAfiliacao("nome");
        Submissao submissao = new Submissao();
        Utilizador utilizador = new Utilizador("nome",
                "1140587@isep.ipp.pt",
                "username",
                "password");
        AutorCorrespondente autorCorrespondente = new AutorCorrespondente(utilizador, instituicao);
        Notificacao notificacao = new Notificacao(this.classificacao);
        submissao.getArtigoInicial().setAutorCorrespondente(autorCorrespondente);
        Decisao instance = new Decisao(this.classificacao, submissao);
        boolean expResult = false;
        boolean result = instance.criarNotificacao();
        assertEquals(expResult, result);
    }
    
}
