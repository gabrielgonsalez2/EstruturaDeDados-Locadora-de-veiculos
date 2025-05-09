package Classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import Utils.LDE;
import Utils.Noh;

public class Categoria {
    private String nome;
    private int identificador;
    // Esta lista guarda os veiculos que forem associados a ela
    LDE listaVeiculosNaCategoria;
    // Esta lista guarda todas as categorias criadas
    static LDE listaCategoria = new LDE();

    public Categoria(String nome, int identificador) {
        this.nome = nome;
        this.identificador = identificador;
        this.listaVeiculosNaCategoria = new LDE();
        // Logo após a criação da cateegoria ela ja é adicionada a lista de categorias
        listaCategoria.insereFim(this);
    }

    // Lista os veiculos vinculados a categoria
    public void listarVeiculos() {
        this.listaVeiculosNaCategoria.imprimeLista();
    }

    // Este metodo serve para evitar uso direto de listaCategoria
    public static Categoria procurarCategoria(int id) {
        return listaCategoria.procurarPorId(id);
    }

    public static void incluirCategoria() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da categoria: ");
        String nome = scanner.nextLine();

        if (listaCategoria.procurarPorNome(nome) == null) {
            System.out.print("Digite o identificador da categoria: ");
            int identificador = scanner.nextInt();

            if (listaCategoria.procurarPorId(identificador) == null) {
                Categoria categoria = new Categoria(nome, identificador);
                System.out.println("Categoria incluida com sucesso!");
            } else {
                System.out.println("Já existe uma categoria com este identificador.");
            }
        } else {
            System.out.println("Já existe uma categoria com este nome.");
        }
    }

    public static void editarCategoria() {
        Scanner scanner = new Scanner(System.in);
        listaCategoria.imprimeLista();

        System.out.print("Digite o identificador da categoria que deseja editar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Categoria categoria = listaCategoria.procurarPorId(id);

        if (categoria == null) {
            System.out.println("Categoria não encontrada.");
            return;
        }

        System.out.print("Digite o novo nome da categoria: ");
        String novoNome = scanner.nextLine();

        if (listaCategoria.procurarPorNome(novoNome) == null) {
            categoria.nome = novoNome;

            System.out.print("Digite o identificador da categoria: ");
            int novoIdentificador = scanner.nextInt();

            if (listaCategoria.procurarPorId(novoIdentificador) == null) {
                categoria.identificador = novoIdentificador;
                System.out.println("Categoria atualizada com sucesso!");
            } else {
                System.out.println("Já existe uma categoria com este identificador.");
            }
        } else {
            System.out.println("Já existe uma categoria com este nome.");
        }
    }

    public static void excluirCategoria() {
        Scanner scanner = new Scanner(System.in);
        listaCategoria.imprimeLista();

        System.out.print("Digite o id da categoria que deseja excluir: ");
        int id = Integer.parseInt(scanner.nextLine());
        Categoria categoria = listaCategoria.procurarPorId(id);

        if (categoria == null) {
            System.out.println("Categoria não encontrada.");
            return;
        }

        if (categoria.listaVeiculosNaCategoria != null) {
            System.out.println("Esta categoria possui veiculos vinculados a ela.");
            return;
        }

        System.out.println("Certeza que deseja excluir? (s/n)");
        String escolha = scanner.nextLine();

        if (escolha.equals("s")) {
            System.out.println(categoria.getNome() + "foi excluido com sucesso!");
            listaCategoria.remove(categoria);
        }
    }

    public static void listarCategoria() {
        System.out.print("Listar do início para o fim? (s/n): ");
        Scanner scanner = new Scanner(System.in);
        String escolha = scanner.nextLine();
        if (escolha.equals("s")) {
            System.out.println("Exibindo do início para o fim:");
            listaCategoria.imprimeLista();
        } else if (escolha.equals("n")) {
            System.out.println("Exibindo do fim para o início:");
            listaCategoria.imprimeReverso();
        }
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

    public static void carregarCategoriasCSV(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {
                // Ignora a primeira linha se for cabeçalho
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                String[] dados = linha.split(";");
                if (dados.length != 2) {
                    System.out.println("Linha inválida: " + linha);
                    continue;
                }

                int identificador = Integer.parseInt(dados[0].trim());
                String nome = dados[1].trim();

                if (listaCategoria.procurarPorId(identificador) == null &&
                        listaCategoria.procurarPorNome(nome) == null) {

                    Categoria categoria = new Categoria(nome, identificador);
                } else {
                    System.out.println("Categoria já existente, ignorando: " + nome);
                }
            }

            System.out.println("Carregamento de categorias finalizado.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public static void salvarCategoriasCSV(String caminhoArquivo) {
        try (PrintWriter writer = new PrintWriter(caminhoArquivo)) {
            // Cabeçalho
            writer.println("identificador;nome");

            // Percorrer a lista de categorias e salvar
            Noh atual = listaCategoria.getInicio();
            while (atual != null) {
                Categoria categoria = (Categoria) atual.getInfo();
                writer.println(categoria.getIdentificador() + ";" + categoria.getNome());
                atual = atual.getProx();
            }

            System.out.println("Categorias salvas com sucesso em: " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar categorias: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nome= '" + nome + '\'' +
                ", identificador= '" + identificador + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object outro) {
        // qualquer coisa é diferente de NULL
        if (outro == null) return false;

        // propriedade REFLEXIVA
        if (this == outro) return true;

        // objetos de classes diferentes nunca são iguais
        if (this.getClass() != outro.getClass()) return false;

        // conversão explícita para acessar os atributos do outro
        Categoria outraCategoria = (Categoria) outro;

        // verifica se todos os atributos são iguais
        return this.nome.equals(outraCategoria.nome) &&
                this.identificador == outraCategoria.identificador;
    }
}
