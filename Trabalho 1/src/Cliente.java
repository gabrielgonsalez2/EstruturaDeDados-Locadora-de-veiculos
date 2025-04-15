import java.util.Scanner;

public class Cliente {
    private String nome;
    private String cpf;
    private String cnh;
    private String telefone;

    public Cliente(String nome, String cpf, String cnh, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
        this.telefone = telefone;
    }

    // Métodos 
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

    public static void removerCliente(LDE listaClientes) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o CPF do cliente a ser removido: ");
        String cpf = sc.nextLine();
        Cliente cliente = buscarPorCpf(listaClientes, cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        if (listaClientes.remove(cliente)) {
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Erro ao remover cliente.");
        }
    }

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

    public static void listarClientesInicio(LDE listaClientes) {
        System.out.println("\n====== LISTA DE CLIENTES (Início -> Fim) ======");
        listaClientes.imprimeLista();
    }

    public static void listarClientesFim(LDE listaClientes) {
        System.out.println("\n====== LISTA DE CLIENTES (Fim -> Início) ======");
        listaClientes.imprimeReverso();
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