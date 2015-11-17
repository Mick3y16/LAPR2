package eventoscientificos.model;

/**
 * Representa uma instância de autor através do nome, do email e instituição de
 * afiliação.
 *
 * @author G01
 */
public class Autor {

    /**
     * Nome do autor.
     */
    private String nome;

    /**
     * Email do autor.
     */
    private String email;

    /**
     * InstituicaoAfiliacao do autor.
     */
    private InstituicaoAfiliacao instituicaoAfiliacao;

    /**
     * Utilizador que é autor.
     */
    private Utilizador utilizador;

    /**
     * Constrói uma instância de autor recebendo um nome, um email e uma
     * instituição de afiliação.
     *
     * @param nome Nome do autor.
     * @param email Email do autor.
     * @param instituicaoAfiliacao Instituicao de Afiliacao do autor.
     */
    public Autor(String nome, String email,
            InstituicaoAfiliacao instituicaoAfiliacao) {
        setNome(nome);
        setEmail(email);
        setInstituicaoAfiliacao(instituicaoAfiliacao);
    }
    
    /**
     * Constrói uma instância de autor recebendo um utilizador e uma
     * instituição de afiliação.
     * 
     * @param utilizador Utilizador que é autor.
     * @param instituicaoAfiliacao Instituicao de Afiliacao do autor.
     */
    public Autor(Utilizador utilizador, InstituicaoAfiliacao instituicaoAfiliacao) {
        this(utilizador.getNome(), utilizador.getEmail(), instituicaoAfiliacao);
        this.utilizador = utilizador;
    }

    /**
     * Constrói uma cópia de autor, com os mesmos atributos que o autor passado
     * por parametro.
     * 
     * @param autor Autor que irá ser copiado.
     */
    public Autor(Autor autor) {
        setNome(autor.getNome());
        setEmail(autor.getEmail());
        setInstituicaoAfiliacao(autor.getInstituicaoAfiliacao());
        this.utilizador = autor.getUtilizador();
    }
    
    /**
     * Devolve o nome do autor.
     *
     * @return Nome do autor.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Devolve o email do autor.
     *
     * @return Email do autor.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Devolve a instituição de afiliação do autor.
     *
     * @return Instituição de afiliação do autor.
     */
    public InstituicaoAfiliacao getInstituicaoAfiliacao() {
        return this.instituicaoAfiliacao;
    }

    /**
     * Devolve o utilizador referente ao autor.
     *
     * @return Utilizador referente ao autor.
     */
    public Utilizador getUtilizador() {
        return this.utilizador;
    }

    /**
     * Modifica o nome do autor.
     *
     * @param nome Novo nome do autor.
     */
    public void setNome(String nome) {
        if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do autor nao pode estar"
                    + " vazio");
        }
        if (nome.contains("[0-9]+")) {

            throw new IllegalArgumentException("Nome do autor nao pode conter"
                    + " numeros");
        }
        if (nome.length() < 2) {
            throw new IllegalArgumentException("Nome do autor tem de ter pelo"
                    + " menos 2 letras");

        }
        if (nome.contains("[()<>,;:.\\[\\]{}]\\\\\\\\")) {
            throw new IllegalArgumentException("Nome do autor nao pode conter"
                    + " caracteres");
        }
        this.nome = nome;
    }

    /**
     * Modifica o email do autor.
     *
     * @param email Novo email do autor.
     */
    public void setEmail(String email) {
        if (email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email do autor não pode estar"
                    + " vazio.");
        }
        if (email.contains("[()<>,;:.\\[\\]{}]\\\\\\\\")) {
            throw new IllegalArgumentException("Email do autor não pode conter "
                    + "caracteres.");
        }
        if (!(email.matches(".+@.+\\..{2,}"))) {
            throw new IllegalArgumentException("Email do autor tem de obedecer"
                    + " a estrutura");
        }

        this.email = email;
    }
    
    /**
     * Modifica a instituicaoAfiliacao.
     * 
     * @param instituicaoAfiliacao Nova instituicao de afiliacao do autor.
     */
    public void setInstituicaoAfiliacao(InstituicaoAfiliacao instituicaoAfiliacao) {
        this.instituicaoAfiliacao = instituicaoAfiliacao;
    }
    
    public boolean validarAutor() {
        return true;
    }
    
    /**
     * Faz a comparação entre dois autores, comparando primeiro a posição de
     * memória entre ambos, de seguida as classes e, se o segundo é ou não nulo
     * e por fim os atributos de ambos.
     *
     * @param outroObjeto Objeto/Autor que vai ser comparado.
     * @return Verdadeiro se os objetos comparados forem iguais e falso se forem
     * diferentes.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }

        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }

        Autor outroAutor = (Autor) outroObjeto;

        return this.getEmail().equalsIgnoreCase(outroAutor.getEmail());
    }

    /**
     * Verifica se o autor é ou não um utilizador registado.
     *
     * @return Verdadeiro se o autor for um utilizador registado ou falso se o
     * autor não o for.
     */
    public boolean isAutorRegistado() {
        return this.getUtilizador() != null;
    }

    
     /**
     * Devolve a descrição textual do autor no formato: nome, email, instituição
     * de afiliação.
     * 
     * @return Caracteristicas do autor
     */
    @Override
    public String toString() {
        return String.format("%s, %s, %s",
                this.getNome(), this.getEmail(), this.getInstituicaoAfiliacao());
    }

}
