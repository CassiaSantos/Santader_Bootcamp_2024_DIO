/* Vamos explorar alguns outros cenários, com fluxo condicionais, repetições e excepcionais.

Case 1: Vamos imaginar que em um processo seletivo, existe o valor base salarial de R$ 2.000,00 e o salário pretentido pelo candidato. Vamos elaborar um controle de fluxo onde:

Se o valor salário base, for maior que valor salário pretentido, imprima : LIGAR PARA O CANDIDATO;

Senão, Se o valor salário base for igual ao valor salário pretentido, imprima : LIGAR PARA O CANDIDATO, COM CONTRA PROPOSTA;

Senão imprima: AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS.

Case 2: Foi solicitado, que nosso sistema garanta que, diante das inúmeras candidaturas sejam selecionados apenas no máximo, 5 candidatos para entrevista, onde o salário pretendido seja menor ou igual ao salário base.

Case 3: Agora é hora de imprimir a lista dos candidatos selecionados, para disponibilizar para o RH entrar em contato.

Case 4: O RH deverá realizar uma ligação, com no máximo 03 tentativas para cada candidato selecionado e caso o candidato atenda, deve-se imprimir:

"CONSEGUIMOS CONTATO COM [CANDIDATO] APÓS n TENTATIVA(S)"

Do contrário imprima: "NÃO CONSEGUIMOS CONTATO COM O [CANDIDATO] */

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO"};
        for (String candidato : candidatos) {
            entrarEmContatoCandidato(candidato);
        }
    }

    static void entrarEmContatoCandidato(String candidato) {
		int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu=false;
        do {
            atendeu= atender();
			continuarTentando = !atendeu;
			if(continuarTentando)
				tentativasRealizadas++;
			else
				System.out.println("CONTATO REALIZADO COM SUCESSO");
        } while (continuarTentando && tentativasRealizadas < 3);
        if(atendeu)
			System.out.println("CONSEGUIMOS CONTATO COM " + candidato +" NA " + tentativasRealizadas + " TENTATIVA");
		else
			System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato +", NÚMERO MAXIMO TENTATIVAS " + tentativasRealizadas + " REALIZADA");
    }

    //método auxiliar
	static boolean atender() {
		return new Random().nextInt(3)==1;	
	}

    static void imprimirCandidatosSelecionados() {
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO"};
        for (String candidato : candidatos) {
            System.out.println("O candidato " + candidato + "foi selecionado");
        }
    }

    static void selecionaCandidatos(){
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            double salarioBase = 2000.0;
            double salarioPretendido = valorPretendido(); 
            String candidato = candidatos[candidatoAtual];
            System.out.println("O candidato " + candidato + " solicitou R$" + salarioPretendido + " de salário");
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + "foi selecionado para a vaga");
                candidatosSelecionados++;
            } else{
                System.out.println("O candidato " + candidato + "não foi selecionado para a vaga");
            }
            candidatoAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioPretendido < salarioBase){
            System.out.println("Ligar para o candidato!");
        } else if(salarioPretendido == salarioBase){
            System.out.println("Ligar para o candidato com contra-proposta!");
        } else {
            System.out.println("Aguardar resposta dos demais candidatos!");
        }
    }
    
}
