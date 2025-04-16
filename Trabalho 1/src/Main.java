import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inicializar listas principais do sistema
        ListaLocacoes listaLocacoes = new ListaLocacoes();

        // Carregar dados de arquivos CSV na ordem correta
        Categoria.carregarCategoriasCSV("Trabalho 1/src/Data/Categorias.csv");
        Veiculos.carregarVeiculosCSV("Trabalho 1/src/Data/veiculos.csv");
        Cliente.carregarClientesCSV("Trabalho 1/src/Data/clientes.csv");
        listaLocacoes.carregarLocacoesDeCSV("Trabalho 1/src/Data/locacoes.csv", Cliente.listaClientes, Veiculos.listaVeiculos);

        // Menu principal do sistema
        int opcao;
        do {
            System.out.println("\n========= Sistema Locadora =========");
            System.out.println("1 - Gerenciar Clientes");
            System.out.println("2 - Gerenciar Veículos");
            System.out.println("3 - Gerenciar Categorias");
            System.out.println("4 - Gerenciar Locações");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    MenuCliente.exibirMenu(Cliente.listaClientes);
                    break;
                case 2:
                    MenuVeiculos.exibirMenu();
                    break;
                case 3:
                    MenuCategoria.exibirMenu();
                    break;
                case 4:
                    MenuLocacoes.exibirMenu(Cliente.listaClientes, Veiculos.listaVeiculos, listaLocacoes);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
        //  Salva os dados nos arquivos CSV
        Categoria.salvarCategoriasCSV("Trabalho 1/src/Data/categorias.csv");
        Veiculos.salvarVeiculosCSV("Trabalho 1/src/Data/veiculos.csv");
        listaLocacoes.salvarLocacoesCSV("Trabalho 1/src/Data/locacoes.csv");
        Cliente.salvarClientesCSV("Trabalho 1/src/Data/clientes.csv");
        sc.close();
    }
}