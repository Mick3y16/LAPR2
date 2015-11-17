package eventoscientificos.model.mecanismo.decisao;

import eventoscientificos.model.Decisao;
import eventoscientificos.model.ListaDecisoes;
import eventoscientificos.model.ListaRevisoes;
import eventoscientificos.model.Revisao;

/**
 * Constrói uma instância de MecanismoDecisao1 que classifica cada revisão
 * mediante os parâmetros dados e devolve uma lista com as decisões.
 * 
 * @author G01
 */
public class MecanismoDecisao1 implements MecanismoDecisao {

    /**
     * Constrói uma instância de MecanismoDecisao1.
     */
    public MecanismoDecisao1() {
            }

    /**
     * Devolve uma lista de decisões com as classificações de cada revisão.
     * 
     * @param listaRevisoes Lista de revisões das submissões a classificar.
     * @return Lista de decisões.
     */
    @Override
    public ListaDecisoes classificarSubmissoes(ListaRevisoes listaRevisoes) {
        
        ListaDecisoes listaDecisoes = new ListaDecisoes();
        
        for(Revisao revisao : listaRevisoes.getListaRevisoes()) {
            int classificacao = (revisao.getRecomendacaoGlobal() + 
                    revisao.getAdequacaoArtigo() +
                    revisao.getConfiancaRevisor() +
                    revisao.getOriginalidadeArtigo() +
                    revisao.getQualidadeArtigo()) / 5;
             Decisao decisao = listaDecisoes.novaDecisao(classificacao, revisao.getSubmissao());
             listaDecisoes.adicionarDecisao(decisao);
            }
        return listaDecisoes;
        }
    
}
