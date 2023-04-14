package creature.attack;

import creature.characteristics.Characteristics;
import element.Element;

/**
 * Ataque elemental.
 */
public class ElementalAttack extends Attack {
    private Element element;

    public ElementalAttack(Characteristics characteristics, Element element) {
        super(characteristics);
        this.element = element;
    }

    @Override
    public int castAttack() {
        return this.characteristics.getPower() * this.characteristics.getDamage();
    }
}
