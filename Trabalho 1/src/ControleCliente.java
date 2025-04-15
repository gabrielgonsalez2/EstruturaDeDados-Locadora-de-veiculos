import java.util.Scanner;

public class ControleCliente {
    private LDE listaClientes = new LDE();
    private Scanner sc = new Scanner(System.in); 

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
   
    public void removerCliente(LDE listaClientes) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o CPF do cliente a ser removido: ");
        String cpf = sc.nextLine();
        Cliente cliente = buscarPorCpf(listaClientes, cpf);

        if (cliente != null) {
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
}
public void listarClientesInicio(LDE listaClientes) {
    listaClientes.imprimeLista();
}

public void listarClientesFim(LDE listaClientes) {
    listaClientes.imprimeReverso();
}
