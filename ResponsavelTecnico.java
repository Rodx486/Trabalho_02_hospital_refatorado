/**
 * Representa o responsável técnico que pode liberar procedimentos.
 */
public class ResponsavelTecnico extends Funcionario {
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
    public ResponsavelTecnico(String nome, String endereco, String cpf, String matricula, String salario, String setor, String cargo, String coren,
            String senha) {
        super(nome, endereco, cpf, matricula, salario, setor, cargo);
   
    }

    /**
     * Libera o procedimento quando o funcionário é seu responsável técnico.
     * @param p procedimento a ser agendado.
     */
    public void liberarProcedimento(Procedimento p) {
        if(this.equals(p.getResponsavelTecnico())) {
            p.setLiberadoResponsavelTecnico(true);
            System.out.println("Procedimento liberado com sucesso pelo Responsável Técnico " + getNome() + "!");
        } else {
            System.out.println("Apenas o responsável técnico do procedimento pode liberá-lo.");
        }
    }

}
