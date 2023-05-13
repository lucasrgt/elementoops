package creature;

import creature.characteristics.Characteristics;
import element.Element;
import element.Water;

public class WaterCreature extends Creature {
    private static final String NAME = "WaveNerd";
    private static final Element ELEMENT = new Water();
    private static final Characteristics CHARACTERISTICS = new Characteristics();

    public WaterCreature() {
        super(NAME, ELEMENT, CHARACTERISTICS);
    }

    @Override
    public void showCreatedCreatureMessage() {
        System.out.println(
                "\n" +
                "| Um " +  NAME + " flui graciosamente da correnteza com as seguintes características:"
        );
        super.getCreatedCreatureCharacteristicsMessage();
    }

    @Override
    public Creature[] getEnemiesCreatures() {
        return new Creature[]{new FireCreature(), new AirCreature(), new EarthCreature()};
    }
}
