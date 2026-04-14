package entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    //atributos
    private List<Tarefas> ListaTarefas = new ArrayList<>();
    private int proximoId = 1;

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
        tarefa.setId(proximoId);
        ListaTarefas.add(tarefa);
        proximoId++;
    }

    public void removerTarefa(Tarefas tarefa){
        ListaTarefas.remove(tarefa);
    }

    public void marcarTarefaConcluida(Tarefas tarefa){

        tarefa.setConcluida(true);
    }

     public Tarefas buscarPorId(int id) {
         return ListaTarefas.stream()
                 .filter(t -> t.getId() == id)
                 .findFirst()
                 .orElse(null);
     }

     public Tarefas buscarPorNome(String nome) {
         return ListaTarefas.stream()
                 .filter(t -> t.getNome().equalsIgnoreCase(nome))
                 .findFirst()
                 .orElse(null);
     }

    public void listarTarefas(){
        for (Tarefas tarefa : ListaTarefas) {
            System.out.println("ID: " + tarefa.getId());
            System.out.println("Nome: " + tarefa.getNome());
            System.out.println("Descrição: " + tarefa.getDescricao());
            System.out.println("Concluída: " + tarefa.isConcluida());
            System.out.println("-------------------------");
        }
    }

    public void salvarParaArquivo(){
        try {
            FileWriter fw = new FileWriter("tarefas.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (Tarefas tarefa : ListaTarefas) {
                String linha = tarefa.getId() + ";" + tarefa.getNome() + ";" +
                               tarefa.getDescricao() + ";" + tarefa.isConcluida();
                bw.write(linha);
                bw.newLine();
            }

            bw.close();
            fw.close();
            System.out.println("Tarefas salvas com sucesso!");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void carregarArquivo(){
        try {
            FileReader fr = new FileReader("tarefas.txt");
            BufferedReader br = new BufferedReader(fr);
            String linha;

            ListaTarefas.clear();
            proximoId = 1;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if (dados.length == 4) {
                    int id = Integer.parseInt(dados[0]);
                    String nome = dados[1];
                    String descricao = dados[2];
                    boolean concluida = Boolean.parseBoolean(dados[3]);

                    Tarefas tarefa = new Tarefas(nome, descricao);
                    tarefa.setId(id);
                    tarefa.setConcluida(concluida);
                    ListaTarefas.add(tarefa);

                    if (id >= proximoId) {
                        proximoId = id + 1;
                    }
                }
            }

            br.close();
            fr.close();
            System.out.println("Tarefas carregadas com sucesso!");
        }
        catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Iniciando com lista vazia.");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void listarTarefasPendentes(){
        for (Tarefas tarefa : ListaTarefas) {
            if (!tarefa.isConcluida()) {
                System.out.println("ID: " + tarefa.getId());
                System.out.println("Nome: " + tarefa.getNome());
                System.out.println("Descrição: " + tarefa.getDescricao());
                System.out.println("-------------------------");
            }
        }
    }
    public void listarTarefasConcluidas(){
        for (Tarefas tarefa : ListaTarefas) {
            if (tarefa.isConcluida()) {
                System.out.println("ID: " + tarefa.getId());
                System.out.println("Nome: " + tarefa.getNome());
                System.out.println("Descrição: " + tarefa.getDescricao());
                System.out.println("-------------------------");
            }
        }
    }
}
