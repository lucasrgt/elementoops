package console;

import creature.Creature;
import creature.characteristics.Characteristics;

public class ConsoleTournament {
    ConsoleCreatureHandler creatureHandler;

    public ConsoleTournament(ConsoleCreatureHandler creatureHandler) {
        this.creatureHandler = creatureHandler;
    }

    /**
     * Cria um torneio.
     * Dependendo do elemento da criatura do jogador, receberá as criaturas adversárias adequadas e lutará com
     * cada uma delas até o fim do jogo.
     */
    public void createTournament(Creature playerSelectedCreature) {
        Creature[] enemiesCreatures = playerSelectedCreature.getEnemiesCreatures();

        for (Creature enemyCreature : enemiesCreatures) {
            Characteristics playerSelectedCreatureCharacteristics = playerSelectedCreature.getCharacteristics();

            Characteristics enemyCreatureCharacteristics = enemyCreature.getCharacteristics();

            System.out.println("[ " + ConsoleColors.RED + "ALERTA" + ConsoleColors.RESET + " ] " +  "INIMIGO AVISTADO!");

            enemyCreature.showCreatedCreatureMessage();

            creatureHandler.getFirstAttack(playerSelectedCreature, enemyCreature);

            while (true) {
                creatureHandler.selectAttack(playerSelectedCreature, enemyCreature);

                System.out.println(ConsoleColors.RED + "VIDA DO INIMIGO AGORA: " + enemyCreatureCharacteristics.getVitality() + "\n" + ConsoleColors.RESET);

                if (enemyCreatureCharacteristics.getVitality() <= 0) {
                    System.out.println(ConsoleColors.GREEN + "VOCÊ DERROTOU O INIMIGO!\n" + ConsoleColors.RESET);
                    playerSelectedCreature.regenerateVitality();
                    ConsoleUtils.sleep(3000);
                    break;
                }

                creatureHandler.enemyAttack(playerSelectedCreature, enemyCreature);

                if (playerSelectedCreatureCharacteristics.getVitality() <= 0) {
                    System.out.println(ConsoleColors.RED + "--- GAME OVER - VOCÊ FOI DERROTADO ---");
                    System.exit(0);
                }
            }
        }

        System.out.println(ConsoleColors.GREEN + "\n --- PARABÉNS, VOCÊ VENCEU O JOGO! ---");
    }
}
