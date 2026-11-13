import java.util.ArrayList;
import java.util.Scanner;

public abstract class Procedimento {

    private Paciente paciente;
    private Medico medicoResponsavel;
    private ResponsavelTecnico responsavelTecnico;
    private boolean liberadoResponsavelTecnico = false;
    private String especialidadeExigida;

    public Procedimento(Paciente paciente, Medico medicoResponsavel, ResponsavelTecnico responsavelTecnico,
            String especialidadeExigida) {
        this.paciente = paciente;
        this.medicoResponsavel = medicoResponsavel;
        this.responsavelTecnico = responsavelTecnico;
        this.especialidadeExigida = especialidadeExigida;
        validaEspecialidade();
    }

    public boolean getLiberadoResponsavelTecnico() {
        return this.liberadoResponsavelTecnico;
    }

    public void setLiberadoResponsavelTecnico(boolean liberadoResponsavelTecnico) {
        this.liberadoResponsavelTecnico = liberadoResponsavelTecnico;
    }

    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void validaEspecialidade() {
        if (!medicoResponsavel.getEspecialidade().equals(especialidadeExigida)) {
            throw new IllegalArgumentException(
                    "O médico responsável não possui a especialidade exigida para este procedimento.");
        }
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public ResponsavelTecnico getResponsavelTecnico() {
        return responsavelTecnico;
    }

    // sobrescrevendo o método toString para exibir informações do procedimento
    // se não fizermos a sobrescrita, o método toString da classe Object sera 
    // chamado, e ele por padrão retorna o nome da classe e o hashcode do objeto, o que não é muito útil para nós.
    @Override
    public String toString() {
        return "Tipo: " + this.getClass().getSimpleName() + // pega o nome da suclasse concreta
                " | Paciente: " + this.paciente.getNome() + // pega o nome do paciente
                " | Médico: " + this.medicoResponsavel.getNome() + // pega o nome do médico responsável
                " | Especialidade: " + this.especialidadeExigida +
                " | Liberado pelo RT: " + this.liberadoResponsavelTecnico;
    }

    public static Procedimento cadastrarProcedimento(Scanner scanner, ArrayList<Paciente> pacientes, ArrayList<Funcionario> funcionarios) {
        System.out.println("\n=== Tipo de Procedimento ===");
        System.out.println("1 - Consulta");
        System.out.println("2 - Procedimento Estético");
        System.out.println("3 - Procedimento Cirúrgico");
        System.out.print("Escolha o tipo: ");
        int tipo = Integer.parseInt(scanner.nextLine());

        System.out.println("\n=== Escolha o Paciente ===");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println(i + " - " + pacientes.get(i).getNome());
        }
        System.out.print("Número do paciente: ");
        int idxPac = Integer.parseInt(scanner.nextLine());
        Paciente paciente = pacientes.get(idxPac);

        System.out.println("\n=== Escolha o Médico Responsável ===");
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i) instanceof Medico) {
                Medico m = (Medico) funcionarios.get(i);
                System.out.println(i + " - " + m.getNome() + " (Especialidade: " + m.getEspecialidade() + ")");
            }
        }
        System.out.print("Número do médico: ");
        int idxMed = Integer.parseInt(scanner.nextLine());
        Medico medico = (Medico) funcionarios.get(idxMed);

        System.out.print("Digite a especialidade exigida pelo procedimento: ");
        String especialidade = scanner.nextLine();

        ResponsavelTecnico rt = (ResponsavelTecnico) funcionarios.get(6);

        if (tipo == 1) {
            return new Consulta(paciente, medico, rt, especialidade);
        } else if (tipo == 2) {
            Enfermeiro enf = (Enfermeiro) funcionarios.get(4);
            Anestesista anest = (Anestesista) funcionarios.get(5);
            return new ProcedimentoEstetico(paciente, medico, rt, enf, anest, especialidade);
        } else {
            Enfermeiro enf = (Enfermeiro) funcionarios.get(4);
            Anestesista anest = (Anestesista) funcionarios.get(5);
            return new ProcedimentoCirurgico(paciente, medico, rt, anest, enf, especialidade);
        }
    }
}
