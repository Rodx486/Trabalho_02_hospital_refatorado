import java.util.ArrayList;
import java.util.Scanner;

/**
 * Representa os dados e regras comuns aos procedimentos hospitalares.
 */
public abstract class Procedimento {

    private Paciente paciente;
    private Medico medicoResponsavel;
    private ResponsavelTecnico responsavelTecnico;
    private boolean liberadoResponsavelTecnico = false;
    private String especialidadeExigida;

    /**
     * Inicializa um novo objeto desta classe.
     * @param paciente paciente associado ao procedimento.
     * @param medicoResponsavel médico responsável pelo procedimento.
     * @param responsavelTecnico responsável técnico associado ao procedimento.
     * @param especialidadeExigida especialidade necessária para o procedimento.
     */
    public Procedimento(Paciente paciente, Medico medicoResponsavel, ResponsavelTecnico responsavelTecnico,
            String especialidadeExigida) {
        this.paciente = paciente;
        this.medicoResponsavel = medicoResponsavel;
        this.responsavelTecnico = responsavelTecnico;
        this.especialidadeExigida = especialidadeExigida;
        validaEspecialidade();
    }

    /**
     * Informa se o responsável técnico liberou o procedimento.
     * @return true se o responsável técnico liberou o procedimento; caso contrário, false.
     */
    public boolean getLiberadoResponsavelTecnico() {
        return this.liberadoResponsavelTecnico;
    }

    /**
     * Atualiza o estado de liberação do procedimento pelo responsável técnico.
     * @param liberadoResponsavelTecnico novo estado de liberação pelo responsável técnico.
     */
    public void setLiberadoResponsavelTecnico(boolean liberadoResponsavelTecnico) {
        this.liberadoResponsavelTecnico = liberadoResponsavelTecnico;
    }

    /**
     * Retorna o médico responsável pelo procedimento.
     * @return médico responsável pelo procedimento.
     */
    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    /**
     * Verifica se o médico responsável possui a especialidade exigida.
     */
    public void validaEspecialidade() {
        if (!medicoResponsavel.getEspecialidade().equals(especialidadeExigida)) {
            throw new IllegalArgumentException(
                    "O médico responsável não possui a especialidade exigida para este procedimento.");
        }
    }

    /**
     * Retorna o paciente associado ao procedimento.
     * @return paciente associado ao procedimento.
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * Retorna o responsável técnico associado ao procedimento.
     * @return responsável técnico pelo procedimento.
     */
    public ResponsavelTecnico getResponsavelTecnico() {
        return responsavelTecnico;
    }

    // sobrescrevendo o método toString para exibir informações do procedimento
    // se não fizermos a sobrescrita, o método toString da classe Object sera
    // chamado, e ele por padrão retorna o nome da classe e o hashcode do objeto, o
    // que não é muito útil
    /**
     * Retorna uma descrição textual do objeto.
     * @return descrição textual do objeto.
     */
    @Override
    public String toString() {
        return "Tipo: " + this.getClass().getSimpleName() + // pega o nome da suclasse concreta
                " | Paciente: " + this.paciente.getNome() + // pega o nome do paciente
                " | Médico: " + this.medicoResponsavel.getNome() + // pega o nome do médico responsável
                " | Especialidade: " + this.especialidadeExigida +
                " | Liberado pelo RT: " + this.liberadoResponsavelTecnico;
    }

    /**
     * Solicita os dados do procedimento e cria a instância do tipo escolhido.
     * @param scanner leitor usado para receber os dados digitados no console.
     * @param pacientes pacientes disponíveis para seleção.
     * @param funcionarios funcionários disponíveis no sistema.
     * @return procedimento criado com os dados informados.
     */
    public static Procedimento cadastrarProcedimento(Scanner scanner, ArrayList<Paciente> pacientes,
            ArrayList<Funcionario> funcionarios) {
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
        ArrayList<Medico> medicos = new ArrayList<>();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof Medico) {
                medicos.add((Medico) funcionario);
            }
        }

        if (medicos.isEmpty()) {
            throw new IllegalArgumentException("Nenhum médico cadastrado.");
        }

        for (int i = 0; i < medicos.size(); i++) {
            Medico medicoDaLista = medicos.get(i);
            System.out.println(i + " - " + medicoDaLista.getNome()
                    + " (Especialidade: " + medicoDaLista.getEspecialidade() + ")");
        }

        System.out.print("Número do médico: ");
        int idxMed = Integer.parseInt(scanner.nextLine());

        if (idxMed < 0 || idxMed >= medicos.size()) {
            throw new IllegalArgumentException("Número de médico inválido.");
        }

        Medico medico = medicos.get(idxMed);
        System.out.print("Digite a especialidade exigida pelo procedimento: ");
        String especialidade = scanner.nextLine();

        ResponsavelTecnico rt = Funcionario.buscarPorTipo(funcionarios, ResponsavelTecnico.class);

        if (rt == null) {
            throw new IllegalArgumentException("Nenhum responsável técnico cadastrado.");
        }

        if (tipo == 1) {
            return new Consulta(paciente, medico, rt, especialidade);
        } else if (tipo == 2) {
            Enfermeiro enf = Funcionario.buscarPorTipo(funcionarios, Enfermeiro.class);
            Anestesista anest = Funcionario.buscarPorTipo(funcionarios, Anestesista.class);

            if (enf == null || anest == null) {
                throw new IllegalArgumentException(
                        "É necessário cadastrar um enfermeiro e um anestesista.");
            }
            return new ProcedimentoEstetico(paciente, medico, rt, enf, anest, especialidade);
        } else {
            Enfermeiro enf = Funcionario.buscarPorTipo(funcionarios, Enfermeiro.class);
            Anestesista anest = Funcionario.buscarPorTipo(funcionarios, Anestesista.class);

            if (enf == null || anest == null) {
                throw new IllegalArgumentException(
                        "É necessário cadastrar um enfermeiro e um anestesista.");
            }
            return new ProcedimentoCirurgico(paciente, medico, rt, anest, enf, especialidade);
        }
    }
}
