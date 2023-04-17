package console;

import creature.*;
import element.Air;
import element.Earth;
import element.Fire;
import element.Water;
import java.util.Random;
import java.util.Scanner;

public class ConsoleCreatureHandler {
    /** Cria uma nova criatura e mostra a mensagem contendo as suas características.
     * @return Creature
     */

    Scanner scanner;

    public ConsoleCreatureHandler(Scanner scanner) {
        this.scanner = scanner;
    }
    public Creature createCreature() {
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
                case 1 -> {
                    return new AirCreature();
                }
                case 2 -> {
                    return new EarthCreature();
                }
                case 3 -> {
                    return new FireCreature();
                }
                case 4 -> {
                    return new WaterCreature();
                }
                default ->
                        System.out.println(ConsoleColors.RED + "\nESCOLHA INVÁLIDA. POR FAVOR SELECIONE UM NÚMERO DE 1 - 4.\n" + ConsoleColors.RESET);
            }
        }
    }

    /**
     * Implementação da lógica de quem começa a jogar primeiro (jogador ou computador) baseado na velocidade das criaturas.
     * A criatura com mais velocidade será aquela que jogará primeiro.
     */
    public Creature getFirstAttack(Creature playerSelectedCreature, Creature enemyCreature) {
        if (playerSelectedCreature.getCharacteristics().getSpeed() > enemyCreature.getCharacteristics().getSpeed()) {
            System.out.println("[ " + ConsoleColors.GREEN + "COMBATE" + ConsoleColors.RESET + " ] " + "SUA CRIATURA É MAIS RÁPIDA, VOCÊ JOGA PRIMEIRO!\n");
            selectAttack(playerSelectedCreature, enemyCreature);

            return playerSelectedCreature;
        } else {
            System.out.println("[ " + ConsoleColors.RED + "COMBATE" + ConsoleColors.RESET + " ] " + "INFELIZMENTE A CRIATURA INIMIGA É MAIS RÁPIDA, ELA JOGA PRIMEIRO!\n");
            enemyAttack(playerSelectedCreature, enemyCreature);

            return enemyCreature;
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
                case 1 -> {
                    System.out.println(ConsoleColors.GREEN + "\nVOCÊ REALIZA UM ATAQUE FÍSICO!" + ConsoleColors.RESET);
                    enemyCreature.receivePhysicalDamage(playerCreature);
                    attackSelected = true;
                }
                case 2 -> {
                    System.out.println(ConsoleColors.GREEN + "\nVOCÊ REALIZA UM ATAQUE ELEMENTAL!" + ConsoleColors.RESET);
                    enemyCreature.receiveElementalDamage(playerCreature);
                    attackSelected = true;
                }
                case 3 -> ConsoleUtils.stop(scanner);
                default ->
                        System.out.println(ConsoleColors.RED + "\nESCOLHA INVÁLIDA. POR FAVOR SELECIONE UM NÚMERO DE 1 - 3.\n" + ConsoleColors.RESET);
            }
        }
    }

    /**
     * Implementação dos ataques do computador. Os ataques são aleatórios (50% de chance).
     */
    public void enemyAttack(Creature playerCreature, Creature enemyCreature) {
        System.out.print("Inimigo realizando um ataque.");
        ConsoleUtils.sleep(1000);

        System.out.print(".");
        ConsoleUtils.sleep(1000);

        System.out.print(".");
        ConsoleUtils.sleep(1000);

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
