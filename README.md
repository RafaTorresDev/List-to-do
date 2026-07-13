# Lista de Tarefas (Console)

Este é um exercício de estudo, não um projeto de portfólio.

Aplicação simples de lista de tarefas via console, feita para praticar estruturas de dados, orientação a objetos e organização de classes em Java.

## Funcionalidades

Adicionar tarefa  
Listar tarefas  
Remover tarefa  
Menu de interação via console

## Estrutura

```
List-to-do/
└── src/
    ├── Main.java
        └── entities/
                ├── ListaTarefas.java
                        ├── Menu.java
                                └── Tarefas.java
                                ```

                                ## Como executar

                                ```bash
                                cd src
                                javac -d ../out Main.java entities/*.java
                                java -cp ../out Main
                                ```

                                ## Tecnologias

                                Java puro, sem frameworks ou dependências externas.
                                
