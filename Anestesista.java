/**
 * Representa um anestesista que atua nos procedimentos hospitalares.
 */
public class Anestesista extends Funcionario {

    /**
     * Inicializa um novo objeto desta classe.
     * @param nome nome da pessoa.
     * @param endereco endereço da pessoa.
     * @param cpf CPF da pessoa.
     * @param matricula matrícula do funcionário.
     * @param salario salário do funcionário.
     * @param setor setor de trabalho.
     * @param cargo cargo do funcionário.
     * @param corem valor utilizado pela operação.
     * @param senha senha informada para autenticação.
     */
    public Anestesista(String nome, String endereco, String cpf, String matricula, String salario, String setor, String cargo, String corem,
            String senha) {
        super(nome, endereco, cpf, matricula, salario, setor, cargo);

    }
    
}
