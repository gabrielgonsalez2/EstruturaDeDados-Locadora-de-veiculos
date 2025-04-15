import java.util.Scanner;

public class MenuCategoria {
    private static Scanner sc = new Scanner(System.in);

    public static void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=========== Menu Cliente ============");
            System.out.println("1 - Cadastrar Categoria");
            System.out.println("2 - Listar Categorias");
            System.out.println("3 - Editar Categoria");
            System.out.println("4 - Remover Categoria");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    Categoria.incluirCategoria();
                    break;
                case 2:
                    Categoria.listarCategoria();
                    break;
                case 3:
                    Categoria.editarCategoria();
                    break;
                case 4:
                    Categoria.excluirCategoria();
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
