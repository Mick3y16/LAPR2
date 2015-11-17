package eventoscientificos.model;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import eventoscientificos.model.state.evento.EventoEmCameraReadyState;
import eventoscientificos.model.state.evento.EventoEmSubmissaoCameraReadyState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import utils.Data;

/**
 * Representa uma instancia de RegistoEventos que representa uma lista de
 * eventos da empresa.
 *
 * @author G01
 */
public class RegistoEventos {

    /**
     * Lista de Eventos da empresa.
     */
    private List<Evento> listaEventos;

    /**
     * Lista de eventos nos quais é possível gerar estatistica.
     */
    private List<Evento> listaEventosEstatistica;

    /**
     * Lista de submissões de todos os eventos.
     */
    private List<Submissao> listaSubmissao;

    /**
     * Processo de análise estatística.
     */
    private ProcessoAnaliseEstatistica processoAnaliseEstatistica;

    /**
     * Lista de todos os revisores dos eventos da empresa.
     */
    private List<Revisor> listaRevisores;

    private List<Revisao> listaRevisoes;

    /**
     * Constrói uma instância de RegistoEventos sem parametros.
     */
    public RegistoEventos() {
        this.listaEventos = new ArrayList<>();
    }

    /**
     * Constrói uma instância de evento recebendo um titulo, descricao, local,
     * data de inicio, data de fim, data de inicio de submissao, data limite de
     * submissao, data de inicio de distribuicao.
     *
     * @param titulo Titulo do evento.
     * @param descricao Descricao do evento.
     * @param local Local do evento.
     * @param dataInicioSubmissao Data de inicio de submissao do evento.
     * @param dataLimiteSubmissao Data limite de submissao do evento.
     * @param dataInicioDistribuicao Data de inicio de distribuicao do evento.
     * @param dataFimRevisao data final de revisao
     * @param dataFimSubmissaoCameraReady Data fim de submissao camera ready do
     * evento.
     * @param dataInicio Data de inicio do evento.
     * @param dataFim Data de fim do evento.
     *
     * @return Evento.
     */
    public Evento novoEvento(String titulo, String descricao, Local local,
                        Data dataInicioSubmissao, Data dataLimiteSubmissao,
                        Data dataInicioDistribuicao, Data dataFimRevisao,
                        Data dataFimSubmissaoCameraReady, Data dataInicio,
                        Data dataFim) {

        return new Evento(titulo, descricao, local, dataInicioSubmissao,
                            dataLimiteSubmissao, dataInicioDistribuicao, dataFimRevisao,
                            dataFimSubmissaoCameraReady, dataInicio, dataFim);
    }

    /**
     * Verifica se o evento passado por parametro ja consta na lista de eventos.
     *
     * @param evento instancia de evento a verificar.
     * @return true caso nao exista na lista e false caso ja exista.
     */
    public boolean validarEvento(Evento evento) {
        return !this.listaEventos.contains(evento);
    }

    /**
     * Devolve a lista de Revisores de todos os eventos agregados.
     *
     * @return lista de revisores.
     */
    public List<Revisor> getListaRevisores() {
        return listaRevisores;
    }

    /**
     * Devolve a lista de revisões de todos os eventos agregados.
     *
     * @return lista de revisoes.
     */
    public List<Revisao> getListaRevisoes() {
        return listaRevisoes;
    }

    /**
     * Devolve a lista de submissões de todos os eventos agregados.
     *
     * @return lista de submissoes.
     */
    public List<Submissao> getListaSubmissao() {
        return listaSubmissao;
    }

    /**
     * Adiciona o evento passado por parametro a lista de eventos caso este nao
     * exista na lista.
     *
     * @param evento instancia de evento a adicionar.
     * @return true caso seja adicionado e false se nao for adicionado.
     */
    public boolean adicionarEvento(Evento evento) {
        return this.listaEventos.add(evento);
    }

    /**
     * Devolve o número total de eventos na lista.
     *
     * @return Número total de eventos na lista.
     */
    public int getNumeroEventos() {
        return this.listaEventos.size();
    }

