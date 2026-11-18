import java.util.ArrayList;
/**
 * Representa um paciente e permite consultar seus procedimentos registrados.
 */
public class Paciente extends Pessoa {
    /**
     * Inicializa um novo objeto desta classe.
     * @param nome nome da pessoa.
     * @param endereco endereço da pessoa.
     * @param cpf CPF da pessoa.
     */
    public Paciente(String nome, String endereco, String cpf) {
        super(nome, endereco, cpf);
    }

    /**
     * Exibe os procedimentos associados a este paciente.
     * @param todosProcedimentos lista de procedimentos a consultar.
     */
    public void consultarRegistros(ArrayList<Procedimento> todosProcedimentos) {
        System.out.println("Registros de procedimentos do paciente " + getNome() + ":");
        for (Procedimento procedimento : todosProcedimentos) {
            if (procedimento.getPaciente().equals(this)) {
                System.out.println(procedimento);
            }
        }
       

    }

}
