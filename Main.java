import java.util.ArrayList;
import java.util.Scanner;

/**
 * Inicia a aplicação e coordena o menu e os fluxos do sistema hospitalar.
 */
public class Main {

    /**
     * Inicializa um novo objeto desta classe.
     * @param args argumentos recebidos pela aplicação ao iniciar.
     */
    public static void main(String[] args) {

        // Aqui será guardados todos os pacientes cadastrados.
        ArrayList<Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Paciente("Carlos Silva", "Rua das Flores, 123", "111.222.333-44"));
        pacientes.add(new Paciente("Mariana Souza", "Av. Brasil, 456", "555.666.777-88"));
        pacientes.add(new Paciente("Roberto Oliveira", "Rua Central, 789", "999.000.111-22"));

        // Aqui será guarddo todos os funicionarios cadastrados.
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Medico("Dr. João Mendes", "Rua A, 10", "123.456.789-00", "M001", "15000.00",
                "Centro Cirúrgico", "Médico", "Cirurgia Geral", "senha123"));
        funcionarios.add(new Medico("Dra. Fernanda Costa", "Rua D, 40", "456.789.012-33", "M002", "14500.00",
                "Ambulatório", "Médica", "Cardiologia", "med456"));
        funcionarios.add(new Medico("Dr. Rafael Almeida", "Rua E, 50", "567.890.123-44", "M003", "16000.00", "Estética",
                "Médico", "Dermatologia", "med789"));
        funcionarios.add(new Medico("Dra. Juliana Rocha", "Rua F, 60", "678.901.234-55", "M004", "15200.00",
                "Ortopedia", "Médica", "Ortopedia", "med321"));
        funcionarios.add(new Enfermeiro("Ana Paula", "Rua B, 20", "234.567.890-11", "E001", "5500.00", "Enfermaria",
                "Enfermeira", "COREN-12345", "senha456"));
        funcionarios.add(new Anestesista("Dr. Bruno Martins", "Rua G, 70", "789.012.345-66", "A001", "14000.00",
                "Centro Cirúrgico", "Anestesista", "CRM-54321", "anest123"));
        funcionarios.add(new ResponsavelTecnico("Dra. Patrícia Lima", "Rua H, 80", "890.123.456-77", "RT001",
                "18000.00", "Diretoria Clínica", "Responsável Técnico", "COREN-99999", "rt123"));
        funcionarios.add(new FuncionarioTecnicoAdministrativo("Lucas Ferreira", "Rua C, 30", "345.678.901-22", "T001",
                "3800.00", "Recepção", "Técnico Administrativo", "admin123"));

        // Aqui será guardado todos os procedimentos agendados.
        ArrayList<Procedimento> procedimentosAgendados = new ArrayList<>();

        menu menu = new menu();
        int opcao;

        do {
            opcao = menu.exibirMenu();

            switch (opcao) {
                case 1:
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("=== Digite sua senha ===");
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();

                    Agendador agendadorLogado = null;

                    for (Funcionario funcionario : funcionarios) {
                        if (funcionario instanceof Agendador) {
                            Agendador agendador = (Agendador) funcionario;
                            if (agendador.getSenha().equals(senha)) {
                                agendadorLogado = agendador;
                                System.out.println("Acesso permitido. Bem-vindo(a), " + funcionario.getNome() + "!");
                                break;
                            }
                        }
                    }
                    if (agendadorLogado != null) {
                        try {
                            Procedimento procedimento = Procedimento.cadastrarProcedimento(scanner, pacientes,
                                    funcionarios);
                            agendadorLogado.agendarProcedimento(procedimentosAgendados, procedimento, senha);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro ao agendar: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Acesso negado. Senha incorreta ou usuário não autorizado.");
                    }
                    break;
                case 2:
                    Scanner scannerConsulta = new Scanner(System.in);
                    System.out.println("\n=== Informe o CPF ===");
                    System.out.print("CPF : ");

                    String cpfInformado = scannerConsulta.nextLine();

                    Paciente pacienteEncontrado = null;

                    for (Paciente paciente : pacientes) {
                        if (paciente.getCpf().equals(cpfInformado)) {
                            pacienteEncontrado = paciente;
                            break;
                        }
                    }
                    if (pacienteEncontrado != null) {
                        pacienteEncontrado.consultarRegistros(procedimentosAgendados);
                    } else {
                        System.out.println("Paciente não encontrado.");
                    }

                    break;
                case 3:
                    if (procedimentosAgendados.isEmpty()) {
                        System.out.println("Nenhum procedimento agendado no momento.");
                        break;
                    }
                    Scanner scannerRT = new Scanner(System.in);
                    System.out.println("\n=== Escolha o Procedimento para Liberar (RT) ===");
                    for (int i = 0; i < procedimentosAgendados.size(); i++) {
                        System.out.println(i + " - " + procedimentosAgendados.get(i));
                    }
                    System.out.print("Número do procedimento: ");
                    int idxProcRT = scannerRT.nextInt();

                    ResponsavelTecnico rt = Funcionario.buscarPorTipo(funcionarios, ResponsavelTecnico.class);

                    if (rt == null) {
                        System.out.println("Nenhum responsável técnico cadastrado.");
                        break;
                    }

                    rt.liberarProcedimento(procedimentosAgendados.get(idxProcRT));
                    break;
                case 4:
                    if (procedimentosAgendados.isEmpty()) {
                        System.out.println("Nenhum procedimento agendado no momento.");
                        break;
                    }
                    Scanner scannerAlta = new Scanner(System.in);
                    System.out.println("\n=== Escolha o Procedimento Cirúrgico para Dar Alta ===");
                    for (int i = 0; i < procedimentosAgendados.size(); i++) {
                        if (procedimentosAgendados.get(i) instanceof ProcedimentoCirurgico) {
                            System.out.println(i + " - " + procedimentosAgendados.get(i));
                        }
                    }
                    System.out.print("Número do procedimento cirúrgico: ");
                    int idxCirurgia = scannerAlta.nextInt();

                    System.out.println("\n=== Qual médico está concedendo a alta? ===");
                    for (int i = 0; i < funcionarios.size(); i++) {
                        if (funcionarios.get(i) instanceof Medico) {
                            System.out.println(i + " - " + funcionarios.get(i).getNome());
                        }
                    }
                    System.out.print("Número do médico: ");
                    int idxMedAlta = scannerAlta.nextInt();

                    ProcedimentoCirurgico cirurgiaAlta = (ProcedimentoCirurgico) procedimentosAgendados
                            .get(idxCirurgia);
                    Medico medicoAlta = (Medico) funcionarios.get(idxMedAlta);
                    cirurgiaAlta.darAltaMedica(medicoAlta);
                    break;
                case 5:
                    if (procedimentosAgendados.isEmpty()) {
                        System.out.println("Nenhum procedimento agendado no momento.");
                        break;
                    }
                    Scanner scannerSaida = new Scanner(System.in);
                    System.out.println("\n=== Escolha o Procedimento Cirúrgico para Registrar Saída ===");
                    for (int i = 0; i < procedimentosAgendados.size(); i++) {
                        if (procedimentosAgendados.get(i) instanceof ProcedimentoCirurgico) {
                            System.out.println(i + " - " + procedimentosAgendados.get(i));
                        }
                    }
                    System.out.print("Número do procedimento cirúrgico: ");
                    int idxSaida = scannerSaida.nextInt();

                    ProcedimentoCirurgico cirurgiaSaida = (ProcedimentoCirurgico) procedimentosAgendados.get(idxSaida);
                    cirurgiaSaida.registrarSaidaPaciente();
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);

    }

}