    /**
     * Devolve a lista de eventos que onde o revisor em análise pertence à CP
     *
     * @param revisor revisor a procurar
     * @param listaEventosApresentados lista de eventos apresentados
     * @return lista de eventos
     */
    public List<Evento> getListaEventosRevisor(Revisor revisor, List<Evento> listaEventosApresentados) {
        Utilizador u = revisor.getUtilizador();
        List<Evento> listaEventosRevisor = new ArrayList<>();
        for (Evento e : listaEventosApresentados) {
            if (e.getCP().contains(u)) {
                listaEventosRevisor.add(e);
            }
        }
        return listaEventosRevisor;
    }

    /**
     * Devolve a lista de eventos que onde é possível gerar a análise
     * estatística
     *
     * @return lista de eventos
     */
    public List<Evento> getListaEventosGerarAnaliseEstatistica() {
        this.listaEventosEstatistica = new ArrayList<>();
        List<Evento> listaEvento = new ArrayList<>();
        this.listaSubmissao = new ArrayList<>();
        for (Evento evento : this.listaEventos) {
            if (evento.isStateValidoParaGerarAnaliseEstatisticas()) {
                listaEvento.add(evento);
                for (Submissao s : evento.getListaSubmissoes().getListaSubmissoes()) {
                    if (!listaSubmissao.contains(s)) {
                        listaSubmissao.add(s);
                    }
                }
            }
        }
        return listaEvento;
    }

    /**
     * Devolve um evento através da sua posição na lista.
     *
     * @param indice Posição na lista.
     *
     * @return Evento através da sua posição na lista.
     */
    public Evento getEventoPeloID(int indice) {
        return this.listaEventos.get(indice);
    }

    /**
     * Devolve uma lista de eventos onde o utilizador é organizador, onde ainda
     * é possível criar Sessões Temáticas.
     *
     * @param utilizador Utilizador que se quer verificar se é organizador.
     * @return Lista de eventos onde o utilizador é organizador.
     */
    public List<Evento> getListaEventosOrganizador(Utilizador utilizador) {
        List<Evento> listaEventosOrganizador = new ArrayList();

        for (Evento evento : this.listaEventos) {
            if (evento.isOrganizador(utilizador)
                                && evento.isRegistadoOuSessoesTematicasDefinidas()) {
                listaEventosOrganizador.add(evento);
            }
        }

        return listaEventosOrganizador;
    }

    /**
     * Devolve uma lista de submissiveis nos quais ainda é possivel submeter
     * artigos
     *
     * @return Lista de Submisiveis que aceitam submisoes
     */
    public List<Submissivel> getListaSubmissiveisAceitarArtigo() {
        List<Submissivel> listaSubmissiveis = new ArrayList<>();

        for (Evento evento : this.listaEventos) {
            if (evento.isStateValidoParaSubmeter()) {
                listaSubmissiveis.add(evento);
            }
            listaSubmissiveis.addAll(
                                evento.getListaSubmissiveisAceitarArtigo());
        }
        return listaSubmissiveis;
    }

    /**
     * Devolve uma lista de submissiveis nas quais o utilizador é autor de
     * alguma submissao.
     *
     * @param utilizador utilizador
     * @return Lista de Submissiveis.
     */
    public List<Submissivel> getListaSubmissiveisAceitarArtigoComSubmissaoUtilizador(Utilizador utilizador) {
        List<Submissivel> listaSubmissiveisUtilizador = new ArrayList<>();

        for (Evento evento : this.listaEventos) {
            if (evento.isStateValidoParaAlterar()
                                && evento.isUtilizadorUmAutorSubmissao(utilizador)) {
                listaSubmissiveisUtilizador.add(evento);
            }
            listaSubmissiveisUtilizador.addAll(
                                evento.getListaSubmissiveisAceitarAlteracaoArtigoComSubmissaoUtilizador(utilizador));
        }

        return listaSubmissiveisUtilizador;
    }

    /**
     * Devolve uma lista de eventoes/sessões temáticas que se encontrem sem CP
     * definida e onde o utilizador é organizador/proponente.
     *
     * @param utilizador Utilizador a verificar se é organizador/proponente.
     * @return Lista de evento/sessao temática onde o utilizador é
     * organizador/proponente.
     */
    public List<CPDefinivel> getListaCPDefiniveisSemCPOrganizadorProponente(Utilizador utilizador) {
        List<CPDefinivel> listaSemCPDefinida = new ArrayList();

        for (Evento evento : this.listaEventos) {
            if (evento.isSessoesTematicasDefinidas()
                                && evento.isOrganizador(utilizador)) {
                listaSemCPDefinida.add(evento);
            }
            List<CPDefinivel> listaSessoesTematicas
                                = evento.getListaCPDefiniveisSemCPOrganizadorProponente(utilizador);
            listaSemCPDefinida.addAll(listaSessoesTematicas);
        }

        return listaSemCPDefinida;
    }

