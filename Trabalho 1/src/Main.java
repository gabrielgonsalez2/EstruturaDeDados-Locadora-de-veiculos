public class Main {
    public static void main(String[] args) {
        LDE listaVeiculos = new LDE();
        LDE listaCategorias = new LDE();
Categoria esportivo = new Categoria("Esportivo", 1);
        Veiculos carro1 = new Veiculos("1222g", "Cayenne" ,"Porche", 2025, 493, 5, esportivo);
        Veiculos carro2 = new Veiculos("123h3", "Civic", "Honda", 2003, 222, 5, esportivo);
        listaVeiculos.insereInicio(carro1);
        listaVeiculos.insereFim(carro2);
        listaCategorias.insereInicio(esportivo);
        listaVeiculos.imprimeLista();
        listaCategorias.imprimeLista();
    }
}


