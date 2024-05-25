/*Descrição
Você está desenvolvendo um programa simples em Java para verificar se uma conta bancária ultrapassou o limite do cheque especial. A aplicação solicitará ao cliente que informe o saldo atual da conta bancária. Em seguida, o programa pedirá o valor de um saque que o cliente deseja realizar.

O limite do cheque especial será definido como 500 unidades monetárias.

Entrada
O programa solicitará ao usuário que informe o saldo atual da conta bancária.
Em seguida, o programa solicitará o valor de um saque que o cliente deseja realizar.
Saída
O programa deverá verificar se o saque ultrapassará o saldo disponível na conta.
Se o saque não ultrapassar o saldo, o programa informará que a transação foi realizada com sucesso.
Se o saque ultrapassar o saldo, o programa verificará se o valor do saque ultrapassa o cheque especial (definido como 500 unidades monetárias).
Se ultrapassar, o programa informará que a transação não pode ser realizada devido ao limite excedido.
Caso contrário, o programa informará que a transação foi realizada com sucesso, utilizando o cheque especial. */

import java.util.Scanner;

public class VerificacaoChequeEspecial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double saldo = scanner.nextDouble();
        double saque = scanner.nextDouble();

        // Define um limite para o cheque especial
        double limiteChequeEspecial = 500;

        // Verifica se o saque ultrapassa o saldo disponível
        if (saque <= saldo) {
            //Imprimir "Transação realizada com sucesso."
            System.out.println("Transacao realizada com sucesso.");
        
        } else if((saque > saldo) && (saque <=(saldo + limiteChequeEspecial))) {
            // Em caso positivo, imprimir "Transacao realizada com sucesso utilizando o cheque especial."
                System.out.println("Transacao realizada com sucesso utilizando o cheque especial.");
        } else {
            // Caso contrário, imprimir "Transacao nao realizada. Limite do cheque especial excedido."
            System.out.println("Transacao nao realizada. Limite do cheque especial excedido.");
        }
            
        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}