    /**
     * Devolve uma lista de eventos onde consta o utilizador no sistema como
     * revisor
     *
     * @param u utilizador no sistema
     * @return lista de eventos
     */
    public List<Licitavel> getListaLicitaveisComArtigosPorLicitarRevisor(Utilizador u) {
        List<Licitavel> listaLicitaveis = new ArrayList<>();
        for (Evento evento : listaEventos) {
            boolean validoParaLicitar = evento.isStateValidoParaLicitar(u);
            if (validoParaLicitar) {
                listaLicitaveis.add(evento);
            }
            List<SessaoTematica> listaST = evento.getListaSessoesTematicas().getListaSessoesTematicas();
            for (SessaoTematica st : listaST) {
                validoParaLicitar = st.isStateValidoParaLicitar(u);
                if (validoParaLicitar) {
                    listaLicitaveis.add(st);
                }
            }
        }
        return listaLicitaveis;
    }

    /**
     * Devolve uma lista de eventos onde consta o utilizador no sistema como
     * revisor
     *
     * @param u utilizador no sistema
     * @return lista de eventos
     */
    public List<Distribuivel> getListaDistribuiveisOrganizadorProponente(Utilizador u) {
        List<Distribuivel> listaDistribuiveis = new ArrayList<>();
        for (Evento evento : listaEventos) {
            boolean validoParaDistribuir = evento.isStateValidoParaDistribuir(u);
            if (validoParaDistribuir) {
                listaDistribuiveis.add(evento);
            }
            List<SessaoTematica> listaST = (evento.getListaSessoesTematicas()).getListaSessoesTematicas();
            for (SessaoTematica st : listaST) {
                validoParaDistribuir = st.isStateValidoParaDistribuir(u);
                if (validoParaDistribuir) {
                    listaDistribuiveis.add(st);
                }
            }
        }
        return listaDistribuiveis;
    }

    /**
     * Devolve uma lista de revisiveis onde o revisor tem submissoes a rever
     *
     * @param u utilizador
     * @return lista de revisiveis
     */
    public List<Revisivel> getListaRevisiveisComArtigosPReverRevisor(Utilizador u) {
        List<Revisivel> listaRevisiveis = new ArrayList<>();
        for (Evento evento : listaEventos) {
            boolean validoRever = evento.getEstado().setEmRevisao();
            if (evento.isStateValidoParaRever(u)) {
                listaRevisiveis.add(evento);
            }
            List<SessaoTematica> listaST = (evento.getListaSessoesTematicas()).getListaSessoesTematicas();
            for (SessaoTematica st : listaST) {
                validoRever = st.isStateValidoParaRever(u);
                if (validoRever) {
                    listaRevisiveis.add(st);
                }
            }
        }
        return listaRevisiveis;
    }

    /**
     * Compara dois objetos entre si. Comparando primariamente a posição de
     * memória, seguida do conteudo e das classes as quais cada um deles
     * pertence, e finalmente os seus atributos lista de eventos.
     *
     * @param outroObjeto Evento que vai ser usado na comparação.
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

        RegistoEventos outroRegisto = (RegistoEventos) outroObjeto;

        return this.listaEventos.equals(outroRegisto.listaEventos);
    }

    /**
     * Devolve uma lista de eventoes/sessões temáticas onde se encontrem
     * submissoes retiradas e onde o utilizador é organizador/proponente.
     *
     * @param utilizador Utilizador a verificar se é organizador/proponente.
     * @return Lista de evento/sessao temática onde o utilizador é
     * organizador/proponente.
     */
    public List<Submissivel> getListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente(Utilizador utilizador) {
        List<Submissivel> listaSubmissoesRetiradas = new ArrayList<>();

        for (Evento evento : this.listaEventos) {
            if (evento.isOrganizador(utilizador) && evento.temSubmissoesRetiradas(utilizador)) {
                listaSubmissoesRetiradas.add(evento);
            }
            List<Submissivel> listaSubmissoesRetiradasST = evento.getListaSubmissiveisComSubmissoesRetiradasOrganizadorProponente(utilizador);
            listaSubmissoesRetiradas.addAll(listaSubmissoesRetiradasST);
        }
        return listaSubmissoesRetiradas;
    }

