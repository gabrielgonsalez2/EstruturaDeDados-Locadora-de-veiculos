import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicializar listas
        LDE listaVeiculos = new LDE();
        LDE listaClientes = new LDE();
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
    }
}