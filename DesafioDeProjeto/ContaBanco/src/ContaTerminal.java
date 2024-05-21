import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {

        //cria uma instância de scanner: 
        Scanner scanner = new Scanner(System.in);
              
        System.out.print("Digite seu nome completo: ");
        String nomeCompletoCliente = scanner.nextLine();
                        
        System.out.print("Digite sua agência: ");
        String agenciaConta = scanner.nextLine();
                        
        System.out.print("Digite o número da sua conta: ");
        int numeroConta = scanner.nextInt();
                        
        System.out.print("Valor do depósito inicial: ");
        double saldoConta = scanner.nextDouble();
            
        System.out.println("Olá "+ nomeCompletoCliente + "! Obrigada por criar uma conta em nosso banco. Sua agência é " + agenciaConta + " e número de conta " + numeroConta + ". Seu saldo de " + saldoConta + " já está disponível para saque!");
        scanner.close(); 
    }
}