    /**
     * Devolve uma lista de submissiveis nas quais o utilizador é autor de
     * alguma submissao.
     *
     * @param utilizador utilizador
     * @return lista de submissiveis
     */
    public List<Submissivel> getListaSubmissiveisAceitarArtigoFinal(
                        Utilizador utilizador) {

        List<Submissivel> listaSubmissiveis = new ArrayList<>();

        for (Evento evento : this.listaEventos) {
            if (evento.isStateValidoParaSubmeterArtigoFinal()
                                && evento.isUtilizadorUmAutorSubmissaoInicial(utilizador)) {
                listaSubmissiveis.add(evento);
            }
            listaSubmissiveis.addAll(
                                evento.getListaSubmissiveisAceitarArtigoFinal(utilizador));
        }
        return listaSubmissiveis;
    }

    /**
     * Devolve uma lista de submissiveis nas quais o utilizador é autor de
     * alguma submissao.
     *
     * @param utilizador utilizador
     * @return Lista de Submissiveis.
     */
    public List<Submissivel> getListaSubmissiveisAceitarAlteracaoArtigoComSubmissaoUtilizador(
                        Utilizador utilizador) {
        List<Submissivel> listaSubmissiveisUtilizador = new ArrayList<>();

        for (Evento evento : this.listaEventos) {
            if (evento.isStateValidoParaAlterar()
                                && evento.isUtilizadorUmAutorSubmissao(utilizador)) {
                listaSubmissiveisUtilizador.add(evento);
            }
            listaSubmissiveisUtilizador.addAll(
                                evento.getListaSubmissiveisAceitarAlteracaoArtigoComSubmissaoUtilizador(
                                                    utilizador));
        }

        return listaSubmissiveisUtilizador;
    }

    /**
     * Devolve a lista de submissiveis onde o utilizador em sistema tem artigos
     * e é possivel remover
     *
     * @param u utilizador autenticado no sistema
     * @return lista de submissiveis
     */
    public List<Submissivel> getListaSubmissiveisComArtigosUtilizadorParaRemover(Utilizador u) {
        List<Submissivel> listaSubmissiveisUtilizador = new ArrayList<>();
        for (Evento evento : this.listaEventos) {
            if (evento.isStateValidoParaRemover(u)) {
                listaSubmissiveisUtilizador.add(evento);
            }
            for (SessaoTematica st : evento.getListaSessoesTematicas().getListaSessoesTematicas()) {
                if (st.isStateValidoParaRemover(u)) {
                    listaSubmissiveisUtilizador.add(st);
                }
            }

        }
        return listaSubmissiveisUtilizador;
    }

    /**
     * Devolve uma lista com todos os eventos nos quais o utilizador autenticdo
     * é uma organizador e estão em submissãoCameraReady
     *
     * @param u utilizador
     * @return lista de eventos
     */
    public List<Evento> getListaEventosOrganizadorEmSubmissaoCameraReady(Utilizador u) {
        List<Evento> listaEventos = new ArrayList<>();
        for (Evento e : this.listaEventos) {
            if (e.isOrganizador(u) && e.isStateValidoParaSubmeterArtigoFinal()) {
                listaEventos.add(e);
            }
        }
        return listaEventos;
    }

    /**
     * Devolve uma lista de eventoes/sessões temáticas com todas as submissões
     * revistas e ainda não foi realizado o processo de decisão e onde o
     * utilizador é organizador/proponente.
     *
     * @param utilizador Utilizador a verificar se é organizador/proponente.
     * @return Lista de evento/sessao temática onde o utilizador é
     * organizador/proponente.
     */
    public List<Decidivel> getListaDecidiveisOrganizadorProponente(Utilizador utilizador) {
        List<Decidivel> listaDecidiveis = new ArrayList<>();
        for (Evento evento : this.listaEventos) {
            boolean submissoesAceites = false;
            int indice = 0;
            if (evento.isOrganizador(utilizador)
                                && evento.isEstadoValidoParaDecidir()) {
                do {
                    Submissao s = evento.getListaSubmissoes().getListaSubmissoes().get(indice);
                    if (s.isStateValidoParaDecidir()) {
                        listaDecidiveis.add(evento);
                        submissoesAceites = true;
                    }
                } while (submissoesAceites != true);
            }
            indice++;
            List< Decidivel> listaDecidiveisSessaoTematica
                                = evento.getListaSessoesTematicas().getListaDecidivelOrganizadorProponente(utilizador);
            listaDecidiveis.addAll(listaDecidiveisSessaoTematica);
        }
        return listaDecidiveis;
    }

