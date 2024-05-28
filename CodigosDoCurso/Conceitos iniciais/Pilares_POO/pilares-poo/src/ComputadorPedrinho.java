/*ANTES DOS PILARES DE POO:
Simulação do uso da classe MSNMessenger

public class ComputadorPedrinho {
	public static void main(String[] args) {
		//abrindo MSN Messenger
		MSNMessenger msn = new MSNMessenger();
		
		msn.validarConectadoInternet();
		msn.enviarMensagem();
		msn.salvarHistoricoMensagem();
		
		msn.receberMensagem();
	}
}
 */
/*
public class ComputadorPedrinho {
	public static void main(String[] args) {
		//abrindo MSN Messenger
		MSNMessenger msn = new MSNMessenger();
		msn.enviarMensagem();
		msn.receberMensagem();

        FacebookMessenger fcb = new FacebookMessenger();
		fcb.enviarMensagem();
		fcb.receberMensagem();

        Telegram tlg = new Telegram();
		tlg.enviarMensagem();
		tlg.receberMensagem();
	}
}*/

import apps.FacebookMessenger;
import apps.MSNMessenger;
import apps.ServicoMensagemInstantanea;
import apps.Telegram;

public class ComputadorPedrinho {
	public static void main(String[] args) {
		
		ServicoMensagemInstantanea smi = null;
		
		/*
		    NÃO SE SABE QUAL APP 
		    MAS QUALQUER UM DEVERÁ ENVIAR E RECEBER MENSAGEM
		 */
		String appEscolhido="msn"; 
		
		if(appEscolhido.equals("msn"))
			smi = new MSNMessenger();
		else if(appEscolhido.equals("fbm"))
			smi = new FacebookMessenger();
		else if(appEscolhido.equals("tlg"))
			smi = new Telegram();
		
			
		smi.enviarMensagem();
		smi.receberMensagem();
	}
}
