package entities;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    //atributos
    private List<Tarefas> ListaTarefas = new ArrayList<>();

    //construtor
    public ListaTarefas(){}
    public ListaTarefas(List<Tarefas> ListaTarefas) {
        this.ListaTarefas = ListaTarefas;
    }
    //getters e setters
    public List<Tarefas> getListaTarefas() {
        return ListaTarefas;
    }

    public void setListaTarefas(List<Tarefas> listaTarefas) {
        ListaTarefas = listaTarefas;
    }

    //metodos
    public void adicionarTarefa(Tarefas tarefa){
        ListaTarefas.add(tarefa);
    }

    public void removerTarefa(Tarefas tarefa){
        ListaTarefas.remove(tarefa);
    }

    public void marcarTarefaConcluida(Tarefas tarefa){
        tarefa.setConcluida(true);
    }

    public void listarTarefas(){
        for (Tarefas tarefa : ListaTarefas) {
            System.out.println("Nome: " + tarefa.getNome());
            System.out.println("Descrição: " + tarefa.getDescricao());
            System.out.println("Concluída: " + tarefa.isConcluida());
            System.out.println("-------------------------");
        }
    }

}