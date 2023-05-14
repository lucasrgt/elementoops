package console;

import creature.*;

import java.util.Random;
import java.util.Scanner;

public class ConsoleCreatureHandler {
    /**
     * Cria uma nova criatura e mostra a mensagem contendo as suas características.
     */

    Scanner scanner;

    public ConsoleCreatureHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public Creature createCreature() {
        Creature playerCreature = selectCreature();

        System.out.println("\n[ " + "SUCESSO" + " ] " + "CRIATURA SELECIONADA!");

        playerCreature.showCreatedCreatureMessage();

        return playerCreature;
    }

    /**
     * Retorna uma nova instância da criatura escolhida pelo jogador. Essa instância é única e será utilizada no jogo inteiro.
     *
     * @return Creature
     */
    private Creature selectCreature() {
        while (true) {
            System.out.println("| " + "1. Ar");
            System.out.println("| " + "2. Terra");
            System.out.println("| " + "3. Fogo");
            System.out.println("| " + "4. Água");
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
                default -> System.out.println("\nESCOLHA INVÁLIDA. POR FAVOR SELECIONE UM NÚMERO DE 1 - 4.\n");
            }
        }
    }

    /**
     * Implementação da lógica de quem começa a jogar primeiro (jogador ou computador) baseado na velocidade das criaturas.
     * A criatura com mais velocidade será aquela que jogará primeiro. Se as criaturas tiverem a mesma velocidade, irá ser sorteado
     * quem irá jogar primeiro (50/50).
     */
    public Creature getFirstAttack(Creature playerSelectedCreature, Creature enemyCreature) {
        if (playerSelectedCreature.getCharacteristics().getSpeed() > enemyCreature.getCharacteristics().getSpeed()) {
            System.out.println("[ " + "COMBATE" + " ] " + "SUA CRIATURA É MAIS RÁPIDA, VOCÊ JOGA PRIMEIRO!\n");
            selectAttack(playerSelectedCreature, enemyCreature);

            return playerSelectedCreature;
        } else if (playerSelectedCreature.getCharacteristics().getSpeed() == enemyCreature.getCharacteristics().getSpeed()) {
            System.out.println("[ COMBATE ] VELOCIDADES DAS CRIATURAS SÃO IGUAIS, VAMOS SORTEAR QUEM IRÁ JOGAR PRIMEIRO! ");
            Random random = new Random();

            System.out.println("\n\nO INIMIGO LANÇA UM ATAQUE!");

            int chance = random.nextInt(2) + 1;

            if (chance == 1) {
                System.out.println("[ COMBATE ] SUA CRIATURA FOI SORTEADA PARA JOGAR PRIMEIRO.");
                selectAttack(playerSelectedCreature, enemyCreature);
                return playerSelectedCreature;

            } else {
                System.out.println("[ COMBATE ] INFELIZMENTE O INIMIGO FOI SORTEADO PARA JOGAR PRIMEIRO.");
                enemyAttack(playerSelectedCreature, enemyCreature);
                return enemyCreature;
            }

        } else {
            System.out.println("[ " + "COMBATE" + " ] " + "INFELIZMENTE A CRIATURA INIMIGA É MAIS RÁPIDA, ELA JOGA PRIMEIRO!\n");
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
            System.out.println("| " + "1. Ataque FÍSICO");
            System.out.println("| " + "2. Ataque ELEMENTAL");
            System.out.println("| " + "3. Sair");
            System.out.print("\n- SELECIONE UMA OPÇÃO ( 1 - 3 ):  ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("\nVOCÊ REALIZA UM ATAQUE FÍSICO!");
                    playerCreature.castPhysicalAttack(enemyCreature);
                    attackSelected = true;
                }
                case 2 -> {
                    System.out.println("\nVOCÊ REALIZA UM ATAQUE ELEMENTAL!");
                    playerCreature.castElementalAttack(enemyCreature);
                    attackSelected = true;
                }
                case 3 -> ConsoleUtils.stop(scanner);
                default -> System.out.println("\nESCOLHA INVÁLIDA. POR FAVOR SELECIONE UM NÚMERO DE 1 - 3.\n");
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

        System.out.println("\n\nO INIMIGO LANÇA UM ATAQUE!");

        int chance = random.nextInt(2) + 1;

        if (chance == 1) {
            enemyCreature.castPhysicalAttack(playerCreature);
        } else {
            enemyCreature.castElementalAttack(playerCreature);
        }

        System.out.println("SUA VIDA AGORA: " + playerCreature.getCharacteristics().getVitality() + "\n");
    }
}
