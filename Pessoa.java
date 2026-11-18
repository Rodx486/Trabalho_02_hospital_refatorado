/**
 * Representa os dados pessoais comuns a pacientes e funcionários.
 */
public abstract class Pessoa {

    private String nome;
    private String endereco;
    private String cpf;

    /**
     * Inicializa um novo objeto desta classe.
     * @param nome nome da pessoa.
     * @param endereco endereço da pessoa.
     * @param cpf CPF da pessoa.
     */
    public Pessoa(String nome, String endereco, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    /**
     * Retorna o nome da pessoa.
     * @return nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o endereço da pessoa.
     * @return endereço da pessoa.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Retorna o CPF da pessoa.
     * @return CPF da pessoa.
     */
    public String getCpf() {
        return cpf;
    }

}
