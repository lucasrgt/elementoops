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

            System.out.println("\nVocê deseja iniciar um torneio?" +
                    "\n| " +  ConsoleColors.GREEN + "1. Iniciar torneio" + ConsoleColors.RESET +
                    "\n| " + ConsoleColors.RED + "2. Sair" + ConsoleColors.RESET);

            System.out.print("\n- SELECIONE UMA OPÇÃO ( 1 - 2 ): ");

            Scanner scanner = new Scanner(System.in);

            int choice = scanner.nextInt();
            boolean selected = false;

            while (!selected) {
                switch (choice) {
                    case 1:
                        System.out.println("\nIniciando torneio...\n");
                        tournament.createTournament(playerCreature);
                        selected = true;
                        break;
                    case 2:
                        ConsoleUtils.stop();
                        selected = true;
                        restartGame = true;
                        break;
                    default:
                        System.out.println(ConsoleColors.RED + "\nESCOLHA INVÁLIDA. POR FAVOR SELECIONE UM NÚMERO DE 1 - 3.\n" + ConsoleColors.RESET);
                        break;
                }
            }
        } while (restartGame);
    }
}

