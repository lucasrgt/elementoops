package console;

import creature.*;
import creature.characteristics.Characteristics;
import element.Air;
import element.Earth;
import element.Fire;
import element.Water;
import java.util.Random;
import java.util.Scanner;

/**
 * Console que controla o funcionamento do jogo.
 */
public class GameConsole {
    Scanner scanner = new Scanner(System.in);

    /**
     * Inicia o jogo.
     */
    public void startGame() {
        boolean restart;

        do {
            restart = false;

            System.out.println("\n- SEJA BEM-VINDO(A) AO ElementOOPS! -\n");

            Creature playerCreature = createCreature();

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
                        createTournament(playerCreature);
                        selected = true;
                        break;
                    case 2:
                        Console.stop();
                        selected = true;
                        restart = true;
                        break;
                    default:
                        System.out.println(ConsoleColors.RED + "\nESCOLHA INVÁLIDA. POR FAVOR SELECIONE UM NÚMERO DE 1 - 3.\n" + ConsoleColors.RESET);
                        break;
                }
            }
        } while (restart);
    }

    /** Cria uma nova criatura e mostra a mensagem contendo as suas características.
     * @return Creature
     */
    private Creature createCreature() {
        Creature playerCreature = selectCreature();

        System.out.println("\n[ " + ConsoleColors.GREEN + "SUCESSO" + ConsoleColors.RESET + " ] " +  "CRIATURA SELECIONADA!");

        playerCreature.showCreatedCreatureMessage();

        return playerCreature;
    }

    /** Retorna uma nova instância da criatura escolhida pelo jogador. Essa instância é única e será utilizada no jogo inteiro.
     * @return Creature
     */
    private Creature selectCreature() {
        while (true) {
            System.out.println("| " + Air.CONSOLE_COLOR_CODE + "1. Ar" + ConsoleColors.RESET);
            System.out.println("| " + Earth.CONSOLE_COLOR_CODE + "2. Terra" + ConsoleColors.RESET);
            System.out.println("| " + Fire.CONSOLE_COLOR_CODE + "3. Fogo" + ConsoleColors.RESET);
            System.out.println("| " + Water.CONSOLE_COLOR_CODE + "4. Água" + ConsoleColors.RESET);
            System.out.print("\n- SELECIONE A SUA CRIATURA ( 1 - 4 ): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    return new AirCreature();
                case 2:
                    return new EarthCreature();
                case 3:
                    return new FireCreature();
                case 4:
                    return new WaterCreature();
                default:
                    System.out.println(ConsoleColors.RED + "\nESCOLHA INVÁLIDA. POR FAVOR SELECIONE UM NÚMERO DE 1 - 4.\n" + ConsoleColors.RESET);
                    break;
            }
        }
    }

    /**
     * Cria um torneio.
     * Dependendo do elemento da criatura do jogador, receberá as criaturas adversárias adequadas e lutará com
     * cada uma delas até o fim do jogo.
     */
    private void createTournament(Creature playerSelectedCreature) {
        Creature[] enemiesCreatures = playerSelectedCreature.getEnemiesCreatures();

        for (Creature enemyCreature : enemiesCreatures) {
            Characteristics playerSelectedCreatureCharacteristics = playerSelectedCreature.getCharacteristics();

            Characteristics enemyCreatureCharacteristics = enemyCreature.getCharacteristics();

            System.out.println("[ " + ConsoleColors.RED + "ALERTA" + ConsoleColors.RESET + " ] " +  "INIMIGO AVISTADO!");

            enemyCreature.showCreatedCreatureMessage();

            getFirstAttack(playerSelectedCreature, enemyCreature);

            while (true) {
                selectAttack(playerSelectedCreature, enemyCreature);

                System.out.println(ConsoleColors.RED + "VIDA DO INIMIGO AGORA: " + enemyCreatureCharacteristics.getVitality() + "\n" + ConsoleColors.RESET);

                if (enemyCreatureCharacteristics.getVitality() <= 0) {
                    System.out.println(ConsoleColors.GREEN + "VOCÊ DERROTOU O INIMIGO!\n" + ConsoleColors.RESET);
                    playerSelectedCreature.regenerateVitality();
                    Console.sleep(3000);
                    break;
                }

                enemyAttack(playerSelectedCreature, enemyCreature);

                if (playerSelectedCreatureCharacteristics.getVitality() <= 0) {
                    System.out.println(ConsoleColors.RED + "--- GAME OVER - VOCÊ FOI DERROTADO ---");
                    Console.stop();
                }
            }
        }

        System.out.println(ConsoleColors.GREEN + "\n --- PARABÉNS, VOCÊ VENCEU O JOGO! ---");
    }


    /**
     * Implementação da lógica de quem começa a jogar primeiro (jogador ou computador) baseado na velocidade das criaturas.
     * A criatura com mais velocidade será aquela que jogará primeiro.
     */
    public void getFirstAttack(Creature playerSelectedCreature, Creature enemyCreature) {
        if (playerSelectedCreature.getCharacteristics().getSpeed() > enemyCreature.getCharacteristics().getSpeed()) {
            System.out.println("[ " + ConsoleColors.GREEN + "COMBATE" + ConsoleColors.RESET + " ] " + "SUA CRIATURA É MAIS RÁPIDA, VOCÊ JOGA PRIMEIRO!\n");
            selectAttack(playerSelectedCreature, enemyCreature);
        } else {
            System.out.println("[ " + ConsoleColors.RED + "COMBATE" + ConsoleColors.RESET + " ] " + "INFELIZMENTE A CRIATURA INIMIGA É MAIS RÁPIDA, ELA JOGA PRIMEIRO!\n");
            enemyAttack(playerSelectedCreature, enemyCreature);
        }
    }

    /**
     * Implementação do menu de seleção de ataques do jogador.
     */
    public void selectAttack(Creature playerCreature, Creature enemyCreature) {

        System.out.println("O que você deseja fazer?");

        boolean attackSelected = false;

        while (!attackSelected) {
            System.out.println("| " + ConsoleColors.YELLOW + "1. Ataque FÍSICO" + ConsoleColors.RESET);
            System.out.println("| " + ConsoleColors.PURPLE + "2. Ataque ELEMENTAL" + ConsoleColors.RESET);
            System.out.println("| " + ConsoleColors.RED + "3. Sair" + ConsoleColors.RESET);
            System.out.print("\n- SELECIONE UMA OPÇÃO ( 1 - 3 ):  ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(ConsoleColors.GREEN + "\nVOCÊ REALIZA UM ATAQUE FÍSICO!" + ConsoleColors.RESET);
                    enemyCreature.receivePhysicalDamage(playerCreature);
                    attackSelected = true;
                    break;
                case 2:
                    System.out.println(ConsoleColors.GREEN + "\nVOCÊ REALIZA UM ATAQUE ELEMENTAL!" + ConsoleColors.RESET);
                    enemyCreature.receiveElementalDamage(playerCreature);
                    attackSelected = true;
                    break;
                case 3:
                    Console.stop();
                    break;
                default:
                    System.out.println(ConsoleColors.RED + "\nESCOLHA INVÁLIDA. POR FAVOR SELECIONE UM NÚMERO DE 1 - 3.\n" + ConsoleColors.RESET);
                    break;
            }
        }
    }

    /**
     * Implementação dos ataques do computador. Os ataques são aleatórios (50% de chance).
     */
    public void enemyAttack(Creature playerCreature, Creature enemyCreature) {
        System.out.print("Inimigo realizando um ataque.");
        Console.sleep(1000);

        System.out.print(".");
        Console.sleep(1000);

        System.out.print(".");
        Console.sleep(1000);

        Random random = new Random();

        System.out.println(ConsoleColors.RED + "\n\nO INIMIGO LANÇA UM ATAQUE!" + ConsoleColors.RESET);

        int chance = random.nextInt(2) + 1;

        if (chance == 1) {
            playerCreature.receiveElementalDamage(enemyCreature);
        } else {
            playerCreature.receivePhysicalDamage(enemyCreature);
        }

        System.out.println(ConsoleColors.RED + "SUA VIDA AGORA: " + playerCreature.getCharacteristics().getVitality() + "\n" + ConsoleColors.RESET);
    }
}

