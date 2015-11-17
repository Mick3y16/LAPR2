/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos.model.mecanismo.distribuicao;

import eventoscientificos.model.CP;
import eventoscientificos.model.Distribuivel;
import eventoscientificos.model.ListaRevisoes;
import eventoscientificos.model.Revisao;
import eventoscientificos.model.Revisor;
import eventoscientificos.model.Submissao;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma instância de um
 *
 * @author G01
 */
public class MecanismoDistribuicaoTodasSubmissoesPorRevisor implements MecanismoDistribuicao {

    /**
     * Constrói uma instância de MecanismoDistribuicaoTodasSubmissoesPorRevisor 
     * por omissão
     */
    public MecanismoDistribuicaoTodasSubmissoesPorRevisor() {
    }

    
    /**
     * Distribui as submissões por cada um dos revisores.
     *
     * @param distribuivel evento/sessão temática onde se vai distribuir
     * @param lr lista de revisões a incluir as revisões
     * @return verdadeiro se distribuir e falso se não conseguir distribuir
     */
    @Override
    public boolean distribuirRevisoes(Distribuivel distribuivel, ListaRevisoes lr) {
        boolean distribuido = false;
        List<Submissao> listaSubmissoes = distribuivel.getListaSubmissoes().getListaSubmissoes();
        List<Revisor> listaRevisores = new ArrayList<>();
        CP cpDistribuivel = distribuivel.getCP();
        int tamanho = cpDistribuivel.getNumeroRevisores();
        for (int i = 0; i < tamanho; i++) {
            Revisor revisor = cpDistribuivel.getRevisorPeloID(i);
            for (Submissao s : listaSubmissoes) {
                lr.adicionarRevisao(new Revisao(s, revisor));

            }
            distribuido = true;
        }
        return distribuido;
    }

}
