public class Main {
    public static void main(String[] args) {
        LDE listaVeiculos = new LDE();
        LDE listaCategorias = new LDE();
        Categoria esportivo = new Categoria("Esportivo", 1);
        Categoria offRoad = new Categoria("Off Road", 2);
        Veiculos carro1 = new Veiculos("1222g", "Cayenne" ,"Porche", 2025, 493, 5, esportivo);
        Veiculos carro2 = new Veiculos("123h3", "Civic", "Honda", 2003, 222, 5, esportivo);
        listaCategorias.insereInicio(esportivo);
        listaCategorias.insereInicio(offRoad);
        listaCategorias.imprimeLista();

        esportivo.listarVeiculos();
    }
}


