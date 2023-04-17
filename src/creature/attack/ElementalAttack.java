package creature.attack;

import creature.characteristics.Characteristics;

/**
 * Ataque elemental.
 */
public class ElementalAttack extends Attack {
    public ElementalAttack(Characteristics characteristics) {
        super(characteristics);
    }

    @Override
    public int castAttack() {
        return this.characteristics.getPower() * this.characteristics.getDamage();
    }
}
