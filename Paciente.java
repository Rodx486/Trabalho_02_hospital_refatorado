import java.util.ArrayList;
public class Paciente extends Pessoa {
    public Paciente(String nome, String endereco, String cpf) {
        super(nome, endereco, cpf);
    }

    public void consultarRegistros(ArrayList<Procedimento> todosProcedimentos) {
        System.out.println("Registros de procedimentos do paciente " + getNome() + ":");
        for (Procedimento procedimento : todosProcedimentos) {
            if (procedimento.getPaciente().equals(this)) {
                System.out.println(procedimento);
            }
        }
       

    }

}
