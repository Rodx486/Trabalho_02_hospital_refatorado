/**
 * Representa um enfermeiro que atua nos procedimentos hospitalares.
 */
public class Enfermeiro extends Funcionario {

    /**
     * Inicializa um novo objeto desta classe.
     * @param nome nome da pessoa.
     * @param endereco endereço da pessoa.
     * @param cpf CPF da pessoa.
     * @param matricula matrícula do funcionário.
     * @param salario salário do funcionário.
     * @param setor setor de trabalho.
     * @param cargo cargo do funcionário.
     * @param coren valor utilizado pela operação.
     * @param senha senha informada para autenticação.
     */
    public Enfermeiro(String nome, String endereco, String cpf, String matricula, String salario, String setor, String cargo, String coren,
            String senha) {
        super(nome, endereco, cpf, matricula, salario, setor, cargo);

    }

}
