import java.util.Scanner;

public class GerenciadorTarefasIniciante {
    public static void main(String[] args) {
        // Criamos um vetor (array) que suporta até 5 tarefas pendentes
        String[] tarefasPendentes = new String[5];
        // Esta variável controla quantas tarefas temos e aponta para o topo da pilha
        int quantidadePendentes = 0;

        // Criamos outro vetor para guardar as tarefas que forem concluídas (histórico)
        String[] tarefasConcluidas = new String[5];
        int quantidadeConcluidas = 0;

        Scanner leitor = new Scanner(System.in);
        int opcao = 0;

        System.out.println("=== MEU PRIMEIRO GERENCIADOR DE TAREFAS ===");

        // Laço de repetição para exibir o menu até que o usuário decida sair (opção 5)
        while (opcao != 5) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Ver Tarefas Pendentes");
            System.out.println("3. Concluir Última Tarefa");
            System.out.println("4. Desfazer Última Conclusão");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = leitor.nextInt();
            leitor.nextLine(); // Limpa o teclado

            if (opcao == 1) {
                // --- ADICIONAR TAREFA (PUSH) ---
                if (quantidadePendentes < 5) {
                    System.out.print("Digite a descrição da tarefa: ");
                    String novaTarefa = leitor.nextLine();

                    // Coloca a tarefa na posição atual do topo e depois aumenta o contador
                    tarefasPendentes[quantidadePendentes] = novaTarefa;
                    quantidadePendentes++;
                    System.out.println("Tarefa adicionada com sucesso!");
                } else {
                    System.out.println("Aviso: Sua lista está cheia! Conclua algo antes.");
                }

            } else if (opcao == 2) {
                // --- VISUALIZAR TAREFAS ---
                if (quantidadePendentes == 0) {
                    System.out.println("Nenhuma tarefa pendente.");
                } else {
                    System.out.println("\nTarefas Pendentes (Do Topo para a Base):");
                    // Mostramos do último adicionado (topo) até o primeiro (base)
                    for (int i = quantidadePendentes - 1; i >= 0; i--) {
                        System.out.println(i + " - " + tarefasPendentes[i]);
                    }
                }

            } else if (opcao == 3) {
                // --- CONCLUIR TAREFA (POP) ---
                if (quantidadePendentes == 0) {
                    System.out.println("Não há tarefas para concluir.");
                } else {
                    // Descobre qual é a última tarefa (topo)
                    int indiceTopo = quantidadePendentes - 1;
                    String tarefaConcluida = tarefasPendentes[indiceTopo];

                    // Remove da lista de pendentes (diminuindo o contador)
                    quantidadePendentes--;

                    // Guarda na lista de concluídas
                    tarefasConcluidas[quantidadeConcluidas] = tarefaConcluida;
                    quantidadeConcluidas++;

                    System.out.println("Tarefa \"" + tarefaConcluida + "\" concluída!");
                }

            } else if (opcao == 4) {
                // --- DESFAZER CONCLUSÃO ---
                if (quantidadeConcluidas == 0) {
                    System.out.println("Não há nenhuma tarefa concluída para desfazer.");
                } else {
                    // Pega a última tarefa que foi concluída
                    int indiceConcluida = quantidadeConcluidas - 1;
                    String tarefaDesfeita = tarefasConcluidas[indiceConcluida];

                    // Remove da lista de concluídas
                    quantidadeConcluidas--;

                    // Devolve para a lista de pendentes
                    tarefasPendentes[quantidadePendentes] = tarefaDesfeita;
                    quantidadePendentes++;

                    System.out.println("Desfeito! A tarefa \"" + tarefaDesfeita + "\" voltou para a lista.");
                }

            } else if (opcao == 5) {
                System.out.println("Encerrando o programa. Até mais!");
            } else {
                System.out.println("Opção inválida!");
            }
        }

        leitor.close();
    }
}