package console;

import java.util.Scanner;

/**
 * Algumas utilidades de console que são usadas ao longo do jogo.
 */
public class ConsoleUtils {
    /**
     * Aguarda um determinado tempo antes de executar a próxima ação.
     *
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
    public static void stop(Scanner scanner) {
        System.out.println("Você deseja mesmo sair do jogo?" + "\n");
        System.out.println("| " + "1. Continuar jogo" + "\n" +
                "| " + "2. Sair");

        System.out.print("\n- SELECIONE UMA OPÇÃO ( 1 - 2 ): ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> System.out.println("\nContinuando o jogo...\n");
            case 2 -> {
                System.out.println("\nFinalizando o jogo...");
                System.exit(0);
            }
            default -> System.out.println("\nESCOLHA INVÁLIDA. POR FAVOR SELECIONE UM NÚMERO DE 1 - 2.\n");
        }
    }
}

