import java.util.Scanner;

public class MenuVeiculos {
    private static Scanner sc = new Scanner(System.in);

    public static void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=========== Menu Veiculos ============");
            System.out.println("1 - Cadastrar Veiculo");
            System.out.println("2 - Listar Veiculos");
            System.out.println("3 - Editar Veiculoo");
            System.out.println("4 - Remover Veiculo");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    Veiculos.incluirVeiculo();
                    break;
                case 2:
                    Veiculos.listarVeiculos();
                    break;
                case 3:
                    Veiculos.editarVeiculo();
                    break;
                case 4:
                    Veiculos.excluirVeiculo();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);
    }
}
