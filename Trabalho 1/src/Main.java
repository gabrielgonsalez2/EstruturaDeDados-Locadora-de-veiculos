/**
 * @author Gabriel Gonsalez
 * @author Lucie Grillo
 * @author Graziela Espindola
 */

import java.util.Scanner;
import Classes.Categoria;
import Classes.Cliente;
import Classes.ListaLocacoes;
import Classes.Veiculos;
import Menus.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inicializar listas principais do sistema
        ListaLocacoes listaLocacoes = new ListaLocacoes();

        // Carregar dados de arquivos CSV na ordem correta.
        Categoria.carregarCategoriasCSV("src/Data/Categorias.csv");
        Veiculos.carregarVeiculosCSV("src/Data/veiculos.csv");
        Cliente.carregarClientesCSV("src/Data/clientes.csv");
        listaLocacoes.carregarLocacoesDeCSV("src/Data/locacoes.csv", Cliente.listaClientes, Veiculos.listaVeiculos);

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
        Categoria.salvarCategoriasCSV("src/Data/categorias.csv");
        Veiculos.salvarVeiculosCSV("src/Data/veiculos.csv");
        listaLocacoes.salvarLocacoesCSV("src/Data/locacoes.csv");
        Cliente.salvarClientesCSV("src/Data/clientes.csv");
        sc.close();
    }
}