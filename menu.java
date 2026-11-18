import java.util.Scanner;

/**
 * Exibe as opções disponíveis para interação com o sistema hospitalar.
 */
public class menu {
    

    /**
     * Exibe as opções do sistema e lê a opção escolhida pelo usuário.
     * @return número da opção escolhida pelo usuário.
     */
    public int exibirMenu() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== HOSPITAL ===");
        System.out.println("1. Agendar Procedimento");
        System.out.println("2. Consultar Registros (Paciente)");
        System.out.println("3. Liberar Procedimento (Responsável Técnico)");
        System.out.println("4. Dar Alta Médica (Procedimento Cirúrgico)");
        System.out.println("5. Registrar Saída do Paciente (Procedimento Cirúrgico)");
        System.out.println("6. Sair");

        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        return opcao;

    }







}
