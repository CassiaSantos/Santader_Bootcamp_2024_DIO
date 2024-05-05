/* será desenvolvido uma classe para representar uma TV smart onde:
1. Ela contenha as características: ligada(boolean), canal(int) e volume(int);
2. A TV possui 2 estados: ligada e desligada;
3. A TV muda de volume sempre de +1 ou -1;
4. A TV poderá mudar de canal de 1 em 1 ou definindo o número correspondente.
*/

public class Usuario {
    
	public static void main(String[] args) {
	    
	    SmartTV smartTV = new SmartTV();
	    int canalSelecionado;
	    
		System.out.println("A TV está ligada? " + smartTV.estadoLigada);
		
		//liga a TV:
		System.out.println("\nQuero ligar a TV!");
		smartTV.ligar();
		System.out.println("Agora a TV está ligada? " + smartTV.estadoLigada);
		
		//aumenta volume:
		smartTV.aumentarVolume();
		smartTV.aumentarVolume();
		smartTV.aumentarVolume();
		smartTV.aumentarVolume();
		smartTV.diminuirVolume();
		System.out.println("\nA TV está no volume: " + smartTV.volume);
        
        
        smartTV.avancarCanal();
        smartTV.avancarCanal();
        smartTV.avancarCanal();
        smartTV.avancarCanal();
        smartTV.recuarCanal();
		System.out.println("\nA TV está no canal: " + smartTV.canal);
		
		canalSelecionado = 18;
		smartTV.mudarCanalSelecionado(canalSelecionado);
		System.out.println("\nQuero trocar colocar a TV no canal " + canalSelecionado);
		System.out.println("Agora a TV está no canal: " + canalSelecionado);
		
	}

}
