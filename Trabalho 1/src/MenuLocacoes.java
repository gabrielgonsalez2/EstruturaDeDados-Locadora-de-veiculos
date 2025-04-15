import java.util.Scanner;

public class MenuLocacoes {
    private static Scanner scanner = new Scanner(System.in);

    public static void exibirMenu(LDE listaClientes, LDE listaVeiculos) {
        ListaLocacoes listaLocacoes = new ListaLocacoes();
        int opcao;

        do {
            System.out.println("\n=========== Menu de Locações ============");
            System.out.println("1 - Locar veículo");
            System.out.println("2 - Encerrar locação");
            System.out.println("3 - Listar locações ativas");
            System.out.println("4 - Consultar veículos disponíveis");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    listaLocacoes.criarLocacao(listaClientes, listaVeiculos);
                    break;
                case 2:
                    listaLocacoes.encerrarLocacao();
                    break;
                case 3:
                    System.out.print("Listar do início para o fim? (s/n): ");
                    boolean inicioParaFim = scanner.nextLine().equalsIgnoreCase("s");
                    listaLocacoes.listarLocacoes(inicioParaFim);
                    break;
                case 4:
                    System.out.println("Filtros (deixe em branco para ignorar):");
                    System.out.print("Potência mínima: ");
                    String potenciaStr = scanner.nextLine();
                    Integer potenciaMin = potenciaStr.isEmpty() ? null : Integer.parseInt(potenciaStr);

                    System.out.print("Número de lugares: ");
                    String lugaresStr = scanner.nextLine();
                    Integer lugares = lugaresStr.isEmpty() ? null : Integer.parseInt(lugaresStr);

                    System.out.print("ID da categoria: ");
                    String categoriaStr = scanner.nextLine();
                    Integer idCategoria = categoriaStr.isEmpty() ? null : Integer.parseInt(categoriaStr);

                    System.out.print("Ordenar por potência crescente? (s/n): ");
                    boolean ordemCrescente = scanner.nextLine().equalsIgnoreCase("s");

                    listaLocacoes.listarVeiculosDisponiveis(listaVeiculos, potenciaMin, lugares, idCategoria, ordemCrescente);
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