package utils;

import eventoscientificos.model.Artigo;
import eventoscientificos.model.Autor;
import eventoscientificos.model.AutorCorrespondente;
import eventoscientificos.model.CP;
import eventoscientificos.model.CPDefinivel;
import eventoscientificos.model.Decidivel;
import eventoscientificos.model.Decisao;
import eventoscientificos.model.Distribuivel;
import eventoscientificos.model.Empresa;
import eventoscientificos.model.Evento;
import eventoscientificos.model.InstituicaoAfiliacao;
import eventoscientificos.model.ListaAutores;
import eventoscientificos.model.ListaDecisoes;
import eventoscientificos.model.ListaRevisoes;
import eventoscientificos.model.ListaSessoesTematicas;
import eventoscientificos.model.ListaSubmissoes;
import eventoscientificos.model.Local;
import eventoscientificos.model.ProcessoDistribuicao;
import eventoscientificos.model.RegistoEventos;
import eventoscientificos.model.RegistoUtilizadores;
import eventoscientificos.model.Revisao;
import eventoscientificos.model.Revisor;
import eventoscientificos.model.SessaoTematica;
import eventoscientificos.model.Submissao;
import eventoscientificos.model.Submissivel;
import eventoscientificos.model.Utilizador;
import eventoscientificos.model.state.evento.EventoState;
import eventoscientificos.model.state.sessaotematica.SessaoTematicaState;
import eventoscientificos.model.state.submissao.SubmissaoState;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Representa uma instância de um parser de XML, responsável pela persistência
 * dos dados da aplicação, através de uma empresa e dos caminhos para ficheiros.
 *
 * @author G01
 */
public class XMLParser {

    /**
     * Frame principal.
     */
    private Frame framePai;

    /**
     * Empresa onde é guardada a informação.
     */
    private Empresa empresa;

    /**
     * Locais de todos os eventos, com o respetivo ID de cada um.
     */
    private HashMap<String, String> locais;

    /**
     * Caminho para os ficheiros .xml.
     */
//    private final String caminhoFicheiroUtilizador = "test_set1/TestSet01_Utilizador.xml";
//    private final String caminhoFicheiroEvento =  "test_set1/TestSet01_Evento.xml";
//    private final String caminhoFicheiroLocal = "test_set1/TestSet01_Local.xml";
    private final String caminhoFicheiroUtilizador = "test_set2/TestSet02_Utilizador.xml";
    private final String caminhoFicheiroEvento = "test_set2/TestSet02_Evento.xml";
    private final String caminhoFicheiroLocal = "test_set2/TestSet02_Local.xml";

    /**
     * Tags passíveis de serem encontradas no ficheiro .xml dos utilizadores.
     */
    private final String listaUtilizadoresTag = "ListaUtilizadores";
    private final String numeroElementosTag = "NumeroElementos";
    private final String utilizadoresTag = "Utilizadores";
    private final String utilizadorTag = "Utilizador";
    private final String usernameTag = "Username";
    private final String nomeTag = "Nome";
    private final String emailTag = "Email";
    private final String passwordTag = "Password";

    /**
     * Tags passíveis de serem encontradas no ficheiro .xml dos locais.
     */
    private final String listaLocaisTag = "ListaLocais";
    private final String numElementosTag = "NumElementos";
    private final String locaisTag = "Locais";
    private final String localTag = "Local";
    private final String localIDTag = "LocalID";
    private final String designacaoTag = "Designacao";

    /**
     * Tags passíveis de serem encontradas no ficheiro .xml dos eventos.
     */
    /**
     * Evento
     */
    private final String listaEventosTag = "ListaEventos";
    private final String numeroEventosTag = "NumeroEventos";
    private final String eventosTag = "Eventos";
    private final String eventoTag = "Evento";
    private final String tituloTag = "Titulo";
    private final String descricaoTag = "Descricao";
    private final String dataInicioTag = "DataInicio";
    private final String dataFimTag = "DataFim";
    private final String dataInicioSubmissaoTag = "DataInicioSubmissao";
    private final String dataFimSubmissaoTag = "DataFimSubmissao";
    private final String dataInicioDistribuicaoTag = "DataInicioDistribuicao";
    private final String dataLimiteRevisaoTag = "DataLimiteRevisao";
    private final String dataLimiteSubmissaoFinalTag = "DataLmiteSubmissaoFinal";
    private final String estadoEventoTag = "EstadoEvento";
    private final String listaOrganizadoresTag = "ListaOrganizadores";
    private final String numeroOrganizadoresTag = "NumeroOrganizadores";
    private final String organizadoresTag = "Organizadores";
    private final String organizadorTag = "Organizador";
    private final String cpTag = "CP";
    private final String numeroMembrosCPTag = "NumeroMembrosCP";
    private final String membrosCPTag = "MembrosCP";
    private final String membroCPTag = "MembroCP";

    /**
     * Sessão Temática
     */
    private final String listaSessoesTematicasTag = "ListaSessoesTematicas";
    private final String numeroSessoesTematicasTag = "NumeroSessoesTematicas";
    private final String sessoesTematicasTag = "SessoesTematicas";
    private final String sessaoTematicaTag = "SessaoTematica";
    private final String codigoSTTag = "CodigoST";
    private final String descricaoSTTag = "DescricaoST";
    private final String estadoSTTag = "EstadoST";
    private final String listaProponentesTag = "ListaProponentes";
    private final String numeroProponentesTag = "NumeroProponentes";
    private final String proponentesTag = "Proponentes";
    private final String proponenteTag = "Proponente";
    private final String CPSessaoTag = "CPSessao";
    private final String numeroMembrosCPSTTag = "NumeroMembrosCPST";
    private final String membrosCPSessaoTag = "MembrosCPSessao";
    private final String membroCPSessaoTag = "MembroCPSessao";

    /**
     * Lista de Submissões Evento/Sessão Temática
     */
    private final String listaSubmissoesEventoTag = "ListaSubmissoesEvento";
    private final String listaSubmissoesTag = "ListaSubmissoes";
    private final String numeroSubmissoesTag = "NumeroSubmissoes";
    private final String submissoesTag = "Submissoes";
    private final String submissaoTag = "Submissao";
    private final String estadoSubmissaoTag = "EstadoSubmissao";

    /**
     * Artigo
     */
    private final String artigoTag = "Artigo";
    private final String artigoInicialAttr = "INICIAL";
    private final String artigoFinalAttr = "FINAL";
    private final String autorCorrespondenteTag = "AutorCorrespondente";
    private final String autorSubmissorTag = "AutorSubmissao";
    private final String dataSubmissaoTag = "DataSubmissao";
    private final String tituloArtigoTag = "TituloArtigo";
    private final String resumoTag = "Resumo";
    private final String listaAutoresTag = "ListaAutores";
    private final String numeroAutoresTag = "NumeroAutores";
    private final String autoresTag = "Autores";
    private final String autorTag = "Autor";
    private final String nomeAutorTag = "NomeAutor";
    private final String emailAutorTag = "EmailAutor";
    private final String filiacaoAutorTag = "Filiacao";
    private final String usernameAutorTag = "UsernameAutor";
    private final String palavrasChaveTag = "PalavrasChave";
    private final String ficheiroTag = "Ficheiro";

