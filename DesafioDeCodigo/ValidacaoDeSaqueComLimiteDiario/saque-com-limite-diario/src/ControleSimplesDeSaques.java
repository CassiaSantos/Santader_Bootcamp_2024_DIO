/*Descrição
Você está desenvolvendo um programa simples em Java para auxiliar um cliente a realizar saques de uma conta bancária. O cliente pode fazer saques até atingir um limite diário predefinido.

Entrada
O programa solicitará ao usuário que informe o limite diário de saque.
Em seguida, o programa solicitará ao usuário que informe o valor do primeiro saque.
Saída
Utilizando um laço for, o programa iterará sobre os saques.
Para cada saque, o programa verificará se o valor ultrapassa o limite diário.
Se ultrapassar, o programa informará que o limite foi atingido e encerrará o loop.
Se não ultrapassar, o programa informará que o saque foi realizado com sucesso. */

import java.util.Scanner;

public class ControleSimplesDeSaques {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //O programa solicitará ao usuário que informe o limite diário de saque:
        double limiteDiario = scanner.nextDouble();

        // Loop for para iterar sobre os saques
        for (int i = 1; ; i++) {

            double valorSaque = scanner.nextDouble();

            if (valorSaque == 0) {
                System.out.println("Transacoes encerradas.");
                break; // Encerra o loop
            } else if (valorSaque > limiteDiario) {
                System.out.println("Limite diario de saque atingido. Transacoes encerradas.");
                break; // Encerra o loop
            } else {
                //Atualiza o limite diário e imprimir a saída no formato dos exemplos.
                limiteDiario = limiteDiario - valorSaque;
                    System.out.println("Saque realizado. Limite restante: " + String.format("%.1f", limiteDiario));

            }
        }

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}