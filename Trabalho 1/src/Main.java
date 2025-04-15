import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicializar listas
        LDE listaVeiculos = new LDE();
        LDE listaCategorias = new LDE();
        LDE listaClientes = new LDE();

        // Dados de teste originais
        Categoria esportivo = new Categoria("Esportivo");
        Categoria offRoad = new Categoria("Off Road");
        Veiculos carro1 = new Veiculos("1222g", "Cayenne", "Porche", 2025, 493, 5, esportivo);
        Veiculos carro2 = new Veiculos("123h3", "Civic", "Honda", 2003, 222, 5, esportivo);
        listaCategorias.insereInicio(esportivo);
        listaCategorias.insereInicio(offRoad);
        listaVeiculos.insereFim(carro1);
        listaVeiculos.insereFim(carro2);

        // Menu inicial
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=========== Menu Inicial ============");
            System.out.println("1 - Gerenciar Categorias e Veículos");
            System.out.println("2 - Gerenciar Locações");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    // Bloco original do colega
                    Categoria.incluirCategoria();
                    Veiculos.incluirVeiculo();
                    Veiculos.editarVeiculo();
                    Veiculos.excluirVeiculo();
                    Categoria.editarCategoria();
                    Categoria.excluirCategoria();
                    Categoria.listarCategoria();
                    Veiculos.listarVeiculos();
                    break;
                case 2:
                    // Seu módulo de locações
                    MenuLocacoes.exibirMenu(listaClientes, listaVeiculos);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}