    /**
     * Preenche os mapas com as palavras chaves e respetivas recomendações
     * globais.
     *
     * @param hashMapSubmissoesAceites Mapa de submissões aceites.
     * @param hashMapSubmissoesRejeitadas Mapa de submissões rejeitadas.
     */
    public void hashMapSubmissoes(
                        HashMap<String, Integer> hashMapSubmissoesAceites,
                        HashMap<String, Integer> hashMapSubmissoesRejeitadas) {
        for (Evento evento : this.listaEventos) {
            if (evento.getEstado() instanceof EventoEmSubmissaoCameraReadyState
                                || evento.getEstado() instanceof EventoEmCameraReadyState) {

                evento.hashMapSubmissoes(hashMapSubmissoesAceites,
                                    hashMapSubmissoesRejeitadas);
            }
        }
    }

    /**
     * Devolve uma lista de eventos que estão a aceitar submissões de artigos.
     *
     * @return Lista de eventos.
     */
    public List<Evento> getListaEventosAceitarArtigos() {
        List<Evento> listaEventos = new ArrayList<>();

        for (Evento evento : this.listaEventos) {
            if (evento.isStateValidoParaSubmeter()) {
                listaEventos.add(evento);
            }
        }

        return listaEventos;
    }

    /**
     * Devolve a lista de emails dos organizadores dos eventos ao qual o revisor
     * pertence
     *
     * @param listaEventos lista de eventos nos quais tem o revisor como membro
     * de CP
     * @return lista de emails dos organizadores
     */
    public List<String> notificarOrganizador(List<Evento> listaEventos) {
        List<String> listaEmail = new ArrayList<>();
        for (Evento evento : listaEventos) {
            for (String email : evento.notificarOrganizador()) {
                if (!listaEmail.contains(email)) {
                    listaEmail.add(email);
                }
            }
        }
        return listaEmail;
    }

    /**
     * Devolve uma matriz com os resultados dos revisores por submissão do
     * evento
     *
     * @param listaEventosApresentados lista de eventos apresentados
     * @return matriz dos resultados sob a forma textual
     */
    public String[] getValoresTotaisAnaliseEstatistica(List<Evento> listaEventosApresentados) {
        this.processoAnaliseEstatistica = new ProcessoAnaliseEstatistica(this.listaRevisoes, this.listaSubmissao, listaRevisores);
        return this.processoAnaliseEstatistica.getValoresEstatistica();

    }

    /**
     * Devolve uma lista de revisores existentes em todos os eventos que cumprem
     * as condições necessárias de aceitação.
     *
     * @param listaEventosApresentados lista de eventos selecionados
     * anteriormente
     * @return verdadeiro se as listas de listaRevisores e a listas submissões
     * estiverem preenchidas.
     *
     */
    public boolean getTodosRevisores(List<Evento> listaEventosApresentados) {
        this.listaRevisores = new ArrayList<>();
        this.listaRevisoes = new ArrayList<>();
        CP cp;
        for (Evento e : listaEventosApresentados) {
            if ((cp = e.getCP()) != null) {
                int numeroRevisores = e.getCP().getNumeroRevisores();
                for (int i = 0; i < numeroRevisores; i++) {
                    Revisor revisor = cp.getRevisorPeloID(i);
                    if (!listaRevisores.contains(revisor)) {
                        listaRevisores.add(revisor);
                    }

                }
            }
            listaRevisoes.addAll(e.getProcessoDistribuicao().getListaRevisoes().getListaRevisoes());
        }
        return this.listaRevisores.size() > 0 && this.listaSubmissao.size() > 0;
    }

}
