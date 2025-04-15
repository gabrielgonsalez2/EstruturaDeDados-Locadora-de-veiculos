import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
        Categoria.incluirCategoria();
        Veiculos.incluirVeiculo();
        Veiculos.editarVeiculo();
        Veiculos.excluirVeiculo();
        Categoria.editarCategoria();
        Categoria.excluirCategoria();
        Categoria.listarCategoria();
        Veiculos.listarVeiculos();

        //menu principal
        int opcao;
        do {
            System.out.println("\n========= Sistema Locadora =========");
            System.out.println("1 - Gerenciar Clientes");
            System.out.println("2 - Gerenciar Veículos");
            System.out.println("3 - Gerenciar Categorias");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    MenuCliente.exibirMenu(listaClientes);
                    break;
                case 2:
                    // Aqui você pode chamar um MenuVeiculo
                    System.out.println("Menu de veículos ainda não implementado.");
                    break;
                case 3:
                    // Aqui você pode chamar um MenuCategoria
                    System.out.println("Menu de categorias ainda não implementado.");
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}