    /**
     * Lista Revisões.
     */
    private final String listaRevisoesTag = "ListaRevisoes";
    private final String numeroRevisoesTag = "NumeroRevisoes";
    private final String revisoesTag = "Revisoes";
    private final String revisaoTag = "Revisao";
    private final String revisorTag = "Revisor";
    private final String estadoRevisaoTag = "EstadoRevisao";
    private final String confiancaTag = "Confianca";
    private final String adequacaoTag = "Adequacao";
    private final String originalidadeTag = "Originalidade";
    private final String apresentacaoTag = "Apresentacao";
    private final String recomendacaoTag = "Recomendacao";
    private final String justificacaoTag = "Justificacao";

    /**
     * Decisao
     */
    private final String decisaoTag = "Decisao";

    /**
     * Representa uma instância de um parser de XML, recebendo uma empresa.
     *
     * @param parent Frame para a qual são reportados erros.
     * @param empresa Empresa onde é guardada a informação.
     */
    public XMLParser(java.awt.Frame parent, Empresa empresa) {
        this.framePai = parent;
        this.empresa = empresa;
    }

    /**
     * Lê o ficheiro XML que contém os dados dos utilizadores da aplicação.
     *
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws java.io.IOException
     * @throws org.xml.sax.SAXException
     */
    public void lerFicheiroUtilizador() throws ParserConfigurationException,
            IOException, SAXException {
        RegistoUtilizadores registoUtilizadores
                = this.empresa.getRegistoUtilizadores();

        Document doc = lerFicheiro(caminhoFicheiroUtilizador);

        if (Integer.parseInt(doc.getElementsByTagName(
                numeroElementosTag).item(0).getTextContent()) > 0) {
            NodeList utilizadoresNodeList
                    = doc.getElementsByTagName(utilizadorTag);

            for (int i = 0; i < utilizadoresNodeList.getLength(); i++) {
                Node utilizadorNode = utilizadoresNodeList.item(i);

                if (utilizadorNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element utilizadorElement = (Element) utilizadorNode;

                    int separador = utilizadorElement.getElementsByTagName(
                            passwordTag).item(0).getTextContent().lastIndexOf(";");
                    registoUtilizadores.adicionaUtilizador(registoUtilizadores.novoUtilizador(
                            utilizadorElement.getElementsByTagName(
                                    nomeTag).item(0).getTextContent(),
                            utilizadorElement.getElementsByTagName(
                                    emailTag).item(0).getTextContent(),
                            utilizadorElement.getElementsByTagName(
                                    usernameTag).item(0).getTextContent(),
                            utilizadorElement.getElementsByTagName(
                                    passwordTag).item(0).getTextContent()
                            .substring(separador + 1),
                            utilizadorElement.getElementsByTagName(
                                    passwordTag).item(0).getTextContent()
                            .substring(0, separador)));
                }
            }
        }
    }

