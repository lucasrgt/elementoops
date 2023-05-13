package creature;

import creature.characteristics.Characteristics;
import element.Earth;
import element.Element;

public class EarthCreature extends Creature {
    private static final String NAME = "StoneDev";
    private static final Element ELEMENT = new Earth();
    private static final Characteristics CHARACTERISTICS = new Characteristics();
    public EarthCreature() {
        super(NAME, ELEMENT, CHARACTERISTICS);
    }

    @Override
    public void showCreatedCreatureMessage() {
        System.out.println(
                "\n" +
                "| Um " +  NAME + " brota do solo com as seguintes características:"
        );
        super.getCreatedCreatureCharacteristicsMessage();
    }

    @Override
    public Creature[] getEnemiesCreatures() {
        return new Creature[]{new WaterCreature(), new FireCreature(), new AirCreature()};
    }
}
