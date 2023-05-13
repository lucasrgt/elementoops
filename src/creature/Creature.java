package creature;

import creature.attack.ElementalAttack;
import creature.attack.PhysicalAttack;
import creature.characteristics.Characteristics;
import element.Element;

/**
 * Modelo de classe para as criaturas elementais.
 */
public abstract class Creature {
    private final String name;
    private final Element element;
    private Characteristics characteristics;

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
     * Recebe um ataque físico e reduz a vitalidade.
     */
    public void receivePhysicalDamage(Creature enemyCreature) {
        int enemyAttackDamage = new PhysicalAttack(enemyCreature.getCharacteristics()).castAttack();

        System.out.println("\n" +
                "| " + enemyCreature.getName() + " REALIZA UM ATAQUE FÍSICO!\n" +
                "| " + "Dano bruto: " + enemyAttackDamage + " ( PDR x ATQ )" +
                "\n");

        int receivedDamage = enemyAttackDamage / this.characteristics.getDefense();

        System.out.println("DANO TOTAL DO ATAQUE: " + receivedDamage + "\n");

        this.characteristics.setVitality(this.characteristics.getVitality() - receivedDamage);
    }

    /**
     * Recebimento de um ataque elemental e reduz a vitalidade da criatura com defesa baseada no fator elemental.
     */
    public void receiveElementalDamage(Creature enemyCreature) {
        Element enemyElement = enemyCreature.getElement();

        int enemyAttackDamage = new ElementalAttack(enemyCreature.getCharacteristics()).castAttack();

        System.out.println("\n" +
                "| " + enemyCreature.getName() + " REALIZA UM ATAQUE ELEMENTAL!\n" +
                "| " + "Elemento: " + enemyElement.getPortugueseName() +
                "\n" +
                "| " + "Dano bruto: " + enemyAttackDamage + " ( PDR x ATQ )" +
                "\n" +
                "| " + "Ataque defendido com fator: " + this.element.getResistanceFactor(enemyElement) + " ( " + this.element.getPortugueseName() + " )" +
                "\n");

        int receivedDamage = (int) Math.round(enemyAttackDamage / (this.characteristics.getDefense() * this.element.getResistanceFactor(enemyElement)));

        System.out.println("DANO TOTAL RECEBIDO: " + receivedDamage + "\n");

        this.characteristics.setVitality(this.characteristics.getVitality() - receivedDamage);
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

    public void setCharacteristics(Characteristics characteristics) {
        this.characteristics = characteristics;
    }


}
