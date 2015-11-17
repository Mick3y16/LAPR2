package eventoscientificos.model;

import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmCameraReadyState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaEmSubmissaoCameraReadyState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import utils.Data;

/**
 * Representa uma instância de uma lista de Sessões Temáticas através dessa
 * mesma lista.
 *
 * @author G01
 */
public class ListaSessoesTematicas {

    /**
     * Evento ao qual a Lista de Sessões Temáticas pertence.
     */
    private Evento evento;

    /**
     * Lista de Sessões Temáticas.
     */
    private List<SessaoTematica> listaSessoesTematicas;

    /**
     * Constrói uma instância de uma lista de Sessões Temáticas recebendo o
     * evento à qual pertence.
     *
     * @param evento Evento ao qual a Lista de Sessões Temáticas pertence.
     */
    public ListaSessoesTematicas(Evento evento) {
        this.evento = evento;
        this.listaSessoesTematicas = new ArrayList();
    }

    /**
     * Devolve uma lista de sessões tméticas.
     *
     * @return Lista de Sessões Temáticas.
     */
    public List<SessaoTematica> getListaSessoesTematicas() {
        return this.listaSessoesTematicas;
    }

    /**
     * Compara dois objetos entre si. Comparando primariamente a posição de
     * memória, seguida do conteudo e das classes as quais cada um deles
     * pertence, e finalmente os seus atributos, evento que a contém e as suas
     * sessões temáticas.
     *
     * @param outroObjeto ListaSessoesTematicas que vai ser usada na comparação.
     * @return Verdadeiro caso os objetos comparados sejam iguais e falso caso
     * não o sejam.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }

        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }

        ListaSessoesTematicas outraListaSessoesTematicas
                            = (ListaSessoesTematicas) outroObjeto;

        return this.evento.equals(outraListaSessoesTematicas.evento)
                            && this.listaSessoesTematicas.equals(
                                                outraListaSessoesTematicas.listaSessoesTematicas);
    }

    /**
     * Cria uma instância de sessão temática com um código único, uma descrição,
     * uma data de inicio de submissão e data de fim de submissão.
     *
     * @param codigoUnico Código único da Sessão Temática.
     * @param descricao Descrição da Sessão Temátiica.
     * @param dataInicioSubmissao Data de inicio do periodo de submissão da
     * Sessão Temática.
     * @param dataFimSubmissao Data de fim do periodo de submissão da Sessão
     * Temática.
     * @param dataFimRevisao Data de fim de revisão de submissoes da Sessão
     * Temática
     * @param dataInicioDistribuicao Data de início de distribuição da Sessão
     * Temática.
     * @param dataFimSubmissaoCameraReady Data de fim do periodo de submissão do
     * artigo final da Sessão Temática.
     * @param dataInicio Data de início da Sessão Temática.
     * @param dataFim Data de fim da Sessão Temática.
     * @return Sessão Temática.
     */
    public SessaoTematica novaSessaoTematica(
                        String codigoUnico, String descricao,
                        Data dataInicioSubmissao, Data dataFimSubmissao,
                        Data dataFimRevisao, Data dataInicioDistribuicao,
                        Data dataFimSubmissaoCameraReady, Data dataInicio,
                        Data dataFim) {
        return new SessaoTematica(
                            codigoUnico, descricao, dataInicioSubmissao, dataFimSubmissao,
                            dataFimRevisao, dataInicioDistribuicao,
                            dataFimSubmissaoCameraReady, dataInicio, dataFim);
    }

    /**
     * Adiciona uma instância de uma Sessão Temática a uma lista.
     *
     * @param sessaoTematica Sessão Temática que vai ser adicionada à lista.
     * @return Verdadeiro caso a Sessão Temática seja adicionada à lista e falso
     * caso a adição falhe.
     */
    public boolean adicionarSessaoTematica(SessaoTematica sessaoTematica) {
        return this.listaSessoesTematicas.add(sessaoTematica);
    }

    /**
     * Devolve o número total de sessões temáticas na lista.
     *
     * @return Número total de sessões temaáticas na lista.
     */
    public int getNumeroSessoesTematicas() {
        return this.listaSessoesTematicas.size();
    }

    /**
     * Devolve uma sessão temática através da sua posição na lista.
     *
     * @param indice Posição na lista.
     *
     * @return Sessão temática através da sua posição na lista.
     */
    public SessaoTematica getSessoesTematicasPeloID(int indice) {
        return this.listaSessoesTematicas.get(indice);
    }

