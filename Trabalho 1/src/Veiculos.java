public class Veiculos {
    private String placa;
    private final String modelo;
    private final String marca;
    private final int ano;
    private int potencia;
    private final int numeroLugares;
    private final Categoria categoria;

    public Veiculos(String placa, String modelo, String marca, int ano, int potencia, int numeroLugares, Categoria categoria) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.potencia = potencia;
        this.numeroLugares = numeroLugares;
        this.categoria = categoria;
        //adiciona o veiculo recem criado na lista da categoria
        this.categoria.listaVeiculosNaCategoria.insereInicio(this);
    }

    public void incluirVeiculo(Veiculos veiculo){

    }

    public void editarVeiculo(Veiculos veiculo){

    }

    public void excluirVeiculo(Veiculos veiculo){

    }

    public void listarVeiculo(Veiculos veiculo){

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

    public String getMarca() {
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

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", ano='" + ano + '\'' +
                ", potencia='" + potencia + '\'' +
                ", categoria='" + this.categoria.getNome() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object outro) {
        //qualquer coisa é diferente de NULL
        if (outro == null) {
            return false;
        }
        //propriedade REFLEXIVA
        if (this == outro) {
            return true;
        }
        //objetos de classes diferentes nunca são iguais
        if (this.getClass() != outro.getClass()) {
            return false;
        }
        //conversão explícita para acessar os atributos do outro
        Veiculos outroVeiculo = (Veiculos) outro;
        //verifica se todos os atributos são iguais
        return this.placa.equals(outroVeiculo.placa)
                && this.modelo.equals(outroVeiculo.modelo)
                && this.marca.equals(outroVeiculo.marca)
                && this.ano == outroVeiculo.ano
                && this.potencia == outroVeiculo.potencia
                && this.numeroLugares == outroVeiculo.numeroLugares
                && this.categoria.equals(outroVeiculo.categoria);

    }
}
