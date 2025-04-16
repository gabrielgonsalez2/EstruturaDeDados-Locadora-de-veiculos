import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inicializar listas principais do sistema
        LDE listaVeiculos = new LDE();
        LDE listaCategorias = new LDE();
        LDE listaClientes = new LDE();
        ListaLocacoes listaLocacoes = new ListaLocacoes();

        // Dados de teste iniciais para categorias e veículos
        Categoria esportivo = new Categoria("Esportivo", 1010);
        Categoria offRoad = new Categoria("Off Road", 1011);
        Veiculos carro1 = new Veiculos("1222g", "Cayenne", "Porsche", 2025, 493, 5, esportivo);
        Veiculos carro2 = new Veiculos("123h3", "Civic", "Honda", 2003, 222, 5, esportivo);
        listaCategorias.insereInicio(esportivo);
        listaCategorias.insereInicio(offRoad);
        // Adicionar os veículos à lista
        listaVeiculos.insereInicio(carro1);
        listaVeiculos.insereInicio(carro2);

        // Adicionar um cliente de teste para o carregamento de locações funcionar
        Cliente clienteTeste = new Cliente("João da Silva", "02408925469", "5482156", "(55)3325-2525");
        listaClientes.insereFim(clienteTeste);

        // Carregar dados de arquivos CSV na ordem correta
        listaLocacoes.carregarLocacoesDeCSV("Trabalho 1/locacoes.csv", listaClientes, listaVeiculos);

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
                    MenuCliente.exibirMenu(listaClientes);
                    break;
                case 2:
                    MenuVeiculos.exibirMenu();
                    break;
                case 3:
                    MenuCategoria.exibirMenu();
                    break;
                case 4:
                    MenuLocacoes.exibirMenu(listaClientes, listaVeiculos, listaLocacoes);
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