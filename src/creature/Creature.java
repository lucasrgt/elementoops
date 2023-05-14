package creature;

import creature.characteristics.Characteristics;
import element.Element;

/**
 * Modelo de classe para as criaturas elementais.
 */
public abstract class Creature {
    private final String name;
    private final Element element;
    private final Characteristics characteristics;

    public Creature(String name, Element element, Characteristics characteristics) {
        this.name = name;
        this.element = element;
        this.characteristics = characteristics;
    }

    /**
     * Criação de uma mensagem com as características da criatura.
     */
    public abstract void showCreatedCreatureMessage();

    /**
     * Retorna uma lista de criaturas inimigas para combater baseado no elemento da criatura do jogador.
     *
     * @return Creature[]
     */
    public abstract Creature[] getEnemiesCreatures();

    /**
     * Modelo padrão de mensagem de características de uma criatura, seja ela do jogador ou inimiga.
     */
    protected void getCreatedCreatureCharacteristicsMessage() {
        System.out.println(
                "| PODER (PDR): " + this.characteristics.getPower() +
                        "\n" +
                        "| ATAQUE (ATQ): " + this.characteristics.getDamage() +
                        "\n" +
                        "| DEFESA (DEF): " + this.characteristics.getDefense() +
                        "\n" +
                        "| VELOCIDADE (VEL): " + this.characteristics.getSpeed() +
                        "\n" +
                        "| PONTOS DE VIDA (PVD): " + this.characteristics.getVitality() +
                        "\n"
        );
    }

    /**
     * Conjuração de um ataque físico.
     */
    public void castPhysicalAttack(Creature enemyCreature) {
        int damage = this.characteristics.getDamage() * this.characteristics.getPower();

        System.out.println("\n" +
                "| " + getName() + " REALIZA UM ATAQUE FÍSICO!\n" +
                "| " + "Dano bruto: " + damage + " ( PDR x ATQ )" +
                "\n");

        int totalDamage = damage / enemyCreature.characteristics.getDefense();

        System.out.println("DANO TOTAL DO ATAQUE: " + totalDamage + "\n");

        enemyCreature.getCharacteristics().setVitality(enemyCreature.characteristics.getVitality() - totalDamage);

    }

    /**
     * Conjuração de um ataque elemental baseado no fator de defesa elemental.
     */

    public void castElementalAttack(Creature enemyCreature) {
        int damage = this.characteristics.getDamage() * this.characteristics.getPower();

        System.out.println("\n" +
                "| " + getName() + " REALIZA UM ATAQUE ELEMENTAL!\n" +
                "| " + "Elemento: " + getElement().getPortugueseName() +
                "\n" +
                "| " + "Dano bruto: " + damage + " ( PDR x ATQ )" +
                "\n" +
                "| " + "Ataque defendido com fator: " + enemyCreature.element.getResistanceFactor(this.getElement()) +
                " ( " + this.element.getPortugueseName() + " )" +
                "\n");

        int totalDamage = (int) Math.round(damage / (enemyCreature.characteristics.getDefense() * enemyCreature.element.getResistanceFactor(this.getElement())));

        System.out.println("DANO TOTAL DO ATAQUE: " + totalDamage + "\n");

        enemyCreature.getCharacteristics().setVitality(enemyCreature.characteristics.getVitality() - totalDamage);
    }


    /**
     * Regenera a vida da criatura ao valor inicial.
     */
    public void regenerateVitality() {
        this.characteristics.setVitality(this.characteristics.getInitialVitality());
        System.out.println("Sua criatura descansou e se recuperou do combate!");
        System.out.println("\nSUA VIDA AGORA: " + this.characteristics.getVitality());
    }

    public String getName() {
        return name;
    }

    public Element getElement() {
        return element;
    }

    public Characteristics getCharacteristics() {
        return characteristics;
    }
}
