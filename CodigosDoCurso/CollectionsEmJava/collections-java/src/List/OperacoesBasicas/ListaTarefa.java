//package CodigosDoCurso.CollectionsEmJava.collections-java.src.List.OperacoesBasicas;
package List.OperacoesBasicas;
import java.util.ArrayList;
import java.util.List;
public class ListaTarefa {
    //quero um atributo que é uma lista de objetos do tipo Tarefa. Esse atributo/lista irá receber o nome de tarefaList. 
    private List<Tarefa> tarefaList;

    //sempre que um objeto do tipo ListaTarefa for criado, haverá um atributo tarefaList com arrayList vazio.
    public ListaTarefa() {
        this.tarefaList = new ArrayList<>();
    }

    //adiciona tarefa na tarefaList
    public void adicionarTarefa(String descricao){
        
    }
}