    /**
     * Valida uma instância de Sessão Temática verificando se a mesma já existe
     * numa lista e se as suas datas estão dentro das do evento.
     *
     * @param sessaoTematica Sessão Temática que vai ser procurada na lista e
     * validada contra o evento.
     * @return Verdadeiro se a Sessão Temática não existir na lista e as suas
     * datas estiverem dentro das do evento e falso caso já esteja na lista.
     */
    public boolean validarSessaoTematica(SessaoTematica sessaoTematica) {
        if (this.evento.getDataInicioSubmissao().isMaior(
                            sessaoTematica.getDataInicioSubmissao())) {
            throw new IllegalArgumentException("A data de inicio de submissão "
                                + "da sessão temática não pode ser menor que a do evento");
        }

        if (this.evento.getDataFimSubmissao().isMaior(
                            sessaoTematica.getDataFimSubmissao())) {
            throw new IllegalArgumentException("A data de fim de submissão da "
                                + "sessão temática não pode ser menor que a do evento");
        }

        if (this.evento.getDataInicioDistribuicao().isMaior(
                            sessaoTematica.getDataInicioDistribuicao())) {
            throw new IllegalArgumentException("A data de inicio de distribuição"
                                + " da sessão temática não pode ser menor que a do evento");
        }

        if (this.evento.getDataFimRevisao().isMaior(
                            sessaoTematica.getDataFimRevisao())) {
            throw new IllegalArgumentException("A data de fim de revisão da "
                                + "sessão temática não pode ser menor que a do evento");
        }

        if (this.evento.getDataFimSubmissaoCameraReady().isMaior(
                            sessaoTematica.getDataFimSubmissaoCameraReady())) {
            throw new IllegalArgumentException("A data de fim de submissão "
                                + "Camera Ready da sessão temática não pode ser menor que a "
                                + "do evento");
        }

        if (this.evento.getDataInicio().isMaior(sessaoTematica.getDataInicio())
                            || sessaoTematica.getDataFim().isMaior(
                                                this.evento.getDataFim())) {
            throw new IllegalArgumentException("A sessão temática deve ocorrer "
                                + "dentro do periodo do evento.");
        }

        return !this.listaSessoesTematicas.contains(sessaoTematica);
    }

    /**
     * Devolve uma lista de submissiveis nos quais ainda é possivel submeter
     * artigos
     *
     *
     * @return Lista de Submisiveis que aceitam submisoes
     */
    public List<Submissivel> getListaSubmissiveisAceitarArtigo() {
        List<Submissivel> listaSubmissiveis = new ArrayList<>();

        for (SessaoTematica sessaoTematica : this.listaSessoesTematicas) {
            if (sessaoTematica.isStateValidoParaSubmeter()) {
                listaSubmissiveis.add(sessaoTematica);
            }
        }
        return listaSubmissiveis;
    }

    /**
     * Verifica se existem Sessões Temáticas a uma lista.
     *
     * @return Verdadeiro caso existam Sessões Temáticas definidas na lista e
     * falso caso esteja vazia.
     */
    public boolean temSessoesTematicasDefinidas() {
        return this.listaSessoesTematicas.size() > 0;
    }

    /**
     * Devolve uma lista de Submissiveis que tem submissoes em que o utilizador
     * passado por parametro é autor e que estão a permitir a alteração de
     * submissões.
     *
     * @param utilizador utilizador
     * @return Lista de Submissiveis.
     */
    public List<Submissivel> getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador(
                        Utilizador utilizador) {
        List<Submissivel> listaSubmissiveisUtilizador = new ArrayList<>();

        for (SessaoTematica sessaoTematica : this.listaSessoesTematicas) {
            if (sessaoTematica.isStateValidoParaAlterar() && sessaoTematica.isUtilizadorUmAutorSubmissao(utilizador)) {
                listaSubmissiveisUtilizador.add(sessaoTematica);
            }
        }
        return listaSubmissiveisUtilizador;
    }

    /**
     * Devolve uma lista de sessão temáticas que se encontrem sem CP definida e
     * onde o utilizador é proponente.
     *
     * @param utilizador Utilizador a verificar se é proponente.
     * @return Lista de sessao temática onde o utilizador é proponente.
     */
    List<CPDefinivel> getListaCPDefiniveisSemCPOrganizadorProponente(Utilizador utilizador) {
        List<CPDefinivel> listaSemCPDefinida = new ArrayList();
        for (SessaoTematica sessaoTematica : this.listaSessoesTematicas) {
            if (sessaoTematica.isRegistada()
                                && sessaoTematica.isProponente(utilizador)) {
                listaSemCPDefinida.add(sessaoTematica);
            }
        }

        return listaSemCPDefinida;
    }

