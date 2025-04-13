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
        if (listaCategoria.procurarPorNome(nome) == null) {
            Categoria categoria = new Categoria(nome);

            System.out.println("Categoria incluida com sucesso!");
        } else{
            System.out.println("Esta categoria já existe");
        }
    }

    public static void editarCategoria(){
        Scanner scanner = new Scanner(System.in);
        listarCategoria();

        System.out.print("Digite o id da categoria que deseja editar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Categoria categoria = listaCategoria.procurarPorId(id);

        if (categoria == null) {
            System.out.println("Categoria não encontrada.");
            return;
        }

        System.out.print("Digite o novo nome da categoria: ");
        categoria.nome = scanner.nextLine();

        System.out.println("Categoria incluida com sucesso!");

    }

    public static void excluirCategoria(){
        Scanner scanner = new Scanner(System.in);

        listarCategoria();
        System.out.print("Digite o id da categoria que deseja excluir: ");
        int id = Integer.parseInt(scanner.nextLine());

        Categoria categoria = listaCategoria.procurarPorId(id);

        if (categoria == null) {
            System.out.println("Categoria não encontrada.");
            return;
        }

        System.out.println("Certeza que deseja excluir? (s/n)");
        String escolha = scanner.nextLine();
        if (escolha.equals("s")) {
            System.out.println(categoria.getNome() + "foi excluido com sucesso!");
            listaCategoria.remove(categoria);
        }
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
