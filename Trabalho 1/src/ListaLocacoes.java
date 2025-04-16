import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
        
        // Verifica se o veículo já está locado
        if (procurarPorPlaca(placa) != null) {
            System.out.println("Veículo já locado!");
            return;
        }
        
        System.out.print("Digite a data de retirada (ex.: 16/04/2025): ");
        String dataRetirada = scanner.nextLine();
        
        System.out.print("Digite a data de devolução (ex.: 20/04/2025): ");
        String dataDevolucao = scanner.nextLine();
        
        System.out.print("Digite o valor da locação: ");
        double valor;
        try {
            valor = Double.parseDouble(scanner.nextLine());
            if (valor < 0) {
                System.out.println("Valor não pode ser negativo!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido! Use um número (ex.: 150.50).");
            return;
        }
        
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
        System.out.println("\n===== Locações Ativas =====");
        if (inicioParaFim) {
            System.out.println("Exibindo do início para o fim:");
            locacoes.imprimeLista();
        } else {
            System.out.println("Exibindo do fim para o início:");
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
                if (lugares != null && veiculo.getLugares() != lugares) {
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
        
        System.out.println("\n===== Veículos Disponíveis =====");
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
        return locacoes.procurarPorPlacaLocacao(placa);
    }

    public void carregarLocacoesDeCSV(String caminhoArquivo, LDE listaClientes, LDE listaVeiculos) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            boolean primeiraLinha = true;
            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue; // pula o cabeçalho
                }
                String[] dados = linha.split(";");
                if (dados.length != 5) continue;

                String cnh = dados[0];
                String placa = dados[1];
                String dataRetirada = dados[2];
                String dataDevolucao = dados[3];
                double valor = Double.parseDouble(dados[4]);

                Cliente cliente = listaClientes.procurarPorCnh(cnh);
                Veiculos veiculo = listaVeiculos.procurarPorPlaca(placa);
                if (cliente != null && veiculo != null && procurarPorPlaca(placa) == null) {
                    Locacao locacao = new Locacao(cnh, placa, dataRetirada, dataDevolucao, valor);
                    locacoes.insereFim(locacao);
                }
            }
            System.out.println("Locações carregadas do arquivo CSV com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar locações do arquivo CSV: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro no formato do valor no arquivo CSV: " + e.getMessage());
        }
    }

    public void salvarLocacoesCSV(String caminhoArquivo) {
        try (PrintWriter writer = new PrintWriter(caminhoArquivo)) {
            // Cabeçalho
            writer.println("cnh;placa;dataRetirada;dataDevolucao;valor");

            // Percorrer a lista de locações e salvar
            Noh atual = locacoes.getInicio();
            while (atual != null) {
                Locacao locacao = (Locacao) atual.getInfo();
                writer.println(
                        locacao.getCnhCliente() + ";" +
                                locacao.getPlacaVeiculo() + ";" +
                                locacao.getDataRetirada() + ";" +
                                locacao.getDataDevolucao() + ";" +
                                locacao.getValor()
                );
                atual = atual.getProx();
            }

            System.out.println("Locações salvas com sucesso em: " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar locações: " + e.getMessage());
        }
    }


    public LDE getLocacoes() {
        return locacoes;
    }
}