import java.util.*;

public class Veiculos {
    private String placa;
    private String modelo;
    private String marca;
    private int ano;
    private int potencia;
    private int numeroLugares;
    private Categoria categoria;
    private static LDE listaVeiculos = new LDE();

    public Veiculos(String placa, String modelo, String marca, int ano, int potencia, int numeroLugares, Categoria categoria) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.potencia = potencia;
        this.numeroLugares = numeroLugares;
        this.categoria = categoria;
        //adiciona o veiculo recem criado na lista da categoria
        this.categoria.listaVeiculosNaCategoria.insereFim(this);
        listaVeiculos.insereFim(this);
    }

    public static void incluirVeiculo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a placa: ");
        String placa = scanner.nextLine();

        if (listaVeiculos.procurarPorPlaca(placa) == null) {

            System.out.print("Digite o modelo: ");
            String modelo = scanner.nextLine();

            System.out.print("Digite a marca: ");
            String marca = scanner.nextLine();

            System.out.print("Digite o ano: ");
            int ano = Integer.parseInt(scanner.nextLine());

            System.out.print("Digite a potência: ");
            int potencia = Integer.parseInt(scanner.nextLine());

            System.out.print("Digite o número de lugares: ");
            int numeroLugares = Integer.parseInt(scanner.nextLine());

            Categoria.listarCategoria();
            System.out.print("Digite o nome da categoria: ");
            int identificadorCategoria = Integer.parseInt(scanner.nextLine());

            Categoria categoria = Categoria.procurarCategoria(identificadorCategoria);
            if (categoria == null) {
                System.out.println("Categoria não encontrada.");
                return;
            }

            Veiculos veiculo = new Veiculos(placa, modelo, marca, ano, potencia, numeroLugares, categoria);
            System.out.println("Veículo adicionado com sucesso!");
        } else{
            System.out.println("Ja existe um veiculo com este placa.");
        }
    }

    public static void editarVeiculo(){
        Scanner scanner = new Scanner(System.in);
        listarVeiculos();
        System.out.print("Digite a placa do veiculo que deseja editar: ");
        String placa = scanner.nextLine();

        Veiculos veiculo = listaVeiculos.procurarPorPlaca(placa);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }
        System.out.println(veiculo);

        System.out.print("Digite a nova placa: ");
        veiculo.placa = scanner.nextLine();

        System.out.print("Digite o novo modelo: ");
        veiculo.modelo = scanner.nextLine();

        System.out.print("Digite a nova marca: ");
        veiculo.marca = scanner.nextLine();

        System.out.print("Digite o novo ano: ");
        veiculo.ano = Integer.parseInt(scanner.nextLine());

        System.out.print("Digite a nova potência: ");
        veiculo.potencia = Integer.parseInt(scanner.nextLine());

        System.out.print("Digite o novo número de lugares: ");
        veiculo.numeroLugares = Integer.parseInt(scanner.nextLine());

        Categoria.listarCategoria();
        System.out.print("Digite o nome da categoria: ");
        int identificadorCategoria = Integer.parseInt(scanner.nextLine());

        Categoria categoria = Categoria.procurarCategoria(identificadorCategoria);
        if (categoria == null) {
            System.out.println("Categoria não encontrada.");
        } else{
            veiculo.categoria = categoria;
        }


    }

    public static void excluirVeiculo(){
        Scanner scanner = new Scanner(System.in);

        listarVeiculos();
        System.out.print("Digite a placa do veiculo que deseja excluir: ");
        String placa = scanner.nextLine();

        Veiculos veiculo = listaVeiculos.procurarPorPlaca(placa);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }

        listaVeiculos.imprimeLista();
        System.out.println("Certeza que deseja excluir? (s/n)");
        String escolha = scanner.nextLine();
        if (escolha.equals("s")) {
            System.out.println(veiculo.getPlaca() + "foi excluido com sucesso!");
            listaVeiculos.remove(veiculo);
        }
    }

    public static void listarVeiculos(){
        listaVeiculos.imprimeLista();
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

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", ano='" + ano + '\'' +
                ", potencia='" + potencia + '\'' +
                ", número de lugares='" + numeroLugares + '\'' +
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
        //verifica se as placas são iguais
        return this.placa.equals(outroVeiculo.placa);
    }
}