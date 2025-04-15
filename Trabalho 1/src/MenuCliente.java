import java.util.Scanner;

public class MenuCliente {
    private static Scanner sc = new Scanner(System.in);

    public static void exibirMenu(LDE listaClientes) {
        int opcao;
        do {
            System.out.println("\n=========== Menu Cliente ============");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes (início → fim)");
            System.out.println("3 - Editar Cliente");
            System.out.println("4 - Remover Cliente");
            System.out.println("5 - Listar Clientes (fim → início)");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Consumir quebra de linha
        
            switch (opcao) {
                case 1:
                    Cliente.cadastrarCliente(listaClientes);
                    break;
                case 2:
                    listaClientes.imprimeLista();
                    break;
                case 3:
                    Cliente.editarCliente(listaClientes);
                    break;
                case 4:
                    Cliente.removerCliente(listaClientes);
                    break;
                case 5:
                    listaClientes.imprimeReverso();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}
