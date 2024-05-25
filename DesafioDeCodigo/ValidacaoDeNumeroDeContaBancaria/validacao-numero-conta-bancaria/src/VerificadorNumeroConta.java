/*Descrição:
Você está desenvolvendo um programa simples em Java para verificar se um número de conta bancária é válido. O número da conta deve ter exatamente 8 dígitos.

Entrada:
O programa solicitará ao usuário que digite o número da conta bancária.

Saída:
O programa utilizará um bloco try-catch para verificar se o número da conta possui exatamente 8 dígitos.
Se o número da conta tiver 8 dígitos, o programa informará que é um número válido.
Se o número da conta não tiver 8 dígitos, o programa lançará uma exceção (por exemplo, IllegalArgumentException) e informará que o número da conta é inválido. */

import java.util.Scanner;

public class VerificadorNumeroConta extends IllegalArgumentException {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String numeroConta = scanner.nextLine();

            // Chamar o método que veritica se o número da conta é valido
            verificarNumeroConta(numeroConta);
            
            // Caso nenhuma exceção seja lançada, imprime a mensagem de sucesso.
            System.out.println("Numero de conta valido.");
        } catch (IllegalArgumentException e) {
            // Informar que o número de conta é inválido e exibir a mensagem de erro
            //System.out.println("Erro: " + e.getMessage());
        } finally {
            // Fechar o scanner para evitar vazamentos de recursos
            scanner.close();
        }
    }

    private static void verificarNumeroConta(String numeroConta) throws IllegalArgumentException {
        if (numeroConta.length() != 8) {
            // "Numero de conta invalido. Digite exatamente 8 digitos."
            System.out.println("Erro: Numero de conta invalido. Digite exatamente 8 digitos.");
            // Lançar uma IllegalArgumentException com a seguinte mensagem:
            throw new IllegalArgumentException();

        }
    }
}