package creature.characteristics;


/**
 * Características de uma criatura
 */
public class Characteristics {
    private final int power;
    private final int damage;
    private final int defense;
    private final int speed;
    private int vitality;
    private final int initialVitality;

    public Characteristics() {
        this.power = CharacteristicRandomizer.getRandomCharacteristicNumber(10, 30);
        this.damage = CharacteristicRandomizer.getRandomCharacteristicNumber(5, 15);
        this.defense = CharacteristicRandomizer.getRandomCharacteristicNumber(5, 15);
        this.speed = CharacteristicRandomizer.getRandomCharacteristicNumber(1, 10);
        this.vitality = CharacteristicRandomizer.getRandomCharacteristicNumber(200, 400);
        this.initialVitality = vitality;
    }

    public int getPower() {
        return this.power;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getVitality() {
        return this.vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getInitialVitality() {
        return initialVitality;
    }
}
