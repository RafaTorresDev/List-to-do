package entities;

public class Tarefas {
    //atributos
    private String nome;
    private String descricao;
    private boolean concluida;

    //construtor
    public Tarefas() {}

    public Tarefas(String nome, String descricao) {
        this.concluida = false;
        this.descricao = this.descricao;
        this.nome = this.nome;
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

    //metodos
}