import java.util.*;

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

    public void cadastrarCliente(LDE listaClientes) {
        Scanner sc = new Scanner(System.in);
        System.out.println("========= Cadastro de Cliente =========");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
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
    
            if (cliente != null) {
                System.out.print("Novo nome: ");
                cliente.setNome(sc.nextLine());
                System.out.print("Nova CNH: ");
                cliente.setCnh(sc.nextLine());
                System.out.print("Novo telefone: ");
                cliente.setTelefone(sc.nextLine());
                System.out.println("Dados atualizados com sucesso!");
            } else {
                System.out.println("Cliente não encontrado.");
            }
        }
    }
    
    public void removerCliente(LDE listaClientes) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o CPF do cliente a ser removido: ");
        String cpf = sc.nextLine();
        Cliente cliente = buscarPorCpf(listaClientes, cpf);

        if (cliente != null) {
            // Aqui você deveria verificar se o cliente tem locações atreladas.
            listaClientes.remove(cliente);
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
    public static Cliente buscarPorCpf(LDE lista, String cpf) {
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

    public String getNome() { 
        return nome; }

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

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cnh='" + cnh + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
