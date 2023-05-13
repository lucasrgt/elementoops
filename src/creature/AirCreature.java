package creature;

import creature.characteristics.Characteristics;
import element.Air;
import element.Element;

public class AirCreature extends Creature {
    private static final String NAME = "BreezeHacker";
    private static final Element ELEMENT = new Air();
    private static final Characteristics CHARACTERISTICS = new Characteristics();
    public AirCreature() {
        super(NAME, ELEMENT, CHARACTERISTICS);
    }

    @Override
    public void showCreatedCreatureMessage() {
        System.out.println(
                "\n" +
                "| Um " +  NAME + " nasce de uma brisa suave com as seguintes características:"
        );
        super.getCreatedCreatureCharacteristicsMessage();
    }

    @Override
    public Creature[] getEnemiesCreatures() {
        return new Creature[]{new FireCreature(), new WaterCreature(), new EarthCreature()};
    }
}
