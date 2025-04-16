package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import Utils.LDE;
import Utils.Noh;



public class Cliente {
    // Atributos do cliente
    private String nome;
    private String cpf;
    private String cnh;
    private String telefone;

    // Esta lista guarda todos os clientes cadastrados
    public static LDE listaClientes = new LDE(); 

    public Cliente(String nome, String cpf, String cnh, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
        this.telefone = telefone;
    }

    // Método para cadastrar um novo cliente
    public static void cadastrarCliente(LDE listaClientes) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n========= CADASTRO DE CLIENTE =========");
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        if (buscarPorCpf(listaClientes, cpf) != null) {
            System.out.println("Erro: Já existe um cliente cadastrado com este CPF!");
            return;
        }

        System.out.print("CNH: ");
        String cnh = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        Cliente novoCliente = new Cliente(nome, cpf, cnh, telefone);
        listaClientes.insereFim(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    // Método para editar um cliente existente
    public static void editarCliente(LDE listaClientes) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o CPF do cliente que deseja editar: ");
        String cpf = sc.nextLine();
        Cliente cliente = buscarPorCpf(listaClientes, cpf);

    if (cliente == null) {
        System.out.println("Cliente não encontrado.");
        return;
    }

        System.out.println("Editando cliente: " + cliente.getNome());
        System.out.print("Novo nome (" + cliente.getNome() + "): ");
        cliente.setNome(sc.nextLine());

        System.out.print("Nova CNH (" + cliente.getCnh() + "): ");
        cliente.setCnh(sc.nextLine());

        System.out.print("Novo telefone (" + cliente.getTelefone() + "): ");
        cliente.setTelefone(sc.nextLine());
        
        System.out.println("Dados atualizados com sucesso!");
    }

    // Método para remover um cliente
    public static void removerCliente(LDE listaClientes) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o CPF do cliente a ser removido: ");
        String cpf = sc.nextLine();
        Cliente cliente = buscarPorCpf(listaClientes, cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        if (Locacao.listaLocacoes.procurarPorCnhLocacao(cliente.cnh) != null) {
            System.out.println("Erro: Cliente possui locação ativa e não pode ser removido.");
            return;
        }

        if (listaClientes.remove(cliente)) {
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Erro ao remover cliente.");
        }
    }

    // Método para buscar um cliente pelo CPF
    public static Cliente buscarPorCpf(LDE lista, String cpf) {
        if (lista == null || cpf == null) return null;

        Noh atual = lista.getInicio();
        while (atual != null) {
            Object obj = atual.getInfo();
            if (obj instanceof Cliente) {
                Cliente cliente = (Cliente) obj;
                if (cliente.getCpf().equals(cpf)) {
                    return cliente;
                }
            }
            atual = atual.getProx();
        }
        return null;
    }

    // Método para listar todos os clientes no inicio ao fim
    public static void listarClientesInicio(LDE listaClientes) {
        System.out.println("\n====== LISTA DE CLIENTES (Início ao Fim) ======");
        if (listaClientes.getInicio() == null) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
        listaClientes.imprimeLista();
        }
    }
    // Método para listar todos os clientes no fim ao inicio
    public static void listarClientesFim(LDE listaClientes) {
        System.out.println("\n====== LISTA DE CLIENTES (Fim ao Início) ======");
        if (listaClientes.getInicio() == null) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
        listaClientes.imprimeReverso();
    }
}

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public String getCpf() {
         return cpf;
    }
    public String getCnh() {
         return cnh; 
    }
    public String getTelefone() {
         return telefone; 
    }
    public void setNome(String nome) { 
        this.nome = nome;
    }
    public void setCpf(String cpf) { 
        this.cpf = cpf;
    }
    public void setCnh(String cnh) { 
            this.cnh = cnh;
    }
    public void setTelefone(String telefone) { 
            this.telefone = telefone;
    }

    // Método para carregar clientes de um arquivo CSV
public static void carregarClientesCSV(String caminhoArquivo) {
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
            if (dados.length != 4) {
                System.out.println("Linha inválida: " + linha);
                continue;
            }

            String nome = dados[0].trim();
            String cpf = dados[1].trim();
            String cnh = dados[2].trim();
            String telefone = dados[3].trim();

            if (buscarPorCpf(listaClientes, cpf) == null) {
                Cliente cliente = new Cliente(nome, cpf, cnh, telefone);
                listaClientes.insereFim(cliente);
            } else {
                System.out.println("Cliente já existente: " + cpf);
            }
        }

        System.out.println("Carregamento de clientes finalizado.");
    } catch (IOException e) {
        System.out.println("Erro ao ler o arquivo de clientes: " + e.getMessage());
    }
}
    // Método para salvar clientes de um arquivo CSV
   public static void salvarClientesCSV(String caminhoArquivo) {
    try (PrintWriter writer = new PrintWriter(caminhoArquivo)) {
        writer.println("nome;cpf;cnh;telefone");
        Noh atual = listaClientes.getInicio();
        while (atual != null) {
            Cliente cliente = (Cliente) atual.getInfo();
            writer.println(
                    cliente.getNome() + ";" +
                    cliente.getCpf() + ";" +
                    cliente.getCnh() + ";" +
                    cliente.getTelefone()
            );
            atual = atual.getProx();
        }
        System.out.println("Clientes salvos com sucesso em: " + caminhoArquivo);
    } catch (IOException e) {
        System.out.println("Erro ao salvar clientes: " + e.getMessage());
    }
}

    // Métodos para comparação de objetos
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;
        return cpf.equals(cliente.cpf);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cnh='" + cnh + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}