    /**
     * Devolve uma lista de submissiveis com as sessoes tematicas que tenham
     * submissoes retiradas onde o utilizador é proponente.
     *
     * @param utilizador Utilizador a verificar se é proponente.
     * @return Lista de submissiveis onde o utilizador é proponente.
     */
    public List<Submissivel> getListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente(Utilizador utilizador) {
        List<Submissivel> listaSubmissiveis = new ArrayList<>();
        for (SessaoTematica sessaoTematica : this.listaSessoesTematicas) {
            if (sessaoTematica.temSubmissoesRetiradas(utilizador)) {
                listaSubmissiveis.add(sessaoTematica);
            }
        }
        return listaSubmissiveis;
    }

    /**
     * Devolve uma lista de Submissiveis que tem submissoes em que o utilizador
     * passado por parametro é autor e que estão a permitir a alteração de
     * submissões.
     *
     * @param utilizador utilizador
     * @return Lista de Submissiveis.
     */
    public List<Submissivel> getListaSubmissiveisAceitarAlteracaoArtigoComSubmissaoUtilizador(
                        Utilizador utilizador) {
        List<Submissivel> listaSubmissiveisUtilizador = new ArrayList<>();

        for (SessaoTematica sessaoTematica : this.listaSessoesTematicas) {
            if (sessaoTematica.isStateValidoParaAlterar() && sessaoTematica.isUtilizadorUmAutorSubmissao(utilizador)) {
                listaSubmissiveisUtilizador.add(sessaoTematica);
            }
        }
        return listaSubmissiveisUtilizador;
    }

    public List<Submissivel> getListaSubmissiveisAceitarArtigoFinal(Utilizador utilizador) {
        List<Submissivel> listaSusmissiveisUtilizador = new ArrayList<>();

        for (SessaoTematica sessaoTematica : this.listaSessoesTematicas) {
            if (sessaoTematica.isStateValidoParaSubmeterArtigoFinal()
                                && sessaoTematica.isUtilizadorUmAutorSubmissaoInicial(utilizador)) {
                listaSusmissiveisUtilizador.add(sessaoTematica);
            }
        }
        return listaSusmissiveisUtilizador;
    }

    /**
     * Devolve uma lista de Decidivel de sessão temática em que o utilizador é
     * proponente e que é possivel decidir.
     *
     * @param utilizador Utilizador a verificar se é proponente.
     * @return Lista Decidivel
     */
    public List<Decidivel> getListaDecidivelOrganizadorProponente(Utilizador utilizador) {
        List<Decidivel> listaDecidivel = new ArrayList<>();

        for (SessaoTematica sessaoTematica : this.listaSessoesTematicas) {
            boolean submissoesAceites = false;
            int indice = 0;
            if (sessaoTematica.isProponente(utilizador) && sessaoTematica.isEstadoValidoParaDecidir()) {
                do {
                    Submissao s = sessaoTematica.getListaSubmissoes().getListaSubmissoes().get(indice);
                    if (s.isStateValidoParaDecidir()) {
                        listaDecidivel.add(sessaoTematica);
                        submissoesAceites = true;
                    }
                } while (submissoesAceites != true);
            }
            indice++;
        }
        return listaDecidivel;
    }

    /**
     * Preenche os mapas com as palavras chaves e respetivas recomendações
     * globais.
     *
     * @param hashMapSubmissoesAceites Mapa de submissões aceites.
     * @param hashMapSubmissoesRejeitadas Mapa de submissões rejeitadas.
     */
    public void hashMapSubmissoesSessaoTematica(
                        HashMap<String, Integer> hashMapSubmissoesAceites,
                        HashMap<String, Integer> hashMapSubmissoesRejeitadas) {

        for (SessaoTematica sessaoTematica : this.listaSessoesTematicas) {
            if (sessaoTematica.getEstado() instanceof SessaoTematicaEmSubmissaoCameraReadyState
                                || sessaoTematica.getEstado() instanceof SessaoTematicaEmCameraReadyState) {

                sessaoTematica.hashMapSubmissoesSessaoTematica(hashMapSubmissoesAceites,
                                    hashMapSubmissoesRejeitadas);
            }
        }
    }

    /**
     * Devolve a Sessao Tematica com o codigo unico recebido por parametro.
     *
     * @param codigoUnico Codigo da sessao tematica a procurar.
     * @return Sessao Tematica correspondente ao codigo unico e null se não
     * encontrar nenhuma Sessao Tematica.
     */
    public SessaoTematica getSessaoTematicaComCodigoUnico(String codigoUnico) {
        for (SessaoTematica sessaoTematica : this.listaSessoesTematicas) {
            if (sessaoTematica.getCodigoUnico().equals(codigoUnico)) {
                return sessaoTematica;
            }
        }

        return null;
    }
}
