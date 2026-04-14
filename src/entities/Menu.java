package entities;

import java.util.Scanner;

public class Menu {
    //atributos
    private Scanner sc = new Scanner(System.in);
    private ListaTarefas  list = new ListaTarefas();

    //construtor
    public Menu() {}
    public Menu( ListaTarefas list) {
        this.list = list;
    }


    //metodoos (aqui nao precisa de get e nem set pq é uma classe de hud)
    public void exibirMenu() {
        System.out.println("================================");
        System.out.println("Bem-vindo ao Gerenciador de Tarefas!");
        System.out.println("================================");
        System.out.println("Menu:");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Remover Tarefa");
        System.out.println("3. Marcar Tarefa como Concluída");
        System.out.println("4. Listar Tarefas");
        System.out.println("5. Sair");
        System.out.println("================================");
    }

    public void iniciarMenu() {
        list.carregarArquivo();
        int opcao = -1;

        do{
            exibirMenu();
            opcao = sc.nextInt();
            sc.nextLine(); //para limpar o buffer lá

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome da tarefa:");
                    String nome = sc.nextLine();
                    System.out.println("Digite a descrição da tarefa:");
                    String descricao = sc.nextLine();
                    Tarefas novaTarefa = new Tarefas(nome, descricao);
                    list.adicionarTarefa(novaTarefa);
                    list.salvarParaArquivo();
                    break;
                case 2:
                    System.out.println("Digite o ID da tarefa a ser removida:");
                    int idRemover = sc.nextInt();

                    Tarefas tarefaRemover = list.buscarPorId(idRemover);

                    if (tarefaRemover != null) {
                        list.removerTarefa(tarefaRemover);
                        System.out.println("Tarefa removida com sucesso!");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                    list.salvarParaArquivo();

                    break;
                case 3:
                    System.out.println("Digite o ID da tarefa a ser marcada como concluída:");
                    int idConcluir = sc.nextInt();
                    Tarefas tarefaConcluir = list.buscarPorId(idConcluir);
                    if (tarefaConcluir != null) {
                        list.marcarTarefaConcluida(tarefaConcluir);
                        System.out.println("Tarefa marcada como concluída!");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                    list.salvarParaArquivo();
                    break;
                case 4:
                    System.out.println("Como deseja listar?");
                    System.out.println("1. Todas");
                    System.out.println("2. Apenas Pendentes");
                    System.out.println("3. Apenas Concluídas");
                    int subOpcao = sc.nextInt();
                    sc.nextLine(); // Limpar buffer sempre!

                    switch (subOpcao) {
                        case 1:
                            list.listarTarefas();
                            break;
                        case 2:
                            list.listarTarefasPendentes();
                            break;
                        case 3:
                            list.listarTarefasConcluidas();
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
        while(opcao != 5);




    }
}
