import java.util.ArrayList;
/**
 * Representa um funcionário técnico-administrativo autorizado a agendar procedimentos.
 */
public class FuncionarioTecnicoAdministrativo extends Funcionario implements Agendador{

    private String senha;

    /**
     * Inicializa um novo objeto desta classe.
     * @param nome nome da pessoa.
     * @param endereco endereço da pessoa.
     * @param cpf CPF da pessoa.
     * @param matricula matrícula do funcionário.
     * @param salario salário do funcionário.
     * @param setor setor de trabalho.
     * @param cargo cargo do funcionário.
     * @param senha senha informada para autenticação.
     */
    public FuncionarioTecnicoAdministrativo(String nome, String endereco, String cpf, String matricula, String salario, String setor, String cargo, String senha) {
        super(nome, endereco, cpf, matricula, salario, setor, cargo);
        this.senha = senha;
    }


    /**
     * Retorna a senha usada para autenticar o agendamento.
     * @return senha de autenticação.
     */
    public String getSenha() {
        return senha;
    }
    
    /**
     * Valida a senha e, se estiver correta, adiciona o procedimento à lista de agendamentos.
     * @param lista lista na qual o procedimento será agendado.
     * @param p procedimento a ser agendado.
     * @param senha senha informada para autenticação.
     */
    public void agendarProcedimento(ArrayList<Procedimento> lista, Procedimento p, String senha) {
        if (this.senha.equals(senha)) {
            lista.add(p);
            System.out.println("Procedimento agendado com sucesso!");
        } else {
            System.out.println("Senha incorreta. Não foi possível agendar o procedimento.");
        }
    }
}
