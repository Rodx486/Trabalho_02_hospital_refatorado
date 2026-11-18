import java.util.ArrayList;

/**
 * Representa os dados comuns a todos os funcionários do hospital.
 */
public abstract class Funcionario extends Pessoa {

    private String matricula;
    private String salario;
    private String setor;
    private String cargo;

    /**
     * Inicializa um novo objeto desta classe.
     * @param nome nome da pessoa.
     * @param endereco endereço da pessoa.
     * @param cpf CPF da pessoa.
     * @param matricula matrícula do funcionário.
     * @param salario salário do funcionário.
     * @param setor setor de trabalho.
     * @param cargo cargo do funcionário.
     */
    public Funcionario(String nome, String endereco, String cpf, String matricula, String salario, String setor,
            String cargo) {
        super(nome, endereco, cpf);
        this.matricula = matricula;
        this.salario = salario;
        this.setor = setor;
        this.cargo = cargo;
    }

    /**
     * Retorna a matrícula do funcionário.
     * @return matrícula do funcionário.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Retorna o salário do funcionário.
     * @return salário do funcionário.
     */
    public String getSalario() {
        return salario;
    }

    /**
     * Retorna o setor do funcionário.
     * @return setor do funcionário.
     */
    public String getSetor() {
        return setor;
    }

    /**
     * Retorna o cargo do funcionário.
     * @return cargo do funcionário.
     */
    public String getCargo() {
        return cargo;
    }

   /**
    * Localiza e retorna o primeiro funcionário compatível com o tipo informado.
    * @param funcionarios funcionários disponíveis no sistema.
    * @param tipo classe do funcionário que deve ser localizada.
    * @return valor produzido pela operação.
    */
   public static <T extends Funcionario> T buscarPorTipo(
        ArrayList<Funcionario> funcionarios, Class<T> tipo) {

    for (Funcionario funcionario : funcionarios) {
        if (tipo.isInstance(funcionario)) {
            return tipo.cast(funcionario);
        }
    }

    return null;
}
}
