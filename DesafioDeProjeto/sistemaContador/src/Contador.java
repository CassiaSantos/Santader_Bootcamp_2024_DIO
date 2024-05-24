/*Descrição
Esse desafio de projeto, visa explorar alguns cenários com fluxos condicionais, repetições e excepcionais.

Cenário:
O sistema deverá receber dois parâmetros via terminal que representarão dois números inteiros, com estes dois números, deverá ser obtida a quantidade de interações (for) e realizar a impressão no console (System.out.print) dos números incrementados, exemplo:

Se você passar os números 12 e 30, logo teremos uma interação (for) com 18 ocorrências para imprimir os números, exemplo: "Imprimindo o número 1", "Imprimindo o número 2" e assim por diante.
Se o primeiro parâmetro for MAIOR que o segundo parâmetro, deverá ser lançada a exceção customizada chamada de ParametrosInvalidosException com a segunda mensagem: "O segundo parâmetro deve ser maior que o primeiro"
Crie o projeto DesafioControleFluxo
Dentro do projeto, crie a classe Contador.java para realizar toda a codificação do nosso programa.
Dentro do projeto, crie a classe ParametrosInvalidosException que representará a exceção de negócio no sistema.
Abaixo temos um trecho de código no qual você poderá seguir alterando as partes que contenham ??
*/

import java.util.Scanner;

public class Contador extends ParametrosInvalidosException {
	public static void main(String[] args) {
		Scanner terminal = new Scanner(System.in);
		
		//Entrada de dados:
		System.out.print("Digite o primeiro parâmetro: ");
		int parametroUm = terminal.nextInt();
		System.out.print("Digite o segundo parâmetro: ");
		int parametroDois = terminal.nextInt();
		
		try {
			//chamada do método que contém a lógica de contagem
			contar(parametroUm, parametroDois);
		
		} catch (ParametrosInvalidosException parametroInvalido) {
			//impressão da mensagem de exceção:
			System.out.print("O segundo parâmetro deve ser maior que o primeiro");
		}
	}
		
	static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
		//valida se parametroUm é MAIOR que parametroDois e lança a exceção
		if (parametroUm > parametroDois) {
			throw new ParametrosInvalidosException();
		} else if (parametroUm == parametroDois){
			System.out.println("Não há diferença entre os 2 parâmetros. Dessa forma, o número de interações é 0.");
		} else {
			int numeroInteracoes = parametroDois - parametroUm;
			System.out.println("A diferença entre " + parametroUm + " e " + parametroDois + " é " + numeroInteracoes +". Dessa forma, vou contar de 1 até " + numeroInteracoes);
			for (int i = 0; i < numeroInteracoes; i++) {
				System.out.println(i+1);
			}
		}
	}
}