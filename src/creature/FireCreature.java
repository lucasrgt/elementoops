package creature;

import creature.characteristics.Characteristics;
import element.Element;
import element.Fire;

public class FireCreature extends Creature {
    private static final String NAME = "BurnCoder";
    private static final Element ELEMENT = new Fire();
    private static final Characteristics CHARACTERISTICS = new Characteristics();

    public FireCreature() {
        super(NAME, ELEMENT, CHARACTERISTICS);
    }

    @Override
    public void showCreatedCreatureMessage() {
        System.out.println(
                "\n" +
                "| Um " +  NAME +  " irrompe em uma explosão vulcânica com as seguintes características:"
        );
        super.getCreatedCreatureCharacteristicsMessage();
    }

    @Override
    public Creature[] getEnemiesCreatures() {
        return new Creature[]{new AirCreature(), new EarthCreature(), new WaterCreature()};
    }
}
