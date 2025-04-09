public class Veiculos {
    String placa;
    String modelo;
    String marca;
    int ano;
    int potencia;
    int numeroLugares;
    Categoria categoria = new Categoria();

    public Veiculos(String placa, String modelo, String marca, int ano, int potencia, int numeroLugares) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.potencia = potencia;
        this.numeroLugares = numeroLugares;
    }
}
