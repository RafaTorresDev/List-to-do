import entities.ListaTarefas;
import entities.Menu;
import entities.Tarefas;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaTarefas lista = new ListaTarefas(new ArrayList<>());
        Menu menu = new Menu(lista);
        Scanner sc = new Scanner(System.in);

        menu.iniciarMenu();

        sc.close();
    }
}