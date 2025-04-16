public class Locacao {
    private String cnhCliente;
    private String placaVeiculo;
    private String dataRetirada;
    private String dataDevolucao;
    private double valor;
    static LDE listaLocacoes = new LDE();

    public Locacao(String cnhCliente, String placaVeiculo, String dataRetirada, String dataDevolucao, double valor) {
        this.cnhCliente = cnhCliente;
        this.placaVeiculo = placaVeiculo;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.valor = valor;
        listaLocacoes.insereFim(this);
    }

    public String getCnhCliente() {
        return cnhCliente;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public String getDataRetirada() {
        return dataRetirada;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "cnhCliente='" + cnhCliente + '\'' +
                ", placaVeiculo='" + placaVeiculo + '\'' +
                ", dataRetirada='" + dataRetirada + '\'' +
                ", dataDevolucao='" + dataDevolucao + '\'' +
                ", valor=" + valor +
                '}';
    }

    @Override
    public boolean equals(Object outro) {
        if (outro == null || getClass() != outro.getClass()) return false;
        if (this == outro) return true;
        Locacao outraLocacao = (Locacao) outro;
        return this.placaVeiculo.equals(outraLocacao.placaVeiculo);
    }
}