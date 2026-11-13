import java.util.Scanner;
/**
     * Exibe o menu de opções para o usuário e retorna a opção escolhida.
     *
     * @return A opção escolhida pelo usuário.
     */
public class menu {
    

    public int exibirMenu() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Menu de Opções ===");
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
