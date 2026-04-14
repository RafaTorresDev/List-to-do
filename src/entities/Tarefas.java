package entities;

public class Tarefas {
    //atributos
    private String nome;
    private String descricao;
    private boolean concluida;
    private int id;

    //construtor
    public Tarefas() {}

    public Tarefas(String nome, String descricao, int id) {
        this.concluida = false;
        this.descricao = descricao;
        this.nome = nome;
        this.id = id;
    }

    public Tarefas(String nome, String descricao) {
        this.concluida = false;
        this.descricao = descricao;
        this.nome = nome;
        this.id = 0; // Default id, can be set later if needed
    }

    //getters e setters
    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

     public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //metodos
}