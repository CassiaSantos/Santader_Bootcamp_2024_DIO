/* será desenvolvido uma classe para representar uma TV smart onde:
1. Ela contenha as características: ligada(boolean), canal(int) e volume(int);
2. A TV possui 2 estados: ligada e desligada;
3. A TV muda de volume sempre de +1 ou -1;
4. A TV poderá mudar de canal de 1 em 1 ou definindo o número correspondente.
*/
public class SmartTV {
    boolean estadoLigada = false;
    int volume = 0;
    int canal = 1;
    
    public void ligar(){
        estadoLigada = true;
    }
    
    public void desligar(){
        estadoLigada = false;
    }
    
    public void aumentarVolume(){
        volume++;
    }
    
    public void diminuirVolume(){
        volume--;
    }
    
    public void avancarCanal(){
        canal++;
    }
    
    public void recuarCanal(){
        canal--;
    }
    
    public void mudarCanalSelecionado(int canalEscolhido){
        canal = canalEscolhido;
    }
}
