/*Descrição
Você está desenvolvendo um programa simples em Java para simular operações bancárias básicas. A aplicação deve permitir ao usuário realizar depósitos, saques e consultar o saldo em uma conta bancária virtual.

Entrada
O programa exibirá um menu com as seguintes opções:
1 - Depositar
2 - Sacar
3 - Consultar Saldo
0 - Encerrar
O usuário escolherá uma dessas opções digitando o número correspondente.

Saída
Utilizando um switch, o programa realizará a operação escolhida pelo usuário.

Se o usuário escolher:
1: O programa solicitará o valor a ser depositado e atualizará o saldo. Além disso, deve imprimir o saldo atual;
2: O programa solicitará o valor a ser sacado e verificará se há saldo suficiente. Sendo assim, deve imprimir valor do Saldo atual quando o saldo for suficiente ou "Saldo insuficiente."
3: O programa apenas exibirá o saldo atual da conta;
0: O programa encerrará, imprimindo "Programa encerrado.".*/

import java.util.Scanner;

public class SimulacaoBancaria {

   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       double saldo = 0.0;
       boolean continuar = true;

       //Exibição do menu na tela e entrada de dados:
       System.out.print("OPÇÕES\n(digite somente o número corresponde à opção):\n1 - Depositar\n2 - Sacar\n3 - Consultar Saldo\n0 - Encerrar\nEu quero: ");

       while (continuar) {

           int opcao = scanner.nextInt();

           switch (opcao) {
               case 1:
                   // Lê o valor a ser depositado, atualiza e imprime o saldo:
                   System.out.print("Digite o valor que deseja depositar: ");
                   double deposito = scanner.nextDouble();
                   saldo = saldo + deposito;
                   System.out.print("Valor depositado com sucesso!\nSaldo atual: " + String.format("%.1f\n\nNova opção: ", saldo));
                   break;
                
               case 2:
                   //Lê o valor a ser sacado, verifica e imprimir se há saldo suficiente:
                   System.out.print("Digite o valor que deseja sacar: ");
                   double saque = scanner.nextDouble();
                   if (saldo >= saque){
                       saldo = saldo - saque;
                       System.out.print("Saque realizado com sucesso! Saldo atual: " + String.format("%.1f\n\nNova opção: ", saldo));
                   } else {
                       System.out.print("Saldo insuficiente! Saldo atual: " + String.format("%.1f\n\nNova opção: ", saldo));
                   }
                   break;
               
               case 3:
                   //Exibe o saldo atual da conta.
                   System.out.print("Saldo atual: " + String.format("%.1f\n\nNova opção: ", saldo));
                   break;
               
               case 0:
                   System.out.println("Programa encerrado.");
                   continuar = false;  // Atualiza a variável de controle para encerrar o loop
                   break;
               default:
                   System.out.println("Opção inválida. Tente novamente inserindo um número de 0 a 3.");
           }
       }
       scanner.close();
   }
}