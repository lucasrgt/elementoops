package creature;

import console.ConsoleColors;
import creature.characteristics.Characteristics;
import element.Earth;
import element.Element;
import element.Fire;

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
                "| Um " + ELEMENT.getConsoleColorCode() +  NAME + ConsoleColors.RESET + " brota do solo com as seguintes características:"
        );
        super.getCreatedCreatureCharacteristics();
    }

    @Override
    public Creature[] getEnemiesCreatures() {
        return new Creature[]{new WaterCreature(), new FireCreature(), new AirCreature()};
    }
}
