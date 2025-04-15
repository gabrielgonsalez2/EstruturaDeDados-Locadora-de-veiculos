import java.util.Scanner;

public class ListaLocacoes {
    private LDE locacoes;

    public ListaLocacoes() {
        this.locacoes = new LDE();
    }

    public void criarLocacao(LDE listaClientes, LDE listaVeiculos) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a CNH do cliente: ");
        String cnh = scanner.nextLine();
        
        // Assumindo que LDE terá procurarPorCnh implementado
        Cliente cliente = listaClientes.procurarPorCnh(cnh);
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }
        
        listarVeiculosDisponiveis(listaVeiculos, null, null, null, true);
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
        
        Veiculos veiculo = listaVeiculos.procurarPorPlaca(placa);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado!");
            return;
        }
        
        if (procurarPorPlaca(placa) != null) {
            System.out.println("Veículo já locado!");
            return;
        }
        
        System.out.print("Digite a data de retirada (ex.: 16/04/2025): ");
        String dataRetirada = scanner.nextLine();
        
        System.out.print("Digite a data de devolução (ex.: 20/04/2025): ");
        String dataDevolucao = scanner.nextLine();
        
        System.out.print("Digite o valor da locação: ");
        double valor = Double.parseDouble(scanner.nextLine());
        
        Locacao locacao = new Locacao(cnh, placa, dataRetirada, dataDevolucao, valor);
        locacoes.insereFim(locacao);
        System.out.println("Locação criada com sucesso!");
    }

    public void encerrarLocacao() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
        
        Locacao locacao = procurarPorPlaca(placa);
        if (locacao == null) {
            System.out.println("Locação não encontrada para a placa " + placa);
            return;
        }
        
        locacoes.remove(locacao);
        System.out.println("Locação encerrada com sucesso!");
    }

    public void listarLocacoes(boolean inicioParaFim) {
        if (locacoes.estahVazia()) {
            System.out.println("Nenhuma locação ativa.");
            return;
        }
        if (inicioParaFim) {
            locacoes.imprimeLista();
        } else {
            locacoes.imprimeReverso();
        }
    }

    public void listarVeiculosDisponiveis(LDE listaVeiculos, Integer potenciaMin, Integer lugares, Integer idCategoria, boolean ordemCrescente) {
        LDE disponiveis = new LDE();
        
        Noh atual = listaVeiculos.getInicio();
        while (atual != null) {
            Veiculos veiculo = (Veiculos) atual.getInfo();
            if (procurarPorPlaca(veiculo.getPlaca()) == null) {
                boolean passaFiltro = true;
                if (potenciaMin != null && veiculo.getPotencia() < potenciaMin) {
                    passaFiltro = false;
                }
                if (lugares != null && veiculo.getNumeroLugares() != lugares) {
                    passaFiltro = false;
                }
                if (idCategoria != null && veiculo.getCategoria().getIdentificador() != idCategoria) {
                    passaFiltro = false;
                }
                if (passaFiltro) {
                    disponiveis.insereFim(veiculo);
                }
            }
            atual = atual.getProx();
        }
        
        if (disponiveis.estahVazia()) {
            System.out.println("Nenhum veículo disponível com os filtros informados.");
            return;
        }
        
        // Ordenação por potência
        ordenarPorPotencia(disponiveis, ordemCrescente);
        
        disponiveis.imprimeLista();
    }

    private void ordenarPorPotencia(LDE lista, boolean crescente) {
        if (lista.estahVazia()) {
            return;
        }
        
        boolean trocou;
        do {
            trocou = false;
            Noh atual = lista.getInicio();
            while (atual != null && atual.getProx() != null) {
                Veiculos v1 = (Veiculos) atual.getInfo();
                Veiculos v2 = (Veiculos) atual.getProx().getInfo();
                
                if ((crescente && v1.getPotencia() > v2.getPotencia()) ||
                    (!crescente && v1.getPotencia() < v2.getPotencia())) {
                    // Trocar informações
                    Object temp = atual.getInfo();
                    atual.setInfo(atual.getProx().getInfo());
                    atual.getProx().setInfo(temp);
                    trocou = true;
                }
                atual = atual.getProx();
            }
        } while (trocou);
    }

    private Locacao procurarPorPlaca(String placa) {
        Noh atual = locacoes.getInicio();
        while (atual != null) {
            Locacao locacao = (Locacao) atual.getInfo();
            if (locacao.getPlacaVeiculo().equals(placa)) {
                return locacao;
            }
            atual = atual.getProx();
        }
        return null;
    }

    // Getter necessário para acessar locações em outras classes (ex.: exclusão de cliente/veículo)
    public LDE getLocacoes() {
        return locacoes;
    }
}

