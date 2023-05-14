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

            System.out.println("[ " + "ALERTA" + " ] " + "INIMIGO AVISTADO!");

            enemyCreature.showCreatedCreatureMessage();

            Creature lastAttacker = creatureHandler.getFirstAttack(playerSelectedCreature, enemyCreature);

            while (true) {
                if (lastAttacker != playerSelectedCreature) {
                    creatureHandler.selectAttack(playerSelectedCreature, enemyCreature);

                    System.out.println("VIDA DO INIMIGO AGORA: " + enemyCreatureCharacteristics.getVitality() + "\n");

                    if (enemyCreatureCharacteristics.getVitality() <= 0) {
                        System.out.println("VOCÊ DERROTOU O INIMIGO!\n");
                        playerSelectedCreature.regenerateVitality();
                        ConsoleUtils.sleep(3000);
                        break;
                    }

                    lastAttacker = playerSelectedCreature;
                } else {
                    creatureHandler.enemyAttack(playerSelectedCreature, enemyCreature);

                    if (playerSelectedCreatureCharacteristics.getVitality() <= 0) {
                        System.out.println("--- GAME OVER - VOCÊ FOI DERROTADO ---");
                        System.exit(0);
                    }

                    lastAttacker = enemyCreature;
                }
            }
        }

        System.out.println("\n --- PARABÉNS, VOCÊ VENCEU O JOGO! ---");
    }
}
