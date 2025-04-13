import java.util.Scanner;

public class Categoria {
    private String nome;
    private int identificador;
    LDE listaVeiculosNaCategoria;
    private static LDE listaCategoria = new LDE();

    public Categoria(String nome) {
        this.nome = nome;
        this.identificador = listaCategoria.tamanho() + 1;
        this.listaVeiculosNaCategoria = new LDE();
        listaCategoria.insereFim(this);

    }

    //Lista os veiculos vinculados a categoria
    public void listarVeiculos(){
        this.listaVeiculosNaCategoria.imprimeLista();
    }

    public static Categoria procurarCategoria(int id){
        return (Categoria) listaCategoria.procurarPorId(id);
    }

    public static void incluirCategoria(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da categoria: ");
        String nome = scanner.nextLine();

        Categoria categoria = new Categoria(nome);

        System.out.println("Categoria incluida com sucesso!");
    }

    public void editarCategoria(Categoria cat){

    }

    public void excluirCategoria(Categoria cat){

    }

    public static void listarCategoria(){
        listaCategoria.imprimeLista();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdentificador() {
        return identificador;
    }
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nome= '" + nome + '\'' +
                ", identificador= '" + identificador+ '\'' +
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
        Categoria outraCategoria = (Categoria) outro;
        //verifica se todos os atributos são iguais
        return this.nome.equals(outraCategoria.nome)
                && this.identificador == outraCategoria.identificador;
    }
}