    /**
     * Lê o ficheiro .xml que contém os dados sobre os locais da aplicação.
     *
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws java.io.IOException
     * @throws org.xml.sax.SAXException
     */
    public void lerFicheiroLocal() throws ParserConfigurationException,
            IOException, SAXException {
        this.locais = new HashMap();

        Document doc = lerFicheiro(caminhoFicheiroLocal);

        if (Integer.parseInt(doc.getElementsByTagName(
                numElementosTag).item(0).getTextContent()) > 0) {
            NodeList nodeList = doc.getElementsByTagName(localTag);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    this.locais.put(
                            element.getElementsByTagName(
                                    localIDTag).item(0).getTextContent(),
                            element.getElementsByTagName(
                                    designacaoTag).item(0).getTextContent());
                }
            }
        }
    }

    /**
     * Lê o ficheiro XML que contém os dados dos eventos da aplicação.
     *
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws java.io.IOException
     * @throws org.xml.sax.SAXException
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.NoSuchMethodException
     * @throws java.lang.reflect.InvocationTargetException
     */
    public void lerFicheiroEvento() throws ParserConfigurationException,
            IOException, SAXException, ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            NoSuchMethodException, IllegalArgumentException,
            InvocationTargetException {
        RegistoEventos registoEventos = this.empresa.getRegistoEventos();
        RegistoUtilizadores registoUtilizadores = this.empresa.getRegistoUtilizadores();

        Document docEvento = lerFicheiro(caminhoFicheiroEvento);

        if (Integer.parseInt(docEvento.getElementsByTagName(
                numeroEventosTag).item(0).getTextContent()) > 0) {
            NodeList eventosNodeList = docEvento.getElementsByTagName(eventoTag);

            for (int i = 0; i < eventosNodeList.getLength(); i++) {
                Node eventoNode = eventosNodeList.item(i);

                if (eventoNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eventoElement = (Element) eventoNode;

                    Evento evento = registoEventos.novoEvento(
                            eventoElement.getElementsByTagName(
                                    tituloTag).item(0).getTextContent(),
                            eventoElement.getElementsByTagName(
                                    descricaoTag).item(0).getTextContent(),
                            new Local(this.locais.get(eventoElement.getElementsByTagName(
                                    localTag).item(0).getTextContent())),
                            Data.converterString(eventoElement.getElementsByTagName(
                                    dataInicioSubmissaoTag).item(0).getTextContent()),
                            Data.converterString(eventoElement.getElementsByTagName(
                                    dataFimSubmissaoTag).item(0).getTextContent()),
                            Data.converterString(eventoElement.getElementsByTagName(
                                    dataInicioDistribuicaoTag).item(0).getTextContent()),
                            Data.converterString(eventoElement.getElementsByTagName(
                                    dataLimiteRevisaoTag).item(0).getTextContent()),
                            Data.converterString(eventoElement.getElementsByTagName(
                                    dataLimiteSubmissaoFinalTag).item(0).getTextContent()),
                            Data.converterString(eventoElement.getElementsByTagName(
                                    dataInicioTag).item(0).getTextContent()),
                            Data.converterString(eventoElement.getElementsByTagName(
                                    dataFimTag).item(0).getTextContent()));
                    String estadoEvento = eventoElement.getElementsByTagName(
                            estadoEventoTag).item(0).getTextContent();
                    atribuirEstadoAEvento(evento, estadoEvento);

                    if (Integer.parseInt(eventoElement.getElementsByTagName(
                            numeroOrganizadoresTag).item(0).getTextContent()) > 0) {
                        lerOrganizadores(eventoElement, registoUtilizadores, evento);
                    }

                    if (Integer.parseInt(eventoElement.getElementsByTagName(
                            numeroMembrosCPTag).item(0).getTextContent()) > 0) {
                        lerRevisores(eventoElement, registoUtilizadores, evento, membroCPTag);
                    }

                    if (Integer.parseInt(eventoElement.getElementsByTagName(
                            numeroSessoesTematicasTag).item(0).getTextContent()) > 0) {
                        NodeList sessoesTematicasNodeList
                                = eventoElement.getElementsByTagName(sessaoTematicaTag);
                        ListaSessoesTematicas listaSessoesTematicas
                                = evento.getListaSessoesTematicas();

                        for (int j = 0; j < sessoesTematicasNodeList.getLength(); j++) {
                            Node sessaoTematicaNode = sessoesTematicasNodeList.item(j);
                            lerSessaoTematica(sessaoTematicaNode,
                                    listaSessoesTematicas, registoUtilizadores);
                        }
                    }

                    Element listaSubmissoesEventoNode
                            = (Element) eventoElement.getElementsByTagName(
                                    listaSubmissoesEventoTag).item(0);
                    
                    if (Integer.parseInt(listaSubmissoesEventoNode.getElementsByTagName(
                            numeroSubmissoesTag).item(0).getTextContent()) > 0) {
                        lerSubmissoes(eventoElement, evento, registoUtilizadores);
                    }

                    registoEventos.adicionarEvento(evento);

                }
            }
        }
    }

    /**
     * Lê a lista de organizadores do evento.
     *
     * @param eventoElement Elemento que contém os dados da lista de
     * organizadores.
     * @param registoUtilizadores Registo de utilizadores.
     * @param evento Evento que guarda os dados.
     */
    private void lerOrganizadores(Element eventoElement,
            RegistoUtilizadores registoUtilizadores, Evento evento) {
        NodeList OrganizadoresNodeList
                = eventoElement.getElementsByTagName(organizadorTag);

        for (int j = 0; j < OrganizadoresNodeList.getLength(); j++) {
            Node organizadorNode = OrganizadoresNodeList.item(j);

            if (organizadorNode.getNodeType() == Node.ELEMENT_NODE) {
                Element organizadorElement = (Element) organizadorNode;

                Utilizador utilizador = registoUtilizadores.getUtilizador(
                        organizadorElement.getTextContent());

                if (utilizador != null) {
                    evento.novoOrganizador(utilizador);
                }
            }
        }
    }

    /**
     * Lê a lista de revisões de um CPDEefinivel.
     *
     * @param cpDefinivelElement Elemento que contém a informção da CP.
     * @param registoUtilizadores Registo de utilizadores.
     * @param cpDefinivel CPDefinivel que guarda a informação
     * @param membroCP Tag pela qual é feita a extração.
     */
    private void lerRevisores(Element cpDefinivelElement,
            RegistoUtilizadores registoUtilizadores, CPDefinivel cpDefinivel,
            String membroCP) {
        NodeList membrosCPNodeList
                = cpDefinivelElement.getElementsByTagName(membroCP);
        CP cp = cpDefinivel.novaCP();

        for (int i = 0; i < membrosCPNodeList.getLength(); i++) {
            Node membroCPNode = membrosCPNodeList.item(i);

            if (membroCPNode.getNodeType() == Node.ELEMENT_NODE) {
                Element membroCPElement = (Element) membroCPNode;

                Utilizador utilizador
                        = registoUtilizadores.getUtilizador(
                                membroCPElement.getTextContent());

                if (utilizador != null) {
                    cp.novoRevisor(utilizador);
                }
            }
        }

        cpDefinivel.setCP(cp);
    }

    /**
     * Lê uma sessão temática.
     *
     * @param sessaoTematicaNode Node que contem uma sessão temática.
     * @param listaSessoesTematicas Lista de sessões temáticas.
     * @param registoUtilizadores Registo de utilizadores.
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    private void lerSessaoTematica(Node sessaoTematicaNode,
            ListaSessoesTematicas listaSessoesTematicas,
            RegistoUtilizadores registoUtilizadores)
            throws ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        if (sessaoTematicaNode.getNodeType() == Node.ELEMENT_NODE) {
            Element sessaoTematicaElement = (Element) sessaoTematicaNode;

            SessaoTematica sessaoTematica = listaSessoesTematicas.novaSessaoTematica(
                    sessaoTematicaElement.getElementsByTagName(
                            codigoSTTag).item(0).getTextContent(),
                    sessaoTematicaElement.getElementsByTagName(
                            descricaoSTTag).item(0).getTextContent(),
                    Data.converterString(sessaoTematicaElement.getElementsByTagName(
                                    dataInicioSubmissaoTag).item(0).getTextContent()),
                    Data.converterString(sessaoTematicaElement.getElementsByTagName(
                                    dataFimSubmissaoTag).item(0).getTextContent()),
                    Data.converterString(sessaoTematicaElement.getElementsByTagName(
                                    dataInicioDistribuicaoTag).item(0).getTextContent()),
                    Data.converterString(sessaoTematicaElement.getElementsByTagName(
                                    dataLimiteRevisaoTag).item(0).getTextContent()),
                    Data.converterString(sessaoTematicaElement.getElementsByTagName(
                                    dataLimiteSubmissaoFinalTag).item(0).getTextContent()),
                    Data.converterString(sessaoTematicaElement.getElementsByTagName(
                                    dataInicioTag).item(0).getTextContent()),
                    Data.converterString(sessaoTematicaElement.getElementsByTagName(
                                    dataFimTag).item(0).getTextContent()));
            String estadoSessaoTematica = sessaoTematicaElement.getElementsByTagName(
                    estadoSTTag).item(0).getTextContent();
            atribuirEstadoASessaoTematica(sessaoTematica, estadoSessaoTematica);

            if (Integer.parseInt(sessaoTematicaElement.getElementsByTagName(
                    numeroProponentesTag).item(0).getTextContent()) > 0) {
                lerProponentes(sessaoTematicaElement, registoUtilizadores, sessaoTematica);
            }

            listaSessoesTematicas.adicionarSessaoTematica(sessaoTematica);

            if (Integer.parseInt(sessaoTematicaElement.getElementsByTagName(
                    numeroMembrosCPSTTag).item(0).getTextContent()) > 0) {
                lerRevisores(sessaoTematicaElement, registoUtilizadores, sessaoTematica, membroCPSessaoTag);
            }

            if (Integer.parseInt(sessaoTematicaElement.getElementsByTagName(
                    numeroSubmissoesTag).item(0).getTextContent()) > 0) {
                lerSubmissoes(sessaoTematicaElement, sessaoTematica, registoUtilizadores);
            }
        }
    }

    /**
     * Lê a lista de proponentes de uma sessão temática.
     *
     * @param sessaoTematicaElement Elemento que contém os dados da sessão
     * temática.
     * @param registoUtilizadores Registo de utilizadores.
     * @param sessaoTematica Sessão temática que contém a lista de proponentes.
     */
    private void lerProponentes(Element sessaoTematicaElement,
            RegistoUtilizadores registoUtilizadores, SessaoTematica sessaoTematica) {
        NodeList proponenteNodeList
                = sessaoTematicaElement.getElementsByTagName(proponenteTag);

        for (int k = 0; k < proponenteNodeList.getLength(); k++) {
            Node proponenteNode = proponenteNodeList.item(k);

            if (proponenteNode.getNodeType() == Node.ELEMENT_NODE) {
                Element proponenteElement = (Element) proponenteNode;

                Utilizador utilizador = registoUtilizadores.getUtilizador(
                        proponenteElement.getTextContent());

                if (utilizador != null) {
                    sessaoTematica.novoProponente(utilizador);
                }
            }
        }
    }

    /**
     * Lê uma lista de submissões de um submissível.
     *
     * @param submissivelElement Elemento que contem a lista de submissoes.
     * @param submissivel Submissivel onde e guardada a lista.
     * @param registoUtilizadores Registo Utilizadores.
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    private void lerSubmissoes(Element submissivelElement,
            Submissivel submissivel, RegistoUtilizadores registoUtilizadores)
            throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, InstantiationException {
        NodeList submissoesNodeList = submissivelElement.getElementsByTagName(submissaoTag);
        ListaSubmissoes listaSubmissoes = submissivel.getListaSubmissoes();

        for (int k = 0; k < submissoesNodeList.getLength(); k++) {
            Node submissaoNode = submissoesNodeList.item(k);

            Submissao submissao = listaSubmissoes.novaSubmissao();
            lerSubmissao(submissaoNode, submissivel, submissao,
                    registoUtilizadores);
            listaSubmissoes.adicionarSubmissao(submissao);
        }
    }

    /**
     * Lê uma submissão de um submissivel.
     *
     * @param submissaoNode Node que contém a informação da submissão.
     * @param submissivel Evento ou sessao temática.
     * @param listaSubmissoes Lista de submissões.
     * @param registoUtilizadores Registo de utilizadores.
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    private void lerSubmissao(Node submissaoNode, Submissivel submissivel,
            Submissao submissao, RegistoUtilizadores registoUtilizadores)
            throws ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        if (submissaoNode.getNodeType() == Node.ELEMENT_NODE) {
            Element submissaoElement = (Element) submissaoNode;

            String estadoSubmissao = submissaoElement.getElementsByTagName(
                    estadoSubmissaoTag).item(0).getTextContent();
            atribuirEstadoASubmissao(submissao, estadoSubmissao);

            NodeList artigoNodeList
                    = submissaoElement.getElementsByTagName(artigoTag);

            for (int l = 0; l < artigoNodeList.getLength(); l++) {
                Node artigoNode = artigoNodeList.item(l);
                lerArtigo(artigoNode, submissao, registoUtilizadores);
            }

            if (Integer.parseInt(submissaoElement.getElementsByTagName(
                    numeroRevisoesTag).item(0).getTextContent()) > 0) {
                lerRevisoes(submissaoElement, (Distribuivel) submissivel,
                        submissao, registoUtilizadores);
            }
        }
    }

    /**
     * Lê uma revisão de um artigo.
     *
     * @param artigoNode Node que contem a informação do artigo.
     * @param submissao Submissão que irá guardar os dados.
     * @param registoUtilizadores Registo de utilizadores.
     */
    private void lerArtigo(Node artigoNode, Submissao submissao,
            RegistoUtilizadores registoUtilizadores) {
        Artigo artigo = submissao.novoArtigo();

        if (artigoNode.getNodeType() == Node.ELEMENT_NODE) {
            Element artigoElement = (Element) artigoNode;

            artigo.setTitulo(artigoElement.getElementsByTagName(
                    tituloArtigoTag).item(0).getTextContent());
            artigo.setResumo(artigoElement.getElementsByTagName(
                    resumoTag).item(0).getTextContent());

            lerListaAutores(artigoElement, artigo, registoUtilizadores);

            String[] palavrasChave = artigoElement.getElementsByTagName(
                    palavrasChaveTag).item(0).getTextContent().split("/");
            List<String> listaPalavrasChave = new ArrayList();

            for (int m = 0; m < palavrasChave.length; m++) {
                listaPalavrasChave.add(palavrasChave[m]);
            }

            artigo.setPalavrasChave(listaPalavrasChave);
            artigo.setFicheiro(artigoElement.getElementsByTagName(
                    ficheiroTag).item(0).getTextContent());

            artigo.setDataSubmissao(Data.converterString(
                    artigoElement.getElementsByTagName(
                            dataSubmissaoTag).item(0).getTextContent()));

            String tipo = artigoElement.getAttribute("tipo");

            if (tipo.equals(artigoInicialAttr)) {
                submissao.setArtigoInicial(artigo);
            } else if (tipo.equals(artigoFinalAttr)) {
                submissao.setArtigoFinal(artigo);
            }
        }
    }

    /**
     * Lê a lista de autores contida num artigo.
     *
     * @param artigoElement Elemento que contém os dados do artigo.
     * @param artigo Artigo que irá guardar os dados.
     * @param registoUtilizadores Registo de utilizadores.
     */
    private void lerListaAutores(Element artigoElement,
            Artigo artigo, RegistoUtilizadores registoUtilizadores) {
        NodeList autoresNodeList = artigoElement.getElementsByTagName(autorTag);
        ListaAutores listaAutores = artigo.getListaAutores();

        for (int m = 0; m < autoresNodeList.getLength(); m++) {
            Node autorNode = autoresNodeList.item(m);

            if (autorNode.getNodeType() == Node.ELEMENT_NODE) {
                Element autorElement = (Element) autorNode;

                Utilizador utilizador = registoUtilizadores.getUtilizador(
                        autorElement.getElementsByTagName(
                                emailAutorTag).item(0).getTextContent());

                if (utilizador == null) {
                    listaAutores.novoAutor(
                            autorElement.getElementsByTagName(
                                    nomeAutorTag).item(0).getTextContent(),
                            autorElement.getElementsByTagName(
                                    emailAutorTag).item(0).getTextContent(),
                            new InstituicaoAfiliacao(
                                    autorElement.getElementsByTagName(
                                            filiacaoAutorTag).item(0).getTextContent()));
                } else {
                    listaAutores.novoAutor(utilizador,
                            new InstituicaoAfiliacao(
                                    autorElement.getElementsByTagName(
                                            filiacaoAutorTag).item(0).getTextContent()));
                }
            }
        }

        List<Autor> listaAutoresRegistados = listaAutores.getListaAutoresRegistados();

        Utilizador utilizadorAutorCorrespondente
                = registoUtilizadores.getUtilizador(
                        artigoElement.getElementsByTagName(
                                autorCorrespondenteTag).item(0).getTextContent());
        int indice = listaAutoresRegistados.indexOf(new Autor(
                utilizadorAutorCorrespondente,
                new InstituicaoAfiliacao("Dummy")));
        artigo.setAutorCorrespondente(
                new AutorCorrespondente(utilizadorAutorCorrespondente,
                        listaAutoresRegistados.get(
                                indice).getInstituicaoAfiliacao()));

        String th = artigoElement.getElementsByTagName(
                autorSubmissorTag).item(0).getTextContent();
        Utilizador utilizadorAutorSubmissor
                = registoUtilizadores.getUtilizador(th);

        indice = listaAutoresRegistados.indexOf(new Autor(
                utilizadorAutorSubmissor, new InstituicaoAfiliacao("Dummy")));
        Autor autor = listaAutoresRegistados.get(indice);
        artigo.setAutorSubmissor(autor);
    }

    /**
     * Lê a lista de revisões de uma submissão.
     *
     * @param submissaoElement Elemento que contém todas as revisões.
     * @param distribuivel Distribuivel que conhece a lista de revissões.
     * @param submissao Submissão que guarda as revisões.
     * @param registoUtilizadores Registo de utilizadores.
     */
    private void lerRevisoes(Element submissaoElement, Distribuivel distribuivel,
            Submissao submissao, RegistoUtilizadores registoUtilizadores) {
        if (distribuivel.getProcessoDistribuicao() == null) {
            distribuivel.adicionarProcessoDistribuicao(
                    new ProcessoDistribuicao());
        }

        NodeList revisoesNodeList
                = submissaoElement.getElementsByTagName(revisaoTag);

        ListaRevisoes listaRevisoes
                = distribuivel.getProcessoDistribuicao().getListaRevisoes();

        for (int i = 0; i < revisoesNodeList.getLength(); i++) {
            Node revisaoNode = revisoesNodeList.item(i);
            lerRevisao(revisaoNode, submissao, listaRevisoes, registoUtilizadores);
        }
    }

    /**
     * Lê uma revisão de um artigo.
     *
     * @param revisaoNode Node que contém a informação da revisão.
     * @param submissao Submissão à qual a revisão pertence.
     * @param listaRevisoes Lista de revissões que guarda a revisão.
     * @param registoUtilizadores Registo de utilizadores.
     */
    private void lerRevisao(Node revisaoNode, Submissao submissao,
            ListaRevisoes listaRevisoes, RegistoUtilizadores registoUtilizadores) {
        if (revisaoNode.getNodeType() == Node.ELEMENT_NODE) {
            Element revisaoElement = (Element) revisaoNode;

            Utilizador utilizador = registoUtilizadores.getUtilizador(
                    revisaoElement.getElementsByTagName(
                            revisorTag).item(0).getTextContent());

            if (utilizador != null) {
                Revisor revisor = new Revisor(utilizador);
                Revisao revisao = listaRevisoes.novaRevisao(submissao, revisor);

                int adequacao = Integer.parseInt(revisaoElement.getElementsByTagName(
                        adequacaoTag).item(0).getTextContent());
                revisao.setAdequacaoArtigo(adequacao);
                int confianca = Integer.parseInt(revisaoElement.getElementsByTagName(
                        confiancaTag).item(0).getTextContent());
                revisao.setConfiancaRevisor(confianca);
                int originalidade = Integer.parseInt(revisaoElement.getElementsByTagName(
                        originalidadeTag).item(0).getTextContent());
                revisao.setOriginalidadeArtigo(originalidade);
                int apresentacao = Integer.parseInt(revisaoElement.getElementsByTagName(
                        apresentacaoTag).item(0).getTextContent());
                revisao.setQualidadeArtigo(apresentacao);
                int recomendacao = Integer.parseInt(revisaoElement.getElementsByTagName(
                        recomendacaoTag).item(0).getTextContent());
                revisao.setRecomendacaoGlobal(recomendacao);
                String justificacao = revisaoElement.getElementsByTagName(
                        justificacaoTag).item(0).getTextContent();
                revisao.setTextoJustificativo(justificacao);

                listaRevisoes.adicionarRevisao(revisao);
            }
        }
    }

    /**
     * Altera o estado do evento para o listado no ficheiro.
     *
     * @param evento Evento cujo estado vai ser alterado.
     * @param estadoEvento Estado do evento.
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    private void atribuirEstadoAEvento(Evento evento, String estadoEvento)
            throws ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        Constructor construtor = Class.forName(
                "eventoscientificos.model.state.evento."
                + estadoEvento).getConstructor(Evento.class);

        evento.setEstado((EventoState) construtor.newInstance(evento));
    }

    /**
     * Altera o estado da sessão temática para o listado no ficheiro.
     *
     * @param sessaoTematica Sessão temática cujo estado vai ser alterado.
     * @param estadoSessaoTematica Estado da sessão temática.
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    private void atribuirEstadoASessaoTematica(SessaoTematica sessaoTematica,
            String estadoSessaoTematica)
            throws ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        Constructor construtor = Class.forName(
                "eventoscientificos.model.state.sessaotematica."
                + estadoSessaoTematica).getConstructor(SessaoTematica.class);

        sessaoTematica.setEstado(
                (SessaoTematicaState) construtor.newInstance(sessaoTematica));
    }

    /**
     * Altera o estado da submissão para o listado no ficheiro.
     *
     * @param submissao Submissão cujo estado vai ser alterado.
     * @param estadoSubmissao Estado da submissão.
     *
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    private void atribuirEstadoASubmissao(
            Submissao submissao, String estadoSubmissao)
            throws ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        Constructor constructor = Class.forName(
                "eventoscientificos.model.state.submissao."
                + estadoSubmissao).getConstructor(Submissao.class);

        submissao.setEstado(
                (SubmissaoState) constructor.newInstance(submissao));
    }

    /**
     * Cria uma árvore com toda a informação sobre os utilizadores e guarda tudo
     * num ficheiro em formato XML.
     *
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws javax.xml.transform.TransformerException
     */
    public void escreverFicheiroUtilizador()
            throws ParserConfigurationException, TransformerException {
        RegistoUtilizadores registoUtilizadores = this.empresa.getRegistoUtilizadores();

        DocumentBuilderFactory docBuilderF = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderF.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        Element listaUtilizadoresElement = doc.createElement(listaUtilizadoresTag);
        doc.appendChild(listaUtilizadoresElement);

        listaUtilizadoresElement.appendChild(doc.createElement(
                numeroElementosTag)).setTextContent(
                        String.valueOf(registoUtilizadores.getNumeroUtilizadores()));

        Element utilizadoresElement = doc.createElement(utilizadoresTag);
        listaUtilizadoresElement.appendChild(utilizadoresElement);

        for (int i = 0; i < registoUtilizadores.getNumeroUtilizadores(); i++) {
            Element utilizadorElement = doc.createElement(utilizadorTag);
            utilizadoresElement.appendChild(utilizadorElement);

            Utilizador utilizador = registoUtilizadores.getUtilizadorPeloID(i);

            utilizadorElement.appendChild(doc.createElement(
                    usernameTag)).setTextContent(utilizador.getUsername());
            utilizadorElement.appendChild(doc.createElement(
                    nomeTag)).setTextContent(utilizador.getNome());
            utilizadorElement.appendChild(doc.createElement(
                    emailTag)).setTextContent(utilizador.getEmail());
            utilizadorElement.appendChild(doc.createElement(
                    passwordTag)).setTextContent(String.join(";",
                                    utilizador.getCodificadorTabela(),
                                    utilizador.getPassword()));
        }

        escreverFicheiro(doc, caminhoFicheiroUtilizador);
    }

    /**
     * Cria uma árvore com toda a informação sobre os locais e guarda tudo num
     * ficheiro em formato XML.
     *
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws javax.xml.transform.TransformerException
     */
    public void escreverFicheiroLocal()
            throws ParserConfigurationException, TransformerException {
        RegistoEventos registoEventos = this.empresa.getRegistoEventos();

        DocumentBuilderFactory docBuilderF = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderF.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        Element listaLocaisElement = doc.createElement(listaLocaisTag);
        doc.appendChild(listaLocaisElement);

        listaLocaisElement.appendChild(doc.createElement(
                numElementosTag)).setTextContent(
                        String.valueOf(registoEventos.getNumeroEventos()));

        Element locaisElement = doc.createElement(locaisTag);
        listaLocaisElement.appendChild(locaisElement);

        for (int i = 0; i < registoEventos.getNumeroEventos(); i++) {
            Element localElement = doc.createElement(localTag);
            locaisElement.appendChild(localElement);

            Evento e = registoEventos.getEventoPeloID(i);

            localElement.appendChild(doc.createElement(
                    localIDTag)).setTextContent(String.valueOf(i + 1));
            localElement.appendChild(doc.createElement(
                    designacaoTag)).setTextContent(e.getLocal().toString());
        }

        escreverFicheiro(doc, caminhoFicheiroLocal);
    }

    /**
     * Cria uma árvore com toda a informação sobre os eventos e guarda tudo num
     * ficheiro em formato XML.
     *
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws javax.xml.transform.TransformerException
     */
    public void escreverFicheiroEvento()
            throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory docBuilderF = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderF.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        doc.appendChild(escreverRegistoEventos(doc,
                doc.createElement(listaEventosTag), this.empresa.getRegistoEventos()));

        escreverFicheiro(doc, caminhoFicheiroEvento);
    }

    /**
     * Constrói uma arvore que guarda o registo de eventos.
     *
     * @param doc Documento XML.
     * @param registoEventosElement Elemento que guarda o registo de eventos.
     * @param registoEventos Registo de eventos de onde é extraida a informação.
     *
     * @return Elemento preenchido.
     */
    private Element escreverRegistoEventos(Document doc,
            Element registoEventosElement, RegistoEventos registoEventos) {
        registoEventosElement.appendChild(doc.createElement(
                numeroEventosTag)).setTextContent(
                        String.valueOf(registoEventos.getNumeroEventos()));
        Element eventos = doc.createElement(eventosTag);
        registoEventosElement.appendChild(eventos);

        for (int i = 0; i < registoEventos.getNumeroEventos(); i++) {
            eventos.appendChild(escreverEvento(
                    doc, doc.createElement(eventoTag),
                    registoEventos.getEventoPeloID(i), i));
        }

        return registoEventosElement;
    }

    /**
     * Constrói uma árvore que guarda a informação de um evento.
     *
     * @param doc Documento XML.
     * @param eventoElement Elemento que guarda o evento.
     * @param evento Evento de onde é extraida a informação.
     * @param i Número do local.
     *
     * @return Elemento preenchido.
     */
    private Element escreverEvento(Document doc,
            Element eventoElement, Evento evento, int i) {
        eventoElement.appendChild(doc.createElement(
                tituloTag)).setTextContent(
                        evento.getTitulo());
        eventoElement.appendChild(doc.createElement(
                descricaoTag)).setTextContent(
                        evento.getDescricao());
        eventoElement.appendChild(doc.createElement(
                dataInicioTag)).setTextContent(
                        evento.getDataInicio().toString());
        eventoElement.appendChild(doc.createElement(
                dataFimTag)).setTextContent(
                        evento.getDataFim().toString());
        eventoElement.appendChild(doc.createElement(
                dataInicioSubmissaoTag)).setTextContent(
                        evento.getDataInicioSubmissao().toString());
        eventoElement.appendChild(doc.createElement(
                dataFimSubmissaoTag)).setTextContent(
                        evento.getDataFimSubmissao().toString());
        eventoElement.appendChild(doc.createElement(
                dataInicioDistribuicaoTag)).setTextContent(
                        evento.getDataInicioDistribuicao().toString());
        eventoElement.appendChild(doc.createElement(
                dataLimiteRevisaoTag)).setTextContent(
                        evento.getDataFimRevisao().toString());
        eventoElement.appendChild(doc.createElement(
                dataLimiteSubmissaoFinalTag)).setTextContent(
                        evento.getDataFimSubmissaoCameraReady().toString());
        eventoElement.appendChild(doc.createElement(
                estadoEventoTag)).setTextContent(
                        evento.getEstado().getClass().getSimpleName());
        eventoElement.appendChild(doc.createElement(
                localTag)).setTextContent(
                        String.valueOf(i + 1));
        eventoElement.appendChild(escreverOrganizadores(doc,
                doc.createElement(listaOrganizadoresTag), evento));
        eventoElement.appendChild(escreverCP(doc,
                doc.createElement(cpTag), evento, numeroMembrosCPTag,
                membrosCPTag, membroCPTag));
        eventoElement.appendChild(
                escreverListaSessoesTematicas(doc,
                        doc.createElement(listaSessoesTematicasTag),
                        evento.getListaSessoesTematicas()));
        eventoElement.appendChild(
                escreverListaSubmissoes(doc,
                        doc.createElement(listaSubmissoesEventoTag),
                        evento.getListaSubmissoes(), evento));

        return eventoElement;
    }

    /**
     * Constrói uma árvore que guarda a informação da lista de organizadores.
     *
     * @param doc Documento XML.
     * @param listaOrganizadoresElement Elemento que guarda a lista de
     * organizadores.
     * @param evento Evento de onde é extraida a informação.
     *
     * @return Elemento preenchido
     */
    private Element escreverOrganizadores(Document doc,
            Element listaOrganizadoresElement, Evento evento) {
        listaOrganizadoresElement.appendChild(doc.createElement(
                numeroOrganizadoresTag)).setTextContent(
                        String.valueOf(evento.getNumeroOrganizadores()));

        Element organizadores = doc.createElement(organizadoresTag);
        listaOrganizadoresElement.appendChild(organizadores);

        for (int i = 0; i < evento.getNumeroOrganizadores(); i++) {
            organizadores.appendChild(doc.createElement(
                    organizadorTag)).setTextContent(
                            evento.getOrganizadorPeloID(i).getUtilizador().getUsername());
        }

        return listaOrganizadoresElement;
    }

    /**
     * Constrói uma árvore que guarda a informação da CP.
     *
     * @param doc Documento XML.
     * @param CPElement Elemento que guarda a CP.
     * @param cp CP de onde é extraiada a informação.
     *
     * @return Elemento preenchido.
     */
    private Element escreverCP(Document doc,
            Element CPElement, CPDefinivel cpDefinivel, String numeroRevisores,
            String revisores, String revisor) {
        CPElement.appendChild(doc.createElement(
                numeroRevisores)).setTextContent(
                        (cpDefinivel.getCP() != null)
                                ? String.valueOf(cpDefinivel.getCP().getNumeroRevisores())
                                : String.valueOf(0));

        Element membrosCP = doc.createElement(revisores);
        CPElement.appendChild(membrosCP);

        if (cpDefinivel.getCP() != null) {
            for (int i = 0; i < cpDefinivel.getCP().getNumeroRevisores(); i++) {
                membrosCP.appendChild(doc.createElement(
                        revisor)).setTextContent(
                                cpDefinivel.getCP().getRevisorPeloID(
                                        i).getUtilizador().getUsername());
            }
        }

        return CPElement;
    }

    /**
     * Constrói uma árvore que guarda a informação da lista de sessões
     * temáticas.
     *
     * @param doc Documento XML.
     * @param listaSessoesTematicasElement Elemento que guarda a informação da
     * lista de sessões temáticas.
     * @param listaSessoesTematicas Lista de sessões temáticas de onde é
     * extraida a informação.
     *
     * @return Elemento preenchido.
     */
    private Element escreverListaSessoesTematicas(Document doc,
            Element listaSessoesTematicasElement,
            ListaSessoesTematicas listaSessoesTematicas) {
        listaSessoesTematicasElement.appendChild(doc.createElement(
                numeroSessoesTematicasTag)).setTextContent(
                        String.valueOf(listaSessoesTematicas.getNumeroSessoesTematicas()));

        Element sessoesTematicas = doc.createElement(sessoesTematicasTag);
        listaSessoesTematicasElement.appendChild(sessoesTematicas);

        for (int j = 0; j < listaSessoesTematicas.getNumeroSessoesTematicas(); j++) {
            sessoesTematicas.appendChild(escreverSessaoTematica(doc,
                    doc.createElement(sessaoTematicaTag),
                    listaSessoesTematicas.getSessoesTematicasPeloID(j)));
        }
        return listaSessoesTematicasElement;
    }

    /**
     * Constrói uma árvore que guarda a informação de uma sessão temática.
     *
     * @param doc Documento XML.
     * @param sessaoTematicaElement Elemento que guarda a sessão temática.
     * @param sessaoTematica Sessão temática de onde é extraida a informação.
     *
     * @return Elemento preenchido.
     */
    private Element escreverSessaoTematica(Document doc,
            Element sessaoTematicaElement, SessaoTematica sessaoTematica) {
        sessaoTematicaElement.appendChild(doc.createElement(
                codigoSTTag)).setTextContent(
                        sessaoTematica.getCodigoUnico());
        sessaoTematicaElement.appendChild(doc.createElement(
                descricaoSTTag)).setTextContent(
                        sessaoTematica.getDescricao());
        sessaoTematicaElement.appendChild(doc.createElement(
                dataInicioTag)).setTextContent(
                        sessaoTematica.getDataInicio().toString());
        sessaoTematicaElement.appendChild(doc.createElement(
                dataFimTag)).setTextContent(
                        sessaoTematica.getDataFim().toString());
        sessaoTematicaElement.appendChild(doc.createElement(
                dataInicioSubmissaoTag)).setTextContent(
                        sessaoTematica.getDataInicioSubmissao().toString());
        sessaoTematicaElement.appendChild(doc.createElement(
                dataFimSubmissaoTag)).setTextContent(
                        sessaoTematica.getDataFimSubmissao().toString());
        sessaoTematicaElement.appendChild(doc.createElement(
                dataInicioDistribuicaoTag)).setTextContent(
                        sessaoTematica.getDataInicioDistribuicao().toString());
        sessaoTematicaElement.appendChild(doc.createElement(
                dataLimiteRevisaoTag)).setTextContent(
                        sessaoTematica.getDataFimRevisao().toString());
        sessaoTematicaElement.appendChild(doc.createElement(
                dataLimiteSubmissaoFinalTag)).setTextContent(
                        sessaoTematica.getDataFimSubmissaoCameraReady().toString());
        sessaoTematicaElement.appendChild(doc.createElement(
                estadoSTTag)).setTextContent(
                        sessaoTematica.getEstado().getClass().getSimpleName());
        sessaoTematicaElement.appendChild(escreverProponentes(
                doc, doc.createElement(listaProponentesTag), sessaoTematica));
        sessaoTematicaElement.appendChild(escreverCP(doc,
                doc.createElement(CPSessaoTag), sessaoTematica,
                numeroMembrosCPSTTag, membrosCPSessaoTag, membroCPSessaoTag));
        sessaoTematicaElement.appendChild(escreverListaSubmissoes(
                doc, doc.createElement(listaSubmissoesTag),
                sessaoTematica.getListaSubmissoes(), sessaoTematica));

        return sessaoTematicaElement;
    }

    /**
     * Constrói uma árvore que guarda a informação da lista de proponentes.
     *
     * @param doc Documento XML.
     * @param listaProponentesElement Elemento que guarda a lista de
     * proponentes.
     * @param sessaoTematica Sessão temática de onde é extraida a informação.
     *
     * @return Elemento preenchido
     */
    private Element escreverProponentes(Document doc,
            Element listaProponentesElement, SessaoTematica sessaoTematica) {
        listaProponentesElement.appendChild(doc.createElement(
                numeroProponentesTag)).setTextContent(
                        String.valueOf(sessaoTematica.getNumeroProponentes()));

        Element proponentes = doc.createElement(proponentesTag);
        listaProponentesElement.appendChild(proponentes);

        for (int i = 0; i < sessaoTematica.getNumeroProponentes(); i++) {
            proponentes.appendChild(doc.createElement(
                    proponenteTag)).setTextContent(
                            sessaoTematica.getProponentePeloID(i).getUtilizador().getUsername());
        }

        return listaProponentesElement;
    }

    /**
     * Constrói uma árvore que guarda a informação da lista de submissões.
     *
     * @param doc Documento XML.
     * @param listaSubmissoesElement Elemento que guarda a lista de submissões.
     * @param listaSubmissoes Lista de submissões de onde é extraida a
     * informação.
     * @param distribuivel Evento ou sessão temática.
     *
     * @return Elemento preenchido.
     */
    private Element escreverListaSubmissoes(Document doc,
            Element listaSubmissoesElement, ListaSubmissoes listaSubmissoes,
            Distribuivel distribuivel) {
        listaSubmissoesElement.appendChild(doc.createElement(
                numeroSubmissoesTag)).setTextContent(
                        String.valueOf(listaSubmissoes.getNumeroSubmissoes()));

        Element submissoesElement = doc.createElement(submissoesTag);
        listaSubmissoesElement.appendChild(submissoesElement);

        for (int i = 0; i < listaSubmissoes.getNumeroSubmissoes(); i++) {
            submissoesElement.appendChild(escreverSubmissao(
                    doc, doc.createElement(submissaoTag),
                    listaSubmissoes.getSubmissaoPeloID(i), distribuivel));
        }

        return listaSubmissoesElement;
    }

    /**
     * Constrói uma árvore que guarda a informação de uma submissão.
     *
     * @param doc Documento XML.
     * @param submissaoElement Elemento que guarda a submissão.
     * @param submissao Submissão de onde é extraida a informação.
     * @param distribuivel Evento ou sessão temática.
     *
     * @return Elemento preenchido.
     */
    private Element escreverSubmissao(Document doc,
            Element submissaoElement, Submissao submissao,
            Distribuivel distribuivel) {
        submissaoElement.appendChild(
                doc.createElement(estadoSubmissaoTag)).setTextContent(
                        submissao.getEstado().getClass().getSimpleName());
        submissaoElement.appendChild(escreverArtigo(
                doc, doc.createElement(artigoTag),
                submissao.getArtigoInicial(), artigoInicialAttr));
        if (submissao.isStateEmCameraReady()) {
            submissaoElement.appendChild(escreverArtigo(
                    doc, doc.createElement(artigoTag),
                    submissao.getArtigoInicial(), artigoFinalAttr));
        }

        if (distribuivel.getProcessoDistribuicao() != null) {
            submissaoElement.appendChild(escreverListaRevisoes(doc,
                    doc.createElement(listaRevisoesTag), submissao, distribuivel));
        }

        if (((Decidivel) distribuivel).getProcessoDecisao() != null) {
            ListaDecisoes listaDecisoes
                    = ((Decidivel) distribuivel).getProcessoDecisao().getListaDecisoes();

            for (int i = 0; i < listaDecisoes.numeroDecisoes(); i++) {
                Decisao decisao;
                if ((decisao
                        = listaDecisoes.getDecisaoPeloID(i)).getSubmissao().equals(submissao)) {
                    submissaoElement.appendChild(doc.createElement(
                            decisaoTag)).setTextContent(
                                    String.valueOf(decisao.getClassificacao()));
                }
            }
        }

        return submissaoElement;
    }

    /**
     * Constrói a árvore que guarda a lista de revisões de uma submissão.
     *
     * @param doc Documento XML.
     * @param listaRevisoesElement Elemento que guarda a lista de revisões.
     * @param submissao Submissão da qual é extraida a informação.
     * @param distribuivel Distribuivel que contém a lista de revisões.
     *
     * @return Elemento preenchido.
     */
    private Element escreverListaRevisoes(Document doc,
            Element listaRevisoesElement, Submissao submissao,
            Distribuivel distribuivel) {
        ListaRevisoes listaRevisoes
                = distribuivel.getProcessoDistribuicao().getListaRevisoes();

        listaRevisoesElement.appendChild(doc.createElement(
                numeroRevisoesTag)).setTextContent(
                        String.valueOf(listaRevisoes.numeroRevisoes()));

        Element revisoesElement = doc.createElement(revisoesTag);
        listaRevisoesElement.appendChild(revisoesElement);

        for (int i = 0; i < listaRevisoes.numeroRevisoes(); i++) {
            if (listaRevisoes.getRevisaoPeloID(i).getSubmissao().equals(submissao)) {
                revisoesElement.appendChild(escreverRevisao(
                        doc, doc.createElement(revisaoTag),
                        listaRevisoes.getRevisaoPeloID(i)));
            }
        }

        return listaRevisoesElement;
    }

    /**
     * Constrói a árvore que guarda uma revisão de uma submissão.
     *
     * @param doc Documento XML.
     * @param revisaoElement Elemento que guarda a revisão.
     * @param revisao Revisão de onde é extraida a informação.
     *
     * @return Elemento preenchido.
     */
    private Element escreverRevisao(Document doc,
            Element revisaoElement, Revisao revisao) {
        revisaoElement.appendChild(doc.createElement(
                revisorTag)).setTextContent(
                        revisao.getRevisor().getUtilizador().getUsername());
        revisaoElement.appendChild(doc.createElement(
                estadoRevisaoTag)).setTextContent(
                        (revisao.getRecomendacaoGlobal() == -1)
                                ? "RevisaoStateConcluida"
                                : "RevisaoStatePorConcluir");
        revisaoElement.appendChild(doc.createElement(
                confiancaTag)).setTextContent(
                        String.valueOf(revisao.getConfiancaRevisor()));
        revisaoElement.appendChild(doc.createElement(
                adequacaoTag)).setTextContent(
                        String.valueOf(revisao.getAdequacaoArtigo()));
        revisaoElement.appendChild(doc.createElement(
                originalidadeTag)).setTextContent(
                        String.valueOf(revisao.getOriginalidadeArtigo()));
        revisaoElement.appendChild(doc.createElement(
                apresentacaoTag)).setTextContent(
                        String.valueOf(revisao.getQualidadeArtigo()));
        revisaoElement.appendChild(doc.createElement(
                recomendacaoTag)).setTextContent(
                        String.valueOf(revisao.getRecomendacaoGlobal()));
        revisaoElement.appendChild(doc.createElement(
                justificacaoTag)).setTextContent(
                        revisao.getTextoJustificativo());

        return revisaoElement;
    }

    /**
     * Constrói a arvore que contém a lista de autores de um artigo.
     *
     * @param doc Documento XML.
     * @param listaAutoresElement Elemento que guarda a lista de autores.
     * @param artigo Artigo de onde é extraida a informação que se pretende
     * guardar
     *
     * @return Elemento preenchido.
     */
    private Element escreverListaAutores(Document doc,
            Element listaAutoresElement, Artigo artigo) {
        ListaAutores listaAutores = artigo.getListaAutores();
        listaAutoresElement.appendChild(doc.createElement(
                numeroAutoresTag)).setTextContent(String.valueOf(
                                listaAutores.getNumeroAutores()));

        Element autoresElement = doc.createElement(autoresTag);
        listaAutoresElement.appendChild(autoresElement);

        for (int i = 0; i < listaAutores.getNumeroAutores(); i++) {
            Element autorElement = doc.createElement(autorTag);
            autoresElement.appendChild(autorElement);

            Autor autor = listaAutores.getAutorPeloID(i);

            autorElement.appendChild(doc.createElement(
                    nomeAutorTag)).setTextContent(autor.getNome());
            autorElement.appendChild(doc.createElement(
                    emailAutorTag)).setTextContent(autor.getEmail());
            autorElement.appendChild(doc.createElement(
                    filiacaoAutorTag)).setTextContent(
                            autor.getInstituicaoAfiliacao().toString());
            autorElement.appendChild(doc.createElement(
                    usernameAutorTag)).setTextContent(
                            (autor.getUtilizador() != null)
                                    ? autor.getUtilizador().getUsername()
                                    : "");
        }

        return listaAutoresElement;
    }

    /**
     * Constrói a arvore que contém o artigo de uma submissão.
     *
     * @param doc Documento XML.
     * @param artigoElement Elemento que guarda o artigo.
     * @param artigo Artigo de onde é extraida a informação.
     * @param tipo Tipo de artigo (inicial/final).
     *
     * @return Elemento preenchido.
     */
    private Element escreverArtigo(Document doc,
            Element artigoElement, Artigo artigo, String tipo) {
        artigoElement.setAttribute("tipo", tipo);
        artigoElement.appendChild(doc.createElement(
                autorCorrespondenteTag)).setTextContent(
                        artigo.getAutorCorrespondente().getEmail());
        artigoElement.appendChild(doc.createElement(
                autorSubmissorTag)).setTextContent(
                        artigo.getAutorSubmissor().getEmail());
        artigoElement.appendChild(doc.createElement(
                dataSubmissaoTag)).setTextContent(
                        artigo.getDataSubmissao().toString());
        artigoElement.appendChild(doc.createElement(
                tituloArtigoTag)).setTextContent(artigo.getTitulo());
        artigoElement.appendChild(doc.createElement(
                resumoTag)).setTextContent(artigo.getResumo());
        artigoElement.appendChild(escreverListaAutores(
                doc, doc.createElement(listaAutoresTag), artigo));
        artigoElement.appendChild(doc.createElement(
                ficheiroTag)).setTextContent(artigo.getFicheiro());
        artigoElement.appendChild(doc.createElement(
                palavrasChaveTag)).setTextContent(
                        String.join(";", artigo.getPalavrasChave()));

        return artigoElement;
    }

    /**
     * Lê e processa um ficheiro XML devolvendo a árvore do mesmo.
     *
     * @param caminho Caminho do ficheiro a ler.
     * @return Construção de uma árvore em XML.
     */
    private Document lerFicheiro(String caminho)
            throws ParserConfigurationException, IOException, SAXException {
        File ficheiro = new File(caminho);
        DocumentBuilderFactory docBuilderF = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder;
        docBuilder = docBuilderF.newDocumentBuilder();
        Document doc = docBuilder.parse(ficheiro);
        doc.normalize();

        return doc;
    }

    /**
     * Gera o ficheiro XML com a árvores de informação disponibilizada.
     *
     * @param doc Documento que contém toda a árvore de informação
     * disponibilizada.
     * @param nomeFicheiro Nome do ficheiro XML que irá ser criado.
     */
    private void escreverFicheiro(Document doc, String nomeFicheiro)
            throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(nomeFicheiro));
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(source, result);
    }

}
