import java.util.Scanner;

public class MenuCliente {
    private static Scanner sc = new Scanner(System.in);

    public static void exibirMenu(LDE listaClientes) {
        int opcao;
        do {
            System.out.println("\n=========== Menu Cliente ============");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Editar Cliente");
            System.out.println("4 - Remover Cliente");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1: 
                cadastrarCliente(listaClientes);
                case 2:
                listaClientes.imprimeLista();
                case 3: 
                editarCliente(listaClientes);
                case 4:
                removerCliente(listaClientes);
                case 0:
                System.out.println("Voltando...");
                default:
                System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

  
}
