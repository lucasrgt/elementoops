package console;

import creature.*;

import java.util.Scanner;

/**
 * Console que controla o funcionamento do jogo.
 */
public class GameConsole {
    Scanner scanner = new Scanner(System.in);
    ConsoleCreatureHandler creatureHandler = new ConsoleCreatureHandler(scanner);
    ConsoleTournament tournament = new ConsoleTournament(creatureHandler);

    /**
     * Inicia o jogo.
     */
    public void startGame() {

        boolean restartGame;

        do {
            restartGame = false;

            System.out.println("\n- SEJA BEM-VINDO(A) AO ElementOOPS! -\n");

            Creature playerCreature = creatureHandler.createCreature();

            System.out.println("""
                    Você deseja iniciar um torneio?
                                        
                    | 1. Iniciar torneio
                    | 2. Sair""");

            System.out.print("\n- SELECIONE UMA OPÇÃO ( 1 - 2 ): ");

            int choice = scanner.nextInt();
            boolean selected = false;

            while (!selected) {
                switch (choice) {
                    case 1 -> {
                        System.out.println("\nIniciando torneio...\n");
                        tournament.createTournament(playerCreature);
                        selected = true;
                    }
                    case 2 -> {
                        ConsoleUtils.stop(scanner);
                        selected = true;
                        restartGame = true;
                    }
                    default -> System.out.println("\nESCOLHA INVÁLIDA. POR FAVOR SELECIONE UM NÚMERO DE 1 - 2.\n");
                }
            }
        } while (restartGame);
    }
}

