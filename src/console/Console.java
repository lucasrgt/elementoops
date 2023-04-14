package console;

import java.util.Scanner;

/**
 * Algumas utilidades de console que são usadas ao longo do jogo.
 */
public class Console {
    /**
     * Aguarda um determinado tempo antes de executar a próxima ação.
     * @param milliseconds Tempo em milisegundos
     */
    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Mostra o menu de saída do jogo com confirmação se o jogador deseja realmente sair.
     */
    public static void stop() {
        System.out.println("\nVocê deseja mesmo sair do jogo?");
        System.out.println("\n| " +  ConsoleColors.GREEN + "1. Continuar jogo" + ConsoleColors.RESET +
                           "\n| " + ConsoleColors.RED + "2. Sair" + ConsoleColors.RESET);

        System.out.print("\n- SELECIONE UMA OPÇÃO ( 1 - 2 ): ");

        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("\nContinuando o jogo...\n");
                break;
            case 2:
                System.out.println("\nFinalizando o jogo...");
                System.exit(0);
            default:
                System.out.println(ConsoleColors.RED + "\nESCOLHA INVÁLIDA. POR FAVOR SELECIONE UM NÚMERO DE 1 - 3.\n" + ConsoleColors.RESET);
                break;
            }
        }
    }

