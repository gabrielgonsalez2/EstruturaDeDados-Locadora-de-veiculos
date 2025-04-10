public class Veiculos {
    private String placa;
    private final String modelo;
    private final String marca;
    private final int ano;
    private int potencia;
    private final int numeroLugares;
    private Categoria categoria;

    public Veiculos(String placa, String modelo, String marca, int ano, int potencia, int numeroLugares) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.potencia = potencia;
        this.numeroLugares = numeroLugares;
    }



    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getModelo() {
        return modelo;
    }
    public String getMarca(){
        return marca;
    }
    public int getAno() {
        return ano;
    }
    public int getPotencia() {
        return potencia;
    }
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    public int getNumeroLugares() {
        return numeroLugares;
    }
}
