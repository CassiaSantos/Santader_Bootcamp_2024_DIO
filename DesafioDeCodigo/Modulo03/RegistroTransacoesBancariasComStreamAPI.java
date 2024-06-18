import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RegistroTransacoesBancariasComStreamAPI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê a Entrada que informa o saldo inicial da conta
        //System.out.print("Digite o saldo inicial da conta: ");
        double saldoInicial = scanner.nextDouble();

        // Lê a Entrada com a quantidade total de transações
        //System.out.print("Digite a quantidade total de transações: ");
        int quantidadeTransacoes = scanner.nextInt();

        // Lista para armazenar as transações
        List<Transacao> transacoes = new ArrayList<>();

        // Loop para iterar sobre as transações
        for (int i = 1; i <= quantidadeTransacoes; i++) {
            // Lê a Entrada com o tipo de transação (D para depósito ou S para saque)
            //System.out.print("Digite o tipo de transação (D para depósito, S para saque): ");
            char tipoTransacao = scanner.next().toUpperCase().charAt(0);
            // Lê a Entrada com o valor da transação
            //System.out.print("Digite o valor da transação: ");
            double valorTransacao = scanner.nextDouble();

            // Cria e adiciona a transação à lista
            transacoes.add(new Transacao(tipoTransacao, valorTransacao));
        }

        // Calcula o saldo final utilizando a Stream API
        double saldoFinal = saldoInicial + transacoes.stream()
            .mapToDouble(transacao -> transacao.tipo == 'D' ? transacao.valor : -transacao.valor)
            .sum();

        // Exibir o saldo final
        System.out.printf("Saldo: %.1f\n", saldoFinal);

        // Exibir a lista de transações com índices
        System.out.println("Transacoes:");
        final int[] index = {1};
        transacoes.stream()
            .map(transacao ->(transacao.tipo == 'D' ? "d" : "s") + " de " + transacao.valor)
            .forEach(System.out::println);

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}

// Classe para representar uma transação
class Transacao {
    char tipo;
    double valor;

    Transacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }
}
